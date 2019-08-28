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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dealers extends AppCompatActivity {


    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;

    private DatabaseReference database;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealers);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = FirebaseAuth.getInstance().getCurrentUser();
        database = FirebaseDatabase.getInstance().getReference(user.getUid());

        tv1 = (TextView) findViewById(R.id.textview);
        tv2 = (TextView) findViewById(R.id.textview1);
        tv3 = (TextView) findViewById(R.id.textview2);
        tv4 = (TextView) findViewById(R.id.textview3);
        tv5 = (TextView) findViewById(R.id.textview4);
        tv6 = (TextView) findViewById(R.id.textview5);
        tv7 = (TextView) findViewById(R.id.textview6);
        tv8 = (TextView) findViewById(R.id.textview7);
        tv9 = (TextView)  findViewById(R.id.textview8);
        tv10 = (TextView) findViewById(R.id.textview9);


        Button Select1 = (Button) findViewById(R.id.button1);
        Button Select2 = (Button) findViewById(R.id.button3);
        Button Select3 = (Button) findViewById(R.id.button5);
        Button Select4 = (Button) findViewById(R.id.button7);
        Button Select5 = (Button) findViewById(R.id.button9);
        Button Select6 = (Button) findViewById(R.id.button11);
        Button Select7 = (Button) findViewById(R.id.button13);
        Button Select8 = (Button) findViewById(R.id.button15);
        Button Select9 = (Button) findViewById(R.id.button17);
        Button Select10 = (Button) findViewById(R.id.button19);

        Button Call1 = (Button) findViewById(R.id.button2);
        Button Call2 = (Button) findViewById(R.id.button4);
        Button Call3 = (Button) findViewById(R.id.button6);
        Button Call4 = (Button) findViewById(R.id.button8);
        Button Call5 = (Button) findViewById(R.id.button10);
        Button Call6 = (Button) findViewById(R.id.button12);
        Button Call7 = (Button) findViewById(R.id.button14);
        Button Call8 = (Button) findViewById(R.id.button16);
        Button Call9 = (Button) findViewById(R.id.button18);
        Button Call10 = (Button) findViewById(R.id.button20);

        Select1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = tv1.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data1);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });
        Select2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data2 = tv2.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data2);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });
        Select3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data3 = tv3.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data3);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });
        Select4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data4 = tv4.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data4);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });
        Select5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data5 = tv5.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data5);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });

        Select6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data6 = tv6.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data6);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });
        Select7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data7 = tv7.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data7);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });
        Select8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data8 = tv8.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data8);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });
        Select9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data9 = tv9.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data9);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });
        Select10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data10 = tv10.getText().toString();
                //String id = database.push().getKey();
                database.child("Dealer").setValue(data10);
                startActivity(new Intent(Dealers.this, Confirm.class));
            }
        });


        Call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9787877987"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        Call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9365751245"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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


        Call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9917878998"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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


        Call4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9764315487"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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


        Call5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7014457898"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        Call6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9787877987"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        Call7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9365751245"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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


        Call8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9917878998"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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


        Call9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9764315487"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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


        Call10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7014457898"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
