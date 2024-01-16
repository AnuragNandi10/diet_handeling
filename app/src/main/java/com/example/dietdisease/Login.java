package com.example.dietdisease;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private TextView tvRegister;
    private EditText etLoginPhone,etLoginPassword;
    private Button loginButton;
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private Cursor cursor;

Bean bean=new Bean();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        tvRegister = findViewById(R.id.tvRegister);
        etLoginPhone = findViewById(R.id.etLogGmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        loginButton = findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginUserAccount();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent
                        = new Intent(Login.this,
                        Register.class);
                startActivity(intent);
            }
        });
    }

    private void loginUserAccount()
    {


        // Take the value of two edit texts in Strings
        String email, password;
        email = etLoginPhone.getText().toString();
        password = etLoginPassword.getText().toString();

        // validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // signin existing user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                                    "Login successful!!",
                                                    Toast.LENGTH_LONG)
                                            .show();


                                    // if sign-in is successful
                                    // intent to home activity
                                    Intent intent
                                            = new Intent(Login.this,
                                            LoginSuccess.class);
                                    startActivity(intent);
                                }

                                else {

                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                                    "Login failed!!",
                                                    Toast.LENGTH_LONG)
                                            .show();


                                }
                            }
                        });
    }
}