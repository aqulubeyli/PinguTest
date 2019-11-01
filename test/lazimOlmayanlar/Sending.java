package lazimOlmayanlar;

/*****************************************************
 * 	Tebrikleri gondermek ucun javada expremental proq
 * 		terminaldan
 * 	
 *****************************************************/

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

import com.sun.mail.smtp.SMTPTransport;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import mailsender.conf.MailListReader;


public class Sending{

	public void send_main(){

		String mail_from 			= 	"aydin.qulubeyli@mail.ru";
		String mail_to 	 			= 	"aydin.qulubeyli@mail.ru";
		String mail_password			= 	"Zxcv5555";
                String PATH                             =       "C:\\Users\\Aydin\\Documents\\NetBeansProjects\\PinguMail\\src\\mailsender\\conf\\maillist.txt";
                String mail_adr_tmp                     =       "";
                int mail_adrs_sayi                      =       new MailListReader().mail_list_size(PATH) - 1;
                
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.mail.ru");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(props, null);
                
                while(mail_adrs_sayi >= 0){
                    
                    System.out.println(mail_adrs_sayi);

		
                    try{
                            mail_adr_tmp = new MailListReader().mail_list_reader(PATH, mail_adrs_sayi);
                            Message msg = new MimeMessage(session);

                            msg.setFrom(new InternetAddress(mail_from, "Aydin Qulubeyli"));
                            
                            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail_adr_tmp, false));
                            msg.setSubject("Поздравление");
                            msg.setText("");
                            
                            
//                                    tmp
                            //*********************************************
                            MimeMultipart multipart = new MimeMultipart("related");

                            // first part (the html)
                            BodyPart messageBodyPart = new MimeBodyPart();
                            String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
                            messageBodyPart.setContent(htmlText, "text/html");
                            // add it
                            multipart.addBodyPart(messageBodyPart);

                            // second part (the image)
                            messageBodyPart = new MimeBodyPart();
                            DataSource fds = new FileDataSource(
                               "/home/aydin/Project/test-mail-sender-java/src/8559371.jpg");

                            messageBodyPart.setDataHandler(new DataHandler(fds));
                            messageBodyPart.setHeader("Content-ID", "<image>");

                            // add image to the multipart
                            multipart.addBodyPart(messageBodyPart);

                            // put everything together
                            msg.setContent(multipart);

                            /*
                                    bunalar arashdirilmalidir
                             */
//                            msg.setHeader("Xmaller", "Tov");
                            msg.setSentDate(new Date());

                            //						PROTOCLS
                            // Parsingin formasini yoxlamaq lazimdir
                            // muxtelif modelleri tetbiq etmek lazimdir.
                            //
//                            SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
//                            // SMTPTransport t = session.getTransport("smtps");
//                            t.connect("smtp.mail.ru", mail_from, mail_password);
//                            t.sendMessage(msg, msg.getAllRecipients());
//                            System.out.println("Response: "+ t.getLastServerResponse());
                                 Transport.send(msg);


                    }
                    catch( Exception msg){
                            msg.printStackTrace();
                    }
                    mail_adrs_sayi--;
                }
	}


	/***************************************************************************************
		Mail adreslerinin toplu verilmesi
	 ***************************************************************************************/


/******************************************************************************************
	Kodun optimize eidlmesi
 ******************************************************************************************/

	/**
	 * [connect description]
	 * @param mail_address_from [description]
	 * @param mail_address_to   [description]
	 */
	public void connect(String mail_address, String mail_password){
		System.out.println("this is for connect e-mail");	
	}


	/**
	 * Mesaji gondermek ucun Metod
	 * @param mail_address_from [description]
	 * @param mail_address_to   [description]
	 */

	public void messageSender(String mail_address_from, String mail_address_to, String message_subject, String message_text){
		System.out.println("this is for sender message");	
	}
}

