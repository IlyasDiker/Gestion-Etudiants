package com.example.studentsgestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddActivity extends AppCompatActivity {

    EditText firstname_input, lastname_input;
    Spinner branch_input, group_input;
    Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        firstname_input = findViewById(R.id.fisrtname_input);
        lastname_input = findViewById(R.id.lastname_input);
        branch_input = findViewById(R.id.branch_input);
        group_input = findViewById(R.id.group_input);

        save_button = findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper( AddActivity.this);
                myDB.addStudent(firstname_input.getText().toString().trim(),
                        lastname_input.getText().toString().trim(),
                        branch_input.getSelectedItem().toString().trim(),
                        group_input.getSelectedItem().toString().trim());
            }
        });

    }


}
