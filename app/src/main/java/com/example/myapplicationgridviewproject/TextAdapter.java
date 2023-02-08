package com.example.myapplicationgridviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class TextAdapter extends BaseAdapter {


    private Context mContext;

    public TextAdapter(Context mContext) {
        this.mContext=mContext;
    }


    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;

        if (convertView == null) {
            grid = new View(mContext);
            //LayoutInflater inflater = getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            grid = inflater.inflate(R.layout.item, parent, false);
        } else {
            grid = (View) convertView;
        }

        TextView textView = (TextView) grid.findViewById(R.id.item_text_view);
        Person person = (Person) this.getItem(position);
        textView.setText(person.name);
        return grid;        

    }
}
