package com.muzadev.bearertoken.network;

import com.muzadev.bearertoken.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AuthService {
    @FormUrlEncoded
    @POST("authenticate")
    Call<LoginResponse> login(
            @Field("login") String login,
            @Field("password") String password
    );

    @GET("exam_schedule")
    Call<LoginResponse> getExamData(@Header("Authorization") String token);
}
