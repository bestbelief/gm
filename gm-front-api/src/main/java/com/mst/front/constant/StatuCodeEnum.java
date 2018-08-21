package com.mst.front.constant;

public enum StatuCodeEnum {
    RETCODE_200(200, "RETCODE_200", "响应成功"),
    RETCODE_500(500, "RETCODE_500", "内部错误"),
    RETCODE_404(404, "404","找不到请求的资源"),
    RETCODE_400( 400,"400","请求参数，或者语法存在问题"),
    RETCODE_530(530, "RETCODE_530", "用户没有登录");
    /**
     * 状态码
     */
    private int retCode;

    /**
     * 状态
     */
    private String status; // success,error

    /**
     * 提示信息
     */
    private String msg;

    // 构造方法
    private StatuCodeEnum(int retCode, String status, String msg) {
        this.retCode = retCode;
        this.status = status;
        this.msg = msg;
    }

    // 覆盖方法 ---返回提示信息
    @Override
    public String toString() {
        return this.msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getRetCode() {
        return retCode;
    }

    public String getStatus() {
        return status;
    }
}
