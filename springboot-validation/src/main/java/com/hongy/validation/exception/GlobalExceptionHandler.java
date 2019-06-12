package com.hongy.validation.exception;

/**
 * @Author lihongy
 * @Created by on 2019/06/11 17:44.
 * @Description:
 */

import com.hongy.validation.common.ResultDTO;
import com.hongy.validation.constant.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.function.Function;

@RestControllerAdvice // 增强型控制器，默认会处理controller层抛出的异常
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultDTO<Object> handleAllException(Exception e) {
        return ResultDTO.builder()
                .resCode(Constants.FAILURE_CODE)
                .resMsg(Constants.SYSTEM_EXCEPTION_MESSAGE)
                .build();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultDTO<Object> handlerMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResultDTO.builder()
                .resCode(Constants.FAILURE_CODE)
                .resMsg(e.getMessage())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResultDTO<Object> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        return ResultDTO.builder()
                .resCode(Constants.FAILURE_CODE)
                .resMsg(e.getMessage())
                .build();
    }

    // 方法参数model字段校验    如：@RequestBody @Validated OrderDTO orderDTO，orderDTO对象参数校验不通过的异常。请求参数形式必须是json形式
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultDTO<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return getMessage(e.getBindingResult().getAllErrors(), o -> ((ObjectError)o).getDefaultMessage());
    }


    // TODO 参数对象校验不通过，进不的是这个方法，什么条件下进这个方法还不知 ... 20190612
    @ExceptionHandler(value = BindException.class)
    public ResultDTO<Object> handlerBindException(BindException e) {
        return ResultDTO.builder()
                .resCode(Constants.FAILURE_CODE)
                .resMsg(Constants.SYSTEM_EXCEPTION_MESSAGE)
                .build();
    }

    private static <T extends Collection,U>  ResultDTO<Object> getMessage(T t, Function<U,String> function){
        if (t.size() == 1) {
            return ResultDTO.builder().resMsg(function.apply((U)t.iterator().next()))
                    .resCode(Constants.FAILURE_CODE).build();
        } else {
            return ResultDTO.builder().resMsg("参数异常：" +
                    t.stream()
                            .map(m -> "[" + function.apply((U)m) + "]")
                            .reduce((x, y) -> x + "," + y)
                            .orElse(StringUtils.EMPTY)
            ).resCode(Constants.FAILURE_CODE).build();
        }
    }
}