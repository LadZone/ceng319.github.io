package com.ladzone.fimp.assigment2;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab_plus, fab_account, fab_test;
    Animation fabopen, fabclose, fabClock, fabanticlock;
    TextView ew_account, ew_test, ew_date;
    View bckgroundDimmer;
    List<Contact> Contacts = new ArrayList<Contact>();
    ListView contcatListView;

    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabHost tabHost;



        contcatListView = (ListView) findViewById(R.id.listView);

        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_account = (FloatingActionButton) findViewById(R.id.fab_account);
        fab_test = (FloatingActionButton) findViewById(R.id.fab_test);
        fabopen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fabclose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fabClock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        fabanticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
        ew_account = (TextView) findViewById(R.id.ewAccount);
        ew_test = (TextView) findViewById(R.id.ewTest);
        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();
        this.bckgroundDimmer = findViewById(R.id.background_dimmer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
        contcatListView.setAdapter((ListAdapter) myList);





        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    fab_account.startAnimation(fabclose);
                    fab_test.startAnimation(fabclose);
                    fab_plus.startAnimation(fabanticlock);
                    fab_account.setClickable(false);
                    fab_test.setClickable(false);
                    ew_test.setVisibility(View.INVISIBLE);
                    ew_account.setVisibility(View.INVISIBLE);
                    onMenuCollapsed();
                    isOpen = false;


                } else {

                    fab_account.startAnimation(fabopen);
                    fab_test.startAnimation(fabopen);
                    fab_plus.startAnimation(fabClock);
                    fab_account.setClickable(true);
                    fab_test.setClickable(true);
                    ew_test.setVisibility(View.VISIBLE);
                    ew_account.setVisibility(View.VISIBLE);
                    onMenuExpanded();
                    isOpen = true;


                }
            }
        });
        fab_test.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTest.class);


                startActivity(intent);
            }
        });
        fab_account.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddPatient.class);


                startActivity(intent);
            }
        });


        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec(getString(R.string.my_patient));
        spec.setContent(R.id.tab1);
        spec.setIndicator(getString(R.string.my_patient));
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec(getString(R.string.all_patient));
        spec.setContent(R.id.tab2);
        spec.setIndicator(getString(R.string.all_patient));
        host.addTab(spec);

    }





        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }


        public void onMenuCollapsed() {
            bckgroundDimmer.setVisibility(View.GONE);
        }

        public void onMenuExpanded() {
            bckgroundDimmer.setVisibility(View.VISIBLE);
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult(myIntent, 0);

            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);

        }


    }

