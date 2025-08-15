package com.wesleyaldrich.animedxd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    public static String GLOBAL_USERNAME = "";

    private EditText edtUsername, edtPassword;
    private TextView txtUsernameError, txtPasswordError;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        txtUsernameError = findViewById(R.id.txtUsernameError);
        txtPasswordError = findViewById(R.id.txtPasswordError);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hapus baris ini:
                // btnLogin.setBackgroundColor(Color.parseColor("#163C99"));

                txtUsernameError.setVisibility(View.GONE);
                txtPasswordError.setVisibility(View.GONE);

                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                boolean isValid = true;

                if (username.isEmpty()) {
                    txtUsernameError.setText("Username should not be empty!");
                    txtUsernameError.setVisibility(View.VISIBLE);
                    isValid = false;
                } else if (username.length() < 5 || username.length() > 10) {
                    txtUsernameError.setText("Username must be 5-10 characters long!");
                    txtUsernameError.setVisibility(View.VISIBLE);
                    isValid = false;
                }

                if (password.isEmpty()) {
                    txtPasswordError.setText("Password should not be empty!");
                    txtPasswordError.setVisibility(View.VISIBLE);
                    isValid = false;
                }

                if (isValid) {
                    GLOBAL_USERNAME = username;
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("EXTRA_USERNAME", username);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}