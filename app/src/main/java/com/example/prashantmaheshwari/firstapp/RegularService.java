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


public class RegularService extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>();

    private CheckBox p1, w1, w2, w3;
    private Button next, c11;
    private DatabaseReference database;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular_service);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        p1 = (CheckBox)findViewById(R.id.checkedTextView);
        w1 = (CheckBox)findViewById(R.id.checkedTextViewrd1);
        w2 = (CheckBox)findViewById(R.id.checkedTextViewrd2);
        w3 = (CheckBox)findViewById(R.id.checkedTextViewrd3);
        next = (Button)findViewById(R.id.r11);
        c11 = (Button)findViewById(R.id.c11);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9675978031"));
                if (ActivityCompat.checkSelfPermission(RegularService.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        user = FirebaseAuth.getInstance().getCurrentUser();
        database = FirebaseDatabase.getInstance().getReference(user.getUid());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senddata();
            }
        });
    }

    public void select(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch(view.getId()){
            case R.id.repair55 :
                String a = (p1.getText().toString());
                if(checked){
                    arrayList.add(a);
                }else{
                    arrayList.remove(a);
                }
                break;
            case R.id.repair56 :
                String b = (w1.getText().toString());
                if(checked){
                    arrayList.add(b);
                }else{
                    arrayList.remove(b);
                }
                break;
            case R.id.repair57 :
                String c = (w2.getText().toString());
                if(checked){
                    arrayList.add(c);
                }else{
                    arrayList.remove(c);
                }
                break;
            case R.id.repair58:
                String d = (w3.getText().toString());
                if(checked){
                    arrayList.add(d);
                }else{
                    arrayList.remove(d);
                }
                break;
        }
    }

    public void senddata(){
        if(p1.isChecked() || w1.isChecked() || w2.isChecked() || w3.isChecked()) {
            //String id =  database6.push().getKey();

            String final_select = "";
            for(String Selections : arrayList){
                final_select = final_select + Selections;
            }
            database.child("service").setValue(final_select);
            startActivity(new Intent(RegularService.this,ServiceDetails.class));
        } else{
            Toast.makeText(this, "Please select Some service", Toast.LENGTH_LONG).show();
        }
    }
}