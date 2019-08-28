package com.example.prashantmaheshwari.firstapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Address extends AppCompatActivity implements LocationListener {
    private DatabaseReference database;
    private TextView tv111, tv222;
    private FirebaseUser user;
    DatabaseReference rootRef, demoRef;
    private LocationManager locationManager;
    private static final String TAG = "PhoneLogin";
    private boolean mVerificationInProgress = false;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAuth mAuth;
    EditText e1,e2;
    Button b1,b2;
    TextView t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv111 = (TextView) findViewById(R.id.textView180);
        tv222 = (TextView) findViewById(R.id.textView18);
        e1 = (EditText) findViewById(R.id.edittext8);
        e2 = (EditText)findViewById(R.id.edittext88);
        b1 = (Button) findViewById(R.id.bt1415);
        b2 = (Button) findViewById(R.id.bt1145);
        t1 = (TextView) findViewById(R.id.textView28);
        t2 = (TextView) findViewById(R.id.textView88);
        user = FirebaseAuth.getInstance().getCurrentUser();
        rootRef = FirebaseDatabase.getInstance().getReference(user.getUid());
        demoRef = rootRef.child("Extras/cars");
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mAuth = FirebaseAuth.getInstance();
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                mVerificationInProgress = false;
                Toast.makeText(Address.this,"Verification Complete",Toast.LENGTH_SHORT).show();
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(Address.this,"Verification Failed",Toast.LENGTH_SHORT).show();
                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    Toast.makeText(Address.this,"InValid Phone Number",Toast.LENGTH_SHORT).show();
                } else if (e instanceof FirebaseTooManyRequestsException) {
                }
            }
            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                Toast.makeText(Address.this,"Verification code has been send on your number",Toast.LENGTH_SHORT).show();
                mVerificationId = verificationId;
                mResendToken = token;
                e1.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                t1.setVisibility(View.GONE);
                t2.setVisibility(View.VISIBLE);
                e2.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
            }
        };

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91"+e1.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        Address.this,
                        mCallbacks
                );
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, e2.getText().toString());
                signInWithPhoneAuthCredential(credential);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        demoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                tv111.setText(value);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        onLocationChanged(location);
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Geocoder geocoder = new Geocoder(getApplicationContext());
        try {
            List<android.location.Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            String res = addresses.get(0).getPremises();
            if (res != null) {
                String result = addresses.get(0).getFeatureName() + ", ";
                result = result + addresses.get(0).getSubLocality() + ", ";
                result = result + addresses.get(0).getLocality() + ", ";
                result = result + addresses.get(0).getCountryName();
                tv222.setText(res + result);
            } else {
                String result = addresses.get(0).getFeatureName() + ", ";
                result = result + addresses.get(0).getSubLocality() + ", ";
                result = result + addresses.get(0).getLocality() + ", ";
                result = result + addresses.get(0).getCountryName();
                tv222.setText(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(Address.this,Extras.class));
                            Toast.makeText(Address.this,"Verification Done",Toast.LENGTH_SHORT).show();
                            // ...
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(Address.this,"Invalid Verification",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
}
