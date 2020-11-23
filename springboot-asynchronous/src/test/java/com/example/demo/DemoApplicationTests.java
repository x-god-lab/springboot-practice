package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的协议
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("3482563675@qq.com");
        mailMessage.setSubject("测试");
        mailMessage.setText("谢谢你的测试");
        mailMessage.setTo("1763495066@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的协议
        MimeMessage mimeMessage=mailSender.createMimeMessage();

        //组装
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        //正文
        helper.setSubject("第二次测试");
        helper.setText("<p style='color:red'>测试</p>",true);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\\\Administrator\\Desktop\\2.jpg"));
        helper.addAttachment("3.jpg",new File("C:\\Users\\Administrator\\Desktop\\3.jpg"));

        helper.setFrom("3482563675@qq.com");
        helper.setTo("1763495066@qq.com");

        mailSender.send(mimeMessage);
    }

    /**
     *
     * @param html:
     * @throws MessagingException
     * @Author xin
     */
    public void sendMail(Boolean html,String subject,String text) throws MessagingException {
        //一个复杂的协议
        MimeMessage mimeMessage=mailSender.createMimeMessage();

        //组装
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,html);
        //正文
        helper.setSubject(subject);
        helper.setText(text,true);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\\\Administrator\\Desktop\\2.jpg"));
        helper.addAttachment("3.jpg",new File("C:\\Users\\Administrator\\Desktop\\3.jpg"));

        helper.setFrom("3482563675@qq.com");
        helper.setTo("1763495066@qq.com");

        mailSender.send(mimeMessage);
    }

}
