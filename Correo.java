/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class Correo {
static String readFile(String path, Charset encoding) 
  throws IOException 
{
  byte[] encoded = Files.readAllBytes(Paths.get(path));
  return new String(encoded, encoding);
}

    private static String makeBody(String  status, String orden, String ref, String titulo) {
       
        String body="\r\n" + 
        		"	<head>\r\n" + 
        		"		<title>Internal_email-29</title>\r\n" + 
        		"		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
        		"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n" + 
        		"		<style type=\"text/css\">\r\n" + 
        		"			* {\r\n" + 
        		"				-ms-text-size-adjust:100%;\r\n" + 
        		"				-webkit-text-size-adjust:none;\r\n" + 
        		"				-webkit-text-resize:100%;\r\n" + 
        		"				text-resize:100%;\r\n" + 
        		"			}\r\n" + 
        		"			a{\r\n" + 
        		"				outline:none;\r\n" + 
        		"				color:#40aceb;\r\n" + 
        		"				text-decoration:underline;\r\n" + 
        		"			}\r\n" + 
        		"			a:hover{text-decoration:none !important;}\r\n" + 
        		"			.nav a:hover{text-decoration:underline !important;}\r\n" + 
        		"			.title a:hover{text-decoration:underline !important;}\r\n" + 
        		"			.title-2 a:hover{text-decoration:underline !important;}\r\n" + 
        		"			.btn:hover{opacity:0.8;}\r\n" + 
        		"			.btn a:hover{text-decoration:none !important;}\r\n" + 
        		"			.btn{\r\n" + 
        		"				-webkit-transition:all 0.3s ease;\r\n" + 
        		"				-moz-transition:all 0.3s ease;\r\n" + 
        		"				-ms-transition:all 0.3s ease;\r\n" + 
        		"				transition:all 0.3s ease;\r\n" + 
        		"			}\r\n" + 
        		"			table td {border-collapse: collapse !important;}\r\n" + 
        		"			.ExternalClass, .ExternalClass a, .ExternalClass span, .ExternalClass b, .ExternalClass br, .ExternalClass p, .ExternalClass div{line-height:inherit;}\r\n" + 
        		"			@media only screen and (max-width:500px) {\r\n" + 
        		"				table[class=\"flexible\"]{width:100% !important;}\r\n" + 
        		"				table[class=\"center\"]{\r\n" + 
        		"					float:none !important;\r\n" + 
        		"					margin:0 auto !important;\r\n" + 
        		"				}\r\n" + 
        		"				*[class=\"hide\"]{\r\n" + 
        		"					display:none !important;\r\n" + 
        		"					width:0 !important;\r\n" + 
        		"					height:0 !important;\r\n" + 
        		"					padding:0 !important;\r\n" + 
        		"					font-size:0 !important;\r\n" + 
        		"					line-height:0 !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"img-flex\"] img{\r\n" + 
        		"					width:100% !important;\r\n" + 
        		"					height:auto !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"aligncenter\"]{text-align:center !important;}\r\n" + 
        		"				th[class=\"flex\"]{\r\n" + 
        		"					display:block !important;\r\n" + 
        		"					width:100% !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"wrapper\"]{padding:0 !important;}\r\n" + 
        		"				td[class=\"holder\"]{padding:30px 15px 20px !important;}\r\n" + 
        		"				td[class=\"nav\"]{\r\n" + 
        		"					padding:20px 0 0 !important;\r\n" + 
        		"					text-align:center !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"h-auto\"]{height:auto !important;}\r\n" + 
        		"				td[class=\"description\"]{padding:30px 20px !important;}\r\n" + 
        		"				td[class=\"i-120\"] img{\r\n" + 
        		"					width:120px !important;\r\n" + 
        		"					height:auto !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"footer\"]{padding:5px 20px 20px !important;}\r\n" + 
        		"				td[class=\"footer\"] td[class=\"aligncenter\"]{\r\n" + 
        		"					line-height:25px !important;\r\n" + 
        		"					padding:20px 0 0 !important;\r\n" + 
        		"				}\r\n" + 
        		"				tr[class=\"table-holder\"]{\r\n" + 
        		"					display:table !important;\r\n" + 
        		"					width:100% !important;\r\n" + 
        		"				}\r\n" + 
        		"				th[class=\"thead\"]{display:table-header-group !important; width:100% !important;}\r\n" + 
        		"				th[class=\"tfoot\"]{display:table-footer-group !important; width:100% !important;}\r\n" + 
        		"			}\r\n" + 
        		"		</style>\r\n" + 
        		"	</head>\r\n" + 
        		"	<body style=\"margin:0; padding:0;\" bgcolor=\"#eaeced\">\r\n" + 
        		"		<table style=\"min-width:320px;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#eaeced\">\r\n" + 
        		"			<!-- fix for gmail -->\r\n" + 
        		"			\r\n" + 
        		"					\r\n" + 
        		"					<!-- module 2 -->\r\n" + 
        		"					<table data-module=\"module-2\" data-thumb=\"thumbnails/02.png\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"						<tr>\r\n" + 
        		"							<td data-bgcolor=\"bg-module\" bgcolor=\"#eaeced\">\r\n" + 
        		"								<table class=\"flexible\" width=\"600\" align=\"center\" style=\"margin:0 auto;\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"						\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td data-bgcolor=\"bg-block\" class=\"holder\" style=\"padding:58px 60px 52px;\" bgcolor=\"#f9f9f9\">\r\n" + 
        		"											<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"												<tr>\r\n" + 
        		"													<td data-color=\"title\" data-size=\"size title\" data-min=\"25\" data-max=\"45\" data-link-color=\"link title color\" data-link-style=\"text-decoration:none; color:#292c34;\" class=\"title\" align=\"center\" style=\"font:35px/38px Arial, Helvetica, sans-serif; color:#292c34; padding:0 0 24px;\">\r\n" + 
        		"														TITLE_MAIL\r\n" + 
        		"													</td>\r\n" + 
        		"												</tr>\r\n" + 
        		"												<tr>\r\n" + 
        		"													<td data-color=\"text\" data-size=\"size text\" data-min=\"10\" data-max=\"26\" data-link-color=\"link text color\" data-link-style=\"font-weight:bold; text-decoration:underline; color:#40aceb;\" align=\"center\" style=\"font:bold 16px/25px Arial, Helvetica, sans-serif; color:#888; padding:0 0 23px;\">\r\n" + 
        		"													Tu orden con numero NUM_ORDER ha sido STATUS_ORDER\r\n" + 
        		"													</td>\r\n" + 
        		"												</tr>\r\n" + 
        		"												<tr>\r\n" + 
        		"													<td style=\"padding:0 0 20px;\">\r\n" + 
        		"														<table width=\"134\" align=\"center\" style=\"margin:0 auto;\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"															<tr>\r\n" + 
        		"																<td data-bgcolor=\"bg-button\" data-size=\"size button\" data-min=\"10\" data-max=\"16\" class=\"btn\" align=\"center\" style=\"font:12px/14px Arial, Helvetica, sans-serif; color:#f8f9fb; text-transform:uppercase; mso-padding-alt:12px 10px 10px; border-radius:2px;\" bgcolor=\"#7bb84f\">\r\n" + 
        		"																	<a target=\"_blank\" style=\"text-decoration:none; color:#f8f9fb; display:block; padding:12px 10px 10px;\" href=\"H_REF\">Verificar</a>\r\n" + 
        		"																</td>\r\n" + 
        		"															</tr>\r\n" + 
        		"														</table>\r\n" + 
        		"													</td>\r\n" + 
        		"												</tr>\r\n" + 
        		"											</table>\r\n" + 
        		"										</td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr><td height=\"28\"></td></tr>\r\n" + 
        		"								</table>\r\n" + 
        		"							</td>\r\n" + 
        		"						</tr>\r\n" + 
        		"					</table>\r\n" + 
        		"				\r\n" + 
        		"					\r\n" + 
        		"					\r\n" + 
        		"					<!-- module 7 -->\r\n" + 
        		"					<table data-module=\"module-7\" data-thumb=\"thumbnails/07.png\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"						<tr>\r\n" + 
        		"							<td data-bgcolor=\"bg-module\" bgcolor=\"#eaeced\">\r\n" + 
        		"								<table class=\"flexible\" width=\"600\" align=\"center\" style=\"margin:0 auto;\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td class=\"footer\" style=\"padding:0 0 10px;\">\r\n" + 
        		"											<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"												<tr class=\"table-holder\">\r\n" + 
        		"													<th class=\"tfoot\" width=\"400\" align=\"left\" style=\"vertical-align:top; padding:0;\">\r\n" + 
        		"														<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"															<tr>\r\n" + 
        		"																<td data-color=\"text\" data-link-color=\"link text color\" data-link-style=\"text-decoration:underline; color:#797c82;\" class=\"aligncenter\" style=\"font:12px/16px Arial, Helvetica, sans-serif; color:#797c82; padding:0 0 10px;\">\r\n" + 
        		"																	NISE, 2018. &nbsp; Todos los derechos reservados.\r\n" + 
        		"																</td>\r\n" + 
        		"															</tr>\r\n" + 
        		"														</table>\r\n" + 
        		"													</th>\r\n" + 
        		"												</tr>\r\n" + 
        		"											</table>\r\n" + 
        		"										</td>\r\n" + 
        		"									</tr>\r\n" + 
        		"								</table>\r\n" + 
        		"							</td>\r\n" + 
        		"						</tr>\r\n" + 
        		"					</table>\r\n" + 
        		"				</td>\r\n" + 
        		"			</tr>\r\n" + 
        		"		</table>\r\n" + 
        		"";
 
        String Res= body.replaceAll("NUM_ORDER", orden);
        String Res2= Res.replaceAll("H_REF", ref);
        Res=Res2.replaceAll("TITLE_MAIL", titulo);
        return Res.replaceAll("STATUS_ORDER", status);
    }
    
    
   
   public static void enviarGMail(String destinatario,String  status, String orden, String ref, String titulo ) {
   
   String remitente = "noreply.nise";  //Para la dirección nomcuenta@gmail.com

    Properties props = System.getProperties();
    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
    props.put("mail.smtp.user", remitente);
    props.put("mail.smtp.clave", "nise123456");    //La clave de la cuenta
    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);
    try {
        message.setFrom(new InternetAddress(remitente));
       // message.addRecipient(Message.RecipientType.TO, destinatario);
        message.addRecipients(Message.RecipientType.TO, destinatario);//Se podrían añadir varios de la misma manera
        message.setSubject("Confirmacion de orden");
        message.setContent(makeBody(status,orden,ref,titulo),"text/html");
        Transport transport = session.getTransport("smtp");
        String clave="nise123456";
        transport.connect("smtp.gmail.com", remitente, clave);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();   //Si se produce un error
    }
}

   public static void enviarGMailRegistro(String destinatario, String body, String ref, String titulo) {
	   String remitente = "noreply.nise";  //Para la dirección nomcuenta@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "nise123456");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	    try {
	        message.setFrom(new InternetAddress(remitente));
	       // message.addRecipient(Message.RecipientType.TO, destinatario);
	        message.addRecipients(Message.RecipientType.TO, destinatario);//Se podrían añadir varios de la misma manera
	        message.setSubject("Confirmacion de orden");
	        message.setContent(makeBody2(body,ref,titulo),"text/html");
	        Transport transport = session.getTransport("smtp");
	        String clave="nise123456";
	        transport.connect("smtp.gmail.com", remitente, clave);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	
	
   }
	
   public static void main (String [ ] args) {

	   
enviarGMailRegistro( "nicolas.mendez.g56@gmail.com","bod con valor de \\$", "localhost", "titulo" );


}
	private static Object makeBody2(String bodyText, String ref, String titulo) {
		 
        String body2="\r\n" + 
        		"	<head>\r\n" + 
        		"		<title>Internal_email-29</title>\r\n" + 
        		"		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
        		"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n" + 
        		"		<style type=\"text/css\">\r\n" + 
        		"			* {\r\n" + 
        		"				-ms-text-size-adjust:100%;\r\n" + 
        		"				-webkit-text-size-adjust:none;\r\n" + 
        		"				-webkit-text-resize:100%;\r\n" + 
        		"				text-resize:100%;\r\n" + 
        		"			}\r\n" + 
        		"			a{\r\n" + 
        		"				outline:none;\r\n" + 
        		"				color:#40aceb;\r\n" + 
        		"				text-decoration:underline;\r\n" + 
        		"			}\r\n" + 
        		"			a:hover{text-decoration:none !important;}\r\n" + 
        		"			.nav a:hover{text-decoration:underline !important;}\r\n" + 
        		"			.title a:hover{text-decoration:underline !important;}\r\n" + 
        		"			.title-2 a:hover{text-decoration:underline !important;}\r\n" + 
        		"			.btn:hover{opacity:0.8;}\r\n" + 
        		"			.btn a:hover{text-decoration:none !important;}\r\n" + 
        		"			.btn{\r\n" + 
        		"				-webkit-transition:all 0.3s ease;\r\n" + 
        		"				-moz-transition:all 0.3s ease;\r\n" + 
        		"				-ms-transition:all 0.3s ease;\r\n" + 
        		"				transition:all 0.3s ease;\r\n" + 
        		"			}\r\n" + 
        		"			table td {border-collapse: collapse !important;}\r\n" + 
        		"			.ExternalClass, .ExternalClass a, .ExternalClass span, .ExternalClass b, .ExternalClass br, .ExternalClass p, .ExternalClass div{line-height:inherit;}\r\n" + 
        		"			@media only screen and (max-width:500px) {\r\n" + 
        		"				table[class=\"flexible\"]{width:100% !important;}\r\n" + 
        		"				table[class=\"center\"]{\r\n" + 
        		"					float:none !important;\r\n" + 
        		"					margin:0 auto !important;\r\n" + 
        		"				}\r\n" + 
        		"				*[class=\"hide\"]{\r\n" + 
        		"					display:none !important;\r\n" + 
        		"					width:0 !important;\r\n" + 
        		"					height:0 !important;\r\n" + 
        		"					padding:0 !important;\r\n" + 
        		"					font-size:0 !important;\r\n" + 
        		"					line-height:0 !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"img-flex\"] img{\r\n" + 
        		"					width:100% !important;\r\n" + 
        		"					height:auto !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"aligncenter\"]{text-align:center !important;}\r\n" + 
        		"				th[class=\"flex\"]{\r\n" + 
        		"					display:block !important;\r\n" + 
        		"					width:100% !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"wrapper\"]{padding:0 !important;}\r\n" + 
        		"				td[class=\"holder\"]{padding:30px 15px 20px !important;}\r\n" + 
        		"				td[class=\"nav\"]{\r\n" + 
        		"					padding:20px 0 0 !important;\r\n" + 
        		"					text-align:center !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"h-auto\"]{height:auto !important;}\r\n" + 
        		"				td[class=\"description\"]{padding:30px 20px !important;}\r\n" + 
        		"				td[class=\"i-120\"] img{\r\n" + 
        		"					width:120px !important;\r\n" + 
        		"					height:auto !important;\r\n" + 
        		"				}\r\n" + 
        		"				td[class=\"footer\"]{padding:5px 20px 20px !important;}\r\n" + 
        		"				td[class=\"footer\"] td[class=\"aligncenter\"]{\r\n" + 
        		"					line-height:25px !important;\r\n" + 
        		"					padding:20px 0 0 !important;\r\n" + 
        		"				}\r\n" + 
        		"				tr[class=\"table-holder\"]{\r\n" + 
        		"					display:table !important;\r\n" + 
        		"					width:100% !important;\r\n" + 
        		"				}\r\n" + 
        		"				th[class=\"thead\"]{display:table-header-group !important; width:100% !important;}\r\n" + 
        		"				th[class=\"tfoot\"]{display:table-footer-group !important; width:100% !important;}\r\n" + 
        		"			}\r\n" + 
        		"		</style>\r\n" + 
        		"	</head>\r\n" + 
        		"	<body style=\"margin:0; padding:0;\" bgcolor=\"#eaeced\">\r\n" + 
        		"		<table style=\"min-width:320px;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#eaeced\">\r\n" + 
        		"			<!-- fix for gmail -->\r\n" + 
        		"			\r\n" + 
        		"					\r\n" + 
        		"					<!-- module 2 -->\r\n" + 
        		"					<table data-module=\"module-2\" data-thumb=\"thumbnails/02.png\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"						<tr>\r\n" + 
        		"							<td data-bgcolor=\"bg-module\" bgcolor=\"#eaeced\">\r\n" + 
        		"								<table class=\"flexible\" width=\"600\" align=\"center\" style=\"margin:0 auto;\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"						\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td data-bgcolor=\"bg-block\" class=\"holder\" style=\"padding:58px 60px 52px;\" bgcolor=\"#f9f9f9\">\r\n" + 
        		"											<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"												<tr>\r\n" + 
        		"													<td data-color=\"title\" data-size=\"size title\" data-min=\"25\" data-max=\"45\" data-link-color=\"link title color\" data-link-style=\"text-decoration:none; color:#292c34;\" class=\"title\" align=\"center\" style=\"font:35px/38px Arial, Helvetica, sans-serif; color:#292c34; padding:0 0 24px;\">\r\n" + 
        		"														TITLE_MAIL\r\n" + 
        		"													</td>\r\n" + 
        		"												</tr>\r\n" + 
        		"												<tr>\r\n" + 
        		"													<td data-color=\"text\" data-size=\"size text\" data-min=\"10\" data-max=\"26\" data-link-color=\"link text color\" data-link-style=\"font-weight:bold; text-decoration:underline; color:#40aceb;\" align=\"center\" style=\"font:bold 16px/25px Arial, Helvetica, sans-serif; color:#888; padding:0 0 23px;\">\r\n" + 
        		"													 STATUS_ORDER\r\n" + 
        		"													</td>\r\n" + 
        		"												</tr>\r\n" + 
        		"												<tr>\r\n" + 
        		"													<td style=\"padding:0 0 20px;\">\r\n" + 
        		"														<table width=\"134\" align=\"center\" style=\"margin:0 auto;\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"															<tr>\r\n" + 
        		"																<td data-bgcolor=\"bg-button\" data-size=\"size button\" data-min=\"10\" data-max=\"16\" class=\"btn\" align=\"center\" style=\"font:12px/14px Arial, Helvetica, sans-serif; color:#f8f9fb; text-transform:uppercase; mso-padding-alt:12px 10px 10px; border-radius:2px;\" bgcolor=\"#7bb84f\">\r\n" + 
        		"																	<a target=\"_blank\" style=\"text-decoration:none; color:#f8f9fb; display:block; padding:12px 10px 10px;\" href=\"H_REF\">Verificar</a>\r\n" + 
        		"																</td>\r\n" + 
        		"															</tr>\r\n" + 
        		"														</table>\r\n" + 
        		"													</td>\r\n" + 
        		"												</tr>\r\n" + 
        		"											</table>\r\n" + 
        		"										</td>\r\n" + 
        		"									</tr>\r\n" + 
        		"									<tr><td height=\"28\"></td></tr>\r\n" + 
        		"								</table>\r\n" + 
        		"							</td>\r\n" + 
        		"						</tr>\r\n" + 
        		"					</table>\r\n" + 
        		"				\r\n" + 
        		"					\r\n" + 
        		"					\r\n" + 
        		"					<!-- module 7 -->\r\n" + 
        		"					<table data-module=\"module-7\" data-thumb=\"thumbnails/07.png\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"						<tr>\r\n" + 
        		"							<td data-bgcolor=\"bg-module\" bgcolor=\"#eaeced\">\r\n" + 
        		"								<table class=\"flexible\" width=\"600\" align=\"center\" style=\"margin:0 auto;\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"									<tr>\r\n" + 
        		"										<td class=\"footer\" style=\"padding:0 0 10px;\">\r\n" + 
        		"											<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"												<tr class=\"table-holder\">\r\n" + 
        		"													<th class=\"tfoot\" width=\"400\" align=\"left\" style=\"vertical-align:top; padding:0;\">\r\n" + 
        		"														<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
        		"															<tr>\r\n" + 
        		"																<td data-color=\"text\" data-link-color=\"link text color\" data-link-style=\"text-decoration:underline; color:#797c82;\" class=\"aligncenter\" style=\"font:12px/16px Arial, Helvetica, sans-serif; color:#797c82; padding:0 0 10px;\">\r\n" + 
        		"																	NISE, 2018. &nbsp; Todos los derechos reservados.\r\n" + 
        		"																</td>\r\n" + 
        		"															</tr>\r\n" + 
        		"														</table>\r\n" + 
        		"													</th>\r\n" + 
        		"												</tr>\r\n" + 
        		"											</table>\r\n" + 
        		"										</td>\r\n" + 
        		"									</tr>\r\n" + 
        		"								</table>\r\n" + 
        		"							</td>\r\n" + 
        		"						</tr>\r\n" + 
        		"					</table>\r\n" + 
        		"				</td>\r\n" + 
        		"			</tr>\r\n" + 
        		"		</table>\r\n" + 
        		"";
 
        String Res2= body2.replaceAll("TITLE_MAIL", titulo);
        String Res22= Res2.replaceAll("H_REF", ref);
    
        return Res2.replaceFirst("STATUS_ORDER", bodyText);
 		
	
	}
}
