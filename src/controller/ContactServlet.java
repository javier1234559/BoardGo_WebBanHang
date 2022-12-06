package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
@WebServlet(urlPatterns = {"/ContactServlet", "/HOME/ContactServlet"})
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String subject = request.getParameter("name");
		String content = request.getParameter("message");
		
		subject = "Cảm ơn phản hồi từ " + subject;
		content = content + " đã được gửi thành công !";
		String footerEmail = request.getParameter("footerEmail");
		if(footerEmail != null) {
			email = footerEmail;
			subject = "Success!";
			content = "Đăng kí nhận tin thành công !";
		}
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("nguyenhue1234559@gmail.com", "keyoorkikodbequs");
			}
		});
		String to = email ;
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));// change accordingly
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(content);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		}

		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("thankyou.html");
		dispatcher.forward(request, response);
            
	  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
