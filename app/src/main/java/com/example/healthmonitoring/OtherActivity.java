package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OtherActivity extends AppCompatActivity {

    private static final String TAG = OtherActivity.class.getSimpleName();

    private EditText weightEdTxt;
    private EditText stepsEdTxt;
    private Button saveBtn;
    private ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        init();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"save");
                try {
                    double weight = Double.parseDouble(weightEdTxt.getText().toString());
                    long steps = Long.parseLong(stepsEdTxt.getText().toString());
                    Other other = new Other(weight,steps);
                    List<Other> list = new ArrayList<>();
                    list.add(other);
                    Toast.makeText(OtherActivity.this, R.string.save,Toast.LENGTH_LONG).show();
                }catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(OtherActivity.this, R.string.incorrect,Toast.LENGTH_LONG).show();
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
    }

    private void init() {
        weightEdTxt = findViewById(R.id.weightEdTxt);
        stepsEdTxt = findViewById(R.id.stepsEdTxt);
        saveBtn = findViewById(R.id.saveBtn3);
        backBtn = findViewById(R.id.backImVw3);

    }
}
