package com.lne.fmmall.controller;

import com.lne.fmmall.service.UploadFileService;
import com.lne.fmmall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * FileName: UploadFuleController
 * Author:   fengsulin
 * Date:     2022/5/12 16:06
 * Description: 文件上传控制类
 */
@RestController
@RequestMapping("/file")
@Api(value = "",tags = "文件上传管理")
public class UploadFileController {
    @Resource
    UploadFileService uploadFileService;

    @ApiOperation("文件上传接口")
    @PostMapping("/upload")
    public ResultVo uploadFile(@RequestParam(name = "multipartFile") MultipartFile multipartFile){
        return uploadFileService.upLoadFile(multipartFile);
    }
}
