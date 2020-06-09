package com.example.studentsgestion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Students.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_students";
    private static final String COLUMN_ID = "uid";
    private static final String COLUMN_FIRSTNAME = "student_firstname";
    private static final String COLUMN_LASTNAME = "student_lastname";
    private static final String COLUMN_BRANCHE = "student_branche";
    private static final String COLUMN_GROUP = "student_group";

    // ABSENCE TABLE
    private static final String TABLE_NAME2 = "absence";
    private static final String COLUMN_ID2 = "aid";
    private static final String COLUMN_STUDENTID = "student_id";
    private static final String COLUMN_DATE = "absence_date";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ( "+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FIRSTNAME + " TEXT, "+ COLUMN_LASTNAME + " TEXT, "+ COLUMN_BRANCHE + " TEXT, " + COLUMN_GROUP + " TEXT ); ";
        db.execSQL(query);
        String query2 = "CREATE TABLE " + TABLE_NAME2 + " ( "+COLUMN_ID2+" INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_STUDENTID + " TEXT, "+ COLUMN_DATE + " TEXT ); ";
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
        onCreate(db);
    }

    void addStudent(String FirstName, String LastName, String Branch, String Group) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FIRSTNAME, FirstName);
        cv.put(COLUMN_LASTNAME, LastName);
        cv.put(COLUMN_BRANCHE, Branch);
        cv.put(COLUMN_GROUP, Group);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ajouté avec Succès", Toast.LENGTH_SHORT).show();
        }
    }

    void addAbsence(String studentid, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STUDENTID, studentid);
        cv.put(COLUMN_DATE, date);
        long result = db.insert(TABLE_NAME2, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Absence Ajouté", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllAbsences(String index) {
        String query2 = "SELECT * FROM " + TABLE_NAME2+ " WHERE "+ COLUMN_STUDENTID + " = "+index;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor2 = null;
        if (db != null) {
            cursor2 = db.rawQuery(query2, null);
        }
        return cursor2;
    }

    Cursor readAllAbsencesWithSearch(String index, String mois) {
        String query2 = "SELECT * FROM " + TABLE_NAME2+ " WHERE "+ COLUMN_STUDENTID + " = "+index + " AND "+COLUMN_DATE+ " LIKE '%/"+mois+"/%'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor2 = null;
        if (db != null) {
            cursor2 = db.rawQuery(query2, null);
        }
        return cursor2;
    }
}
