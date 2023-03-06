package VIEW;

import CLASS.nhanVien;
import Controler.ControlerNhanVien;
import HELPER.helper;
import com.formdev.flatlaf.FlatLightLaf;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class editorNhanVien extends javax.swing.JDialog {

    public static String option;
    public static String idNhanVien;
    public static nhanVien nhanVien;

    public editorNhanVien(java.awt.Frame parent, boolean modal, String option, String idnhanvien) throws ParseException {
        super(parent, modal);
        this.option = option;
        initComponents();
        setLocationRelativeTo(null);
        if (option == "edit") {
            this.idNhanVien = idnhanvien;
            this.nhanVien = ControlerNhanVien.getNhanVien(idnhanvien);
            txtIdNhanVien.setText(nhanVien.getId());
            txtDiaChiNhanVien.setText(nhanVien.getDiaChi());
            txtNameNhanVien.setText(nhanVien.getName());
            txtSoDienThoaiNhanVien.setText(nhanVien.getSoDienThoai());
            if (nhanVien.isGioiTinh() == true) {
                checkNam.setSelected(true);
                checkNu.setSelected(false);
            } else {
                checkNam.setSelected(false);
                checkNu.setSelected(true);
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateNgaySinh.setDate(dateFormat.parse(nhanVien.getNgaySinh()));
            numLuongCoBan.setValue(Integer.parseInt(nhanVien.getTienLuong() + ""));

        } else {
            txtIdNhanVien.setText(helper.newID("NV"));
            btnRemove.setEnabled(false);
            dateNgaySinh.setDate(new Date());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gioiTinh = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCloseTab = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtIdNhanVien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNameNhanVien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChiNhanVien = new javax.swing.JTextField();
        txtSoDienThoaiNhanVien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        checkNam = new javax.swing.JCheckBox();
        checkNu = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        numLuongCoBan = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
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
        jPanel2.add(btnSave);

        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(0, 0, 0));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/delete.png"))); // NOI18N
        btnRemove.setText("XÓA");
        btnRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel2.add(btnRemove);

        btnCloseTab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCloseTab.setForeground(new java.awt.Color(0, 0, 0));
        btnCloseTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/exit.png"))); // NOI18N
        btnCloseTab.setText("THOÁT");
        btnCloseTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabActionPerformed(evt);
            }
        });
        jPanel2.add(btnCloseTab);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setText("Mã nhân viên :");

        txtIdNhanVien.setEditable(false);
        txtIdNhanVien.setFocusable(false);
        txtIdNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdNhanVienKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setText("Tên nhân viên :");

        txtNameNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameNhanVienKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setText("Địa chỉ :");

        txtDiaChiNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiaChiNhanVienKeyReleased(evt);
            }
        });

        txtSoDienThoaiNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoDienThoaiNhanVienKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel8.setText("Số điện thoại :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setText("Ngày sinh :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel10.setText("Giới tính :");

        gioiTinh.add(checkNam);
        checkNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkNam.setText("Nam");
        checkNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNamActionPerformed(evt);
            }
        });

        gioiTinh.add(checkNu);
        checkNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkNu.setText("Nữ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel11.setText("Lương :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiaChiNhanVien)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dateNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdNhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(checkNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(checkNu)
                                .addGap(40, 40, 40)))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoDienThoaiNhanVien)
                            .addComponent(txtNameNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(numLuongCoBan))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(numLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(checkNu)
                    .addComponent(checkNam)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(txtDiaChiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN NHÂN VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (option == "edit") {
            Date today = new Date();
            Date born = dateNgaySinh.getDate();
            if (today.getYear() - born.getYear() < 18) {
                JOptionPane.showMessageDialog(null, "Chưa đủ 18 tuổi !");
                return;
            }

            //cập nhật
            String id = txtIdNhanVien.getText();
            String name = txtNameNhanVien.getText();
            String sdt = txtSoDienThoaiNhanVien.getText();
            if (sdt.equals("")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không được trống !");
                return;
            }
            String diachi = txtDiaChiNhanVien.getText();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinh = dcn.format(dateNgaySinh.getDate());
            boolean isgioitinh;
            if (id.equals("") || name.equals("") || sdt.equals("") || diachi.equals("")) {
                JOptionPane.showMessageDialog(this, "không được để trống");
                return;
            }
            if (checkNam.isSelected() == true) {
                isgioitinh = true;
            } else {
                isgioitinh = false;
            }
            long luong = Long.parseLong(numLuongCoBan.getValue() + "");
            if (luong < 1000000) {
                JOptionPane.showMessageDialog(this, "Lương phải hơn 1 triệu !");
                return;
            }
            ControlerNhanVien.capNhatNhanVien(new nhanVien(id, name, sdt, diachi, ngaySinh, isgioitinh, luong, 0, true));
            JOptionPane.showMessageDialog(this, "Đã cập nhật !");
            this.setVisible(false);
        } else if (option == "") {
            //Thêm

            Date today = new Date();
            Date born = dateNgaySinh.getDate();
            if (today.getYear() - born.getYear() < 18) {
                JOptionPane.showMessageDialog(null, "Chưa đủ 18 tuổi !");
                return;
            }

            String id = txtIdNhanVien.getText();
            String name = txtNameNhanVien.getText();
            String sdt = txtSoDienThoaiNhanVien.getText();
            if (sdt.equals("")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không được trống !");
                return;
            }
            String diachi = txtDiaChiNhanVien.getText();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinh = dcn.format(dateNgaySinh.getDate());
            boolean isgioitinh;
            if (id.equals("") || name.equals("") || sdt.equals("") || diachi.equals("")) {
                JOptionPane.showMessageDialog(this, "không được để trống");
                return;
            }
            if (checkNam.isSelected() == true) {
                isgioitinh = true;
            } else {
                isgioitinh = false;
            }
            long luong = Long.parseLong(numLuongCoBan.getValue() + "");
            if (luong < 1000000) {
                JOptionPane.showMessageDialog(this, "Lương phải hơn 1 triệu !");
                return;
            }
            if (name != "" || sdt != "" || diachi != "" || luong > 100000) {
                ControlerNhanVien.add(new nhanVien(id, name, sdt, diachi, ngaySinh, isgioitinh, luong, 0, true));
                JOptionPane.showMessageDialog(this, "Đã thêm nhân viên !");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Sai thông tin nhân viên !");
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (option == "edit") {
            String id = txtIdNhanVien.getText();
            if (JOptionPane.showConfirmDialog(this, "Xóa nhân viên ?") == 0) {
                ControlerNhanVien.remove(id);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCloseTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseTabActionPerformed

    private void txtNameNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameNhanVienKeyReleased
        helper.validName(txtNameNhanVien);
    }//GEN-LAST:event_txtNameNhanVienKeyReleased

    private void txtIdNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdNhanVienKeyReleased

    }//GEN-LAST:event_txtIdNhanVienKeyReleased

    private void txtDiaChiNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaChiNhanVienKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiNhanVienKeyReleased

    private void txtSoDienThoaiNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoDienThoaiNhanVienKeyReleased

    }//GEN-LAST:event_txtSoDienThoaiNhanVienKeyReleased

    private void checkNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                editorNhanVien dialog = null;
                try {
                    dialog = new editorNhanVien(new javax.swing.JFrame(), true, option, idNhanVien);
                } catch (ParseException ex) {
                    Logger.getLogger(editorNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseTab;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox checkNam;
    private javax.swing.JCheckBox checkNu;
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private javax.swing.ButtonGroup gioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner numLuongCoBan;
    private javax.swing.JTextField txtDiaChiNhanVien;
    private javax.swing.JTextField txtIdNhanVien;
    private javax.swing.JTextField txtNameNhanVien;
    private javax.swing.JTextField txtSoDienThoaiNhanVien;
    // End of variables declaration//GEN-END:variables
}
