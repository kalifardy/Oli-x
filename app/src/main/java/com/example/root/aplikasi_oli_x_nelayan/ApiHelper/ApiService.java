package com.example.root.aplikasi_oli_x_nelayan.ApiHelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by root on 3/27/18.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody>loginRequest(@Field("id_nelayan")String id_nelayan,
                                   @Field("password")String password);

    @FormUrlEncoded
    @POST("registeer.php")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                       @Field("id_nelayan") String id_nelayan,
                                       @Field("password") String password,
                                       @Field("email") String email,
                                       @Field("tanggal_lahir") String tanggal_lahir,
                                       @Field("tempat_lahir") String tempat_lahir,
                                       @Field("jk") String jk,
                                       @Field("no_hp") String no_hp);


}
