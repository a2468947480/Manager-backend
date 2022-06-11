package cn.edu.wzut.controller;

public class MyException extends Exception{
    public MyException(String msg) {
        super(msg);
    }

    public MyException() {
        super();
    }
}
