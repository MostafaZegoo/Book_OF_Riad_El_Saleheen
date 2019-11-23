package com.mostafa.book_of_riad_el_saleheen.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mostafa.book_of_riad_el_saleheen.R;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> list_name;

    private List<String> list_intro;

    private LayoutInflater mInflater;

    private ItemClickListener mClickListener;

    private String mTag;

    // data is passed into the constructor
    RecyclerViewAdapter(Context context, List<String> data, String tag) {

        this.mTag = tag;

        this.mInflater = LayoutInflater.from(context);

        this.list_name = data;

    }

    RecyclerViewAdapter(Context context, List<String> data, List<String> info, String tag) {

        this.mTag = tag;

        this.mInflater = LayoutInflater.from(context);

        this.list_name = data;

        this.list_intro = info;

    }

    // Involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = null;

        if (mTag.equals("chapters")) {

            view = mInflater.inflate(R.layout.chaptersrecyclerview, parent, false);

        } else if (mTag.equals("books")) {

            view = mInflater.inflate(R.layout.booksrecyclerview_row, parent, false);

        }


        return new ViewHolder(Objects.requireNonNull(view));

    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        if (mTag.equals("chapters")) {

            String name_data = list_name.get(position);
            String intro_data = list_intro.get(position);
            holder.name.setText(name_data);
            holder.chapter_intro.setText(intro_data);

        } else if (mTag.equals("books")) {

            String name_data = list_name.get(position);
            holder.name.setText(name_data);

        }

    }

    @Override
    public int getItemCount() {
        return list_name.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        TextView name, chapter_intro;

        @SuppressLint("WrongConstant")
        ViewHolder(@NonNull View itemView) {

            super(itemView);

            name = itemView.findViewById(R.id.name);

            chapter_intro = itemView.findViewById(R.id.chapter_intro);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition(), mTag);
        }

    }

    /*String getItem(int id) {
        return list_name.get(id);
    }*/

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position, String tag);
    }

}
