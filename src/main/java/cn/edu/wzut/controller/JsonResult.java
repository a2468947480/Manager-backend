package cn.edu.wzut.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResult<T> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    private int code;
    private String msg;

    public JsonResult() {
        this.code = 0;
        this.msg = "操作成功";
    }

    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(T data) {
        this.data = data;
        this.code = 0;
        this.msg = "操作成功";
    }

    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = 0;
        this.msg = msg;
    }
}
