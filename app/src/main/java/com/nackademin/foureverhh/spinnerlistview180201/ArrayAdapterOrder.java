package com.nackademin.foureverhh.spinnerlistview180201;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ArrayAdapterOrder extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Intent intent;
    Spinner drink,temp;
    TextView txv;
    String[] tempSet1 = {"Iced","No ice","Warm"};
    String[] tempSet2 = {"Iced","No ice"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_order);

        txv = findViewById(R.id.order);
        drink = findViewById(R.id.drink);
        temp = findViewById(R.id.temp);

        drink.setOnItemSelectedListener(this);
        intent = getIntent();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String[] tempSet;

        if(position == 3) //Lemon is chosen
            tempSet = tempSet2;
        else
            tempSet = tempSet1;
        //Spinner's layout when it is not open android.R.layout.simple_spinner_item
        ArrayAdapter<String> temAd = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tempSet);

        //When spinner is open. the layout is like android.R.layout.simple_spinner_dropdown_item
        temAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        temp.setAdapter(temAd);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void showOrder(View view)
    {
        String order = drink.getSelectedItem()+" "+temp.getSelectedItem();
        txv.setText(order);
    }
}
