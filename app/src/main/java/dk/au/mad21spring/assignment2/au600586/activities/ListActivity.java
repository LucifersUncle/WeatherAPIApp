package dk.au.mad21spring.assignment2.au600586.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import dk.au.mad21spring.assignment2.au600586.R;

public class ListActivity extends AppCompatActivity {

    Button exitBtn, addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        exitBtn = findViewById(R.id.exitBtn);
        addBtn = findViewById(R.id.addBtn);

        //Creates events when buttons are clicked
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListActivity.this, "exit clicked", Toast.LENGTH_SHORT).show();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListActivity.this, "add clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}