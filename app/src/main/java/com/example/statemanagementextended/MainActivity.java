package com.example.statemanagementextended;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String key_num = "num";

    private TextView text;
    private Button button;
    private EditText write;
    private CheckBox check;
    private Switch dark;
    private int num = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        button = findViewById(R.id.button);
        write = findViewById(R.id.write);
        check = findViewById(R.id.check);
        dark = findViewById(R.id.dark);

        if(savedInstanceState != null){
            num = savedInstanceState.getInt(key_num);
        }

        updateCountText();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                updateCountText();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(key_num, num);
    }

    private void updateCountText(){
        text.setText("Numer wciśnięć: " + num);
    }
}