create table tb_sales_order_vehicle(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
date DATE NOT NULL,
price double NOT NULL,
vehicle_id BIGINT NULL,
customer_id BIGINT NULL,
seller_id BIGINT NULL, 
FOREIGN KEY (vehicle_id) REFERENCES tb_vehicle(id),
FOREIGN KEY (customer_id) REFERENCES tb_customer(id),
FOREIGN KEY (seller_id) REFERENCES tb_seller(id)
);