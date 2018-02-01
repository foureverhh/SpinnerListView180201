package com.nackademin.foureverhh.spinnerlistview180201;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SportConsumer extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Intent intent;
    Double[] energyConsumption ={1.1,2.2,3.3};
    EditText weight,time;
    TextView total,txvRate;
    Spinner sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_consumer);

        intent = getIntent();

      weight = findViewById(R.id.weight);
        time  = findViewById(R.id.timeSpan);
        total = findViewById(R.id.total);
        txvRate = findViewById(R.id.txvRate);
        sport = findViewById(R.id.spinnerSport);
        sport.setOnItemSelectedListener(this);//setOnItemClickListener

    }



    public void calc (View view)
    {
        double w = Double.parseDouble(weight.getText().toString());
        double t = Double.parseDouble(time.getText().toString());

        int idxSelected = sport.getSelectedItemPosition();

        double selectedConsumption = energyConsumption[idxSelected];

        double totalConsumption = w*t*selectedConsumption;

        total.setText("Energy consumption is: "+totalConsumption);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        txvRate.setText(String.valueOf(energyConsumption[position]));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
