package dmi.ris.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	   @Autowired
	    private JavaMailSender javaMailSender;	
	    
	    public void sendEmail(String receiver, String sender, String subject, String body) {
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(receiver);
	        msg.setCc(sender);
	        msg.setSubject(subject);
	        msg.setText(body);
	        javaMailSender.send(msg);    	
	    }
	    
	    public void sendEmailWithAttachment(String receiver,String sender, String subject, String text, File file) {
	    		    try {
	    		    	MimeMessage message = javaMailSender.createMimeMessage();   
	        		    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        		    
	        		    helper.setCc(sender);
	        		    helper.setTo(receiver);
	        		    helper.setSubject(subject);
						helper.setText(text);
	        		    FileSystemResource fileResource = new FileSystemResource(file); 	
	        		    helper.addAttachment(file.getName(), fileResource);
	        		    javaMailSender.send(message);
					} catch (Exception e) {
						e.printStackTrace();
					}
	    		        
	    		}

}
