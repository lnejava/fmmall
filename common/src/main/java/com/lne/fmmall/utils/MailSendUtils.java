package com.lne.fmmall.utils;

import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * FileName: MailSendUtils
 * Author:   fengsulin
 * Date:     2022/5/12 8:54
 * Description: 邮件发送通用类
 */
@Slf4j
@Component
public class MailSendUtils {
    @Resource
    JavaMailSenderImpl javaMailSender;

    /**简单的邮件构建发送*/
    public ResultVo sendSimpleMails(){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("测试SpringBoot发送邮件");
            simpleMailMessage.setText("这是SpringBoot发送的测试简单邮件！");
            simpleMailMessage.setTo("1811443663@qq.com");
            simpleMailMessage.setFrom("fengsu_lin@163.com");
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(),
                ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null);
    }

    /**复杂的构建和发送*/
    public ResultVo sendFixMail() throws MessagingException {
        // 调用创造复杂邮件方法
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try{
            helper.setTo("1811443663@qq.com");
            helper.setFrom("fengsu_lin@163.com");
            helper.setSubject("测试SpringBoot发送邮件");
            helper.setText("这是SpringBoot发送的测试复杂邮件");
            helper.setSentDate(new Date());

            //添加附件
            helper.addAttachment("spring-test.docx",new File("D://SpringBoot-mail.docx"));

            // 发送邮件
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(),
                ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null);
    }
}
