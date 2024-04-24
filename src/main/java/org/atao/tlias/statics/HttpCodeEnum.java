package org.atao.tlias.statics;

public enum HttpCodeEnum {
    SUCCEED(200, "操作成功"),
    NOT_FOUND(404, "资源未找到"),
    INTERNAL_SERVER_ERROR(500, "内部服务器错误");


    public final int code;
    public final String msg;

    HttpCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
