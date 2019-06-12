package com.hongy.validation.common;

import lombok.*;

/**
 * @Author lihongy
 * @Created by on 2019/06/11 17:50.
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDTO<T> {
    private String resCode;

    private String resMsg;

    private String attachInfo;

    private T result;
}