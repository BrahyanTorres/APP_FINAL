package com.brahyan.app_tienda.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brahyan.app_tienda.Domain.PopularDomain;
import com.brahyan.app_tienda.R;

import java.util.ArrayList;

public class ListAdapters extends RecyclerView.Adapter<ListAdapters.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context;

    public ListAdapters(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapters.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list,parent,false );
        context=parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapters.Viewholder holder, int position) {
    holder.titletxt.setText(items.get(position).getTitulo());
    holder.preciotxt.setText("$"+items.get(position).getPrecio());
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
        }
    }
}
