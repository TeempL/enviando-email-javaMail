package br.com.javamail.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javamail.entidade.Email;

@WebServlet("/javaMail")
public class JavaMailServlet extends HttpServlet {
	
	private String email = "lolalajjs1@gmail.com";
	private String senha = "kyvzfbeouwphaqos";
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String eml = request.getParameter("email");
		String titulo = request.getParameter("titulo");
		String mensagem = request.getParameter("mensagem");
		
		Email mail = new Email();
		mail.setEmail(eml);
		mail.setNome(nome);
		mail.setTitulo(titulo);
		mail.setMensagem(mensagem);
		
		Properties properties = new Properties();
		try {
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					
					return new PasswordAuthentication(email,senha);
				}
			});
			
			Address[] toUser = InternetAddress.parse(mail.getEmail());
		
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(mail.getTitulo());
			message.setText(mail.getMensagem() + " Enviado por: " + mail.getNome());

			Transport.send(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("msg", "Email enviado");
		rd.forward(request, response);
		
	}
}
