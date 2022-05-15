package com.lne.fmmall.vo.enums;

/**
 * FileName: ResultEnum
 * Author:   fengsulin
 * Date:     2022/4/21 23:50
 * Description: 响应信息枚举类
 */
public enum ResultEnum {
    SUCCESS(true,200,"成功"),
    UNKNOWN_ERROR(false,10001,"未知错误"),
    PARAM_ERROR(false,10002,"参数错误"),
    NULL_POINT(false,10003,"空指针异常"),
    NO_PERMISSION(false,403,"你无权限访问"),
    NO_AUTH(false,401,"未授权，请登录验证"),
    NO_FOUND(false,404,"未找到资源"),
    INTERNAL_SERVER_ERROR(false,500,"服务器异常，请联系管理员");
    /**请求结果*/
    private final Boolean success;
    /**响应码*/
    private final Integer code;

    /**响应信息*/
    private final String msg;

    private ResultEnum(Boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    public Boolean getSuccess(){return success;}

    @Override
    public String toString() {
        return "ResultEnum{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
