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

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterr extends RecyclerView.Adapter<CustomAdapterr.MyViewHolder> implements Filterable {
    private Activity activity;
    private Context context;
    private ArrayList<String> book_id;
    private ArrayList<String> book_title;
    private ArrayList<String> book_author;
    private ArrayList<String> book_pages;
    private ArrayList<String> filteredList; // To store filtered items

    CustomAdapterr(Activity activity,
                   Context context,
                   ArrayList<String> book_id,
                   ArrayList<String> book_title,
                   ArrayList<String> book_author,
                   ArrayList<String> book_pages){
        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_pages = book_pages;
        this.filteredList = new ArrayList<>(book_id);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.book_id_txt.setText(String.valueOf(position + 1));
        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));
        holder.mainLayout.setOnClickListener((View)-> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("id", String.valueOf(book_id.get(position)));
            intent.putExtra("title", String.valueOf(book_title.get(position)));
            intent.putExtra("author", String.valueOf(book_author.get(position)));
            intent.putExtra("pages", String.valueOf(book_pages.get(position)));
            activity.startActivityForResult(intent, 1);
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String query = constraint.toString().toLowerCase();
                List<String> filtered = new ArrayList<>();

                if (query.isEmpty()) {
                    filtered.addAll(book_id);
                } else {
                    for (int i = 0; i < book_title.size(); i++) {
                        if (book_title.get(i).toLowerCase().contains(query)) {
                            filtered.add(book_id.get(i));
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList.clear();
                filteredList.addAll((List<String>) results.values);
                notifyDataSetChanged();
            }
        };
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            book_title_txt = itemView.findViewById(R.id.book_title_txt);
            book_author_txt = itemView.findViewById(R.id.book_author_txt);
            book_pages_txt = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
