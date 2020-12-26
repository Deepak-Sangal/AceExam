package com.acexams.aceexam.activity.adpater;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acexams.aceexam.activity.modal.Datum;

import java.util.List;

public class ExamListAdapter extends RecyclerView.Adapter<ExamListAdapter.MyHolder> {

    private List<Datum> list;

    public ExamListAdapter(List<Datum> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
