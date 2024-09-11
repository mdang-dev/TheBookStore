/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TheBookStore;

import DAO.EmployeeDAO;
import EntityClass.Employees;
import ExtentionLibrary.Auth;
import ExtentionLibrary.EmailVerification;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import raven.alerts.MessageAlerts;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

/**
 *
 * @author LENOVO
 */
public class ForgetPassword extends javax.swing.JFrame {

    EmployeeDAO empDAO = new EmployeeDAO();
    EmailVerification verify = new EmailVerification();
    private Timer timer;
    private int thoiGianDemNguoc = 30;

    public ForgetPassword() {
        initComponents();
        lblHideForgotPass1.setIcon(new ImageIcon("src//img//hide.png"));
        lblHideForgotPass2.setIcon(new ImageIcon("src//img//hide.png"));
        Timer_ForgotPass();

        GlassPanePopup.install(this);
        Notifications.getInstance().setJFrame(this);
    }

    private void Timer_ForgotPass() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (thoiGianDemNguoc > 0) {
                    btnSendForgotPass.setText(thoiGianDemNguoc + "");
                    thoiGianDemNguoc--;
                } else {
                    timer.stop();
                    btnSendForgotPass.setEnabled(true);
                    btnSendForgotPass.setText("Gửi mã");
                    thoiGianDemNguoc = 60; // Reset đếm ngược
                }
            }
        });
    }

    void clearFormForgotPass() {
        txtUsernameForgotPass.setText("");
        txtEmailForgotPass.setText("");
        txtNewPassForgotPass1.setText("");
        txtNewPassForgotPass2.setText("");
        txtVerificationCodeForgotPass.setText("");
        btnSendForgotPass.setEnabled(true);
    }

    Employees getForgotPassForm() {
        Employees e = new Employees();
        e.setUserName(txtUsernameForgotPass.getText());
        e.setEmail(txtEmailForgotPass.getText());
        return e;
    }

    public void UpdatePass() {
        String userName = txtUsernameForgotPass.getText();
        String newPass1 = new String(txtNewPassForgotPass1.getPassword());
        String newPass2 = new String(txtNewPassForgotPass2.getPassword());
        String email = txtEmailForgotPass.getText();
        String enteredCode = txtVerificationCodeForgotPass.getText();

        Employees e = empDAO.selectByName(userName) == null ? null : empDAO.selectByName(userName).get(0);
        if (e == null) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Tên đăng nhập không tồn tại hoặc rỗng!");
            return;
        }
        if (txtNewPassForgotPass1.getText().isBlank() || txtNewPassForgotPass2.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập mật khẩu và xác nhận!");
        } else if (!email.equals(e.getEmail()) || txtEmailForgotPass.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập email và đúng email!");
        } else if (!newPass1.equals(newPass2)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Xác nhận mật khẩu không khớp!");
        } else if (!verify.getCode().equals(enteredCode) || txtVerificationCodeForgotPass.getText().isBlank()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập và nhập đúng mã xác thực!");
        } else {
            e.setEmployeePassword(newPass1);
            empDAO.update(e);
            MessageAlerts.getInstance().showMessage("TheBookStore", "Đổi mật khẩu thành công!", MessageAlerts.MessageType.SUCCESS);
            clearFormForgotPass();
        }
    }

    public void SendForgotPass() {
        String userName = txtUsernameForgotPass.getText();
        String email = txtEmailForgotPass.getText();

        if (email == null || email.trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Vui lòng nhập địa chỉ email!");
            return;
        }

        try {
            verify.sendVerificationCode(email, userName);
            MessageAlerts.getInstance().showMessage("TheBookStore", "Mã xác thực đã được gửi đến địa chỉ email của bạn!", MessageAlerts.MessageType.SUCCESS);
            btnSendForgotPass.setEnabled(false);
            timer.start();
        } catch (MessagingException e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 3000, "Lỗi khi gửi mã xác thực qua email!");
            e.printStackTrace(); // In chi tiết lỗi ra console hoặc log file
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlForgetPassword = new javax.swing.JPanel();
        lblForgotPass = new javax.swing.JLabel();
        lblHideForgotPass1 = new javax.swing.JLabel();
        lblHideForgotPass2 = new javax.swing.JLabel();
        txtUsernameForgotPass = new javax.swing.JTextField();
        txtNewPassForgotPass1 = new javax.swing.JPasswordField();
        lblReturnFormLoginForgotPass = new javax.swing.JLabel();
        btnConfirmForgotPass = new javax.swing.JButton();
        txtNewPassForgotPass2 = new javax.swing.JPasswordField();
        txtEmailForgotPass = new javax.swing.JTextField();
        txtVerificationCodeForgotPass = new javax.swing.JTextField();
        btnSendForgotPass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlForgetPassword.setBackground(new java.awt.Color(255, 255, 255));
        pnlForgetPassword.setForeground(new java.awt.Color(255, 255, 255));
        pnlForgetPassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblForgotPass.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblForgotPass.setText("QUÊN MẬT KHẨU");
        pnlForgetPassword.add(lblForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 31, -1, 33));

        lblHideForgotPass1.setText(" ");
        lblHideForgotPass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHideForgotPass1MouseClicked(evt);
            }
        });
        pnlForgetPassword.add(lblHideForgotPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 196, 40, 20));

        lblHideForgotPass2.setText(" ");
        lblHideForgotPass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHideForgotPass2MouseClicked(evt);
            }
        });
        pnlForgetPassword.add(lblHideForgotPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 40, 20));

        txtUsernameForgotPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUsernameForgotPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên Đăng Nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtUsernameForgotPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtUsernameForgotPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameForgotPassActionPerformed(evt);
            }
        });
        pnlForgetPassword.add(txtUsernameForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 97, 420, 57));

        txtNewPassForgotPass1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNewPassForgotPass1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mật Khẩu Mới", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtNewPassForgotPass1.setEchoChar('*');
        pnlForgetPassword.add(txtNewPassForgotPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 172, 360, 57));

        lblReturnFormLoginForgotPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblReturnFormLoginForgotPass.setText("Đăng Nhập?");
        lblReturnFormLoginForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReturnFormLoginForgotPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReturnFormLoginForgotPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReturnFormLoginForgotPassMouseExited(evt);
            }
        });
        pnlForgetPassword.add(lblReturnFormLoginForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 120, -1));

        btnConfirmForgotPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirmForgotPass.setText("ĐỔI MẬT KHẨU");
        btnConfirmForgotPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmForgotPassActionPerformed(evt);
            }
        });
        pnlForgetPassword.add(btnConfirmForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 146, 35));

        txtNewPassForgotPass2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNewPassForgotPass2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Xác Nhận Mật Khẩu Mới", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtNewPassForgotPass2.setEchoChar('*');
        pnlForgetPassword.add(txtNewPassForgotPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 247, 360, 57));

        txtEmailForgotPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmailForgotPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtEmailForgotPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtEmailForgotPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailForgotPassActionPerformed(evt);
            }
        });
        pnlForgetPassword.add(txtEmailForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 322, 420, 57));

        txtVerificationCodeForgotPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtVerificationCodeForgotPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Xác Nhận", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtVerificationCodeForgotPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtVerificationCodeForgotPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVerificationCodeForgotPassActionPerformed(evt);
            }
        });
        pnlForgetPassword.add(txtVerificationCodeForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 397, 320, 57));

        btnSendForgotPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSendForgotPass.setText("Gửi Mã");
        btnSendForgotPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendForgotPassActionPerformed(evt);
            }
        });
        pnlForgetPassword.add(btnSendForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 90, 40));

        getContentPane().add(pnlForgetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameForgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameForgotPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameForgotPassActionPerformed

    private void btnConfirmForgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmForgotPassActionPerformed

        this.UpdatePass();
    }//GEN-LAST:event_btnConfirmForgotPassActionPerformed

    private void txtEmailForgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailForgotPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailForgotPassActionPerformed

    private void txtVerificationCodeForgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVerificationCodeForgotPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVerificationCodeForgotPassActionPerformed

    private void btnSendForgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendForgotPassActionPerformed
        // TODO add your handling code here:
        this.SendForgotPass();
    }//GEN-LAST:event_btnSendForgotPassActionPerformed

    private void lblHideForgotPass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHideForgotPass1MouseClicked
        if (txtNewPassForgotPass1.getEchoChar() != 0) {
            txtNewPassForgotPass1.setEchoChar((char) 0); // Hiện mật khẩu
            ImageIcon icon = new ImageIcon("src//img//view.png");
            lblHideForgotPass1.setIcon(icon);
        } else {
            txtNewPassForgotPass1.setEchoChar('*'); // Ẩn mật khẩu
            ImageIcon icon = new ImageIcon("src//img//hide.png");
            lblHideForgotPass1.setIcon(icon);
        }
    }//GEN-LAST:event_lblHideForgotPass1MouseClicked

    private void lblHideForgotPass2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHideForgotPass2MouseClicked
        if (txtNewPassForgotPass2.getEchoChar() != 0) {
            txtNewPassForgotPass2.setEchoChar((char) 0); // Hiện mật khẩu
            ImageIcon icon = new ImageIcon("src//img//view.png");
            lblHideForgotPass2.setIcon(icon);
        } else {
            txtNewPassForgotPass2.setEchoChar('*'); // Ẩn mật khẩu
            ImageIcon icon = new ImageIcon("src//img//hide.png");
            lblHideForgotPass2.setIcon(icon);
        }
    }//GEN-LAST:event_lblHideForgotPass2MouseClicked

    private void lblReturnFormLoginForgotPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnFormLoginForgotPassMouseEntered
       lblReturnFormLoginForgotPass.setText("<html><u>Đăng Nhập</u></html>");
       lblReturnFormLoginForgotPass.setForeground(Color.red);
    }//GEN-LAST:event_lblReturnFormLoginForgotPassMouseEntered

    private void lblReturnFormLoginForgotPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnFormLoginForgotPassMouseExited
        lblReturnFormLoginForgotPass.setText("Đăng Nhập?");
        lblReturnFormLoginForgotPass.setForeground(new Color(187, 187, 187));
    }//GEN-LAST:event_lblReturnFormLoginForgotPassMouseExited

    private void lblReturnFormLoginForgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnFormLoginForgotPassMouseClicked
       new Login().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_lblReturnFormLoginForgotPassMouseClicked

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
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmForgotPass;
    private javax.swing.JButton btnSendForgotPass;
    private javax.swing.JLabel lblForgotPass;
    private javax.swing.JLabel lblHideForgotPass1;
    private javax.swing.JLabel lblHideForgotPass2;
    private javax.swing.JLabel lblReturnFormLoginForgotPass;
    private javax.swing.JPanel pnlForgetPassword;
    private javax.swing.JTextField txtEmailForgotPass;
    private javax.swing.JPasswordField txtNewPassForgotPass1;
    private javax.swing.JPasswordField txtNewPassForgotPass2;
    private javax.swing.JTextField txtUsernameForgotPass;
    private javax.swing.JTextField txtVerificationCodeForgotPass;
    // End of variables declaration//GEN-END:variables
}
