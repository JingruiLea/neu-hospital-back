package edu.neu.his.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessage {

    private int code;
    private String msg;
    private Map data;
    private Object object;
    public ResponseMessage(int code, String msg, Map data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseMessage(int code, String msg, Object object){
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public ResponseMessage(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Map getResponse(){
        Map res = new HashMap();
        res.put("code", code);
        res.put("msg", msg);
        if(this.data != null){
            res.put("data", data);
        }
        if(this.object != null) {
            res.put("data", objectToDataMap());
        }
        return res;
    }

    private Map objectToDataMap(){
        HashMap dataMap = new HashMap();
        dataMap.put("data", object);
        return dataMap;
    }
}
