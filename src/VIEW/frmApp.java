package VIEW;

import CLASS.User;
import CLASS.hoaDon;
import CLASS.khachHang;
import CLASS.nhaCungCap;
import CLASS.nhanVien;
import CLASS.sanPham;
import Controler.ControlerHoaDon;
import Controler.ControlerKhachHang;
import Controler.ControlerNhaCungCap;
import Controler.ControlerNhanVien;
import Controler.ControlerSanPham;
import Controler.ControlerUser;
import HELPER.ChuyenDoi;
import HELPER.helper;
import MODEL.model;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.Component;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.function.IntConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class frmApp extends javax.swing.JFrame {

    public static User users;
    public static Component component;

    public frmApp(User user) {
        this.users = user;
        UIManager.put("TabbedPane.selectedBackground", new Color(205, 133, 63));
        UIManager.put("TableHeader.sortIconPosition", "right");
        UIManager.put("TableHeader.showTrailingVerticalLine", true);
        initComponents();

        this.tabMain.putClientProperty("JTabbedPane.tabClosable", true);
        this.tabMain.putClientProperty("JTabbedPane.tabCloseCallback",
                (IntConsumer) tabIndex -> {
                    this.tabMain.remove(tabIndex);
                });

        ImageIcon img = new ImageIcon("src/ICON/favicon.jpg");
        this.setIconImage(img.getImage());

        setExtendedState(this.MAXIMIZED_BOTH);
        pnlDefault.add(lbLogo);
        loadBackground load = new loadBackground();
        load.start();
        loadJDateChooser();
        loadJDateChooserDoanhThu();
        this.component = (Frame) this;
        // setting Role
        btnTaoDon.setVisible(user.isThemDonHang());
        btnDoanhThu.setVisible(user.isDoanhThu());
        btnDonHang.setVisible(user.isXemDonHang());
        btnKhoHang.setVisible(user.isKhoHang());
        btnThuNo.setVisible(user.isThuNo());
        menuThongKe.setVisible(user.isBaoCao());
        menuQuanLy.setVisible(user.isDanhMuc());
        btnExportExcel.setVisible(false);
        btnPrint.setVisible(false);
    }

    public void loadJDateChooser() {
        Date date = new Date();
        dateTo.setDate(date);
        dateFrom.setDate(date);
    }

    public void loadJDateChooserDoanhThu() {
        Date date = new Date();
        dateTo1.setDate(date);
        dateFrom1.setDate(date);
    }

    public void loadTableUser() {
        DefaultTableModel model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    case 4:
                        return Boolean.class;
                    case 5:
                        return Boolean.class;
                    case 6:
                        return Boolean.class;
                    case 7:
                        return Boolean.class;
                    case 8:
                        return Boolean.class;
                    case 9:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        // Add Column
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Nhân viên");
        model.addColumn("Xem đơn hàng");
        model.addColumn("Thêm đơn hàng");
        model.addColumn("Quản Lý Doanh Thu");
        model.addColumn("Quản Lý kho hàng");
        model.addColumn("Quản Lý danh mục");
        model.addColumn("Thu nợ");
        model.addColumn("Báo cáo");
        ArrayList<User> list = ControlerUser.getData();
        for (User item : list) {
            model.addRow(new Object[]{
                item.getUsername(),
                item.getPassword(),
                item.getNhanVien(),
                item.isXemDonHang(),
                item.isThemDonHang(),
                item.isDoanhThu(),
                item.isKhoHang(),
                item.isDanhMuc(),
                item.isThuNo(),
                item.isBaoCao()
            });
        }
        tableUser.setModel(model);
    }

    public void loadTableUser(ArrayList<User> list) {
        DefaultTableModel model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    case 4:
                        return Boolean.class;
                    case 5:
                        return Boolean.class;
                    case 6:
                        return Boolean.class;
                    case 7:
                        return Boolean.class;
                    case 8:
                        return Boolean.class;
                    case 9:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        // Add Column
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Nhân viên");
        model.addColumn("Xem đơn hàng");
        model.addColumn("Thêm đơn hàng");
        model.addColumn("Quản Lý Doanh Thu");
        model.addColumn("Quản Lý kho hàng");
        model.addColumn("Quản Lý danh mục");
        model.addColumn("Thu nợ");
        model.addColumn("Báo cáo");
        for (User item : list) {
            model.addRow(new Object[]{
                item.getUsername(),
                item.getPassword(),
                item.getNhanVien(),
                item.isXemDonHang(),
                item.isThemDonHang(),
                item.isDoanhThu(),
                item.isKhoHang(),
                item.isDanhMuc(),
                item.isThuNo(),
                item.isBaoCao()
            });
        }
        tableUser.setModel(model);
    }

    public class loadBackground extends Thread {

        public loadBackground() {

        }

        public void run() {
            while (true) {
                if (tabMain.getTabCount() == 0) {
                    pnlDefault.add(lbLogo);
                    lbLogo.setVisible(true);
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLogo = new javax.swing.JLabel();
        tabMain = new javax.swing.JTabbedPane();
        pnlQuanLyDonHang = new javax.swing.JPanel();
        pnlThongTinKH1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTiemKiemQLDH = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnShow = new javax.swing.JButton();
        cbSelectField = new javax.swing.JComboBox<>();
        dateTo = new com.toedter.calendar.JDateChooser();
        dateFrom = new com.toedter.calendar.JDateChooser();
        checkBoxShowAll = new javax.swing.JCheckBox();
        nofication = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableQuanLyHoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnCloseQLHD = new javax.swing.JButton();
        pnlSanPham = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtTimKiemQLSP = new javax.swing.JTextField();
        btnReLoad = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnThemSanPhamMoi = new javax.swing.JButton();
        btnNhapExcel = new javax.swing.JButton();
        btnCloseTabQLSP = new javax.swing.JButton();
        pnlNhanVien = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnThemNhanVien = new javax.swing.JButton();
        btnCloseTabQLSP1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtTimKiemQLNV = new javax.swing.JTextField();
        btnReLoad1 = new javax.swing.JButton();
        pnlUser = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnSaveUser = new javax.swing.JButton();
        btnThemUser = new javax.swing.JButton();
        btnCloseTabQLSP2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtTimKiemUser = new javax.swing.JTextField();
        btnReLoadUser = new javax.swing.JButton();
        pnlKhachHang = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnThemKhachHang = new javax.swing.JButton();
        btnCloseTabKhachHang = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableKhachHang = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtTimKiemKhachHang = new javax.swing.JTextField();
        btnReloadKhachHang = new javax.swing.JButton();
        pnlNhaCungCap = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        btnThemKhachHang1 = new javax.swing.JButton();
        btnCloseTabNcc = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableNhaCungCap = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txtTimKiemNcc = new javax.swing.JTextField();
        btnReloadNcc = new javax.swing.JButton();
        pnlThuNo = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        btnCloseTabThuNo = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableThuNo = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtTimKiemThuNo = new javax.swing.JTextField();
        btnReloadThuNo = new javax.swing.JButton();
        pnlChiPhiNhapHang = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCloseQLHD1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableChiPhiNhapHang = new javax.swing.JTable();
        pnlThongTinKH2 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtTiemKiemCPNH = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnShowNhapHang = new javax.swing.JButton();
        cbSelectFieldCPNH = new javax.swing.JComboBox<>();
        dateToChiPhiNhapHang = new com.toedter.calendar.JDateChooser();
        dateFromChiPhiNhapHang = new com.toedter.calendar.JDateChooser();
        lbKetQuaCPNH = new javax.swing.JLabel();
        pnlTraHangNcc = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        btnCloseTabTraHangNcc = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableTraHangNhaCungCap = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        txtTimKiemNccTraHang = new javax.swing.JTextField();
        btnReloadTraHangNcc = new javax.swing.JButton();
        pnlDoanhThu = new javax.swing.JPanel();
        pnlThongTinKH3 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        btnShow1 = new javax.swing.JButton();
        dateTo1 = new com.toedter.calendar.JDateChooser();
        dateFrom1 = new com.toedter.calendar.JDateChooser();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableDoanhThu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnExportExcel = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnCloseQLHD3 = new javax.swing.JButton();
        lbKetQua = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        pnlDefault = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        btnTaoDon = new javax.swing.JButton();
        btnDonHang = new javax.swing.JButton();
        btnDoanhThu = new javax.swing.JButton();
        btnKhoHang = new javax.swing.JButton();
        btnThuNo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuQuanLy = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuKhachHang = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        menuThongKe = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        lbLogo.setBackground(new java.awt.Color(28, 35, 45));
        lbLogo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbLogo.setForeground(new java.awt.Color(0, 204, 204));
        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/logo-text.png"))); // NOI18N
        lbLogo.setText("PHẦN MỀM QUẢN LÝ BÁN HÀNG FAST SALE");
        lbLogo.setMaximumSize(new java.awt.Dimension(9999, 9999));

        tabMain.setForeground(new java.awt.Color(0, 204, 204));
        tabMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabMain.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        pnlThongTinKH1.setBackground(new java.awt.Color(207, 227, 244));
        pnlThongTinKH1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel28.setText("Nhập :");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel29.setText("Từ ngày :");

        txtTiemKiemQLDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiemKiemQLDHActionPerformed(evt);
            }
        });
        txtTiemKiemQLDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTiemKiemQLDHKeyReleased(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel30.setText("Đến ngày :");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel31.setText("Tìm theo :");

        btnShow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShow.setText("XEM");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        cbSelectField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbSelectField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã hóa đơn", "Tên khách hàng", "Nhân viên bán hàng" }));
        cbSelectField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSelectFieldItemStateChanged(evt);
            }
        });

        checkBoxShowAll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxShowAll.setText("Hiện tất cả hóa đơn");
        checkBoxShowAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBoxShowAllMouseClicked(evt);
            }
        });
        checkBoxShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxShowAllActionPerformed(evt);
            }
        });

        nofication.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nofication.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout pnlThongTinKH1Layout = new javax.swing.GroupLayout(pnlThongTinKH1);
        pnlThongTinKH1.setLayout(pnlThongTinKH1Layout);
        pnlThongTinKH1Layout.setHorizontalGroup(
            pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinKH1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(cbSelectField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateTo, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(txtTiemKiemQLDH))
                .addGap(53, 53, 53)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkBoxShowAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nofication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        pnlThongTinKH1Layout.setVerticalGroup(
            pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKH1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlThongTinKH1Layout.createSequentialGroup()
                        .addGroup(pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel31)
                            .addComponent(cbSelectField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(txtTiemKiemQLDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(pnlThongTinKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(pnlThongTinKH1Layout.createSequentialGroup()
                        .addComponent(checkBoxShowAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nofication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tableQuanLyHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableQuanLyHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Khách hàng", "Tổng tiền", "Thanh toán", "Thời gian", "Nhân viên bán", "Mã chi tiết"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableQuanLyHoaDon.setRowHeight(30);
        tableQuanLyHoaDon.setRowMargin(3);
        tableQuanLyHoaDon.getTableHeader().setReorderingAllowed(false);
        tableQuanLyHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableQuanLyHoaDonMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableQuanLyHoaDon);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnCloseQLHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseQLHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseQLHD.setText("Thoát");
        btnCloseQLHD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseQLHD.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseQLHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseQLHDActionPerformed(evt);
            }
        });
        jPanel1.add(btnCloseQLHD);

        javax.swing.GroupLayout pnlQuanLyDonHangLayout = new javax.swing.GroupLayout(pnlQuanLyDonHang);
        pnlQuanLyDonHang.setLayout(pnlQuanLyDonHangLayout);
        pnlQuanLyDonHangLayout.setHorizontalGroup(
            pnlQuanLyDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuanLyDonHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQuanLyDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThongTinKH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlQuanLyDonHangLayout.setVerticalGroup(
            pnlQuanLyDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuanLyDonHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongTinKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlQuanLyDonHang.getAccessibleContext().setAccessibleName("Quản Lý Đơn Hàng");

        jPanel6.setBackground(new java.awt.Color(207, 227, 244));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel32.setText("Tìm kiếm :");

        txtTimKiemQLSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemQLSPKeyReleased(evt);
            }
        });

        btnReLoad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReLoad.setText("Tải lại trang");
        btnReLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReLoad)
                    .addComponent(txtTimKiemQLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemQLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReLoad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Nhà cung cấp", "Đơn vị tính", "Tồn kho", "Giá nhập", "giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSanPham.setRowHeight(30);
        tableSanPham.setRowMargin(3);
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableSanPhamMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tableSanPham);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnThemSanPhamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSanPhamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/themSanPham.jpg"))); // NOI18N
        btnThemSanPhamMoi.setText("THÊM");
        btnThemSanPhamMoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemSanPhamMoi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThemSanPhamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamMoiActionPerformed(evt);
            }
        });
        jPanel7.add(btnThemSanPhamMoi);

        btnNhapExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/excel-icon.png"))); // NOI18N
        btnNhapExcel.setText("NHẬP EXCEL");
        btnNhapExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNhapExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapExcelActionPerformed(evt);
            }
        });
        jPanel7.add(btnNhapExcel);

        btnCloseTabQLSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseTabQLSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseTabQLSP.setText("THOÁT");
        btnCloseTabQLSP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTabQLSP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTabQLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabQLSPActionPerformed(evt);
            }
        });
        jPanel7.add(btnCloseTabQLSP);

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlSanPham.getAccessibleContext().setAccessibleName("pnlSanPham");

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnThemNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/themSanPham.jpg"))); // NOI18N
        btnThemNhanVien.setText("THÊM");
        btnThemNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemNhanVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });
        jPanel8.add(btnThemNhanVien);

        btnCloseTabQLSP1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseTabQLSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseTabQLSP1.setText("THOÁT");
        btnCloseTabQLSP1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTabQLSP1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTabQLSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabQLSP1ActionPerformed(evt);
            }
        });
        jPanel8.add(btnCloseTabQLSP1);

        tableNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Địa chỉ", "Ngày sinh", "Giới tính", "Lương cơ bản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNhanVien.setRowHeight(30);
        tableNhanVien.setRowMargin(3);
        tableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableNhanVienMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tableNhanVien);

        jPanel9.setBackground(new java.awt.Color(207, 227, 244));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel33.setText("Tìm kiếm :");

        txtTimKiemQLNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemQLNVKeyReleased(evt);
            }
        });

        btnReLoad1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReLoad1.setText("Tải lại trang");
        btnReLoad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReLoad1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReLoad1)
                    .addComponent(txtTimKiemQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReLoad1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnSaveUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaveUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/save.png"))); // NOI18N
        btnSaveUser.setText("LƯU");
        btnSaveUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUserActionPerformed(evt);
            }
        });
        jPanel10.add(btnSaveUser);

        btnThemUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/themSanPham.jpg"))); // NOI18N
        btnThemUser.setText("THÊM");
        btnThemUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThemUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemUserActionPerformed(evt);
            }
        });
        jPanel10.add(btnThemUser);

        btnCloseTabQLSP2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseTabQLSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseTabQLSP2.setText("THOÁT");
        btnCloseTabQLSP2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTabQLSP2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTabQLSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabQLSP2ActionPerformed(evt);
            }
        });
        jPanel10.add(btnCloseTabQLSP2);

        tableUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Nhân Viên", "Xem đơn hàng", "Thêm đơn hàng", "Quản lý doanh thu", "Quản lý kho hàng", "Quản lý danh mục", "Thu nợ", "Báo cáo"
            }
        ));
        tableUser.setComponentPopupMenu(jPopupMenu1);
        tableUser.setRowHeight(30);
        tableUser.setRowMargin(5);
        tableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUserMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableUserMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tableUser);

        jPanel11.setBackground(new java.awt.Color(207, 227, 244));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel34.setText("Tìm kiếm :");

        txtTimKiemUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemUserKeyReleased(evt);
            }
        });

        btnReLoadUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReLoadUser.setText("Tải lại trang");
        btnReLoadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReLoadUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReLoadUser)
                    .addComponent(txtTimKiemUser, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(705, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReLoadUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlUserLayout = new javax.swing.GroupLayout(pnlUser);
        pnlUser.setLayout(pnlUserLayout);
        pnlUserLayout.setHorizontalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnlUserLayout.setVerticalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnThemKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/themSanPham.jpg"))); // NOI18N
        btnThemKhachHang.setText("THÊM");
        btnThemKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemKhachHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });
        jPanel12.add(btnThemKhachHang);

        btnCloseTabKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseTabKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseTabKhachHang.setText("THOÁT");
        btnCloseTabKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTabKhachHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTabKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabKhachHangActionPerformed(evt);
            }
        });
        jPanel12.add(btnCloseTabKhachHang);

        tableKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số Điện thoại", "Email", "Công nợ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKhachHang.setRowHeight(30);
        tableKhachHang.setRowMargin(3);
        tableKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableKhachHangMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tableKhachHang);
        if (tableKhachHang.getColumnModel().getColumnCount() > 0) {
            tableKhachHang.getColumnModel().getColumn(4).setHeaderValue("Email");
            tableKhachHang.getColumnModel().getColumn(5).setHeaderValue("Công nợ");
        }

        jPanel13.setBackground(new java.awt.Color(207, 227, 244));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel35.setText("Tìm kiếm :");

        txtTimKiemKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKhachHangKeyReleased(evt);
            }
        });

        btnReloadKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReloadKhachHang.setText("Tải lại trang");
        btnReloadKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReloadKhachHang)
                    .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReloadKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnThemKhachHang1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKhachHang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/themSanPham.jpg"))); // NOI18N
        btnThemKhachHang1.setText("THÊM");
        btnThemKhachHang1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemKhachHang1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThemKhachHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHang1ActionPerformed(evt);
            }
        });
        jPanel14.add(btnThemKhachHang1);

        btnCloseTabNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseTabNcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseTabNcc.setText("THOÁT");
        btnCloseTabNcc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTabNcc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTabNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabNccActionPerformed(evt);
            }
        });
        jPanel14.add(btnCloseTabNcc);

        tableNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableNhaCungCap.setRowHeight(30);
        tableNhaCungCap.setRowMargin(3);
        tableNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableNhaCungCapMousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(tableNhaCungCap);

        jPanel15.setBackground(new java.awt.Color(207, 227, 244));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel36.setText("Tìm kiếm :");

        txtTimKiemNcc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemNccKeyReleased(evt);
            }
        });

        btnReloadNcc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReloadNcc.setText("Tải lại trang");
        btnReloadNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadNccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReloadNcc)
                    .addComponent(txtTimKiemNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReloadNcc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlNhaCungCapLayout = new javax.swing.GroupLayout(pnlNhaCungCap);
        pnlNhaCungCap.setLayout(pnlNhaCungCapLayout);
        pnlNhaCungCapLayout.setHorizontalGroup(
            pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlNhaCungCapLayout.setVerticalGroup(
            pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnCloseTabThuNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseTabThuNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseTabThuNo.setText("THOÁT");
        btnCloseTabThuNo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTabThuNo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTabThuNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabThuNoActionPerformed(evt);
            }
        });
        jPanel16.add(btnCloseTabThuNo);

        tableThuNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableThuNo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số Điện thoại", "Email", "Công nợ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableThuNo.setRowHeight(30);
        tableThuNo.setRowMargin(3);
        tableThuNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableThuNoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableThuNoMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(tableThuNo);

        jPanel17.setBackground(new java.awt.Color(207, 227, 244));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel37.setText("Tìm kiếm :");

        txtTimKiemThuNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemThuNoKeyReleased(evt);
            }
        });

        btnReloadThuNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReloadThuNo.setText("Tải lại trang");
        btnReloadThuNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadThuNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReloadThuNo)
                    .addComponent(txtTimKiemThuNo, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemThuNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReloadThuNo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlThuNoLayout = new javax.swing.GroupLayout(pnlThuNo);
        pnlThuNo.setLayout(pnlThuNoLayout);
        pnlThuNoLayout.setHorizontalGroup(
            pnlThuNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThuNoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThuNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlThuNoLayout.setVerticalGroup(
            pnlThuNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThuNoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnCloseQLHD1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseQLHD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseQLHD1.setText("Thoát");
        btnCloseQLHD1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseQLHD1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseQLHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseQLHD1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnCloseQLHD1);

        tableChiPhiNhapHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableChiPhiNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Nhà cung cấp", "Đơn vị tính", "Giá nhập", "Giá bán", "Số lượng nhập", "Nhân viên thực hiện", "Thời gian", "Chi phí"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableChiPhiNhapHang.setRowHeight(30);
        tableChiPhiNhapHang.setRowMargin(3);
        tableChiPhiNhapHang.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableChiPhiNhapHang);

        pnlThongTinKH2.setBackground(new java.awt.Color(207, 227, 244));
        pnlThongTinKH2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel38.setText("Nhập :");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel39.setText("Từ ngày :");

        txtTiemKiemCPNH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiemKiemCPNHActionPerformed(evt);
            }
        });
        txtTiemKiemCPNH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTiemKiemCPNHKeyReleased(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel40.setText("Đến ngày :");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel41.setText("Tìm theo :");

        btnShowNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShowNhapHang.setText("XEM");
        btnShowNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowNhapHangActionPerformed(evt);
            }
        });

        cbSelectFieldCPNH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbSelectFieldCPNH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã sản phẩm", "Tên nhân viên" }));
        cbSelectFieldCPNH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSelectFieldCPNHItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinKH2Layout = new javax.swing.GroupLayout(pnlThongTinKH2);
        pnlThongTinKH2.setLayout(pnlThongTinKH2Layout);
        pnlThongTinKH2Layout.setHorizontalGroup(
            pnlThongTinKH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinKH2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlThongTinKH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinKH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateFromChiPhiNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(cbSelectFieldCPNH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(pnlThongTinKH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinKH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateToChiPhiNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(txtTiemKiemCPNH))
                .addGap(53, 53, 53)
                .addComponent(btnShowNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        pnlThongTinKH2Layout.setVerticalGroup(
            pnlThongTinKH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKH2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShowNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlThongTinKH2Layout.createSequentialGroup()
                        .addGroup(pnlThongTinKH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel41)
                            .addComponent(cbSelectFieldCPNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addComponent(txtTiemKiemCPNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(pnlThongTinKH2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(dateToChiPhiNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40)
                            .addComponent(dateFromChiPhiNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );

        lbKetQuaCPNH.setBackground(new java.awt.Color(0, 0, 0));
        lbKetQuaCPNH.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        lbKetQuaCPNH.setForeground(new java.awt.Color(0, 102, 255));
        lbKetQuaCPNH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbKetQuaCPNH.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pnlChiPhiNhapHangLayout = new javax.swing.GroupLayout(pnlChiPhiNhapHang);
        pnlChiPhiNhapHang.setLayout(pnlChiPhiNhapHangLayout);
        pnlChiPhiNhapHangLayout.setHorizontalGroup(
            pnlChiPhiNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiPhiNhapHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChiPhiNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThongTinKH2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiPhiNhapHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbKetQuaCPNH, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        pnlChiPhiNhapHangLayout.setVerticalGroup(
            pnlChiPhiNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiPhiNhapHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongTinKH2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbKetQuaCPNH, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnCloseTabTraHangNcc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseTabTraHangNcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseTabTraHangNcc.setText("THOÁT");
        btnCloseTabTraHangNcc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTabTraHangNcc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTabTraHangNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabTraHangNccActionPerformed(evt);
            }
        });
        jPanel18.add(btnCloseTabTraHangNcc);

        tableTraHangNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableTraHangNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableTraHangNhaCungCap.setRowHeight(30);
        tableTraHangNhaCungCap.setRowMargin(3);
        tableTraHangNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableTraHangNhaCungCapMousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(tableTraHangNhaCungCap);

        jPanel19.setBackground(new java.awt.Color(207, 227, 244));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel42.setText("Tìm kiếm :");

        txtTimKiemNccTraHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemNccTraHangKeyReleased(evt);
            }
        });

        btnReloadTraHangNcc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReloadTraHangNcc.setText("Tải lại trang");
        btnReloadTraHangNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadTraHangNccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReloadTraHangNcc)
                    .addComponent(txtTimKiemNccTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTimKiemNccTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReloadTraHangNcc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTraHangNccLayout = new javax.swing.GroupLayout(pnlTraHangNcc);
        pnlTraHangNcc.setLayout(pnlTraHangNccLayout);
        pnlTraHangNccLayout.setHorizontalGroup(
            pnlTraHangNccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTraHangNccLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTraHangNccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTraHangNccLayout.setVerticalGroup(
            pnlTraHangNccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTraHangNccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlThongTinKH3.setBackground(new java.awt.Color(207, 227, 244));
        pnlThongTinKH3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel44.setText("Từ ngày :");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel45.setText("Đến ngày :");

        btnShow1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnShow1.setText("XEM");
        btnShow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShow1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinKH3Layout = new javax.swing.GroupLayout(pnlThongTinKH3);
        pnlThongTinKH3.setLayout(pnlThongTinKH3Layout);
        pnlThongTinKH3Layout.setHorizontalGroup(
            pnlThongTinKH3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKH3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateFrom1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateTo1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnShow1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );
        pnlThongTinKH3Layout.setVerticalGroup(
            pnlThongTinKH3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKH3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlThongTinKH3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel44)
                    .addComponent(dateFrom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(dateTo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShow1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tableDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn vị tính", "Số lượng bán", "Số lượng tặng", "Nhân viên bán", "Khách hàng", "Giá nhập", "Giá bán", "Ngày bán", "Doanh thu", "Lợi nhuận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDoanhThu.setRowHeight(30);
        tableDoanhThu.setRowMargin(3);
        tableDoanhThu.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(tableDoanhThu);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnExportExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/excel-icon.png"))); // NOI18N
        btnExportExcel.setText("Export");
        btnExportExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExportExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });
        jPanel3.add(btnExportExcel);

        btnPrint.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/print.png"))); // NOI18N
        btnPrint.setText("PRINT");
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrint);

        btnCloseQLHD3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseQLHD3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseQLHD3.setText("Thoát");
        btnCloseQLHD3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseQLHD3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseQLHD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseQLHD3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnCloseQLHD3);

        lbKetQua.setBackground(new java.awt.Color(0, 0, 0));
        lbKetQua.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        lbKetQua.setForeground(new java.awt.Color(0, 102, 255));
        lbKetQua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbKetQua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pnlDoanhThuLayout = new javax.swing.GroupLayout(pnlDoanhThu);
        pnlDoanhThu.setLayout(pnlDoanhThuLayout);
        pnlDoanhThuLayout.setHorizontalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThongTinKH3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoanhThuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        pnlDoanhThuLayout.setVerticalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongTinKH3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuItem8.setText("Xóa ?");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FAST SALE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnlDefault.setBackground(new java.awt.Color(28, 35, 45));
        pnlDefault.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlDefaultComponentShown(evt);
            }
        });
        pnlDefault.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlDefault, java.awt.BorderLayout.CENTER);

        toolBar.setBackground(new java.awt.Color(28, 35, 45));
        toolBar.setRollover(true);
        toolBar.setBorderPainted(false);

        btnTaoDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTaoDon.setForeground(new java.awt.Color(0, 153, 153));
        btnTaoDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/themDonHang.png"))); // NOI18N
        btnTaoDon.setText("Tạo đơn");
        btnTaoDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoDon.setFocusable(false);
        btnTaoDon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTaoDon.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnTaoDon.setName(""); // NOI18N
        btnTaoDon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTaoDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDonActionPerformed(evt);
            }
        });
        toolBar.add(btnTaoDon);

        btnDonHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDonHang.setForeground(new java.awt.Color(0, 153, 153));
        btnDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/xemDonHang.png"))); // NOI18N
        btnDonHang.setText("Đơn Hàng");
        btnDonHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDonHang.setFocusable(false);
        btnDonHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDonHang.setMargin(new java.awt.Insets(8, 14, 8, 14));
        btnDonHang.setName(""); // NOI18N
        btnDonHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonHangActionPerformed(evt);
            }
        });
        toolBar.add(btnDonHang);

        btnDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDoanhThu.setForeground(new java.awt.Color(0, 153, 153));
        btnDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/doanhThu.png"))); // NOI18N
        btnDoanhThu.setText("Doanh Thu");
        btnDoanhThu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDoanhThu.setFocusable(false);
        btnDoanhThu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDoanhThu.setMargin(new java.awt.Insets(8, 14, 8, 14));
        btnDoanhThu.setName(""); // NOI18N
        btnDoanhThu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanhThuActionPerformed(evt);
            }
        });
        toolBar.add(btnDoanhThu);

        btnKhoHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnKhoHang.setForeground(new java.awt.Color(0, 153, 153));
        btnKhoHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/khoHang.png"))); // NOI18N
        btnKhoHang.setText("Kho Hàng");
        btnKhoHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhoHang.setFocusable(false);
        btnKhoHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoHang.setMargin(new java.awt.Insets(6, 14, 6, 14));
        btnKhoHang.setName(""); // NOI18N
        btnKhoHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoHangActionPerformed(evt);
            }
        });
        toolBar.add(btnKhoHang);

        btnThuNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThuNo.setForeground(new java.awt.Color(0, 153, 153));
        btnThuNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/thuNo.png"))); // NOI18N
        btnThuNo.setText("Thu nợ");
        btnThuNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThuNo.setFocusable(false);
        btnThuNo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThuNo.setMargin(new java.awt.Insets(6, 20, 6, 20));
        btnThuNo.setName(""); // NOI18N
        btnThuNo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThuNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuNoActionPerformed(evt);
            }
        });
        toolBar.add(btnThuNo);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        jMenuBar1.setBackground(new java.awt.Color(28, 35, 45));

        jMenu1.setText("Hệ Thống");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/logout.png"))); // NOI18N
        jMenuItem1.setText("Đăng Xuất");
        jMenuItem1.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/close.png"))); // NOI18N
        jMenuItem4.setText("Thoát");
        jMenuItem4.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        menuQuanLy.setText("Quản Lý");

        jMenuItem3.setText("Nhân viên");
        jMenuItem3.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuQuanLy.add(jMenuItem3);

        jMenuItem5.setText("Tài khoản");
        jMenuItem5.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuQuanLy.add(jMenuItem5);

        menuKhachHang.setText("Khách hàng");
        menuKhachHang.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKhachHangActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuKhachHang);

        jMenuItem7.setText("Nhà cung cấp");
        jMenuItem7.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuQuanLy.add(jMenuItem7);

        jMenuBar1.add(menuQuanLy);

        menuThongKe.setText("Thống kê");

        jMenuItem10.setText("Lương");
        jMenuItem10.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuThongKe.add(jMenuItem10);

        jMenuItem11.setText("Công nợ");
        jMenuItem11.setMargin(new java.awt.Insets(6, 6, 6, 6));
        menuThongKe.add(jMenuItem11);

        jMenuBar1.add(menuThongKe);

        jMenu2.setText("Giao dịch");

        jMenuItem9.setText("Nhật ký nhập hàng");
        jMenuItem9.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem2.setText("Nhật ký trả hàng NCC");
        jMenuItem2.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem6.setText("Nhật ký khách trả hàng");
        jMenuItem6.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu2.add(jMenuItem6);

        jMenuItem16.setText("Nhật ký thu tiền nợ");
        jMenuItem16.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu2.add(jMenuItem16);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Hoàn trả");

        jMenuItem14.setText("Khách trả hàng");
        jMenuItem14.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuItem15.setText("Trả hàng NCC");
        jMenuItem15.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Hổ Trợ");
        jMenu5.setMargin(new java.awt.Insets(3, 8, 3, 8));

        jMenuItem12.setText("thông tin liên hệ");
        jMenuItem12.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu5.add(jMenuItem12);

        jMenuItem13.setText("Hướng dẫn sử dụng");
        jMenuItem13.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jMenu5.add(jMenuItem13);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKhoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoHangActionPerformed

        openTab(pnlSanPham, "Kho hàng");
        loadTableSanPham();
    }//GEN-LAST:event_btnKhoHangActionPerformed

    private void btnTaoDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoDonActionPerformed
        // Tạo đơn hàng
        pnlTaoDon newPanel = new pnlTaoDon(users);
        openTab(newPanel, "Thêm Đơn Hàng");


    }//GEN-LAST:event_btnTaoDonActionPerformed

    public String newID(String type) {
        String id = "";
        int number = (int) Math.floor(Math.random() * (99999 - 10000 + 1) + 10000);
        id = type + Integer.toString(number);
        return id;
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Đăng xuất
        if (JOptionPane.showConfirmDialog(this, "Đăng xuất ?") == 0) {
            setVisible(false);
            new frmLogin("").setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // Thoát chương trình
        if (JOptionPane.showConfirmDialog(this, "Thoát phần mềm ?") == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    public void closeTab() {
        int getSelectedTab = tabMain.getSelectedIndex();

        tabMain.remove(getSelectedTab);
        if (tabMain.getTabCount() == 0) {
            tabMain.setVisible(false);
            lbLogo.setVisible(true);
        }
    }
    private void btnDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonHangActionPerformed
        // Quản lý đơn hàng
        openTab(pnlQuanLyDonHang, "Đơn Hàng");
    }//GEN-LAST:event_btnDonHangActionPerformed

    public void openTab(JPanel TypeOfPanel, String name) {
        JPanel tab = TypeOfPanel;
        tab.setName(name);
        if (tabMain.getTabCount() == 0) {
            lbLogo.setVisible(false);
            pnlDefault.add(tabMain);
            tabMain.setVisible(true);
            tabMain.add(tab);
        } else {
            tabMain.add(tab);
        }
        tabMain.setSelectedIndex(tabMain.getTabCount() - 1);
    }

    private void btnDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanhThuActionPerformed
        openTab(pnlDoanhThu, "Doanh Thu");

    }//GEN-LAST:event_btnDoanhThuActionPerformed

    private void btnThuNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuNoActionPerformed
        openTab(pnlThuNo, "Thu tiền");
        loadTableThuNo();
    }//GEN-LAST:event_btnThuNoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed


    }//GEN-LAST:event_formWindowClosed
    public void loadTableTraHangNCC() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã nhà cung cấp");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");

        ArrayList<nhaCungCap> data = ControlerNhaCungCap.getData();
        for (nhaCungCap item : data) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getSoDienThoai(),
                item.getDiaChi()
            });
        }
        tableTraHangNhaCungCap.setModel(model);
    }

    public void loadTableTraHangNCC(ArrayList<nhaCungCap> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã nhà cung cấp");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");

        for (nhaCungCap item : data) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getSoDienThoai(),
                item.getDiaChi()
            });
        }
        tableTraHangNhaCungCap.setModel(model);
    }

    public void loadTableNhaCungCap() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã nhà cung cấp");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");

        ArrayList<nhaCungCap> data = ControlerNhaCungCap.getData();
        for (nhaCungCap item : data) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getSoDienThoai(),
                item.getDiaChi()
            });
        }
        tableNhaCungCap.setModel(model);
    }

    public void loadTableNhaCungCap(ArrayList<nhaCungCap> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã nhà cung cấp");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");

        for (nhaCungCap item : data) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getSoDienThoai(),
                item.getDiaChi()
            });
        }
        tableNhaCungCap.setModel(model);
    }

    public void loadTableSanPham() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Nhà cung cấp");
        model.addColumn("Đơn vị tính");
        model.addColumn("Tồn kho");
        model.addColumn("Giá nhập");
        model.addColumn("Giá bán");

        ArrayList<sanPham> data = ControlerSanPham.getData();
        for (sanPham item : data) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getMaNhaCungCap(),
                item.getDonViTinh(),
                item.getTonKho(),
                ChuyenDoi.LongToString(item.getGiaNhap()),
                ChuyenDoi.LongToString(item.getGiaBan())
            });
        }
        tableSanPham.setModel(model);
    }

    public void loadTableSanPham(ArrayList<sanPham> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Nhà cung cấp");
        model.addColumn("Đơn vị tính");
        model.addColumn("Tồn kho");
        model.addColumn("Giá nhập");
        model.addColumn("Giá bán");

        for (sanPham item : data) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getMaNhaCungCap(),
                item.getDonViTinh(),
                item.getTonKho(),
                ChuyenDoi.LongToString(item.getGiaNhap()),
                ChuyenDoi.LongToString(item.getGiaBan())
            });
        }
        tableSanPham.setModel(model);
    }

    public void loadTableKhachHang() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã khách hàng");
        model.addColumn("Tên khách hàng");
        model.addColumn("Địa chỉ");
        model.addColumn("Số điện thoại");
        model.addColumn("Email");
        model.addColumn("Công nợ");
        ArrayList<khachHang> data = ControlerKhachHang.getData();
        for (khachHang item : data) {
            if (item.isStatus() == true) {
                model.addRow(new Object[]{
                    item.getId(),
                    item.getName(),
                    item.getDiaChi(),
                    item.getSoDienThoai(),
                    item.getEmail(),
                    ChuyenDoi.LongToString(item.getTienNo())
                });
            }
        }
        tableKhachHang.setModel(model);
    }

    public void loadTableKhachHang(ArrayList<khachHang> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã khách hàng");
        model.addColumn("Tên khách hàng");
        model.addColumn("Địa chỉ");
        model.addColumn("Số điện thoại");
        model.addColumn("Email");
        model.addColumn("Công nợ");

        for (khachHang item : data) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getDiaChi(),
                item.getSoDienThoai(),
                item.getEmail(),
                ChuyenDoi.LongToString(item.getTienNo())
            });
        }
        tableKhachHang.setModel(model);
    }

    public void loadTableChiPhiNhapHang(JLabel lb) {
        String sql = "SELECT sanpham.id,sanpham.name as 'tensanpham',nhacungcap.name as 'nhacungcap',donvitinh,gianhap,giaban,nhaphang.soluong,nhanvien.name as 'tennhanvien',nhaphang.ngaygio from nhaphang\n"
                + "JOIN sanpham on sanpham.id=nhaphang.idSanPham\n"
                + "join nhanvien on nhanvien.id=nhaphang.nhanvien\n"
                + "join nhacungcap on sanpham.nhacungcap=nhacungcap.id";
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("Mã sản phẩm");
        table.addColumn("Tên sản phẩm");
        table.addColumn("Nhà cung cấp");
        table.addColumn("Đơn vị tính");
        table.addColumn("Giá nhập");
        table.addColumn("Giá bán");
        table.addColumn("Số lượng nhập");
        table.addColumn("Nhân viên thực hiện");
        table.addColumn("Thời gian");
        table.addColumn("Chi phí");
        long chiPhi = 0;
        try {
            Connection con = (Connection) model.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                chiPhi += rs.getLong("gianhap") * rs.getLong("soluong");
                table.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("tensanpham"),
                    rs.getString("nhacungcap"),
                    rs.getString("donvitinh"),
                    ChuyenDoi.LongToString(rs.getLong("gianhap")),
                    ChuyenDoi.LongToString(rs.getLong("giaban")),
                    rs.getString("soluong"),
                    rs.getString("tennhanvien"),
                    rs.getString("ngaygio"),
                    ChuyenDoi.LongToString(rs.getLong("soluong") * rs.getLong("gianhap"))
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        lb.setText("TỔNG CHI PHÍ : " + ChuyenDoi.LongToString(Long.parseLong(chiPhi + "")));
        tableChiPhiNhapHang.setModel(table);
    }

    public void loadTableThuNo() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã khách hàng");
        model.addColumn("Tên khách hàng");
        model.addColumn("Địa chỉ");
        model.addColumn("Số điện thoại");
        model.addColumn("Email");
        model.addColumn("Công nợ");

        ArrayList<khachHang> data = ControlerKhachHang.getData();
        for (khachHang item : data) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getDiaChi(),
                item.getSoDienThoai(),
                item.getEmail(),
                ChuyenDoi.LongToString(item.getTienNo())
            });
        }
        tableThuNo.setModel(model);
    }

    public void loadTableThuNo(ArrayList<khachHang> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã khách hàng");
        model.addColumn("Tên khách hàng");
        model.addColumn("Địa chỉ");
        model.addColumn("Số điện thoại");
        model.addColumn("Email");
        model.addColumn("Công nợ");

        for (khachHang item : data) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getDiaChi(),
                item.getSoDienThoai(),
                item.getEmail(),
                ChuyenDoi.LongToString(item.getTienNo())
            });
        }
        tableThuNo.setModel(model);
    }
    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        checkBoxShowAll.setSelected(false);
        String field = cbSelectField.getSelectedItem().toString();
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String date = dcn.format(dateFrom.getDate()); //dateFrom
        String dateTo = dcn.format(this.dateTo.getDate()); //dateTo

        ArrayList<hoaDon> listHD = ControlerHoaDon.getHoaDon(field, txtTiemKiemQLDH.getText(), date, dateTo);
        if (listHD.size() == 0) {
            nofication.setText("Không tìm thấy hóa đơn");
        } else {
            nofication.setText("");
        }
        loadTableQLHD(listHD);

    }//GEN-LAST:event_btnShowActionPerformed

    private void cbSelectFieldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSelectFieldItemStateChanged
        txtTiemKiemQLDH.setText("");
    }//GEN-LAST:event_cbSelectFieldItemStateChanged

    private void txtTiemKiemQLDHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiemKiemQLDHKeyReleased

    }//GEN-LAST:event_txtTiemKiemQLDHKeyReleased

    private void checkBoxShowAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxShowAllMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxShowAllMouseClicked
    public void loadTableQLHD(ArrayList<hoaDon> listHD) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã hóa đơn");
        model.addColumn("Khách hàng");
        model.addColumn("Tổng tiền");
        model.addColumn("Thanh toán");
        model.addColumn("Thời gian");
        model.addColumn("Nhân viên bán");
        model.addColumn("Mã chi tiết");

        for (hoaDon item : listHD) {
            model.addRow(new Object[]{
                item.getId(),
                item.getMaKhachHang(),
                ChuyenDoi.LongToString(item.getTongTien()),
                item.getHinhThucThanhToan(),
                item.getNgayGio(),
                item.getNhanVienBan(),
                item.getMaChiTietHoaDon()
            });

        }
        tableQuanLyHoaDon.setModel(model);
    }

    public void loadTableNhanVien() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã nhân viên");
        model.addColumn("Tên nhân viên");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");
        model.addColumn("Ngày sinh");
        model.addColumn("Giới tính");
        model.addColumn("Lương cơ bản");
        ArrayList<nhanVien> list = ControlerNhanVien.getData();
        for (nhanVien item : list) {
            if (item.isStatus() == true) {
                model.addRow(new Object[]{
                    item.getId(),
                    item.getName(),
                    item.getSoDienThoai(),
                    item.getDiaChi(),
                    item.getNgaySinh(),
                    item.isGioiTinh() == true ? "Nam" : "Nữ",
                    ChuyenDoi.LongToString(item.getTienLuong())
                });
            }

        }
        tableNhanVien.setModel(model);
    }

    public void loadTableNhanVien(ArrayList<nhanVien> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã nhân viên");
        model.addColumn("Tên nhân viên");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");
        model.addColumn("Ngày sinh");
        model.addColumn("Giới tính");
        model.addColumn("Lương cơ bản");
        for (nhanVien item : list) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getSoDienThoai(),
                item.getDiaChi(),
                item.getNgaySinh(),
                item.isGioiTinh() == true ? "Nam" : "Nữ",
                ChuyenDoi.LongToString(item.getTienLuong())
            });

        }
        tableNhanVien.setModel(model);
    }
    private void checkBoxShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxShowAllActionPerformed
        boolean check = checkBoxShowAll.isSelected();
        ArrayList<hoaDon> listHD = ControlerHoaDon.getHoaDon();
        nofication.setText("");
        if (check == true) {
            loadTableQLHD(listHD);
        } else {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã hóa đơn");
            model.addColumn("Khách hàng");
            model.addColumn("Tổng tiền");
            model.addColumn("Thanh toán");
            model.addColumn("Thời gian");
            model.addColumn("Nhân viên bán");
            model.addColumn("Mã chi tiết");

            tableQuanLyHoaDon.setModel(model);
        }


    }//GEN-LAST:event_checkBoxShowAllActionPerformed

    private void txtTiemKiemQLDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiemKiemQLDHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiemKiemQLDHActionPerformed

    private void btnCloseQLHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseQLHDActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseQLHDActionPerformed

    private void txtTimKiemQLSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemQLSPKeyReleased
        String text = txtTimKiemQLSP.getText();
        ArrayList<sanPham> data = ControlerSanPham.getData();
        ArrayList<sanPham> find = new ArrayList<sanPham>();
        for (sanPham item : data) {
            if (item.getId().toLowerCase().contains(text.toLowerCase()) || item.getName().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(item.getId().toLowerCase()).contains(text.toLowerCase()) || helper.removeAccent(item.getName().toLowerCase()).contains(text.toLowerCase())) {
                find.add(item);
            }
        }
        if (text != "") {
            loadTableSanPham(find);
        } else {
            loadTableSanPham(data);
        }
    }//GEN-LAST:event_txtTimKiemQLSPKeyReleased

    private void btnThemSanPhamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamMoiActionPerformed
        editorSanPham editSP = new editorSanPham((Frame) this, true, "", "", users.getNhanVien());
        editSP.setTitle("Thêm sản phẩm");
        editSP.setVisible(true);
    }//GEN-LAST:event_btnThemSanPhamMoiActionPerformed

    private void btnCloseTabQLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabQLSPActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseTabQLSPActionPerformed

    private void btnReLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReLoadActionPerformed
        loadTableSanPham();
    }//GEN-LAST:event_btnReLoadActionPerformed

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        try {
            editorNhanVien editNV = new editorNhanVien((Frame) this, true, "", "");
            editNV.setTitle("Thêm nhân viên mới");
            editNV.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(frmApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void btnCloseTabQLSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabQLSP1ActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseTabQLSP1ActionPerformed

    private void txtTimKiemQLNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemQLNVKeyReleased
        String text = txtTimKiemQLNV.getText();
        ArrayList<nhanVien> data = ControlerNhanVien.getData();
        ArrayList<nhanVien> find = new ArrayList<nhanVien>();
        for (nhanVien item : data) {
            if (item.getId().toLowerCase().contains(text.toLowerCase()) || item.getName().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(item.getId().toLowerCase()).contains(text.toLowerCase()) || helper.removeAccent(item.getName().toLowerCase()).contains(text.toLowerCase())) {
                find.add(item);
            }
        }
        if (text != "") {
            loadTableNhanVien(find);
        } else {
            loadTableNhanVien(data);
        }
    }//GEN-LAST:event_txtTimKiemQLNVKeyReleased

    private void btnReLoad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReLoad1ActionPerformed
        loadTableNhanVien();
    }//GEN-LAST:event_btnReLoad1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        openTab(pnlNhanVien, "Nhân viên");
        loadTableNhanVien();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnThemUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemUserActionPerformed
        editorUser newpnl = new editorUser((Frame) this, true, "", "");
        newpnl.setTitle("Tạo tài khoản");
        newpnl.setVisible(true);
        loadTableUser();
    }//GEN-LAST:event_btnThemUserActionPerformed

    private void btnCloseTabQLSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabQLSP2ActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseTabQLSP2ActionPerformed

    private void txtTimKiemUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemUserKeyReleased
        String text = txtTimKiemUser.getText();
        ArrayList<User> data = ControlerUser.getData();
        ArrayList<User> find = new ArrayList<User>();
        for (User item : data) {
            if (item.getUsername().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(item.getUsername().toLowerCase()).contains(text.toLowerCase())) {
                find.add(item);
            }
        }
        if (text != "") {
            loadTableUser(find);
        } else {
            loadTableUser(data);
        }
    }//GEN-LAST:event_txtTimKiemUserKeyReleased

    private void btnReLoadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReLoadUserActionPerformed
        loadTableUser();
    }//GEN-LAST:event_btnReLoadUserActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        openTab(pnlUser, "Tài khoản");
        btnSaveUser.setVisible(false);
        loadTableUser();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void tableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMouseClicked
        btnSaveUser.setVisible(true);
    }//GEN-LAST:event_tableUserMouseClicked

    private void btnSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUserActionPerformed
        int i = tableUser.getRowCount();
        for (int j = 0; j <= i - 1; j++) {
//            System.out.println(tableUser.getValueAt(j, 0));
            boolean donhang = false;
            boolean themdonhang = false;
            boolean doanhthu = false;
            boolean khohang = false;
            boolean danhmuc = false;
            boolean thuno = false;
            boolean baocao = false;
            if (tableUser.getValueAt(j, 3).equals(true)) {
                donhang = true;
            }
            if (tableUser.getValueAt(j, 4).equals(true)) {
                themdonhang = true;
            }
            if (tableUser.getValueAt(j, 5).equals(true)) {
                doanhthu = true;
            }
            if (tableUser.getValueAt(j, 6).equals(true)) {
                khohang = true;
            }
            if (tableUser.getValueAt(j, 7).equals(true)) {
                danhmuc = true;
            }
            if (tableUser.getValueAt(j, 8).equals(true)) {
                thuno = true;
            }
            if (tableUser.getValueAt(j, 9).equals(true)) {
                baocao = true;
            }
            ControlerUser.setAccount(new User(tableUser.getValueAt(j, 0).toString(),
                    tableUser.getValueAt(j, 1).toString(),
                    tableUser.getValueAt(j, 2).toString(),
                    danhmuc, donhang, themdonhang, doanhthu, khohang, danhmuc, thuno, baocao
            ));
        }
        loadTableUser();
        btnSaveUser.setVisible(false);
    }//GEN-LAST:event_btnSaveUserActionPerformed

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        editorKhachHang newpnl = new editorKhachHang((Frame) this, true, "", "");
        newpnl.setTitle("Thêm khách hàng");
        newpnl.setVisible(true);
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void btnCloseTabKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabKhachHangActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseTabKhachHangActionPerformed

    private void txtTimKiemKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKhachHangKeyReleased
        String text = txtTimKiemKhachHang.getText();
        ArrayList<khachHang> data = ControlerKhachHang.getData();
        ArrayList<khachHang> find = new ArrayList<khachHang>();
        for (khachHang item : data) {
            if (item.getName().toLowerCase().contains(text.toLowerCase()) || item.getId().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(item.getName().toLowerCase()).contains(text.toLowerCase())) {
                find.add(item);
            }
        }
        if (text != "") {
            loadTableKhachHang(find);
        } else {
            loadTableKhachHang(data);
        }
    }//GEN-LAST:event_txtTimKiemKhachHangKeyReleased

    private void btnReloadKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadKhachHangActionPerformed
        loadTableKhachHang();
    }//GEN-LAST:event_btnReloadKhachHangActionPerformed

    private void btnThemKhachHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHang1ActionPerformed
        editorNhaCungCap newpnl = new editorNhaCungCap((Frame) this, true, "", "");
        newpnl.setTitle("Thêm nhà cung cấp");
        newpnl.setVisible(true);
    }//GEN-LAST:event_btnThemKhachHang1ActionPerformed

    private void btnCloseTabNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabNccActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseTabNccActionPerformed

    private void txtTimKiemNccKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNccKeyReleased
        String text = txtTimKiemNcc.getText();
        ArrayList<nhaCungCap> data = ControlerNhaCungCap.getData();
        ArrayList<nhaCungCap> find = new ArrayList<nhaCungCap>();
        for (nhaCungCap item : data) {
            if (item.getName().toLowerCase().contains(text.toLowerCase()) || item.getId().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(item.getName().toLowerCase()).contains(text.toLowerCase())) {
                find.add(item);
            }
        }
        if (text != "") {
            loadTableNhaCungCap(find);
        } else {
            loadTableNhaCungCap(data);
        }
    }//GEN-LAST:event_txtTimKiemNccKeyReleased

    private void btnReloadNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadNccActionPerformed
        loadTableNhaCungCap();
    }//GEN-LAST:event_btnReloadNccActionPerformed

    private void menuKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKhachHangActionPerformed
        openTab(pnlKhachHang, "Khách hàng");
        loadTableKhachHang();
    }//GEN-LAST:event_menuKhachHangActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        openTab(pnlNhaCungCap, "Nhà cung cấp");
        loadTableNhaCungCap();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void btnCloseTabThuNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabThuNoActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseTabThuNoActionPerformed

    private void txtTimKiemThuNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemThuNoKeyReleased
        String text = txtTimKiemThuNo.getText();
        ArrayList<khachHang> data = ControlerKhachHang.getData();
        ArrayList<khachHang> find = new ArrayList<khachHang>();
        for (khachHang item : data) {
            if (item.getName().toLowerCase().contains(text.toLowerCase()) || item.getId().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(item.getName().toLowerCase()).contains(text.toLowerCase())) {
                find.add(item);
            }
        }
        if (text != "") {
            loadTableThuNo(find);
        } else {
            loadTableThuNo(data);
        }
    }//GEN-LAST:event_txtTimKiemThuNoKeyReleased

    private void btnReloadThuNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadThuNoActionPerformed
        loadTableThuNo();
    }//GEN-LAST:event_btnReloadThuNoActionPerformed

    private void btnCloseQLHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseQLHD1ActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseQLHD1ActionPerformed

    private void txtTiemKiemCPNHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiemKiemCPNHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiemKiemCPNHActionPerformed

    private void txtTiemKiemCPNHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiemKiemCPNHKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiemKiemCPNHKeyReleased

    private void btnShowNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowNhapHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowNhapHangActionPerformed

    private void cbSelectFieldCPNHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSelectFieldCPNHItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSelectFieldCPNHItemStateChanged

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        openTab(pnlChiPhiNhapHang, "Lịch sử nhập hàng");
        loadTableChiPhiNhapHang(lbKetQuaCPNH);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void btnCloseTabTraHangNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabTraHangNccActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseTabTraHangNccActionPerformed

    private void txtTimKiemNccTraHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNccTraHangKeyReleased
        String text = txtTimKiemNccTraHang.getText();
        ArrayList<nhaCungCap> data = ControlerNhaCungCap.getData();
        ArrayList<nhaCungCap> find = new ArrayList<nhaCungCap>();
        for (nhaCungCap item : data) {
            if (item.getId().toLowerCase().contains(text.toLowerCase()) || item.getName().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(item.getId().toLowerCase()).contains(text.toLowerCase()) || helper.removeAccent(item.getName().toLowerCase()).contains(text.toLowerCase())) {
                find.add(item);
            }
        }
        if (text != "") {
            loadTableTraHangNCC(find);
        } else {
            loadTableTraHangNCC(data);
        }
    }//GEN-LAST:event_txtTimKiemNccTraHangKeyReleased

    private void btnReloadTraHangNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadTraHangNccActionPerformed
        loadTableTraHangNCC();
    }//GEN-LAST:event_btnReloadTraHangNccActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed

    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        openTab(pnlTraHangNcc, "Trả hàng NCC");
        loadTableTraHangNCC();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void btnShow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShow1ActionPerformed
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String dateFrom = dcn.format(dateFrom1.getDate()); //dateFrom
        String dateTo = dcn.format(dateTo1.getDate()); //dateTo
        ControlerHoaDon.getDoanhThu(tableDoanhThu, dateFrom, dateTo, lbKetQua);
        btnExportExcel.setVisible(true);
        btnPrint.setVisible(true);
    }//GEN-LAST:event_btnShow1ActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        exportExcel(tableDoanhThu);
    }//GEN-LAST:event_btnExportExcelActionPerformed

    public void exportExcel(JTable table) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file);
                BufferedWriter bwrite = new BufferedWriter(out);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // ten Cot
                for (int j = 0; j < table.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < table.getRowCount(); j++) {
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }

    private void tableThuNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableThuNoMouseClicked

    }//GEN-LAST:event_tableThuNoMouseClicked

    private void tableThuNoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableThuNoMousePressed
        if (evt.getClickCount() == 2 && tableThuNo.getSelectedRow() != -1) {
            editorThuNo newpnl = new editorThuNo((Frame) component, true, tableThuNo.getValueAt(tableThuNo.getSelectedRow(), 0).toString());
            newpnl.setTitle("Nhà cung cấp: " + tableThuNo.getValueAt(tableThuNo.getSelectedRow(), 1).toString());
            newpnl.setVisible(true);

            loadTableThuNo();
        }
    }//GEN-LAST:event_tableThuNoMousePressed

    private void tableQuanLyHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQuanLyHoaDonMousePressed
        if (evt.getClickCount() == 2 && tableQuanLyHoaDon.getSelectedRow() != -1) {
            // action double clicked:
            int index = tableQuanLyHoaDon.getSelectedRow();
            pnlXemDonHang xemDonHang = new pnlXemDonHang(this.users, tableQuanLyHoaDon.getValueAt(index, 0).toString(), tableQuanLyHoaDon.getValueAt(index, 5).toString());
            openTab(xemDonHang, "Đơn hàng: " + tableQuanLyHoaDon.getValueAt(index, 1).toString());
        }
    }//GEN-LAST:event_tableQuanLyHoaDonMousePressed

    private void tableSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMousePressed
        if (evt.getClickCount() == 2 && tableSanPham.getSelectedRow() != -1) {
            // action double clicked:

            editorSanPham editSP = new editorSanPham((Frame) component, true, "edit", tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 0).toString(), users.getNhanVien());
            editSP.setTitle("Sản phẩm: " + tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 1).toString());
            editSP.setVisible(true);

            loadTableSanPham();
        }
    }//GEN-LAST:event_tableSanPhamMousePressed

    private void tableNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNhanVienMousePressed
        if (evt.getClickCount() == 2 && tableNhanVien.getSelectedRow() != -1) {
            try {
                // action double clicked:
                editorNhanVien editNV = new editorNhanVien((Frame) component, true, "edit", tableNhanVien.getValueAt(tableNhanVien.getSelectedRow(), 0).toString());
                editNV.setTitle("Nhân Viên: " + tableNhanVien.getValueAt(tableNhanVien.getSelectedRow(), 1).toString());
                editNV.setVisible(true);

                loadTableNhanVien();
            } catch (ParseException ex) {
                Logger.getLogger(frmApp.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_tableNhanVienMousePressed

    private void tableUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMousePressed
        if (evt.getClickCount() == 2 && tableUser.getSelectedRow() != -1) {
            editorUser newpnl = new editorUser((Frame) component, true, "edit", tableUser.getValueAt(tableUser.getSelectedRow(), 0).toString());
            newpnl.setTitle("Tài khoản: " + tableUser.getValueAt(tableUser.getSelectedRow(), 0).toString());
            newpnl.setVisible(true);
            loadTableUser();
        }
    }//GEN-LAST:event_tableUserMousePressed

    private void tableKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKhachHangMousePressed
        if (evt.getClickCount() == 2 && tableKhachHang.getSelectedRow() != -1) {
            editorKhachHang newpnl = new editorKhachHang((Frame) component, true, "edit", tableKhachHang.getValueAt(tableKhachHang.getSelectedRow(), 0).toString());
            newpnl.setTitle("Khách hàng: " + tableKhachHang.getValueAt(tableKhachHang.getSelectedRow(), 1).toString());
            newpnl.setVisible(true);
            loadTableKhachHang();
        }
    }//GEN-LAST:event_tableKhachHangMousePressed

    private void tableNhaCungCapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNhaCungCapMousePressed
        if (evt.getClickCount() == 2 && tableNhaCungCap.getSelectedRow() != -1) {

            editorNhaCungCap newpnl = new editorNhaCungCap((Frame) component, true, "edit", tableNhaCungCap.getValueAt(tableNhaCungCap.getSelectedRow(), 0).toString());
            newpnl.setTitle("Nhà cung cấp: " + tableNhaCungCap.getValueAt(tableNhaCungCap.getSelectedRow(), 1).toString());
            newpnl.setVisible(true);

            loadTableNhaCungCap();
        }
    }//GEN-LAST:event_tableNhaCungCapMousePressed

    private void tableTraHangNhaCungCapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTraHangNhaCungCapMousePressed
        if (evt.getClickCount() == 2 && tableTraHangNhaCungCap.getSelectedRow() != -1) {
            traHangNcc newpnl = new traHangNcc((Frame) component, true,
                    tableTraHangNhaCungCap.getValueAt(tableTraHangNhaCungCap.getSelectedRow(), 0).toString(),
                    tableTraHangNhaCungCap.getValueAt(tableTraHangNhaCungCap.getSelectedRow(), 1).toString(),
                    users.getNhanVien());
            newpnl.setTitle("Nhà cung cấp: " + tableTraHangNhaCungCap.getValueAt(tableTraHangNhaCungCap.getSelectedRow(), 1).toString());
            newpnl.setVisible(true);
            loadTableTraHangNCC();
        }
    }//GEN-LAST:event_tableTraHangNhaCungCapMousePressed

    private void btnCloseQLHD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseQLHD3ActionPerformed
        tabMain.remove(tabMain.getSelectedIndex());
    }//GEN-LAST:event_btnCloseQLHD3ActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        String dateFrom = ChuyenDoi.LayNgayString(dateFrom1.getDate(), "YYYY-MM-dd");
        String dateTo = ChuyenDoi.LayNgayString(dateTo1.getDate(), "YYYY-MM-dd");
        String[] arr = lbKetQua.getText().split(" ");
        String doanhThu = arr[3].trim();
        String loiNhuan = arr[arr.length - 1].trim();

        try {
            Hashtable map = new Hashtable();
            JasperReport jasper = JasperCompileManager.compileReport("src/FormReport/reportDoanhThu.jrxml");

            // put parameter
            map.put("dateFrom", dateFrom);
            map.put("dateTo", dateTo);
            map.put("doanhThu", doanhThu);
            map.put("loiNhuan", loiNhuan);

            Connection con = model.getConnection();
            JasperPrint printer = JasperFillManager.fillReport(jasper, map, con);
            JasperViewer.viewReport(printer, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void pnlDefaultComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlDefaultComponentShown

    }//GEN-LAST:event_pnlDefaultComponentShown

    private void btnNhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapExcelActionPerformed
        final String excelFilePath = "C:\\Users\\DELL\\Desktop\\JAVA_3\\FPT_SALE\\input-product.xlsx";
        final List<sanPham> list;
        try {
            list = readExcel(excelFilePath);
            for (sanPham item : list) {
                System.out.println(item);
            }
        } catch (IOException ex) {
            Logger.getLogger(frmApp.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnNhapExcelActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if (tableUser.getSelectedRow() > 0) {
            int[] list = tableUser.getSelectedRows();
            if (JOptionPane.showConfirmDialog(null, "Xóa ?") == 0) {
                for (int item : list) {
                    ControlerUser.removeAccount(tableUser.getValueAt(item, 0) + "");
                }
            }
        }
        loadTableUser();
    }//GEN-LAST:event_jMenuItem8ActionPerformed
    public static List<sanPham> readExcel(String excelFilePath) throws IOException {

        List<sanPham> listBooks = new ArrayList<>();

        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = (Sheet) workbook.getSheetAt(0);

        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            sanPham item = new sanPham();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case 0:
                        item.setId((String) getCellValue(cell));
                        break;
                    case 1:
                        item.setName((String) getCellValue(cell));
                        break;
                    case 2:
                        item.setDonViTinh((String) getCellValue(cell));
                        break;
                    case 3:
                        item.setMaNhaCungCap((String) getCellValue(cell));
                        break;
                    case 4:
                        item.setGiaNhap((long) getCellValue(cell));
                        break;
                    case 5:
                        item.setGiaBan((long) getCellValue(cell));
                        break;
                    case 6:
                        item.setTonKho((Integer) getCellValue(cell));
                        break;
                    default:
                        break;
                }

            }
            listBooks.add(item);
        }

        workbook.close();
        inputStream.close();

        return listBooks;
    }

    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }

        return cellValue;
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmApp(users).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseQLHD;
    private javax.swing.JButton btnCloseQLHD1;
    private javax.swing.JButton btnCloseQLHD3;
    private javax.swing.JButton btnCloseTabKhachHang;
    private javax.swing.JButton btnCloseTabNcc;
    private javax.swing.JButton btnCloseTabQLSP;
    private javax.swing.JButton btnCloseTabQLSP1;
    private javax.swing.JButton btnCloseTabQLSP2;
    private javax.swing.JButton btnCloseTabThuNo;
    private javax.swing.JButton btnCloseTabTraHangNcc;
    private javax.swing.JButton btnDoanhThu;
    private javax.swing.JButton btnDonHang;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnKhoHang;
    private javax.swing.JButton btnNhapExcel;
    private javax.swing.JButton btnPrint;
    public static javax.swing.JButton btnReLoad;
    public static javax.swing.JButton btnReLoad1;
    public static javax.swing.JButton btnReLoadUser;
    public static javax.swing.JButton btnReloadKhachHang;
    public static javax.swing.JButton btnReloadNcc;
    public static javax.swing.JButton btnReloadThuNo;
    public static javax.swing.JButton btnReloadTraHangNcc;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnShow1;
    private javax.swing.JButton btnShowNhapHang;
    private javax.swing.JButton btnTaoDon;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThemKhachHang1;
    private javax.swing.JButton btnThemNhanVien;
    private javax.swing.JButton btnThemSanPhamMoi;
    private javax.swing.JButton btnThemUser;
    private javax.swing.JButton btnThuNo;
    private javax.swing.JComboBox<String> cbSelectField;
    private javax.swing.JComboBox<String> cbSelectFieldCPNH;
    private javax.swing.JCheckBox checkBoxShowAll;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateFrom1;
    private com.toedter.calendar.JDateChooser dateFromChiPhiNhapHang;
    private com.toedter.calendar.JDateChooser dateTo;
    private com.toedter.calendar.JDateChooser dateTo1;
    private com.toedter.calendar.JDateChooser dateToChiPhiNhapHang;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbKetQua;
    private javax.swing.JLabel lbKetQuaCPNH;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JMenuItem menuKhachHang;
    private javax.swing.JMenu menuQuanLy;
    private javax.swing.JMenu menuThongKe;
    private javax.swing.JLabel nofication;
    private javax.swing.JPanel pnlChiPhiNhapHang;
    private javax.swing.JPanel pnlDefault;
    private javax.swing.JPanel pnlDoanhThu;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlNhaCungCap;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlQuanLyDonHang;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JPanel pnlThongTinKH1;
    private javax.swing.JPanel pnlThongTinKH2;
    private javax.swing.JPanel pnlThongTinKH3;
    private javax.swing.JPanel pnlThuNo;
    private javax.swing.JPanel pnlTraHangNcc;
    private javax.swing.JPanel pnlUser;
    public javax.swing.JTabbedPane tabMain;
    private javax.swing.JTable tableChiPhiNhapHang;
    private javax.swing.JTable tableDoanhThu;
    private javax.swing.JTable tableKhachHang;
    private javax.swing.JTable tableNhaCungCap;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTable tableQuanLyHoaDon;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTable tableThuNo;
    private javax.swing.JTable tableTraHangNhaCungCap;
    private javax.swing.JTable tableUser;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextField txtTiemKiemCPNH;
    private javax.swing.JTextField txtTiemKiemQLDH;
    private javax.swing.JTextField txtTimKiemKhachHang;
    private javax.swing.JTextField txtTimKiemNcc;
    private javax.swing.JTextField txtTimKiemNccTraHang;
    private javax.swing.JTextField txtTimKiemQLNV;
    private javax.swing.JTextField txtTimKiemQLSP;
    private javax.swing.JTextField txtTimKiemThuNo;
    private javax.swing.JTextField txtTimKiemUser;
    // End of variables declaration//GEN-END:variables

}
