package com.unicorn.um.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {

    private R(){}

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    // 成功的静态方法
    public static R ok(){
        R r = new R();
        r.setCode(ResultCode.SUCCESS);
        r.setSuccess(true);
        r.setMessage("成功");
        return r;
    }

    // 失败的静态方法
    public static R error(){
        R r = new R();
        r.setCode(ResultCode.ERROR);
        r.setSuccess(false);
        r.setMessage("失败");
        return r;
    }

    public R message(String msg)
    {
        this.setMessage(msg);
        return this;
    }

    public R code(Integer code)
    {
        this.setCode(code);
        return this;
    }

    public R success(Boolean isOk)
    {
        this.setSuccess(isOk);
        return this;
    }

    public R data(String key, Object val)
    {
        this.data.put(key,val);
        return this;
    }

    public R data(Map<String, Object> map)
    {
        this.setData(map);
        return this;
    }
}
