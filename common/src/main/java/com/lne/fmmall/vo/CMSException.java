package com.lne.fmmall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * FileName: CMSException
 * Author:   fengsulin
 * Date:     2022/5/10 9:54
 * Description: 自定义异常
 */
@Getter
@Setter
@ApiModel("自定义异常")
public class CMSException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    /**错误响应码*/
    @ApiModelProperty(dataType = "Integer",value = "错误响应码",example = "404")
    protected Integer errorCode;

    /**错误提示*/
    @ApiModelProperty(dataType = "String",value = "错误提示")
    protected String errorMsg;

    public CMSException(){}

    /**自定义构造方法*/
    public CMSException(Integer errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
