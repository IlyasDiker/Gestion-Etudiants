package com.example.studentsgestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class AddAbsenceActivity extends AppCompatActivity {

    EditText nomuser_field, date_field;
    Button saveabs_button;
    String id_user, name_user;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_absence);

        nomuser_field = findViewById(R.id.nomuser_field);
        date_field = findViewById(R.id.date_field);
        saveabs_button = findViewById(R.id.saveabs_button);
        if(getIntent().hasExtra("id")) {
            id_user = getIntent().getStringExtra("id");
            name_user = getIntent().getStringExtra("name");
            nomuser_field.setText(name_user);
        }

        saveabs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (date_field.length() == 10) {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(AddAbsenceActivity.this);
                    myDB.addAbsence(id_user.trim(), date_field.getText().toString().trim());
                } else {
                    Toast.makeText(AddAbsenceActivity.this,"Please enter a valid Date DD/MM/YYYY", LENGTH_LONG).show();
                }
            }
        });
    }
}
