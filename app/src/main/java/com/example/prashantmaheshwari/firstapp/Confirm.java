package com.example.prashantmaheshwari.firstapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Confirm extends AppCompatActivity {


    FirebaseDatabase database=FirebaseDatabase.getInstance();
    FirebaseUser user;
    NotificationCompat.Builder notification;
    private static final int uniqueId = 40111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button okproceed = (Button)findViewById(R.id.button14);
        Button cancelbooking = (Button)findViewById(R.id.button15);


        okproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Your Booking is Successfully Done!!",Toast.LENGTH_SHORT).show();
                notification.setSmallIcon(R.mipmap.abc);
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("Your Booking is successfully Done!!");
                notification.setContentText("Our Team will reach you shortly");

                Intent i = new Intent(Confirm.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(Confirm.this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pendingIntent);

                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(uniqueId,notification.build());
                startActivity(new Intent(Confirm.this,Home.class));

            }
        });


        cancelbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Booking Request Cancelled by the user!!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Confirm.this,Home.class));
            }
        });
    }
}
