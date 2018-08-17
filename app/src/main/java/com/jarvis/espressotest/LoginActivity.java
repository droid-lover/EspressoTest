package com.jarvis.espressotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {


    EditText etEmailId, etPassword;
    Button loginButton;

    String emailValue, passwordValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
    }

    private void findViews() {
        etEmailId = findViewById(R.id.et_email_id);
        etPassword = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailValue = etEmailId.getText().toString();
                passwordValue = etPassword.getText().toString();

                if (TextUtils.isEmpty(emailValue)) {
                    etEmailId.setError("Enter a Valid email id");
                    return;
                } else if (TextUtils.isEmpty(passwordValue)) {
                    etEmailId.setError("Enter your password");
                    return;
                } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
