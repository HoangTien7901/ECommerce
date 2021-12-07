-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2021 at 01:03 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerce_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `banners`
--

CREATE TABLE `banners` (
  `id` int(11) NOT NULL,
  `caption` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `link` varchar(100) NOT NULL,
  `created` date NOT NULL,
  `creater_id` int(11) NOT NULL,
  `updated` date DEFAULT NULL,
  `updater_id` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `banners`
--

INSERT INTO `banners` (`id`, `caption`, `description`, `link`, `created`, `creater_id`, `updated`, `updater_id`, `status`) VALUES
(2, 'banner 1', 'des 1', 'http://localhost:9595/manager/banner/save', '2021-11-01', 1, '2021-12-02', 1, 0),
(3, 'banner 2', 'des 1', 'link 1', '2021-11-01', 1, NULL, NULL, 0),
(4, 'banner 3', 'des 1', 'link 1', '2021-11-29', 1, NULL, NULL, 0),
(5, 'banner 4', 'asdf', 'dddd', '2021-11-29', 1, NULL, NULL, 0),
(12, 'asdfasdf', 'asdfasdfasdf', 'https://adminlte.io/docs/3.1//javascript/toasts.html', '2021-12-01', 1, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `branchs`
--

CREATE TABLE `branchs` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `logo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branchs`
--

INSERT INTO `branchs` (`id`, `name`, `logo`) VALUES
(1, 'Dellxx', 'e37fd860db1b453caf0e4d20e321391c.png'),
(2, 'Apple', 'thumb1.gif'),
(3, 'Acer', 'thumb1.gif'),
(4, 'Samsung', 'thumb1.gif'),
(5, 'eidteeasddd', '16c60c2957f04dabbd671fff6067e083.png');

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created` date NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`id`, `user_id`, `created`, `status`) VALUES
(25, 10, '2021-12-06', 'done'),
(26, 10, '2021-12-06', 'done'),
(27, 10, '2021-12-06', 'done'),
(29, 10, '2021-12-06', 'done'),
(31, 10, '2021-12-06', 'done'),
(55, 10, '2021-12-07', 'pending'),
(56, 1, '2021-12-07', 'pending'),
(57, 10, '2021-12-07', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `cart_product`
--

CREATE TABLE `cart_product` (
  `id` int(11) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart_product`
--

INSERT INTO `cart_product` (`id`, `cart_id`, `product_id`, `quantity`) VALUES
(83, 25, 5, 1),
(84, 26, 7, 1),
(85, 27, 3, 1),
(86, 29, 14, 1),
(87, 31, 12, 1);

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `discount_percent` double NOT NULL,
  `status` tinyint(1) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `level` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`, `discount_percent`, `status`, `parent_id`, `level`) VALUES
(1, 'category 1', 5, 1, NULL, 1),
(2, 'category 1.1', 0, 1, 1, 2),
(3, 'Category 2', 15, 1, NULL, 1),
(4, 'category 1.2', 0, 1, 1, 2),
(5, 'Category 3', 15, 1, NULL, 1),
(6, 'Category 2.1', 15, 1, 3, 2),
(12, 'Category 2.2.1', 15, 1, 13, 3),
(13, 'Category 2.2', 15, 1, 3, 2),
(14, 'Category 2.2.2', 15, 1, 13, 3),
(15, 'Category 3.1', 15, 1, 5, 2),
(16, 'Category 3.1.1', 15, 1, 15, 3),
(17, 'Category 3.1.2', 15, 1, 15, 3),
(18, 'Category 1.1.1', 15, 1, 2, 3),
(19, 'Category 1.1.2', 15, 1, 2, 3),
(20, 'Category 1.2.1', 15, 1, 4, 3),
(21, 'Category 1.2.2', 15, 1, 4, 3),
(22, 'Category 2.1.1', 15, 1, 6, 3),
(23, 'Category 2.1.2', 15, 1, 6, 3);

-- --------------------------------------------------------

--
-- Table structure for table `chat_chanels`
--

CREATE TABLE `chat_chanels` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chat_messages`
--

CREATE TABLE `chat_messages` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  `isUser_sender` tinyint(1) NOT NULL,
  `time_sent` date NOT NULL,
  `content` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `content` varchar(500) NOT NULL,
  `rating` int(11) NOT NULL,
  `created` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE `contacts` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`id`, `name`, `email`, `phone`, `address`, `status`) VALUES
(1, 'Stupid name', 'abc@gmail.com', '01234568874', 'address', 0);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` varchar(300) NOT NULL,
  `created` date NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `user_id`, `content`, `created`, `status`) VALUES
(1, 1, 'content 1', '2021-11-01', 1),
(2, 1, 'content 2', '2021-11-01', 0),
(3, 1, 'content 3', '2021-11-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `banner_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`id`, `name`, `product_id`, `banner_id`) VALUES
(3, 'thumb1.gif', NULL, 3),
(4, 'thumb2.gif', NULL, 3),
(8, 'dc297ea1730342c983ea01ef252e93f1.png', NULL, 4),
(9, 'c7b132b0dc534d06b12d422e55dab05f.png', NULL, 4),
(11, '846bc2cfef504db8b8b368b98c1cc84f.png', NULL, 2),
(12, 'fe218129e4f74864a94d15e0c9054a12.png', NULL, 2),
(27, '9a7613b325ff4746b41cde95390b60a7.png', NULL, 12),
(29, '69f0bda5d29d42faabe119c80db7b479.png', NULL, 12),
(30, '0898bc631e1542fb8d8d1e0a63144905.png', NULL, 12),
(31, '525ddf7e5d24415f9d6c8a8a9f23cb14.png', NULL, 12);

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `content` varchar(200) NOT NULL,
  `created` date NOT NULL,
  `is_read` tinyint(1) NOT NULL,
  `is_all_user` tinyint(1) NOT NULL DEFAULT 0,
  `is_all_store` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notifications`
--

INSERT INTO `notifications` (`id`, `user_id`, `store_id`, `content`, `created`, `is_read`, `is_all_user`, `is_all_store`) VALUES
(6, 3, NULL, 'adfasdfasdfeeee', '2021-11-25', 0, 0, 0),
(7, NULL, NULL, 'new notification for all user', '2021-11-25', 0, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `avatar` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `description_detail` text NOT NULL,
  `original_price` double NOT NULL,
  `sale_off_percent` double DEFAULT 0,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `inventory` int(11) NOT NULL,
  `branch_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `created` date NOT NULL,
  `updated` date DEFAULT NULL,
  `is_outstanding` tinyint(1) DEFAULT 0,
  `is_best_selling` tinyint(1) DEFAULT 0,
  `is_new` tinyint(1) DEFAULT 0,
  `store_id` int(1) NOT NULL,
  `discount_percent` double NOT NULL,
  `discount_amount` double NOT NULL,
  `rating_count` int(11) NOT NULL,
  `rating_average` double NOT NULL,
  `status` tinyint(1) NOT NULL,
  `ban_reason` text DEFAULT NULL,
  `is_locked` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `avatar`, `description`, `description_detail`, `original_price`, `sale_off_percent`, `price`, `quantity`, `inventory`, `branch_id`, `category_id`, `created`, `updated`, `is_outstanding`, `is_best_selling`, `is_new`, `store_id`, `discount_percent`, `discount_amount`, `rating_count`, `rating_average`, `status`, `ban_reason`, `is_locked`) VALUES
(1, 'Laptop', 'a57f224e7398407f9e304412d69f6b04.png', 'Laptop 1 description', 'Laptop 1 description detail', 100, 0, 100, 12, 12, 2, 18, '2021-11-18', '2021-12-07', 0, 0, 1, 1, 25, 25, 2, 4, 1, NULL, 0),
(2, 'Product 2', 'thumb1.gif', 'Product 2 description', 'Product 2 description detail', 100, 0, 70, 12, 12, 5, 18, '2021-11-18', '2021-11-19', 0, 1, 1, 1, 25, 25, 1, 5, 1, 'true', 0),
(3, 'Product 3', 'thumb1.gif', 'fffttttt', 'Product 3 description detail', 100, 0, 55, 11, 12, 1, 18, '2021-11-18', '2021-11-30', 1, 0, 1, 1, 25, 25, 3, 4, 1, NULL, 0),
(4, 'Product 4', 'thumb1.gif', 'Product 4 description', 'Product 4 description detail', 100, 0, 40, 12, 12, 1, 18, '2021-11-18', '2021-11-27', 0, 0, 1, 1, 25, 25, 3, 3, 1, '', 0),
(5, 'Product 5', 'thumb1.gif', 'Product 5 description', 'Product 5 description detail', 100, 0, 80, 11, 12, 1, 18, '2021-11-01', '2021-11-18', 1, 0, 1, 1, 25, 25, 2, 1, 1, '', 0),
(7, 'Product 6', 'thumb1.gif', 'Product 6 description', 'Product 6 description detail', 100, 0, 25, 9, 12, 1, 18, '2021-11-18', '2021-11-18', 1, 0, 1, 1, 25, 25, 1, 5, 1, '', 0),
(10, 'Laptop 2', 'a57f224e7398407f9e304412d69f6b04.png', 'Laptop 2 description', 'Laptop 2 description detail', 100, 0, 60, 12, 12, 2, 18, '2021-11-18', '2021-12-07', 0, 0, 1, 1, 25, 25, 2, 4, 1, NULL, 0),
(11, 'Product 7', 'thumb1.gif', '', 'Product 7 description detail', 100, 0, 70, 12, 12, 5, 18, '2021-11-18', '2021-11-19', 0, 1, 1, 1, 25, 25, 1, 5, 1, 'true', 0),
(12, 'Product 8', 'thumb1.gif', 'fffttttt', 'Product 8 description detail', 100, 0, 55, 11, 12, 1, 18, '2021-11-18', '2021-11-30', 1, 0, 1, 1, 25, 25, 3, 4, 1, NULL, 0),
(13, 'Product 11', 'thumb1.gif', 'Product 11 description', 'Product 11 description detail', 100, 0, 40, 12, 12, 1, 18, '2021-11-18', '2021-11-27', 0, 0, 1, 1, 25, 25, 3, 3, 1, '', 0),
(14, 'Product 9', 'thumb1.gif', 'Product 9 description', 'Product 9 description detail', 100, 0, 80, 11, 12, 1, 18, '2021-11-01', '2021-11-18', 1, 0, 1, 1, 25, 25, 2, 1, 1, '', 0),
(15, 'Product 10', 'thumb1.gif', 'Product 10 description', 'Product 10 description detail', 100, 0, 25, 12, 12, 1, 18, '2021-11-18', '2021-11-18', 1, 0, 1, 1, 25, 25, 1, 5, 1, '', 0),
(16, 'dgsfghsfg', 'defaultPreviewImg.png', 'afasdfasdf', 'asdfasdfasdf', 15, 0, 15, 0, 0, 1, 1, '2021-12-07', '2021-12-07', 0, 0, 1, 1, 0, 0, 0, 0, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`, `status`) VALUES
(1, 'ROLE_USER', 1),
(2, 'ROLE_ADMIN', 1);

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  `original_price` double NOT NULL,
  `price` double NOT NULL,
  `duration` int(11) NOT NULL,
  `created` date NOT NULL,
  `created_id` int(11) NOT NULL,
  `updated` date DEFAULT NULL,
  `updated_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `name`, `description`, `original_price`, `price`, `duration`, `created`, `created_id`, `updated`, `updated_id`) VALUES
(1, 'service 1', 'description 1', 1000, 1000, 5, '2021-11-01', 1, NULL, NULL),
(2, 'service 2', 'description 2', 1500, 1400, 10, '2021-11-01', 1, NULL, NULL),
(3, 'service 3', 'description 3', 2500, 2000, 15, '2021-11-01', 1, NULL, NULL),
(5, 'service 4', 'description 4', 999, 1111, 2, '2021-11-29', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `stores`
--

CREATE TABLE `stores` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  `logo` varchar(200) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created` date NOT NULL,
  `expiry` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `ban_term` date DEFAULT NULL,
  `paypal_account` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stores`
--

INSERT INTO `stores` (`id`, `name`, `phone`, `email`, `address`, `logo`, `user_id`, `created`, `expiry`, `updated`, `status`, `ban_term`, `paypal_account`) VALUES
(1, 'Store 1', '0347557353', 'hoangbichht@gmail.com', '4/1 street 10, Thu Duc City', '4d464fee7fa247c88c8e2c25c1de3a70.png', 5, '2021-11-18', '2021-11-30', '2021-12-04', 1, NULL, '');

-- --------------------------------------------------------

--
-- Table structure for table `store_services`
--

CREATE TABLE `store_services` (
  `store_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `created` date NOT NULL,
  `duration` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `system`
--

CREATE TABLE `system` (
  `id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `banner_img_amount` int(11) NOT NULL,
  `max_banner_photo_size` int(11) NOT NULL,
  `default_ban_email_content` text NOT NULL,
  `default_ban_email_subject` varchar(200) NOT NULL,
  `default_password_email_content` text NOT NULL,
  `default_password_email_subject` text NOT NULL,
  `paypal_account` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `email_password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `system`
--

INSERT INTO `system` (`id`, `title`, `banner_img_amount`, `max_banner_photo_size`, `default_ban_email_content`, `default_ban_email_subject`, `default_password_email_content`, `default_password_email_subject`, `paypal_account`, `email`, `email_password`) VALUES
(1, 'One Vendor', 5, 2, '<b>Default ban email content</b>', 'Default ban email subject', '<b>Default password email content</b>', 'Default password email subject', 'sb-89nsw5547823@business.example.com', 'hoangbichht@gmail.com', 'LazyWorld@1949');

-- --------------------------------------------------------

--
-- Table structure for table `tags`
--

CREATE TABLE `tags` (
  `id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tags`
--

INSERT INTO `tags` (`id`, `name`, `status`) VALUES
(1, 'tag 1', 1),
(2, 'tag 2', 1),
(3, 'tag 3', 1),
(4, 'tag 4', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tag_products`
--

CREATE TABLE `tag_products` (
  `id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `id` int(11) NOT NULL,
  `price` double NOT NULL,
  `service_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT 1,
  `quantity` int(11) NOT NULL,
  `tax` double DEFAULT 0,
  `total` double NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `transaction_detail_id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `cancel_reason` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`id`, `price`, `service_id`, `store_id`, `quantity`, `tax`, `total`, `note`, `product_id`, `transaction_detail_id`, `status`, `cancel_reason`) VALUES
(7, 500, NULL, 1, 1, 100, 600, NULL, 1, 1, 'cancel', 'Cancelled by store - Write cancel reason here.'),
(8, 600, NULL, 1, 1, 100, 700, NULL, 5, 1, 'done', ''),
(9, 500, NULL, 1, 1, 100, 600, NULL, 2, 1, 'cancel', NULL),
(10, 600, NULL, 1, 1, 100, 700, NULL, 1, 1, 'done', NULL),
(11, 600, NULL, 1, 1, 100, 700, NULL, 5, 1, 'done', NULL),
(12, 500, NULL, 1, 1, 100, 600, NULL, 3, 1, 'done', NULL),
(13, 25, NULL, 1, 1, 0, 25, NULL, 7, 7, 'pending', NULL),
(14, 80, NULL, 1, 1, 0, 80, NULL, 5, 8, 'pending', NULL),
(15, 25, NULL, 1, 1, 0, 25, NULL, 7, 9, 'pending', NULL),
(16, 55, NULL, 1, 1, 0, 55, NULL, 3, 10, 'pending', NULL),
(17, 80, NULL, 1, 1, 0, 80, NULL, 14, 11, 'pending', NULL),
(18, 55, NULL, 1, 1, 0, 55, NULL, 12, 12, 'pending', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_details`
--

CREATE TABLE `transaction_details` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT 'Transaciton details',
  `payment` varchar(100) DEFAULT 'paypal',
  `address` varchar(500) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `discount` double DEFAULT 0,
  `vat` double DEFAULT 0,
  `created` date NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction_details`
--

INSERT INTO `transaction_details` (`id`, `name`, `payment`, `address`, `quantity`, `discount`, `vat`, `created`, `user_id`) VALUES
(1, 'transaction detail 1', 'paypal', 'address 1', 2, 0, 0, '2021-11-01', 3),
(2, 'Transaction details Mon Dec 06 18:30:39 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10),
(3, 'Transaction details Mon Dec 06 18:31:16 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10),
(4, 'Transaction details Mon Dec 06 18:33:27 ICT 2021', NULL, 'tmp address', 2, 0, 0, '2021-12-06', 10),
(5, 'Transaction details Mon Dec 06 18:36:08 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10),
(6, 'Transaction details Mon Dec 06 18:40:56 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10),
(7, 'Transaction details Mon Dec 06 18:46:49 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10),
(8, 'Transaction details Mon Dec 06 18:50:06 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10),
(9, 'Transaction details Mon Dec 06 18:52:47 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10),
(10, 'Transaction details Mon Dec 06 18:59:26 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10),
(11, 'Transaction details Mon Dec 06 19:00:40 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10),
(12, 'Transaction details Mon Dec 06 19:02:34 ICT 2021', NULL, 'tmp address', 1, 0, 0, '2021-12-06', 10);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `birthday` date NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `created` date NOT NULL,
  `updated` date DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `role_id` int(11) NOT NULL,
  `ban_term` date DEFAULT NULL,
  `address` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `fullname`, `birthday`, `phone`, `email`, `created`, `updated`, `status`, `role_id`, `ban_term`, `address`) VALUES
(1, 'admin', '$2a$10$P9nDmcsnHlL.SLJ54aRkve3bYuK4NvAjMXRVSvcFkGB.7njNj2KFy', 'admin', '2021-11-10', '123', 'hoangbichht@gmail.com', '2021-11-01', '2021-12-02', 0, 2, NULL, ''),
(3, 'username1Ok', '123', 'user 1', '2001-07-12', '123225544688', 'hoangbichht@gmail.com', '2021-11-01', '2021-12-02', 1, 1, NULL, ''),
(4, 'user2', '123', 'user 2', '2021-11-01', '123', 'hoangbichht@gmail.com', '2021-11-01', '2021-12-01', 0, 1, '2022-01-01', ''),
(5, 'user3', '123', 'user 3', '2021-11-01', '123', 'hoangbichht@gmail.com', '2021-11-01', '2021-12-01', 1, 1, NULL, ''),
(6, 'user4', '123', 'user 4', '2021-11-01', '123', 'hoangbichht@gmail.com', '2021-11-01', '2021-11-27', 1, 1, NULL, ''),
(10, 'usernamey', '$2a$10$x5ZqSEQQha5NNe.ty5RuBOYgSEVGP1cNkwJEXPoAYQ4lxDWnPXWie', 'full name 1', '2001-01-26', '0123456789', 'hoangbichht@gmail.com', '2021-12-03', '2021-12-07', 1, 1, NULL, 'address 10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `banners`
--
ALTER TABLE `banners`
  ADD PRIMARY KEY (`id`),
  ADD KEY `creater_id` (`creater_id`),
  ADD KEY `updater_id` (`updater_id`);

--
-- Indexes for table `branchs`
--
ALTER TABLE `branchs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `cart_product`
--
ALTER TABLE `cart_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cart_id` (`cart_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `parent_id` (`parent_id`);

--
-- Indexes for table `chat_chanels`
--
ALTER TABLE `chat_chanels`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `store_id` (`store_id`);

--
-- Indexes for table `chat_messages`
--
ALTER TABLE `chat_messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `author_user_id` (`user_id`,`store_id`),
  ADD KEY `store_id` (`store_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`,`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`,`banner_id`),
  ADD KEY `banner_id` (`banner_id`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`,`store_id`),
  ADD KEY `store_id` (`store_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `store_id` (`store_id`),
  ADD KEY `branch_id` (`branch_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `created_id` (`created_id`,`updated_id`),
  ADD KEY `updated_id` (`updated_id`);

--
-- Indexes for table `stores`
--
ALTER TABLE `stores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `store_services`
--
ALTER TABLE `store_services`
  ADD KEY `store_id` (`store_id`,`service_id`),
  ADD KEY `store_id_2` (`store_id`,`service_id`),
  ADD KEY `service_id` (`service_id`);

--
-- Indexes for table `system`
--
ALTER TABLE `system`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tag_products`
--
ALTER TABLE `tag_products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tag_id` (`tag_id`,`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `service_id` (`service_id`),
  ADD KEY `store_id` (`store_id`),
  ADD KEY `transaction_detail_id` (`transaction_detail_id`);

--
-- Indexes for table `transaction_details`
--
ALTER TABLE `transaction_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `banners`
--
ALTER TABLE `banners`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `branchs`
--
ALTER TABLE `branchs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `carts`
--
ALTER TABLE `carts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `cart_product`
--
ALTER TABLE `cart_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `chat_chanels`
--
ALTER TABLE `chat_chanels`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `chat_messages`
--
ALTER TABLE `chat_messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `stores`
--
ALTER TABLE `stores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `system`
--
ALTER TABLE `system`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tags`
--
ALTER TABLE `tags`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tag_products`
--
ALTER TABLE `tag_products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `transaction_details`
--
ALTER TABLE `transaction_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `banners`
--
ALTER TABLE `banners`
  ADD CONSTRAINT `banners_ibfk_1` FOREIGN KEY (`creater_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `banners_ibfk_2` FOREIGN KEY (`updater_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `carts_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `cart_product`
--
ALTER TABLE `cart_product`
  ADD CONSTRAINT `cart_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `cart_product_ibfk_2` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`);

--
-- Constraints for table `categories`
--
ALTER TABLE `categories`
  ADD CONSTRAINT `categories_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `categories` (`id`);

--
-- Constraints for table `chat_chanels`
--
ALTER TABLE `chat_chanels`
  ADD CONSTRAINT `chat_chanels_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `chat_chanels_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`);

--
-- Constraints for table `chat_messages`
--
ALTER TABLE `chat_messages`
  ADD CONSTRAINT `chat_messages_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `chat_messages_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`);

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `comments_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`banner_id`) REFERENCES `banners` (`id`),
  ADD CONSTRAINT `images_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`),
  ADD CONSTRAINT `notifications_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`branch_id`) REFERENCES `branchs` (`id`),
  ADD CONSTRAINT `products_ibfk_3` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

--
-- Constraints for table `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `services_ibfk_1` FOREIGN KEY (`created_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `services_ibfk_2` FOREIGN KEY (`updated_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `stores`
--
ALTER TABLE `stores`
  ADD CONSTRAINT `stores_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `store_services`
--
ALTER TABLE `store_services`
  ADD CONSTRAINT `store_services_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`),
  ADD CONSTRAINT `store_services_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`);

--
-- Constraints for table `tag_products`
--
ALTER TABLE `tag_products`
  ADD CONSTRAINT `tag_products_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`),
  ADD CONSTRAINT `tag_products_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`),
  ADD CONSTRAINT `transactions_ibfk_3` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`),
  ADD CONSTRAINT `transactions_ibfk_4` FOREIGN KEY (`transaction_detail_id`) REFERENCES `transaction_details` (`id`),
  ADD CONSTRAINT `transactions_ibfk_5` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `transaction_details`
--
ALTER TABLE `transaction_details`
  ADD CONSTRAINT `transaction_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
