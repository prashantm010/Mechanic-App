package com.example.prashantmaheshwari.firstapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Carwash extends AppCompatActivity {
    ArrayList<String> arrayListb = new ArrayList<>();
    private CheckBox c1, c2, c3, c4, c5, c6;
    private Button next1, c12;
    private DatabaseReference database2;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carwash);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = FirebaseAuth.getInstance().getCurrentUser();
        database2 = FirebaseDatabase.getInstance().getReference(user.getUid());

        c1 = (CheckBox) findViewById(R.id.checkedTextViewrd5);
        c2 = (CheckBox) findViewById(R.id.checkedTextViewrd6);
        c3 = (CheckBox) findViewById(R.id.checkedTextViewrd7);
        c4 = (CheckBox) findViewById(R.id.checkedTextViewrd8);
        c5 = (CheckBox) findViewById(R.id.checkedTextViewrd9);
        c6 = (CheckBox) findViewById(R.id.checkedTextViewrd10);
        next1 = (Button)findViewById(R.id.r12);
        c12 = (Button)findViewById(R.id.c12);
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9675978031"));
                if (ActivityCompat.checkSelfPermission(Carwash.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);

            }
        });

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carwash();
            }
        });
    }

    public void selectb(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch(view.getId()){
            case R.id.checkedTextViewrd5 :
                String e = c1.getText().toString();
                if(checked){
                    arrayListb.add(e);
                }else{
                    arrayListb.remove(e);
                }
                break;
            case R.id.checkedTextViewrd6 :
                String f = c2.getText().toString();
                if(checked){
                    arrayListb.add(f);
                }else{
                    arrayListb.remove(f);
                }
                break;
            case R.id.checkedTextViewrd7 :
                String g = c3.getText().toString();
                if(checked){
                    arrayListb.add(g);
                }else{
                    arrayListb.remove(g);
                }
                break;
            case R.id.checkedTextViewrd8 :
                String h = c4.getText().toString();
                if(checked){
                    arrayListb.add(h);
                }else{
                    arrayListb.remove(h);
                }
                break;
            case R.id.checkedTextViewrd9 :
                String i = c5.getText().toString();
                if(checked){
                    arrayListb.add(i);
                }else{
                    arrayListb.remove(i);
                }
                break;
            case R.id.checkedTextViewrd10 :
                String j = c6.getText().toString();
                if(checked){
                    arrayListb.add(j);
                }else{
                    arrayListb.remove(j);
                }
                break;
        }
    }

    public void carwash(){
        if(c1.isChecked() || c2.isChecked() || c3.isChecked() || c4.isChecked() || c5.isChecked() || c6.isChecked()){
            //String id =  database2.push().getKey();
            String final_selectb = "";
            for(String Selections : arrayListb){
                final_selectb = final_selectb + Selections;
            }
            database2.child("service").setValue(final_selectb);
            startActivity(new Intent(Carwash.this,ServiceDetails.class));
        }
        else{
            Toast.makeText(this, "Please select Some service", Toast.LENGTH_LONG).show();
        }
    }
}
