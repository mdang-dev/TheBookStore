USE [master]
GO
/****** Object:  Database [TheBookStore]    Script Date: 8/11/2024 11:27:42 PM ******/
CREATE DATABASE [TheBookStore]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TheBookStore', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\TheBookStore.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'TheBookStore_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\TheBookStore_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [TheBookStore] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TheBookStore].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TheBookStore] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TheBookStore] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TheBookStore] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TheBookStore] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TheBookStore] SET ARITHABORT OFF 
GO
ALTER DATABASE [TheBookStore] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TheBookStore] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TheBookStore] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TheBookStore] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TheBookStore] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TheBookStore] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TheBookStore] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TheBookStore] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TheBookStore] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TheBookStore] SET  ENABLE_BROKER 
GO
ALTER DATABASE [TheBookStore] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TheBookStore] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TheBookStore] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TheBookStore] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TheBookStore] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TheBookStore] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TheBookStore] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TheBookStore] SET RECOVERY FULL 
GO
ALTER DATABASE [TheBookStore] SET  MULTI_USER 
GO
ALTER DATABASE [TheBookStore] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TheBookStore] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TheBookStore] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TheBookStore] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [TheBookStore] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [TheBookStore] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'TheBookStore', N'ON'
GO
ALTER DATABASE [TheBookStore] SET QUERY_STORE = ON
GO
ALTER DATABASE [TheBookStore] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [TheBookStore]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ID] [varchar](128) NOT NULL,
	[ProductName] [nvarchar](max) NOT NULL,
	[TypeOfProductID] [int] NOT NULL,
	[Author] [nvarchar](max) NULL,
	[Publisher] [nvarchar](max) NULL,
	[Genre] [nvarchar](100) NULL,
	[MoreInfo] [nvarchar](max) NULL,
	[BarCode] [varchar](20) NOT NULL,
	[EmployeeID] [int] NOT NULL,
	[ImagePath] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WarehouseReceipts]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WarehouseReceipts](
	[ID] [varchar](128) NOT NULL,
	[ProviderID] [int] NOT NULL,
	[ReceivingDate] [datetime] NOT NULL,
	[TotalCost] [float] NULL,
	[CurrentStatus] [nvarchar](100) NOT NULL,
	[MoreInfo] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WarehouseReceiptDetails]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WarehouseReceiptDetails](
	[ID] [varchar](128) NOT NULL,
	[ProductID] [varchar](128) NOT NULL,
	[WarehouseReceiptID] [varchar](128) NOT NULL,
	[Quantity] [int] NOT NULL,
	[ReceivingPrice] [float] NOT NULL,
	[CurrentStatus] [nvarchar](100) NULL,
	[MoreInfo] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Inventory]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inventory](
	[ID] [varchar](128) NOT NULL,
	[ProductID] [varchar](128) NOT NULL,
	[WarehouseReceiptID] [varchar](128) NOT NULL,
	[AvailableQuantity] [int] NOT NULL,
	[SellingPrice] [float] NOT NULL,
	[CurrentStatus] [nvarchar](100) NULL,
	[Area] [nvarchar](200) NULL,
	[MoreInfo] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  View [dbo].[viewInventoryProduct]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   VIEW [dbo].[viewInventoryProduct]
AS
	SELECT pr.ID, pr.ProductName, iv.WarehouseReceiptID, iv.AvailableQuantity, whd.ReceivingPrice, iv.SellingPrice, iv.CurrentStatus, iv.Area, pr.ImagePath, iv.MoreInfo FROM Products pr JOIN Inventory iv ON pr.ID = iv.ProductID JOIN WarehouseReceipts wh ON wh.ID = iv.WarehouseReceiptID JOIN WarehouseReceiptDetails whd ON wh.ID = whd.WarehouseReceiptID
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CustomerName] [nvarchar](200) NULL,
	[PhoneNumber] [varchar](20) NOT NULL,
	[addressCustomers] [nvarchar](max) NULL,
	[ContractDate] [date] NULL,
	[Email] [varchar](200) NULL,
	[MoreInfo] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employees]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employees](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeName] [nvarchar](max) NULL,
	[Username] [varchar](50) NOT NULL,
	[EmployeePassword] [varchar](50) NOT NULL,
	[Gender] [bit] NOT NULL,
	[DateOfBirth] [date] NOT NULL,
	[EmployeeRole] [bit] NOT NULL,
	[Email] [varchar](200) NULL,
	[PhoneNumber] [varchar](20) NOT NULL,
	[MoreInfo] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Providers]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Providers](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ProviderName] [nvarchar](max) NOT NULL,
	[PhoneNumber] [varchar](20) NULL,
	[addressProviders] [nvarchar](max) NULL,
	[ContractDate] [date] NULL,
	[Email] [varchar](200) NULL,
	[MoreInfo] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReceiptDetails]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReceiptDetails](
	[ID] [varchar](128) NOT NULL,
	[ReceiptID] [varchar](128) NOT NULL,
	[InventoryID] [varchar](128) NOT NULL,
	[Quantity] [int] NOT NULL,
	[SellingPrice] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Receipts]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Receipts](
	[ID] [varchar](128) NOT NULL,
	[EmployeeID] [int] NOT NULL,
	[TotalCost] [float] NULL,
	[CurrentStatus] [nvarchar](100) NULL,
	[CreatedDate] [datetime] NOT NULL,
	[MoreInfo] [nvarchar](max) NULL,
	[MoneyReceived] [float] NULL,
	[MoneyReturned] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TypeOfProduct]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TypeOfProduct](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TypeOfProduct] [nvarchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Inventory]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ID])
GO
ALTER TABLE [dbo].[Inventory]  WITH CHECK ADD FOREIGN KEY([WarehouseReceiptID])
REFERENCES [dbo].[WarehouseReceipts] ([ID])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([EmployeeID])
REFERENCES [dbo].[Employees] ([ID])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([TypeOfProductID])
REFERENCES [dbo].[TypeOfProduct] ([ID])
GO
ALTER TABLE [dbo].[ReceiptDetails]  WITH CHECK ADD FOREIGN KEY([InventoryID])
REFERENCES [dbo].[Inventory] ([ID])
GO
ALTER TABLE [dbo].[ReceiptDetails]  WITH CHECK ADD FOREIGN KEY([ReceiptID])
REFERENCES [dbo].[Receipts] ([ID])
GO
ALTER TABLE [dbo].[Receipts]  WITH CHECK ADD FOREIGN KEY([EmployeeID])
REFERENCES [dbo].[Employees] ([ID])
GO
ALTER TABLE [dbo].[WarehouseReceiptDetails]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ID])
GO
ALTER TABLE [dbo].[WarehouseReceiptDetails]  WITH CHECK ADD FOREIGN KEY([WarehouseReceiptID])
REFERENCES [dbo].[WarehouseReceipts] ([ID])
GO
ALTER TABLE [dbo].[WarehouseReceipts]  WITH CHECK ADD FOREIGN KEY([ProviderID])
REFERENCES [dbo].[Providers] ([ID])
GO
/****** Object:  StoredProcedure [dbo].[CheckDuplicate]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[CheckDuplicate] @InventoryID VARCHAR(128), @ReceiptID VARCHAR(128)
AS
BEGIN
	IF @InventoryID IN (SELECT InventoryID FROM ReceiptDetails WHERE ReceiptID = @ReceiptID)
	BEGIN
		SELECT 1
	END
	ELSE
	BEGIN 
		SELECT 0
	END
END
GO
/****** Object:  StoredProcedure [dbo].[DeleteReceipt]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   PROC [dbo].[DeleteReceipt] @ID VARCHAR(128)
AS
BEGIN
	IF EXISTS (SELECT @ID FROM ReceiptDetails)
	BEGIN
		DELETE FROM ReceiptDetails WHERE ReceiptID = @ID
		DELETE FROM Receipts WHERE ID = @ID
	END
	ELSE
	BEGIN
		DELETE FROM Receipts WHERE ID = @ID
	END
END
GO
/****** Object:  StoredProcedure [dbo].[InventoryData]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   PROC [dbo].[InventoryData]
AS
BEGIN
	SELECT iv.ID AS InventoryID, pr.ID AS ProductID, pr.ProductName, iv.WarehouseReceiptID, wh.ReceivingDate, iv.AvailableQuantity, whd.ReceivingPrice, iv.SellingPrice, iv.CurrentStatus, iv.Area, pr.ImagePath, iv.MoreInfo FROM Products pr JOIN Inventory iv ON pr.ID = iv.ProductID JOIN WarehouseReceipts wh ON wh.ID = iv.WarehouseReceiptID JOIN WarehouseReceiptDetails whd ON wh.ID = whd.WarehouseReceiptID
	END
GO
/****** Object:  StoredProcedure [dbo].[InventoryDataAll]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[InventoryDataAll]
AS
BEGIN
	SELECT iv.ID AS InventoryID, pr.ID AS ProductID, pr.ProductName, iv.WarehouseReceiptID, wh.ReceivingDate, iv.AvailableQuantity, whd.ReceivingPrice, iv.SellingPrice, iv.CurrentStatus, iv.Area, pr.ImagePath, iv.MoreInfo FROM Products pr JOIN Inventory iv ON pr.ID = iv.ProductID JOIN WarehouseReceipts wh ON wh.ID = iv.WarehouseReceiptID JOIN WarehouseReceiptDetails whd ON wh.ID = whd.WarehouseReceiptID
END
GO
/****** Object:  StoredProcedure [dbo].[RevenueStatistics]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   PROC [dbo].[RevenueStatistics] @StartDate DATE = NULL, @EndDate DATE = NULL
AS
BEGIN
    SET @StartDate = ISNULL(@StartDate, '2000-01-01');
    SET @EndDate = ISNULL(@EndDate, GETDATE());

    SELECT R.CreatedDate AS Date, SUM(RD.Quantity * RD.SellingPrice) AS Total_Revenue
    FROM ReceiptDetails RD JOIN Receipts R ON RD.ReceiptID = R.ID
    WHERE R.CreatedDate BETWEEN @StartDate AND @EndDate
    GROUP BY R.CreatedDate
    ORDER BY R.CreatedDate;
END
GO
/****** Object:  StoredProcedure [dbo].[SearchProductWarehouse]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROC [dbo].[SearchProductWarehouse] @name nvarchar(100)
AS 
BEGIN
	SELECT * FROM Products WHERE ProductName LIKE '%'+@name+'%'
END
GO
/****** Object:  StoredProcedure [dbo].[searchWarehouseReceiptID]    Script Date: 8/11/2024 11:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   PROC [dbo].[searchWarehouseReceiptID] @id varchar(100)
AS
BEGIN
	SELECT * FROM WarehouseReceipts WHERE ID LIKE '%'+@id+'%'
END
GO
USE [master]
GO
ALTER DATABASE [TheBookStore] SET  READ_WRITE 
GO
