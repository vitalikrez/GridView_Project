package com.example.myapplicationgridviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private TextView mSelectText;
    public static Person persons[] = new Person[]
            {
                    new Person("Дмитро","12.12, 20.05, 13.09","Це давньогрецьке ім'я, яке означає\" присвячений богині Деметрі\" - богині родючості і землі. Ще одне значення імені - \"хлібороб\"."),
                    new Person("Ірина","05.04, 30.10","Ім'я Ірина має давньогрецьке походження. Найімовірніше, воно походить від імені \"Eirene\" (Ейрена), що належало давньогрецькій богині миру і спокою. Буквальне трактування значення цього імені звучить як \"мир і спокій\""),
                    new Person("Юлія","07.06","Має дві версії походження. За першою з них, ім'я прийшло до нас із Греції, де слово \"Іулія\" означало \"пухнаста\", \"хвиляста\", \"кучерява\". Друга ж гласить, що ім'я – латинського походження і трактується як \"липнева\" або \"з роду Юліїв\""),
                    new Person("Дмитро","12.12, 20.05, 13.09","Це давньогрецьке ім'я, яке означає\" присвячений богині Деметрі\" - богині родючості і землі. Ще одне значення імені - \"хлібороб\"."),
                    new Person("Дмитро","12.12, 20.05, 13.09","Це давньогрецьке ім'я, яке означає\" присвячений богині Деметрі\" - богині родючості і землі. Ще одне значення імені - \"хлібороб\"."),
                    new Person("Ірина","05.04, 30.10","Ім'я Ірина має давньогрецьке походження. Найімовірніше, воно походить від імені \"Eirene\" (Ейрена), що належало давньогрецькій богині миру і спокою. Буквальне трактування значення цього імені звучить як \"мир і спокій\"."),
                    new Person("Дмитро","12.12, 20.05, 13.09","Це давньогрецьке ім'я, яке означає\" присвячений богині Деметрі\" - богині родючості і землі. Ще одне значення імені - \"хлібороб\"."),
                    new Person("Юлія","07.06","Має дві версії походження. За першою з них, ім'я прийшло до нас із Греції, де слово \"Іулія\" означало \"пухнаста\", \"хвиляста\", \"кучерява\". Друга ж гласить, що ім'я – латинського походження і трактується як \"липнева\" або \"з роду Юліїв\""),
                    new Person("Дмитро","12.12, 20.05, 13.09","Це давньогрецьке ім'я, яке означає\" присвячений богині Деметрі\" - богині родючості і землі. Ще одне значення імені - \"хлібороб\"."),
                    new Person("Ірина","05.04, 30.10","Ім'я Ірина має давньогрецьке походження. Найімовірніше, воно походить від імені \"Eirene\" (Ейрена), що належало давньогрецькій богині миру і спокою. Буквальне трактування значення цього імені звучить як \"мир і спокій\"."),
                    new Person("Дмитро","12.12, 20.05, 13.09","Це давньогрецьке ім'я, яке означає\" присвячений богині Деметрі\" - богині родючості і землі. Ще одне значення імені - \"хлібороб\"."),
                    new Person("Юлія","07.06","Має дві версії походження. За першою з них, ім'я прийшло до нас із Греції, де слово \"Іулія\" означало \"пухнаста\", \"хвиляста\", \"кучерява\". Друга ж гласить, що ім'я – латинського походження і трактується як \"липнева\" або \"з роду Юліїв\""),
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView countriesList = findViewById(R.id.gridview);
        ArrayAdapter<Person> adapter = new PersonAdapter(this);
        countriesList.setAdapter(adapter);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Ви вибрали "
                                + position,
                        Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this,MainActivityPersonInfo.class);
                intent.putExtra("id", position);
                MainActivity.this.startActivity(intent);
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