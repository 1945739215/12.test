package com.cidp.pojo.result;

public class Result {
    private int code;
    private String msg;
    private Object object;


    private static Result responseResult = new Result();

    private Result() {
    }



    public static Result getInstance(int code, String msg, Object object) {
        responseResult.code = code;
        responseResult.msg = msg;
        responseResult.object = object;


        return responseResult;
    }

    public static Result success() {
        return getInstance(200, "success",null);
    }

    public static Result error(String error) {
        return getInstance(400, error,null);
    }
    public static Result error1(String error) {
        return getInstance(0, error,null);
    }
    public static Result error2(String error) {
        return getInstance(1, error,null);
    }
    public static Result Success(Object data){responseResult.code=200;responseResult.msg="登录成功";responseResult.object=data;return responseResult;}
    public static Result Error(){responseResult.code=400;return responseResult;}

    public static Result SuccesswithObject(String msg, Object object) {
        return getInstance(200,msg,object);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
