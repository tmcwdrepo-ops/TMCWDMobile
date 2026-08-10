package com.example.tmcwd;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Initialize();
    }

    ///
    /// Initialize fields
    private void Initialize(){
        var btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var txtUsername = (EditText)findViewById(R.id.txtUsername);
                var txtPassword = (EditText)findViewById(R.id.txtPassword);
                var username = txtUsername.getText();
                var password = txtPassword.getText();
                if(username.toString().isEmpty() || password.toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please provide username and password", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Toast.makeText(MainActivity.this, getString(R.string.sign_in_button_was_clicked), Toast.LENGTH_SHORT).show();
                }
            }
        });

        var lnkForgotPassword = findViewById(R.id.lnkForgotPassword);
        lnkForgotPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Link was clicked!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void PullAccounts(){

    }

}