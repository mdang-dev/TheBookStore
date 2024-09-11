package TheBookStore;

import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DAO.ProductDAO;
import DAO.ProviderDAO;
import DAO.ReceiptsDAO;
import DAO.ReceiptsDetailsDAO;
import DAO.WareHouseReceiptDetailsDAO;
import DAO.ReceiveIntoInventoryDAO;
import DAO.StatisticsDAO;
import DAO.WareHouseReceiptsDAO;
import EntityClass.Customer;
import EntityClass.Employees;
import EntityClass.Inventory;
import EntityClass.Products;
import EntityClass.Providers;
import EntityClass.ReceiptDetails;
import EntityClass.Receipts;
import EntityClass.TextTableCenter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import EntityClass.WareHouseReceiptDetails;
import EntityClass.WareHouseReceipts;
import ExtentionLibrary.Auth;
import ExtentionLibrary.GenerateBarcodeImage;
import ExtentionLibrary.MsgBox;
import ExtentionLibrary.XDate;
import ExtentionLibrary.XImage;
import ExtentionLibrary.XJdbc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.sql.DriverManager;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellEditor;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import raven.alerts.MessageAlerts;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

/**
 *
 * @author Admin
 */
public class TheBookStoreJFrame extends javax.swing.JFrame {

    /**
     * Creates new form TheBookStoreJFrame
     *
     * @throws java.sql.SQLException
     */
    public TheBookStoreJFrame() throws SQLException {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        init();
        initCustomer();
        ImageIcon icon = new ImageIcon("src\\img\\Rimberio.png");
        this.setIconImage(icon.getImage());
        GlassPanePopup.install(this);
        Notifications.getInstance().setJFrame(this);
        permission();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupGender = new javax.swing.ButtonGroup();
        GroupRole = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        groupCurrentStatusWarehouseReceipt = new javax.swing.ButtonGroup();
        groupCurrentStatusWarehouseExport = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlMenu = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnBooks = new javax.swing.JButton();
        btnStationery = new javax.swing.JButton();
        btnProviders = new javax.swing.JButton();
        btnReceipts = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnEmployees = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();
        btnWarehouse = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        tabs = new javax.swing.JTabbedPane();
        pnlMenuTab = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        pnlTypeOfProduct = new javax.swing.JPanel();
        pnlBooks = new javax.swing.JPanel();
        pnlBookForm = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblBookImage = new javax.swing.JLabel();
        txtPublisher = new javax.swing.JTextField();
        txtBookID = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        cbbGenre = new javax.swing.JComboBox<>();
        txtBookName = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBookMoreInfo = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        lblBarcode = new javax.swing.JLabel();
        txtBookAddedBy = new javax.swing.JTextField();
        btnClearBook = new javax.swing.JButton();
        btnAddBook = new javax.swing.JButton();
        btnUpdateBook = new javax.swing.JButton();
        btnDeleteBook = new javax.swing.JButton();
        pnlBookTable = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        txtFindBook = new javax.swing.JTextField();
        pnlStationery = new javax.swing.JPanel();
        pnlStationeryForm = new javax.swing.JPanel();
        pnlStationeryPic = new javax.swing.JPanel();
        lblStationeryImage = new javax.swing.JLabel();
        txtStationeryID = new javax.swing.JTextField();
        pnlStationery_MoreInfo = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtStationeryMoreInfo = new javax.swing.JTextArea();
        txtStationery_AddBy = new javax.swing.JTextField();
        txtStationery_Name = new javax.swing.JTextField();
        pnlStationery_TypeOfProduct = new javax.swing.JPanel();
        cbbStationeryGenre = new javax.swing.JComboBox<>();
        btnAddStationery = new javax.swing.JButton();
        btnClearStationery = new javax.swing.JButton();
        btnUpdateStationery = new javax.swing.JButton();
        btnDeleteStationery = new javax.swing.JButton();
        pnlStationery_Barcode = new javax.swing.JPanel();
        lblStationeryBarcode = new javax.swing.JLabel();
        pnlStationeryTable = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblStationery = new javax.swing.JTable();
        txtFindStationery = new javax.swing.JTextField();
        pnlProviders = new javax.swing.JPanel();
        pnlProvidersTable = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblProvider = new javax.swing.JTable();
        txtFindProvider = new javax.swing.JTextField();
        pnlProvidersForm = new javax.swing.JPanel();
        txtProvider_Email = new javax.swing.JTextField();
        txtProvider_ID = new javax.swing.JTextField();
        pnlProvider_ContractDate = new javax.swing.JPanel();
        txtProvider_ContractDate = new com.toedter.calendar.JDateChooser();
        pnlProvider_MoreInfo = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtProvider_MoreInfo = new javax.swing.JTextArea();
        btnRefreshProvider = new javax.swing.JButton();
        btnAddProvider = new javax.swing.JButton();
        btnUpdateProvider = new javax.swing.JButton();
        btnDeleteProvider = new javax.swing.JButton();
        txtProviderName = new javax.swing.JTextField();
        txtAddressProvider = new javax.swing.JTextField();
        txtNumPhoneProvider = new javax.swing.JTextField();
        pnlCustomers = new javax.swing.JPanel();
        pnlListCustomer = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblListCustomer = new javax.swing.JTable();
        txtfindCustomer = new javax.swing.JTextField();
        pnlForm1 = new javax.swing.JPanel();
        txtIDCustomer = new javax.swing.JTextField();
        txtnameCustomer = new javax.swing.JTextField();
        txtadressCustomer = new javax.swing.JTextField();
        pnlmoreInforCustomer = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtmoreInforeCustomer = new javax.swing.JTextArea();
        btnnewCustomer = new javax.swing.JButton();
        btnaddCustomer = new javax.swing.JButton();
        btnfixCustomer = new javax.swing.JButton();
        btndeleteCustomer = new javax.swing.JButton();
        txtnumberphoneCustomer = new javax.swing.JTextField();
        txtemailCustomer = new javax.swing.JTextField();
        pnlmoreInforCustomer1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtmoreInforeCustomer1 = new javax.swing.JTextArea();
        pnlReceipts = new javax.swing.JPanel();
        pnlCustomers1 = new javax.swing.JPanel();
        pnlListCustomer1 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblReceiptProducts = new javax.swing.JTable();
        txtFindPrdReceipts = new javax.swing.JTextField();
        chkStationery = new javax.swing.JCheckBox();
        chkBook = new javax.swing.JCheckBox();
        pnlForm2 = new javax.swing.JPanel();
        txtReceivedReceipts = new javax.swing.JTextField();
        txtReceiptsIDReceipts = new javax.swing.JTextField();
        txtCreatedDayReceipts = new javax.swing.JTextField();
        btnCancelReceipts = new javax.swing.JButton();
        txtTotalReceipts = new javax.swing.JTextField();
        txtCreatedBy = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblReceiptDetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnaddnewReceipts = new javax.swing.JButton();
        btnViewReceipts = new javax.swing.JButton();
        btnPrintReceipts = new javax.swing.JButton();
        txtReturnReceipts = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        pnlChangePassword = new javax.swing.JPanel();
        pnlChangePasswordForm = new javax.swing.JPanel();
        lblOldPassEye = new javax.swing.JLabel();
        lblNewPassEye1 = new javax.swing.JLabel();
        lblNewPassEye2 = new javax.swing.JLabel();
        txtUsernameChange = new javax.swing.JTextField();
        btnChangePass = new javax.swing.JButton();
        txtNewPassword2 = new javax.swing.JPasswordField();
        txtOldPassword = new javax.swing.JPasswordField();
        txtNewPassword1 = new javax.swing.JPasswordField();
        pnlWarehouse = new javax.swing.JPanel();
        pnlInventoryAll = new javax.swing.JPanel();
        tabsInventory = new javax.swing.JTabbedPane();
        pnlInventory1 = new javax.swing.JPanel();
        txtFindInventory = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        pnlWHRP = new javax.swing.JLayeredPane();
        pnlWareHouseReceiptsAll = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        pnlWareHouseReceiptsGenarel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtWareHouseReceiptGeneral = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtCurrentStatus = new javax.swing.JTextField();
        btnEditWarehouseReceipts = new javax.swing.JButton();
        txtTotalCostWareHouseReciepts = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtProviderWareHouseReceipts = new javax.swing.JTextField();
        txtReceivingDateGenarel = new javax.swing.JTextField();
        btnEditWarehouseReceipts2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        pnlWareHouseReceiptsDetails = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tblProductWarehouseReceipt = new javax.swing.JTable();
        txtSearchProduct = new javax.swing.JTextField();
        jScrollPane26 = new javax.swing.JScrollPane();
        tblProductDetails = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pnlWareHouseReceiptsTableAll = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        tblWarehouseReceiptsAll = new javax.swing.JTable();
        txtSearchWarehouseReceipt = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnlWareHouseReceipts = new javax.swing.JPanel();
        lblWaring = new javax.swing.JLabel();
        txtWareHouseReceiptsID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtReceivingDate = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cboProviders = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        txtDecriptionWareHouse = new javax.swing.JTextArea();
        btnVerifyWareHouse = new javax.swing.JButton();
        DateChoosen = new com.toedter.calendar.JDateChooser();
        rdoUnpaid = new javax.swing.JRadioButton();
        rdoPaid = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        pnlStatistics = new javax.swing.JPanel();
        pnlStatisticsForm = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblStatistics = new javax.swing.JTable();
        btnStatisticsReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        startDate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        endDate = new com.toedter.calendar.JDateChooser();
        pnlChart = new javax.swing.JPanel();
        pnlEmployees = new javax.swing.JPanel();
        pnlEmployeesTable = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        txtFindEmployees = new javax.swing.JTextField();
        pnlEmployeesForm = new javax.swing.JPanel();
        lblPassword2 = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtEmployeesName = new javax.swing.JTextField();
        txtPhoneNumberEmployees = new javax.swing.JTextField();
        pnlDateOfBirth = new javax.swing.JPanel();
        dateOfBirth = new com.toedter.calendar.JDateChooser();
        pnlEmployeesRole = new javax.swing.JPanel();
        rdoManager = new javax.swing.JRadioButton();
        rdoEmployees = new javax.swing.JRadioButton();
        btnClearEmployees = new javax.swing.JButton();
        btnAddEmployees = new javax.swing.JButton();
        btnUpdateEmployees = new javax.swing.JButton();
        btnDeleteEmployees = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        pnlGender = new javax.swing.JPanel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        txtEmail = new javax.swing.JTextField();
        pnlEmployeesMoreInfo = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        txtEmployeesMoreInfo = new javax.swing.JTextArea();
        txtPassword = new javax.swing.JPasswordField();
        txtPassword2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THE BOOKSTORE");
        setExtendedState(6);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setBackground(new java.awt.Color(209, 209, 209));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(204, 0, 0));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-out.png"))); // NOI18N
        btnLogout.setText("ĐĂNG XUẤT");
        btnLogout.setFocusPainted(false);
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogout.setIconTextGap(10);
        btnLogout.setOpaque(true);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        pnlMenu.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 180, 50));

        btnExit.setBackground(new java.awt.Color(209, 209, 209));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnExit.setForeground(new java.awt.Color(204, 0, 0));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit-btn.png"))); // NOI18N
        btnExit.setText("THOÁT");
        btnExit.setFocusPainted(false);
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExit.setIconTextGap(10);
        btnExit.setOpaque(true);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlMenu.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 810, 180, 50));

        btnBooks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stack-of-books.png"))); // NOI18N
        btnBooks.setText("SÁCH");
        btnBooks.setBorder(new javax.swing.border.MatteBorder(null));
        btnBooks.setFocusPainted(false);
        btnBooks.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBooks.setIconTextGap(10);
        btnBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksActionPerformed(evt);
            }
        });
        pnlMenu.add(btnBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 50));

        btnStationery.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnStationery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stationery.png"))); // NOI18N
        btnStationery.setText("VĂN PHÒNG PHẨM");
        btnStationery.setBorder(new javax.swing.border.MatteBorder(null));
        btnStationery.setFocusPainted(false);
        btnStationery.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnStationery.setIconTextGap(10);
        btnStationery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStationeryActionPerformed(evt);
            }
        });
        pnlMenu.add(btnStationery, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 180, 50));

        btnProviders.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProviders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/provider.png"))); // NOI18N
        btnProviders.setText("NHÀ CUNG CẤP");
        btnProviders.setBorder(new javax.swing.border.MatteBorder(null));
        btnProviders.setFocusPainted(false);
        btnProviders.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProviders.setIconTextGap(10);
        btnProviders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvidersActionPerformed(evt);
            }
        });
        pnlMenu.add(btnProviders, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 180, 50));

        btnReceipts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/invoice.png"))); // NOI18N
        btnReceipts.setText("HÓA ĐƠN");
        btnReceipts.setBorder(new javax.swing.border.MatteBorder(null));
        btnReceipts.setFocusPainted(false);
        btnReceipts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReceipts.setIconTextGap(10);
        btnReceipts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceiptsActionPerformed(evt);
            }
        });
        pnlMenu.add(btnReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, 50));

        btnCustomers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/customer-satisfaction.png"))); // NOI18N
        btnCustomers.setText("KHÁCH HÀNG");
        btnCustomers.setBorder(new javax.swing.border.MatteBorder(null));
        btnCustomers.setFocusPainted(false);
        btnCustomers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCustomers.setIconTextGap(10);
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 50));

        btnEmployees.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/staff.png"))); // NOI18N
        btnEmployees.setText("NHÂN VIÊN");
        btnEmployees.setBorder(new javax.swing.border.MatteBorder(null));
        btnEmployees.setFocusPainted(false);
        btnEmployees.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmployees.setIconTextGap(10);
        btnEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesActionPerformed(evt);
            }
        });
        pnlMenu.add(btnEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 180, 50));

        btnChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset-password.png"))); // NOI18N
        btnChangePassword.setText("ĐỔI MẬT KHẨU");
        btnChangePassword.setBorder(new javax.swing.border.MatteBorder(null));
        btnChangePassword.setFocusPainted(false);
        btnChangePassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnChangePassword.setIconTextGap(10);
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });
        pnlMenu.add(btnChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 180, 50));

        btnWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnWarehouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/warehouse.png"))); // NOI18N
        btnWarehouse.setText("KHO");
        btnWarehouse.setBorder(new javax.swing.border.MatteBorder(null));
        btnWarehouse.setFocusPainted(false);
        btnWarehouse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnWarehouse.setIconTextGap(10);
        btnWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWarehouseActionPerformed(evt);
            }
        });
        pnlMenu.add(btnWarehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 180, 50));

        btnReports.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analytics.png"))); // NOI18N
        btnReports.setText("THỐNG KÊ");
        btnReports.setBorder(new javax.swing.border.MatteBorder(null));
        btnReports.setFocusPainted(false);
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReports.setIconTextGap(10);
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });
        pnlMenu.add(btnReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 180, 50));

        btnMinimize.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnMinimize.setForeground(new java.awt.Color(204, 0, 0));
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        btnMinimize.setText("THU NHỎ");
        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMinimize.setIconTextGap(10);
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });
        pnlMenu.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 180, 50));

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 860));

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabs.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblStatus.setText(" ");

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTime.setText(" ");

        javax.swing.GroupLayout pnlMenuTabLayout = new javax.swing.GroupLayout(pnlMenuTab);
        pnlMenuTab.setLayout(pnlMenuTabLayout);
        pnlMenuTabLayout.setHorizontalGroup(
            pnlMenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuTabLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 715, Short.MAX_VALUE)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
        );
        pnlMenuTabLayout.setVerticalGroup(
            pnlMenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuTabLayout.createSequentialGroup()
                .addContainerGap(816, Short.MAX_VALUE)
                .addGroup(pnlMenuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(198, 198, 198))
        );

        tabs.addTab("tab11", pnlMenuTab);

        javax.swing.GroupLayout pnlTypeOfProductLayout = new javax.swing.GroupLayout(pnlTypeOfProduct);
        pnlTypeOfProduct.setLayout(pnlTypeOfProductLayout);
        pnlTypeOfProductLayout.setHorizontalGroup(
            pnlTypeOfProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        pnlTypeOfProductLayout.setVerticalGroup(
            pnlTypeOfProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );

        tabs.addTab("LOAI SAN PHAM", pnlTypeOfProduct);

        pnlBooks.setBackground(new java.awt.Color(255, 255, 255));
        pnlBooks.setPreferredSize(new java.awt.Dimension(1539, 1000));
        pnlBooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBookForm.setBackground(new java.awt.Color(255, 255, 255));
        pnlBookForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlBookForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hình Ảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblBookImage.setBackground(new java.awt.Color(204, 204, 204));
        lblBookImage.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBookImage.setForeground(new java.awt.Color(255, 255, 255));
        lblBookImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBookImage.setText("+");
        lblBookImage.setOpaque(true);
        lblBookImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBookImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBookImage, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lblBookImage, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBookForm.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 230));

        txtPublisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPublisher.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhà Xuất Bản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlBookForm.add(txtPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 430, 60));

        txtBookID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBookID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlBookForm.add(txtBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 410, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thể Loại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbbGenre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbGenre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbbGenre.setOpaque(true);
        jPanel5.add(cbbGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 370, 40));

        pnlBookForm.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 410, 70));

        txtBookName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBookName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlBookForm.add(txtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 410, 60));

        txtAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAuthor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tác Giả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });
        pnlBookForm.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 430, 60));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookMoreInfo.setColumns(20);
        txtBookMoreInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBookMoreInfo.setRows(5);
        jScrollPane1.setViewportView(txtBookMoreInfo);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 610, 80));

        pnlBookForm.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 630, 120));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Vạch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBarcode.setBackground(new java.awt.Color(204, 204, 204));
        lblBarcode.setOpaque(true);
        jPanel7.add(lblBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 360, 70));

        pnlBookForm.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 430, 110));

        txtBookAddedBy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBookAddedBy.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Được Thêm Bởi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlBookForm.add(txtBookAddedBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 430, 60));

        btnClearBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClearBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnClearBook.setText("Mới");
        btnClearBook.setIconTextGap(10);
        btnClearBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearBookActionPerformed(evt);
            }
        });
        pnlBookForm.add(btnClearBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 310, 120, 50));

        btnAddBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        btnAddBook.setText("Thêm");
        btnAddBook.setIconTextGap(10);
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });
        pnlBookForm.add(btnAddBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 40, 120, 50));

        btnUpdateBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop.png"))); // NOI18N
        btnUpdateBook.setText("Sửa");
        btnUpdateBook.setIconTextGap(10);
        btnUpdateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBookActionPerformed(evt);
            }
        });
        pnlBookForm.add(btnUpdateBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 130, 120, 50));

        btnDeleteBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDeleteBook.setText("Xóa");
        btnDeleteBook.setIconTextGap(10);
        btnDeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookActionPerformed(evt);
            }
        });
        pnlBookForm.add(btnDeleteBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 220, 120, 50));

        pnlBooks.add(pnlBookForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1300, 420));

        pnlBookTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlBookTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlBookTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBook.setRowHeight(25);
        tblBook.setRowMargin(5);
        tblBook.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBook);

        pnlBookTable.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1260, 270));

        txtFindBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFindBook.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtFindBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindBookKeyReleased(evt);
            }
        });
        pnlBookTable.add(txtFindBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 630, 60));

        pnlBooks.add(pnlBookTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 1300, 380));

        tabs.addTab("SACH", pnlBooks);

        pnlStationery.setBackground(new java.awt.Color(255, 255, 255));
        pnlStationery.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlStationeryForm.setBackground(new java.awt.Color(255, 255, 255));
        pnlStationeryForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlStationeryForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlStationeryPic.setBackground(new java.awt.Color(255, 255, 255));
        pnlStationeryPic.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hình Ảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        lblStationeryImage.setBackground(new java.awt.Color(204, 204, 204));
        lblStationeryImage.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblStationeryImage.setForeground(new java.awt.Color(255, 255, 255));
        lblStationeryImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStationeryImage.setText("+");
        lblStationeryImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblStationeryImage.setOpaque(true);
        lblStationeryImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStationeryImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlStationeryPicLayout = new javax.swing.GroupLayout(pnlStationeryPic);
        pnlStationeryPic.setLayout(pnlStationeryPicLayout);
        pnlStationeryPicLayout.setHorizontalGroup(
            pnlStationeryPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStationeryPicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStationeryImage, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlStationeryPicLayout.setVerticalGroup(
            pnlStationeryPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStationeryPicLayout.createSequentialGroup()
                .addComponent(lblStationeryImage, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStationeryForm.add(pnlStationeryPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, 300));

        txtStationeryID.setEditable(false);
        txtStationeryID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStationeryID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlStationeryForm.add(txtStationeryID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 260, 70));

        pnlStationery_MoreInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlStationery_MoreInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlStationery_MoreInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStationeryMoreInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStationeryMoreInfo.setLineWrap(true);
        txtStationeryMoreInfo.setTabSize(2);
        jScrollPane9.setViewportView(txtStationeryMoreInfo);

        pnlStationery_MoreInfo.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 380, 320));

        pnlStationeryForm.add(pnlStationery_MoreInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, 400, 360));

        txtStationery_AddBy.setEditable(false);
        txtStationery_AddBy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtStationery_AddBy.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Được Thêm Bởi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlStationeryForm.add(txtStationery_AddBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 300, 70));

        txtStationery_Name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStationery_Name.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtStationery_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStationery_NameActionPerformed(evt);
            }
        });
        pnlStationeryForm.add(txtStationery_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 260, 70));

        pnlStationery_TypeOfProduct.setBackground(new java.awt.Color(255, 255, 255));
        pnlStationery_TypeOfProduct.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlStationery_TypeOfProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbbStationeryGenre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbStationeryGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbStationeryGenre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbbStationeryGenre.setOpaque(true);
        cbbStationeryGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbStationeryGenreActionPerformed(evt);
            }
        });
        pnlStationery_TypeOfProduct.add(cbbStationeryGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 40));

        pnlStationeryForm.add(pnlStationery_TypeOfProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 300, 70));

        btnAddStationery.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddStationery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        btnAddStationery.setText("Thêm");
        btnAddStationery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStationeryActionPerformed(evt);
            }
        });
        pnlStationeryForm.add(btnAddStationery, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 50));

        btnClearStationery.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClearStationery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnClearStationery.setText("Mới");
        btnClearStationery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearStationeryActionPerformed(evt);
            }
        });
        pnlStationeryForm.add(btnClearStationery, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 570, 50));

        btnUpdateStationery.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateStationery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop.png"))); // NOI18N
        btnUpdateStationery.setText("Sửa");
        btnUpdateStationery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStationeryActionPerformed(evt);
            }
        });
        pnlStationeryForm.add(btnUpdateStationery, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 120, 50));

        btnDeleteStationery.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteStationery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDeleteStationery.setText("Xóa");
        btnDeleteStationery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStationeryActionPerformed(evt);
            }
        });
        pnlStationeryForm.add(btnDeleteStationery, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 190, 140));

        pnlStationery_Barcode.setBackground(new java.awt.Color(255, 255, 255));
        pnlStationery_Barcode.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Vạch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlStationery_Barcode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStationeryBarcode.setBackground(new java.awt.Color(204, 204, 204));
        lblStationeryBarcode.setOpaque(true);
        pnlStationery_Barcode.add(lblStationeryBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 330, 80));

        pnlStationeryForm.add(pnlStationery_Barcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 370, 150));

        pnlStationery.add(pnlStationeryForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1300, 410));

        pnlStationeryTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlStationeryTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Văn Phòng Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlStationeryTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStationery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStationery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStationeryMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblStationery);

        pnlStationeryTable.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1260, 270));

        txtFindStationery.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFindStationery.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtFindStationery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindStationeryKeyReleased(evt);
            }
        });
        pnlStationeryTable.add(txtFindStationery, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 630, 60));

        pnlStationery.add(pnlStationeryTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 1300, 400));

        tabs.addTab("VAN PHONG PHAM", pnlStationery);

        pnlProviders.setBackground(new java.awt.Color(255, 255, 255));
        pnlProviders.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlProvidersTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlProvidersTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Nhà Cung Cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlProvidersTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProvider.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblProvider.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblProvider.setRowHeight(25);
        tblProvider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProviderMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblProvider);

        pnlProvidersTable.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1250, 300));

        txtFindProvider.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFindProvider.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtFindProvider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindProviderKeyReleased(evt);
            }
        });
        pnlProvidersTable.add(txtFindProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 620, 60));

        pnlProviders.add(pnlProvidersTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 1290, 440));

        pnlProvidersForm.setBackground(new java.awt.Color(255, 255, 255));
        pnlProvidersForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlProvidersForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProvider_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtProvider_Email.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlProvidersForm.add(txtProvider_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 320, 60));

        txtProvider_ID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtProvider_ID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Nhà Cung Cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlProvidersForm.add(txtProvider_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 320, 60));

        pnlProvider_ContractDate.setBackground(new java.awt.Color(255, 255, 255));
        pnlProvider_ContractDate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngày liên hệ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlProvider_ContractDate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProvider_ContractDate.setDateFormatString("dd-MM-yyyy");
        txtProvider_ContractDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlProvider_ContractDate.add(txtProvider_ContractDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 300, 30));

        pnlProvidersForm.add(pnlProvider_ContractDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 320, 60));

        pnlProvider_MoreInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlProvider_MoreInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlProvider_MoreInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProvider_MoreInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtProvider_MoreInfo.setLineWrap(true);
        txtProvider_MoreInfo.setTabSize(0);
        jScrollPane13.setViewportView(txtProvider_MoreInfo);

        pnlProvider_MoreInfo.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 170));

        pnlProvidersForm.add(pnlProvider_MoreInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 570, 220));

        btnRefreshProvider.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefreshProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnRefreshProvider.setText("Mới");
        btnRefreshProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshProviderActionPerformed(evt);
            }
        });
        pnlProvidersForm.add(btnRefreshProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 110, 40));

        btnAddProvider.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        btnAddProvider.setText("Thêm");
        btnAddProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProviderActionPerformed(evt);
            }
        });
        pnlProvidersForm.add(btnAddProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 110, 40));

        btnUpdateProvider.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop.png"))); // NOI18N
        btnUpdateProvider.setText("Sửa");
        btnUpdateProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProviderActionPerformed(evt);
            }
        });
        pnlProvidersForm.add(btnUpdateProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 110, 40));

        btnDeleteProvider.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDeleteProvider.setText("Xóa");
        btnDeleteProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProviderActionPerformed(evt);
            }
        });
        pnlProvidersForm.add(btnDeleteProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 110, 40));

        txtProviderName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtProviderName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên Nhà Cung Cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtProviderName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProviderNameKeyReleased(evt);
            }
        });
        pnlProvidersForm.add(txtProviderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 320, 60));

        txtAddressProvider.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAddressProvider.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Địa Chỉ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlProvidersForm.add(txtAddressProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 320, 60));

        txtNumPhoneProvider.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNumPhoneProvider.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Số Điện Thoại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtNumPhoneProvider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumPhoneProviderKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumPhoneProviderKeyTyped(evt);
            }
        });
        pnlProvidersForm.add(txtNumPhoneProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 320, 60));

        pnlProviders.add(pnlProvidersForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1290, 330));

        tabs.addTab("NHA CUNG CAP", pnlProviders);

        pnlCustomers.setBackground(new java.awt.Color(255, 255, 255));

        pnlListCustomer.setBackground(new java.awt.Color(255, 255, 255));
        pnlListCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlListCustomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblListCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblListCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblListCustomer.setRowHeight(25);
        tblListCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListCustomerMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblListCustomer);

        pnlListCustomer.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1310, 300));

        txtfindCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtfindCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtfindCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfindCustomerKeyReleased(evt);
            }
        });
        pnlListCustomer.add(txtfindCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 660, 60));

        pnlForm1.setBackground(new java.awt.Color(255, 255, 255));
        pnlForm1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIDCustomer.setEditable(false);
        txtIDCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm1.add(txtIDCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 590, 60));

        txtnameCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnameCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm1.add(txtnameCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 590, 60));

        txtadressCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtadressCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Địa Chỉ Khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm1.add(txtadressCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 650, 60));

        pnlmoreInforCustomer.setBackground(new java.awt.Color(255, 255, 255));
        pnlmoreInforCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlmoreInforCustomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtmoreInforeCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtmoreInforeCustomer.setLineWrap(true);
        txtmoreInforeCustomer.setRows(5);
        txtmoreInforeCustomer.setTabSize(0);
        jScrollPane12.setViewportView(txtmoreInforeCustomer);

        pnlmoreInforCustomer.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 590, 120));

        pnlForm1.add(pnlmoreInforCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 610, 160));

        btnnewCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnnewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnnewCustomer.setText("Mới");
        btnnewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewCustomerActionPerformed(evt);
            }
        });
        pnlForm1.add(btnnewCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 110, 50));

        btnaddCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnaddCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        btnaddCustomer.setText("Thêm");
        btnaddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddCustomerActionPerformed(evt);
            }
        });
        pnlForm1.add(btnaddCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 110, 50));

        btnfixCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnfixCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop.png"))); // NOI18N
        btnfixCustomer.setText("Sửa");
        btnfixCustomer.setEnabled(false);
        btnfixCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfixCustomerActionPerformed(evt);
            }
        });
        pnlForm1.add(btnfixCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 110, 50));

        btndeleteCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btndeleteCustomer.setText("Xóa");
        btndeleteCustomer.setEnabled(false);
        btndeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteCustomerActionPerformed(evt);
            }
        });
        pnlForm1.add(btndeleteCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 110, 50));

        txtnumberphoneCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnumberphoneCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Số Điện Thoại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm1.add(txtnumberphoneCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 590, 60));

        txtemailCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtemailCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm1.add(txtemailCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 650, 60));

        pnlmoreInforCustomer1.setBackground(new java.awt.Color(255, 255, 255));
        pnlmoreInforCustomer1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlmoreInforCustomer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtmoreInforeCustomer1.setColumns(20);
        txtmoreInforeCustomer1.setRows(5);
        jScrollPane3.setViewportView(txtmoreInforeCustomer1);

        pnlmoreInforCustomer1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 630, 140));

        pnlForm1.add(pnlmoreInforCustomer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 650, 170));

        javax.swing.GroupLayout pnlCustomersLayout = new javax.swing.GroupLayout(pnlCustomers);
        pnlCustomers.setLayout(pnlCustomersLayout);
        pnlCustomersLayout.setHorizontalGroup(
            pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlForm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlListCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        pnlCustomersLayout.setVerticalGroup(
            pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlListCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        tabs.addTab("KHACH HANG", pnlCustomers);

        pnlCustomers1.setBackground(new java.awt.Color(255, 255, 255));

        pnlListCustomer1.setBackground(new java.awt.Color(255, 255, 255));
        pnlListCustomer1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlListCustomer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblReceiptProducts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblReceiptProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblReceiptProducts.setRowHeight(25);
        tblReceiptProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReceiptProductsMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblReceiptProducts);

        pnlListCustomer1.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1300, 310));

        txtFindPrdReceipts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFindPrdReceipts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtFindPrdReceipts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindPrdReceiptsKeyReleased(evt);
            }
        });
        pnlListCustomer1.add(txtFindPrdReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 720, 60));

        chkStationery.setBackground(new java.awt.Color(255, 255, 255));
        chkStationery.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chkStationery.setText("VĂN PHÒNG PHẨM");
        chkStationery.setOpaque(true);
        chkStationery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkStationeryActionPerformed(evt);
            }
        });
        pnlListCustomer1.add(chkStationery, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 180, 60));

        chkBook.setBackground(new java.awt.Color(255, 255, 255));
        chkBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chkBook.setSelected(true);
        chkBook.setText("SÁCH");
        chkBook.setOpaque(true);
        chkBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBookActionPerformed(evt);
            }
        });
        pnlListCustomer1.add(chkBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, 60));

        pnlForm2.setBackground(new java.awt.Color(255, 255, 255));
        pnlForm2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtReceivedReceipts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtReceivedReceipts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tiền Khách Đưa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtReceivedReceipts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReceivedReceiptsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReceivedReceiptsKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReceivedReceiptsKeyTyped(evt);
            }
        });
        pnlForm2.add(txtReceivedReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, 210, 60));

        txtReceiptsIDReceipts.setEditable(false);
        txtReceiptsIDReceipts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtReceiptsIDReceipts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm2.add(txtReceiptsIDReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 230, 60));

        txtCreatedDayReceipts.setEditable(false);
        txtCreatedDayReceipts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCreatedDayReceipts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngày Bán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm2.add(txtCreatedDayReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 230, 60));

        btnCancelReceipts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnCancelReceipts.setText("Hủy");
        btnCancelReceipts.setIconTextGap(5);
        btnCancelReceipts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelReceiptsActionPerformed(evt);
            }
        });
        pnlForm2.add(btnCancelReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 310, 100, 50));

        txtTotalReceipts.setEditable(false);
        txtTotalReceipts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalReceipts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm2.add(txtTotalReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 120, 210, 60));

        txtCreatedBy.setEditable(false);
        txtCreatedBy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCreatedBy.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Người Tạo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlForm2.add(txtCreatedBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 230, 60));

        tblReceiptDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblReceiptDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ"
            }
        )
        {
            public boolean isCellEditable(int row, int col) {
                return col == 2;
            }
        }
    );
    tblReceiptDetails.setRowHeight(25);
    tblReceiptDetails.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblReceiptDetailsMouseClicked(evt);
        }
    });
    tblReceiptDetails.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            tblReceiptDetailsKeyReleased(evt);
        }
    });
    jScrollPane19.setViewportView(tblReceiptDetails);

    pnlForm2.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 420, 330));

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel1.setText("Chi Tiết Hóa Đơn");
    pnlForm2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

    btnaddnewReceipts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btnaddnewReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
    btnaddnewReceipts.setText("Mới");
    btnaddnewReceipts.setIconTextGap(5);
    btnaddnewReceipts.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnaddnewReceiptsActionPerformed(evt);
        }
    });
    pnlForm2.add(btnaddnewReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 310, 100, 50));

    btnViewReceipts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btnViewReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list.png"))); // NOI18N
    btnViewReceipts.setText("Xem DS");
    btnViewReceipts.setIconTextGap(5);
    btnViewReceipts.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnViewReceiptsActionPerformed(evt);
        }
    });
    pnlForm2.add(btnViewReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 310, 130, 50));

    btnPrintReceipts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btnPrintReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/printer.png"))); // NOI18N
    btnPrintReceipts.setText("In");
    btnPrintReceipts.setIconTextGap(5);
    btnPrintReceipts.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPrintReceiptsActionPerformed(evt);
        }
    });
    pnlForm2.add(btnPrintReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 310, 90, 50));

    txtReturnReceipts.setEditable(false);
    txtReturnReceipts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtReturnReceipts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tiền Thừa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlForm2.add(txtReturnReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 210, 210, 60));

    bill.setColumns(20);
    bill.setRows(5);
    jScrollPane5.setViewportView(bill);

    pnlForm2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 410, 330));

    javax.swing.GroupLayout pnlCustomers1Layout = new javax.swing.GroupLayout(pnlCustomers1);
    pnlCustomers1.setLayout(pnlCustomers1Layout);
    pnlCustomers1Layout.setHorizontalGroup(
        pnlCustomers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlCustomers1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pnlCustomers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(pnlListCustomer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlForm2, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE))
            .addContainerGap(219, Short.MAX_VALUE))
    );
    pnlCustomers1Layout.setVerticalGroup(
        pnlCustomers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomers1Layout.createSequentialGroup()
            .addComponent(pnlForm2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(pnlListCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(174, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pnlReceiptsLayout = new javax.swing.GroupLayout(pnlReceipts);
    pnlReceipts.setLayout(pnlReceiptsLayout);
    pnlReceiptsLayout.setHorizontalGroup(
        pnlReceiptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 1600, Short.MAX_VALUE)
        .addGroup(pnlReceiptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceiptsLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(pnlCustomers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE)))
    );
    pnlReceiptsLayout.setVerticalGroup(
        pnlReceiptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlReceiptsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(pnlCustomers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(pnlReceiptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE))
    );

    tabs.addTab("HOA DON", pnlReceipts);

    pnlChangePassword.setBackground(new java.awt.Color(255, 255, 255));

    pnlChangePasswordForm.setBackground(new java.awt.Color(255, 255, 255));
    pnlChangePasswordForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đổi Mật Khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlChangePasswordForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lblOldPassEye.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblOldPassEyeMouseClicked(evt);
        }
    });
    pnlChangePasswordForm.add(lblOldPassEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 40, 20));

    lblNewPassEye1.setText(" ");
    lblNewPassEye1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblNewPassEye1MouseClicked(evt);
        }
    });
    pnlChangePasswordForm.add(lblNewPassEye1, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 246, 40, 20));

    lblNewPassEye2.setText(" ");
    lblNewPassEye2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblNewPassEye2MouseClicked(evt);
        }
    });
    pnlChangePasswordForm.add(lblNewPassEye2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 40, 20));

    txtUsernameChange.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtUsernameChange.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên Đăng Nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    txtUsernameChange.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtUsernameChangeActionPerformed(evt);
        }
    });
    pnlChangePasswordForm.add(txtUsernameChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 600, 60));

    btnChangePass.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    btnChangePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset-password (1).png"))); // NOI18N
    btnChangePass.setText("Đổi Mật Khẩu");
    btnChangePass.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnChangePassActionPerformed(evt);
        }
    });
    pnlChangePasswordForm.add(btnChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 180, 50));

    txtNewPassword2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Xác Nhận Mật khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlChangePasswordForm.add(txtNewPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 530, 60));

    txtOldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mật Khẩu Cũ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlChangePasswordForm.add(txtOldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 530, 60));

    txtNewPassword1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mật Khẩu Mới", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlChangePasswordForm.add(txtNewPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 530, 60));

    javax.swing.GroupLayout pnlChangePasswordLayout = new javax.swing.GroupLayout(pnlChangePassword);
    pnlChangePassword.setLayout(pnlChangePasswordLayout);
    pnlChangePasswordLayout.setHorizontalGroup(
        pnlChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlChangePasswordLayout.createSequentialGroup()
            .addGap(337, 337, 337)
            .addComponent(pnlChangePasswordForm, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(603, Short.MAX_VALUE))
    );
    pnlChangePasswordLayout.setVerticalGroup(
        pnlChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlChangePasswordLayout.createSequentialGroup()
            .addGap(136, 136, 136)
            .addComponent(pnlChangePasswordForm, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(310, Short.MAX_VALUE))
    );

    tabs.addTab("DOI MAT KHAU", pnlChangePassword);

    pnlWarehouse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    pnlInventoryAll.setBorder(javax.swing.BorderFactory.createTitledBorder("Kho Hàng"));

    tabsInventory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

    pnlInventory1.setMaximumSize(new java.awt.Dimension(32767, 32700));

    txtFindInventory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txtFindInventory.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtFindInventoryKeyReleased(evt);
        }
    });

    tblInventory.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    jScrollPane8.setViewportView(tblInventory);

    jButton2.setText("CẬP NHẬT GIÁ BÁN");

    javax.swing.GroupLayout pnlInventory1Layout = new javax.swing.GroupLayout(pnlInventory1);
    pnlInventory1.setLayout(pnlInventory1Layout);
    pnlInventory1Layout.setHorizontalGroup(
        pnlInventory1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlInventory1Layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(pnlInventory1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(pnlInventory1Layout.createSequentialGroup()
                    .addComponent(txtFindInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(421, 421, 421)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(19, 55, Short.MAX_VALUE))
    );
    pnlInventory1Layout.setVerticalGroup(
        pnlInventory1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlInventory1Layout.createSequentialGroup()
            .addGap(75, 75, 75)
            .addGroup(pnlInventory1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtFindInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12))
    );

    tabsInventory.addTab("Tồn Kho", pnlInventory1);

    pnlWHRP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    pnlWareHouseReceiptsAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton7.setText("TẠO PHIẾU NHẬP");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });
    pnlWareHouseReceiptsAll.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 161, 40));

    pnlWareHouseReceiptsGenarel.setBorder(javax.swing.BorderFactory.createTitledBorder("PHIẾU NHẬP"));

    jLabel19.setText("MÃ PHIẾU NHẬP:");

    jLabel20.setText("TỔNG TIỀN:");

    jLabel21.setText("TRẠNG THÁI:");

    btnEditWarehouseReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
    btnEditWarehouseReceipts.setText("HỦY");
    btnEditWarehouseReceipts.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditWarehouseReceiptsActionPerformed(evt);
        }
    });

    jLabel5.setText("NGÀY TẠO:");

    jLabel6.setText("NHÀ CUNG CẤP: ");

    btnEditWarehouseReceipts2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop.png"))); // NOI18N
    btnEditWarehouseReceipts2.setText("CHỈNH SỬA");
    btnEditWarehouseReceipts2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditWarehouseReceipts2ActionPerformed(evt);
        }
    });

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list.png"))); // NOI18N
    jButton1.setText("LƯU");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pnlWareHouseReceiptsGenarelLayout = new javax.swing.GroupLayout(pnlWareHouseReceiptsGenarel);
    pnlWareHouseReceiptsGenarel.setLayout(pnlWareHouseReceiptsGenarelLayout);
    pnlWareHouseReceiptsGenarelLayout.setHorizontalGroup(
        pnlWareHouseReceiptsGenarelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlWareHouseReceiptsGenarelLayout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(pnlWareHouseReceiptsGenarelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel6)
                .addComponent(jLabel19))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(pnlWareHouseReceiptsGenarelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtWareHouseReceiptGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtProviderWareHouseReceipts, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlWareHouseReceiptsGenarelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWareHouseReceiptsGenarelLayout.createSequentialGroup()
                    .addComponent(jLabel20)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtTotalCostWareHouseReciepts, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWareHouseReceiptsGenarelLayout.createSequentialGroup()
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtReceivingDateGenarel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addGroup(pnlWareHouseReceiptsGenarelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(pnlWareHouseReceiptsGenarelLayout.createSequentialGroup()
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnEditWarehouseReceipts2))
                .addGroup(pnlWareHouseReceiptsGenarelLayout.createSequentialGroup()
                    .addComponent(jLabel21)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtCurrentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(btnEditWarehouseReceipts)
            .addContainerGap())
    );
    pnlWareHouseReceiptsGenarelLayout.setVerticalGroup(
        pnlWareHouseReceiptsGenarelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlWareHouseReceiptsGenarelLayout.createSequentialGroup()
            .addGap(7, 7, 7)
            .addGroup(pnlWareHouseReceiptsGenarelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel19)
                .addComponent(txtWareHouseReceiptGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel21)
                .addComponent(txtCurrentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5)
                .addComponent(txtReceivingDateGenarel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnEditWarehouseReceipts, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
            .addGroup(pnlWareHouseReceiptsGenarelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(txtProviderWareHouseReceipts, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel20)
                .addComponent(txtTotalCostWareHouseReciepts, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnEditWarehouseReceipts2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(8, 8, 8))
    );

    pnlWareHouseReceiptsAll.add(pnlWareHouseReceiptsGenarel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1170, -1));

    jButton10.setText("TẤT CẢ PHIẾU NHẬP");
    jButton10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton10ActionPerformed(evt);
        }
    });
    pnlWareHouseReceiptsAll.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 161, 41));

    pnlWareHouseReceiptsDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("CHI TIẾT SẢN PHẨM"));
    pnlWareHouseReceiptsDetails.setPreferredSize(new java.awt.Dimension(1076, 500));
    pnlWareHouseReceiptsDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tblProductWarehouseReceipt.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    tblProductWarehouseReceipt.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblProductWarehouseReceiptMouseClicked(evt);
        }
    });
    jScrollPane25.setViewportView(tblProductWarehouseReceipt);

    pnlWareHouseReceiptsDetails.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 450, 490));

    txtSearchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtSearchProductKeyReleased(evt);
        }
    });
    pnlWareHouseReceiptsDetails.add(txtSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 370, 30));

    tblProductDetails.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    tblProductDetails.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            tblProductDetailsPropertyChange(evt);
        }
    });
    jScrollPane26.setViewportView(tblProductDetails);

    pnlWareHouseReceiptsDetails.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 770, 490));

    jButton11.setText("THÊM");
    jButton11.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton11ActionPerformed(evt);
        }
    });
    pnlWareHouseReceiptsDetails.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 70, 30));

    jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel22.setText("CHI TIẾT SẢN PHẨM");
    pnlWareHouseReceiptsDetails.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, -1, -1));

    jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
    jButton12.setText("XÓA");
    jButton12.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton12ActionPerformed(evt);
        }
    });
    pnlWareHouseReceiptsDetails.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 60, -1, 30));

    jLabel7.setText("TÌM KIẾM SẢN PHẨM");
    pnlWareHouseReceiptsDetails.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

    pnlWareHouseReceiptsAll.add(pnlWareHouseReceiptsDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 131, 1330, 650));

    pnlWareHouseReceiptsTableAll.setBorder(javax.swing.BorderFactory.createTitledBorder("DANH SÁCH PHIẾU NHẬP"));
    pnlWareHouseReceiptsTableAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tblWarehouseReceiptsAll.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    tblWarehouseReceiptsAll.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblWarehouseReceiptsAllMouseClicked(evt);
        }
    });
    jScrollPane27.setViewportView(tblWarehouseReceiptsAll);

    pnlWareHouseReceiptsTableAll.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 99, 1290, 520));

    txtSearchWarehouseReceipt.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtSearchWarehouseReceiptKeyReleased(evt);
        }
    });
    pnlWareHouseReceiptsTableAll.add(txtSearchWarehouseReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, 578, 42));

    jButton5.setText("CHỈNH SỬA");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });
    pnlWareHouseReceiptsTableAll.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 60, 100, 30));

    jButton6.setText("XEM");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton6ActionPerformed(evt);
        }
    });
    pnlWareHouseReceiptsTableAll.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 100, 30));

    jButton4.setText("XÓA");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });
    pnlWareHouseReceiptsTableAll.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 60, 100, 30));

    pnlWareHouseReceiptsAll.add(pnlWareHouseReceiptsTableAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 137, 1340, 640));

    pnlWareHouseReceipts.setBorder(javax.swing.BorderFactory.createTitledBorder("PHIẾU NHẬP"));
    pnlWareHouseReceipts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lblWaring.setText("* ĐỂ TRỐNG SẼ TỰ ĐỘNG SINH");
    pnlWareHouseReceipts.add(lblWaring, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));
    pnlWareHouseReceipts.add(txtWareHouseReceiptsID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 392, 31));

    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel14.setText("MÃ PHIẾU NHẬP");
    pnlWareHouseReceipts.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 45, -1, -1));

    jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel15.setText("NGÀY NHẬP");
    pnlWareHouseReceipts.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 105, -1, -1));
    pnlWareHouseReceipts.add(txtReceivingDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 370, 31));

    jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel16.setText("NHÀ CUNG CẤP");
    pnlWareHouseReceipts.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 45, 120, -1));
    pnlWareHouseReceipts.add(cboProviders, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 392, 31));

    jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel17.setText("TRẠNG THÁI");
    pnlWareHouseReceipts.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, -1, -1));

    jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel18.setText("GHI CHÚ");
    pnlWareHouseReceipts.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 160, -1, -1));

    txtDecriptionWareHouse.setColumns(20);
    txtDecriptionWareHouse.setRows(5);
    jScrollPane24.setViewportView(txtDecriptionWareHouse);

    pnlWareHouseReceipts.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 930, -1));

    btnVerifyWareHouse.setText("XÁC NHẬN ");
    btnVerifyWareHouse.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnVerifyWareHouseActionPerformed(evt);
        }
    });
    pnlWareHouseReceipts.add(btnVerifyWareHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 207, 40));

    DateChoosen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            DateChoosenPropertyChange(evt);
        }
    });
    pnlWareHouseReceipts.add(DateChoosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 100, 21, 32));

    groupCurrentStatusWarehouseReceipt.add(rdoUnpaid);
    rdoUnpaid.setText("CHƯA THANH TOÁN");
    pnlWareHouseReceipts.add(rdoUnpaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

    groupCurrentStatusWarehouseReceipt.add(rdoPaid);
    rdoPaid.setText("ĐÃ THANH TOÁN");
    rdoPaid.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            rdoPaidMouseClicked(evt);
        }
    });
    pnlWareHouseReceipts.add(rdoPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, -1));

    jButton3.setText("HỦY");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    pnlWareHouseReceipts.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 360, 60, 40));

    pnlWareHouseReceiptsAll.add(pnlWareHouseReceipts, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 227, 1170, 420));

    pnlWHRP.add(pnlWareHouseReceiptsAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(-15, 6, 1400, 770));

    tabsInventory.addTab("Nhập Kho ", pnlWHRP);

    javax.swing.GroupLayout pnlInventoryAllLayout = new javax.swing.GroupLayout(pnlInventoryAll);
    pnlInventoryAll.setLayout(pnlInventoryAllLayout);
    pnlInventoryAllLayout.setHorizontalGroup(
        pnlInventoryAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlInventoryAllLayout.createSequentialGroup()
            .addComponent(tabsInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    pnlInventoryAllLayout.setVerticalGroup(
        pnlInventoryAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlInventoryAllLayout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addComponent(tabsInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pnlWarehouse.add(pnlInventoryAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1390, 850));

    tabs.addTab("KHO", pnlWarehouse);

    pnlStatistics.setBackground(new java.awt.Color(255, 255, 255));
    pnlStatistics.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    pnlStatisticsForm.setBackground(new java.awt.Color(255, 255, 255));
    pnlStatisticsForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doanh Thu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlStatisticsForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tblStatistics.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    jScrollPane15.setViewportView(tblStatistics);

    pnlStatisticsForm.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 217, 440, 570));

    btnStatisticsReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
    btnStatisticsReset.setText("RESET");
    btnStatisticsReset.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnStatisticsResetActionPerformed(evt);
        }
    });
    pnlStatisticsForm.add(btnStatisticsReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 110, 40));

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Từ Ngày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

    startDate.setDateFormatString("dd-MM-yyyy");
    startDate.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            startDateMouseClicked(evt);
        }
    });
    startDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            startDatePropertyChange(evt);
        }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(16, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 13, Short.MAX_VALUE))
    );

    pnlStatisticsForm.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, 80));

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đến Ngày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

    endDate.setDateFormatString("dd-MM-yyyy");
    endDate.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            endDateMouseClicked(evt);
        }
    });
    endDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            endDatePropertyChange(evt);
        }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(17, 17, 17)
            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 13, Short.MAX_VALUE))
    );

    pnlStatisticsForm.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 270, 80));

    pnlStatistics.add(pnlStatisticsForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 480, 810));

    pnlChart.setBackground(new java.awt.Color(255, 255, 255));
    pnlChart.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Biểu Đồ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlChart.setLayout(new java.awt.BorderLayout());
    pnlStatistics.add(pnlChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 800, 810));

    tabs.addTab("THONG KE", pnlStatistics);

    pnlEmployees.setBackground(new java.awt.Color(255, 255, 255));
    pnlEmployees.setPreferredSize(new java.awt.Dimension(1080, 950));
    pnlEmployees.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    pnlEmployeesTable.setBackground(new java.awt.Color(255, 255, 255));
    pnlEmployeesTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlEmployeesTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tblEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null}
        },
        new String [] {
            "MÃ NHÂN VIÊN", "HỌ VÀ TÊN", "TÊN ĐĂNG NHẬP", "GIỚI TÍNH", "NGÀY SINH", "CHỨC VỤ", "EMAIL", "ĐIỆN THOẠI", "GHI CHÚ"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    tblEmployees.setRowHeight(25);
    tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblEmployeesMouseClicked(evt);
        }
    });
    jScrollPane7.setViewportView(tblEmployees);

    pnlEmployeesTable.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1260, 250));

    txtFindEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtFindEmployees.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    txtFindEmployees.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtFindEmployeesKeyReleased(evt);
        }
    });
    pnlEmployeesTable.add(txtFindEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1260, 60));

    pnlEmployees.add(pnlEmployeesTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 1300, 380));

    pnlEmployeesForm.setBackground(new java.awt.Color(255, 255, 255));
    pnlEmployeesForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlEmployeesForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lblPassword2.setText(" ");
    lblPassword2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblPassword2MouseClicked(evt);
        }
    });
    pnlEmployeesForm.add(lblPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 40, 20));

    lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hide.png"))); // NOI18N
    lblPassword.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblPasswordMouseClicked(evt);
        }
    });
    pnlEmployeesForm.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 40, 20));

    txtEmployeesName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtEmployeesName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Họ Và Tên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlEmployeesForm.add(txtEmployeesName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 600, 60));

    txtPhoneNumberEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtPhoneNumberEmployees.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điện Thoại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlEmployeesForm.add(txtPhoneNumberEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 300, 60));

    pnlDateOfBirth.setBackground(new java.awt.Color(255, 255, 255));
    pnlDateOfBirth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngày Sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlDateOfBirth.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    dateOfBirth.setDateFormatString("dd-MM-yyyy");
    dateOfBirth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    dateOfBirth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            dateOfBirthPropertyChange(evt);
        }
    });
    dateOfBirth.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
        public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
            dateOfBirthVetoableChange(evt);
        }
    });
    pnlDateOfBirth.add(dateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, 30));

    pnlEmployeesForm.add(pnlDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 290, 60));

    pnlEmployeesRole.setBackground(new java.awt.Color(255, 255, 255));
    pnlEmployeesRole.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlEmployeesRole.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    rdoManager.setBackground(new java.awt.Color(255, 255, 255));
    GroupRole.add(rdoManager);
    rdoManager.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    rdoManager.setText("Quản Lý");
    pnlEmployeesRole.add(rdoManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

    rdoEmployees.setBackground(new java.awt.Color(255, 255, 255));
    GroupRole.add(rdoEmployees);
    rdoEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    rdoEmployees.setText("Nhân Viên");
    pnlEmployeesRole.add(rdoEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

    pnlEmployeesForm.add(pnlEmployeesRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 600, 60));

    btnClearEmployees.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btnClearEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
    btnClearEmployees.setText("Mới");
    btnClearEmployees.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnClearEmployeesActionPerformed(evt);
        }
    });
    pnlEmployeesForm.add(btnClearEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 390, 110, 40));

    btnAddEmployees.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btnAddEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
    btnAddEmployees.setText("Thêm");
    btnAddEmployees.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddEmployeesActionPerformed(evt);
        }
    });
    pnlEmployeesForm.add(btnAddEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 110, 40));

    btnUpdateEmployees.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btnUpdateEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loop.png"))); // NOI18N
    btnUpdateEmployees.setText("Sửa");
    btnUpdateEmployees.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUpdateEmployeesActionPerformed(evt);
        }
    });
    pnlEmployeesForm.add(btnUpdateEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 110, 40));

    btnDeleteEmployees.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btnDeleteEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
    btnDeleteEmployees.setText("Xóa");
    btnDeleteEmployees.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteEmployeesActionPerformed(evt);
        }
    });
    pnlEmployeesForm.add(btnDeleteEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 110, 40));

    txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên Đăng Nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlEmployeesForm.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 600, 60));

    pnlGender.setBackground(new java.awt.Color(255, 255, 255));
    pnlGender.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giới Tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlGender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    rdoMale.setBackground(new java.awt.Color(255, 255, 255));
    GroupGender.add(rdoMale);
    rdoMale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    rdoMale.setText("Nam");
    pnlGender.add(rdoMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

    rdoFemale.setBackground(new java.awt.Color(255, 255, 255));
    GroupGender.add(rdoFemale);
    rdoFemale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    rdoFemale.setText("Nữ");
    pnlGender.add(rdoFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

    pnlEmployeesForm.add(pnlGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 600, 60));

    txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlEmployeesForm.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 600, 60));

    pnlEmployeesMoreInfo.setBackground(new java.awt.Color(255, 255, 255));
    pnlEmployeesMoreInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    pnlEmployeesMoreInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    txtEmployeesMoreInfo.setColumns(20);
    txtEmployeesMoreInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtEmployeesMoreInfo.setRows(5);
    jScrollPane22.setViewportView(txtEmployeesMoreInfo);

    pnlEmployeesMoreInfo.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 580, 150));

    pnlEmployeesForm.add(pnlEmployeesMoreInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 600, 200));

    txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mật Khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    txtPassword.setEchoChar('*');
    pnlEmployeesForm.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 250, 60));

    txtPassword2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Xác Nhận Mật Khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
    txtPassword2.setEchoChar('*');
    pnlEmployeesForm.add(txtPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 250, 60));

    pnlEmployees.add(pnlEmployeesForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1300, 440));

    tabs.addTab("NHAN VIEN", pnlEmployees);

    getContentPane().add(tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(-11, 0, 1800, 1050));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookActionPerformed
        if (!isBookFormHasError()) {
            try {
                // TODO add your handling code here:
                insertNewBook();
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddBookActionPerformed

    private void btnClearBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearBookActionPerformed
        clearBookForm();
    }//GEN-LAST:event_btnClearBookActionPerformed

    private void btnDeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookActionPerformed
        String id = txtBookID.getText();
        try {
            deleteBook(id);
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteBookActionPerformed

    private void tblBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                int row = tblBook.getSelectedRow();
                String id = tblBook.getValueAt(row, 0).toString();
                Products p = prodDAO.selectById(id).get(0);
                setBookForm(p);
                btnUpdateBook.setEnabled(true);
                btnDeleteBook.setEnabled(Auth.isManager() ? true : false);
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblBookMouseClicked

    private void lblBookImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookImageMouseClicked
        pickImage(lblBookImage);
    }//GEN-LAST:event_lblBookImageMouseClicked

    private void btnUpdateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBookActionPerformed
        try {
            if (!isBookFormHasError()) {
                updateBook();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateBookActionPerformed

    private void btnfixCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfixCustomerActionPerformed
        try {
            updateCustomer();
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnfixCustomerActionPerformed

    private void tblListCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListCustomerMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                int row = tblListCustomer.getSelectedRow();
                int id = (int) tblListCustomer.getValueAt(row, 0);
                CustomerID = id;
                Customer cus = cusDAO.selectById(id).get(0);
                setFormCustomer(cus);
                btnfixCustomer.setEnabled(true);
                btndeleteCustomer.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblListCustomerMouseClicked

    private void txtfindCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfindCustomerKeyReleased
        try {
            this.findCustomer();
        } catch (SQLException ex) {
            MsgBox.alert(this, "Lỗi truy xuất dữ liệu !");
        }
    }//GEN-LAST:event_txtfindCustomerKeyReleased

    private void tblProviderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProviderMouseClicked
        if (evt.getClickCount() == 2) {
            this.rowProv = tblProvider.getSelectedRow();
            this.editProvider();
        }
    }//GEN-LAST:event_tblProviderMouseClicked

    private void txtFindProviderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindProviderKeyReleased
        try {
            this.findProvider();
        } catch (SQLException ex) {
            MsgBox.alert(this, "Lỗi truy xuất dữ liệu !");
        }
    }//GEN-LAST:event_txtFindProviderKeyReleased

    private void btnRefreshProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshProviderActionPerformed
        this.clearFormProvider();
    }//GEN-LAST:event_btnRefreshProviderActionPerformed

    private void btnAddProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProviderActionPerformed
        if (!checkErrorProv() && !checkContractDate()) {
            this.insertProvider();
        }
    }//GEN-LAST:event_btnAddProviderActionPerformed

    private void btnUpdateProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProviderActionPerformed
        if (!checkErrorProv() && !checkContractDate()) {
            this.updateProvider();
        }
    }//GEN-LAST:event_btnUpdateProviderActionPerformed

    private void btnDeleteProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProviderActionPerformed
        this.deleteProvider();
    }//GEN-LAST:event_btnDeleteProviderActionPerformed

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblEmployees.getSelectedRow();
            rowEmp = (int) tblEmployees.getValueAt(row, 0);
            this.editEmployees();
        }
    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void txtFindEmployeesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindEmployeesKeyReleased
        try {
            this.findEmployees();
        } catch (SQLException ex) {
            MsgBox.alert(this, "Lỗi truy xuất dữ liệu !");
        }
    }//GEN-LAST:event_txtFindEmployeesKeyReleased

    private void lblOldPassEyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOldPassEyeMouseClicked
        if (txtOldPassword.getEchoChar() != 0) {
            txtOldPassword.setEchoChar((char) 0); // Hiện mật khẩu
            ImageIcon icon = new ImageIcon("src//img//view.png");
            lblOldPassEye.setIcon(icon);
        } else {
            txtOldPassword.setEchoChar('*'); // Ẩn mật khẩu
            ImageIcon icon = new ImageIcon("src//img//hide.png");
            lblOldPassEye.setIcon(icon);
        }
    }//GEN-LAST:event_lblOldPassEyeMouseClicked

    private void lblNewPassEye1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewPassEye1MouseClicked
        if (txtNewPassword1.getEchoChar() != 0) {
            txtNewPassword1.setEchoChar((char) 0); // Hiện mật khẩu
            ImageIcon icon = new ImageIcon("src//img//view.png");
            lblNewPassEye1.setIcon(icon);
        } else {
            txtNewPassword1.setEchoChar('*'); // Ẩn mật khẩu
            ImageIcon icon = new ImageIcon("src//img//hide.png");
            lblNewPassEye1.setIcon(icon);
        }
    }//GEN-LAST:event_lblNewPassEye1MouseClicked

    private void lblNewPassEye2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewPassEye2MouseClicked
        if (txtNewPassword2.getEchoChar() != 0) {
            txtNewPassword2.setEchoChar((char) 0); // Hiện mật khẩu
            ImageIcon icon = new ImageIcon("src//img//view.png");
            lblNewPassEye2.setIcon(icon);
        } else {
            txtNewPassword2.setEchoChar('*'); // Ẩn mật khẩu
            ImageIcon icon = new ImageIcon("src//img//hide.png");
            lblNewPassEye2.setIcon(icon);
        }
    }//GEN-LAST:event_lblNewPassEye2MouseClicked

    private void txtUsernameChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameChangeActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        if (!checkEmployeesChange()) {
            String userName = txtUsername.getText();
            String oldPass = new String(txtOldPassword.getPassword());
            String newPass1 = new String(txtNewPassword1.getPassword());
            String newPass2 = new String(txtNewPassword2.getPassword());
            if (!oldPass.equals(Auth.user.getEmployeePassword())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Sai mật khẩu!");
            } else if (!newPass1.equals(newPass2)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Xác nhận mật khẩu không đúng!");
            } else {
                Auth.user.setEmployeePassword(newPass1);
                empDAO.update(Auth.user);
                MessageAlerts.getInstance().showMessage("TheBookStore", "Đổi mật khẩu thành công!", MessageAlerts.MessageType.SUCCESS);
            }
        }
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        // TODO add your handling code here:
        tabs.setSelectedIndex(9);
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWarehouseActionPerformed
        // TODO add your handling code here:
        tabs.setSelectedIndex(8);
    }//GEN-LAST:event_btnWarehouseActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        // TODO add your handling code here:
        tabs.setSelectedIndex(7);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesActionPerformed

        tabs.setSelectedIndex(10);

    }//GEN-LAST:event_btnEmployeesActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        // TODO add your handling code here:
        tabs.setSelectedIndex(5);
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceiptsActionPerformed
        // TODO add your handling code here:
        tabs.setSelectedIndex(6);
    }//GEN-LAST:event_btnReceiptsActionPerformed

    private void btnProvidersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvidersActionPerformed
        // TODO add your handling code here:
        tabs.setSelectedIndex(4);
    }//GEN-LAST:event_btnProvidersActionPerformed

    private void btnStationeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStationeryActionPerformed
        // TODO add your handling code here:
        tabs.setSelectedIndex(3);
    }//GEN-LAST:event_btnStationeryActionPerformed

    private void btnBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksActionPerformed
        // TODO add your handling code here:
        tabs.setSelectedIndex(2);
    }//GEN-LAST:event_btnBooksActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtFindBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindBookKeyReleased
        try {
            // TODO add your handling code here:
            String columns[] = {"MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "TÁC GIẢ", "NXB", "THỂ LOẠI"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            List<Products> list = prodDAO.selectBookByIdOrName(txtFindBook.getText(), txtFindBook.getText());
            for (Products p : list) {
                Object row[] = new Object[]{p.getID(), p.getProductName(),
                    p.getAuthor(), p.getPublisher(), p.getGenre()};
                model.addRow(row);

            }
            tblBook.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFindBookKeyReleased

    @Override
    public int checkImage(Image image, ImageObserver observer) {
        return super.checkImage(image, observer); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    boolean check = false;


    private void btnaddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddCustomerActionPerformed
        try {
            addCustomer();

        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddCustomerActionPerformed

    private void btnnewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewCustomerActionPerformed
        try {
            refeshCustomer();
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnnewCustomerActionPerformed

    private void chkStationeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkStationeryActionPerformed
        try {
            // TODO add your handling code here:
            fillProducts();
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkStationeryActionPerformed

    private void chkBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBookActionPerformed
        try {
            // TODO add your handling code here:
            fillProducts();
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkBookActionPerformed

    private void tblReceiptProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReceiptProductsMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            try {
                int row = tblReceiptProducts.getSelectedRow();
                float sellingPrice = 0;
                if (tblReceiptProducts.getValueAt(row, 5) != null) {
                    if (tblReceiptProducts.getValueAt(row, 4) != null && !tblReceiptProducts.getValueAt(row, 4).toString().equals("0")) {
                        sellingPrice = Float.parseFloat(tblReceiptProducts.getValueAt(row, 5).toString());
                        String productID = tblReceiptProducts.getValueAt(row, 0).toString();
                        String inventoryID = tblReceiptProducts.getValueAt(row, 6).toString();

                        // Insert whenever user clicks a product
                        ReceiptDetails re = new ReceiptDetails();
                        re.setID(generateRandomCode());
                        re.setInventoryID(inventoryID);
                        re.setReceiptID(txtReceiptsIDReceipts.getText());
                        re.setSellingPrice(sellingPrice);
                        if (recDetailDAO.isDuplicate(inventoryID, re.getReceiptID())) {
                            String id = recDetailDAO.getPreviousID(inventoryID, re.getReceiptID());
                            ReceiptDetails oldRe = recDetailDAO.selectById(id, txtReceiptsIDReceipts.getText());
                            int quan = oldRe.getQuantity() + 1;
                            oldRe.setQuantity(quan);
                            recDetailDAO.update(oldRe);
                        } else {
                            re.setQuantity(1);
                            recDetailDAO.insert(re);
                        }
                        Inventory i = receiveIntoInventory.selectById(inventoryID);
                        i.setAvaiableQuantity(i.getAvaiableQuantity() - re.getQuantity());
                        receiveIntoInventory.update(i);
                        tblReceiptProducts.setValueAt(i.getAvaiableQuantity(), row, 4);
                        storedList = recDetailDAO.selectAll(txtReceiptsIDReceipts.getText());

                        // Fill the table
                        fillDetailByReceiptID(txtReceiptsIDReceipts.getText());
                    } else {
                        MessageAlerts.getInstance().showMessage("THE BOOKSTORE", "Số lượng sản phẩm không đủ!", MessageAlerts.MessageType.WARNING);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_tblReceiptProductsMouseClicked

    private void btnaddnewReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnewReceiptsActionPerformed
        try {
            Receipts r = receiptDAO.selectById(txtReceiptsIDReceipts.getText());
            r.setCurrentStatus("Chưa thanh toán");
            r.setCreateDate(new java.sql.Timestamp(r.getCreateDate().getTime()));
            receiptDAO.update(r);
            renewReceipt();
            btnCancelReceipts.setEnabled(true);
            btnPrintReceipts.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddnewReceiptsActionPerformed

    private void txtReceivedReceiptsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReceivedReceiptsKeyReleased
        if (Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == evt.VK_BACK_SPACE) {
            String textField = txtReceivedReceipts.getText();
            if (textField.isBlank() || textField.startsWith("0")) {
                txtReceivedReceipts.setText("");
            } else {
                String input = textField + "000";
                BigDecimal money = new BigDecimal(input);
                try {
                    Receipts r = receiptDAO.selectById(txtReceiptsIDReceipts.getText());
                    r.setMoneyReceived(Float.parseFloat(input));
                    r.setCreateDate(new java.sql.Timestamp(r.getCreateDate().getTime()));
                    receiptDAO.update(r);
                } catch (SQLException ex) {
                    Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                txtReceivedReceipts.setText(vndFormatter.format(money));
                calReturnedMoney();
                addProductsToBill();
            }

        }
    }//GEN-LAST:event_txtReceivedReceiptsKeyReleased

    private void txtReceivedReceiptsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReceivedReceiptsKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtReceivedReceiptsKeyTyped

    private void txtReceivedReceiptsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReceivedReceiptsKeyPressed
        String textField = txtReceivedReceipts.getText().replace(".", "");
        if (!textField.isBlank()) {
            String moneyWithoutThoudsand = textField.replace("000 ₫", "");
            txtReceivedReceipts.setText(moneyWithoutThoudsand);
        } else {
            txtReceivedReceipts.setText("");
        }

    }//GEN-LAST:event_txtReceivedReceiptsKeyPressed

    private void btnCancelReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelReceiptsActionPerformed
        receiptDAO.delete(txtReceiptsIDReceipts.getText());
        updateQuantityOnChange();
        if (storedList != null) {
            storedList.clear();
        }
        try {
            fillProducts();
            renewReceipt();
            addProductsToBill();
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelReceiptsActionPerformed


    private void btnPrintReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintReceiptsActionPerformed
        try {
            bill.print();
            Receipts r = receiptDAO.selectById(txtReceiptsIDReceipts.getText());
            r.setCurrentStatus("Đã thanh toán");
            receiptDAO.update(r);
            renewReceipt();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnPrintReceiptsActionPerformed

    private void txtFindPrdReceiptsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindPrdReceiptsKeyReleased
        String input = txtFindPrdReceipts.getText();
        if (input.isBlank()) {
            try {
                fillProducts();
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Map<Integer, String[]> map;
            try {
                map = prodDAO.selectByProductId(txtFindPrdReceipts.getText());
                String columns[] = {"MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "LOẠI SẢN PHẨM", "THỂ LOẠI", "SỐ LƯỢNG TỒN", "GIÁ BÁN", "MÃ NHẬP KHO"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                for (int i = 0, n = map.size(); i < n; i++) {
                    String row[] = map.get(i);
                    model.addRow(row);
                }
                tblReceiptProducts.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtFindPrdReceiptsKeyReleased

    private void tblReceiptDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReceiptDetailsMouseClicked
        int col = tblReceiptDetails.getSelectedColumn();
        int row = tblReceiptDetails.getSelectedRow();
        tblReceiptDetails.getModel().isCellEditable(row, col);

        if (!tblReceiptDetails.isEditing()) {
            updateQuantityInReceiptDetails();
            try {
                sumTotalCost();
                addProductsToBill();
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblReceiptDetailsMouseClicked

    private void tblReceiptDetailsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblReceiptDetailsKeyReleased
        if (evt.getKeyCode() == evt.VK_DELETE) {
            try {
                int row = tblReceiptDetails.getSelectedRow();
//                tblReceiptDetails.getCellEditor().stopCellEditing();
                List<ReceiptDetails> list = recDetailDAO.selectAll(txtReceiptsIDReceipts.getText());
                String id = list.get(row).getID();
                recDetailDAO.delete(id);
                DefaultTableModel model = (DefaultTableModel) tblReceiptDetails.getModel();
                model.removeRow(row);
                model.setRowCount(0);
                list.remove(row);
                for (ReceiptDetails rd : list) {
                    Object rows[] = new Object[]{recDetailDAO.fromInventoryToProduct(rd.getInventoryID()),
                        recDetailDAO.toProductName(rd.getInventoryID()), rd.getQuantity(), rd.getSellingPrice()};
                    model.addRow(rows);
                }
                tblReceiptDetails.setModel(model);

                int quan = storedList.get(row).getQuantity();
                Inventory i = receiveIntoInventory.selectById(storedList.get(row).getInventoryID());
                i.setAvaiableQuantity(quan + i.getAvaiableQuantity());
                receiveIntoInventory.update(i);
                fillProducts();

            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Update values if user presses enter
        if (evt.getKeyCode() == evt.VK_ENTER) {
            updateQuantityInReceiptDetails();
            try {
                fillProducts();
                sumTotalCost();
                addProductsToBill();
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblReceiptDetailsKeyReleased

    private void btnViewReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReceiptsActionPerformed
        try {
            // TODO add your handling code here:
            ViewReceipts view = new ViewReceipts(this, true);
            view.setVisible(true);
            if (!view.isDisplayable() && !view.reID.equals("")) {
                txtReceiptsIDReceipts.setText(view.reID);
                fillDetailByReceiptID(view.reID);
                tblReceiptDetails.setEnabled(!view.status.equalsIgnoreCase("Đã thanh toán"));
                txtReceivedReceipts.setEditable(!view.status.equalsIgnoreCase("Đã thanh toán"));
                bill.setEditable(!view.status.equalsIgnoreCase("Đã thanh toán"));
                btnCancelReceipts.setEnabled(false);
                btnPrintReceipts.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnViewReceiptsActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        createWareHouseReceipts();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnEditWarehouseReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditWarehouseReceiptsActionPerformed
        refeshIfNoChange();
    }//GEN-LAST:event_btnEditWarehouseReceiptsActionPerformed

    private void btnEditWarehouseReceipts2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditWarehouseReceipts2ActionPerformed
        editWareHouseReceiptsPrimary();
    }//GEN-LAST:event_btnEditWarehouseReceipts2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checkValid()) {
            addProductDetailsAndReceiveIntoInventory(getTableProductDetails());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        openAllWareHouseReceipts();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tblProductWarehouseReceiptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductWarehouseReceiptMouseClicked
        tblProductWarehouseReceipt.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_tblProductWarehouseReceiptMouseClicked

    private void txtSearchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchProductKeyReleased
        try {
            loadDateTblProductWarehouseReceipts(prodDAO.spSearchProduct(txtSearchProduct.getText()));
            if (txtSearchProduct.getText().equals("")) {
                RenderProduct(listAllRemove);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchProductKeyReleased

    private void tblProductDetailsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblProductDetailsPropertyChange
        sumPrice();
    }//GEN-LAST:event_tblProductDetailsPropertyChange

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        addProductIntoProductDetails();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        deleteProductDetails();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tblWarehouseReceiptsAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWarehouseReceiptsAllMouseClicked
        tblWarehouseReceiptsAll.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_tblWarehouseReceiptsAllMouseClicked

    private void txtSearchWarehouseReceiptKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchWarehouseReceiptKeyReleased
        searchWarehouseReceiptID(txtSearchWarehouseReceipt.getText());
    }//GEN-LAST:event_txtSearchWarehouseReceiptKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            editWarehouseReceiptsRow(tblWarehouseReceiptsAll.getSelectedRow());
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            if (tblWarehouseReceiptsAll.getSelectedRow() != -1) {
                loadDataReport(tblWarehouseReceiptsAll.getSelectedRow());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int[] rows = tblWarehouseReceiptsAll.getSelectedRows();
        if (rows.length > 0) {
            deleteWarehouseReceipts(rows);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnVerifyWareHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyWareHouseActionPerformed
        vefifyWareHouseReceipts();
    }//GEN-LAST:event_btnVerifyWareHouseActionPerformed

    private void DateChoosenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DateChoosenPropertyChange
        if (DateChoosen.getDate() != null) {
            txtReceivingDate.setText(XDate.toString(DateChoosen.getDate(), "dd-MM-yyyy"));
        }
    }//GEN-LAST:event_DateChoosenPropertyChange

    private void rdoPaidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoPaidMouseClicked
        rdoPaid.setSelected(true);
        rdoUnpaid.setSelected(false);
    }//GEN-LAST:event_rdoPaidMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        refeshIfNoChange();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lblPassword2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPassword2MouseClicked
        if (txtPassword2.getEchoChar() != 0) {
            txtPassword2.setEchoChar((char) 0); // Hiện mật khẩu
            ImageIcon icon = new ImageIcon("src//img//view.png");
            lblPassword2.setIcon(icon);
        } else {
            txtPassword2.setEchoChar('*'); // Ẩn mật khẩu
            ImageIcon icon = new ImageIcon("src//img//hide.png");
            lblPassword2.setIcon(icon);
        }
    }//GEN-LAST:event_lblPassword2MouseClicked

    private void lblPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordMouseClicked
        if (txtPassword.getEchoChar() != 0) {
            txtPassword.setEchoChar((char) 0); // Hiện mật khẩu
            ImageIcon icon = new ImageIcon("src//img//view.png");
            lblPassword.setIcon(icon);
        } else {
            txtPassword.setEchoChar('*'); // Ẩn mật khẩu
            ImageIcon icon = new ImageIcon("src//img//hide.png");
            lblPassword.setIcon(icon);
        }
    }//GEN-LAST:event_lblPasswordMouseClicked

    private void dateOfBirthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateOfBirthPropertyChange
        if (dateOfBirth.getDate() != null) {
            LocalDate dateOfDateInput = dateOfBirth.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateNow = LocalDate.now();
            if (Period.between(dateOfDateInput, dateNow).getYears() <= 18) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Định dạng ngày không hợp lệ hoặc tuổi nhỏ hơn 18!");
            }
        }
    }//GEN-LAST:event_dateOfBirthPropertyChange

    private void dateOfBirthVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dateOfBirthVetoableChange
        if (check) {
            System.out.println(dateOfBirth.getDate());
            try {
                LocalDate dateOfBirthLocalDate = LocalDate.parse((CharSequence) dateOfBirth.getDate());
                LocalDate nowDate = LocalDate.now();
                System.out.println(Period.between(dateOfBirthLocalDate, nowDate).getYears());
            } catch (DateTimeParseException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Định dạng ngày không hợp lệ hoặc tuổi nhỏ hơn 18!");
            }
        }
    }//GEN-LAST:event_dateOfBirthVetoableChange

    private void btnClearEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearEmployeesActionPerformed
        this.clearEmployeesForm();
    }//GEN-LAST:event_btnClearEmployeesActionPerformed

    private void btnAddEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeesActionPerformed
        if (!checkEmployees() && !checkPKEmployees()) {
            try {
                this.insertEmployees();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnAddEmployeesActionPerformed

    private void btnUpdateEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEmployeesActionPerformed
        if (!checkEmployees())
            this.updateEmployees();
    }//GEN-LAST:event_btnUpdateEmployeesActionPerformed

    private void btnDeleteEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEmployeesActionPerformed
        this.deleteEmployees();
    }//GEN-LAST:event_btnDeleteEmployeesActionPerformed

    private void lblStationeryImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStationeryImageMouseClicked
        pickImage(lblStationeryImage);
    }//GEN-LAST:event_lblStationeryImageMouseClicked

    private void txtStationery_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStationery_NameActionPerformed

    }//GEN-LAST:event_txtStationery_NameActionPerformed

    private void cbbStationeryGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbStationeryGenreActionPerformed

    }//GEN-LAST:event_cbbStationeryGenreActionPerformed

    private void btnAddStationeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStationeryActionPerformed
        if (!isStationeryFormHasError()) {
            this.insertNewStationery();
        }
    }//GEN-LAST:event_btnAddStationeryActionPerformed

    private void btnClearStationeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearStationeryActionPerformed
        this.clearStationeryForm();
    }//GEN-LAST:event_btnClearStationeryActionPerformed

    private void btnUpdateStationeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStationeryActionPerformed
        if (!isStationeryFormHasError()) {
            this.updateStationery();
        }
    }//GEN-LAST:event_btnUpdateStationeryActionPerformed

    private void btnDeleteStationeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStationeryActionPerformed
        int rowTblStationery = tblStationery.getSelectedRow();
        if (rowTblStationery > -1) {
            this.deleteStationery(txtStationeryID.getText());
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Bạn chưa chọn dữ liệu cần xóa");
        }
    }//GEN-LAST:event_btnDeleteStationeryActionPerformed

    private void tblStationeryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStationeryMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                boolean check;
                int rowTblStationery = tblStationery.getSelectedRow();
                String id = tblStationery.getValueAt(rowTblStationery, 0).toString();
                Products p = prodDAO.selectById(id).get(0);
                setStationeryForm(p);

                if (rowTblStationery != -1) {
                    check = true;
                } else {
                    check = false;
                }

                if (Auth.isManager()) {
                    btnDeleteStationery.setEnabled(check);
                }
                btnUpdateStationery.setEnabled(check);
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblStationeryMouseClicked

    private void txtFindStationeryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindStationeryKeyReleased
        this.findStationery();
    }//GEN-LAST:event_txtFindStationeryKeyReleased

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void btndeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteCustomerActionPerformed
        deleteCustomer();
    }//GEN-LAST:event_btndeleteCustomerActionPerformed

    private void startDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startDateMouseClicked

    }//GEN-LAST:event_startDateMouseClicked

    private void endDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endDateMouseClicked

    }//GEN-LAST:event_endDateMouseClicked

    private void btnStatisticsResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticsResetActionPerformed
        this.resetDateStatistic();
    }//GEN-LAST:event_btnStatisticsResetActionPerformed

    private void startDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startDatePropertyChange
        this.fillTableStatistics();
        try {
            showLineChart();
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_startDatePropertyChange

    private void endDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_endDatePropertyChange
        this.fillTableStatistics();
        try {
            showLineChart();
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_endDatePropertyChange

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        if (MsgBox.confirm(this, "Bạn có muốn đăng xuất khỏi ứng dụng?")) {
            Auth.user = null;
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void txtProviderNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProviderNameKeyReleased
        if (!txtProviderName.getText().isBlank()) {
            txtProviderName.setBackground(Color.white);
        } else {
            txtProviderName.setBackground(Color.yellow);
        }
    }//GEN-LAST:event_txtProviderNameKeyReleased

    private void txtNumPhoneProviderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumPhoneProviderKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Chỉ nhập số!");
            evt.consume();
        } else if (txtNumPhoneProvider.getText().isEmpty()) {
            if (c != '0') {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Số điện thoại phải bắt đầu bằng 0!");
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNumPhoneProviderKeyTyped

    private void txtFindInventoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindInventoryKeyReleased
        searchInventory(txtFindInventory.getText());
    }//GEN-LAST:event_txtFindInventoryKeyReleased

    private void txtNumPhoneProviderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumPhoneProviderKeyReleased
        if (txtNumPhoneProvider.getText().length() > 10) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Số điện thoại vượt quá số ký tự cho phép! (10)");
            String newText = txtNumPhoneProvider.getText() + evt.getKeyChar();
            txtNumPhoneProvider.setText(newText.substring(0, 10));
        }
    }//GEN-LAST:event_txtNumPhoneProviderKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TheBookStoreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TheBookStoreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TheBookStoreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TheBookStoreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TheBookStoreJFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChoosen;
    private javax.swing.ButtonGroup GroupGender;
    private javax.swing.ButtonGroup GroupRole;
    private javax.swing.JTextArea bill;
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnAddEmployees;
    private javax.swing.JButton btnAddProvider;
    private javax.swing.JButton btnAddStationery;
    private javax.swing.JButton btnBooks;
    private javax.swing.JButton btnCancelReceipts;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnClearBook;
    private javax.swing.JButton btnClearEmployees;
    private javax.swing.JButton btnClearStationery;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnDeleteBook;
    private javax.swing.JButton btnDeleteEmployees;
    private javax.swing.JButton btnDeleteProvider;
    private javax.swing.JButton btnDeleteStationery;
    private javax.swing.JButton btnEditWarehouseReceipts;
    private javax.swing.JButton btnEditWarehouseReceipts2;
    private javax.swing.JButton btnEmployees;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnPrintReceipts;
    private javax.swing.JButton btnProviders;
    private javax.swing.JButton btnReceipts;
    private javax.swing.JButton btnRefreshProvider;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnStationery;
    private javax.swing.JButton btnStatisticsReset;
    private javax.swing.JButton btnUpdateBook;
    private javax.swing.JButton btnUpdateEmployees;
    private javax.swing.JButton btnUpdateProvider;
    private javax.swing.JButton btnUpdateStationery;
    private javax.swing.JButton btnVerifyWareHouse;
    private javax.swing.JButton btnViewReceipts;
    private javax.swing.JButton btnWarehouse;
    private javax.swing.JButton btnaddCustomer;
    private javax.swing.JButton btnaddnewReceipts;
    private javax.swing.JButton btndeleteCustomer;
    private javax.swing.JButton btnfixCustomer;
    private javax.swing.JButton btnnewCustomer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbGenre;
    private javax.swing.JComboBox<String> cbbStationeryGenre;
    private javax.swing.JComboBox<Providers> cboProviders;
    private javax.swing.JCheckBox chkBook;
    private javax.swing.JCheckBox chkStationery;
    private com.toedter.calendar.JDateChooser dateOfBirth;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.ButtonGroup groupCurrentStatusWarehouseExport;
    private javax.swing.ButtonGroup groupCurrentStatusWarehouseReceipt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblBookImage;
    private javax.swing.JLabel lblNewPassEye1;
    private javax.swing.JLabel lblNewPassEye2;
    private javax.swing.JLabel lblOldPassEye;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JLabel lblStationeryBarcode;
    private javax.swing.JLabel lblStationeryImage;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWaring;
    private javax.swing.JPanel pnlBookForm;
    private javax.swing.JPanel pnlBookTable;
    private javax.swing.JPanel pnlBooks;
    private javax.swing.JPanel pnlChangePassword;
    private javax.swing.JPanel pnlChangePasswordForm;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JPanel pnlCustomers;
    private javax.swing.JPanel pnlCustomers1;
    private javax.swing.JPanel pnlDateOfBirth;
    private javax.swing.JPanel pnlEmployees;
    private javax.swing.JPanel pnlEmployeesForm;
    private javax.swing.JPanel pnlEmployeesMoreInfo;
    private javax.swing.JPanel pnlEmployeesRole;
    private javax.swing.JPanel pnlEmployeesTable;
    private javax.swing.JPanel pnlForm1;
    private javax.swing.JPanel pnlForm2;
    private javax.swing.JPanel pnlGender;
    private javax.swing.JPanel pnlInventory1;
    private javax.swing.JPanel pnlInventoryAll;
    private javax.swing.JPanel pnlListCustomer;
    private javax.swing.JPanel pnlListCustomer1;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuTab;
    private javax.swing.JPanel pnlProvider_ContractDate;
    private javax.swing.JPanel pnlProvider_MoreInfo;
    private javax.swing.JPanel pnlProviders;
    private javax.swing.JPanel pnlProvidersForm;
    private javax.swing.JPanel pnlProvidersTable;
    private javax.swing.JPanel pnlReceipts;
    private javax.swing.JPanel pnlStationery;
    private javax.swing.JPanel pnlStationeryForm;
    private javax.swing.JPanel pnlStationeryPic;
    private javax.swing.JPanel pnlStationeryTable;
    private javax.swing.JPanel pnlStationery_Barcode;
    private javax.swing.JPanel pnlStationery_MoreInfo;
    private javax.swing.JPanel pnlStationery_TypeOfProduct;
    private javax.swing.JPanel pnlStatistics;
    private javax.swing.JPanel pnlStatisticsForm;
    private javax.swing.JPanel pnlTypeOfProduct;
    private javax.swing.JLayeredPane pnlWHRP;
    private javax.swing.JPanel pnlWareHouseReceipts;
    private javax.swing.JPanel pnlWareHouseReceiptsAll;
    private javax.swing.JPanel pnlWareHouseReceiptsDetails;
    private javax.swing.JPanel pnlWareHouseReceiptsGenarel;
    private javax.swing.JPanel pnlWareHouseReceiptsTableAll;
    private javax.swing.JPanel pnlWarehouse;
    private javax.swing.JPanel pnlmoreInforCustomer;
    private javax.swing.JPanel pnlmoreInforCustomer1;
    private javax.swing.JRadioButton rdoEmployees;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JRadioButton rdoManager;
    private javax.swing.JRadioButton rdoPaid;
    private javax.swing.JRadioButton rdoUnpaid;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTabbedPane tabsInventory;
    private javax.swing.JTable tblBook;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTable tblInventory;
    private javax.swing.JTable tblListCustomer;
    private javax.swing.JTable tblProductDetails;
    private javax.swing.JTable tblProductWarehouseReceipt;
    private javax.swing.JTable tblProvider;
    private javax.swing.JTable tblReceiptDetails;
    private javax.swing.JTable tblReceiptProducts;
    private javax.swing.JTable tblStationery;
    private javax.swing.JTable tblStatistics;
    private javax.swing.JTable tblWarehouseReceiptsAll;
    private javax.swing.JTextField txtAddressProvider;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookAddedBy;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextArea txtBookMoreInfo;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtCreatedBy;
    private javax.swing.JTextField txtCreatedDayReceipts;
    private javax.swing.JTextField txtCurrentStatus;
    private javax.swing.JTextArea txtDecriptionWareHouse;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtEmployeesMoreInfo;
    private javax.swing.JTextField txtEmployeesName;
    private javax.swing.JTextField txtFindBook;
    private javax.swing.JTextField txtFindEmployees;
    private javax.swing.JTextField txtFindInventory;
    private javax.swing.JTextField txtFindPrdReceipts;
    private javax.swing.JTextField txtFindProvider;
    private javax.swing.JTextField txtFindStationery;
    private javax.swing.JTextField txtIDCustomer;
    private javax.swing.JPasswordField txtNewPassword1;
    private javax.swing.JPasswordField txtNewPassword2;
    private javax.swing.JTextField txtNumPhoneProvider;
    private javax.swing.JPasswordField txtOldPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword2;
    private javax.swing.JTextField txtPhoneNumberEmployees;
    private javax.swing.JTextField txtProviderName;
    private javax.swing.JTextField txtProviderWareHouseReceipts;
    private com.toedter.calendar.JDateChooser txtProvider_ContractDate;
    private javax.swing.JTextField txtProvider_Email;
    private javax.swing.JTextField txtProvider_ID;
    private javax.swing.JTextArea txtProvider_MoreInfo;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtReceiptsIDReceipts;
    private javax.swing.JTextField txtReceivedReceipts;
    private javax.swing.JTextField txtReceivingDate;
    private javax.swing.JTextField txtReceivingDateGenarel;
    private javax.swing.JTextField txtReturnReceipts;
    private javax.swing.JTextField txtSearchProduct;
    private javax.swing.JTextField txtSearchWarehouseReceipt;
    private javax.swing.JTextField txtStationeryID;
    private javax.swing.JTextArea txtStationeryMoreInfo;
    private javax.swing.JTextField txtStationery_AddBy;
    private javax.swing.JTextField txtStationery_Name;
    private javax.swing.JTextField txtTotalCostWareHouseReciepts;
    private javax.swing.JTextField txtTotalReceipts;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameChange;
    private javax.swing.JTextField txtWareHouseReceiptGeneral;
    private javax.swing.JTextField txtWareHouseReceiptsID;
    private javax.swing.JTextField txtadressCustomer;
    private javax.swing.JTextField txtemailCustomer;
    private javax.swing.JTextField txtfindCustomer;
    private javax.swing.JTextArea txtmoreInforeCustomer;
    private javax.swing.JTextArea txtmoreInforeCustomer1;
    private javax.swing.JTextField txtnameCustomer;
    private javax.swing.JTextField txtnumberphoneCustomer;
    // End of variables declaration//GEN-END:variables

    /*------------------------------------GENERAL METHODS------------------------------------------------*/
    public void resizeColumnsToContent(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();

        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width); // Add some padding
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }

        table.revalidate(); // Update table view
    }
    JFileChooser fileChooser = new JFileChooser();

    String generateRandomCode() {
        String uuid = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
        String uuid16digits = uuid.substring(uuid.length() - 16);
        return uuid16digits;
    }

    void pickImage(JLabel lblImage) {

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            if (fileName.substring(fileName.lastIndexOf(".")).equalsIgnoreCase(".jpg") || fileName.substring(fileName.lastIndexOf(".")).equalsIgnoreCase(".png") || fileName.substring(fileName.lastIndexOf(".")).equalsIgnoreCase(".jpeg")) {
                XImage.save("src\\product_img", file);
                ImageIcon icon = new ImageIcon(XImage.read("src\\product_img\\", file.getName()).
                        getImage().getScaledInstance(lblImage.getWidth(),
                                lblImage.getHeight(), Image.SCALE_SMOOTH));

                lblImage.setText("");
                lblImage.setIcon(icon);
                lblImage.setToolTipText(file.getName());
            } else {
                MsgBox.alert(this, "File hình đã chọn không hợp lệ!");
            }
        }
    }

    ProductDAO prodDAO = new ProductDAO();
    CustomerDAO cusDAO = new CustomerDAO();
    EmployeeDAO empDAO = new EmployeeDAO();
    ProviderDAO provDAO = new ProviderDAO();
    ReceiptsDAO receiptDAO = new ReceiptsDAO();
    ReceiptsDetailsDAO recDetailDAO = new ReceiptsDetailsDAO();
    StatisticsDAO statsDAO = new StatisticsDAO();
    SimpleDateFormat formatterDATE = new SimpleDateFormat("dd-MM-yyyy");
    DecimalFormat formatterVND = new DecimalFormat("#,###");

    void permission() {
        btnReports.setVisible(Auth.isManager());
        btnEmployees.setVisible(Auth.isManager());
        btnDeleteBook.setEnabled(false);
//        btnDeleteEmployees.setEnabled(false);
        btnDeleteProvider.setEnabled(false);
        btnDeleteStationery.setEnabled(false);
        btndeleteCustomer.setEnabled(false);
        btnUpdateBook.setEnabled(false);
//        btnUpdateEmployees.setEnabled(false);
        btnUpdateProvider.setEnabled(false);
        btnUpdateStationery.setEnabled(false);
        btnfixCustomer.setEnabled(false);
    }

    void startDongHo() {
        SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss a");
        new Timer(1000, (ActionEvent e) -> {
            lblTime.setText(formater.format(new Date()));
        }).start();
    }

    void status() {
        if (Auth.isLogin()) {
            if (Auth.isManager()) {
                lblStatus.setText("Quản lý: " + Auth.user.getEmployeeName() + " - " + Auth.user.getUserName());
            } else {
                lblStatus.setText("Nhân viên: " + Auth.user.getEmployeeName() + " - " + Auth.user.getUserName());
            }
        } else {
            lblStatus.setText("Hệ thống quản lý TheBookStore");
        }
    }

    /*---------------------------------END OF GENERAL METHODS--------------------------------------------*/

 /*------------------------------------------------BOOK-----------------------------------------------*/
    void fillTableBook() throws SQLException {
        txtCreatedBy.setText(Auth.user.getEmployeeName());
        txtCreatedBy.setEditable(false);
        String columns[] = {"MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "TÁC GIẢ", "NXB", "THỂ LOẠI"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        List<Products> list = prodDAO.selectAll();
        for (Products p : list) {
            if (p.getTypeOfProductID() == 1) {
                Object row[] = new Object[]{p.getID(), p.getProductName(),
                    p.getAuthor(), p.getPublisher(), p.getGenre()};
                model.addRow(row);
            } else {
                continue;
            }
        }
        tblBook.setModel(model);
        fillProducts();
    }

    Products getBookForm() {
        Products p = new Products();
        p.setID(txtBookID.getText());
        p.setProductName(txtBookName.getText());
        p.setTypeOfProductID(1);
        p.setAuthor(txtAuthor.getText());
        p.setPublisher(txtPublisher.getText());
        p.setGenre(cbbGenre.getSelectedItem().toString());
        p.setMoreInfo(txtBookMoreInfo.getText());
        p.setBarCode(txtBookID.getText());
        if (lblBookImage.getIcon() != null) {
            p.setImagePath(lblBookImage.getToolTipText());
        }
        p.setEmployeeID(Auth.user.getIdEmployee());
        p.setImagePath(lblBookImage.getToolTipText()); // Temporary value
        return p;
    }

    void setBookForm(Products p) {
        txtBookID.setText(p.getID());
        txtBookName.setText(p.getProductName());
        txtAuthor.setText(p.getAuthor());
        txtPublisher.setText(p.getPublisher());
        txtBookMoreInfo.setText(p.getMoreInfo());
        // Add code to generate barcode image here!
        String fileName = p.getBarCode() + ".png";
        ImageIcon barcode_icon = new ImageIcon(XImage.read("src\\barcode_img", fileName).
                getImage().getScaledInstance(lblBarcode.getWidth(),
                        lblBarcode.getHeight(), Image.SCALE_SMOOTH));
        lblBarcode.setIcon(barcode_icon);

        txtBookAddedBy.setText(String.valueOf(empDAO.selectById(p.getEmployeeID()).getEmployeeName()));
        // Add code to add image to label here!
        if (p.getImagePath() != null) {
            lblBookImage.setToolTipText(p.getImagePath());
            ImageIcon icon = new ImageIcon(XImage.read("src\\product_img", p.getImagePath()).
                    getImage().getScaledInstance(lblBookImage.getWidth(),
                            lblBookImage.getHeight(), Image.SCALE_SMOOTH));
            lblBookImage.setText("");
            lblBookImage.setIcon(icon);
        } else {
            lblBookImage.setText("");
            lblBookImage.setIcon(null);
        }
        cbbGenre.setSelectedItem(p.getGenre());
    }

    void insertNewBook() throws SQLException {
        Products p = getBookForm();
        GenerateBarcodeImage.createBarcodeImage(p.getBarCode() + ".png", p.getID());
        prodDAO.insert(p);
        this.clearBookForm();
        this.fillTableBook();
        MessageAlerts.getInstance().showMessage("The BookStore", "THÊM THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
    }

    void updateBook() throws SQLException {
        Products p = getBookForm();
        prodDAO.update(p);
        this.clearBookForm();
        this.fillTableBook();
        MessageAlerts.getInstance().showMessage("The BookStore", "CẬP NHẬT THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
    }

    void deleteBook(String ID) throws SQLException {
        if (MsgBox.confirm(this, "Bạn có muốn xóa sách này ?")) {
            if (!prodDAO.isRemained(ID)) {
                prodDAO.delete(ID);
                this.clearBookForm();
                this.fillTableBook();
                MessageAlerts.getInstance().showMessage("The BookStore", "XÓA THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Không thể xóa sản phẩm này!");
            }
        }

    }

    void clearBookForm() {
        String ID = this.generateRandomCode();
        txtBookID.setText(ID);
        txtAuthor.setText("");
        txtPublisher.setText("");
        txtBookName.setText("");
        cbbGenre.setSelectedIndex(0);
        txtBookAddedBy.setText(Auth.user.getEmployeeName());
        txtBookMoreInfo.setText("");
        lblBarcode.setIcon(null);
        lblBookImage.setIcon(null);
        lblBookImage.setText("+");
        btnUpdateBook.setEnabled(false);
        btnDeleteBook.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    void addGenre() {
        String items[] = {"Văn học", "Khoa học", "Sách giáo khoa", "Sách kỹ thuật", "Sách kinh doanh", "Sách lịch sử",
            "Sách du lịch", "Sách tâm lý", "Sách thiếu nhi", "Sách tranh", "Sách phi hư cấu", "Sách tự học", "Sách lãng mạn",
            "Sách bí ẩn", "Sách khoa học viễn tưởng", "Sách giả tưởng", "Sách kinh dị", "Sách hài hước", "Sách thơ"};
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        cbbGenre.setModel(model);
    }

    boolean isBookFormHasError() {
        if (txtBookName.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập tên sách!");
            return true;
        } else if (txtAuthor.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập tên tác giả!");
            return true;
        } else if (txtPublisher.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập nhà xuất bản!");

            return true;
        }

        return false;
    }

    /*---------------------------------------------END OF BOOK-------------------------------------------*/

 /*------------------------------------------------STATIONERY-----------------------------------------*/
    void fillTblStationery() throws SQLException {
        String columns[] = {"MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "LOẠI SẢN PHẨM"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        if (txtFindStationery.getText().isBlank()) {
            List<Products> list = prodDAO.SelectByIdTypeOfProduct();
            for (Products p : list) {
                Object row[] = new Object[]{p.getID(), p.getProductName(), p.getGenre()};
                model.addRow(row);
            }
            tblStationery.setModel(model);
        } else {
            String wordKey = txtFindStationery.getText();
            List<Products> list = prodDAO.SelectByKeyWord(wordKey);
            for (Products p : list) {
                Object row[] = new Object[]{p.getID(), p.getProductName(), p.getGenre()};
                model.addRow(row);
            }
            tblStationery.setModel(model);
        }
        fillProducts();
    }

    Products getStationeryForm() {
        Products p = new Products();
        p.setID(txtStationeryID.getText());
        p.setProductName(txtStationery_Name.getText());
        p.setTypeOfProductID(2);
        p.setAuthor(null);
        p.setPublisher(null);
        p.setGenre(cbbStationeryGenre.getSelectedItem().toString());
        p.setMoreInfo(txtBookMoreInfo.getText());
        p.setBarCode(txtStationeryID.getText());
        if (lblBookImage.getIcon() != null) {
            p.setImagePath(lblStationeryImage.getToolTipText());
        }
        p.setEmployeeID(Auth.user.getIdEmployee());
        p.setImagePath(lblStationeryImage.getToolTipText());
        return p;
    }

    void setStationeryForm(Products p) {
        txtStationeryID.setText(p.getID());
        txtStationery_Name.setText(p.getProductName());
        txtStationeryMoreInfo.setText(p.getMoreInfo());
        String fileName = p.getBarCode() + ".png";
        ImageIcon barcode_icon = new ImageIcon(XImage.read("src\\barcode_img", fileName).
                getImage().getScaledInstance(lblStationeryBarcode.getWidth(),
                        lblStationeryBarcode.getHeight(), Image.SCALE_SMOOTH));
        lblStationeryBarcode.setIcon(barcode_icon);

        txtStationery_AddBy.setText(empDAO.selectName(p.getEmployeeID()) + " (ID: " + String.valueOf(p.getEmployeeID()) + ")");
        if (p.getImagePath() != null) {
            lblStationeryImage.setToolTipText(p.getImagePath());
            ImageIcon icon = new ImageIcon(XImage.read("src\\product_img", p.getImagePath()).
                    getImage().getScaledInstance(lblStationeryImage.getWidth(),
                            lblStationeryImage.getHeight(), Image.SCALE_SMOOTH));
            lblStationeryImage.setText("");
            lblStationeryImage.setIcon(icon);
        }
    }

    void insertNewStationery() {
        try {
            Products p = getStationeryForm();
            GenerateBarcodeImage.createBarcodeImage(p.getBarCode() + ".png", p.getID());
            prodDAO.insert(p);
            this.fillTblStationery();
            MessageAlerts.getInstance().showMessage("The BookStore", "THÊM MỚI THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
        } catch (SQLException ex) {
            MessageAlerts.getInstance().showMessage("The BookStore", "THÊM MỚI THẤT BẠI!", MessageAlerts.MessageType.ERROR);
        }
    }

    void updateStationery() {
        try {
            Products p = getStationeryForm();
            prodDAO.update(p);
            this.clearStationeryForm();
            this.fillTblStationery();
            MessageAlerts.getInstance().showMessage("The BookStore", "CẬP NHẬT THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
        } catch (SQLException ex) {
            MessageAlerts.getInstance().showMessage("The BookStore", "CẬP NHẬT THẤT BẠI!", MessageAlerts.MessageType.ERROR);
        }
    }

    void deleteStationery(String ID) {
        if (!Auth.isManager()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Bạn không có quyền xóa mục này!");
        } else {
            if (MsgBox.confirm(this, "Bạn có chắc chắn xóa mục này chứ?")) {
                try {
                    prodDAO.delete(ID);
                    this.clearStationeryForm();
                    this.fillTblStationery();
                    MessageAlerts.getInstance().showMessage("The BookStore", "XÓA THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
                } catch (SQLException ex) {
                    MessageAlerts.getInstance().showMessage("The BookStore", "XÓA THẤT BẠI!", MessageAlerts.MessageType.ERROR);
                }
            }
        }
    }

    void clearStationeryForm() {
        String ID = this.generateRandomCode();
        txtStationeryID.setText(ID);
        txtAuthor.setText("");
        txtPublisher.setText("");
        txtStationery_Name.setText("");
        cbbStationeryGenre.setSelectedIndex(-1);
        txtStationery_AddBy.setText(Auth.user.getEmployeeName() + " (ID: " + Auth.user.getIdEmployee() + ")");
        txtStationeryMoreInfo.setText("");
        lblStationeryBarcode.setIcon(null);
        lblStationeryImage.setIcon(null);
        lblStationeryImage.setText("+");
        tblStationery.clearSelection();
        btnDeleteStationery.setEnabled(false);
        btnUpdateStationery.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    void addStationeryGenre() {
        String items[] = {"Bút mực", "Bút chì", "Thước kẻ", "Cục tẩy", "Viết xóa", "Tập 5 ô ly"};
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        cbbStationeryGenre.setModel(model);
        cbbStationeryGenre.setSelectedIndex(-1);
    }

    boolean isStationeryFormHasError() {
        if (txtStationery_Name.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Vui lòng nhập tên sản phẩm!");
            return true;
        }
        if (cbbStationeryGenre.getSelectedIndex() == -1) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Vui lòng chọn loại sản phẩm!");
            return true;
        }

        if (txtStationeryID.getText().equals("")) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Vui lòng làm mới giao diện!");
            return true;
        }
        return false;
    }

    void findStationery() {
        try {
            this.clearStationeryForm();
            this.fillTblStationery();
        } catch (SQLException ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Lỗi truy vấn dữ liệu!");
        }
    }
    /*---------------------------------------------END OF STATIONERY-------------------------------------*/

 /*------------------------------------------------PROVIDER-------------------------------------------*/
    int rowProv = -1;

    void fillTableProvider() {
        String columns[] = {"MÃ NHÀ CUNG CẤP", "TÊN NHÀ CUNG CẤP", "NGÀY LIÊN HỆ", "ĐỊA CHỈ", "SỐ ĐIỆN THOẠI", "EMAIL"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        try {
            String wordKey = txtFindProvider.getText();
            List<Providers> list = provDAO.selectByKeyWord(wordKey);
            for (Providers pv : list) {
                Object row[] = new Object[]{
                    pv.getProvidersID(),
                    pv.getProvidersName(),
                    pv.getContractDate() != null ? formatterDATE.format(pv.getContractDate()) : null,
                    pv.getAddressProviders(),
                    pv.getPhoneNumber(),
                    pv.getEmail()
                };
                model.addRow(row);
            }
            tblProvider.setModel(model);
        } catch (SQLException e) {
            MessageAlerts.getInstance().showMessage("The BookStore", "LỖI TRUY VẤN DỮ LIỆU!", MessageAlerts.MessageType.ERROR);
        }
    }

    Providers getFormProvider() throws SQLException {
        Providers prov = new Providers();
        prov.setProvidersID(Integer.parseInt(txtProvider_ID.getText()));
        prov.setProvidersName(txtProviderName.getText());
        prov.setContractDate(txtProvider_ContractDate.getDate());
        prov.setAddressProviders(txtAddressProvider.getText());
        prov.setPhoneNumber(txtNumPhoneProvider.getText());
        prov.setEmail(txtProvider_Email.getText());
        prov.setMoreInfo(txtProvider_MoreInfo.getText());
        return prov;
    }

    void setFormProvider(Providers prov) throws SQLException {
        txtProvider_ID.setText(String.valueOf(prov.getProvidersID()));
        txtProviderName.setText(prov.getProvidersName());
        txtProvider_ContractDate.setDate(prov.getContractDate());
        txtAddressProvider.setText(prov.getAddressProviders());
        txtNumPhoneProvider.setText(prov.getPhoneNumber());
        txtProvider_Email.setText(prov.getEmail());
        txtProvider_MoreInfo.setText(prov.getMoreInfo());
    }

    void insertProvider() {
        try {
            Providers prov = getFormProvider();
            provDAO.insert(prov);
            this.fillTableProvider();
            fillCboProviderWareHouseReceipts();
            MessageAlerts.getInstance().showMessage("The BookStore", "THÊM MỚI THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
        } catch (SQLException e) {
            MessageAlerts.getInstance().showMessage("The BookStore", "THÊM MỚI THẤT BẠI!", MessageAlerts.MessageType.ERROR);
        }
    }

    void updateProvider() {
        try {
            Providers prov = getFormProvider();
            provDAO.update(prov);
            this.fillTableProvider();
            fillCboProviderWareHouseReceipts();
            MessageAlerts.getInstance().showMessage("The BookStore", "CẬP NHẬT THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
        } catch (SQLException e) {
            MessageAlerts.getInstance().showMessage("The BookStore", "CẬP NHẬT THẤT BẠI!", MessageAlerts.MessageType.ERROR);
        }
    }

    void deleteProvider() {
        if (!Auth.isManager()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Bạn không có quyền xóa mục này!");
        } else {
            int provID = Integer.parseInt(txtProvider_ID.getText());
            if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhà cung cấp này ?")) {
                try {
                    provDAO.delete(provID);
                    this.fillTableProvider();
                    fillCboProviderWareHouseReceipts();
                    this.clearFormProvider();
                    MessageAlerts.getInstance().showMessage("The BookStore", "XÓA THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
                } catch (SQLException e) {
                    MessageAlerts.getInstance().showMessage("The BookStore", "XÓA THẤT BẠI!", MessageAlerts.MessageType.ERROR);
                }
            }
        }
    }

    void editProvider() {
        tblProvider.setRowSelectionInterval(this.rowProv, this.rowProv);
        int provID = (Integer) tblProvider.getValueAt(this.rowProv, 0);
        try {
            Providers prov = provDAO.selectById(provID);
            this.setFormProvider(prov);
            this.updateStatusProviderForm();
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void clearFormProvider() {
        Providers prov = new Providers();
        try {
            this.setFormProvider(prov);
            rowProv = -1;
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtProvider_ContractDate.setDate(null);
        tblProvider.clearSelection();
        this.updateStatusProviderForm();
    }

    void updateStatusProviderForm() {
        boolean edit = (this.rowProv >= 0);

        if (Auth.isManager()) {
            btnDeleteProvider.setEnabled(edit);
        } else {
            btnDeleteProvider.setEnabled(false);
        }
        btnUpdateProvider.setEnabled(edit);
        resizeColumnsToContent(tblProvider);
    }

    void findProvider() throws SQLException {
        this.clearFormProvider();
        this.fillTableProvider();
        this.rowProv = -1;
        this.updateStatusProviderForm();
    }

    boolean checkEmailProv(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    boolean checkErrorProv() {
        if (txtProviderName.getText().equals("")) {
            txtProviderName.setBackground(Color.yellow);
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Vui lòng nhập đầy đủ tên nhà cung cấp!");
            return true;
        }

        String email = txtProvider_Email.getText();
        if (!checkEmailProv(email)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Email không hợp lệ!");
            return true;
        }

        if (txtProvider_ID.getText().equals("")) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Vui lòng làm mới giao diện!");
            return true;
        }
        return false;
    }

    boolean checkContractDate() {
        if (txtProvider_ContractDate.getDate() == null) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Vui lòng chọn ngày liên hệ!");
            return true;
        } else if (txtProvider_ContractDate.getDate().after(new Date())) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 3000, "Vui lòng chọn ngày liên hệ từ hôm nay trở về trước!");
            return true;
        }
        return false;
    }
    /*---------------------------------------------END OF PROVIDER---------------------------------------*/

 /*------------------------------------------------CUSTOMER-------------------------------------------*/
    int rowCus = -1;

    void findCustomer() throws SQLException {
        this.refeshCustomer();
        this.fillTblCustomer();
        this.rowCus = -1;

    }

    void fillTblCustomer() throws SQLException {
        String columns[] = {"MÃ KHÁCH HÀNG", "TÊN KHÁCH HÀNG", "ĐỊA CHỈ", "EMAIL", "SỐ ĐIỆN THOẠI"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        String wordKey = txtfindCustomer.getText();
        List<Customer> list = cusDAO.selectByKeyWord(wordKey);
        for (Customer c : list) {
            Object row[] = new Object[]{c.getID(), c.getCustomerName(), c.getAddressCustomers(),
                c.getEmail(), c.getPhoneNumber()};
            model.addRow(row);
        }
        tblListCustomer.setModel(model);
    }

    void addCustomer() throws SQLException {
        if (!checkNull() && !checkPKCustomer()) {
            if (txtnameCustomer.getText().isEmpty() || txtnumberphoneCustomer.getText().isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập đầy đủ thông tin !");
            } else {
                new CustomerDAO().insert(getFormCustomer());
                MessageAlerts.getInstance().showMessage("The BookStore", "THÊM THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
                fillTblCustomer();
            }

        }

    }

    void deleteCustomer() {
        if (!Auth.isManager()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Bạn không có quyền xóa khách hàng !");
        } else {
            if (MsgBox.confirm(this, "Bạn thực sự muốn xóa khách hàng này?")) {
                try {
                    if (CustomerID != -1) {
                        cusDAO.delete(CustomerID);
                        this.fillTblCustomer();
                        this.refeshCustomer();
                        MessageAlerts.getInstance().showMessage("TheBookStore", "Xóa thành công", MessageAlerts.MessageType.SUCCESS);
                        btndeleteCustomer.setEnabled(false);
                        btnfixCustomer.setEnabled(false);
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Hãy chọn dữ liệu để xóa!");
                    }
                } catch (Exception e) {
                    MessageAlerts.getInstance().showMessage("TheBookStore", "Xóa thất bại", MessageAlerts.MessageType.SUCCESS);
                }
            }
        }
    }

    int CustomerID = -1;

    void updateCustomer() throws SQLException {
        if (!checkNull()) {
            if (txtnameCustomer.getText().isEmpty() || txtnumberphoneCustomer.getText().isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập đầy đủ thông tin !");
            } else {
                Customer cus = getFormCustomer();
                cus.setID(CustomerID);
                if (cus.getID() != -1) {
                    new CustomerDAO().update(cus);
                    MessageAlerts.getInstance().showMessage("The BookStore", "CẬP NHẬT THÀNH CÔNG!", MessageAlerts.MessageType.SUCCESS);
                    fillTblCustomer();
                    refeshCustomer();
                    btnfixCustomer.setEnabled(false);
                    btndeleteCustomer.setEnabled(false);
                    CustomerID = -1;
                }
            }
        }
    }

    boolean checkNull() {

        String mauEmail = "^(|[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$";
        String mauSDT = "^((\\+84|0)[3|5|7|8|9])+([0-9]{8})$";
        if (txtnameCustomer.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Không bỏ trống tên khách hàng !");
            txtnameCustomer.setText("");
            txtnameCustomer.requestFocus();
            return true;
        } else if (txtnumberphoneCustomer.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Không bỏ trống SĐT !");
            txtnumberphoneCustomer.requestFocus();
            return true;
        } else if (!txtnumberphoneCustomer.getText().matches(mauSDT)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập SĐT đúng định dạng (84+) !");
            txtnumberphoneCustomer.setText("");
            txtnumberphoneCustomer.requestFocus();
            return true;
        } else if (!txtemailCustomer.getText().matches(mauEmail)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập email đúng định dạng !");
            txtemailCustomer.setText("");
            txtemailCustomer.requestFocus();
            return true;
        }

        return false;
    }

    public boolean checkPKCustomer() throws SQLException {
        List<Customer> list = new CustomerDAO().selectAll();
        for (Customer c : list) {
            if (c.getPhoneNumber().equalsIgnoreCase(txtnumberphoneCustomer.getText())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Số điện thoại đã tồn tại !");
                return true;
            }
            if (!c.getEmail().equals("") && c.getEmail().equalsIgnoreCase(txtemailCustomer.getText())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Email đã tồn tại !");
                return true;
            }
        }
        return false;
    }

    Customer getFormCustomer() {
        Customer customer = new Customer();
//        customer.setID(Integer.parseInt(txtIDCustomer.getText()));
        customer.setCustomerName(txtnameCustomer.getText());
        customer.setPhoneNumber(txtnumberphoneCustomer.getText());
        customer.setAddressCustomers(txtadressCustomer.getText());
        customer.setContractDate(XDate.toDate(XDate.toString(new Date(), "dd-MM-yyyy"), "dd-MM-yyyy"));
        customer.setEmail(txtemailCustomer.getText());
        customer.setMoreInfo(txtmoreInforeCustomer.getText());
        return customer;
    }

    void setFormCustomer(Customer customer) {
        txtIDCustomer.setText(String.valueOf(customer.getID()));
        txtnameCustomer.setText(customer.getCustomerName());
        txtnumberphoneCustomer.setText(customer.getPhoneNumber());
        txtadressCustomer.setText(customer.getAddressCustomers());

        txtemailCustomer.setText(customer.getEmail());
        txtmoreInforeCustomer.setText(customer.getMoreInfo());

    }

    void refeshCustomer() throws SQLException {
        Customer customer = new Customer();
        setFormCustomer(customer);
        fillTblCustomer();
    }

    /*---------------------------------------------END OF CUSTOMER---------------------------------------*/

 /*------------------------------------------------EMPLOYEE-------------------------------------------*/
    public boolean checkPKEmployees() {
        List<Employees> list = new EmployeeDAO().selectAll();
        for (Employees e : list) {
            if (e.getUserName().equalsIgnoreCase(txtUsername.getText())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Tên đăng nhập đã tồn tại!");
                return true;
            }
            if (e.getPhoneNumber().equalsIgnoreCase(txtPhoneNumberEmployees.getText())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Số điện thoại đã tồn tại ở một người khác!");
                return true;
            }
        }
        return false;
    }

    public boolean checkDateOfBirth(String dateOfBirth) {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate dateOfBirthLocalDate = LocalDate.parse(dateOfBirth, formatDate);
            LocalDate nowDate = LocalDate.now();
            Period old = Period.between(dateOfBirthLocalDate, nowDate);
            return old.getYears() >= 18;
        } catch (DateTimeParseException e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Định dạng ngày không hợp lệ hoặc tuổi nhỏ hơn 18!");
            return false;
        }
    }

    void fillTblEmployees() throws SQLException {
        //(EmployeeName, Username, Password, Gender, DateOfBirth, EmployeeRole, Email, PhoneNumber, MoreInfo)
        String columns[] = {"MÃ NHÂN VIÊN", "HỌ VÀ TÊN", "TÊN ĐĂNG NHẬP", "GIỚI TÍNH", "NGÀY SINH", "CHỨC VỤ", "EMAIL", "ĐIỆN THOẠI", "GHI CHÚ"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        String nameKey = txtFindEmployees.getText();
        List<Employees> list = empDAO.selectByNameEmp(nameKey);
        for (Employees e : list) {
            Object row[] = new Object[]{e.getIdEmployee(), e.getEmployeeName(), e.getUserName(), e.isGender() ? "Nam" : "Nữ", formatterDATE.format(e.getDateOfBirth()), e.isEmployeeRole() ? "Quản Lý" : "Nhân Viên", e.getEmail(), e.getPhoneNumber(), e.getMoreInfo()};
            model.addRow(row);
        }
        tblEmployees.setModel(model);
    }

    public boolean checkEmployees() {

        //Form Employees
        String employeeName = "[\\p{L}\\p{N}\\s]{1,100}$";
        String userName = "^[a-zA-Z0-9]{1,50}$";
        String email = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        String phoneNumber = "0[3579]{1}[0-9]{8}";
        String employeePassword = "^[a-zA-Z0-9._%+-]{6,50}$";

        if (txtEmployeesName.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập lại họ và tên nhập đúng định dạng!");
            return true;
        }
        if (!txtEmployeesName.getText().matches(employeeName)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Sai định dạng họ và tên!");
            return true;
        }

        if (txtUsername.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập lại tên đăng nhập và nhập đúng định dạng!");
            return true;
        }
        if (!txtUsername.getText().matches(userName)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Sai định dạng tên đăng nhập!");
            return true;
        }

        if (txtPassword.getText().isBlank() || txtPassword2.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập mật khẩu và xác nhận!");
            return true;
        }
        if (!txtPassword.getText().matches(employeePassword)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Mật khẩu tối thiểu 6 kí tự và tối đa 50 kí tự!");
            return true;
        }

        if (rdoFemale.isSelected() == false && rdoMale.isSelected() == false) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng chọn giới tính!");
            return true;
        }

        if (dateOfBirth == null) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng chọn ngày sinh!");
            return true;
        }

        if (txtPhoneNumberEmployees.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập lại số điện thoại và nhập đúng định dạng!");
            return true;
        }
        if (!txtPhoneNumberEmployees.getText().matches(phoneNumber)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Sai định dạng số điện thoại!");
            return true;
        }
        if (txtEmail.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập lại email và nhập đúng định dạng!");
            return true;
        }
        if (!txtEmail.getText().matches(email)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Sai định dạng email!");
            return true;
        }

        if (rdoManager.isSelected() == false && rdoEmployees.isSelected() == false) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng chọn vai trò!");
            return true;
        }

        return false;
    }

    void findEmployees() throws SQLException {
        this.clearEmployeesForm();
        this.fillTblEmployees();
        this.rowEmp = -1;
        this.updateEmployeesStatus();
    }

    void insertEmployees() {
        Employees e = getEmployeesForm();
        String passWord2 = new String(txtPassword2.getPassword());
        if (!passWord2.equals(e.getEmployeePassword())) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Xác nhận mật khẩu không đúng!");
        } else {
            try {
                empDAO.insert(e);
                this.fillTblEmployees();
                MessageAlerts.getInstance().showMessage("TheBookStore", "Thêm mới thành công", MessageAlerts.MessageType.SUCCESS);
            } catch (SQLException ex) {
                MessageAlerts.getInstance().showMessage("TheBookStore", "Thêm mới thất bại", MessageAlerts.MessageType.SUCCESS);
            }
        }
    }

    void updateEmployees() {
        Employees e = getEmployeesForm();
        String passWord2 = new String(txtPassword2.getPassword());
        if (!passWord2.equals(e.getEmployeePassword())) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Xác nhận mật khẩu không đúng!");
        } else {
            try {
                if (rowEmp != -1) {
                    empDAO.update(e);
                    this.fillTblEmployees();
                    this.clearEmployeesForm();
                    MessageAlerts.getInstance().showMessage("TheBookStore", "Cập nhật thành công", MessageAlerts.MessageType.SUCCESS);
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Hãy chọn dữ liệu để cập nhật!");
                }
            } catch (SQLException ex) {
                MessageAlerts.getInstance().showMessage("TheBookStore", "Cập nhật thất bại", MessageAlerts.MessageType.SUCCESS);
            }
        }
    }

    int rowEmp = -1;

    void deleteEmployees() {
        if (!Auth.isManager()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Bạn không có quyền xóa nhân viên!");
        } else {
            if (rowEmp == Auth.user.getIdEmployee()) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Bạn không được xóa chính bạn!");
            } else if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
                try {
                    if (rowEmp != -1) {
                        empDAO.delete(rowEmp);
                        this.fillTblEmployees();
                        this.clearEmployeesForm();
                        MessageAlerts.getInstance().showMessage("TheBookStore", "Xóa thành công", MessageAlerts.MessageType.SUCCESS);
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Hãy chọn dữ liệu để xóa!");
                    }
                } catch (Exception e) {
                    MessageAlerts.getInstance().showMessage("TheBookStore", "Xóa thất bại", MessageAlerts.MessageType.SUCCESS);
                }
            }
        }
    }

    void clearEmployeesForm() {
        Employees e = new Employees();
        this.setEmployeesForm(e);
        this.rowEmp = -1;
        this.updateEmployeesStatus();
        GroupGender.clearSelection();
        GroupRole.clearSelection();
    }

    Employees getEmployeesForm() {
        Employees e = new Employees();
        if (tblEmployees.getSelectedRow() != -1) {
            e.setIdEmployee(Integer.parseInt("" + tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 0)));
            check = true;
        } else {
            check = false;
        }

        e.setEmployeeName(txtEmployeesName.getText());
        e.setUserName(txtUsername.getText());
        e.setEmployeePassword(new String(txtPassword.getPassword()));
        e.setGender(rdoMale.isSelected());
        e.setDateOfBirth(dateOfBirth.getDate());
        e.setEmployeeRole(rdoManager.isSelected());
        e.setEmail(txtEmail.getText());
        e.setPhoneNumber(txtPhoneNumberEmployees.getText());
        e.setMoreInfo(txtEmployeesMoreInfo.getText());
        return e;
    }

    void setEmployeesForm(Employees e
    ) {
        //(EmployeeName, Username, Password, Gender, DateOfBirth, EmployeeRole, Email, PhoneNumber, MoreInfo)
        txtEmployeesName.setText(e.getEmployeeName());
        txtUsername.setText(e.getUserName());
        txtPassword.setText(e.getEmployeePassword());
        txtPassword2.setText(e.getEmployeePassword());
        rdoMale.setSelected(e.isGender());
        rdoFemale.setSelected(!e.isGender());
        if (e.getDateOfBirth() != null) {
            dateOfBirth.setDate(XDate.toDate(formatterDATE.format(e.getDateOfBirth()), "dd-MM-yyyy"));
        } else {
            dateOfBirth.setDate(null);
        }
        rdoManager.setSelected(e.isEmployeeRole());
        rdoEmployees.setSelected(!e.isEmployeeRole());
        txtEmail.setText(e.getEmail());
        txtPhoneNumberEmployees.setText(e.getPhoneNumber());
        txtEmployeesMoreInfo.setText(e.getMoreInfo());
    }

    void editEmployees() {
        Employees e = empDAO.selectById(rowEmp);
        this.setEmployeesForm(e);
        this.updateEmployeesStatus();
    }

    void getValueTblEmployees(int index
    ) {
        Employees employees = new EmployeeDAO().selectById(Integer.parseInt(tblEmployees.getValueAt(index, 0).toString()));
        setEmployeesForm(employees);
    }

    void updateEmployeesStatus() {
        boolean edit = (this.rowEmp >= 0);
        boolean first = (this.rowEmp == 0);
        boolean last = (this.rowEmp == tblEmployees.getRowCount() - 1);
    }

    /*-------------------------------------------END OF EMPLOYEE-----------------------------------------*/

 /*------------------------------------------------RECEIPT--------------------------------------------*/
    void fillDetailByReceiptID(String id) throws SQLException {
        List<ReceiptDetails> list = recDetailDAO.selectAll(id);
        DefaultTableModel model = (DefaultTableModel) tblReceiptDetails.getModel();
        model.setRowCount(0);
        for (ReceiptDetails rd : list) {
            Object rows[] = new Object[]{recDetailDAO.fromInventoryToProduct(rd.getInventoryID()),
                recDetailDAO.toProductName(rd.getInventoryID()), rd.getQuantity(), rd.getSellingPrice()};
            model.addRow(rows);
        }
        tblReceiptDetails.setModel(model);
        sumTotalCost();
        calReturnedMoney();
        addProductsToBill();
    }

    void renewReceipt() throws SQLException {
        txtReceiptsIDReceipts.setText(createNewReceiptID());
        txtTotalReceipts.setText("");
        txtReceivedReceipts.setText("");
        txtReturnReceipts.setText("");
        DefaultTableModel model = (DefaultTableModel) tblReceiptDetails.getModel();
        model.setRowCount(0);
        addProductsToBill();
        createNewReceipt();
    }

    void updateQuantityInReceiptDetails() {
        try {
            List<ReceiptDetails> list = recDetailDAO.selectAll(txtReceiptsIDReceipts.getText());
            for (int i = 0, n = tblReceiptDetails.getRowCount(); i < n; i++) {
                int new_quantity = 0;
                int old_quantity = list.get(i).getQuantity();
                try {
                    new_quantity = Integer.parseInt(tblReceiptDetails.getValueAt(i, 2).toString());
                    if (new_quantity < 0) {
                        new_quantity = old_quantity;
                        tblReceiptDetails.setValueAt(new_quantity, i, 2);
                    }
                } catch (Exception e) {
                    new_quantity = old_quantity;
                    tblReceiptDetails.setValueAt(new_quantity, i, 2);
                }

                int row = tblReceiptDetails.getSelectedRow();
                String inventoryID = storedList.get(i).getInventoryID();
                Inventory inven = receiveIntoInventory.selectById(inventoryID);
                if (old_quantity + inven.getAvaiableQuantity() - new_quantity >= 0) {
                    inven.setAvaiableQuantity(old_quantity + inven.getAvaiableQuantity() - new_quantity);
                    receiveIntoInventory.update(inven);
                } else {
                    MessageAlerts.getInstance().showMessage("THE BOOKSTORE", "Số lượng sản phẩm không đủ!", MessageAlerts.MessageType.WARNING);
                    tblReceiptDetails.setValueAt(old_quantity, i, 2);
                    inven.setAvaiableQuantity(inven.getAvaiableQuantity() + old_quantity);
                    new_quantity = old_quantity;
                }

                ReceiptDetails rd = list.get(i);
                rd.setQuantity(new_quantity);
                recDetailDAO.update(rd);
                storedList.get(i).setQuantity(new_quantity);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void calReturnedMoney() {
        if (!txtTotalReceipts.getText().isBlank()) {
            if (!txtReceivedReceipts.getText().isBlank()) {
                String total = txtTotalReceipts.getText().replace(" ₫", "").replace(".", "");
                String receive = txtReceivedReceipts.getText().replace(" ₫", "").replace(".", "");
                BigDecimal totalMoney = new BigDecimal(total);
                BigDecimal money = new BigDecimal(receive);
                if (money.floatValue() - totalMoney.floatValue() < 0) {
                    txtReturnReceipts.setText("Tiền khách đưa chưa đủ!");
                } else {
                    float returnMoney = money.floatValue() - totalMoney.floatValue();
                    txtReturnReceipts.setText(String.valueOf(vndFormatter.format(returnMoney)));
                    try {
                        Receipts r = receiptDAO.selectById(txtReceiptsIDReceipts.getText());
                        r.setMoneyReturned(returnMoney);
                        r.setCreateDate(new java.sql.Timestamp(r.getCreateDate().getTime()));
                        receiptDAO.update(r);
                    } catch (SQLException ex) {
                        Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            txtReturnReceipts.setText("Vui lòng chọn sản phẩm!");
        }
    }

    void fillProducts() throws SQLException {
        Map<Integer, String[]> map = null;
        String columns[] = {"MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "LOẠI SẢN PHẨM", "THỂ LOẠI", "SỐ LƯỢNG TỒN", "GIÁ BÁN", "MÃ NHẬP KHO"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        if (!chkBook.isSelected() && !chkStationery.isSelected()) {
            MessageAlerts.getInstance().showMessage("THE BOOKSTORE", "Phải có ít nhất một loại sản phẩm được chọn!", MessageAlerts.MessageType.WARNING);
            chkBook.setSelected(true);
            map = prodDAO.selectByTypeOfProduct(1);
        }
        if (chkBook.isSelected() && !chkStationery.isSelected()) {
            map = prodDAO.selectByTypeOfProduct(1);
        } else if (chkStationery.isSelected() && !chkBook.isSelected()) {
            map = prodDAO.selectByTypeOfProduct(2);
        } else {
            map = prodDAO.selectByTypeOfProduct(0);
        }
        for (int i = 0, n = map.size(); i < n; i++) {
            String row[] = map.get(i);
            model.addRow(row);
        }
        tblReceiptProducts.setModel(model);
    }

    Locale locale = new Locale("vi", "VN");
    Currency vnd = Currency.getInstance("VND");
    NumberFormat vndFormatter = NumberFormat.getCurrencyInstance(locale);

    void deleteNullReceipt() throws SQLException {
        if (recDetailDAO.receiptsHaveNoProduct().size() > 0) {
            List<String> ids = recDetailDAO.receiptsHaveNoProduct();
            if (ids != null) {
                for (String id : ids) {
                    receiptDAO.delete(id);
                }
            }

        }
    }

    void addProductsToBill() {
        bill.setText("\t\t  THE BOOKSTORE \n");
        bill.setText(bill.getText() + "\t     FPT Polytechnic Cần Thơ \n");
        bill.setText(bill.getText() + "\t      SĐT: (+84) 715498762\n");
        bill.setText(bill.getText() + "\t         Ngày " + txtCreatedDayReceipts.getText() + "\n");
        bill.setText(bill.getText() + "--------------------------------------------------\n");
        bill.setText(bill.getText() + "Sản phẩm \tSố lượng \tĐơn giá \n");
        bill.setText(bill.getText() + "--------------------------------------------------\n");

        DefaultTableModel df = (DefaultTableModel) tblReceiptDetails.getModel();
        for (int i = 0; i < tblReceiptDetails.getRowCount(); i++) {

            String name = df.getValueAt(i, 1).toString();
            String quantity = df.getValueAt(i, 2).toString();
            String price = df.getValueAt(i, 3).toString();

            bill.setText(bill.getText() + name + "\t" + quantity + "\t\t" + price + " \n");

        }
        bill.setText(bill.getText() + "--------------------------------------------------\n");
        bill.setText(bill.getText() + "Tổng tiền:\t" + txtTotalReceipts.getText() + "\n");
        bill.setText(bill.getText() + "Tiền khách đưa:\t" + txtReceivedReceipts.getText() + "\n");
        bill.setText(bill.getText() + "Tiền thừa:\t" + txtReturnReceipts.getText() + "\n");
        bill.setText(bill.getText() + "==================================================\n");
        bill.setText(bill.getText() + "\tTHE BOOKSTORE xin cảm ơn quý khách !" + "\n");
        bill.setText(bill.getText() + "--------------------------------------------------\n");
    }

    void createNewReceipt() throws SQLException {
        deleteNullReceipt();
        Receipts re = new Receipts();
        re.setID(txtReceiptsIDReceipts.getText());
        re.setEmployeeID(Auth.user.getIdEmployee());
        re.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
        re.setCurrentStatus("Mới");
        receiptDAO.insert(re);

    }

    void sumTotalCost() throws SQLException {
        List<ReceiptDetails> list = recDetailDAO.selectAll(txtReceiptsIDReceipts.getText());
        float sum = 0;
        for (ReceiptDetails rd : list) {
            sum += rd.getQuantity() * rd.getSellingPrice();
        }
        txtTotalReceipts.setText(String.valueOf(vndFormatter.format(sum)));
        Receipts r = receiptDAO.selectById(txtReceiptsIDReceipts.getText());
        r.setTotalCost(sum);
        r.setCreateDate(new java.sql.Timestamp(r.getCreateDate().getTime()));
        receiptDAO.update(r);
    }

    int receiptIndex() throws SQLException {
        deleteNullReceipt();
        String prevID = "";
        String prevDate = "";
        if (receiptDAO.lastestReceipts() != null) {
            prevID = receiptDAO.lastestReceipts();
            prevDate = prevID.substring(2, 10);

        } else {
            return 1;
        }

        prevDate = prevDate.substring(0, 2) + "-" + prevDate.substring(2, 4) + "-" + prevDate.substring(4);
        Date lastDate = XDate.toDate(prevDate, "dd-MM-yyyy");

        String prevIndex = prevID.substring(11);
        int prev = Integer.parseInt(prevIndex);
        if (XDate.addDays(lastDate, 1) == new Date()) {
            now = new Date();
            prev = 1;
        } else {
            prev++;
        }
        return prev;
    }

    Date now = new Date();
    List<ReceiptDetails> storedList;

    String createNewReceiptID() throws SQLException {
        String today = XDate.toString(now, "dd-MM-yyyy");
        String todayFormatted = today.replace("-", "");
        DecimalFormat format = new DecimalFormat("0000");
        String new_ID = "HD" + todayFormatted + "-" + format.format(receiptIndex());
        return new_ID;
    }

    void updateQuantityOnChange() {
        if (storedList != null) {
            for (ReceiptDetails rd : storedList) {
                Inventory i = receiveIntoInventory.selectById(rd.getInventoryID());
                i.setAvaiableQuantity(rd.getQuantity() + i.getAvaiableQuantity());
                receiveIntoInventory.update(i);
            }
        }
    }
    /*---------------------------------------------END OF RECEIPT----------------------------------------*/

 /*------------------------------------------------WAREHOUSE------------------------------------------*/
    Inventory inventory = new Inventory();
    ReceiveIntoInventoryDAO inventoryDAO = new ReceiveIntoInventoryDAO();
    public TableCellRenderer centerData = new TextTableCenter();

    void setColumnTblInventory() {
        Object[] header = new Object[]{"IDnone", "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "MÃ PHẾU NHẬP", "NGÀY NHẬP", "SỐ LƯỢNG", "GIÁ NHẬP(VNĐ)", "GIÁ BÁN(VNĐ)", "TRẠNG THÁI", "VỊ TRÍ", "HÌNH ẢNH", "GHI  CHÚ"};
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7;
            }
        };
        tblInventory.setModel(model);
        model.setColumnIdentifiers(header);

        tblInventory.getColumn("HÌNH ẢNH").setCellRenderer(new TableRendererInventory());

        TableCellEditor editorColumnPrice = new DefaultCellEditor(new JTextField()) {

            private final JTextField textField = (JTextField) editorComponent;

            {

                textField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ((Character.isLetter(c) && !e.isAltDown())
                                || (c == '.' && textField.getCaretPosition() == 0)
                                || c == ','
                                || (c == '0' && textField.getCaretPosition() == 0
                                || (e.getModifiersEx() != 0 && (e.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK) != 0)
                                || (textField.getText().contains(".") && c == '.')
                                || c == '['
                                || c == ']'
                                || c == ';'
                                || c == '\''
                                || c == '/'
                                || c == '='
                                || c == '-')) {
                            e.consume();
                        }
                    }
                });
            }

            ;  
            
             @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                textField.setText("" + value);
                return textField;
            }

            @Override
            public Object getCellEditorValue() {
                return textField.getText();
            }
        };
        TableColumnModel columnModel = tblInventory.getColumnModel();
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);
        columnModel.getColumn(0).setWidth(0);
        tblInventory.getColumnModel().getColumn(7).setCellEditor(editorColumnPrice);
        model.setRowCount(0);
    }

    void fillTblInventory() {
        DecimalFormat formatInventory = new DecimalFormat("#.##");
        model = (DefaultTableModel) tblInventory.getModel();
        List<Object[]> list = inventoryDAO.getViewInventory();
        for (int i = 0; i < list.size(); i++) {
            Object[] entity = list.get(i);
            JLabel productImage = new JLabel();
            ImageIcon icon = XImage.read("src\\product_img", entity[10].toString());
            productImage.setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
            model.addRow(new Object[]{entity[0], entity[1], entity[2], entity[3], entity[4], entity[5], formatInventory.format(entity[6]), formatInventory.format(entity[7]), entity[8], entity[9] == null ? "" : entity[9], productImage, entity[11] == null ? "" : entity[11]});
        }
        tblInventory.setModel(model);
    }

    void refeshIfNoChange() {
        WareHouseReceipts wareHouseReceipts = new WareHouseReceipts();
        wareHouseReceipts = null;
        listAllRemove.clear();
        model = (DefaultTableModel) tblProductDetails.getModel();
        model.setRowCount(0);
        try {
            loadDateTblProductWarehouseReceipts(prodDAO.selectAll());
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtWareHouseReceiptsID.setText("");
        txtReceivingDate.setText(formatterDATE.format(new Date()));
        cboProviders.setSelectedIndex(0);
        groupCurrentStatusWarehouseReceipt.clearSelection();
        txtDecriptionWareHouse.setText("");
        txtReceivingDateGenarel.setText("");
        txtProviderWareHouseReceipts.setText("");
        txtTotalCostWareHouseReciepts.setText(format.format(0));
        pnlWareHouseReceiptsGenarel.setVisible(false);
        pnlWareHouseReceiptsDetails.setVisible(false);
        tblWarehouseReceiptsAll.clearSelection();
        pnlWareHouseReceiptsTableAll.setVisible(true);
        pnlWareHouseReceipts.setVisible(false);
    }

    void setStyleTableInventory() {
        JTableHeader theader = tblInventory.getTableHeader();
        theader.setBackground(Color.red);
        theader.setForeground(Color.red);
        theader.setFont(new Font("Tahome", Font.BOLD, 10));
        ((DefaultTableCellRenderer) theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    DecimalFormat format = new DecimalFormat("#,###.##' VNĐ' ");

    WareHouseReceipts wareHouseReceipts = new WareHouseReceipts();
    WareHouseReceiptsDAO wareHouseReceiptsDAO = new WareHouseReceiptsDAO();
    WareHouseReceiptDetails wareHouseReceiptDetails = new WareHouseReceiptDetails();
    WareHouseReceiptDetailsDAO wareHouseReceiptDetailsDAO = new WareHouseReceiptDetailsDAO();
    ReceiveIntoInventoryDAO receiveIntoInventory = new ReceiveIntoInventoryDAO();

    DefaultTableModel model;

    boolean checkNullWareHouseReceipts() {
        if (!rdoPaid.isSelected() && !rdoUnpaid.isSelected()) {
            MsgBox.alert(this, "Vui lòng chọn trạng thái !");
            return false;
        }
        return true;
    }

    void setLayoutPnlWareHouse() {
        pnlWareHouseReceiptsGenarel.setVisible(false);
        txtWareHouseReceiptGeneral.setEditable(false);
        txtTotalCostWareHouseReciepts.setEditable(false);
        txtCurrentStatus.setEditable(false);
        pnlWareHouseReceiptsDetails.setVisible(false);
        pnlWareHouseReceipts.setVisible(false);
        txtReceivingDate.setEditable(false);
        txtTotalCostWareHouseReciepts.setText("0");
        txtReceivingDateGenarel.setEditable(false);
        txtReceivingDateGenarel.setEditable(false);
        txtProviderWareHouseReceipts.setEditable(false);
    }

    void createWareHouseReceipts() {
        if (!pnlWareHouseReceiptsGenarel.isVisible() && !pnlWareHouseReceiptsDetails.isVisible()) {
            Date dateNow = new Date();
            pnlWareHouseReceipts.setVisible(true);
            pnlWareHouseReceiptsTableAll.setVisible(false);
            txtReceivingDate.setText(XDate.toString(dateNow, "dd-MM-yyyy"));
        } else {
            MsgBox.alert(this, "Bạn chưa hoàn tất lưu phiếu nhập hiện tại !");
        }
    }

    void vefifyWareHouseReceipts() {
        if (checkNullWareHouseReceipts()) {
            pnlWareHouseReceiptsGenarel.setVisible(true);
            pnlWareHouseReceipts.setVisible(false);
            txtWareHouseReceiptGeneral.setText(getFormWareHouseReceipts().getID());
            txtCurrentStatus.setText(checkCurrentStatus());
            txtProviderWareHouseReceipts.setText(cboProviders.getSelectedItem().toString());
            pnlWareHouseReceiptsDetails.setVisible(true);
            txtWareHouseReceiptGeneral.setText(checkWareHouseReceiptsID());
            txtReceivingDateGenarel.setText(txtReceivingDate.getText());
            setFormWareHouseReceipstGenarel(getFormWareHouseReceipts());
        }
    }

    private static final String randomCharacter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    String randomWarehouse() {
        int codeLength = 16;
        String radomCode = generateRandomCode(codeLength);
        return radomCode;
    }

    String generateRandomCode(int lenght) {
        SecureRandom random = new SecureRandom();
        StringBuilder str = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++) {
            int index = random.nextInt(randomCharacter.length());
            str.append(randomCharacter.charAt(index));
        }
        return str.toString();
    }

    String checkWareHouseReceiptsID() {
        if (txtWareHouseReceiptsID.getText().trim().isEmpty()) {
            return randomWarehouse();
        } else {
            return txtWareHouseReceiptsID.getText();
        }
    }

    String checkCurrentStatus() {
        if (rdoPaid.isSelected()) {
            return rdoPaid.getText();
        } else {
            return rdoUnpaid.getText();
        }
    }

    void openAllWareHouseReceipts() {
        pnlWareHouseReceiptsGenarel.setVisible(false);
        pnlWareHouseReceiptsDetails.setVisible(false);
        pnlWareHouseReceiptsTableAll.setVisible(true);
    }

    void editWareHouseReceipts() {
        pnlWareHouseReceiptsGenarel.setVisible(true);
        pnlWareHouseReceiptsDetails.setVisible(true);
        pnlWareHouseReceiptsTableAll.setVisible(false);
        pnlWareHouseReceipts.setVisible(false);
        checkEditWareHouseReceipts();
    }

    void checkEditWareHouseReceipts() {
        if (!txtWareHouseReceiptGeneral.getText().trim().isEmpty()) {
            txtWareHouseReceiptsID.setText(txtWareHouseReceiptGeneral.getText().trim());
        }
    }

    void editWareHouseReceiptsPrimary() {
        pnlWareHouseReceiptsGenarel.setVisible(false);
        pnlWareHouseReceiptsDetails.setVisible(false);
        pnlWareHouseReceiptsTableAll.setVisible(false);
        pnlWareHouseReceipts.setVisible(true);
        checkEditWareHouseReceipts();
        WareHouseReceipts warehouseReceipt = wareHouseReceiptsDAO.selectById(txtWareHouseReceiptGeneral.getText());
        setFormWareHouseReceipst(warehouseReceipt);
    }

    void fillCboProviderWareHouseReceipts() throws SQLException {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<Providers> list = new ProviderDAO().selectAll();
        for (int i = 0; i < list.size(); i++) {
            model.addElement(list.get(i));
        }
        cboProviders.setModel(model);
    }

    void setFormWareHouseReceipstGenarel(WareHouseReceipts wareHouseReceipts) {
        if (wareHouseReceipts != null) {
            txtWareHouseReceiptGeneral.setText(wareHouseReceipts.getID());
            if (wareHouseReceipts.getReceivingDate() == null) {
                txtReceivingDateGenarel.setText("" + formatterDATE.format(new Date()));
            } else {
                txtReceivingDateGenarel.setText("" + formatterDATE.format(wareHouseReceipts.getReceivingDate()));
            }
            txtProviderWareHouseReceipts.setText("" + wareHouseReceiptsDAO.IDtoName(wareHouseReceipts.getProviderID()));
            txtCurrentStatus.setText(wareHouseReceipts.getCurrentStatus());
            if (wareHouseReceipts.getTotalCost() != null) {
                txtTotalCostWareHouseReciepts.setText(format.format(wareHouseReceipts.getTotalCost()));
            }
        }
    }

    void setFormWareHouseReceipst(WareHouseReceipts warehouseReceipt) {
        if (warehouseReceipt != null) {
            try {
                txtWareHouseReceiptsID.setText(warehouseReceipt.getID());
                txtReceivingDate.setText(formatterDATE.format(warehouseReceipt.getReceivingDate()));
                Providers provider = new ProviderDAO().selectById(warehouseReceipt.getProviderID());
                for (int i = 0; i < cboProviders.getItemCount(); i++) {
                    if (cboProviders.getItemAt(i).getProvidersID() == provider.getProvidersID()) {
                        cboProviders.setSelectedIndex(i);
                        break;
                    }
                }
                if (warehouseReceipt.getCurrentStatus().equalsIgnoreCase("ĐÃ THANH TOÁN")) {
                    rdoPaid.setSelected(true);
                } else {
                    rdoUnpaid.setSelected(true);
                }
                txtDecriptionWareHouse.setText(warehouseReceipt.getMoreInfo());
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    WareHouseReceipts getFormWareHouseReceipts() {
        Providers provider = (Providers) cboProviders.getSelectedItem();
        WareHouseReceipts wareHouseReceipts = new WareHouseReceipts();
        if (provider != null) {
            if (txtWareHouseReceiptsID.getText().trim().isEmpty()) {
                txtWareHouseReceiptsID.setText(randomWarehouse());
                wareHouseReceipts.setID(txtWareHouseReceiptsID.getText());
            } else {
                wareHouseReceipts.setID(txtWareHouseReceiptsID.getText().trim());
            }
            wareHouseReceipts.setProviderID(provider.getProvidersID());
            wareHouseReceipts.setReceivingDate(XDate.toDate(txtReceivingDate.getText(), "dd-MM-yyyy"));
            wareHouseReceipts.setTotalCost(null);
            wareHouseReceipts.setCurrentStatus(rdoPaid.isSelected() ? "ĐÃ THANH TOÁN" : "CHƯA THANH TOÁN");
            wareHouseReceipts.setMoreInfo(txtDecriptionWareHouse.getText());
        }
        return wareHouseReceipts;
    }

    WareHouseReceipts getFormWarehouseReceiptGeneral() {
        WareHouseReceipts wareHouseReceipts = new WareHouseReceipts();
        Providers provider = (Providers) cboProviders.getSelectedItem();
        if (provider != null) {
            wareHouseReceipts.setID(txtWareHouseReceiptGeneral.getText());
            wareHouseReceipts.setProviderID(provider.getProvidersID());
            wareHouseReceipts.setReceivingDate(XDate.toDate(txtReceivingDateGenarel.getText(), "dd-MM-yyyy"));
            wareHouseReceipts.setTotalCost(Double.parseDouble("" + txtTotalCostWareHouseReciepts.getText().substring(0, txtTotalCostWareHouseReciepts.getText().indexOf(" ")).replaceAll(",", "")));
            wareHouseReceipts.setCurrentStatus(txtCurrentStatus.getText());
            wareHouseReceipts.setMoreInfo(txtDecriptionWareHouse.getText());
        }
        return wareHouseReceipts;
    }

    class TableRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            TableColumn tbl = tblProductWarehouseReceipt.getColumn("HÌNH ẢNH");
            tbl.setMaxWidth(100);
            tbl.setMinWidth(100);
            tblProductWarehouseReceipt.setRowHeight(80);
            return (Component) value;
        }
    }

    class TableRendererInventory implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            TableColumn tbl = tblInventory.getColumn("HÌNH ẢNH");
            tbl.setMaxWidth(100);
            tbl.setMinWidth(100);
            tblInventory.setRowHeight(80);
            return (Component) value;
        }
    }

    void setTblProductWareHouseReceipt() {
        Object[] header = new Object[]{"MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "HÌNH ẢNH"};
        model = (DefaultTableModel) tblProductWarehouseReceipt.getModel();
        model.setColumnIdentifiers(header);
        tblProductWarehouseReceipt.getColumn("HÌNH ẢNH").setCellRenderer(new TableRenderer());
        model.setRowCount(0);
        tblProductWarehouseReceipt.getTableHeader().setReorderingAllowed(false);
    }

    void loadDateTblProductWarehouseReceipts(List<Products> list) throws SQLException {
        Collections.sort(list, new Comparator<Products>() {
            public int compare(Products o1, Products o2) {
                return o1.getID().compareTo(o2.getID());
            }
        });
        Collections.reverse(list);
        model = (DefaultTableModel) tblProductWarehouseReceipt.getModel();
        model.setRowCount(0);
        HashSet<String> setData = new HashSet<>();
        if (listAllRemove.size() > 0) {
            for (int i = 0; i < listAllRemove.size(); i++) {
                setData.add(listAllRemove.get(i).getID());
            }
            for (int i = 0; i < list.size(); i++) {
                if (!setData.contains(list.get(i).getID())) {
                    JLabel productImage = new JLabel();
                    ImageIcon icon = XImage.read("src\\product_img", list.get(i).getImagePath());
                    productImage.setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                    model.addRow(new Object[]{list.get(i).getID(), list.get(i).getProductName(), productImage});
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                JLabel productImage = new JLabel();
                ImageIcon icon = XImage.read("src\\product_img", list.get(i).getImagePath());
                productImage.setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                model.addRow(new Object[]{list.get(i).getID(), list.get(i).getProductName(), productImage});
            }
        }

    }

    List<Products> listAllRemove = new ArrayList<>();

    List<Products> addProductIntoWarehouseReceiptDetails(int[] choosenRows) throws SQLException {
        model = (DefaultTableModel) tblProductWarehouseReceipt.getModel();
        List<Products> list = new ArrayList<>();
        for (int i = 0; i < choosenRows.length; i++) {
            int index = choosenRows[i];
            Products products = new Products();
            products = prodDAO.selectByIdSQL("" + tblProductWarehouseReceipt.getValueAt(index, 0));
            list.add(products);
        }

        for (Products products : list) {
            listAllRemove.add(products);
        }
        Collections.sort(listAllRemove, new Comparator<Products>() {
            public int compare(Products o1, Products o2) {
                return o1.getID().compareTo(o2.getID());
            }
        });
        return list;
    }

    void RenderProduct(List<Products> list) throws SQLException {
        Set<String> listIDs = new HashSet<>();
        for (Products listID : list) {
            listIDs.add(listID.getID());
        }
        List<Products> listAllProduct = prodDAO.selectAll();
        model = (DefaultTableModel) tblProductWarehouseReceipt.getModel();
        model.setRowCount(0);
        for (int i = listAllProduct.size() - 1; i >= 0; i--) {
            if (!listIDs.contains(listAllProduct.get(i).getID())) {
                JLabel productImage = new JLabel();
                ImageIcon icon = XImage.read("src\\product_img", listAllProduct.get(i).getImagePath());
                productImage.setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                model.addRow(new Object[]{listAllProduct.get(i).getID(), listAllProduct.get(i).getProductName(), productImage});
            }

        }
        Collections.sort(listAllProduct, new Comparator<Products>() {
            public int compare(Products o1, Products o2) {
                return o2.getID().compareTo(o2.getID());
            }
        });
    }

    void setColumnTblProductDetails() {
        String header[] = {"MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ (VNĐ)", "TRẠNG THÁI", "VỊ TRÍ", "GHI CHÚ"};
        DefaultTableModel model = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 3 || column == 4 || column == 5 || column == 6;
            }
        };

        tblProductDetails.setModel(model);

        TableCellEditor editorColumnPrice = new DefaultCellEditor(new JTextField()) {

            private final JTextField textField = (JTextField) editorComponent;

            {

                textField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ((Character.isLetter(c) && !e.isAltDown())
                                || (c == '.' && textField.getCaretPosition() == 0)
                                || c == ','
                                || (c == '0' && textField.getCaretPosition() == 0
                                || (e.getModifiersEx() != 0 && (e.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK) != 0)
                                || (textField.getText().contains(".") && c == '.')
                                || c == '['
                                || c == ']'
                                || c == ';'
                                || c == '\''
                                || c == '/'
                                || c == '='
                                || c == '-')) {
                            e.consume();
                        }
                    }
                });
            }

            ;
                
            
             @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                textField.setText("" + value);
                return textField;
            }

            @Override
            public Object getCellEditorValue() {
                return textField.getText();
            }
        };

        TableCellEditor editorColumnQuantity = new DefaultCellEditor(new JTextField()) {

            private final JTextField textField = (JTextField) editorComponent;

            {

                textField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!Character.isDigit(c) || (c == '0' && textField.getCaretPosition() == 0)) {
                            e.consume();
                        }
                    }
                ;

            }

            );
            
            };
            
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                textField.setText("" + value);
                return textField;
            }

            ;
            
            public Object getCellEditorValue() {
                return textField.getText();
            }

        };

        tblProductDetails.getColumnModel().getColumn(3).setCellEditor(editorColumnPrice);
        tblProductDetails.getColumnModel().getColumn(2).setCellEditor(editorColumnQuantity);
        tblProductDetails.getTableHeader().setReorderingAllowed(false);

    }

    void loadDateTblProductDetails(List<Products> list) {
        model = (DefaultTableModel) tblProductDetails.getModel();
        model.setRowCount(0);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                model.addRow(new Object[]{list.get(i).getID(), list.get(i).getProductName(), 1, "", "NGUYÊN VẸN", "", ""});
            }
        }
        tblProductDetails.setRowHeight(30);
    }

    int[] deleteProducts() {
        return tblProductDetails.getSelectedRows();
    }

    void removeProductExits(int[] choosenRows) throws SQLException {
        List<Products> list = new ArrayList<>();
        for (int i = choosenRows.length - 1; i >= 0; i--) {

            Products product = new Products();
            product = prodDAO.selectByIdSQL("" + tblProductDetails.getValueAt(choosenRows[i], 0));
            list.add(product);

        }
        Set<String> LisIDs = new HashSet<>();
        for (Products products : list) {
            LisIDs.add(products.getID());
        }

        for (int i = listAllRemove.size() - 1; i >= 0; i--) {
            Products value = listAllRemove.get(i);
            if (LisIDs.contains(value.getID())) {
                listAllRemove.remove(value);
            }
        }

    }

    void RenderProductAfterRemove(List<Products> list) throws SQLException {
        Set<String> listIDs = new HashSet<>();
        for (Products listID : list) {
            listIDs.add(listID.getID());
        }
        List<Products> listAllProduct = prodDAO.selectAll();
        model = (DefaultTableModel) tblProductWarehouseReceipt.getModel();
        model.setRowCount(0);

        for (int i = listAllProduct.size() - 1; i >= 0; i--) {
            if (!listIDs.contains(listAllProduct.get(i).getID())) {
                JLabel productImage = new JLabel();
                ImageIcon icon = XImage.read("src\\product_img", listAllProduct.get(i).getImagePath());
                productImage.setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                model.addRow(new Object[]{listAllProduct.get(i).getID(), listAllProduct.get(i).getProductName(), productImage});
            }
        }
        Collections.sort(listAllRemove, new Comparator<Products>() {
            public int compare(Products o1, Products o2) {
                return o1.getID().compareTo(o2.getID());
            }
        });
    }

    void checkProductDetailsChoosenDelete(int[] choosenRows) {
        model = (DefaultTableModel) tblProductDetails.getModel();
        for (int i = choosenRows.length - 1; i >= 0; i--) {
            int index = choosenRows[i];
            if (index >= 0 && index < model.getRowCount()) {
                model.removeRow(index);
            }
        }
    }

    boolean checkWarehouseReceipts(String id) {
        List<WareHouseReceipts> list = wareHouseReceiptsDAO.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getID())) {
                return true;
            }
        }
        return false;
    }

    List<WareHouseReceiptDetails> getTableProductDetails() {
        List<WareHouseReceiptDetails> list = new ArrayList<>();
        for (int i = 0; i < tblProductDetails.getRowCount(); i++) {
            WareHouseReceiptDetails warehouseReceiptDetails = new WareHouseReceiptDetails();
            warehouseReceiptDetails.setProductID("" + tblProductDetails.getValueAt(i, 0));
            warehouseReceiptDetails.setWareHouseReceiptID(txtWareHouseReceiptsID.getText());
            warehouseReceiptDetails.setQuantity(Integer.parseInt("" + tblProductDetails.getValueAt(i, 2)));
            warehouseReceiptDetails.setReceivingPrice(Double.parseDouble("" + tblProductDetails.getValueAt(i, 3)));
            warehouseReceiptDetails.setCurrentStatus("" + tblProductDetails.getValueAt(i, 4));
            warehouseReceiptDetails.setMoreInfo("" + tblProductDetails.getValueAt(i, 6));
            list.add(warehouseReceiptDetails);
        }
        return list;
    }

    void addProductDetailsAndReceiveIntoInventory(List<WareHouseReceiptDetails> list) {
        try {
            DecimalFormat format = new DecimalFormat();
            if (checkWarehouseReceipts(txtWareHouseReceiptGeneral.getText())) {
                wareHouseReceiptsDAO.update(getFormWarehouseReceiptGeneral());
                XJdbc.update("DELETE Inventory WHERE WarehouseReceiptID =? DELETE WarehouseReceiptDetails WHERE WarehouseReceiptID=?", txtWareHouseReceiptGeneral.getText(), txtWareHouseReceiptGeneral.getText());
                for (int i = 0; i < list.size(); i++) {
                    wareHouseReceiptDetailsDAO.insert(list.get(i));
                    receiveIntoInventory.insertAll(list.get(i), "" + tblProductDetails.getValueAt(i, 5));
                }

                MsgBox.alert(this, "Lưu Phiếu Nhập Thành Công !");
                setLayoutPnlWareHouse();
                this.fillTblInventory();
                this.fillTableWarehouseReceipts();
                refeshIfNoChange();
                refeshTblProductDetails();
            } else {
                wareHouseReceiptsDAO.insert(getFormWarehouseReceiptGeneral());
                for (int i = 0; i < list.size(); i++) {
                    wareHouseReceiptDetailsDAO.insert(list.get(i));
                    receiveIntoInventory.insertAll(list.get(i), "" + tblProductDetails.getValueAt(i, 5));
                }
                MsgBox.alert(this, "Lưu Phiếu Nhập Thành Công !");
                setLayoutPnlWareHouse();
                this.fillTblInventory();
                this.fillTableWarehouseReceipts();
                refeshIfNoChange();
                refeshTblProductDetails();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Không thể thực hiện thao tác xóa hay chỉnh sửa với phiếu nhập có sản phẩm đã xuất hóa đơn !");
        }

    }

    void createWarehouseReceiptNew() {
        Date dateNow = new Date();
        WareHouseReceipts warehouseReceipt = new WareHouseReceipts();
        setFormWareHouseReceipst(warehouseReceipt);
        setFormWareHouseReceipstGenarel(wareHouseReceipts);
        pnlWareHouseReceiptsGenarel.setVisible(false);
        pnlWareHouseReceiptsDetails.setVisible(false);
        pnlWareHouseReceiptsTableAll.setVisible(false);
        pnlWareHouseReceipts.setVisible(true);
        txtReceivingDate.setText(XDate.toString(dateNow, "dd-MM-yyyy"));
    }

    void refeshTblProductDetails() {
        try {
            model = (DefaultTableModel) tblProductDetails.getModel();
            model.setRowCount(0);
            DefaultTableModel model2 = (DefaultTableModel) tblProductWarehouseReceipt.getModel();
            model2.setRowCount(0);
            listAllRemove.clear();
            loadDateTblProductWarehouseReceipts(prodDAO.selectAll());
        } catch (SQLException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void sumPrice() {
        double sum = 0;
        for (int i = 0; i < tblProductDetails.getRowCount(); i++) {
            if (tblProductDetails.getValueAt(i, 3) != null && tblProductDetails.getValueAt(i, 3).toString().matches("^[-+]?(\\d+(\\.\\d*)?|\\.\\d+)$")) {
                sum += Double.parseDouble("" + tblProductDetails.getValueAt(i, 2)) * Double.parseDouble("" + tblProductDetails.getValueAt(i, 3));
            }
        }
        txtTotalCostWareHouseReciepts.setText("" + format.format(sum));
    }

    void fillTableWarehouseReceipts() {
        List<WareHouseReceipts> list = wareHouseReceiptsDAO.selectAll();
        model = (DefaultTableModel) tblWarehouseReceiptsAll.getModel();
        String header[] = {"MÃ PHIẾU NHẬP", "NHÀ CUNG CẤP", "NGÀY TẠO", "TỔNG TIỀN", "TRẠNG THÁI", "GHI CHÚ"};
        model.setColumnIdentifiers(header);
        model.setRowCount(0);
        tblWarehouseReceiptsAll.setRowHeight(30);
        for (int i = 0; i < list.size(); i++) {
            String providerName = new ProviderDAO().selectName(list.get(i).getProviderID());
            model.addRow(new Object[]{list.get(i).getID(), providerName, XDate.toString(list.get(i).getReceivingDate(), "dd-MM-yyyy"), format.format(list.get(i).getTotalCost()), list.get(i).getCurrentStatus(), list.get(i).getMoreInfo()});
        }
        tblWarehouseReceiptsAll.setModel(model);
    }

    void searchWarehouseReceiptID(String id) {
        List<WareHouseReceipts> list = wareHouseReceiptsDAO.searchIDWarehouseReceipts(id);
        model = (DefaultTableModel) tblWarehouseReceiptsAll.getModel();
        String header[] = {"MÃ PHIẾU NHẬP", "NHÀ CUNG CẤP", "NGÀY TẠO", "TỔNG TIỀN", "TRẠNG THÁI", "GHI CHÚ"};
        model.setColumnIdentifiers(header);
        model.setRowCount(0);
        tblWarehouseReceiptsAll.setRowHeight(30);
        for (int i = 0; i < list.size(); i++) {
            String providerName = provDAO.selectName(list.get(i).getProviderID());
            model.addRow(new Object[]{list.get(i).getID(), providerName, XDate.toString(list.get(i).getReceivingDate(), "dd-MM-yyyy"), format.format(list.get(i).getTotalCost()), list.get(i).getCurrentStatus(), list.get(i).getMoreInfo()});
        }
        tblWarehouseReceiptsAll.setModel(model);
    }

    boolean checkValid() {
        boolean check = false;
        String header[] = {"MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ", "TRẠNG THÁI", "VỊ TRÍ", "GHI CHÚ"};
        for (int i = 0; i < tblProductDetails.getRowCount(); i++) {
            if (tblProductDetails.getValueAt(i, 2) == null || (tblProductDetails.getValueAt(i, 2) != null && tblProductDetails.getValueAt(i, 2).toString().equals(""))) {
                MsgBox.alert(this, "Vui lòng không để trống số lượng !");
                return false;
            } else if (!tblProductDetails.getValueAt(i, 2).toString().matches("^[-+]?\\d+$")) {
                MsgBox.alert(this, "Vui lòng nhập số lượng là số nguyên !");
                return false;
            } else if (Integer.parseInt(tblProductDetails.getValueAt(i, 2).toString()) <= 0) {
                MsgBox.alert(this, "Vui lòng nhập số lượng lớn hơn 0 !");
                return false;
            } else if (tblProductDetails.getValueAt(i, 3) == null || (tblProductDetails.getValueAt(i, 3) != null && tblProductDetails.getValueAt(i, 3).toString().equals(""))) {
                MsgBox.alert(this, "Vui lòng không để trống đơn giá !");
                return false;
            } else if (tblProductDetails.getValueAt(i, 3) != null && !tblProductDetails.getValueAt(i, 3).toString().matches("^[-+]?(\\d+(\\.\\d*)?|\\.\\d+)$")) {
                MsgBox.alert(this, "Đơn giá vui lòng nhập số !");
                return false;
            } else if (tblProductDetails.getValueAt(i, 3) != null && Double.parseDouble(tblProductDetails.getValueAt(i, 3).toString()) <= 0) {
                MsgBox.alert(this, "Vui lòng nhập đơn giá lớn hơn 0 !");
                return false;
            } else if (tblProductDetails.getValueAt(i, 4) == null || (tblProductDetails.getValueAt(i, 4) != null && tblProductDetails.getValueAt(i, 4).toString().equals(""))) {
                MsgBox.alert(this, "Vui lòng không để trống trạng thái !");
                return false;
            } else if (tblProductDetails.getValueAt(i, 5) == null || (tblProductDetails.getValueAt(i, 5) != null && tblProductDetails.getValueAt(i, 5).toString().equals(""))) {
                MsgBox.alert(this, "Vui lòng không để trống vị trí !");
                return false;
            } else {
                check = true;
            }
        }
        if (Double.parseDouble("" + txtTotalCostWareHouseReciepts.getText().substring(0, txtTotalCostWareHouseReciepts.getText().indexOf(" ")).replace(",", "")) == 0) {
            MsgBox.alert(this, "Vui lòng thêm sản phẩm để tạo phiếu nhập !");
            return false;
        }
        return check;
    }

    void addProductIntoProductDetails() {
        if (tblProductWarehouseReceipt.getSelectedRows().length > 0) {
            try {
                addProductIntoWarehouseReceiptDetails(tblProductWarehouseReceipt.getSelectedRows());
                RenderProduct(listAllRemove);
                loadDateTblProductDetails(listAllRemove);
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            MsgBox.alert(this, "Vui lòng chọn sản phẩm để thêm !");
        }
    }

    void deleteProductDetails() {
        if (tblProductDetails.getSelectedRows().length > 0) {
            try {
                removeProductExits(deleteProducts());
                checkProductDetailsChoosenDelete(deleteProducts());
                RenderProductAfterRemove(listAllRemove);
                sumPrice();
            } catch (SQLException ex) {
                Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            MsgBox.alert(this, "Vui lòng chọn sản phẩm để xóa !");
        }
    }

    void loadDataReport(int row) throws SQLException, ClassNotFoundException {
        Class.forName(XJdbc.driver);
        String id = "'" + tblWarehouseReceiptsAll.getValueAt(row, 0).toString() + "'";
        try {
            JasperDesign design = JRXmlLoader.load("src\\Report\\WarehouseReceipts.jrxml");
            JRDesignQuery query = new JRDesignQuery();
            query.setText("SELECT wh.ID AS ID, prv.ProviderName AS ProviderName, wh.ReceivingDate AS ReceivingDate, wh.CurrentStatus AS CurrentStatusWh, wh.TotalCost AS TotalCost, whd.ProductID AS ProductID, prd.ProductName, whd.Quantity AS Quantity, whd.ReceivingPrice AS ReceivingPrice, whd.CurrentStatus AS CurrentStatus FROM WarehouseReceiptDetails whd JOIN WarehouseReceipts wh ON wh.ID = whd.WarehouseReceiptID JOIN Products prd ON whd.ProductID = prd.ID JOIN Providers prv ON wh.ProviderID = prv.ID WHERE wh.ID = " + id);
            design.setQuery(query);
            JasperReport report = JasperCompileManager.compileReport(design);
            JasperPrint print = JasperFillManager.fillReport(report, null, DriverManager.getConnection(XJdbc.dburl, XJdbc.user, XJdbc.pass));
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(TheBookStoreJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void deleteWarehouseReceipts(int[] rows) {
        if (MsgBox.confirm(this, "Bạn có chắc chắn muốn xóa thông tin này không?")) {
            for (int i = 0; i < rows.length; i++) {
                wareHouseReceiptsDAO.deleteAll("" + tblWarehouseReceiptsAll.getValueAt(rows[i], 0), "" + tblWarehouseReceiptsAll.getValueAt(rows[i], 0), "" + tblWarehouseReceiptsAll.getValueAt(rows[i], 0));
            }
            MsgBox.alert(this, "Xóa thành công !");
            fillTableWarehouseReceipts();
            fillTblInventory();
        }
    }

    void editWarehouseReceiptsRow(int row) throws SQLException {
        if (row != -1) {
            WareHouseReceipts warehouseReceipt = wareHouseReceiptsDAO.selectById("" + tblWarehouseReceiptsAll.getValueAt(row, 0));
            txtWareHouseReceiptGeneral.setText(warehouseReceipt.getID());
            txtReceivingDateGenarel.setText("" + formatterDATE.format(warehouseReceipt.getReceivingDate()));
            txtProviderWareHouseReceipts.setText("" + wareHouseReceiptsDAO.IDtoName(warehouseReceipt.getProviderID()));
            txtCurrentStatus.setText(warehouseReceipt.getCurrentStatus());
            for (int i = 0; i < cboProviders.getItemCount(); i++) {
                if (cboProviders.getItemAt(i).getProvidersID() == warehouseReceipt.getProviderID()) {
                    cboProviders.setSelectedIndex(i);
                    break;
                }
            }
            model = (DefaultTableModel) tblProductWarehouseReceipt.getModel();
            List<WareHouseReceiptDetails> list = wareHouseReceiptDetailsDAO.selectByIdAll(warehouseReceipt.getID());
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    String idProduct = list.get(i).getProductID();
                    Products product = prodDAO.selectByIdSQL(idProduct);
                    listAllRemove.add(product);
                }
                loadDateTblProductDetailsEdit(warehouseReceipt);
                RenderProduct(listAllRemove);
                txtTotalCostWareHouseReciepts.setText("" + format.format(warehouseReceipt.getTotalCost()));
                editWareHouseReceipts();
            }
        }
    }

    void loadDateTblProductDetailsEdit(WareHouseReceipts warehouseReceipt) {
        DecimalFormat formatPrice = new DecimalFormat("#.##");
        model = (DefaultTableModel) tblProductDetails.getModel();
        model.setRowCount(0);
        List<Object[]> list = wareHouseReceiptDetailsDAO.selectEdit(warehouseReceipt.getID());
        for (int i = 0; i < list.size(); i++) {
            Object[] entity = list.get(i);
            String area = receiveIntoInventory.selectArea(entity[6].toString(), entity[0].toString());
            model.addRow(new Object[]{entity[0], entity[1], entity[2], formatPrice.format(entity[3]), entity[4], area == null ? "" : area, entity[5] == null ? "" : entity[5]});

        }
        tblProductDetails.setRowHeight(30);
    }

    void updatePriceInventory() {
        model = (DefaultTableModel) tblInventory.getModel();
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    Object newValue = model.getValueAt(row, column);
                    XJdbc.update("UPDATE Inventory SET SellingPrice =? WHERE ID =?", Double.parseDouble("" + newValue), "" + model.getValueAt(row, 0));
                    tblInventory.clearSelection();
                }
            }
        });
    }

    void searchInventory(String name) {
        DecimalFormat formatInventory = new DecimalFormat("#.##");
        model = (DefaultTableModel) tblInventory.getModel();
        model.setRowCount(0);
        List<Object[]> list = inventoryDAO.getDataInventory(name);
        for (int i = 0; i < list.size(); i++) {
            Object[] entity = list.get(i);
            JLabel productImage = new JLabel();
            ImageIcon icon = XImage.read("src\\product_img", entity[10].toString());
            productImage.setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
            model.addRow(new Object[]{entity[0], entity[1], entity[2], entity[3], entity[4], entity[5], formatInventory.format(entity[6]), formatInventory.format(entity[7]), entity[8], entity[9] == null ? "" : entity[9], productImage, entity[11] == null ? "" : entity[11]});
        }
        tblInventory.setModel(model);
    }
    /*--------------------------------------------END OF WAREHOUSE---------------------------------------*/
 /*--------------------------------------------START OF STATISTICS---------------------------------------*/
    // ===== Statistics
    Date dateStart;
    Date dateEnd;

    void fillTableStatistics() {
        String columns[] = {"THỜI GIAN", "DOANH THU"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        dateStart = this.startDate.getDate();
        dateEnd = this.endDate.getDate();

        // Gọi phương thức getDoanhThu với ngày bắt đầu và kết thúc
        List<Object[]> list = statsDAO.getDoanhThu(dateStart, dateEnd);

        // Thêm dữ liệu vào bảng
        for (Object[] row : list) {
            // Đảm bảo row không null và có đủ số lượng cột
            if (row != null && row.length == 2) {
                try {
                    model.addRow(new Object[]{formatterDATE.format(row[0]), formatterVND.format(row[1])});
                } catch (Exception e) {
                    // Xử lý ngoại lệ nếu định dạng không hợp lệ
                    System.err.println("Error formatting data: " + e.getMessage());
                }
            }
        }
        tblStatistics.setModel(model);
    }

//    private void addPropertyChangeListeners() {
//        startDate.addPropertyChangeListener("date", evt -> fillTableStatistics());
//        endDate.addPropertyChangeListener("date", evt -> fillTableStatistics());
//    }
    void resetDateStatistic() {
        startDate.setDate(null);
        endDate.setDate(null);
    }

    public void showLineChart() throws SQLException {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (dateStart == null || dateEnd == null) {
            String now = XDate.toString(new Date(), "dd-MM-yyyy");
            dateStart = XDate.toDate("01-01-" + now.substring(now.lastIndexOf("-") + 1), "dd-MM-yyyy");
            dateEnd = new Date();
        }
        List<Object[]> list = statsDAO.getDoanhThu(dateStart, dateEnd);
        for (Object[] obj : list) {
            dataset.setValue(Double.parseDouble(obj[1].toString()), "Total",
                    formatterDATE.format(obj[0]));
        }

        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Thống kê doanh thu từ " + XDate.toString(dateStart, "dd-MM-yyyy") + " đến "
                + XDate.toString(dateEnd, "dd-MM-yyyy"), "Doanh thu", "Ngày",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        lineCategoryPlot.setNoDataMessage("Không có dữ liệu!");
        NumberAxis rangeAxis = (NumberAxis) lineCategoryPlot.getRangeAxis();
        rangeAxis.setAutoRange(false);
        lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);

        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        pnlChart.removeAll();
        pnlChart.add(lineChartPanel, BorderLayout.CENTER);
        pnlChart.validate();

    }

    /*--------------------------------------------END OF STATISTICS---------------------------------------*/
 /*--------------------------------------------START OF CHANGEPASSWORD---------------------------------------*/
    public boolean checkEmployeesChange() {
        //Form ChangPassword
        String employeePassword = "^[a-zA-Z0-9._%+-]{6,50}$";

        if (txtOldPassword.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập mật khẩu cũ!");
            return true;
        }
        if (txtNewPassword1.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập mật khẩu mới!");
            return true;
        }
        if (!txtNewPassword1.getText().matches(employeePassword)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Mật khẩu tối thiểu 6 kí tự và tối đa 50 kí tự!");
            return true;
        }
        if (txtNewPassword2.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng xác nhận mật khẩu mới!");
            return true;
        }
        if (txtNewPassword2.equals(txtNewPassword1.getText())) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Xác nhận mật khẩu không trùng khớp!");
            return true;
        }
        if (txtOldPassword.equals(txtNewPassword1.getText())) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Mật khẩu mới đã trùng mật khẩu cũ!");
            return true;
        }
        return false;
    }

    /*--------------------------------------------END OF CHANGEPASSWORD---------------------------------------*/
    void initBook() throws SQLException {
        fillTableBook();
        resizeColumnsToContent(tblBook);
        tblBook.setDefaultEditor(Object.class, null);
        txtBookID.setEditable(false);
        addGenre();
        txtBookAddedBy.setText(Auth.user.getEmployeeName());
        clearBookForm();
    }

    void initStationery() throws SQLException {
        fillTblStationery();
        addStationeryGenre();
        resizeColumnsToContent(tblStationery);
        tblStationery.setDefaultEditor(Object.class, null);
        txtCreatedBy.setText(Auth.user.getEmployeeName());
    }

    void initProvider() {
        fillTableProvider();
        txtProvider_ID.setEditable(false);
        resizeColumnsToContent(tblProvider);
        tblProvider.setDefaultEditor(Object.class, null);
    }

    void initEmployee() throws SQLException {
        fillTblEmployees();
        resizeColumnsToContent(tblEmployees);
        tblEmployees.setDefaultEditor(Object.class, null);
        lblPassword.setIcon(new ImageIcon("src//img//hide.png"));
        lblPassword2.setIcon(new ImageIcon("src//img//hide.png"));
        lblOldPassEye.setIcon(new ImageIcon("src//img//hide.png"));
        lblNewPassEye1.setIcon(new ImageIcon("src//img//hide.png"));
        lblNewPassEye2.setIcon(new ImageIcon("src//img//hide.png"));
        rdoEmployees.setSelected(true);
    }

    void initCustomer() throws SQLException {
        fillTblCustomer();
        tblListCustomer.setDefaultEditor(Object.class, null);
        txtIDCustomer.setEditable(false);
        btndeleteCustomer.setEnabled(false);
        btnfixCustomer.setEnabled(false);

    }

    void initReceipt() throws SQLException {
        fillProducts();
        tblReceiptProducts.setDefaultEditor(Object.class, null);
        txtReceiptsIDReceipts.setText(createNewReceiptID());
        txtCreatedDayReceipts.setText(XDate.toString(new Date(), "dd-MM-yyyy"));
        createNewReceipt();
        vndFormatter.setCurrency(vnd);
        resizeColumnsToContent(tblReceiptDetails);
        DefaultTableModel model = (DefaultTableModel) tblReceiptDetails.getModel();
        model.setRowCount(0);
        addProductsToBill();
        bill.setEditable(false);
        tblReceiptProducts.getTableHeader().setBackground(Color.red);
        tblReceiptProducts.getTableHeader().setForeground(Color.red);
    }

    void initInventory() throws SQLException {
        setLayoutPnlWareHouse();
        fillCboProviderWareHouseReceipts();
        setColumnTblProductDetails();
        setTblProductWareHouseReceipt();
        loadDateTblProductWarehouseReceipts(prodDAO.selectAll());
        setColumnTblInventory();
        fillTblInventory();
        setStyleTableInventory();
        fillTableWarehouseReceipts();
        updatePriceInventory();

    }

    void initStatistics() throws SQLException {
        fillTableStatistics();
        tblStatistics.setDefaultEditor(Object.class, null);
        showLineChart();
    }

    void Auth() {
        if (Auth.isManager()) {
            tabs.setSelectedIndex(9);
        } else {
            tabs.setSelectedIndex(6);
        }
    }

    void initChange() {
        txtUsernameChange.setText(Auth.user.getUserName());
        txtOldPassword.setText(Auth.user.getEmployeePassword());
        txtUsernameChange.setEnabled(false);
    }

    void init() throws SQLException {
        initBook();
        initStationery();
        initProvider();
        initEmployee();
        initCustomer();
        initReceipt();
        initInventory();
        initStatistics();
        initChange();
        lblStatus.setIcon(new ImageIcon("src//img//lblHeQLDT.png"));
        lblTime.setIcon(new ImageIcon("src//img//lblThoiGian.png"));
        btnExit.setIcon(new ImageIcon("src//img//exit-btn.png"));
        this.startDongHo();
        this.status();
        this.Auth();
    }
}
