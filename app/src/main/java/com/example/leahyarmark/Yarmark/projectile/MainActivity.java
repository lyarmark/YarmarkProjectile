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

    private TextView angleView;
    private TextView velocityView;
    private TextView timeView;
    private TextView answerView;
    private EditText angleEdit;
    private EditText velocityEdit;
    private EditText timeEdit;

    private Button calculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);

        angleView = (TextView) findViewById(R.id.text1);
        velocityView = (TextView) findViewById(R.id.text2);
        timeView = (TextView) findViewById(R.id.text3);
        answerView = (TextView) findViewById(R.id.text4);

        calculateButton = (Button) findViewById(R.id.button1);

        calculateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                angleEdit = (EditText) findViewById(R.id.editText1);
                velocityEdit = (EditText) findViewById(R.id.editText2);
                timeEdit = (EditText) findViewById(R.id.editText3);

                double angle = Double.parseDouble(angleEdit.getText().toString());
                double velocity = Double.parseDouble(velocityEdit.getText().toString());
                double time = Double.parseDouble(timeEdit.getText().toString());

                final Projectile p = new Projectile(angle, velocity, time);
                answerView.setText("(" + p.getX() + ", " + p.getY() + ")");
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