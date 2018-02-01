package com.nackademin.foureverhh.spinnerlistview180201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;  //Declare a text view
    Spinner tickets;    //Declare a spinner
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);  //initialize the text view object
        tickets  = findViewById(R.id.spinner); //initialize the spinner object
    }

    public void order(View view)
    {
        //Through getResource().getStringArray(R.array.tickets) to get the tickets array in XML
        String[] ticketType = getResources().getStringArray(R.array.tickets);
        //through getSelectedItemPosition() to get the selected item in the spinner
        int index = tickets.getSelectedItemPosition();

        textView.setText("Order the kind of "+ticketType[index]+" tickets");
    }
}
