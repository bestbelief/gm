package com.mst.front.tempentity;

import com.mst.front.constant.StatuCodeEnum;

/**
 * 数据结果集Bean常用类
 * @author Mr.Anderson
 * @param <T>
 */
public class Result<T> {
    /**
     * 状态码
     */
    private int retCode;

    /**
     * 状态
     */
    private String status;

    /**
     * 提示信息
     */
    private String msg;
    /**
     * 结果集
     */
    private T results;
    /**
     *  默认是成功的结果---这里的枚举仅仅用了进行设置不做任何作用
     */
    public Result() {
        this.retCode = StatuCodeEnum.RETCODE_200.getRetCode();
        this.status = StatuCodeEnum.RETCODE_200.getStatus();
        this.msg = StatuCodeEnum.RETCODE_200.getMsg();
    }
    /**
     * 返回的状态的结果集合
     * @param codeConstant 状态常量
     * @param msg 提示消息
     * @param results 结果集
     */
    public Result(StatuCodeEnum codeConstant,String msg,T results) {
        this.retCode = codeConstant.getRetCode();
        this.status = codeConstant.getStatus();
        if (msg!=null) {
            this.msg = msg;
        }else {
            this.msg=codeConstant.getMsg();
        }
        this.results = results;
    }
    public int getRetCode() {
        return retCode;
    }
    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getResults() {
        return results;
    }
    public void setResults(T results) {
        this.results = results;
    }
}
