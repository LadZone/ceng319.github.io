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

public class DetailActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();

        //Toast.makeText(this,getIntent().getStringExtra("SIZE"),
             //   Toast.LENGTH_LONG).show();
      //  Toast.makeText(this,getIntent().getStringExtra("CHEESE"),
                //Toast.LENGTH_LONG).show();
        TextView size1 = (TextView)findViewById(R.id.size_result);
        TextView cheese1 = (TextView)findViewById(R.id.cheese_result);
        TextView meat1 = (TextView)findViewById(R.id.mv_result);
        TextView vig1 = (TextView)findViewById(R.id.vig_result);


        String size = intent.getStringExtra("SIZE");
        cheese1.setText(size);
        String chesses = intent.getStringExtra("CHEESE");
        size1.setText(chesses);
        String meat = intent.getStringExtra("MEAT");
        meat1.setText(meat);

        String vig = intent.getStringExtra("VIG");
        vig1.setText(vig);

        button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, Order.class);


                startActivity(intent);
            }
        });


        button = (Button) findViewById(R.id.Back);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, CustomActivity.class);


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


