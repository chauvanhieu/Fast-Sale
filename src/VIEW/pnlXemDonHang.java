package VIEW;

import CLASS.User;
import CLASS.hoaDon;
import CLASS.khachHang;
import CLASS.nhanVien;
import CLASS.sanPham;
import CLASS.tableHoaDon;
import Controler.ControlerHoaDon;
import Controler.ControlerKhachHang;
import Controler.ControlerNhanVien;
import Controler.ControlerSanPham;
import HELPER.ChuyenDoi;
import javax.swing.JTabbedPane;
import HELPER.helper;
import MODEL.model;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class pnlXemDonHang extends javax.swing.JPanel {

    private hoaDon hoaDon = null;
    private khachHang kh = null;
    private ArrayList<sanPham> dataSanPham = ControlerSanPham.getData();
    private ArrayList<nhanVien> dataNhanVien = ControlerNhanVien.getData();
    private ArrayList<tableHoaDon> dataHoaDon = new ArrayList<tableHoaDon>();
    private boolean askSave;
    private hoaDon hoaDonGoc;
    private ArrayList<tableHoaDon> chiTietGoc = new ArrayList<tableHoaDon>();

    public pnlXemDonHang(User user, String idHoaDon, String nv) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        initComponents();

        this.hoaDon = helper.getHoaDon(idHoaDon);
        hoaDonGoc = this.hoaDon;
        cbNhanVienBan.addItem(nv + " - " + hoaDon.getNhanVienBan());
        for (nhanVien item : dataNhanVien) {
            cbNhanVienBan.addItem(item.getName() + " - " + item.getId());
        }
        kh = ControlerKhachHang.getKhachHang(hoaDon.getMaKhachHang());
        txtNgayGio.setText(hoaDon.getNgayGio());
        cbTenKhachHang.addItem(kh.getName() + " - " + kh.getId());
        txtNhanVienTao.setText(hoaDon.getNhanVienTao());
        txtSoDienThoai.setText(kh.getSoDienThoai());
        txtDiaChi.setText(kh.getDiaChi());
        txtNoCu.setText(ChuyenDoi.LongToString((kh.getTienNo() - hoaDon.getTongTien()))); // hồi phục nợ tạm thời

        dataHoaDon = helper.getDataHoaDon(idHoaDon);
        chiTietGoc = dataHoaDon;
        loadTable(dataHoaDon);
    }

    public void loadTable(ArrayList<tableHoaDon> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Đơn vị tính");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");
        model.addColumn("Thành tiền");
        long tongTien = 0;
        int i = 0;
        for (tableHoaDon item : dataHoaDon) {
            for (sanPham sp : dataSanPham) {
                if (sp.getId() == item.getId()) {
                    int sum = sp.getTonKho() + item.getSoLuong();
                    sp.setTonKho(sum);
                }
            }
            model.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getDonViTinh(),
                item.getTang() == 0 ? ChuyenDoi.LongToString(item.getDonGia()) : 0,
                item.getTang() == 0 ? item.getSoLuong() : item.getTang(),
                item.getTang() == 0 ? ChuyenDoi.LongToString(item.getDonGia() * Long.parseLong(item.getSoLuong() + "")) : 0
            });
            tongTien += item.getTang() == 0 ? item.getDonGia() * Long.parseLong(item.getSoLuong() + "") : 0;
            i++;
        }
        for (sanPham item : dataSanPham) {
            cbSanPham.addItem(item.getName() + " - " + item.getId());
        }
        tableDonHang.setModel(model);
        txtTongHoaDon.setText(ChuyenDoi.LongToString(tongTien));
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
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtNgayGio = new javax.swing.JTextField();
        txtNhanVienTao = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();

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
        btnSave.setEnabled(false);
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
        btnPrint.setText("PRINT");
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
        btnRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
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
        tableDonHang.setEnabled(false);
        tableDonHang.setRowHeight(30);
        tableDonHang.setRowMargin(3);
        tableDonHang.getTableHeader().setReorderingAllowed(false);
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
        cbHinhThucThanhToan.setEnabled(false);
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

        cbNhanVienBan.setEnabled(false);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(txtTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
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

        txtSoDienThoai.setEnabled(false);

        txtDiaChi.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setText("Địa Chỉ :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setText("Tìm khách hàng :");

        txtTimKiemKhachHang.setEnabled(false);
        txtTimKiemKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKhachHangKeyReleased(evt);
            }
        });

        cbTenKhachHang.setEnabled(false);
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

        jPanel5.setBackground(new java.awt.Color(207, 227, 244));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel18.setText("Ngày giờ :");

        txtNgayGio.setEditable(false);
        txtNgayGio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayGio.setForeground(new java.awt.Color(255, 51, 0));
        txtNgayGio.setFocusable(false);

        txtNhanVienTao.setEditable(false);
        txtNhanVienTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhanVienTao.setForeground(new java.awt.Color(204, 51, 0));
        txtNhanVienTao.setFocusable(false);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel26.setText("Nhân viên tạo :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNhanVienTao, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(txtNgayGio))
                .addGap(58, 58, 58))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNgayGio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
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
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlThongTinKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        lock(false);
        if (dataHoaDon.size() > 0) {
            String nhanvien = cbNhanVienBan.getSelectedItem().toString();
            String[] arr = nhanvien.split("-");
            String idNVban = arr[1].trim();
            String khachhang = cbTenKhachHang.getSelectedItem().toString();
            String[] arrz = khachhang.split("-");
            String idKH = arrz[1].trim();
            long tongTien = (long) ChuyenDoi.StringToLong(txtTongHoaDon.getText());
            helper.updateHoaDon(dataHoaDon, hoaDon, tongTien, idNVban);
            helper.congDoanhThu((long) ChuyenDoi.StringToLong(txtTongHoaDon.getText()), idNVban);
            if (cbHinhThucThanhToan.getSelectedItem().toString() == "Nợ") {
                helper.congTienNo((long) ChuyenDoi.StringToLong(txtNoMoi.getText()), idKH);
            }
            helper.giamSoLuongTonKho(dataHoaDon);
            JOptionPane.showMessageDialog(this, "Đã thêm đơn hàng !");
            JTabbedPane parent = (JTabbedPane) this.getParent();
            parent.remove(this);
        } else {
            JOptionPane.showMessageDialog(this, "Chưa có sản phẩm !");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        tableDonHang.setEnabled(true);
        lock(true);
        askSave = true;
        String value = cbHinhThucThanhToan.getSelectedItem().toString();
        if (txtNoCu.getText() != "") {
            if (value == "Nợ") {
                long sum = (long) (ChuyenDoi.StringToLong(txtNoCu.getText()) + ChuyenDoi.StringToLong(txtTongHoaDon.getText()));
                txtNoMoi.setText(ChuyenDoi.LongToString(sum));
            } else {
                txtNoMoi.setText("");
            }
        }

        /*
        1. Cập nhật lại nợ cũ
        2. Cập nhật lại doanh thu nhân viên
        3. Cập nhật số lượng tồn kho từng sản phẩm đã bán
         */
        String nhanvien = cbNhanVienBan.getSelectedItem().toString();
        String[] arr = nhanvien.split("-");
        String idNVban = arr[1].trim();
        String khachhang = cbTenKhachHang.getSelectedItem().toString();
        String[] arrz = khachhang.split("-");
        String idKH = arrz[1].trim();
        ControlerHoaDon.letUpdate(idNVban, idKH, dataHoaDon, hoaDon.getTongTien(), hoaDon.getMaChiTietHoaDon());

    }//GEN-LAST:event_btnEditActionPerformed
    public void lock(boolean bl) {
        cbHinhThucThanhToan.setEnabled(bl);
        cbNhanVienBan.setEnabled(bl);
        txtTimKiemSanPham.setEnabled(bl);
        cbSanPham.setEnabled(bl);
        btnThemSanPham.setEnabled(bl);
        numDonGia.setEnabled(bl);
        numSoLuongBan.setEnabled(bl);
        numSoLuongTang.setEnabled(bl);
        numTonKho.setEnabled(bl);
        btnSave.setEnabled(bl);
        btnPrint.setEnabled(bl);
        btnEdit.setEnabled(bl == true ? false : true);
    }
    private void btnCloseTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabActionPerformed
//        if (askSave == true) { // đã click Sữa
//            if (JOptionPane.showConfirmDialog(this, "Lưu lại ?") == 0) {
//                if (dataHoaDon.size() > 0) {
//                    String nhanvien = cbNhanVienBan.getSelectedItem().toString();
//                    String[] arr = nhanvien.split("-");
//                    String idNVban = arr[1].trim();
//                    String khachhang = cbTenKhachHang.getSelectedItem().toString();
//                    String[] arrz = khachhang.split("-");
//                    String idKH = arrz[1].trim();
//                    long tongTien = (long) ChuyenDoi.StringToLong(txtTongHoaDon.getText());
//                    helper.updateHoaDon(dataHoaDon, hoaDon, tongTien, idNVban);
//                    helper.congDoanhThu((long) ChuyenDoi.StringToLong(txtTongHoaDon.getText()), idNVban);
//                    if (cbHinhThucThanhToan.getSelectedItem().toString() == "Nợ") {
//                        helper.congTienNo((long) ChuyenDoi.StringToLong(txtNoMoi.getText()), idKH);
//                    }
//                    helper.giamSoLuongTonKho(dataHoaDon);
//                    JOptionPane.showMessageDialog(this, "Đã cập nhật !");
//                    JTabbedPane parent = (JTabbedPane) this.getParent();
//                    parent.remove(this);
//                } else {
//                    JOptionPane.showMessageDialog(this, "Chưa có sản phẩm !");
//                }
//            } else {
//                /*
//                  1. Cập nhật lại nợ cũ:    nợ hiện tại - tổng tiền hóa đơn
//                    2. Cập nhật lại doanh thu nhân viên:   doanh thu hiện tại trừ đi tổng tiền hóa đơn
//                 3. Cập nhật số lượng tồn kho từng sản phẩm đã bán: Có ArrayList từng SP => tồn kho hiện tại cộng cho số lượng tặng và số lượng bán
//                   4. Xóa chi tiết hóa đơn đó
//                 */
//
// /*
//                cộng lại nợ cũ
//                cộng lại doanh thu cũ cho nhân viên
//                trừ lại tồn kho như cũ
//                insert lại chi tiết hóa đơn 
//                 */
//                ControlerHoaDon.reup(hoaDonGoc, dataHoaDon);
//                JTabbedPane parent = (JTabbedPane) this.getParent();
//                parent.remove(this);
//            }
//
//        } else {
//            JTabbedPane parent = (JTabbedPane) this.getParent();
//            parent.remove(this);
//        }
        btnSave.doClick();
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
        for (tableHoaDon item : dataHoaDon) {
            if (item.getId().equals(id)) {
                isTonTai = true;
                break;
            }
        }

        if (isTonTai == true) {

            boolean isTangRoi = false;
            for (tableHoaDon item : dataHoaDon) {
                if (item.getId().equals(id) && item.getDonGia() != 0) {
                    item.setSoLuong(item.getSoLuong() + soLuong);
                    item.setThanhTien(item.getDonGia() * Long.parseLong(item.getSoLuong() + ""));
                    break;
                } else if (item.getId().equals(id) && item.getDonGia() == 0) {
                    isTangRoi = true;
                }
            }

            if (isTangRoi && soLuong > 0) {
                for (tableHoaDon item : dataHoaDon) {
                    if (item.getId().equals(id) && item.getDonGia() == 0) {
                        item.setSoLuong(item.getSoLuong() + soLuong);
                    }
                }
            } else if (!isTangRoi && soLuongTang > 0) {
                dataHoaDon.add(new tableHoaDon(id, name, donViTinh, 0, soLuongTang, 0, 0));
            }
        } else {
            if (soLuong > 0 && soLuongTang > 0) {
                dataHoaDon.add(new tableHoaDon(id, name, donViTinh, soLuong, 0, donGia, thanhTien));
                dataHoaDon.add(new tableHoaDon(id, name, donViTinh, 0, soLuongTang, 0, 0));
            } else if (soLuong == 0 && soLuongTang > 0) {
                dataHoaDon.add(new tableHoaDon(id, name, donViTinh, 0, soLuongTang, 0, 0));
            } else if (soLuong > 0 && soLuongTang == 0) {
                dataHoaDon.add(new tableHoaDon(id, name, donViTinh, soLuong, soLuongTang, donGia, thanhTien));
            }
        }

        loadTable(dataHoaDon);
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

    }//GEN-LAST:event_cbHinhThucThanhToanItemStateChanged

    private void txtTimKiemKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKhachHangKeyReleased

    }//GEN-LAST:event_txtTimKiemKhachHangKeyReleased

    private void cbTenKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTenKhachHangItemStateChanged

    }//GEN-LAST:event_cbTenKhachHangItemStateChanged

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Xóa đơn hàng ?") == 0) {
            helper.xoaDonHang(hoaDon.getId(), hoaDon.getMaChiTietHoaDon());
        }
        btnCloseTab.doClick();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void menuXoaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuXoaItemActionPerformed
        int index = tableDonHang.getSelectedRow();
        if (index >= 0 || tableDonHang.getSelectedRows().length != 0) {
            dataHoaDon.remove(index);
            loadTable(dataHoaDon);
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
        }
    }//GEN-LAST:event_menuXoaItemActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        String nhanvien = cbNhanVienBan.getSelectedItem().toString();
        String[] arr = nhanvien.split("-");
        String tenNhanVien = arr[0].trim();
        String idNVban = arr[1].trim();
        String khachhang = cbTenKhachHang.getSelectedItem().toString();
        String[] arrz = khachhang.split("-");
        String idKH = arrz[1].trim();
        String tenKH = arrz[0].trim();

        try {
            Hashtable map = new Hashtable();
            JasperReport jasper = JasperCompileManager.compileReport("src/FormReport/reportHoaDon.jrxml");
            map.put("tenKH", tenKH);
            map.put("tenNV", tenNhanVien);
            map.put("ngayBanHang", txtNgayGio.getText());
            map.put("paramHinhThuc", cbHinhThucThanhToan.getSelectedItem().toString());
            map.put("paramTongTien", txtTongHoaDon.getText());
            map.put("paramIdHoaDon", hoaDon.getId());
            map.put("paramChiTietHoaDon", hoaDon.getMaChiTietHoaDon());
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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