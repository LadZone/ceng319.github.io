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
import android.widget.EditText;
import android.widget.Spinner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order extends AppCompatActivity {
private Button button1, button2;
    EditText Fname, Lname;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText Fname = (EditText)findViewById(R.id.input_fname);
        final EditText Lname = (EditText)findViewById(R.id.input_Lname);
        final EditText phone_num = (EditText)findViewById(R.id.input_phone);
        final EditText Address_re = (EditText)findViewById(R.id.input_Address);

        final EditText CCity = (EditText)findViewById(R.id.input_city);
        final EditText SState = (EditText)findViewById(R.id.input_state);
        final EditText Countryy = (EditText)findViewById(R.id.input_country);
        final EditText EEmail = (EditText)findViewById(R.id.input_email);

        final EditText z_zip = (EditText)findViewById(R.id.input_zip);
        final EditText Credit_name = (EditText)findViewById(R.id.input_card_holder_name);
        final EditText creditnum = (EditText)findViewById(R.id.input_credit);
        final EditText expdate = (EditText)findViewById(R.id.input_expiration_date);
        spinner1 = (Spinner) findViewById(R.id.spinner1);


        button1 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String regexStr = "^[0-9]$";
                String regExpn ="[a-zA-Z]+[0-9]+[a-zA-Z]+[0-9]+[a-zA-Z]+[0-9]";
                String number=phone_num.getText().toString();
                String zipp=z_zip.getText().toString();
               int First_name = Fname.getText().toString().length();
                int Last_name = Lname.getText().toString().length();
                int phonenum = phone_num.getText().toString().length();
                int address = Address_re.getText().toString().length();



                int e_mailee = phone_num.getText().toString().length();
                int C_city = CCity.getText().toString().length();
                int S_state = SState.getText().toString().length();
                int C_county = Countryy.getText().toString().length();
                String eeemail = EEmail.getText().toString().trim();
                int zzzip = z_zip.getText().toString().length();
                int credit_holder = Credit_name.getText().toString().length();
                int credit_num = creditnum.getText().toString().length();
                int dateexp = expdate.getText().toString().length();


                //Fname.getText().toString().length()==0
               if(First_name ==0) {
                   Fname.setError("please enter First name");
               }
                   else if(Last_name==0) {
                   Lname.setError("please enter Last name");
               }else if(phonenum<10 || number.length()>10 || number.matches(regexStr)==true  ) {
                   phone_num.setError("Please enter Valid Phone Number");
               }else if(address==0) {
                   Address_re.setError("please enter Address");
               }else if(C_city==0) {
                   CCity.setError("please enter city");
               }else if(S_state==0) {
                   SState.setError("please enter State");
               }else if(C_county==0) {
                   Countryy.setError("please enter Country");
               }else if(e_mailee==0) {
                   EEmail.setError("Please enter valid email");
               }else if(zzzip<6 || zipp.length()>6 || number.matches(regExpn)==true  ) {
                   z_zip.setError("Please enter Valid Zip");
               }else if(credit_holder==0) {
                   Credit_name.setError("please enter card holder name");
               }else if(credit_num==0) {
                   creditnum.setError("please enter your creesit card number");
               }else if(dateexp==0) {
                   expdate.setError("please enter valid expiration date");
               }else{

                   String fFname = Fname.getText().toString();
                   String lFname = Lname.getText().toString();

                   String phone = phone_num.getText().toString();
                   String Address = Address_re.getText().toString();

                   String city = CCity.getText().toString();
                   String state= SState.getText().toString();

                   String country = Countryy.getText().toString();
                   String email = EEmail.getText().toString();

                   String zip = z_zip.getText().toString();
                   String credit_name = Credit_name.getText().toString();

                   String credit_number = creditnum.getText().toString();
                   String expdates = expdate.getText().toString();

                   Intent intent = new Intent(Order.this, OrderConfirmationActivity.class);
                   intent.putExtra("first", fFname);
                   intent.putExtra("last", lFname);

                   intent.putExtra("phone", phone);
                   intent.putExtra("address", Address);

                   intent.putExtra("city", city);
                   intent.putExtra("state", state);

                   intent.putExtra("country", country);
                   intent.putExtra("email", email);

                   intent.putExtra("zip", zip);
                   intent.putExtra("Cname", credit_name);

                   intent.putExtra("Cnumber", credit_number);
                   intent.putExtra("exp", expdates);


                   intent.putExtra("Credit", String.valueOf(spinner1.getSelectedItem()));

                   startActivity(intent);
               }


            }
        });




        button2 = (Button) findViewById(R.id.Back);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, DetailActivity.class);


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




    private boolean number(String first_name) {
        String EMAIL_PATTERN = "^([0-9])$";
        String text = Fname.getText().toString().trim();
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(first_name);
        return matcher.matches();

    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        //spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

}
