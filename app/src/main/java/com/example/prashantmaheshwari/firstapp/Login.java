package com.example.prashantmaheshwari.firstapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText inputemail,inputpassword;
    private Button submit, newuser, forgotpassword;
    private FirebaseAuth auth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Login.this, Home.class));
            finish();
        }

        inputemail = (EditText)findViewById(R.id.editText);
        inputpassword = (EditText)findViewById(R.id.editText2);
        submit = (Button)findViewById(R.id.button2);
        newuser = (Button)findViewById(R.id.button3);
        forgotpassword = (Button)findViewById(R.id.button4);
        progressDialog = new ProgressDialog(this);

        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Forgot.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputemail.getText().toString();
                final String password = inputpassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.setMessage("Logining User...");
                progressDialog.show();
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if (!task.isSuccessful()) {
                                    if (password.length() < 6) {
                                        Toast.makeText(Login.this,"Password is Short",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(Login.this, "Could Not Login, Please Try again...", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(Login.this, Home.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });
    }


}
