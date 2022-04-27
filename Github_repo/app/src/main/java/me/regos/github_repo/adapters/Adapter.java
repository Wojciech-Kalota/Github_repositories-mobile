package me.regos.github_repo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import me.regos.github_repo.utils.OnClickListener;
import me.regos.github_repo.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private final String[] repositories;
    private final Context context;
    private final OnClickListener clickListener;


    public Adapter(Context ct, String[] names, OnClickListener onClickListener){
        context = ct;
        repositories = names;
        clickListener = onClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(repositories[position]);
    }

    @Override
    public int getItemCount() {
        return repositories.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;

        OnClickListener listener;

        public ViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            listener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(getAdapterPosition());
        }
    }


    public Context getContext() {
        return context;
    }

    public OnClickListener getClickListener() {
        return clickListener;
    }
}
