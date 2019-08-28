package com.example.prashantmaheshwari.firstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

/**
 * Created by prashant maheshwari on 27-01-2018.
 */

public class CarList extends ArrayAdapter<Car> {
    private Activity context;
    List<Car> carList;
    private TextView close;
    FirebaseUser user;

    public CarList(@NonNull Activity context, List<Car> carList) {
        super(context, R.layout.car, carList);
        this.context = context;
        this.carList = carList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"})
        View listViewItem = inflater.inflate(R.layout.car, parent, false);

        TextView textViewCar = (TextView) listViewItem.findViewById(R.id.textViewcar);
        TextView textViewFuel = (TextView) listViewItem.findViewById(R.id.textViewfuel);
        TextView textViewRegistration = (TextView) listViewItem.findViewById(R.id.textViewregistration);
        close = (TextView)listViewItem.findViewById(R.id.close);

        final Car car1 = carList.get(position);
        textViewCar.setText(car1.getCarmodel());
        textViewFuel.setText(car1.getFuel());
        textViewRegistration.setText(car1.getRegistrationNo());

        user = FirebaseAuth.getInstance().getCurrentUser();

        /*close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletecar(car1.getId());
            }
        });*/

        return listViewItem;
    }

    /*public void deletecar(String car){
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(user.getUid()).child("car");
        databaseReference.removeValue();
        databaseReference.addChildEventListener(new ChildEventListener() {
      @Override
      public void onChildAdded(DataSnapshot dataSnapshot, String s) {

      }

      @Override
      public void onChildChanged(DataSnapshot dataSnapshot, String s) {

      }

      @Override
      public void onChildRemoved(DataSnapshot dataSnapshot) {
      }

      @Override
      public void onChildMoved(DataSnapshot dataSnapshot, String s) {

      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }
  });
  }*/


}

