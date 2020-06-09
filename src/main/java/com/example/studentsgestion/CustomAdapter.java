package com.example.studentsgestion;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList ids, firstnames, lastnames, branches, groups;

    int position;

    CustomAdapter(Context context,
                  ArrayList ids,
                  ArrayList firstnames,
                  ArrayList lastnames,
                  ArrayList branches,
                  ArrayList groups){
        this.context = context;
        this.ids = ids;
        this.firstnames = firstnames;
        this.lastnames = lastnames;
        this.branches = branches;
        this.groups = groups;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        this.position = position;
        holder.student_id_txt.setText(ids.get(position).toString());
        holder.student_name_txt.setText(firstnames.get(position).toString() + " " + lastnames.get(position).toString());
        holder.student_branch_txt.setText(branches.get(position).toString());
        holder.student_group_txt.setText(groups.get(position).toString());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, StudentActivity.class);
                intent1.putExtra("id", ids.get(position).toString());
                intent1.putExtra("name", (firstnames.get(position).toString() + " " + lastnames.get(position).toString()));
                context.startActivities(new Intent[]{intent1});
            }
        });
    }

    @Override
    public int getItemCount() {
        return ids.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView student_id_txt, student_name_txt, student_branch_txt, student_group_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            student_id_txt = itemView.findViewById(R.id.id_field);
            student_name_txt = itemView.findViewById(R.id.name_field);
            student_branch_txt = itemView.findViewById(R.id.filier_field);
            student_group_txt = itemView.findViewById(R.id.group_field);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
