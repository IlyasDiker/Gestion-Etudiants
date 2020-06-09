package com.example.studentsgestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    MyDatabaseHelper myDB;

    TextView iduser, nomuser, nbabscence;
    String id_user, name_user, indexedVal;
    FloatingActionButton addabsence_button;

    RecyclerView recyclerView2;
    CustomLineAdapter customLineAdapter;

    ArrayList ids, students, dates;
    Spinner spinnermois;


    void getIntentData() {
        if(getIntent().hasExtra("id")  && getIntent().hasExtra("name")){
            id_user = getIntent().getStringExtra("id");
            name_user = getIntent().getStringExtra("name");

            filldata();
        } else {
            Toast.makeText(this, "No Data Selected", Toast.LENGTH_SHORT).show();
        }
    }

    void filldata() {
        iduser.setText(id_user);
        nomuser.setText(name_user);
        nbabscence.setText("Total Absences : "+"0");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        iduser = findViewById(R.id.iduser);
        nomuser = findViewById(R.id.nomuser);
        nbabscence = findViewById(R.id.nbabscence);
        recyclerView2 = findViewById(R.id.recyclerView2);
        addabsence_button = findViewById(R.id.addabsence_button);
        spinnermois = findViewById(R.id.spinnermois);

        ids = new ArrayList();
        students = new ArrayList();
        dates = new ArrayList();

        getIntentData();

        addabsence_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, AddAbsenceActivity.class);
                intent.putExtra("id", id_user);
                intent.putExtra("name", name_user);
                startActivity(intent);
            }
        });
        myDB = new MyDatabaseHelper(StudentActivity.this);

        StoreDataInArrays();

        if(ids.size()!=0) {
            customLineAdapter = new CustomLineAdapter(StudentActivity.this, ids, students ,dates);
            recyclerView2.setAdapter(customLineAdapter);
            recyclerView2.setLayoutManager(new LinearLayoutManager(StudentActivity.this));
        }

    }

    void StoreDataInArrays() {
        Cursor cursor;
        if (indexedVal == null || indexedVal.equals("Mois")){
            cursor =  myDB.readAllAbsences(id_user);
        } else {
            cursor =  myDB.readAllAbsencesWithSearch(id_user, indexedVal);
        }
        if(cursor.getCount() == 0){
            Toast.makeText(this,"Aucun Absence Trouver",Toast.LENGTH_LONG).show();
            //recyclerView2.setAdapter(null);
        }else{
            if (indexedVal == null){
                while (cursor.moveToNext()){
                    ids.add(cursor.getString(0).toString());
                    students.add(cursor.getString(1).toString());
                    dates.add(cursor.getString(2).toString());
                }
            } else {
                ids.clear();
                students.clear();
                dates.clear();

                while (cursor.moveToNext()){
                    ids.add(cursor.getString(0).toString());
                    students.add(cursor.getString(1).toString());
                    dates.add(cursor.getString(2).toString());
                }
            }
        }
        nbabscence.setText("Total Absence :"+ids.size());
    }

    public void refresh(View view) {
        indexedVal = spinnermois.getSelectedItem().toString();

        //Toast.makeText(this,"Searched Value : "+indexedVal ,Toast.LENGTH_SHORT).show();
        if (indexedVal.equals("Mois")){
            Toast.makeText(this,"Veuillez Selectioner un mois Valid" ,Toast.LENGTH_SHORT).show();
        } else {
            StoreDataInArrays();

            if(ids.size()!=0) {
                customLineAdapter = new CustomLineAdapter(StudentActivity.this, ids, students ,dates);
                recyclerView2.setAdapter(customLineAdapter);
                recyclerView2.setLayoutManager(new LinearLayoutManager(StudentActivity.this));
            }
        }

    }
}
