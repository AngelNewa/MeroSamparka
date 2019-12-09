package com.app.merosamparka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etPassword;
    Button btnLogin, btnSignup, btnForgot;

    RelativeLayout relay1, relay2;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relay1.setVisibility(View.VISIBLE);
            relay2.setVisibility(View.VISIBLE);
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        btnForgot = findViewById(R.id.btnForgot);



        btnLogin.setOnClickListener(this);


        relay1 = findViewById(R.id.relay1);
        relay2 = findViewById(R.id.relay2);

//Setting timeout for the splash
        handler.postDelayed(runnable, 2000);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                if (etName.getText().toString().equals("admin")&& etPassword.getText().toString().equals("admin")){
                    startActivity(new Intent(this, Dashboard.class));
                }
                else if (TextUtils.isEmpty(etName.getText())){
                    etName.setError("Please enter your Name");
                    return;
                }

                else if (TextUtils.isEmpty(etPassword.getText())){
                    etPassword.setError("Please enter your Password");
                    return;
                }
                else{
                    Toast.makeText(this, "Invalid Name or Password", Toast.LENGTH_LONG).show();
                    return;
                }
                break;

            case R.id.btnSignup:
                startActivity(new Intent(this, SignupActivity.class));
                break;
        }


    }
}