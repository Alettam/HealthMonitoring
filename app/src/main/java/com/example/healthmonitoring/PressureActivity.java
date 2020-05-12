package com.example.healthmonitoring;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class PressureActivity extends AppCompatActivity{

    private static final String TAG = PressureActivity.class.getSimpleName();

    private EditText lowerEdTxt;
    private EditText upperEdTxt;
    private EditText pulseEdTxt;
    private EditText dateEdTxt;
    private CheckBox tachBox;
    private Button saveBtn;
    private ImageView backBtn;
    private ImageView nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        init();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"save");
                boolean tachicardia = tachBox.isChecked();
                String date = dateEdTxt.getText().toString();
                try{
                    int lower = Integer.parseInt(lowerEdTxt.getText().toString());
                    int upper = Integer.parseInt(upperEdTxt.getText().toString());
                    int pulse = Integer.parseInt(pulseEdTxt.getText().toString());

                    List<Pressure> list = new ArrayList<>();
                    list.add(new Pressure(lower,upper,pulse,tachicardia,date));
                    Toast.makeText(PressureActivity.this, R.string.save,Toast.LENGTH_LONG).show();

                }catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(PressureActivity.this, R.string.incorrect,Toast.LENGTH_LONG).show();
                }finally {
                    lowerEdTxt.getText().clear();
                    upperEdTxt.getText().clear();
                    pulseEdTxt.getText().clear();
                    dateEdTxt.getText().clear();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"back");
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"next");
                Intent intent = new Intent(PressureActivity.this, OtherActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        lowerEdTxt = findViewById(R.id.lowerEdTxt);
        upperEdTxt = findViewById(R.id.upperEdTxt);
        pulseEdTxt = findViewById(R.id.pulseEdTxt);
        dateEdTxt = findViewById(R.id.dateEdTxt);
        tachBox = findViewById(R.id.tachBox);
        saveBtn = findViewById(R.id.saveBtn2);
        backBtn = findViewById(R.id.backImVw2);
        nextBtn = findViewById(R.id.nextImVw2);
    }
}
