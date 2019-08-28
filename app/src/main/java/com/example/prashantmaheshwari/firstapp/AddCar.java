package com.example.prashantmaheshwari.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCar extends AppCompatActivity {

    private Spinner sp1,sp2;
    private EditText et1, et2, et3, et4;
    private Button button;
    private DatabaseReference database;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        user = FirebaseAuth.getInstance().getCurrentUser();

        String text = user.getUid();
        database = FirebaseDatabase.getInstance().getReference(text+"/car");

        sp1 = (Spinner)findViewById(R.id.spinner);
        sp2 = (Spinner)findViewById(R.id.spinner2);
        et1 = (EditText)findViewById(R.id.editText13);
        et2 = (EditText)findViewById(R.id.editText14);
        et3 = (EditText)findViewById(R.id.editText16);
        et4 = (EditText)findViewById(R.id.editText17);
        button = (Button)findViewById(R.id.button8);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String carmodel = sp1.getSelectedItem().toString();
                String fuel = sp2.getSelectedItem().toString();
                String registration = et1.getText().toString()+et2.getText().toString()+et3.getText().toString()+et4.getText().toString();
                if(!TextUtils.isEmpty(registration)){
                    String id = database.push().getKey();
                    Car car = new Car(id,carmodel,fuel,registration);
                    database.child(id).setValue(car);
                    Toast.makeText(getApplicationContext(),"Car Added",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddCar.this,MyCar3.class));

                }else{
                    Toast.makeText(getApplicationContext(),"Please Enter your registration no.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
