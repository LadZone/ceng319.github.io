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
                    selection.add("CHEESE LOVER");
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("Extra pizza mozzarella and two of your favourite toppings.");

                }else {
                    selection.remove("CHEESE LOVER");
                    selection.remove("Extra pizza mozzarella and two of your favourite toppings.");
                }
                break;
            case R.id.checkbox_supreme_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("SUPREME LOVER");
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("Pepperoni, mild sausage, beef topping, green pepper, mushrooms, red onion and pizza mozzarella.");
                }else {
                    selection.remove("SUPREME LOVER");
                    selection.remove("Pepperoni, mild sausage, beef topping, green pepper, mushrooms, red onion and pizza mozzarella.");
                }
                break;
            case R.id.checkbox_supersupreme_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("SUPER SUPREME");
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("Pepperoni, Italian Sausage, mild sausage, beef topping, ham, green pepper, mushrooms, red onion, black olives and pizza mozzarella.");

                }else {
                    selection.remove("SUPER SUPREME");
                    selection.remove("Pepperoni, Italian Sausage, mild sausage, beef topping, ham, green pepper, mushrooms, red onion, black olives and pizza mozzarella.");
                }
                break;



            //next 1

            case R.id.checkbox_pepperonilovers_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("PEPPERONI LOVER");
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("Pepperoni, Italian sausage, mild sausage, beef topping, ham, bacon crumble and pizza mozzarella.");

                }else {
                    selection.remove("PEPPERONI LOVER");
                    selection.remove("Pepperoni, Italian sausage, mild sausage, beef topping, ham, bacon crumble and pizza mozzarella.");
                }
                break;
            case R.id.checkbox_meatlover_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("MEAT LOVER");
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("Pepperoni, Italian sausage, mild sausage, beef topping, ham, bacon crumble and pizza mozzarella.");

                }else {
                    selection.remove("MEAT LOVER");
                    selection.remove("Pepperoni, Italian sausage, mild sausage, beef topping, ham, bacon crumble and pizza mozzarella.");
                }
                break;
            case R.id.checkbox_hawaiian_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("HAWAIIAN");
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("The amazing and classic combination of Ham and Pineapple on a base of your choice with extra pizza mozzarella.");


                }else {
                    selection.remove("HAWAIIAN");
                    selection.remove("The amazing and classic combination of Ham and Pineapple on a base of your choice with extra pizza mozzarella.");
                }
                break;


            //next 2

            case R.id.checkbox_chickencaesar_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("CHICKEN CAESAR");
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("Hail Caesar! The classic salad inspired this pizza with grilled chicken, bacon, roasted garlic, creamy Alfredo sauce and 100% Pizza Mozzarella and parmesan cheeses.");
                }else {
                    selection.remove("CHICKEN CAESAR");
                    selection.remove("Hail Caesar! The classic salad inspired this pizza with grilled chicken, bacon, roasted garlic, creamy Alfredo sauce and 100% Pizza Mozzarella and parmesan cheeses.");
                }
                break;
            case R.id.checkbox_triprlcrown_img:
                if (checked) {
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("TRIPLE CROWN");
                    selection.add("----------------------------------------------------------------------------------");
                    selection.add("Pepperoni, mushrooms, crisp green peppers and crowned with 100% Pizza Mozzarella.");

                }else {
                    selection.remove("TRIPLE CROWN");
                    selection.remove("Pepperoni, mushrooms, crisp green peppers and crowned with 100% Pizza Mozzarella.");
                }
                break;




        }
    }

}
