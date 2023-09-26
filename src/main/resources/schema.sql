CREATE TABLE BRAND_OFFER (
    offer_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    brand_id BIGINT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price DECIMAL(10,2),
    priority INT,
    partnumber BIGINT
);
