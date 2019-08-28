package com.example.prashantmaheshwari.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyCar2 extends AppCompatActivity {

    public static final String Car_Model = "https://bookamechanic-411b3.firebaseio.com/";
    public static final String Car_id = "https://bookamechanic-411b3.firebaseio.com/";

    ListView listViewcars;
    List<Car> cars;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    FirebaseUser user;
    String text;
    private DatabaseReference database11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = FirebaseAuth.getInstance().getCurrentUser();
        database11 = FirebaseDatabase.getInstance().getReference(user.getUid());

        listViewcars = (ListView) findViewById(R.id.listViewCars);
        listViewcars.setClickable(true);
        listViewcars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Car car = cars.get(i);
                database11.child("Extras" + "/cars").setValue(car.getCarmodel());
                Intent intent = new Intent(getApplicationContext(), RoadSide.class);
                startActivity(intent);
            }
        });


        user = FirebaseAuth.getInstance().getCurrentUser();
        text = user.getUid();
        cars = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        DatabaseReference rootRef = database.getInstance().getReference();
        DatabaseReference usersRef = rootRef.child(text+"/car");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cars.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Car car = postSnapshot.getValue(Car.class);
                    cars.add(car);
                }
                CarList carsAdapter = new CarList(MyCar2.this, cars);
                listViewcars.setAdapter(carsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        usersRef.addListenerForSingleValueEvent(eventListener);
    }
}
