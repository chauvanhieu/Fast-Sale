package VIEW;

import CLASS.User;
import CLASS.nhanVien;
import Controler.ControlerNhanVien;
import Controler.ControlerUser;
import HELPER.helper;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class editorUser extends javax.swing.JDialog {

    public static String option;
    public static String username;
    private static User user;
    private static ArrayList<nhanVien> listNhanVien = ControlerNhanVien.getData();

    public editorUser(java.awt.Frame parent, boolean modal, String option, String username) {
        super(parent, modal);
        this.option = option;
        this.user = ControlerUser.getUser(username);
        initComponents();
        setLocationRelativeTo(null);
        for (nhanVien item : listNhanVien) {
            cbNhanVienUser.addItem(item.getName() + " - " + item.getId());
        }
        cbNhanVienUser.setSelectedIndex(0);
        if (option == "edit") {
            txtUsername.setText(user.getUsername());
            txtUsername.setEditable(false);
            txtUsername.setFocusable(false);

            chkBaoCao.setSelected(user.isBaoCao());
            chkDanhMuc.setSelected(user.isDanhMuc());
            chkDoanhThu.setSelected(user.isDoanhThu());
            chkKhoHang.setSelected(user.isKhoHang());
            chkThemDonHang.setSelected(user.isThemDonHang());
            chkThuNo.setSelected(user.isThuNo());
            chkXemDonHang.setSelected(user.isXemDonHang());
        } else {
            btnRemove.setEnabled(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        cbNhanVienUser = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        chkXemDonHang = new javax.swing.JCheckBox();
        chkThemDonHang = new javax.swing.JCheckBox();
        chkDoanhThu = new javax.swing.JCheckBox();
        chkKhoHang = new javax.swing.JCheckBox();
        chkDanhMuc = new javax.swing.JCheckBox();
        chkThuNo = new javax.swing.JCheckBox();
        chkBaoCao = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCloseTab = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN TÀI KHOẢN");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setText("Username :");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setText("Confirm password :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel10.setText("Password :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel8.setText("Nhân viên :");

        jPanel3.setLayout(new java.awt.GridBagLayout());

        chkXemDonHang.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        chkXemDonHang.setText("Xem đơn hàng");
        chkXemDonHang.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanel3.add(chkXemDonHang, new java.awt.GridBagConstraints());

        chkThemDonHang.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        chkThemDonHang.setText("Thêm đơn hàng");
        chkThemDonHang.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanel3.add(chkThemDonHang, new java.awt.GridBagConstraints());

        chkDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        chkDoanhThu.setText("Doanh thu");
        chkDoanhThu.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanel3.add(chkDoanhThu, new java.awt.GridBagConstraints());

        chkKhoHang.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        chkKhoHang.setText("Kho hàng");
        chkKhoHang.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanel3.add(chkKhoHang, new java.awt.GridBagConstraints());

        chkDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        chkDanhMuc.setText("Danh mục");
        chkDanhMuc.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanel3.add(chkDanhMuc, new java.awt.GridBagConstraints());

        chkThuNo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        chkThuNo.setText("Thu nợ");
        chkThuNo.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanel3.add(chkThuNo, new java.awt.GridBagConstraints());

        chkBaoCao.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        chkBaoCao.setText("Báo cáo");
        chkBaoCao.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanel3.add(chkBaoCao, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbNhanVienUser, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbNhanVienUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

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
        jPanel2.add(btnSave);

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
        jPanel2.add(btnRemove);

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
        jPanel2.add(btnCloseTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        helper.validUsername(txtUsername);
    }//GEN-LAST:event_txtUsernameKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        String username = txtUsername.getText();
        String password = new String(txtConfirmPassword.getPassword());
        String password2 = new String(txtPassword.getPassword());
        String[] arr = cbNhanVienUser.getSelectedItem().toString().split("-");
        String nhanvien = arr[1].trim();

        if (option == "edit") {
            if (!helper.isUsername(username)) {
                JOptionPane.showMessageDialog(this, "Username sai cú pháp !");
                return;
            }
            if (!password.equals(password2)) {
                JOptionPane.showMessageDialog(this, "Mật khẩu không trùng khớp !");
            } else {
                ControlerUser.setAccount(new User(username,
                        password,
                        nhanvien,
                        false,
                        chkXemDonHang.isSelected(),
                        chkThemDonHang.isSelected(),
                        chkDoanhThu.isSelected(),
                        chkKhoHang.isSelected(),
                        chkDanhMuc.isSelected(),
                        chkThuNo.isSelected(),
                        chkBaoCao.isSelected()));
                JOptionPane.showMessageDialog(this, "Đã cập nhật !");
                this.setVisible(false);

            }
        } else if (option == "") {
            if (!helper.isUsername(username)) {
                JOptionPane.showMessageDialog(this, "Username sai cú pháp !");
                return;
            }
            ArrayList<String> listUsername = ControlerUser.getUsername();
            boolean isNewUsername = true;
            for (String item : listUsername) {
                if (item.equals(username)) {
                    isNewUsername = false;
                }
            }
            if (isNewUsername) {
                if (!password.equals(password2)) {
                    JOptionPane.showMessageDialog(this, "Mật khẩu không trùng khớp !");
                } else {
                    ControlerUser.addAccount(new User(username,
                            password,
                            nhanvien,
                            false,
                            chkXemDonHang.isSelected(),
                            chkThemDonHang.isSelected(),
                            chkDoanhThu.isSelected(),
                            chkKhoHang.isSelected(),
                            chkDanhMuc.isSelected(),
                            chkThuNo.isSelected(),
                            chkBaoCao.isSelected()));
                    JOptionPane.showMessageDialog(this, "Đã thêm tài khoản !");
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username đã tồn tại !");
            }

        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Xóa tài khoản ?") == 0) {
            ControlerUser.removeAccount(txtUsername.getText());
            JOptionPane.showMessageDialog(this, "Đã xóa tài khoản !");
            this.setVisible(false);
        }

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCloseTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseTabActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

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
                editorUser dialog = new editorUser(new javax.swing.JFrame(), true, option, username);
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
    private javax.swing.JComboBox<String> cbNhanVienUser;
    private javax.swing.JCheckBox chkBaoCao;
    private javax.swing.JCheckBox chkDanhMuc;
    private javax.swing.JCheckBox chkDoanhThu;
    private javax.swing.JCheckBox chkKhoHang;
    private javax.swing.JCheckBox chkThemDonHang;
    private javax.swing.JCheckBox chkThuNo;
    private javax.swing.JCheckBox chkXemDonHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
