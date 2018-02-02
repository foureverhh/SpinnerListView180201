package com.nackademin.foureverhh.spinnerlistview180201;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CinemaTicketOrder extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ArrayList<String> selected = new ArrayList<>();
    Intent intent;
    TextView textOrder;
    ListView lvTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_ticket_order);

        intent = getIntent();
        textOrder = findViewById(R.id.textOrder);
        lvTicket = findViewById(R.id.lvTicket);

        lvTicket.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



        TextView ticketItem = (TextView) view; //To get the information conveyed by the item, transform it to the type of TextView
        String ticketSelected = ticketItem.getText().toString();

        if(selected.contains(ticketSelected))
        {
            selected.remove(ticketSelected);
        }else
        {
            selected.add(ticketSelected);
        }

        String msg;
        if(selected.size()>0)
        {
            msg="You have chose: ";
            for(String str: selected)
            {
                msg += " "+str;
            }
        }else
            msg = "Choose your ticket";

        textOrder.setText(msg);
    }
}
