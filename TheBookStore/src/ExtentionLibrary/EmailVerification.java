/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExtentionLibrary;

/**
 *
 * @author Admin
 */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Random;

public class EmailVerification {

    private String verificationCode;

    // Gửi mã xác thực về email
    public void sendVerificationCode(String email, String username) throws MessagingException {
        if (isValidUser(username, email)) {  // Kiểm tra tên đăng nhập và email có hợp lệ không
            if (verificationCode == null) {  // Chỉ tạo mã mới nếu chưa có mã nào
                verificationCode = generateCode();
            }
            if (email == null || email.trim().isEmpty()) {
                throw new MessagingException("Vui lòng không bỏ trống email!");
            }
            sendEmail(email, verificationCode);
        } else {
            throw new MessagingException("Tên đăng nhập hoặc email không hợp lệ!");
        }
    }

    // Kiểm tra tên đăng nhập và email có hợp lệ không (giả định)
    private boolean isValidUser(String username, String email) {
        // Thực hiện kiểm tra hợp lệ, ví dụ kiểm tra trong cơ sở dữ liệu
        // Dưới đây là đoạn mã mẫu, bạn cần thay thế bằng logic kiểm tra thực tế
        return username != null && !username.trim().isEmpty() && email != null && email.contains("@");
    }

    // Tạo mã xác thực
    public String generateCode() {
        Random random = new Random();
        int ma = 100000 + random.nextInt(900000);
        return String.valueOf(ma);
    }

    // Gửi email chứa mã xác thực
    public void sendEmail(String recipientsEmail, String code) throws MessagingException {
        String email = "huynhthithaovy.hg.2021@gmail.com"; // Thay thế bằng email của bạn
        String pass = "mvxy hvde rsqh cjdz";         // Thay thế bằng mật khẩu của bạn

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, pass);
            }
        };

        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(email));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientsEmail));
            msg.setSubject("Mã xác nhận đổi mật khẩu");
            msg.setText("Mã xác nhận của bạn là: " + code);
            Transport.send(msg);
        } catch (SendFailedException e) {
            throw new MessagingException("Email không tồn tại hoặc không thể gửi được!", e);
        } catch (MessagingException e) {
            throw new MessagingException("Có lỗi xảy ra khi gửi email!", e);
        } catch (Exception e) {
            throw new MessagingException("Có lỗi không xác định xảy ra!", e);
        }
    }

    // Lấy mã xác thực hiện tại
    public String getCode() {
        return verificationCode;
    }

}
