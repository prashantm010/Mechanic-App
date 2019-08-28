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

public class Mullti extends AppCompatActivity {
    ArrayList<String> arrayListf = new ArrayList<>();

    private CheckBox m1,m2,m3,m4,m5;
    private Button next6, c16;
    private DatabaseReference database6;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mullti);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user = FirebaseAuth.getInstance().getCurrentUser();

        String text = user.getUid();
        database6 = FirebaseDatabase.getInstance().getReference(text);

        m1 = (CheckBox) findViewById(R.id.repair55);
        m2 = (CheckBox) findViewById(R.id.repair56);
        m3 = (CheckBox) findViewById(R.id.repair57);
        m4 = (CheckBox) findViewById(R.id.repair58);
        m5 = (CheckBox) findViewById(R.id.repair59);
        c16 = (Button)findViewById(R.id.c16);
        next6 = (Button)findViewById(R.id.r16);

        c16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9675978031"));
                if (ActivityCompat.checkSelfPermission(Mullti.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Multis();
            }
        });
    }

    public void selectf(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch(view.getId()){
            case R.id.repair55 :
                String ac = (m1.getText().toString());
                if(checked){
                    arrayListf.add(ac);
                }else{
                    arrayListf.remove(ac);
                }
                break;
            case R.id.repair56 :
                String ad = (m2.getText().toString());
                if(checked){
                    arrayListf.add(ad);
                }else{
                    arrayListf.remove(ad);
                }
                break;
            case R.id.repair57 :
                String ae = (m3.getText().toString());
                if(checked){
                    arrayListf.add(ae);
                }else{
                    arrayListf.remove(ae);
                }
                break;
            case R.id.repair58:
                String af = (m4.getText().toString());
                if(checked){
                    arrayListf.add(af);
                }else{
                    arrayListf.remove(af);
                }
                break;
            case R.id.repair59 :
                String ag = (m5.getText().toString());
                if(checked){
                    arrayListf.add(ag);
                }else{
                    arrayListf.remove(ag);
                }
                break;
        }
    }


    public void Multis(){
        if(m1.isChecked() || m2.isChecked() || m3.isChecked() || m4.isChecked() || m5.isChecked()){
            //String id =  database6.push().getKey();

            String final_selectf = "";
            for(String Selections : arrayListf){
                final_selectf = final_selectf + Selections;
            }
            database6.child("service").setValue(final_selectf);
            startActivity(new Intent(Mullti.this,ServiceDetails.class));
        } else{
            Toast.makeText(this, "Please select Some service", Toast.LENGTH_LONG).show();
        }
    }

}
