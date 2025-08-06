package com.example.exception;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler//捕获异常，通过形参指定要处理的异常类型，
    public Result ex(Exception e){//方法形参中指定能够处理的异常类型
        e.printStackTrace();//打印堆栈中的异常信息
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }

    @ExceptionHandler//捕获异常按先子异常后父异常
    public Result ex(DataIntegrityViolationException e){
        e.printStackTrace();
        return Result.error("对不起，您输出的内容过长");
    }

    // 添加对参数类型不匹配异常的处理
    @ExceptionHandler
    public Result ex(MethodArgumentTypeMismatchException e) {
        log.error("参数类型不匹配异常: ", e);
        return Result.error("请求参数格式不正确");
    }


}