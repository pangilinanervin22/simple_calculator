package com.example.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;


public class RestoreListAdapter extends RecyclerView.Adapter<RestoreListAdapter.ViewHolder> {

    public LinkedList<ListRestore> itemLinkedList = new LinkedList<>();

    private Context context;

    public RestoreListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restore_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_listItem.setText(itemLinkedList.get(position).getPrevious_text());
        holder.answer_listItem.setText(String.format("ans : %s", itemLinkedList.get(position).getAnswer_text()));
        holder.position.setText(String.valueOf(position + 1));

        holder.text_listItem.setOnClickListener(v -> {
            String temp = String.valueOf(holder.text_listItem.getText());
            MainActivity.currentString = "";
            MainActivity.setCurrentString(temp);
        });

        holder.answer_listItem.setOnClickListener(v -> {
            String temp = String.valueOf(holder.answer_listItem.getText());
            MainActivity.currentString = "";
            MainActivity.setCurrentString(temp.replaceAll("[ans :]", ""));
        });

    }

    @Override
    public int getItemCount() {
        return itemLinkedList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView text_listItem, answer_listItem, position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_listItem = itemView.findViewById(R.id.text_listItem);
            answer_listItem = itemView.findViewById(R.id.answer_listItem);
            position = itemView.findViewById(R.id.position_item);
        }
    }

    public void setItemLinkedList(LinkedList<ListRestore> itemLinkedList) {
        this.itemLinkedList = itemLinkedList;
        notifyDataSetChanged();
    }


}
