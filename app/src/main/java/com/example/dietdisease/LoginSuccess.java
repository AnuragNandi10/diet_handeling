package com.example.dietdisease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginSuccess extends AppCompatActivity {
Button btn1,btn2,btn3,btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        Intent intent=getIntent();
        String result = intent.getStringExtra("Phone");
        System.out.println("My Phone number is:"+result);
btn1.setOnClickListener(new View.OnClickListener() {


    @Override
    public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("Phone",result);
        startActivity(i);
    }
});

btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent n=new Intent(getApplicationContext(), HeartDisease.class);
        startActivity(n);
    }
});
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(getApplicationContext(), Diabetes.class);
                startActivity(n);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(getApplicationContext(), Parkinsons.class);
                startActivity(n);
            }
        });
    }
}