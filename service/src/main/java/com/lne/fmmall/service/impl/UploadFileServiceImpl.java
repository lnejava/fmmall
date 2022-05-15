package com.lne.fmmall.service.impl;

import com.lne.fmmall.service.UploadFileService;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * FileName: UpLoadFileServiceImpl
 * Author:   fengsulin
 * Date:     2022/5/12 15:51
 * Description: 上传文件dao接口实现类
 */
@Service
@Slf4j
public class UploadFileServiceImpl implements UploadFileService {
    @Override
    public ResultVo upLoadFile(MultipartFile multipartFile) {
        // 定义文件保存路径
        String filePath = "C://fileLoad";
        // 文件名
        String fileName = String.valueOf(System.currentTimeMillis());
        String originalFilename = multipartFile.getOriginalFilename();
        String[] split = originalFilename.split("\\.");
        String s = split[split.length - 1];
        File file = new File(filePath + File.separator + fileName +"."+ s);
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            IOUtils.copy(multipartFile.getInputStream(),bufferedOutputStream);
            log.info("file upload success");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(),
                ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null);
    }
}
