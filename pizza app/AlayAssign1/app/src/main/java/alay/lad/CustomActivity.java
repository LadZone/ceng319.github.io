package alay.lad;

import android.content.Intent;
import android.content.res.Configuration;
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


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.stop) {
            return true;
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
                    selectionmeat.add("Beef");

                }else {
                    selectionmeat.remove("Beef");
                }
                break;
            case R.id.checkbox_Pepperoni:
                if (checked) {
                    selectionmeat.add("Pepperoni");

                }else {
                    selectionmeat.remove("Pepperoni");
                }
                break;
            case R.id.checkbox_Bacon:
                if (checked) {
                    selectionmeat.add("Bacon");

                }else {
                    selectionmeat.remove("Bacon");
                }
                break;



            //next 1

            case R.id.checkbox_hot_sausage:
                if (checked) {
                    selectionmeat.add("Hot Sausage");

                }else {
                    selectionmeat.remove("Hot Sausage");
                }
                break;
            case R.id.checkbox_Mushroom:
                if (checked) {
                    selection.add("Mushroom");

                }else {
                    selection.remove("Mushroom");
                }
                break;
            case R.id.checkbox_Pineapple:
                if (checked) {
                    selection.add("Pineapple");

                }else {
                    selection.remove("Pineapple");
                }
                break;


            //next 2

            case R.id.checkbox_red_pepper:
                if (checked) {
                    selection.add("Red Pepper");

                }else {
                    selection.remove("Red Pepper");
                }
                break;
            case R.id.checkbox_green_olives:
                if (checked) {
                    selection.add("Green Olives");

                }else {
                    selection.remove("Green Olives");
                }
                break;
            case R.id.checkbox_Chicken:
                if (checked) {
                    selectionmeat.add("Chicken");

                }else {
                    selectionmeat.remove("Chicken");
                }
                break;



            //next 3

            case R.id.checkbox_Bacon_Crumble:
                if (checked) {
                    selectionmeat.add("Bacon Crumble");

                }else {
                    selectionmeat.remove("Bacon Crumble");
                }
                break;
            case R.id.checkbox_Ham:
                if (checked) {
                    selectionmeat.add("Ham");

                }else {
                    selectionmeat.remove("Ham");
                }
                break;
            case R.id.checkbox_mild_sausage:
                if (checked) {
                    selectionmeat.add("Mild Sausage");

                }else {
                    selectionmeat.remove("Mild Sausage");
                }
                break;



            //next 4

            case R.id.checkbox_Green_Pepper:
                if (checked) {
                    selection.add("Green Pepper");

                }else {
                    selection.remove("Green Pepper");
                }
                break;
            case R.id.checkbox_red_onions:
                if (checked) {
                    selection.add("Red Onions");

                }else {
                    selection.remove("Red Onions");
                }
                break;
            case R.id.checkbox_Tomatoes:
                if (checked) {
                    selection.add("Tomatoes");

                }else {
                    selection.remove("Tomatoes");
                }
                break;
            case R.id.checkbox_black_olives:
                if (checked) {
                    selection.add("Black Olives");

                }else {
                    selection.remove("Black Olives");
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

