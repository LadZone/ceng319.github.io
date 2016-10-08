package alay.lad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpecialDetails extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();




    TextView size1 = (TextView)findViewById(R.id.size_result);
    TextView cheese1 = (TextView)findViewById(R.id.cheese_result);
    TextView meat1 = (TextView)findViewById(R.id.mv_result);
    TextView vig1 = (TextView)findViewById(R.id.vig_result);




    String vig =intent.getStringExtra("SPECIAL");
    vig1.setText(vig);

        button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SpecialDetails.this, Order.class);


                startActivity(intent);
            }
        });


        button = (Button) findViewById(R.id.Back);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SpecialDetails.this, SpecialActivity.class);


                startActivity(intent);
            }
        });
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

}
