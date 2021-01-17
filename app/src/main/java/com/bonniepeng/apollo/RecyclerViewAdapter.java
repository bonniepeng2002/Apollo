package com.bonniepeng.apollo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Map<String, String>> logs = new ArrayList<>();
    private Context context;
    private final String TAG = "ADAPTER INFLATE";
    private RecyclerOnItemClick recyclerOnItemClick;


    public RecyclerViewAdapter(Context context, RecyclerOnItemClick recyclerOnItemClick) {
        this.context = context;
        this.recyclerOnItemClick = recyclerOnItemClick;
    }

    public RecyclerViewAdapter() {

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.log_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view, recyclerOnItemClick);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Map<String, String> currentLog = logs.get(i);
        Log.i(TAG, currentLog.toString());

        // SETTING DISPLAY INFO
        String date = currentLog.get("date"); // get value with key "sciName"
        String keywords = currentLog.get("keywords");

        viewHolder.txtKeyword.setText(keywords);
        viewHolder.txtDate.setText(date);

    }

    @Override
    public int getItemCount() {
        return logs.size();
    }

    public void setLogs(ArrayList<Map<String, String>> logs) {
        this.logs = logs;
        notifyDataSetChanged();

        Log.i("IN SET LOGS", logs.toString());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView txtDate;
        private final TextView txtKeyword;
        RecyclerOnItemClick recyclerOnItemClick;


        public ViewHolder(@NonNull View itemView, RecyclerOnItemClick recyclerOnItemClick) {
            super(itemView);
            txtDate = itemView.findViewById(R.id.txtDates);
            txtKeyword = itemView.findViewById(R.id.txtKeywords);

            this.recyclerOnItemClick = recyclerOnItemClick;
            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View view) {
            recyclerOnItemClick.onClick(view, getAdapterPosition());
        }
    }
}