package priv.dhx.bookstore.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice
{
    @ExceptionHandler(Exception.class)
    public R doException(Exception e)
    {
        e.printStackTrace();
        return new R("服务器异常，请稍后再试！");
    }
}