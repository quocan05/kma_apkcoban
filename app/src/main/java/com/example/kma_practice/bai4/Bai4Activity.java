package com.example.kma_practice.bai4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kma_practice.R;

public class Bai4Activity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;

    ListUser listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4);
        listUser = new ListUser();
        initUI();
        createAction();
    }

    void createAction() {
        String username, password;
        username = edtUsername.getText().toString().trim();
        password = edtPassword.getText().toString().trim();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the username and password
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                // Debug logs
                Log.d("LoginDebug", "Username: " + username);
                Log.d("LoginDebug", "Password: " + password);

                boolean userFound = false;
                for (Account user : listUser.getListUSer()) {
                    if (user.getUsername().equals(username)) {
                        userFound = true;
                        if (user.getPassword().equals(password)) {
                            Toast.makeText(Bai4Activity.this, "success", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            Toast.makeText(Bai4Activity.this, "wrong password", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
                if (!userFound) {
                    Toast.makeText(Bai4Activity.this, "not found account", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    void initUI() {
        edtPassword = findViewById(R.id.editPassword);
        edtUsername = findViewById(R.id.edtUsername);
        btnLogin = findViewById(R.id.btnLogin);

    }
}