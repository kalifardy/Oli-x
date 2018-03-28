package com.example.root.aplikasi_oli_x_nelayan.ApiHelper;

/**
 * Created by root on 3/27/18.
 */

public class UtilsApi {
    public static  final  String Url="http://192.168.1.14/nelayan/";

    public static  ApiService getApiService(){
        return  RetrofitClient.getClient(Url).create(ApiService.class);
    }
}
