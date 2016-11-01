package com.ladzone.fimp.assigment2;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddTest extends AppCompatActivity {
    TextView test;

    private RadioGroup radioOptionGroup;
    private RadioButton radioOptionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.d("chk", "id" + checkedId);

        if (checkedId == R.id.negative) {
            Toast.makeText(AddTest.this,
                    "negative", Toast.LENGTH_SHORT).show();
        } else if (checkedId == R.id.positive) {
            Toast.makeText(AddTest.this,
                    "positive", Toast.LENGTH_SHORT).show();
        }
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }











    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
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
