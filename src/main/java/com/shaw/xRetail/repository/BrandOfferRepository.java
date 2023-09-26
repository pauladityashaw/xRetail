package com.shaw.xRetail.repository;

import com.shaw.xRetail.model.BrandOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandOfferRepository extends JpaRepository<BrandOffer, Long> {
    List<BrandOffer> findByBrandIdAndPartnumberOrderByStartDate(Long brandId, Long partnumber);
}