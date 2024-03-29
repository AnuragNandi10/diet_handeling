package com.example.dietdisease;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class OverWeight extends AppCompatActivity {
    Intent t;
    TextView t1,t2,t3;
    float loseOne,loseTwo,calories;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.over_weight);
        Intent intent=getIntent();
        String result2 = intent.getStringExtra("Phone");
        t1 = (TextView) findViewById(R.id.textView32);
        t2 = (TextView) findViewById(R.id.textView25);
        t3 = (TextView) findViewById(R.id.textView27);
        t = getIntent();
        b1 = (Button)findViewById(R.id.button4);
        b2 = (Button)findViewById(R.id.button9);
        String value = t.getStringExtra("calories");
        t1.setText(value);
        calories = Float.parseFloat(t1.getText().toString());
        loseOne = calories - 500;
        String close = Float.toString(loseOne);
        loseTwo = calories - 1000;
        String close1 = Float.toString(loseTwo);
        t1.setTextSize(20);
        t1.setTypeface(t1.getTypeface(), Typeface.BOLD);
        t2.setText(close);
        t2.setTextSize(20);
        t2.setTypeface(t2.getTypeface(), Typeface.BOLD);
        t3.setText(close1);
        t3.setTextSize(20);
        t3.setTypeface(t3.getTypeface(), Typeface.BOLD);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("inside","b1 click");
                //Log.d("caloriesgain2","value"+lose);
                Log.d("calorieslose 1 week","value"+loseOne);
                Intent t = new Intent(OverWeight.this,ViewItems.class);
                t.putExtra("Phone",result2);
                String s =String.valueOf(loseOne);
                t.putExtra("values",s);
                startActivityForResult(t,0);
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("inside","b1 click");
                //Log.d("caloriesgain2","value"+lose);
                Log.d("caloriesgain 1 week","value"+loseTwo);
                Intent t = new Intent(OverWeight.this,ViewItems.class);
                t.putExtra("Phone",result2);
                String s =String.valueOf(loseTwo);
                t.putExtra("values",s);
                startActivityForResult(t,0);

            }

        });

    }
}
