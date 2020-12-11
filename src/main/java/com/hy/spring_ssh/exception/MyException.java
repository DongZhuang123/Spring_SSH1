package com.hy.spring_ssh.exception;

public class MyException extends Exception {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MyException(){
        this.msg=msg;
    }
    public MyException(String msg){
        super(msg);
        this.msg=msg;
    }

}
