package com.example.prashantmaheshwari.firstapp;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class ServiceDetails extends AppCompatActivity implements LocationListener {
    private TextView textView, mycab, time1, date1;
    FirebaseUser user;
    private RadioGroup radioGroup;
    private ImageButton img1, img2;
    private DatabaseReference database;
    private EditText id;
    private LocationManager locationManager;
    private Button button, button1, button2;
    private int mYear, mMonth, mDay, mHour, mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = FirebaseAuth.getInstance().getCurrentUser();

        String text = user.getUid();
        database = FirebaseDatabase.getInstance().getReference(text);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        button = (Button) findViewById(R.id.button2);
        button1 = (Button) findViewById(R.id.choosecar);
        id = (EditText) findViewById(R.id.id);
        mycab = (TextView) findViewById(R.id.car);
        time1 = (TextView) findViewById(R.id.textView6);
        img1 = (ImageButton) findViewById(R.id.imageButton10);
        img2 = (ImageButton) findViewById(R.id.imageButton5);
        date1 = (TextView) findViewById(R.id.textView7);
        button2 = (Button) findViewById(R.id.choosecar1);
        textView = (TextView) findViewById(R.id.textview);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    String a = rb.getText().toString();
                }

            }
        });
        Intent intent = getIntent();
        mycab.setText(intent.getStringExtra(MyCars.Car_Model));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(ServiceDetails.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ServiceDetails.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                Location location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
                onLocationChanged(location);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(ServiceDetails.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        time1.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ServiceDetails.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date1.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    }
                }, mDay, mMonth, mYear);
                datePickerDialog.show();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ServiceDetails.this, MyCars.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataadd();
            }
        });

    }

    private void dataadd() {
        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        String mob = id.getText().toString();
        String address = textView.getText().toString();
        String car121 = mycab.getText().toString();
        String pickup = rb.getText().toString();
        String time11 = time1.getText().toString();
        String date22 = date1.getText().toString();

        if (!TextUtils.isEmpty(mob)) {
            String id = database.push().getKey();
            Details details = new Details(id, mob, address, car121, pickup, time11, date22);
            database.child("Address").setValue(details);
            Toast.makeText(getApplicationContext(), "Details Added", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ServiceDetails.this, Dealers.class));

        } else {
            Toast.makeText(getApplicationContext(), "Plz enter the details", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Geocoder geocoder = new Geocoder(getApplicationContext());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            String res = addresses.get(0).getPremises();
            if (res != null) {
                String result = addresses.get(0).getFeatureName() + ", ";
                result = result + addresses.get(0).getSubLocality() + ", ";
                result = result + addresses.get(0).getLocality() + ", ";
                result = result + addresses.get(0).getCountryName();
                textView.setText(res + result);
            } else {
                String result = addresses.get(0).getFeatureName() + ", ";
                result = result + addresses.get(0).getSubLocality() + ", ";
                result = result + addresses.get(0).getLocality() + ", ";
                result = result + addresses.get(0).getCountryName();
                textView.setText(result);
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
}


