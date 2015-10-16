package com.example.leahyarmark.Yarmark.projectile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by student1 on 10/15/2015.
 */
public class AnswerActivity extends AppCompatActivity {
    //convention is to have the name of an activity end with 'activity'
//all activities have to extend AppCompatActivity
    //and need an onCreate method

    //this activity will display the answer
    //(main activity will display everything else)

    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Intent intent = getIntent();
        double angle = intent.getDoubleExtra("Angle", 0.0);
        double velocity = intent.getDoubleExtra("Velocity", 0.0);
        double time = intent.getDoubleExtra("Time", .0);

        answer = (TextView) findViewById(R.id.answer);
        //for every activity in the app, need it in the manifest
    }
}
