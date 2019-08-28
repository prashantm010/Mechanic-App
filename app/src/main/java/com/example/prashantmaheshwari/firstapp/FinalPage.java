package com.example.prashantmaheshwari.firstapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.util.DiffUtil;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class FinalPage extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueId = 40111;
    CheckBox cb;
    String MAY1;
    private DatabaseReference database;
    private TextView tv1 ,tv2 ,tv3 ,tv4,tv5,tv6,tv7;
    private FirebaseUser user;
    DatabaseReference rootRef,demoRef;
    String apm,Mo;
    Double tt;
    private EditText editText;
    private Button apply11;

    @Override
    protected void onStart() {
        super.onStart();
        demoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                String cnc = String.valueOf(map.get("cars"));
                String anc = String.valueOf(map.get("title"));
                String bnc = String.valueOf(map.get("money"));
                tv1.setText(cnc);
                tv2.setText(anc);
                tv3.setText("@"+bnc + " INR");
                tv4.setText(bnc);

                Double mm = 0.00;
                mm = Double.valueOf(bnc);
                Double an = mm * 0.18;
                tt = mm + an;
                String gst = String.valueOf(an);
                tv5.setText(gst);
                float k = (float) Math.round(tt * 100) / 100;
                Mo = String.valueOf(k);
                tv6.setText(Mo);
                /*String Coupon = editText.getText().toString();
                if(Coupon == "GET20" && Coupon == "get20"){
                    Double qw = tt*0.20;
                    Double pp = tt - qw;
                    float l = (float) Math.round(pp * 100) / 100;
                    MAY = String.valueOf(l);
                }*/


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //calculate();
        Button confirmBook = (Button)findViewById(R.id.button22);
        cb = (CheckBox)findViewById(R.id.checkBox);
        tv1 = (TextView)findViewById(R.id.textView9);
        tv2 = (TextView)findViewById(R.id.textView10);
        tv3 = (TextView)findViewById(R.id.textView11);
        tv4 = (TextView)findViewById(R.id.textView23);
        tv5 = (TextView)findViewById(R.id.textView24);
        tv6 = (TextView)findViewById(R.id.textView25);
        tv7 = (TextView)findViewById(R.id.textView16);
        editText = (EditText)findViewById(R.id.editText8);
        apply11 = (Button)findViewById(R.id.button21);

        /*apply11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double appp = Double.parseDouble(Mo);
                if(appp!=null) {
                String Coupon = editText.getText().toString();
                if(Coupon == "GET20" && Coupon == "get20"){
                    appp = tt*0.2;
                    Double pp = tt - appp;
                    float l = (float) Math.round(pp * 100) / 100;
                    MAY = String.valueOf(l);
                    tv7.setText(MAY);
                }
                }else {
                    Toast.makeText(FinalPage.this,"csds",Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        apply11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double appp = Double.parseDouble(Mo);
                if(appp!=null) {
                    String Coupon = editText.getText().toString();
                    if(Coupon == "GET20" && Coupon == "get20"){
                        appp = tt*0.2;
                        Double pp = tt - appp;
                        float l = (float) Math.round(pp * 100) / 100;
                        MAY1 = String.valueOf(l);
                        tv7.setText(MAY1);
                    }
                }else {
                    Toast.makeText(FinalPage.this,"csds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        user = FirebaseAuth.getInstance().getCurrentUser();

        rootRef = FirebaseDatabase.getInstance().getReference(user.getUid());
        demoRef = rootRef.child("Extras");

        confirmBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Your Booking is Successfully Done!!", Toast.LENGTH_SHORT).show();
                    notification.setSmallIcon(R.mipmap.abc);
                    notification.setWhen(System.currentTimeMillis());
                    notification.setContentTitle("Your Booking is successfully Done!!");
                    notification.setContentText("Our Team will reach you shortly");

                    Intent i = new Intent(FinalPage.this, MainActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(FinalPage.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                    notification.setContentIntent(pendingIntent);

                    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(uniqueId, notification.build());
                    startActivity(new Intent(FinalPage.this, Home.class));
                }
                else{
                    Toast.makeText(FinalPage.this,"Plz Agree to Confirm Booking",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /*public void calculate(){
        if(apm!=null) {
            //apm = tv3.getText().toString();
            Double mm = 0.00;
            mm = Double.valueOf(apm);
            Double an = mm * 0.18;
            double tt = mm - an;
            String Mo = String.valueOf(tt);
            String gst = String.valueOf(an);
            tv5.setText(gst);
            tv6.setText(Mo);
        }
        else{
            Toast.makeText(FinalPage.this,"csds",Toast.LENGTH_SHORT).show();
        }
    }*/

}
