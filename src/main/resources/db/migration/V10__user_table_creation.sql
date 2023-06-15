create table tb_user(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR (255) NOT NULL ,
password VARCHAR (255) NOT NULL,
role_id BIGINT NOT NULL,
foreign key (role_id) references tb_role(id)ON DELETE CASCADE
);