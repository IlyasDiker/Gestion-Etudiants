package com.example.studentsgestion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomLineAdapter extends RecyclerView.Adapter<CustomLineAdapter.MyViewHolder> {

    Context context;
    ArrayList ids, students, dates;


    int position;

    CustomLineAdapter(Context context,
                      ArrayList ids,
                      ArrayList students,
                      ArrayList dates){
        this.context = context;
        this.ids = ids;
        this.students = students;
        this.dates = dates;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        this.position = position;
        holder.absence_id_txt.setText(ids.get(position).toString());
        holder.student_id_txt.setText(students.get(position).toString());
        holder.absence_date.setText(dates.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return ids.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView absence_id_txt, student_id_txt, absence_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            absence_id_txt = itemView.findViewById(R.id.id_fieldab);
            student_id_txt = itemView.findViewById(R.id.makayench);
            absence_date = itemView.findViewById(R.id.date_field);
        }
    }
}
