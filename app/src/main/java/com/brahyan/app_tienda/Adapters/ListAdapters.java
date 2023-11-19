package com.brahyan.app_tienda.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brahyan.app_tienda.Activity.HomeActivity;
import com.brahyan.app_tienda.Domain.PopularDomain;
import com.brahyan.app_tienda.R;

import java.util.ArrayList;

public class ListAdapters extends RecyclerView.Adapter<ListAdapters.Viewholder> {
    ArrayList<PopularDomain> items;
    Context contexto;

    public ListAdapters(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ListAdapters.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list,parent,false );
        contexto=parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, @SuppressLint("RecyclerView") int position) {
    holder.titletxt.setText(items.get(position).getTitulo());
    holder.preciotxt.setText("$"+items.get(position).getPrecio());

        holder.itemView.getResources().getIdentifier(items.get(position).getImg(),
                "drawable", holder.itemView.getContext().getPackageName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(holder.itemView.getContext(), HomeActivity.class);
                intent.putExtra("object", items.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView titletxt, preciotxt;
        ImageView img;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            titletxt=itemView.findViewById(R.id.titletxt);
            preciotxt=itemView.findViewById(R.id.preciotxt);
            img=itemView.findViewById(R.id.pic1);
        }
    }
}
