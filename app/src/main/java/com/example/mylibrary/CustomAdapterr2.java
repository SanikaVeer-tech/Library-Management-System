package com.example.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapterr2 extends RecyclerView.Adapter<CustomAdapterr2.MyViewHolder> implements Filterable {
    private Activity activity;
    private Context context;
    private ArrayList<String> book_id1;
    private ArrayList<String> username;
    private ArrayList<String> book_name;
    private ArrayList<String> days;
    private ArrayList<String> status;
    private ArrayList<String> filteredList2; // To store filtered items

    CustomAdapterr2(Activity activity,
                    Context context,
                    ArrayList<String> book_id1,
                    ArrayList<String> username,
                    ArrayList<String> book_name,
                    ArrayList<String> days,
                    ArrayList<String> status){
        this.activity = activity;
        this.context = context;
        this.book_id1 = book_id1;
        this.username = username;
        this.book_name = book_name;
        this.days = days;
        this.status = status;
        this.filteredList2 = new ArrayList<>(book_id1);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.book_id1_txt.setText(String.valueOf(position + 1));
        holder.username_txt.setText(String.valueOf(username.get(position)));
        holder.book_name_txt.setText(String.valueOf(book_name.get(position)));
        holder.no_of_days_txt.setText(String.valueOf(days.get(position)));
        holder.status_txt.setText(String.valueOf(status.get(position)));
    }



    @Override
    public int getItemCount() {
        return filteredList2.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String query1 = constraint.toString().toLowerCase();
                List<String> filtered = new ArrayList<>();

                if (query1.isEmpty()) {
                    filtered.addAll(username);
                } else {
                    for (int i = 0; i < username.size(); i++) {
                        if (username.get(i).toLowerCase().contains(query1)) {
                            filtered.add(username.get(i)); // Add username elements instead of book_id1
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filtered;
                return results;
            }


            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList2.clear();
                filteredList2.addAll((List<String>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView book_id1_txt, username_txt, book_name_txt, status_txt, no_of_days_txt;
        LinearLayout mainLayout1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id1_txt = itemView.findViewById(R.id.book_id_txt);
            username_txt = itemView.findViewById(R.id.username_input);
            book_name_txt = itemView.findViewById(R.id.book_name_input);
            no_of_days_txt = itemView.findViewById(R.id.days_input);
            //status_txt = itemView.findViewById(R.id.status_input);
            mainLayout1 = itemView.findViewById(R.id.mainLayout);
        }
    }
}