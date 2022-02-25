package com.example.user.email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.user.model.Items;
import com.example.user.model.User;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail,String body, String subject) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("dhanyakumargs11@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);

	}

	public void sendItems(User user) {
		SimpleMailMessage message = new SimpleMailMessage();
		String body ="";
		double price = 0;
		for(Items item : user.getItems()) {
			body = item.getName()+" qty : "+item.getQty()+"\n";
			price = price+(item.getQty()*item.getPrice());
			}
		body=body+"\n Total Price :"+price;
		message.setFrom("dhanyakumargs11@gmail.com");
		message.setTo(user.getEmail());
		message.setText(body);
		message.setSubject("Online Shopping Cart OrderDetails");
		
		mailSender.send(message);
		System.out.println("msg"+message);
	}
}
