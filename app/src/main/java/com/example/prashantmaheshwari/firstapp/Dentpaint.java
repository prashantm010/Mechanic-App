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

public class Dentpaint extends AppCompatActivity {

    ArrayList<String> arrayListe = new ArrayList<>();

    private CheckBox d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12;
    private Button next5, c14;
    private DatabaseReference database5;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentpaint);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = FirebaseAuth.getInstance().getCurrentUser();

        String text = user.getUid();
        database5 = FirebaseDatabase.getInstance().getReference(text);
        d1 = (CheckBox) findViewById(R.id.repair37);
        d2 = (CheckBox) findViewById(R.id.repair38);
        d3 = (CheckBox) findViewById(R.id.repair39);
        d4 = (CheckBox) findViewById(R.id.repair40);
        d5 = (CheckBox) findViewById(R.id.repair41);
        d6 = (CheckBox) findViewById(R.id.repair42);
        d7 = (CheckBox) findViewById(R.id.repair43);
        d8 = (CheckBox) findViewById(R.id.repair44);
        d9 = (CheckBox) findViewById(R.id.repair45);
        d10 = (CheckBox) findViewById(R.id.repair46);
        d11 = (CheckBox) findViewById(R.id.repair47);
        d12 = (CheckBox) findViewById(R.id.repair48);
        next5 = (Button)findViewById(R.id.r15);
        c14 = (Button)findViewById(R.id.c14);

        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9675978031"));
                if (ActivityCompat.checkSelfPermission(Dentpaint.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dent();
            }
        });
    }

    public void selecte(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch(view.getId()){
            case R.id.repair37 :
                String  q = (d1.getText().toString());
                if(checked){
                    arrayListe.add(q);
                }else{
                    arrayListe.remove(q);
                }
                break;
            case R.id.repair38 :
                String r =  (d2.getText().toString());
                if(checked){
                    arrayListe.add(r);
                }else{
                    arrayListe.remove(r);
                }
                break;
            case R.id.repair39 :
                String s =  (d3.getText().toString());
                if(checked){
                    arrayListe.add(s);
                }else{
                    arrayListe.remove(s);
                }
                break;
            case R.id.repair40 :
                String t =  (d4.getText().toString());
                if(checked){
                    arrayListe.add(t);
                }else{
                    arrayListe.remove(t);
                }
                break;
            case R.id.repair41 :
                String u =  (d5.getText().toString());
                if(checked){
                    arrayListe.add(u);
                }else{
                    arrayListe.remove(u);
                }
                break;
            case R.id.repair42 :
                String v =  (d6.getText().toString());
                if(checked){
                    arrayListe.add(v);
                }else{
                    arrayListe.remove(v);
                }
                break;
            case R.id.repair43 :
                String  w = (d1.getText().toString());
                if(checked){
                    arrayListe.add(w);
                }else{
                    arrayListe.remove(w);
                }
                break;
            case R.id.repair44 :
                String x =  (d8.getText().toString());
                if(checked){
                    arrayListe.add(x);
                }else{
                    arrayListe.remove(x);
                }
                break;
            case R.id.repair45 :
                String y =  (d9.getText().toString());
                if(checked){
                    arrayListe.add(y);
                }else{
                    arrayListe.remove(y);
                }
                break;
            case R.id.repair46 :
                String z =  (d10.getText().toString());
                if(checked){
                    arrayListe.add(z);
                }else{
                    arrayListe.remove(z);
                }
                break;
            case R.id.repair47 :
                String aa =  (d11.getText().toString());
                if(checked){
                    arrayListe.add(aa);
                }else{
                    arrayListe.remove(aa);
                }
                break;
            case R.id.repair48 :
                String ab =  (d12.getText().toString());
                if(checked){
                    arrayListe.add(ab);
                }else{
                    arrayListe.remove(ab);
                }
                break;
        }
    }


    public void Dent(){

        if(d1.isChecked() || d2.isChecked() || d3.isChecked() || d4.isChecked() || d5.isChecked() || d6.isChecked() || d7.isChecked() || d8.isChecked() || d9.isChecked() || d10.isChecked() || d11.isChecked() || d12.isChecked()){
            //String id =  database5.push().getKey();
            String final_selecte = "";
            for(String Selections : arrayListe){
                final_selecte = final_selecte + Selections;
            }
            database5.child("service").setValue(final_selecte);
            startActivity(new Intent(Dentpaint.this,ServiceDetails.class));
        }
        else{
            Toast.makeText(this, "Please select Some service", Toast.LENGTH_LONG).show();
        }
    }

}
