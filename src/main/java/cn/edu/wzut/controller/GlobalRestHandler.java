package cn.edu.wzut.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalRestHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<String> exception(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return new JsonResult<>(-1, "系统错误");
    }

    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<String> myException(MyException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return new JsonResult<>(-1, e.getMessage());
    }
}
