package com.example.swipedeleterecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Model> models;
    Context context;

    public MyAdapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        Model model= models.get(position);
        holder.title.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public RelativeLayout viewForeground,viewBackground;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            viewBackground=itemView.findViewById(R.id.view_background);
            viewForeground=itemView.findViewById(R.id.view_foreground);
        }
    }

    public void remove(int position){
        models.remove(position);
        notifyItemRemoved(position);
    }
}
