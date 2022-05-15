package com.lne.fmmall.controller;

import com.lne.fmmall.utils.MailSendUtils;
import com.lne.fmmall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * FileName: MailSendController
 * Author:   fengsulin
 * Date:     2022/5/12 9:13
 * Description: 邮件控制器发送类
 */
@RestController
@RequestMapping("/mail")
@Api(value = "",tags = "邮件发送管理")
public class MailSendController {
    @Resource
    private MailSendUtils mailSendUtils;

    @GetMapping("/sends")
    @ApiOperation("简单邮件发送接口")
    public ResultVo sendSimpleMail(){
        return mailSendUtils.sendSimpleMails();
    }

    @GetMapping("/send")
    @ApiOperation("复杂邮件发送接口")
    public ResultVo sendFixMail() throws MessagingException {
        return mailSendUtils.sendFixMail();
    }

}
