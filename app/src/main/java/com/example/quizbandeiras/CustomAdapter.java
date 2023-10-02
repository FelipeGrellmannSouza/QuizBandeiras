package com.example.quizbandeiras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList nome_usuario, pontos_usuario;

    CustomAdapter(Context context, ArrayList nome_usuario, ArrayList pontos_usuario){
        this.context = context;
        this.nome_usuario = nome_usuario;
        this.pontos_usuario = pontos_usuario;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_row, parent, false);

        //LayoutInflater inflater = LayoutInflater.from(context);
        //View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomeTextView.setText(String.valueOf(nome_usuario.get(position)));
        holder.pontosTextView.setText(String.valueOf(pontos_usuario.get(position)));
    }

    @Override
    public int getItemCount() {
        return nome_usuario.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nomeTextView, pontosTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeTextView = itemView.findViewById(R.id.nomeTextView);
            pontosTextView = itemView.findViewById(R.id.pontosTextView);
        }
    }
}
