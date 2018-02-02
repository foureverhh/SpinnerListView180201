package com.nackademin.foureverhh.spinnerlistview180201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceOrder extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Make a ArrayList to contain all the items which have been ordered.
    ArrayList<String> selected = new ArrayList<>();
    ListView menu;
    TextView msgTxv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        //Initialise the ListView
        menu = findViewById(R.id.menu);
        msgTxv = findViewById(R.id.msgTxv);
        //Make menu listen to the clicking
        menu.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Let the item to be clicked to be a TextView type so that to get the information it carries
        TextView txv = (TextView) view;
        //Get the information of the clicked item
        String item = txv.getText().toString();

        //Formula the order placed
        if(selected.contains(item))
            selected.remove(item);
        else
            selected.add(item);

        //
        String msg;
        if(selected.size()>0)
        {
            msg="You have ordered";
            for(String str:selected)
                msg +=" "+str;
        }else
        {
            msg="Please place your order";
        }

        msgTxv.setText(msg);

    }
}
