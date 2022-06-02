package com.kwg.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.kwg.model.CenproURLStatus;

@Component
public class SendMailUtility {

	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendMail(String to,String subject,String body) {
		try {

			System.out.println("sending mail....!");
			//set props
			SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);

			//send mail
			javaMailSender.send(simpleMailMessage);
			System.out.println("Done...");

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean sendEmailNew(String to, String subject,CenproURLStatus cenproURLStatus) {
		try {
			System.out.println("sending mail....!");

			MimeMessage mimeMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
			String statusBody = getUnlockAccEmailBody(cenproURLStatus);

			helper.setTo("sourabh101094@gmail.com");
			helper.setSubject(subject);
			helper.setText(statusBody, true);

			javaMailSender.send(mimeMsg);
			System.out.println("Done...");

			return true;
		} catch (Exception e) {

		}
		return false;
	}



	public String getUnlockAccEmailBody(CenproURLStatus cenproURLStatus) throws IOException {
		StringBuffer sb = new StringBuffer("");

		FileReader fr = new FileReader("CENPRO'S-URL-STATUS-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		
		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}

		br.close();

		// format mail body
		String mailBody = sb.toString();
		//mailBody.replace("{DATE}", (CharSequence) cenproURLStatus.getTimestamp());
		mailBody = mailBody.replace("{WORKING}", cenproURLStatus.getStatus());
		System.out.println(cenproURLStatus.getStatus());



		return mailBody;
	}
}
