package com.example.leahyarmark.Yarmark.projectile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView answer;
    private EditText editTextAngle;
    private EditText editTextVelocity;
    private EditText editTextTime;
    private ImageView image;
    private Button button1;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);
        Picasso.with(this).load("http://www.afs.org/blog/icl/wp-content/uploads/2014/08/smile.jpg")
                .placeholder(R.drawable.projectile_img)
                .into(image);

        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);

        editTextAngle = (EditText) findViewById(R.id.editTextAngle);
        editTextVelocity = (EditText) findViewById(R.id.editTextVelocity);
        editTextTime = (EditText) findViewById(R.id.editTextTime);

        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MainActivity.this.showAnswer();
            }
        });
        sharedPreferences = this.getSharedPreferences("DEFAULT", MODE_PRIVATE);
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

    public void showAnswer() {

        double angle = Double.parseDouble(editTextAngle.getText().toString());
        double velocity = Double.parseDouble(editTextVelocity.getText().toString());
        double time = Double.parseDouble(editTextTime.getText().toString());

        Intent intent = new Intent(this, AnswerActivity.class);

        //send the angle, velocity, time to the intent
        intent.putExtra("Angle", angle);
        intent.putExtra("Velocity", velocity);
        intent.putExtra("Time", time);

        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        //blank is default so hint text will show
        //if there's stored data, that will show instead
        editTextAngle.setText(sharedPreferences.getString("ANGLE", ""));
        editTextVelocity.setText(sharedPreferences.getString("VELOCITY", ""));
        editTextTime.setText(sharedPreferences.getString("TIME", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ANGLE", editTextAngle.getText().toString());
        editor.putString("VELOCITY", editTextVelocity.getText().toString());
        editor.putString("TIME", editTextTime.getText().toString());

        editor.apply();
    }
}
