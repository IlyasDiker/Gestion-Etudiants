package com.example.studentsgestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> ids, firstnames, lastnames, branches, groups;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        ids = new ArrayList<>();
        firstnames = new ArrayList<>();
        lastnames = new ArrayList<>();
        branches = new ArrayList<>();
        groups = new ArrayList<>();

        StoreDataInArrays();
        if(ids.size()!=0) {
            customAdapter = new CustomAdapter(MainActivity.this, ids, firstnames, lastnames, branches, groups);
            recyclerView.setAdapter(customAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        }
    }

    void StoreDataInArrays() {
        Cursor cursor =  myDB.readAllData();
        int test = cursor.getCount();
        if(test == 0){
            Toast.makeText(this,"Aucun Utilisateur Trouver",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                ids.add(cursor.getString(0));
                firstnames.add(cursor.getString(1));
                lastnames.add(cursor.getString(2));
                branches.add(cursor.getString(3));
                groups.add(cursor.getString(4));
            }
        }
    }
}
