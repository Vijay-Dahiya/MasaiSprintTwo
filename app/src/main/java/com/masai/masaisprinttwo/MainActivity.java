package com.masai.masaisprinttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etEmailScreen1;
    private EditText etPasswordScreen1;
    private TextView etLoginScreen1;
    private CheckBox cbEmail;
    private final boolean[] isClicked = {false};
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        if (isClicked[0]) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            startActivity(intent);

        }


        cbEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClicked[0] = true;
            }
        });

        etLoginScreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isPasswordValid = isPasswordValid();
                boolean isEmailValid = isEmailValid();
                if (isEmailValid && isPasswordValid) {

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                    startActivity(intent);

                }
            }

        });


    }

    protected void onRestart() {
        super.onRestart();

    }

    void initViews() {
        etEmailScreen1 = findViewById(R.id.EmailScreen1);
        etPasswordScreen1 = findViewById(R.id.IdScreen1);
        etLoginScreen1 = findViewById(R.id.LoginScreen1);
        cbEmail = findViewById(R.id.checkboxEmail);

    }

    private boolean isEmailValid() {
        if (etEmailScreen1.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            etEmailScreen1.setError("Invalid email");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (etPasswordScreen1.getText().toString().length() >= 6) {
            return true;
        } else {
            etPasswordScreen1.setError("Password is short");
            return false;
        }
    }
}
