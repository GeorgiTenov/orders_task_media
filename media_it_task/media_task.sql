-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Feb 10, 2022 at 08:09 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `media_task`
--

-- --------------------------------------------------------

--
-- Table structure for table `dishes`
--

CREATE TABLE `dishes` (
  `dish_id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(60) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `restaurant_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dishes`
--

INSERT INTO `dishes` (`dish_id`, `name`, `description`, `url`, `restaurant_id`, `order_id`) VALUES
(6, 'dish-sweet', 'desc', 'url..', 2, 2),
(7, 'dish-sweet', 'desc', 'url..', 2, 2),
(8, 'dish-sweet', 'desc', 'url..', 2, 2),
(10, 'dish-sweet', 'desc', 'url..', 2, 2),
(11, 'dish-sweet', 'desc', 'url..', 2, 2),
(12, 'dish-sweet', 'desc', 'url..', 2, 2),
(13, 'dish-sweet', 'desc', 'url..', 2, 2),
(14, 'dish-sweet', 'desc', 'url..', 2, 2),
(15, 'dish-sweet', 'desc', 'url..', 2, 2),
(16, 'dish-sweet', 'desc', 'url..', 2, 2),
(17, 'dish-sweet', 'desc', 'url..', 2, 2),
(18, 'New_dish_name', 'desc', 'url..', 2, 2),
(19, 'egg', 'desc', 'url..', 2, 2),
(20, 'egg', 'desc', 'url..', 2, 2),
(21, 'egg', 'desc', 'url..', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `user_email` varchar(70) DEFAULT NULL,
  `order_status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `user_email`, `order_status`) VALUES
(2, 'shadow@abv.bg', 'Not'),
(3, 'support@gmail.bg', 'Pending'),
(4, 'support@gmail.bg', 'Pending'),
(5, 'support@gmail.bg', 'Pending'),
(6, 'support@gmail.bg', 'Pending'),
(7, 'support@gmail.bg', 'Pending'),
(8, 'support@gmail.bg', 'Pending'),
(9, 'supporddt@gmail.bg', 'Pending'),
(10, 'supporddt@gmail.bg', 'Pending'),
(11, 'suppordd!t@gmail.bg', 'Pending'),
(12, 'suppordd!t@gmail.bg', 'Pending'),
(13, 'suppordd!t@gmail.bg', 'Pending'),
(14, 'suppordd!t@gmail.bg', 'Pending'),
(15, 'suppordd!t@gmail.bg', 'Pending'),
(16, 'suppordd!t@gmail.bg', 'Pending'),
(17, 'suppordd!t@gmail.bg', 'Pending'),
(18, 'suppordd!t@gmail.bg', 'Pending'),
(19, 'suppordd!t@gmail.bg', 'Pending'),
(20, 'suppordd!t@gmail.bg', 'Pending'),
(25, 'mediaSupport@gmail.bg', 'Pending'),
(26, 'mediaSupport@gmail.bg', 'Pending'),
(27, 'mediaSupport@gmail.bg', 'Pending'),
(28, 'mediaSupport@gmail.bg', 'Pending'),
(29, 'mediaSupport@gmail.bg', 'Pending'),
(30, 'mediaSupport@gmail.bg', 'Pending'),
(31, 'mediaSupport@gmail.bg', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `restaurant_id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `url` varchar(40) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`restaurant_id`, `name`, `description`, `url`, `address`) VALUES
(2, 'Bochova', 'Super', 'http://super.com', 'some'),
(3, 'Indie', 'Super', 'http://super.com', 'some'),
(4, 'Bochova', 'Super', 'http://super.com', 'some'),
(5, 'Restaurant C', 'desc', 'website!', 'address'),
(6, 'Restaurant C', 'desc', 'website!', 'address'),
(7, 'Restaurant C', 'desc', 'website!', 'address'),
(8, 'Restaurant C', 'desc', 'website!', 'address'),
(9, 'Restaurant C', 'desc', 'website!', 'address'),
(10, 'Restaurant C', 'desc', 'website!', 'address'),
(11, 'Restaurant C', 'desc', 'website!', 'address'),
(12, 'Restaurant C', 'desc', 'website!', 'address'),
(13, 'Restaurant C', 'desc', 'website!', 'address'),
(14, 'Restaurant C', 'desc', 'website!', 'address'),
(15, 'Restaurant C', 'desc', 'website!', 'address'),
(16, 'Restaurant C', 'desc', 'website!', 'address'),
(17, 'Restaurant C', 'desc', 'website!', 'address'),
(18, 'Restaurant C', 'desc', 'website!', 'address'),
(19, 'Restaurant C', 'desc', 'website!', 'address'),
(20, 'Restaurant C', 'desc', 'website!', 'address'),
(21, 'Restaurant C', 'desc', 'website!', 'address'),
(22, 'Restaurant C', 'desc', 'website!', 'address'),
(23, 'Restaurant C', 'desc', 'website!', 'address'),
(24, 'Restaurant C', 'desc', 'website!', 'address'),
(25, 'Restaurant C', 'desc', 'website!', 'address'),
(26, 'Scorp X', 'desc', 'website!', 'address'),
(27, 'Scorp X', 'desc', 'website!', 'address'),
(28, 'Scorp X', 'desc', 'website!', 'address'),
(29, 'Scorp X', 'desc', 'website!', 'address'),
(30, 'Scorp X', 'desc', 'website!', 'address'),
(31, 'Scorp X', 'desc', 'website!', 'address'),
(32, 'Scorp X', 'desc', 'website!', 'address'),
(33, 'Scorp X', 'desc', 'website!', 'address'),
(34, 'Scorp X', 'desc', 'website!', 'address'),
(35, 'Scorp X', 'desc', 'website!', 'address'),
(36, 'Scorp X', 'desc', 'website!', 'address'),
(37, 'Scorp A', 'desc', 'website!', 'address');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `email` varchar(70) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `password`, `first_name`, `last_name`, `address`, `telephone`) VALUES
('georgi@email.com', 'asdqwe', 'gorj', 'smarty', 'trakiya', '0897213874'),
('HAHO@abv.bg', 'hadhs', 'asdwe', 'stupid', 'ore', '0891232133'),
('low@abv.bg', 'test23', 'hello', 'area51', 'Stone river', '0887661244'),
('mediaSupport@gmail.bg', 'test23', 'new_name', 'area51', 'Stone river', '0887661244'),
('shadow@abv.bg', 'stupid', 'haho12', 'area51', 'Stone river', '0887661244'),
('suppordd!t@gmail.bg', 'test23', 'hello', 'area51', 'Stone river', '0887661244'),
('supporddt@gmail.bg', 'test23', 'hello', 'area51', 'Stone river', '0887661244'),
('support@gmail.bg', 'test23', 'hello', 'area51', 'Stone river', '0887661244');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dishes`
--
ALTER TABLE `dishes`
  ADD PRIMARY KEY (`dish_id`),
  ADD KEY `dishes_ibfk_1` (`restaurant_id`),
  ADD KEY `dishes_ibfk_2` (`order_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `orders_ibfk_1` (`user_email`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`restaurant_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dishes`
--
ALTER TABLE `dishes`
  MODIFY `dish_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `restaurant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dishes`
--
ALTER TABLE `dishes`
  ADD CONSTRAINT `dishes_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_email`) REFERENCES `users` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
