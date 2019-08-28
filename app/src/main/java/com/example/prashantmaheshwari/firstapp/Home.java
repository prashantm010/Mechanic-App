package com.example.prashantmaheshwari.firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] Images= {R.drawable.one,R.drawable.four,R.drawable.five};
    private ArrayList<Integer> Array = new ArrayList<Integer>();

    private Button ln1,ln2,ln3,ln4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ln1 = (Button) findViewById(R.id.bt1);
        ln2 = (Button) findViewById(R.id.bt2);
        ln3 = (Button) findViewById(R.id.bt11);
        ln4 = (Button) findViewById(R.id.bt22);

        init();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();

        View header = navigationView.getHeaderView(0);
        TextView textView = (TextView) header.findViewById(R.id.textView);
        textView.setText("Welcome \n" + email);

        ln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:18002002255"));
                if (ActivityCompat.checkSelfPermission(Home.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        ln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] TO = {"prashantgreat010@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Car Service");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Home.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        for(int i=0;i<Images.length;i++)
            Array.add(Images[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new Myadapter(Home.this,Array));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == Images.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);

        mPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,Offer.class));
            }
        });

        ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,MyCar2.class));
            }
        });
        ln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,WheelWork.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_offers) {
            startActivity(new Intent(Home.this,Offer.class));
        }
        else if (id == R.id.action_logout) {
            logout();
            startActivity(new Intent(Home.this,Login.class));
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("MissingPermission")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Home) {
            startActivity(new Intent(Home.this,Home.class));
        } else if (id == R.id.My_cars) {
            startActivity(new Intent(Home.this,MyCar3.class));
        } else if (id == R.id.service_history) {
            startActivity(new Intent(Home.this,ServiceHistory.class));
        } else if (id == R.id.Call) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:9675978031"));
            startActivity(callIntent);
        } else if (id == R.id.About_us) {
            startActivity(new Intent(Home.this,Aboutus.class));
        } else if (id == R.id.Rate_me) {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
            startActivity(launchIntent);
        }else if (id == R.id.share) {
            Intent intent2 = new Intent(); intent2.setAction(Intent.ACTION_SEND);
            intent2.setType("text/plain");
            intent2.putExtra(Intent.EXTRA_TEXT, "Car Service Application"+"\n https://play.google.com/store/apps/details?id=com.garagecloudcom.garagecloud" );
            startActivity(Intent.createChooser(intent2, "Share via"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
