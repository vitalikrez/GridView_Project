package com.example.myapplicationgridviewproject;

import static com.example.myapplicationgridviewproject.Person.persons;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private TextView mSelectText;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView countriesList = findViewById(R.id.gridview);
        ArrayAdapter<Person> adapter = new PersonAdapter(this);
        countriesList.setAdapter(adapter);

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        countriesList.startAnimation(animation);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Ви вибрали елемент "
                                + position,
                        Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this,MainActivityPersonInfo.class);
                intent.putExtra("id", position);
                MainActivity.this.startActivity(intent);

                //запуск анімації
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);

            }
        };
        countriesList.setOnItemClickListener(itemListener);

    }

    private class PersonAdapter extends ArrayAdapter<Person> {

        public PersonAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_2, persons);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Person person = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(android.R.layout.simple_list_item_2, null);
            }
            ((TextView) convertView.findViewById(android.R.id.text1))
                   .setText(person.name);

            return convertView;
        }
    }


}