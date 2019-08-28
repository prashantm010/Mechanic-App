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

public class Repairfixes extends AppCompatActivity {

    ArrayList<String> arrayListc = new ArrayList<>();


    private CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c35, c36;
    private Button next3, C13;
    private DatabaseReference database;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairfixes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user = FirebaseAuth.getInstance().getCurrentUser();

        String text = user.getUid();
        database = FirebaseDatabase.getInstance().getReference(text);

        c1 = (CheckBox)findViewById(R.id.repair1);
        c2 = (CheckBox)findViewById(R.id.repair2);
        c3 = (CheckBox)findViewById(R.id.repair3);
        c4 = (CheckBox)findViewById(R.id.repair4);
        c5 = (CheckBox)findViewById(R.id.repair5);
        c6 = (CheckBox)findViewById(R.id.repair6);
        c7 = (CheckBox)findViewById(R.id.repair7);
        c8 = (CheckBox)findViewById(R.id.repair8);
        c9 = (CheckBox)findViewById(R.id.repair9);
        c10 = (CheckBox)findViewById(R.id.repair10);
        c11 = (CheckBox)findViewById(R.id.repair11);
        c12 = (CheckBox)findViewById(R.id.repair12);
        c13 = (CheckBox)findViewById(R.id.repair13);
        c14 = (CheckBox)findViewById(R.id.repair14);
        c15 = (CheckBox)findViewById(R.id.repair15);
        c16 = (CheckBox)findViewById(R.id.repair16);
        c17 = (CheckBox)findViewById(R.id.repair17);
        c18 = (CheckBox)findViewById(R.id.repair18);
        c19 = (CheckBox)findViewById(R.id.repair19);
        c20 = (CheckBox)findViewById(R.id.repair20);
        c21 = (CheckBox)findViewById(R.id.repair21);
        c22 = (CheckBox)findViewById(R.id.repair22);
        c23 = (CheckBox)findViewById(R.id.repair23);
        c24 = (CheckBox)findViewById(R.id.repair24);
        c25 = (CheckBox)findViewById(R.id.repair25);
        c26 = (CheckBox)findViewById(R.id.repair26);
        c27 = (CheckBox)findViewById(R.id.repair27);
        c28 = (CheckBox)findViewById(R.id.repair28);
        c29 = (CheckBox)findViewById(R.id.repair29);
        c30 = (CheckBox)findViewById(R.id.repair30);
        c31 = (CheckBox)findViewById(R.id.repair31);
        c32 = (CheckBox)findViewById(R.id.repair32);
        c33 = (CheckBox)findViewById(R.id.repair33);
        c34 = (CheckBox)findViewById(R.id.repair34);
        c35 = (CheckBox)findViewById(R.id.repair35);
        c36 = (CheckBox)findViewById(R.id.repair36);
        next3 = (Button)findViewById(R.id.r13);
        C13 = (Button)findViewById(R.id.C13);


        C13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9675978031"));
                if (ActivityCompat.checkSelfPermission(Repairfixes.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repair();
            }
        });
    }

    public void selectc(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch(view.getId()){
            case R.id.repair1 :
                String ah =  (c1.getText().toString());
                if(checked){
                    arrayListc.add(ah);
                }else{
                    arrayListc.remove(ah);
                }
                break;
            case R.id.repair2 :
                String ai = c2.getText().toString();
                if(checked){
                    arrayListc.add(ai);
                }else{
                    arrayListc.remove(ai);
                }
                break;
            case R.id.repair3 :
                String aj = c3.getText().toString();
                if(checked){
                    arrayListc.add(aj);
                }else{
                    arrayListc.remove(aj);
                }
                break;
            case R.id.repair4 :
                String ak = c4.getText().toString();
                if(checked){
                    arrayListc.add(ak);
                }else{
                    arrayListc.remove(ak);
                }
                break;
            case R.id.repair5 :
                String al = c5.getText().toString();
                if(checked){
                    arrayListc.add(al);
                }else{
                    arrayListc.remove(al);
                }
                break;
            case R.id.repair6 :
                String am = c6.getText().toString();
                if(checked){
                    arrayListc.add(am);
                }else{
                    arrayListc.remove(am);
                }
                break;
            case R.id.repair7 :
                String an = c7.getText().toString();
                if(checked){
                    arrayListc.add(an);
                }else{
                    arrayListc.remove(an);
                }
                break;
            case R.id.repair8 :
                String ao = c8.getText().toString();
                if(checked){
                    arrayListc.add(ao);
                }else{
                    arrayListc.remove(ao);
                }
                break;
            case R.id.repair9 :
                String ap = c9.getText().toString();
                if(checked){
                    arrayListc.add(ap);
                }else{
                    arrayListc.remove(ap);
                }
                break;
            case R.id.repair10 :
                String aq = c10.getText().toString();
                if(checked){
                    arrayListc.add(aq);
                }else{
                    arrayListc.remove(aq);
                }
                break;
            case R.id.repair11 :
                String ar = c11.getText().toString();
                if(checked){
                    arrayListc.add(ar);
                }else{
                    arrayListc.remove(ar);
                }
                break;
            case R.id.repair12 :
                String as = c12.getText().toString();
                if(checked){
                    arrayListc.add(as);
                }else{
                    arrayListc.remove(as);
                }
                break;case R.id.repair13 :
                String at = c13.getText().toString();
                if(checked){
                    arrayListc.add(at);
                }else{
                    arrayListc.remove(at);
                }
                break;
            case R.id.repair14 :
                String au = c14.getText().toString();
                if(checked){
                    arrayListc.add(au);
                }else{
                    arrayListc.remove(au);
                }
                break;
            case R.id.repair15 :
                String av = c15.getText().toString();
                if(checked){
                    arrayListc.add(av);
                }else{
                    arrayListc.remove(av);
                }
                break;
            case R.id.repair16 :
                String aw = c16.getText().toString();
                if(checked){
                    arrayListc.add(aw);
                }else{
                    arrayListc.remove(aw);
                }
                break;
            case R.id.repair17 :
                String ax = c17.getText().toString();
                if(checked){
                    arrayListc.add(ax);
                }else{
                    arrayListc.remove(ax);
                }
                break;
            case R.id.repair18 :
                String ay = c18.getText().toString();
                if(checked){
                    arrayListc.add(ay);
                }else{
                    arrayListc.remove(ay);
                }
                break;case R.id.repair19 :
                String az = c19.getText().toString();
                if(checked){
                    arrayListc.add(az);
                }else{
                    arrayListc.remove(az);
                }
                break;
            case R.id.repair20 :
                String ba = c20.getText().toString();
                if(checked){
                    arrayListc.add(ba);
                }else{
                    arrayListc.remove(ba);
                }
                break;
            case R.id.repair21 :
                String bb = c22.getText().toString();
                if(checked){
                    arrayListc.add(bb);
                }else{
                    arrayListc.remove(bb);
                }
                break;
            case R.id.repair22 :
                String bc = c22.getText().toString();
                if(checked){
                    arrayListc.add(bc);
                }else{
                    arrayListc.remove(bc);
                }
                break;
            case R.id.repair23 :
                String bd = c23.getText().toString();
                if(checked){
                    arrayListc.add(bd);
                }else{
                    arrayListc.remove(bd);
                }
                break;
            case R.id.repair24 :
                String be = c24.getText().toString();
                if(checked){
                    arrayListc.add(be);
                }else{
                    arrayListc.remove(be);
                }
                break;case R.id.repair25 :
                String bf = c25.getText().toString();
                if(checked){
                    arrayListc.add(bf);
                }else{
                    arrayListc.remove(bf);
                }
                break;
            case R.id.repair26 :
                String bg = c26.getText().toString();
                if(checked){
                    arrayListc.add(bg);
                }else{
                    arrayListc.remove(bg);
                }
                break;
            case R.id.repair27 :
                String bh = c27.getText().toString();
                if(checked){
                    arrayListc.add(bh);
                }else{
                    arrayListc.remove(bh);
                }
                break;
            case R.id.repair28 :
                String bi = c28.getText().toString();
                if(checked){
                    arrayListc.add(bi);
                }else{
                    arrayListc.remove(bi);
                }
                break;
            case R.id.repair29 :
                String bj = c29.getText().toString();
                if(checked){
                    arrayListc.add(bj);
                }else{
                    arrayListc.remove(bj);
                }
                break;
            case R.id.repair30:
                String bk = c30.getText().toString();
                if(checked){
                    arrayListc.add(bk);
                }else{
                    arrayListc.remove(bk);
                }
                break;case R.id.repair31 :
                String bl = c31.getText().toString();
                if(checked){
                    arrayListc.add(bl);
                }else{
                    arrayListc.remove(bl);
                }
                break;
            case R.id.repair32 :
                String bm = c32.getText().toString();
                if(checked){
                    arrayListc.add(bm);
                }else{
                    arrayListc.remove(bm);
                }
                break;
            case R.id.repair33 :
                String bn = c33.getText().toString();
                if(checked){
                    arrayListc.add(bn);
                }else{
                    arrayListc.remove(bn);
                }
                break;
            case R.id.repair34 :
                String bo = c34.getText().toString();
                if(checked){
                    arrayListc.add(bo);
                }else{
                    arrayListc.remove(bo);
                }
                break;
            case R.id.repair35 :
                String bp = c35.getText().toString();
                if(checked){
                    arrayListc.add(bp);
                }else{
                    arrayListc.remove(bp);
                }
                break;
            case R.id.repair36 :
                String bq = c36.getText().toString();
                if(checked){
                    arrayListc.add(bq);
                }else{
                    arrayListc.remove(bq);
                }
                break;
        }
    }


    private void repair() {

        if(c1.isChecked() || c2.isChecked() || c3.isChecked() || c4.isChecked() || c5.isChecked() || c6.isChecked() || c7.isChecked() || c8.isChecked() || c9.isChecked() || c10.isChecked() || c11.isChecked() || c12.isChecked() || c13.isChecked() || c14.isChecked() || c15.isChecked() || c16.isChecked() || c17.isChecked() || c18.isChecked() || c19.isChecked() || c20.isChecked() || c21.isChecked() || c22.isChecked() || c23.isChecked() || c24.isChecked() || c25.isChecked() || c26.isChecked() || c27.isChecked() || c28.isChecked() || c29.isChecked() || c30.isChecked() || c31.isChecked() || c32.isChecked() || c33.isChecked() || c34.isChecked() || c35.isChecked() || c36.isChecked()){
            //String id =  database.push().getKey();

            String final_selectc = "";
            for(String Selections : arrayListc){
                final_selectc = final_selectc + Selections;
            }
            database.child("service").setValue(final_selectc);
            startActivity(new Intent(Repairfixes.this,ServiceDetails.class));
        }
        else{
            Toast.makeText(this, "Please select Some service", Toast.LENGTH_LONG).show();
        }
    }
}
