package com.muzadev.bearertoken;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.bearertoken.network.AuthProvider;
import com.muzadev.bearertoken.util.PrefManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrefManager prefManager = new PrefManager(this);
        String token = prefManager.getToken();
        Toast.makeText(this, "token yang tesimpan: " + token, Toast.LENGTH_SHORT).show();


        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        AuthProvider authProvider = new AuthProvider(this);
        authProvider.login(username, password);
    }

    private void convertStringToDate() {
        String dateString = "2019-09-27 22:15:42";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd", Locale.getDefault());

        try {
            Date tanggalDariServer = sdf.parse(dateString);
            Date dateNow = new Date();

            if(tanggalDariServer.equals(dateNow)){
                Toast.makeText(this, "tanggalnya sama", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "tanggalnya berbeda", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {

        }

    }


}
