package com.ladzone.fimp.assigment2;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddPatient extends AppCompatActivity {
    List<Contact> Contacts = new ArrayList<Contact>();
    EditText Firstname, Lastname;
    ListView contcatListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firstname = (EditText)findViewById(R.id.first_name);
        Lastname = (EditText)findViewById(R.id.last_name);
        contcatListView = (ListView)findViewById(R.id.listView3);

        final Button addBtn = (Button) findViewById(R.id.AddPatient);
        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


        Intent intent = getIntent();


       // String Fname= intent.getStringExtra("Fname");
        ///Firstname.setText(Fname);
               // String Lname= intent.getStringExtra("Lname");
               // Lastname.setText(Lname);







                addContact(Firstname.getText().toString(),Lastname.getText().toString());
              // populateList();

                ArrayAdapter<Contact>adapter = new ContactListAdapter();
                //contcatListView.setAdapter(adapter);

                intent.putExtra("mylist", String.valueOf(adapter));






                Toast.makeText(getApplicationContext(),Firstname.getText().toString()+"name has been add it !!", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void populateList(){

        ArrayAdapter<Contact>adapter = new ContactListAdapter();



       contcatListView.setAdapter(adapter);
    }

   public void addContact(String firstName, String lastName){
        Contacts.add(new Contact(firstName, lastName));


    }



    public class ContactListAdapter extends ArrayAdapter<Contact> {
        public ContactListAdapter(){

            super(AddPatient.this, R.layout.listview_item, Contacts);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){

            if(view == null )
                view = getLayoutInflater().inflate(R.layout.listview_item,parent, false);
            Contact currentContact = Contacts.get(position);
            TextView Fname = (TextView)view.findViewById(R.id.ContactFname);
            Fname.setText(currentContact.getFirstName());

            TextView Lname = (TextView)view.findViewById(R.id.ContactLname);
            Lname.setText(currentContact.getLastName());

            return view;

        }

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
