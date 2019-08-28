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

public class TyresService extends AppCompatActivity {

    ArrayList<String> arrayListd = new ArrayList<>();

    private CheckBox t1, t2, t3, t4, t5, t6;
    private Button next4, c15;
    private DatabaseReference database4;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyres_service);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = FirebaseAuth.getInstance().getCurrentUser();

        String text = user.getUid();
        database4 = FirebaseDatabase.getInstance().getReference(text);

        t1 = (CheckBox) findViewById(R.id.repair49);
        t2 = (CheckBox) findViewById(R.id.repair50);
        t3 = (CheckBox) findViewById(R.id.repair51);
        t4 = (CheckBox) findViewById(R.id.repair52);
        t5 = (CheckBox) findViewById(R.id.repair53);
        t6 = (CheckBox) findViewById(R.id.repair54);
        next4 = (Button)findViewById(R.id.r14);
        c15 = (Button)findViewById(R.id.c15);
        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9675978031"));
                if (ActivityCompat.checkSelfPermission(TyresService.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tyre();
            }
        });
    }
    public void selectd(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch(view.getId()){
            case R.id.repair49 :
                String k = t1.getText().toString();
                if(checked){
                    arrayListd.add(k);
                }else{
                    arrayListd.remove(k);
                }
                break;
            case R.id.repair50 :
                String l = t2.getText().toString();
                if(checked){
                    arrayListd.add(l);
                }else{
                    arrayListd.remove(l);
                }
                break;
            case R.id.repair51 :
                String m = t3.getText().toString();
                if(checked){
                    arrayListd.add(m);
                }else{
                    arrayListd.remove(m);
                }
                break;
            case R.id.repair52 :
                String n = t4.getText().toString();
                if(checked){
                    arrayListd.add(n);
                }else{
                    arrayListd.remove(n);
                }
                break;
            case R.id.repair53 :
                String o = t5.getText().toString();
                if(checked){
                    arrayListd.add(o);
                }else{
                    arrayListd.remove(o);
                }
                break;
            case R.id.repair54 :
                String p = t6.getText().toString();
                if(checked){
                    arrayListd.add(p);
                }else{
                    arrayListd.remove(p);
                }
                break;
        }
    }

    public void Tyre(){

        if(t1.isChecked() || t2.isChecked() || t3.isChecked() || t4.isChecked() || t5.isChecked() || t6.isChecked()){
            String id =  database4.push().getKey();
            String final_selectd = "";
            for(String Selections : arrayListd){
                final_selectd = final_selectd + Selections;
            }
            database4.child("service").setValue(final_selectd);
            startActivity(new Intent(TyresService.this,ServiceDetails.class));
        }
        else{
            Toast.makeText(this, "Please select Some service", Toast.LENGTH_LONG).show();
        }
    }

}
