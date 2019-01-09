package com.daoshan.service.AliSms;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSend {

    /**
     * 发送邮件
     * @param user 给谁发
     * @param code 验证码
     */
    public static void send_mail(String user,String code) throws MessagingException {
        //创建连接对象 连接到邮件服务器
        Properties properties = new Properties();
        //设置发送邮件的基本参数
        //发送邮件服务器
        properties.put("mail.smtp.host", "smtp.163.com");
        //发送端口
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");

        properties.put("mail.smtp.starttls.enable", "true");
        //设置发送邮件的账号和密码
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //两个参数分别是发送邮件的账户和密码
                return new PasswordAuthentication("zhutonglmh@163.com","sunzhi960607");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress("zhutonglmh@163.com"));
        //设置收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(user));
        //设置主题
        message.setSubject("道山学海-张崇宝");
        //设置邮件正文  第二个参数是邮件发送的类型
        message.setContent("注册验证\n" +
                "您好\" "+ user +"\"！\n" +
                "\n" +
                "欢迎注册道山学海，请将验证码填写到注册页面。\n" +
                "\n" +
                "验证码："+ code +"","text/html;charset=UTF-8");
        //发送一封邮件
        Transport.send(message);
    }


}
