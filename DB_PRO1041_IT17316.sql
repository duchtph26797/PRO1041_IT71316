USE [master]
GO
/****** Object:  Database [PRO1041_IT17316_N5]    Script Date: 11/23/2022 12:43:16 AM ******/
CREATE DATABASE [PRO1041_IT17316_N5]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PRO1041_IT17316_N5', FILENAME = N'C:\Program Files\Microsoft SQL Server 2019 Express\MSSQL15.SQLEXPRESS\MSSQL\DATA\PRO1041_IT17316_N5.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PRO1041_IT17316_N5_log', FILENAME = N'C:\Program Files\Microsoft SQL Server 2019 Express\MSSQL15.SQLEXPRESS\MSSQL\DATA\PRO1041_IT17316_N5_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRO1041_IT17316_N5].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET ARITHABORT OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET  MULTI_USER 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET QUERY_STORE = OFF
GO
USE [PRO1041_IT17316_N5]
GO
/****** Object:  Table [dbo].[CHATLIEU]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHATLIEU](
	[MaCL] [varchar](10) NOT NULL,
	[TenCL] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHITIETSP]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETSP](
	[MaCTSP] [varchar](10) NOT NULL,
	[MaSP] [varchar](10) NULL,
	[MaMS] [varchar](10) NULL,
	[MaLoai] [varchar](10) NULL,
	[MaCL] [varchar](10) NULL,
	[MaKC] [varchar](10) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[MoTa] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HDCT]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HDCT](
	[MaHDCT] [varchar](10) NOT NULL,
	[NgayTao] [date] NULL,
	[MaCTSP] [varchar](10) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[MaHD] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHDCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[MaHD] [varchar](10) NOT NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [int] NULL,
	[MaNV] [varchar](10) NULL,
	[MaKH] [varchar](10) NULL,
	[MaKM] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[MaKH] [varchar](10) NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [varchar](20) NULL,
	[Username] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHUYENMAI]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHUYENMAI](
	[MaKM] [varchar](10) NOT NULL,
	[MucKM] [int] NULL,
	[NgayBatDau] [date] NULL,
	[NgayKetThuc] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KICHCO]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KICHCO](
	[MaKC] [varchar](10) NOT NULL,
	[TenKC] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOAIHANG]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAIHANG](
	[MaLoai] [varchar](10) NOT NULL,
	[TenLoai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MAUSAC]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAUSAC](
	[MaMS] [varchar](10) NOT NULL,
	[TenMS] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaMS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[MaNV] [varchar](10) NOT NULL,
	[TenNV] [nvarchar](50) NULL,
	[SDT] [varchar](20) NULL,
	[Username] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SANPHAM]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SANPHAM](
	[MaSP] [varchar](10) NOT NULL,
	[TenSP] [nvarchar](50) NULL,
	[MaLoai] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TAIKHOAN]    Script Date: 11/23/2022 12:43:16 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TAIKHOAN](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NULL,
	[LoaiTK] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CHATLIEU] ([MaCL], [TenCL]) VALUES (N'CL1', N'Vải')
INSERT [dbo].[CHATLIEU] ([MaCL], [TenCL]) VALUES (N'CL2', N'Nỉ')
INSERT [dbo].[CHATLIEU] ([MaCL], [TenCL]) VALUES (N'CL3', N'Bông')
GO
INSERT [dbo].[CHITIETSP] ([MaCTSP], [MaSP], [MaMS], [MaLoai], [MaCL], [MaKC], [SoLuong], [DonGia], [MoTa]) VALUES (N'CTSP1', N'SP1', N'MS2', N'L1', N'CL2', N'KC2', 50, 55.5, N'rất ngon')
GO
INSERT [dbo].[HDCT] ([MaHDCT], [NgayTao], [MaCTSP], [SoLuong], [DonGia], [MaHD]) VALUES (N'HDCT1', CAST(N'2022-11-12' AS Date), N'CTSP1', 2, 55.5, N'HD1')
GO
INSERT [dbo].[HOADON] ([MaHD], [NgayTao], [TrangThai], [MaNV], [MaKH], [MaKM]) VALUES (N'HD1', CAST(N'2022-11-12' AS Date), 0, N'NV1', N'KH1', N'KM0')
GO
INSERT [dbo].[KHACHHANG] ([MaKH], [TenKH], [DiaChi], [SDT], [Username]) VALUES (N'KH1', N'TIẾN NGUYỄN', N'PHÚ QUỐC', N'0123456789', N'tien')
GO
INSERT [dbo].[KHUYENMAI] ([MaKM], [MucKM], [NgayBatDau], [NgayKetThuc]) VALUES (N'KM0', 0, NULL, NULL)
INSERT [dbo].[KHUYENMAI] ([MaKM], [MucKM], [NgayBatDau], [NgayKetThuc]) VALUES (N'KM1', 10, CAST(N'2022-12-21' AS Date), CAST(N'2022-12-23' AS Date))
INSERT [dbo].[KHUYENMAI] ([MaKM], [MucKM], [NgayBatDau], [NgayKetThuc]) VALUES (N'KM2', 20, CAST(N'2022-12-18' AS Date), CAST(N'2022-12-21' AS Date))
INSERT [dbo].[KHUYENMAI] ([MaKM], [MucKM], [NgayBatDau], [NgayKetThuc]) VALUES (N'KM3', 50, CAST(N'2022-12-15' AS Date), CAST(N'2022-12-21' AS Date))
GO
INSERT [dbo].[KICHCO] ([MaKC], [TenKC]) VALUES (N'KC1', N'M')
INSERT [dbo].[KICHCO] ([MaKC], [TenKC]) VALUES (N'KC2', N'L')
INSERT [dbo].[KICHCO] ([MaKC], [TenKC]) VALUES (N'KC3', N'XL')
GO
INSERT [dbo].[LOAIHANG] ([MaLoai], [TenLoai]) VALUES (N'L1', N'Quần')
INSERT [dbo].[LOAIHANG] ([MaLoai], [TenLoai]) VALUES (N'L2', N'Áo')
GO
INSERT [dbo].[MAUSAC] ([MaMS], [TenMS]) VALUES (N'MS1', N'Xanh')
INSERT [dbo].[MAUSAC] ([MaMS], [TenMS]) VALUES (N'MS2', N'Đen')
INSERT [dbo].[MAUSAC] ([MaMS], [TenMS]) VALUES (N'MS3', N'Trắng')
GO
INSERT [dbo].[NHANVIEN] ([MaNV], [TenNV], [SDT], [Username]) VALUES (N'NV1', N'cường nguyễn', NULL, N'cuong3')
INSERT [dbo].[NHANVIEN] ([MaNV], [TenNV], [SDT], [Username]) VALUES (N'NV2', N'lịch trần tạ', NULL, N'lich')
INSERT [dbo].[NHANVIEN] ([MaNV], [TenNV], [SDT], [Username]) VALUES (N'NV3', N'văn phú', NULL, N'phu8')
GO
INSERT [dbo].[SANPHAM] ([MaSP], [TenSP], [MaLoai]) VALUES (N'SP1', N'Áo 1', N'L2')
INSERT [dbo].[SANPHAM] ([MaSP], [TenSP], [MaLoai]) VALUES (N'SP2', N'Áo 2', N'L2')
INSERT [dbo].[SANPHAM] ([MaSP], [TenSP], [MaLoai]) VALUES (N'SP3', N'Quần 1', N'L1')
GO
INSERT [dbo].[TAIKHOAN] ([Username], [Password], [LoaiTK]) VALUES (N'cuong3', N'11', N'nhanvien')
INSERT [dbo].[TAIKHOAN] ([Username], [Password], [LoaiTK]) VALUES (N'duc11', N'11', N'quanly')
INSERT [dbo].[TAIKHOAN] ([Username], [Password], [LoaiTK]) VALUES (N'lich', N'11', N'nhanvien')
INSERT [dbo].[TAIKHOAN] ([Username], [Password], [LoaiTK]) VALUES (N'phu8', N'11', N'nhanvien')
INSERT [dbo].[TAIKHOAN] ([Username], [Password], [LoaiTK]) VALUES (N'tien', N'11', N'khachhang')
GO
ALTER TABLE [dbo].[CHITIETSP]  WITH CHECK ADD FOREIGN KEY([MaCL])
REFERENCES [dbo].[CHATLIEU] ([MaCL])
GO
ALTER TABLE [dbo].[CHITIETSP]  WITH CHECK ADD FOREIGN KEY([MaKC])
REFERENCES [dbo].[KICHCO] ([MaKC])
GO
ALTER TABLE [dbo].[CHITIETSP]  WITH CHECK ADD FOREIGN KEY([MaMS])
REFERENCES [dbo].[MAUSAC] ([MaMS])
GO
ALTER TABLE [dbo].[CHITIETSP]  WITH CHECK ADD FOREIGN KEY([MaSP])
REFERENCES [dbo].[SANPHAM] ([MaSP])
GO
ALTER TABLE [dbo].[HDCT]  WITH CHECK ADD FOREIGN KEY([MaCTSP])
REFERENCES [dbo].[CHITIETSP] ([MaCTSP])
GO
ALTER TABLE [dbo].[HDCT]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HOADON] ([MaHD])
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD FOREIGN KEY([MaKH])
REFERENCES [dbo].[KHACHHANG] ([MaKH])
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD FOREIGN KEY([MaKM])
REFERENCES [dbo].[KHUYENMAI] ([MaKM])
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NHANVIEN] ([MaNV])
GO
ALTER TABLE [dbo].[KHACHHANG]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[TAIKHOAN] ([Username])
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[TAIKHOAN] ([Username])
GO
ALTER TABLE [dbo].[SANPHAM]  WITH CHECK ADD FOREIGN KEY([MaLoai])
REFERENCES [dbo].[LOAIHANG] ([MaLoai])
GO
USE [master]
GO
ALTER DATABASE [PRO1041_IT17316_N5] SET  READ_WRITE 
GO
