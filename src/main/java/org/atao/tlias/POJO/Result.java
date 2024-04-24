package org.atao.tlias.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.atao.tlias.statics.HttpCodeEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;

    private String msg;

    private Object data;
    public static Result ret(HttpCodeEnum httpCodeEnum, Object data) {
        return new Result(httpCodeEnum.code, httpCodeEnum.msg, data);
    }

    public static Result ret(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }
}
