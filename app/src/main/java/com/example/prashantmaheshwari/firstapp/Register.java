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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private EditText name, inputpassword, mobile, inputemail;
    private Button submit;
    private ProgressDialog progressDialog;
    FirebaseUser user;
    private DatabaseReference database;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        user = FirebaseAuth.getInstance().getCurrentUser();

        database = FirebaseDatabase.getInstance().getReference("Register");

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Register.this, Home.class));
            finish();
        }

        name = (EditText)findViewById(R.id.editText3);
        inputpassword = (EditText)findViewById(R.id.editText6);
        mobile = (EditText)findViewById(R.id.editText4);
        inputemail = (EditText)findViewById(R.id.editText7);
        progressDialog = new ProgressDialog(this);
        submit = (Button)findViewById(R.id.button6);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String email = inputemail.getText().toString().trim();
                String password = inputpassword.getText().toString().trim();
                String Mobile = mobile.getText().toString();

                if (TextUtils.isEmpty(name1)) {
                    Toast.makeText(getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Mobile)) {
                    Toast.makeText(getApplicationContext(), "Enter Mobile No.!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }


                progressDialog.setMessage("Registering User....");
                progressDialog.show();
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Register.this, Home.class));
                                    Toast.makeText(Register.this, "Successfully Registered User...",Toast.LENGTH_SHORT).show();

                                    finish();
                                }
                            }
                        });

            }
        });
    }
}