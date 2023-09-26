package com.shaw.xRetail.service;

import com.shaw.xRetail.model.BrandOffer;
import com.shaw.xRetail.repository.BrandOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandOfferService {
    @Autowired
    private BrandOfferRepository repository;

    public List<Map<String, Object>> findOffers(Long brandId, Long partnumber) {
        List<BrandOffer> offers = repository.findByBrandIdAndPartnumberOrderByStartDate(brandId, partnumber);

        List<Map<String, Object>> result = new ArrayList<>();

        for (int i = 0; i < offers.size(); i++) {
            BrandOffer current = offers.get(i);

            if (i < offers.size() - 1) {
                BrandOffer next = offers.get(i + 1);
                if (current.getEndDate().isAfter(next.getStartDate())) {
                    if (current.getPriority() < next.getPriority()) {
                        // Split the current offer
                        BrandOffer split = new BrandOffer();
                        split.setBrandId(current.getBrandId());
                        split.setPartnumber(current.getPartnumber());
                        split.setStartDate(next.getEndDate().plusSeconds(1));
                        split.setEndDate(current.getEndDate());
                        split.setPrice(current.getPrice());
                        split.setPriority(current.getPriority());

                        current.setEndDate(next.getStartDate().minusSeconds(1));

                        if (!split.getEndDate().equals(next.getEndDate())) {
                            offers.add(i + 2, split);  // Insert after next offer
                        }
                    } else {
                        next.setStartDate(current.getEndDate().plusSeconds(1));
                    }
                }
            }

            Map<String, Object> offerData = new HashMap<>();
            offerData.put("brand_id", current.getBrandId());
            offerData.put("start_date", current.getStartDate());
            offerData.put("end_date", current.getEndDate());
            offerData.put("price", current.getPrice());

            result.add(offerData);
        }

        return result;
    }
}

