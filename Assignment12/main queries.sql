create database pizza;

-- working on pizza info
insert into pizza_info (pizza_id, pizza_name, pizza_price)
values (1, 'Pepperoni & Cheese', 7.99);customer_info

insert into pizza_info (pizza_id, pizza_name, pizza_price)
values (2, 'Vegetarian', 9.99);

insert into pizza_info (pizza_id, pizza_name, pizza_price)
values (3, 'Meat Lovers', 14.99);

insert into pizza_info (pizza_id, pizza_name, pizza_price)
values (4, 'Hawaiian', 12.99);

update pizza_info
set pizza_price = 7.99
where pizza_id = 1;

update pizza_info
set pizza_price = 9.99
where pizza_id = 2;

update pizza_info
set pizza_price = 14.99
where pizza_id = 3;

update pizza_info
set pizza_price = 12.99
where pizza_id = 4;

select * from pizza_info;

-- working on creating join tables
CREATE TABLE `orders_to_pizza` (
    `orderDetail_id` int NOT NULL,
    `pizza_id` int NOT NULL,
	FOREIGN KEY (orderDetail_id) REFERENCES `orderdetails` (orderDetail_id),
    FOREIGN KEY (pizza_id) REFERENCES `pizza_info` (pizza_id)
);

CREATE TABLE `customer_to_orders` (
	`customer_id` int NOT NULL,
    `orderDetail_id` int NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES `customer_info` (customer_id),
	FOREIGN KEY (orderDetail_id) REFERENCES `orderdetails` (orderDetail_id)
);
-- stuff
insert into orders_to_pizza (orderDetail_id, pizza_id)
values (1, 1);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (1, 3);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (2, 2);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (2, 3);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (3, 3);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (3, 4);

select * from orders;

select order_name, date_time , sum(num_peperoni * (select pizza_price from pizza_info where pizza_id = 1) + num_vegetarian * (select pizza_price from pizza_info where pizza_id = 2)+ num_meat * (select pizza_price from pizza_info where pizza_id = 3)+ num_hawaiian * (select pizza_price from pizza_info where pizza_id = 4)) as total 
from orders
join pizza_info on orders.order_number = pizza_info.pizza_id
group by pizza_id;

select pizza_price
from orders
right join pizza_info on orders.order_number = pizza_info.pizza_id
group by pizza_id;

SELECT * from pizza_info;

CREATE TABLE `orderDetail` (
    `orderDetail_id` int NOT NULL,
    `quantity` int NULL,
    `pizza_id` int NOT NULL,
    FOREIGN KEY (pizza_id) REFERENCES `pizza_info` (pizza_id)
);
-- inserting information
insert into orderdetails (orderDetail_id, order_name, date_time, order_id, quantity, pizza_id)
values (1, 'Trevor Page', '2014-09-10 09:47:00', 1, 1, 1);

insert into orderdetails (orderDetail_id, order_name, date_time, order_id, quantity, pizza_id)
values (2, 'Trevor Page', '2014-09-10 09:47:00', 1, 1, 3);

insert into orderdetails (orderDetail_id, order_name, date_time, order_id, quantity, pizza_id)
values (3, 'John Doe', '2014-09-10 13:20:00', 2, 1, 2);

insert into orderdetails (orderDetail_id, order_name, date_time, order_id, quantity, pizza_id)
values (4, 'John Doe', '2014-09-10 13:20:00', 2, 2, 3);

insert into orderdetails (orderDetail_id, order_name, date_time, order_id, quantity, pizza_id)
values (5, 'Trevor Page', '2014-09-10 09:47:00', 3, 1, 3);

insert into orderdetails (orderDetail_id, order_name, date_time, order_id, quantity, pizza_id)
values (6, 'Trevor Page', '2014-09-10 09:47:00', 3, 1, 4);


insert into customer_to_orders (customer_id, orderDetail_id)
values (1, 1);

insert into customer_to_orders (customer_id, orderDetail_id)
values (1, 2);

insert into customer_to_orders (customer_id, orderDetail_id)
values (2, 3);

insert into customer_to_orders (customer_id, orderDetail_id)
values (2, 4);

insert into customer_to_orders (customer_id, orderDetail_id)
values (1, 5);

insert into customer_to_orders (customer_id, orderDetail_id)
values (1, 6);


insert into orders_to_pizza (orderDetail_id, pizza_id)
values (1, 1);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (2, 3);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (3, 2);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (4, 3);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (5, 3);

insert into orders_to_pizza (orderDetail_id, pizza_id)
values (6, 4);


--

ALTER TABLE `orderDetail` 
ADD COLUMN order_id int AFTER pizza_id;

ALTER TABLE orderDetail
ADD FOREIGN KEY (order_id) REFERENCES orders(order_number);

UPDATE orderDetail
SET order_id = 1
WHERE orderdetail_id = 1;

UPDATE orderDetail
SET order_id = 1
WHERE orderdetail_id = 2;

UPDATE orderDetail
SET order_id = 2
WHERE orderdetail_id = 3;

UPDATE orderDetail
SET order_id = 2
WHERE orderdetail_id = 4;

UPDATE orderDetail
SET order_id = 3
WHERE orderdetail_id = 5;

UPDATE orderDetail
SET order_id = 3
WHERE orderdetail_id = 6;

select * from orderdetails;

select order_name, date_time , sum(quantity * (Select pizza_price from pizza_info where orderdetails.pizza_id = pizza_info.pizza_id)) as total 
from orderdetails
left join pizza_info on orderdetails.orderDetail_id = pizza_info.pizza_id
group by order_name;

select * from orderdetails
left join pizza_info on orderdetails.orderDetail_id = pizza_info.pizza_id;

DELETE FROM orders_to_pizza WHERE orderDetail_id = 1;

INSERT INTO `orders_to_pizza` (orderDetail_id, pizza_id) VALUES (1,1);
select * from orders_to_pizza;







