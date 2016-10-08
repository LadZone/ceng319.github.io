package alay.lad;
//Name: Alay Lad
//Student ID: N00676600
//Assignment 1

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {
    private Spinner spinner1, spinner2;
    private Button next, Back;
    private CheckBox checkbox_Beef,checkbox_Chicken,checkbox_Pepperoni;
    ArrayList<String> selectionmeat = new ArrayList<String>();
    ArrayList<String> selection = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Alay:
                Uri uri2 = Uri.parse("https://github.com/ladzone/CENG319.github.io"); // missing 'http://' will cause crashed
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);
                return true;
            case R.id.Pizza:
                Uri uri1 = Uri.parse("https://www.pizzahut.ca/home1"); // missing 'http://' will cause crashed
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(intent1);
                return true;
            case R.id.Help:
                Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);

    }


    // Check screen orientation or screen rotate event here
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //Ctrl + F11
        // Checks the orientation of the screen for landscape and portrait
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_LONG).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_LONG).show();
        }


    }


    // add items into spinner dynamically


    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        //spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addItemsOnSpinner2() {
        spinner1 = (Spinner) findViewById(R.id.spinner2);
        //spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        next = (Button) findViewById(R.id.button4);
        checkbox_Beef = (CheckBox) findViewById(R.id.checkbox_Beef);
        checkbox_Chicken = (CheckBox) findViewById(R.id.checkbox_Chicken);
        checkbox_Pepperoni = (CheckBox) findViewById(R.id.checkbox_Pineapple);
        Back = (Button) findViewById(R.id.Back);



        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CustomActivity.this, MenuActivity.class);


                startActivity(intent);
            }
        });



        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CustomActivity.this, DetailActivity.class);


                intent.putExtra("CHEESE", String.valueOf(spinner1.getSelectedItem()));
                intent.putExtra("SIZE", String.valueOf(spinner2.getSelectedItem()));




                String final_meat_selection ="";
                for(String selectionsmeat: selectionmeat)
                {
                    final_meat_selection = final_meat_selection+ selectionsmeat +"\n";
                }

                String final_vig_selection ="";
                for(String selectionsvig: selection)
                {
                    final_vig_selection = final_vig_selection+ selectionsvig +"\n";
                }


                // intent.putExtra("SIZE", String.valueOf(spinner1.getSelectedItem()));
                intent.putExtra("MEAT",final_meat_selection);
                intent.putExtra("VIG",final_vig_selection);





                startActivity(intent);
            }
        });
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_Beef:
                if (checked) {
                    selectionmeat.add(getString(R.string.beef));

                }else {
                    selectionmeat.remove(getString(R.string.beef));
                }
                break;
            case R.id.checkbox_Pepperoni:
                if (checked) {
                    selectionmeat.add(getString(R.string.pepperoni));

                }else {
                    selectionmeat.remove(getString(R.string.pepperoni));
                }
                break;
            case R.id.checkbox_Bacon:
                if (checked) {
                    selectionmeat.add(getString(R.string.bacon));

                }else {
                    selectionmeat.remove(getString(R.string.bacon));
                }
                break;



            //next 1

            case R.id.checkbox_hot_sausage:
                if (checked) {
                    selectionmeat.add(getString(R.string.hot_sausage));

                }else {
                    selectionmeat.remove(getString(R.string.hot_sausage));
                }
                break;
            case R.id.checkbox_Mushroom:
                if (checked) {
                    selection.add(getString(R.string.mushroom));

                }else {
                    selection.remove(getString(R.string.mushroom));
                }
                break;
            case R.id.checkbox_Pineapple:
                if (checked) {
                    selection.add(getString(R.string.pineapple));

                }else {
                    selection.remove(getString(R.string.pineapple));
                }
                break;


            //next 2

            case R.id.checkbox_red_pepper:
                if (checked) {
                    selection.add(getString(R.string.red_pepper));

                }else {
                    selection.remove(getString(R.string.red_pepper));
                }
                break;
            case R.id.checkbox_green_olives:
                if (checked) {
                    selection.add(getString(R.string.green_olives));

                }else {
                    selection.remove(getString(R.string.green_olives));
                }
                break;
            case R.id.checkbox_Chicken:
                if (checked) {
                    selectionmeat.add(getString(R.string.chicken));

                }else {
                    selectionmeat.remove(getString(R.string.chicken));
                }
                break;



            //next 3

            case R.id.checkbox_Bacon_Crumble:
                if (checked) {
                    selectionmeat.add(getString(R.string.bacon_crumble));

                }else {
                    selectionmeat.remove(getString(R.string.bacon_crumble));
                }
                break;
            case R.id.checkbox_Ham:
                if (checked) {
                    selectionmeat.add(getString(R.string.ham));

                }else {
                    selectionmeat.remove(getString(R.string.ham));
                }
                break;
            case R.id.checkbox_mild_sausage:
                if (checked) {
                    selectionmeat.add(getString(R.string.mild_sausage));

                }else {
                    selectionmeat.remove(getString(R.string.mild_sausage));
                }
                break;



            //next 4

            case R.id.checkbox_Green_Pepper:
                if (checked) {
                    selection.add(getString(R.string.green_pepper));

                }else {
                    selection.remove(getString(R.string.green_pepper));
                }
                break;
            case R.id.checkbox_red_onions:
                if (checked) {
                    selection.add(getString(R.string.red_onions));

                }else {
                    selection.remove(getString(R.string.red_onions));
                }
                break;
            case R.id.checkbox_Tomatoes:
                if (checked) {
                    selection.add(getString(R.string.tomatoes));

                }else {
                    selection.remove(getString(R.string.tomatoes));
                }
                break;
            case R.id.checkbox_black_olives:
                if (checked) {
                    selection.add(getString(R.string.black_olives));

                }else {
                    selection.remove(getString(R.string.black_olives));
                }
                break;



        }
    }
    public void finalSelection(View view){
        /*
        String final_fruit_selection =" ";
        for(String selections: selection)
        {
            final_fruit_selection = final_fruit_selection+ selections +"\n";
        }


        Intent intent = new Intent(CustomActivity.this, DetailActivity.class);


       // intent.putExtra("SIZE", String.valueOf(spinner1.getSelectedItem()));
        intent.putExtra("MEAT",final_fruit_selection);


        startActivity(intent);
        */

    }



    }

