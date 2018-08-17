package com.jarvis.espressotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    Button registerButton;

    String nameValue, emailValue, passwordValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
    }

    private void findViews() {
        etName = findViewById(R.id.et_name_in_reg);
        etEmail = findViewById(R.id.et_email_in_reg);
        etPassword = findViewById(R.id.et_password_in_reg);
        registerButton = findViewById(R.id.button_sign_up);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameValue = etName.getText().toString();
                emailValue = etEmail.getText().toString();
                passwordValue = etPassword.getText().toString();

                if (TextUtils.isEmpty(nameValue)) {
                    etName.setError("Please enter your Name");
                    return;
                } else if (TextUtils.isEmpty(emailValue)) {
                    etName.setError("Please enter your Email");
                    return;
                } else if (TextUtils.isEmpty(passwordValue)) {
                    etName.setError("Please enter your Password");
                    return;
                } else {
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
