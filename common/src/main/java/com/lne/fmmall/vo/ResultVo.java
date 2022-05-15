package com.lne.fmmall.vo;

import com.lne.fmmall.vo.enums.ResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: ResultVo
 * Author:   fengsulin
 * Date:     2022/4/21 23:39
 * Description: 封装响应类
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "响应对象")
public class ResultVo {
    /**请求结果*/
    @ApiModelProperty(dataType = "Boolean",value = "请求结果是否成功",name = "success")
    private Boolean success;

    /** 响应code码 */
    @ApiModelProperty(dataType = "Integer",value = "响应状态码",example = "200")
    private Integer code;
    /**响应提示信息*/
    @ApiModelProperty(value = "响应提示信息")
    private String msg;
    /**响应的数据*/
    @ApiModelProperty(value = "响应数据体")
    private Map<String,Object> data = new HashMap<>();

    public ResultVo(){}

    /**自定义返回结果的构造方法*/
    public ResultVo(Boolean success, Integer code,String msg,Map<String,Object> data){
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**自定义异常返回结果*/
    public static ResultVo error(CMSException e){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(false);
        resultVo.setCode(e.getErrorCode());
        resultVo.setMsg(e.getErrorMsg());
        return resultVo;
    }

    /**其他异常处理方法返回结果*/
    public static ResultVo otherError(ResultEnum resultEnum){
        ResultVo resultVo = new ResultVo();
        resultVo.setMsg(resultEnum.getMsg())
                .setCode(resultEnum.getCode())
                .setSuccess(false);
        return resultVo;
    }
}
