package com.lne.fmmall.exception;

import com.lne.fmmall.vo.CMSException;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * FileName: GlobalExceptionHandler
 * Author:   fengsulin
 * Date:     2022/5/10 10:00
 * Description: 统一异常处理器
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

//    /**
//     *自定义异常处理方法，当抛出该异常时自动调用该异常处理方法
//     * @param: [e]
//     * @return: com.lne.fmmall.vo.ResultVo
//     */
//    @ExceptionHandler(value = CMSException.class)
//    @ResponseBody
//    public ResultVo myExceptionHandler(CMSException e){
//        log.error(e.getMessage());
//        e.printStackTrace();
//        return ResultVo.error(e);
//    }
//
//    /**处理其他异常*/
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public ResultVo exceptionHandler(Exception e){
//        log.error(e.getMessage());
//        return ResultVo.otherError(ResultEnum.INTERNAL_SERVER_ERROR);
//    }
}
