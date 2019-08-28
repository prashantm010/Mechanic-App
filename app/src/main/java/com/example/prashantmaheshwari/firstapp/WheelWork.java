package com.example.prashantmaheshwari.firstapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WheelWork extends AppCompatActivity {

    private static final int REQUEST_PHONE_CALL = 1;
    private TextView textView;
    private FirebaseAuth firebaseAuth;

    private Button regular, carwash, repair, dents, tyres, multi, calls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_work);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();

        regular = (Button) findViewById(R.id.textbutton1);
        carwash = (Button) findViewById(R.id.textbutton2);
        repair = (Button) findViewById(R.id.textbutton3);
        dents = (Button) findViewById(R.id.textbutton4);
        tyres = (Button) findViewById(R.id.textbutton5);
        multi = (Button) findViewById(R.id.textbutton6);
        calls = (Button) findViewById(R.id.textbutton7);

        regular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WheelWork.this, RegularService.class));
            }
        });

        carwash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WheelWork.this, Carwash.class));
            }
        });
        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WheelWork.this, Repairfixes.class));
            }
        });
        dents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WheelWork.this, Dentpaint.class));
            }
        });
        tyres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WheelWork.this, TyresService.class));
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WheelWork.this, Mullti.class));
            }
        });
        calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9675978031"));
                if (ActivityCompat.checkSelfPermission(WheelWork.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
    }
}
