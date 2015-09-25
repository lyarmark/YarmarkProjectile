package com.example.leahyarmark.Yarmark.projectile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    private Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        //Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);

        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);
        textView4 = (TextView) findViewById(R.id.text4);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);


        button1 = (Button) findViewById(R.id.button1);


        button1.setOnClickListener(new View.OnClickListener() {

            double angle = Double.parseDouble(editText1.getText().toString());
            double velocity = Double.parseDouble(editText2.getText().toString());
            double time = Double.parseDouble(editText3.getText().toString());

            final Projectile p = new Projectile(angle, velocity, time);

            @Override
            public void onClick(View v) {
                textView4.setText("(" + p.getX() + ", " + p.getY() + ")");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}