package cn.example.code.entity;

import java.util.HashMap;

/**
 * 返回通用数据类型
 */
public class Result extends HashMap<String, Object> {
    public Result(){
        put("code",200);
    }

    public static Result error(){
        return error(500,"发生错误信息");
    }

    public static Result error(String msg){
        return error(500,msg);
    }

    public static Result error(int code, String msg){
        Result result = new Result();
        result.put("error", msg);
        result.put("code",code);
        return result;
    }

    public static Result ok(){
        return new Result();
    }

    public static Result ok(HashMap<String,Object> map){
        Result result=new Result();
        result.putAll(map);
        return result;
    }

    public static Result ok(String msg){
        Result result = new Result();
        result.put("msg",msg);
        return result;
    }

    public static Result ok(Object object){
        Result result = new Result();
        result.put("code", 200);
        result.put("msg","ok");
        result.put("data", object);
        return result;
    }

    @Override
    public Result put(String key,Object value){
        super.put(key,value);
        return this;
    }
}
