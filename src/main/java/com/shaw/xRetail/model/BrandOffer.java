package com.shaw.xRetail.model;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "BRAND_OFFER")
public class BrandOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;
    private Long brandId;
    private Instant startDate;
    private Instant endDate;
    private BigDecimal price;
    private Integer priority;
    private Long partnumber;

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(Long partnumber) {
        this.partnumber = partnumber;
    }
}
