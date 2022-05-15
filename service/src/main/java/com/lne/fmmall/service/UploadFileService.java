package com.lne.fmmall.service;

import com.lne.fmmall.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileName: UpLoadFile
 * Author:   fengsulin
 * Date:     2022/5/12 15:44
 * Description: 上传文件接口
 */
public interface UploadFileService {
    public ResultVo upLoadFile(MultipartFile multipartFile);
}
