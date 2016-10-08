package alay.lad;
//Name: Alay Lad
//Student ID: N00676600
//Assignment 1

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderConfirmationActivity extends AppCompatActivity {

    private Button next, Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView First_name = (TextView)findViewById(R.id.first_names);
        TextView Last_name = (TextView)findViewById(R.id.last_name);

        TextView phone_o = (TextView)findViewById(R.id.output_phone);
        TextView address_o = (TextView)findViewById(R.id.output_Address);

        TextView city_o = (TextView)findViewById(R.id.output_city);
        TextView state_o = (TextView)findViewById(R.id.output_status);

        TextView country_o = (TextView)findViewById(R.id.output_country);
        TextView email_o = (TextView)findViewById(R.id.output_email);

        TextView zip_o = (TextView)findViewById(R.id.output_zip);
        TextView Cname_o = (TextView)findViewById(R.id.card_first_names);

        TextView cnumber_o = (TextView)findViewById(R.id.card_number_output);
        TextView expdate_o = (TextView)findViewById(R.id.exp_date_output);
        TextView Credit_o = (TextView)findViewById(R.id.card_type_output);


        Intent intent= getIntent();
        String first=   intent.getStringExtra("first");
        First_name.setText(first);

        String last=   intent.getStringExtra("last");
        Last_name.setText(last);


        String phone_call=   intent.getStringExtra("phone");
        phone_o.setText(phone_call);

        String address_call=   intent.getStringExtra("address");
        address_o.setText(address_call);


        String city_call=   intent.getStringExtra("city");
        city_o.setText(city_call);

        String state_call=   intent.getStringExtra("state");
        state_o.setText(state_call);


        String country_call=   intent.getStringExtra("country");
        country_o.setText(country_call);

        String email_call=   intent.getStringExtra("email");
        email_o.setText(email_call);


        String zip_call=   intent.getStringExtra("zip");
        zip_o.setText(zip_call);

        String cname_call=   intent.getStringExtra("Cname");
        Cname_o.setText(cname_call);


        String cnumber_call=   intent.getStringExtra("Cnumber");
        cnumber_o.setText(cnumber_call);

        String exp_call=   intent.getStringExtra("exp");
        expdate_o.setText(exp_call);

        String Credit = intent.getStringExtra("Credit");
        Credit_o.setText(Credit);

        next = (Button) findViewById(R.id.button4);

        Back = (Button) findViewById(R.id.Back);

        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OrderConfirmationActivity.this, Order.class);


                startActivity(intent);
            }
        });



        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(OrderConfirmationActivity.this, ThankYou.class);



                startActivity(intent);
            }
        });

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

}
