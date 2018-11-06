package com.myself.code.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 19:53 2018\11\6 0006
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -4360602556584187169L;

    private Integer code;

    private String msg;

    private T data;
}
