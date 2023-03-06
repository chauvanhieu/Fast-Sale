package VIEW;

import CLASS.User;
import Controler.ControlerSanPham;
import CLASS.khachHang;
import CLASS.nhanVien;
import CLASS.sanPham;
import CLASS.tableHoaDon;
import Controler.ControlerKhachHang;
import Controler.ControlerNhanVien;
import HELPER.ChuyenDoi;
import HELPER.helper;
import MODEL.model;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class pnlTaoDon extends javax.swing.JPanel {

    public static User users;
    private String idHoaDon;
    private String idChiTietHoaDon;
    private ArrayList<khachHang> dataKhachHang = ControlerKhachHang.getData();
    private ArrayList<sanPham> dataSanPham = ControlerSanPham.getData();
    private ArrayList<nhanVien> dataNhanVien = ControlerNhanVien.getData();
    private ArrayList<tableHoaDon> listHoaDon = new ArrayList<tableHoaDon>();

    public pnlTaoDon(User user) {
        this.users = user;
        this.idHoaDon = helper.newID("HD");
        this.idChiTietHoaDon = helper.newID("PT");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        initComponents();
        loadComboBox();
        txtNhanVienTao.setText(users.getNhanVien());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        txtNgayGio.setText(dtf.format(now));
    }

    public void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Đơn vị tính");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");
        model.addColumn("Thành tiền");
        long tongTien = 0;
        for (tableHoaDon item : listHoaDon) {
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getDonViTinh(),
                item.getDonGia() == 0 ? 0 : ChuyenDoi.LongToString(item.getDonGia()),
                item.getDonGia() == 0 ? item.getTang() : item.getSoLuong(),
                item.getDonGia() == 0 ? 0 : ChuyenDoi.LongToString(item.getDonGia() * Long.parseLong(item.getSoLuong() + ""))
            }
            );
            tongTien += item.getThanhTien();
        }

        tableDonHang.setModel(model);

        txtTongHoaDon.setText(ChuyenDoi.LongToString(tongTien));
    }

    public void loadComboBox() {
        for (nhanVien item : dataNhanVien) {
            cbNhanVienBan.addItem(item.getName() + " - " + item.getId());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupXoaItem = new javax.swing.JPopupMenu();
        menuXoaItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCloseTab = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDonHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiemSanPham = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnThemSanPham = new javax.swing.JButton();
        numSoLuongBan = new javax.swing.JSpinner();
        numSoLuongTang = new javax.swing.JSpinner();
        numDonGia = new javax.swing.JSpinner();
        numTonKho = new javax.swing.JSpinner();
        cbSanPham = new javax.swing.JComboBox<>();
        txtDonViTinh = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNoCu = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtTongHoaDon = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNoMoi = new javax.swing.JTextField();
        cbNhanVienBan = new javax.swing.JComboBox<>();
        pnlThongTinKH = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTimKiemKhachHang = new javax.swing.JTextField();
        cbTenKhachHang = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNgayGio = new javax.swing.JTextField();
        txtNhanVienTao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        menuXoaItem.setText("Xóa sản phẩm này");
        menuXoaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuXoaItemActionPerformed(evt);
            }
        });
        popupXoaItem.add(menuXoaItem);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/save.png"))); // NOI18N
        btnSave.setText("LƯU");
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setMaximumSize(new java.awt.Dimension(72, 75));
        btnSave.setMinimumSize(new java.awt.Dimension(72, 75));
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        btnPrint.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/print.png"))); // NOI18N
        btnPrint.setText("LƯU - IN");
        btnPrint.setEnabled(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint);

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/edit.png"))); // NOI18N
        btnEdit.setText("SỮA");
        btnEdit.setEnabled(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);

        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/delete.png"))); // NOI18N
        btnRemove.setText("XÓA");
        btnRemove.setEnabled(false);
        btnRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnRemove);

        btnCloseTab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseTab.setText("THOÁT");
        btnCloseTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabActionPerformed(evt);
            }
        });
        jPanel1.add(btnCloseTab);

        tableDonHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tableDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn vị tính", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDonHang.setComponentPopupMenu(popupXoaItem);
        tableDonHang.setRowHeight(30);
        tableDonHang.setRowMargin(3);
        jScrollPane2.setViewportView(tableDonHang);

        jPanel4.setBackground(new java.awt.Color(207, 227, 244));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel11.setText("Tìm kiếm :");

        txtTimKiemSanPham.setEnabled(false);
        txtTimKiemSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPhamKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setText("Tên sản phẩm :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel20.setText("Đơn giá :");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel21.setText("Tồn kho :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel22.setText("Số lượng bán :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel23.setText("Tặng :");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel24.setText("Đơn vị tính :");

        btnThemSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSanPham.setText("Thêm");
        btnThemSanPham.setEnabled(false);
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        numSoLuongBan.setEnabled(false);

        numSoLuongTang.setEnabled(false);

        numDonGia.setEnabled(false);

        numTonKho.setEnabled(false);

        cbSanPham.setEnabled(false);
        cbSanPham.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSanPhamItemStateChanged(evt);
            }
        });

        txtDonViTinh.setEditable(false);
        txtDonViTinh.setEnabled(false);
        txtDonViTinh.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(numDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numSoLuongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numSoLuongTang, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThemSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel12)
                            .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel20)
                            .addComponent(numDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(numTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel22)
                            .addComponent(numSoLuongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(numSoLuongTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel10.setText("Chi tiết đơn hàng :");

        jPanel3.setBackground(new java.awt.Color(207, 227, 244));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel8.setText("Nhân viên bán :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setText("Nợ cũ :");

        txtNoCu.setEditable(false);
        txtNoCu.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel14.setText("Hình thức thanh toán :");

        cbHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nợ", "Tiền mặt", "Chuyển khoản" }));
        cbHinhThucThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbHinhThucThanhToanItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel15.setText("Tổng hóa đơn :");

        txtTongHoaDon.setEditable(false);
        txtTongHoaDon.setFocusable(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel16.setText("Nợ mới :");

        txtNoMoi.setEditable(false);
        txtNoMoi.setFocusable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNoCu, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(cbNhanVienBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbHinhThucThanhToan, 0, 188, Short.MAX_VALUE)
                    .addComponent(txtNoMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(txtTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(txtTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtNoCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(cbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNhanVienBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlThongTinKH.setBackground(new java.awt.Color(207, 227, 244));
        pnlThongTinKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setText("Khách hàng :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setText("Điện thoại :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setText("Địa Chỉ :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setText("Tìm khách hàng :");

        txtTimKiemKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKhachHangKeyReleased(evt);
            }
        });

        cbTenKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTenKhachHangItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinKHLayout = new javax.swing.GroupLayout(pnlThongTinKH);
        pnlThongTinKH.setLayout(pnlThongTinKHLayout);
        pnlThongTinKHLayout.setHorizontalGroup(
            pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinKHLayout.createSequentialGroup()
                .addGroup(pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinKHLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinKHLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(txtSoDienThoai))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiaChi)
                    .addComponent(cbTenKhachHang, 0, 477, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThongTinKHLayout.setVerticalGroup(
            pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(207, 227, 244));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setText("Ngày giờ :");

        txtNgayGio.setEditable(false);
        txtNgayGio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayGio.setForeground(new java.awt.Color(255, 51, 0));
        txtNgayGio.setFocusable(false);

        txtNhanVienTao.setEditable(false);
        txtNhanVienTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhanVienTao.setForeground(new java.awt.Color(204, 51, 0));
        txtNhanVienTao.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setText("Nhân viên tạo :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNhanVienTao, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(txtNgayGio))
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgayGio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNhanVienTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlThongTinKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlThongTinKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        /*
        - Quét mảng hóa đơn table rồi add từng item theo idChiTietHoaDon:
        insert into chiTietHoaDon values(id , masanpham, soluong , tang);
        - Add hóa đơn:
        insert into hoadon values (id, nhanvientao,nhanvienban,idkhachhang,ngaygio,hinhthucchuyenkhoan,chitiethoadon,tongtien)
        - cộng doanhthu cho nhân viên
        update nhanvien set doanhthu = doanhthu + tổng hóa đơn where id = idnhanvien
        - nếu hình thức thanh toán là NỢ thì
        update khachhang set tienNo = nợ mới where id = id khách hàng
         */
        if (listHoaDon.size() > 0) {
            String nhanvien = cbNhanVienBan.getSelectedItem().toString();
            String[] arr = nhanvien.split("-");
            String idNVban = arr[1].trim();
            String khachhang = cbTenKhachHang.getSelectedItem().toString();
            String[] arrz = khachhang.split("-");
            String idKH = arrz[1].trim();
            helper.addItemHoaDon(listHoaDon, idChiTietHoaDon);
            helper.addHoaDon(idHoaDon, txtNhanVienTao.getText(), idNVban, idKH, txtNgayGio.getText(), cbHinhThucThanhToan.getSelectedItem().toString(), idChiTietHoaDon, (long) ChuyenDoi.StringToLong(txtTongHoaDon.getText()));
            helper.congDoanhThu((long) ChuyenDoi.StringToLong(txtTongHoaDon.getText()), idNVban);
            if (cbHinhThucThanhToan.getSelectedItem().toString() == "Nợ") {
                helper.congTienNo((long) ChuyenDoi.StringToLong(txtNoMoi.getText()), idKH);
            }
            helper.giamSoLuongTonKho(listHoaDon);
            JOptionPane.showMessageDialog(this, "Đã thêm đơn hàng !");
            btnCloseTab.doClick();
        } else {
            JOptionPane.showMessageDialog(this, "Chưa có sản phẩm !");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCloseTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabActionPerformed
        JTabbedPane parent = (JTabbedPane) this.getParent();
        parent.remove(this);
    }//GEN-LAST:event_btnCloseTabActionPerformed

    private void txtTimKiemSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamKeyReleased
        String text = txtTimKiemSanPham.getText();
        ArrayList<sanPham> find = new ArrayList<>();

        for (int i = 0; i < dataSanPham.size(); i++) {
            if (dataSanPham.get(i).getName().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(dataSanPham.get(i).getName().toLowerCase()).contains(text.toLowerCase())) {
                find.add(dataSanPham.get(i));
            }
        }
        cbSanPham.removeAllItems();
        if (find.size() > 0) {
            for (sanPham item : find) {
                cbSanPham.addItem(item.getName() + " - " + item.getId());
            }
        } else {
            for (sanPham item : dataSanPham) {
                cbSanPham.addItem(item.getName() + " - " + item.getId());
            }
        }
    }//GEN-LAST:event_txtTimKiemSanPhamKeyReleased

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        try {
            numDonGia.commitEdit();
            numSoLuongBan.commitEdit();
            numSoLuongTang.commitEdit();
            numTonKho.commitEdit();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        // đây là field lấy từ txt/combobox:
        String getName = cbSanPham.getSelectedItem().toString();
        String[] arr = getName.split("-");
        String id = arr[1].trim();
        String name = arr[0];
        int tonKho = Integer.parseInt(numTonKho.getValue() + "");
        String donViTinh = txtDonViTinh.getText();
        long donGia = Long.parseLong(numDonGia.getValue() + "");
        int soLuong = Integer.parseInt(numSoLuongBan.getValue() + "");
        long thanhTien = donGia * Long.parseLong(soLuong + "");
        int soLuongTang = Integer.parseInt(numSoLuongTang.getValue() + "");

        boolean isTonTai = false;
        for (tableHoaDon item : listHoaDon) {
            if (item.getId().equals(id)) {
                isTonTai = true;
                break;
            }
        }

        if (isTonTai == true) {

            boolean isTangRoi = false;
            for (tableHoaDon item : listHoaDon) {
                if (item.getId().equals(id) && item.getDonGia() != 0) {
                    item.setSoLuong(item.getSoLuong() + soLuong);
                    item.setThanhTien(item.getDonGia() * Long.parseLong(item.getSoLuong() + ""));
                    break;
                } else if (item.getId().equals(id) && item.getDonGia() == 0) {
                    isTangRoi = true;
                }
            }

            if (isTangRoi && soLuong > 0) {
                for (tableHoaDon item : listHoaDon) {
                    if (item.getId().equals(id) && item.getDonGia() == 0) {
                        item.setSoLuong(item.getSoLuong() + soLuong);
                    }
                }
            } else if (!isTangRoi && soLuongTang > 0) {
                listHoaDon.add(new tableHoaDon(id, name, donViTinh, 0, soLuongTang, 0, 0));
            }
        } else {
            //String id, String name, String donViTinh, int soLuong, int tang, long donGia, long thanhTien
            if (soLuong > 0 && soLuongTang > 0) {
                listHoaDon.add(new tableHoaDon(id, name, donViTinh, soLuong, 0, donGia, thanhTien));
                listHoaDon.add(new tableHoaDon(id, name, donViTinh, 0, soLuongTang, 0, 0));
            } else if (soLuong == 0 && soLuongTang > 0) {
                listHoaDon.add(new tableHoaDon(id, name, donViTinh, 0, soLuongTang, 0, 0));
            } else if (soLuong > 0 && soLuongTang == 0) {
                listHoaDon.add(new tableHoaDon(id, name, donViTinh, soLuong, soLuongTang, donGia, thanhTien));
            }
        }

        loadTable();
        txtTimKiemSanPham.setText("");
        numSoLuongBan.setValue(0);
        numSoLuongTang.setValue(0);
        String value = cbHinhThucThanhToan.getSelectedItem().toString();
        if (txtNoCu.getText() != "") {
            if (value == "Nợ") {
                long sum = (long) (ChuyenDoi.StringToLong(txtNoCu.getText()) + ChuyenDoi.StringToLong(txtTongHoaDon.getText()));
                txtNoMoi.setText(ChuyenDoi.LongToString(sum));
            } else {
                txtNoMoi.setText("");
            }
        }
        btnPrint.setEnabled(true);
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void cbSanPhamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSanPhamItemStateChanged
        String value = "";
        if (cbSanPham.getItemCount() > 0) {
            value = cbSanPham.getSelectedItem().toString();
            String[] arr = value.split("-");
            String id = arr[1].trim();
            for (sanPham item : dataSanPham) {
                if (item.getId().equals(id)) {
                    numDonGia.setValue(item.getGiaBan());
                    numTonKho.setValue(item.getTonKho());
                    txtDonViTinh.setText(item.getDonViTinh());
                }
            }
        }

    }//GEN-LAST:event_cbSanPhamItemStateChanged

    private void cbHinhThucThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbHinhThucThanhToanItemStateChanged
        String value = cbHinhThucThanhToan.getSelectedItem().toString();
        if (txtNoCu.getText() != "") {
            if (value == "Nợ") {
                long sum = Long.parseLong(txtNoCu.getText()) + Long.parseLong(txtTongHoaDon.getText());
                txtNoMoi.setText(ChuyenDoi.LongToString(sum));
            } else {
                txtNoMoi.setText("");
            }
        }
    }//GEN-LAST:event_cbHinhThucThanhToanItemStateChanged

    private void txtTimKiemKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKhachHangKeyReleased
        String text = txtTimKiemKhachHang.getText();
        ArrayList<khachHang> find = new ArrayList<>();

        for (int i = 0; i < dataKhachHang.size(); i++) {
            if (dataKhachHang.get(i).getName().toLowerCase().contains(text.toLowerCase())
                    || helper.removeAccent(dataKhachHang.get(i).getName().toLowerCase()).contains(text.toLowerCase())) {
                find.add(dataKhachHang.get(i));
            }
        }
        cbTenKhachHang.removeAllItems();
        if (find.size() > 0) {
            for (khachHang item : find) {
                cbTenKhachHang.addItem(item.getName() + " - " + item.getId());
            }
        } else {
            for (khachHang item : dataKhachHang) {
                cbTenKhachHang.addItem(item.getName() + " - " + item.getId());
            }
        }

    }//GEN-LAST:event_txtTimKiemKhachHangKeyReleased

    private void cbTenKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTenKhachHangItemStateChanged
        String value = "";
        if (cbTenKhachHang.getItemCount() > 0) {
            value = cbTenKhachHang.getSelectedItem().toString();
            String[] arr = value.split("-");
            String id = arr[1].trim();
            for (khachHang item : dataKhachHang) {
                if (item.getId().equals(id)) {
                    txtDiaChi.setText(item.getDiaChi());
                    txtSoDienThoai.setText(item.getSoDienThoai());
                    txtNoCu.setText(ChuyenDoi.LongToString(item.getTienNo()));
                    btnSave.setEnabled(true);
                    btnPrint.setEnabled(true);
                    txtTimKiemSanPham.setEnabled(true);
                    txtDonViTinh.setEnabled(true);
                    cbSanPham.setEnabled(true);
                    numDonGia.setEnabled(true);
                    numSoLuongBan.setEnabled(true);
                    numSoLuongTang.setEnabled(true);
                    numTonKho.setEnabled(true);
                    btnThemSanPham.setEnabled(true);
                    break;
                }
            }
        }
    }//GEN-LAST:event_cbTenKhachHangItemStateChanged

    private void menuXoaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuXoaItemActionPerformed
        int index = tableDonHang.getSelectedRow();
        if (index >= 0 || tableDonHang.getSelectedRows().length != 0) {
            listHoaDon.remove(index);
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
        }
    }//GEN-LAST:event_menuXoaItemActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        if (tableDonHang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có sản phẩm !");
            return;
        }
        String nhanvien = cbNhanVienBan.getSelectedItem().toString();
        String[] arr = nhanvien.split("-");
        String tenNhanVien = arr[0].trim();
        String idNVban = arr[1].trim();
        String khachhang = cbTenKhachHang.getSelectedItem().toString();
        String[] arrz = khachhang.split("-");
        String idKH = arrz[1].trim();
        String tenKH = arrz[0].trim();
        if (listHoaDon.size() > 0) {

            helper.addItemHoaDon(listHoaDon, idChiTietHoaDon);
            helper.addHoaDon(idHoaDon, txtNhanVienTao.getText(), idNVban, idKH, txtNgayGio.getText(), cbHinhThucThanhToan.getSelectedItem().toString(), idChiTietHoaDon, (long) ChuyenDoi.StringToLong(txtTongHoaDon.getText()));
            helper.congDoanhThu((long) ChuyenDoi.StringToLong(txtTongHoaDon.getText()), idNVban);
            if (cbHinhThucThanhToan.getSelectedItem().toString() == "Nợ") {
                helper.congTienNo((long) ChuyenDoi.StringToLong(txtNoMoi.getText()), idKH);
            }
            helper.giamSoLuongTonKho(listHoaDon);

            btnCloseTab.doClick();

        } else {
            JOptionPane.showMessageDialog(this, "Chưa có sản phẩm !");
        }

        try {
            Hashtable map = new Hashtable();
            JasperReport jasper = JasperCompileManager.compileReport("src/FormReport/reportHoaDon.jrxml");
            map.put("tenKH", tenKH);
            map.put("tenNV", tenNhanVien);
            map.put("ngayBanHang", txtNgayGio.getText());
            map.put("paramHinhThuc", cbHinhThucThanhToan.getSelectedItem().toString());
            map.put("paramTongTien", txtTongHoaDon.getText());
            map.put("paramIdHoaDon", idHoaDon);
            map.put("paramChiTietHoaDon", idChiTietHoaDon);
            Connection con = model.getConnection();
            JasperPrint printer = JasperFillManager.fillReport(jasper, map, con);
            JasperViewer.viewReport(printer, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseTab;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JComboBox<String> cbHinhThucThanhToan;
    private javax.swing.JComboBox<String> cbNhanVienBan;
    private javax.swing.JComboBox<String> cbSanPham;
    private javax.swing.JComboBox<String> cbTenKhachHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem menuXoaItem;
    private javax.swing.JSpinner numDonGia;
    private javax.swing.JSpinner numSoLuongBan;
    private javax.swing.JSpinner numSoLuongTang;
    private javax.swing.JSpinner numTonKho;
    private javax.swing.JPanel pnlThongTinKH;
    private javax.swing.JPopupMenu popupXoaItem;
    private javax.swing.JTable tableDonHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtNgayGio;
    private javax.swing.JTextField txtNhanVienTao;
    private javax.swing.JTextField txtNoCu;
    private javax.swing.JTextField txtNoMoi;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiemKhachHang;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtTongHoaDon;
    // End of variables declaration//GEN-END:variables
}
