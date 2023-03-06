-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 06, 2022 lúc 07:14 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `fastsale`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `username` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `nhanvien` varchar(10) DEFAULT NULL,
  `remember` bit(1) NOT NULL,
  `donhang` bit(1) DEFAULT NULL,
  `themdonhang` bit(1) DEFAULT NULL,
  `doanhthu` bit(1) DEFAULT NULL,
  `khohang` bit(1) DEFAULT NULL,
  `danhmuc` bit(1) DEFAULT NULL,
  `thuno` bit(1) DEFAULT NULL,
  `baocao` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`username`, `password`, `nhanvien`, `remember`, `donhang`, `themdonhang`, `doanhthu`, `khohang`, `danhmuc`, `thuno`, `baocao`) VALUES
('admin', '123', 'NV001', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
('venus', 'venus', 'NV001', b'0', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
('hieu', '123', 'NV001', b'0', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
('hieuchau', '123', 'NV001', b'0', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
('h', '123', 'NV12380', b'0', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
('hieuchau25', 'venus', 'NV001', b'0', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
('nhung', '123', 'NV005', b'0', b'1', b'1', b'1', b'1', b'1', b'1', b'1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `id` varchar(10) NOT NULL,
  `nhanvientao` varchar(10) DEFAULT NULL,
  `nhanvienban` varchar(10) DEFAULT NULL,
  `khachHang` varchar(10) DEFAULT NULL,
  `ngayGio` datetime DEFAULT NULL,
  `hinhthucthanhtoan` varchar(20) DEFAULT NULL,
  `chitiethoadon` varchar(10) DEFAULT NULL,
  `tongtien` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`id`, `nhanvientao`, `nhanvienban`, `khachHang`, `ngayGio`, `hinhthucthanhtoan`, `chitiethoadon`, `tongtien`) VALUES
('HD30198', 'NV001', 'NV003', 'KH002', '2022-07-11 11:22:10', 'Nợ', 'PT34283', '3600000'),
('HD38995', 'NV001', 'NV001', 'KH001', '2022-07-21 10:47:06', 'Nợ', 'PT69971', '8748000'),
('HD43644', 'NV001', 'NV001', 'KH006', '2022-08-06 10:56:35', 'Nợ', 'PT51709', '1545000'),
('HD45412', 'NV001', 'NV001', 'KH006', '2022-07-08 22:10:28', 'Nợ', 'PT28982', '3600000'),
('HD46714', 'NV001', 'NV001', 'KH005', '2022-07-11 18:26:27', 'Nợ', 'PT56879', '7200000'),
('HD46806', 'NV001', 'NV001', 'KH48089', '2022-07-21 18:19:00', 'Nợ', 'PT89247', '2500000'),
('HD49608', 'NV001', 'NV001', 'KH001', '2022-07-08 12:23:18', 'Nợ', 'PT68987', '995000'),
('HD50458', 'NV001', 'NV008', 'KH38215', '2022-07-11 22:35:22', 'Nợ', 'PT38903', '7010000'),
('HD67728', 'NV001', 'NV004', 'KH001', '2022-07-09 21:55:27', 'Nợ', 'PT83252', '4595000'),
('HD70265', 'NV001', 'NV001', 'KH001', '2022-07-11 19:29:02', 'Nợ', 'PT40823', '8145000'),
('HD73663', 'NV001', 'NV001', 'KH002', '2022-07-11 22:29:31', 'Nợ', 'PT96372', '1250000'),
('HD81654', 'NV001', 'NV001', 'KH001', '2022-07-08 19:50:26', 'Nợ', 'PT62654', '6491000'),
('HD92749', 'NV001', 'NV001', 'KH001', '2022-07-10 10:54:17', 'Tiền mặt', 'PT26989', '1000000'),
('HD99349', 'NV001', 'NV001', 'KH006', '2022-08-06 10:58:14', 'Nợ', 'PT19118', '945000'),
('HD99957', 'NV001', 'NV001', 'KH48089', '2022-07-29 17:22:41', 'Nợ', 'PT76371', '1520000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadonchitiet`
--

CREATE TABLE `hoadonchitiet` (
  `id` varchar(10) DEFAULT NULL,
  `sanpham` varchar(10) DEFAULT NULL,
  `soluong` decimal(10,0) DEFAULT NULL,
  `tang` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadonchitiet`
--

INSERT INTO `hoadonchitiet` (`id`, `sanpham`, `soluong`, `tang`) VALUES
('PT001', 'SP001', '5', '0'),
('PT68987', 'SP007', '5', '0'),
('PT28982', 'SP008', '5', '0'),
('PT28982', 'SP008', '0', '1'),
('PT83252', 'SP007', '5', '0'),
('PT83252', 'SP007', '0', '1'),
('PT83252', 'SP008', '5', '0'),
('PT34283', 'SP008', '5', '0'),
('PT34283', 'SP008', '0', '1'),
('PT56879', 'SP008', '10', '0'),
('PT56879', 'SP008', '0', '5'),
('PT40823', 'SP65310', '5', '0'),
('PT40823', 'SP65310', '0', '1'),
('PT40823', 'SP008', '10', '0'),
('PT38903', 'SP008', '8', '0'),
('PT38903', 'SP35534', '5', '0'),
('PT26989', 'SP005', '5', '0'),
('PT26989', 'SP005', '5', '0'),
('PT69391', 'SP007', '8', '0'),
('PT69391', 'SP007', '8', '0'),
('PT14283', 'SP007', '5', '0'),
('PT69971', 'SP007', '10', '0'),
('PT69971', 'SP58757', '5', '0'),
('PT69971', 'SP007', '5', '0'),
('PT69971', 'SP58757', '5', '0'),
('PT69971', 'SP88262', '1', '0'),
('PT69971', 'SP007', '10', '0'),
('PT69971', 'SP58757', '5', '0'),
('PT69971', 'SP007', '5', '0'),
('PT69971', 'SP58757', '5', '0'),
('PT69971', 'SP88262', '1', '0'),
('PT89247', 'SP35534', '10', '0'),
('PT89247', 'SP35534', '0', '2'),
('PT62654', 'SP88262', '10', '0'),
('PT62654', 'SP004', '9', '0'),
('PT76371', 'SP005', '4', '0'),
('PT76371', 'SP001', '4', '0'),
('PT76371', 'SP001', '0', '1'),
('PT96372', 'SP35534', '5', '0'),
('PT51709', 'SP65310', '5', '0'),
('PT51709', 'SP58757', '6', '0'),
('PT19118', 'SP65310', '5', '0'),
('PT19118', 'SP65310', '0', '0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `id` varchar(10) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `diaChi` varchar(200) DEFAULT NULL,
  `soDienThoai` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tienNo` decimal(10,0) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`id`, `name`, `diaChi`, `soDienThoai`, `email`, `tienNo`, `status`) VALUES
('KH001', 'Nguyễn Văn A', 'Đăk Lăk', '0897654987', 'kh001@gmail.com', '55065000', 1),
('KH002', 'Nguyễn Văn B', 'Đăk Lăk', '0897654987', 'kh001@gmail.com', '20335000', 1),
('KH005', 'Nguyễn Văn E', 'Đăk Lăk', '0897654987', 'kh001@gmail.com', '28924000', 1),
('KH006', 'Nguyễn Văn F', 'Krong Pak, Đăk Lăk', '0897654987', 'kh001@gmail.com', '3413340', 1),
('KH38215', 'Nguyễn Văn Z', 'ĐăkLak', '4567893125', 'vanz@gmail.com', '3240000', 0),
('KH48089', 'Nguyễn Văn Tuấn', 'quận 7, TP.HCM', '0456789321', 'nguyenvantoan@gmail.com', '8520000', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `id` varchar(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `soDienThoai` varchar(10) DEFAULT NULL,
  `diaChi` varchar(150) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`id`, `name`, `soDienThoai`, `diaChi`, `status`) VALUES
('NCC001', 'Việt Khang', '0564793249', 'Hà Nội', 1),
('NCC002', 'Bảo Bảo', '0561233249', 'Hà Nội', 1),
('NCC003', 'Hàn Ý', '0564793254', 'Đà Nẵng', 1),
('NCC004', 'Đông Á', 'Đồng Nai', '0562343249', 1),
('NCC005', 'Long Châu', '0564654249', 'TP.HCM', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id` varchar(10) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `soDienThoai` varchar(10) DEFAULT NULL,
  `diaChi` varchar(200) DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `gioiTinh` int(1) DEFAULT NULL,
  `tienLuong` decimal(10,0) DEFAULT NULL,
  `doanhThu` decimal(10,0) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`id`, `name`, `soDienThoai`, `diaChi`, `ngaySinh`, `gioiTinh`, `tienLuong`, `doanhThu`, `status`) VALUES
('NV001', 'Châu Văn Hiệu', '0352461759', 'Đăk Lăk', '2001-03-19', 1, '9000000', '135521300', 1),
('NV002', 'Châu Văn a', '0352461759', 'Đăk Lăk', '2001-03-19', 1, '9000000', '5000000', 1),
('NV003', 'Châu Văn Hbaa', '0352461759', 'Đăk Lăk', '2001-03-19', 1, '9000000', '8600000', 1),
('NV004', 'Nguyễn Quốc Anh', '0654568945', 'Đăk Lăk', '2002-03-19', 1, '9000000', '9595000', 1),
('NV005', 'Châu Văn d', '0352461759', 'Đăk Lăk', '2003-03-19', 1, '9000000', '5000000', 0),
('NV008', 'Châu Văn g', '0352461759', 'Đăk Lăk', '2002-03-19', 1, '9000000', '12010000', 0),
('NV12380', 'Nguyễn Minh Thơ', '0654789321', 'Quận 7, TP.HCM', '2002-07-04', 0, '9000000', '0', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhaphang`
--

CREATE TABLE `nhaphang` (
  `idSanPham` varchar(10) DEFAULT NULL,
  `soluong` decimal(10,0) DEFAULT NULL,
  `ngaygio` datetime DEFAULT NULL,
  `nhanvien` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhaphang`
--

INSERT INTO `nhaphang` (`idSanPham`, `soluong`, `ngaygio`, `nhanvien`) VALUES
('SP28979', '50', '2022-07-09 11:36:01', 'NV001'),
('SP88262', '1', '2022-07-09 11:37:50', 'NV001'),
('SP007', '50', '2022-07-12 11:00:11', 'NV001'),
('SP008', '100', '2022-07-21 18:20:43', 'NV001');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` varchar(10) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `donViTinh` varchar(15) DEFAULT NULL,
  `nhacungcap` varchar(10) DEFAULT NULL,
  `gianhap` decimal(10,0) DEFAULT NULL,
  `giaban` decimal(10,0) DEFAULT NULL,
  `tonkho` decimal(10,0) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `name`, `donViTinh`, `nhacungcap`, `gianhap`, `giaban`, `tonkho`, `status`) VALUES
('SP001', 'Leber Kid', 'Hộp', 'NCC005', '125000', '180000', '25', 1),
('SP004', 'Canxi Nano KD3', 'Hộp', 'NCC002', '240000', '289000', '35', 1),
('SP005', 'Enter Men', 'Hộp', 'NCC003', '159000', '200000', '41', 1),
('SP007', 'Bổ não An Não Khang', 'Hộp', 'NCC001', '162000', '199000', '62', 1),
('SP008', 'Hồng sâm DAVI', 'Hộp', 'NCC001', '650000', '720000', '108', 1),
('SP28979', 'Rocket 1h', 'Hộp', 'NCC001', '189000', '250000', '120', 1),
('SP35534', 'SyliMaga Gold', 'Hộp', 'NCC001', '65000', '250000', '61', 1),
('SP58757', 'Xịt mũi KidMos', 'Lọ', 'NCC001', '26000', '100000', '89', 1),
('SP65310', 'Fetonic', 'Hộp', 'NCC001', '90000', '189000', '100', 1),
('SP88262', 'Sumo Kids', 'Hộp', 'NCC001', '359000', '389000', '48', 1),
('SP98598', 'Blumex', 'Hộp', 'NCC002', '56000', '199000', '90', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trahangnhacungcap`
--

CREATE TABLE `trahangnhacungcap` (
  `idSanPham` varchar(10) DEFAULT NULL,
  `nhacungcap` varchar(10) DEFAULT NULL,
  `soluong` decimal(10,0) DEFAULT NULL,
  `nhanvien` varchar(10) DEFAULT NULL,
  `ngaygio` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `trahangnhacungcap`
--

INSERT INTO `trahangnhacungcap` (`idSanPham`, `nhacungcap`, `soluong`, `nhanvien`, `ngaygio`) VALUES
('SP001', 'NCC003', '5', 'NV001', '2022-07-09 14:32:05'),
('SP005', 'NCC003', '5', 'NV001', '2022-07-09 14:52:57'),
('SP001', 'NCC003', '10', 'NV001', '2022-07-09 14:52:57'),
('SP005', 'NCC003', '5', 'NV001', '2022-07-09 14:53:34');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD KEY `nhanvien` (`nhanvien`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `khachHang` (`khachHang`),
  ADD KEY `nhanvientao` (`nhanvientao`),
  ADD KEY `nhanvienban` (`nhanvienban`),
  ADD KEY `chitiethoadon` (`chitiethoadon`);

--
-- Chỉ mục cho bảng `hoadonchitiet`
--
ALTER TABLE `hoadonchitiet`
  ADD KEY `sanpham` (`sanpham`),
  ADD KEY `id` (`id`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `nhaphang`
--
ALTER TABLE `nhaphang`
  ADD KEY `idSanPham` (`idSanPham`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nhacungcap` (`nhacungcap`);

--
-- Chỉ mục cho bảng `trahangnhacungcap`
--
ALTER TABLE `trahangnhacungcap`
  ADD KEY `nhanvien` (`nhanvien`),
  ADD KEY `nhacungcap` (`nhacungcap`),
  ADD KEY `idSanPham` (`idSanPham`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`nhanvien`) REFERENCES `nhanvien` (`id`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`nhanvientao`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`nhanvienban`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_5` FOREIGN KEY (`khachHang`) REFERENCES `khachhang` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_6` FOREIGN KEY (`nhanvientao`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_7` FOREIGN KEY (`nhanvienban`) REFERENCES `nhanvien` (`id`);

--
-- Các ràng buộc cho bảng `hoadonchitiet`
--
ALTER TABLE `hoadonchitiet`
  ADD CONSTRAINT `hoadonchitiet_ibfk_1` FOREIGN KEY (`sanpham`) REFERENCES `sanpham` (`id`);

--
-- Các ràng buộc cho bảng `nhaphang`
--
ALTER TABLE `nhaphang`
  ADD CONSTRAINT `nhaphang_ibfk_1` FOREIGN KEY (`idSanPham`) REFERENCES `sanpham` (`id`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`nhacungcap`) REFERENCES `nhacungcap` (`id`);

--
-- Các ràng buộc cho bảng `trahangnhacungcap`
--
ALTER TABLE `trahangnhacungcap`
  ADD CONSTRAINT `trahangnhacungcap_ibfk_1` FOREIGN KEY (`nhanvien`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `trahangnhacungcap_ibfk_2` FOREIGN KEY (`nhacungcap`) REFERENCES `nhacungcap` (`id`),
  ADD CONSTRAINT `trahangnhacungcap_ibfk_3` FOREIGN KEY (`idSanPham`) REFERENCES `sanpham` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
