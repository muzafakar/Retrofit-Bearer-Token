package com.muzadev.bearertoken.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.muzadev.bearertoken.model.LoginResponse;
import com.muzadev.bearertoken.util.PrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthProvider {
    private Context context;

    public AuthProvider(Context context) {
        this.context = context;
    }

    AuthService authService = new RetrofitClient().create(context).create(AuthService.class);

    public void login(String username, String password) {
        authService.login(username, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {

                    PrefManager prefManager = new PrefManager(context);
                    String token = response.body().getData().getAccessToken();

                    prefManager.saveToken(token);
                    Toast.makeText(context, "access_token: " + token, Toast.LENGTH_SHORT).show();
                    Log.i("TEST GAN", "onResponse: " + token);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
