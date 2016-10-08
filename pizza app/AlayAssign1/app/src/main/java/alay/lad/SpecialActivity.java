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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SpecialActivity extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;
    private Button next, Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        addListenerOnButton();


    }
    public	boolean onCreateOptionsMenu(Menu menu)	{
        getMenuInflater().inflate(R.menu.menu,	menu);
        return	true;
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
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_LONG).show();
        }


    }

    public void addListenerOnButton() {


        next = (Button) findViewById(R.id.button4);

        Back = (Button) findViewById(R.id.Back);



        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SpecialActivity.this, MenuActivity.class);


                startActivity(intent);
            }
        });



        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(SpecialActivity.this, SpecialDetails.class);






                String final_vig_selection ="";
                for(String selectionsvig: selection)
                {
                    final_vig_selection = final_vig_selection+ selectionsvig +"\n";
                }


                // intent.putExtra("SIZE", String.valueOf(spinner1.getSelectedItem()));

                intent.putExtra("SPECIAL",final_vig_selection);





                startActivity(intent);
            }
        });

    }



    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_chesses_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.cheese_lover));

                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.cheese_lover_idea));

                }else {
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.cheese_lover));
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.cheese_lover_idea));
                }
                break;


            case R.id.checkbox_supreme_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.supreme_lover));
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.supreme_lover_idea));
                }else {
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.supreme_lover));
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.supreme_lover_idea));
                }
                break;



            case R.id.checkbox_supersupreme_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.super_supreme));
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.super_supreme_idea));

                }else {
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.super_supreme));
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.super_supreme_idea));

                }
                break;



            //next 1

            case R.id.checkbox_pepperonilovers_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.pepperoni_lover));
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.pepperoni_love_idea));

                }else {
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.pepperoni_lover));
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.pepperoni_love_idea));
                }
                break;
            case R.id.checkbox_meatlover_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.meat_lover));
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.meat_lover_idea));

                }else {
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.meat_lover));
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.meat_lover_idea));
                }
                break;
            case R.id.checkbox_hawaiian_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.hawaiian));
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.hawaiian_idea));


                }else {
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.hawaiian));
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.hawaiian_idea));
                }
                break;


            //next 2

            case R.id.checkbox_chickencaesar_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.chicken_caesar));
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.chicken_caesar_idea));
                }else {
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.chicken_caesar));
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.chicken_caesar_idea));
                }
                break;
            case R.id.checkbox_triprlcrown_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.triple_crown));
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add(getString(R.string.triple_crown_idea));

                }else {
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.triple_crown));
                    selection.remove("----------------------------------------------------------------------------------");
                    selection.remove(getString(R.string.triple_crown_idea));

                }
                break;




        }
    }

}
