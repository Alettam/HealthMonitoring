package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText nameEdTxt;
    private EditText ageEdTxt;
    private Button saveBtn;
    private ImageView backImVw;
    private ImageView nextImVw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"save");
                String  ageStr = ageEdTxt.getText().toString();
                try {
                    int age = Integer.parseInt(ageStr);
                    User user1 = new User(nameEdTxt.getText().toString(),age);
                    Toast.makeText(MainActivity.this, R.string.save,Toast.LENGTH_LONG).show();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_LONG).show();
                }

            }
        });

        backImVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"back");
                finish();
            }
        });

        nextImVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"next");
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });


    }

    private void init(){
        nameEdTxt = findViewById(R.id.loginEdText);
        ageEdTxt = findViewById(R.id.ageEdText);
        saveBtn = findViewById(R.id.saveBtn);
        backImVw = findViewById(R.id.backImVw);
        nextImVw = findViewById(R.id.nextImVw);
    }
}
