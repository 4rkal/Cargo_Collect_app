package com.example.cargocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QR extends AppCompatActivity {
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/I.M.Panagiotopoulos+School/@38.0001095,23.8638745,17z/data=!3m1!4b1!4m5!3m4!1s0x14a19a2c46dde241:0x274af5550d4d4c67!8m2!3d38.0001086!4d23.8660542"));
                startActivity(browserIntent);

            }
        });
    }
}