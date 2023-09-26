package com.shaw.xRetail.controller;

import com.shaw.xRetail.model.BrandOffer;
import com.shaw.xRetail.service.BrandOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/offers")
public class BrandOfferController {
    @Autowired
    private BrandOfferService service;

    @GetMapping("/{brandId}/partnumber/{partnumber}")
    public ResponseEntity<List<Map<String, Object>>> getOffers(@PathVariable Long brandId, @PathVariable Long partnumber) {
        return ResponseEntity.ok(service.findOffers(brandId, partnumber));
    }
}
