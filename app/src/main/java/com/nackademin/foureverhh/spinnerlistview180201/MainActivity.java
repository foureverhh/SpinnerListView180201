package com.nackademin.foureverhh.spinnerlistview180201;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;  //Declare a text view
    Spinner tickets,times;    //Declare a spinner
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);  //initialize the text view object
        tickets  = findViewById(R.id.spinnerTicket); //initialize the spinner object
        times =findViewById(R.id.spinnerTime);
        textView.setOnClickListener(this);
    }

    public void order(View view)
    {
        //Through getResource().getStringArray(R.array.tickets) to get the tickets array in XML
        String[] ticketType = getResources().getStringArray(R.array.tickets);
        //through getSelectedItemPosition() to get the selected item in the spinner
        int idxTicket = tickets.getSelectedItemPosition();

        String[] ticketTime =getResources().getStringArray(R.array.time);
        int idxTime = times.getSelectedItemPosition();

        textView.setText("Order the kind of "+ticketType[idxTicket]+" and "+ticketTime[idxTime]+" tickets");
        intent = new Intent(this,SportConsumer.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        intent = new Intent(this,PlaceOrder.class);
        startActivity(intent);
    }
}
