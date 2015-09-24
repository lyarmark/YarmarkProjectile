package com.example.leahyarmark.Yarmark.projectile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    private Button button1;

    private double angle;
    private double velocity;
    private double time;
    private double radians;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            textView1 = (TextView) findViewById(R.id.text1);
            editText1 = (EditText) findViewById(R.id.editText1);
            angle = Double.parseDouble(editText1.getText().toString());

            textView2 = (TextView) findViewById(R.id.text2);
            editText2 = (EditText) findViewById(R.id.editText2);
            velocity = Double.parseDouble(editText2.getText().toString());

            textView3 = (TextView) findViewById(R.id.text3);
            editText3 = (EditText) findViewById(R.id.editText3);
            time = Double.parseDouble(editText3.getText().toString());

        } catch (
                NumberFormatException e
                ) {
        }

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(calculate());
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

    public String calculate() {
        radians = Math.toRadians(angle);
        double x = Math.sin(radians) * velocity * time;
        double y = Math.cos(radians) * velocity * time - (.5 * 9.8 * time * time);
        return "(" + x + ", " + y + ")";
    }
}