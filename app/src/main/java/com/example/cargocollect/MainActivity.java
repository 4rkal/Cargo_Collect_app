package com.example.cargocollect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;
    private String Username = "user";
    private String Password = "123456";
    boolean isValid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.editTextTextPersonName2);
        ePassword = findViewById(R.id.editTextTextPassword2);
        eLogin = findViewById(R.id.button);
        eAttemptsInfo = findViewById(R.id.textView);


        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter name and password!", Toast.LENGTH_LONG).show();
                }else{
                    isValid = validate(inputName, inputPassword);
                    if(!isValid){
                       counter --;
                        Toast.makeText(MainActivity.this, "Incorrect Credentials ", Toast.LENGTH_LONG).show();
                        eAttemptsInfo.setText("Number of attempts remaining: " + counter);
                        if(counter == 0){
                            eLogin.setEnabled(false);
                        }

                    }else{
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();

                        Intent intent= new Intent(MainActivity.this, HomePage.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }


    private boolean validate(String name, String password){
        if(name.equals(Username) && password.equals(Password)){
            return true;
        }
        return false;
    }
}