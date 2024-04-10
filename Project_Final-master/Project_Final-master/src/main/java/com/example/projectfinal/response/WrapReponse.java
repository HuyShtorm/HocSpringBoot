package com.example.projectfinal.response;

import com.example.projectfinal.constant.WrapResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WrapReponse<T> {
    private String statusCode;
    private T data;
    private String message;
    public static <T> WrapReponse<T> ok(T data){

    WrapReponse<T> response = new WrapReponse<>();
    response.setData(data);
    response.setStatusCode(WrapResponseStatus.SUCCESS);
    return  response;}
    public static <T> WrapReponse<T> error(String message){

        WrapReponse<T> response = new WrapReponse<>();
        response.setData(null);
        response.setStatusCode(WrapResponseStatus.INTERNAL_SERVER_ERROR);
        response.setMessage(message);
        return  response;}
    public static <T> WrapReponse<T> error(String statusCode,String message){

        WrapReponse<T> response = new WrapReponse<>();
        response.setData(null);
        response.setStatusCode(statusCode);
        response.setMessage(message);
        return  response;}


}
