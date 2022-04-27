package me.regos.github_repo.adapters;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.regos.github_repo.R;
import me.regos.github_repo.utils.OnClickListener;

public class AdapterLanguages extends RecyclerView.Adapter<AdapterLanguages.ViewHolder> {


    private final List<Pair<String, String>> languages;
    private final Context context;
    private final OnClickListener clickListener;


    public AdapterLanguages(Context ct, List<Pair<String, String>> names, OnClickListener onClickListener){
        context = ct;
        languages = names;
        clickListener = onClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_languages, parent, false);
        return new ViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(languages.get(position).first);
        holder.textView2.setText(languages.get(position).second);

    }

    @Override
    public int getItemCount() {
        return languages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        TextView textView2;

        OnClickListener listener;

        public ViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
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
