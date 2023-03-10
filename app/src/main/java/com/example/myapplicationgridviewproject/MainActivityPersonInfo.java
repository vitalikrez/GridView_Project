package com.example.myapplicationgridviewproject;

import static com.example.myapplicationgridviewproject.Person.persons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivityPersonInfo extends AppCompatActivity {

    private TextView textInfo, textDate, textDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_person_info);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");

        textInfo = findViewById(R.id.info);
        textInfo.setText(textInfo.getText() + " " + persons[position].name);


        textDate = findViewById(R.id.date);
        textDate.setText(textDate.getText() + " " + persons[position].dateOfName);

        textDesc = findViewById(R.id.desc);
        textDesc.setText(textDesc.getText() + " " + persons[position].description);



        Animation animRotateIn_icon = AnimationUtils.loadAnimation(this,
                R.anim.rotate);

        textInfo.startAnimation(animRotateIn_icon);
        textDate.startAnimation(animRotateIn_icon);
        textDesc.startAnimation(animRotateIn_icon);

    }
}