-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2023 at 01:55 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fees_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `ID` int(25) NOT NULL,
  `CNAME` varchar(50) DEFAULT NULL,
  `COST` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`ID`, `CNAME`, `COST`) VALUES
(1, 'Java', '5100.0'),
(2, 'Python', '5100.0'),
(3, 'Html', '4000.0'),
(4, 'Css', '4000.0');

-- --------------------------------------------------------

--
-- Table structure for table `fees_details`
--

CREATE TABLE `fees_details` (
  `reciept_no` int(11) NOT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `payment_mode` varchar(50) DEFAULT NULL,
  `roll_no` varchar(11) DEFAULT NULL,
  `cheque_no` varchar(25) DEFAULT NULL,
  `bank_name` varchar(50) DEFAULT NULL,
  `dd_no` varchar(25) DEFAULT NULL,
  `courses` varchar(100) DEFAULT NULL,
  `gstin` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `cgst` float DEFAULT NULL,
  `sgst` float DEFAULT NULL,
  `total_amount` float DEFAULT NULL,
  `total_in_words` varchar(200) DEFAULT NULL,
  `year1` int(11) DEFAULT NULL,
  `year2` int(11) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fees_details`
--

INSERT INTO `fees_details` (`reciept_no`, `student_name`, `payment_mode`, `roll_no`, `cheque_no`, `bank_name`, `dd_no`, `courses`, `gstin`, `date`, `amount`, `cgst`, `sgst`, `total_amount`, `total_in_words`, `year1`, `year2`, `remark`) VALUES
(1, 'Sonu Kumar', 'Cash', '76', '', '', '', 'Java', '22HVSJH55', '2023-03-03', 5100, 459, 459, 6018, 'Six Thousand Eighteen only', 2022, 2023, ''),
(2, 'KumarSonu', 'Cash', '77', '', '', '', 'Python', '22HVSJH55', '2023-03-03', 4900, 441, 441, 5782, 'Five Thousand Seven Hundred Eighty Two only', 2022, 2023, ''),
(3, 'Bharat raj', 'Cheque', '3', '65451', 'SBI', '', 'Python', '22HVSJH55', '2023-03-01', 5900, 531, 531, 6962, 'Six Thousand Nine Hundred Sixty Two only', 2022, 2023, ''),
(4, 'Vijoy ', 'DD', '46', '', 'SBI', '851', 'Python', '22HVSJH55', '2023-03-03', 1550, 139.5, 139.5, 1829, 'One Thousand Eight Hundred Twenty Nine only', 2022, 2023, 'nO Remarks'),
(5, 'Jaywardhan ', 'Cheque', 'Cheque', '98453', 'SBI', '', 'Java', '22HVSJH55', '2023-03-03', 5150, 463.5, 463.5, 6077, 'Six Thousand Seventy Seven only', 2022, 2023, '');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `Id` int(11) NOT NULL,
  `Firstname` varchar(30) DEFAULT NULL,
  `Lastname` varchar(30) DEFAULT NULL,
  `Username` varchar(30) DEFAULT NULL,
  `Password` varchar(15) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Contact` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`Id`, `Firstname`, `Lastname`, `Username`, `Password`, `DOB`, `Contact`) VALUES
(1, 'Sonu', 'Kumar', 'kusonu', '98745632', '2002-12-16', '7541999724');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `fees_details`
--
ALTER TABLE `fees_details`
  ADD PRIMARY KEY (`reciept_no`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `ID` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `fees_details`
--
ALTER TABLE `fees_details`
  MODIFY `reciept_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `signup`
--
ALTER TABLE `signup`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
