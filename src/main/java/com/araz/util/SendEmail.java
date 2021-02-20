package com.araz.util;

import com.araz.entity.Order;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;



public class SendEmail {
        private String username;
        private String password;
        private Properties props;

        public SendEmail(String username, String password) {
            this.username = username;
            this.password = password;

            props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
        }

        public int send(Order order, String toEmail){
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                Message message = new MimeMessage(session);
                //от кого
                message.setFrom(new InternetAddress(username));
                //кому
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
                //тема сообщения
                String subject = "Azziz comp";
                message.setSubject(subject);
                //текст
                String text = "Hello," + order.getUserId() + "\n Your order with id: " + order.getId() + " has been confirmed. Please enter this code to pay for your order, and we will immediately begin to fulfill it.\n Regards, Araz\n" +
                        "Your code: " + order.hashCode();
                System.out.println("SEND EMAIL " + order.hashCode() + "ID:" + order.getId());

                message.setText(text);

                //отправляем сообщение
                Transport.send(message);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            return order.hashCode();
        }
    }