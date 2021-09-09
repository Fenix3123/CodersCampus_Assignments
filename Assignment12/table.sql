CREATE TABLE `orders` (
  `order_number` int NOT NULL,
  `order_name` varchar(45) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `num_peperoni` int DEFAULT NULL,
  `num_vegetarian` int DEFAULT NULL,
  `num_meat` int DEFAULT NULL,
  `num_hawaiian` int DEFAULT NULL,
  PRIMARY KEY (`order_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orderDetails` (
  `orderDetail_id` int NOT NULL,
  `order_name` varchar(45) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `order_id` varchar(45) DEFAULT NULL,
  `pizza_id` varchar(45) DEFAULT NULL,
  `quantity` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
