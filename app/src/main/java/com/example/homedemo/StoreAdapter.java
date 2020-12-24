package com.example.homedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Store> arrStore;

    public StoreAdapter(Context mContext, ArrayList<Store> arrStore) {
        this.mContext = mContext;
        this.arrStore = arrStore;
    }

    @NonNull
    @Override
    public StoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_store, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(arrStore.get(position).getName());
        holder.tvAddress.setText(arrStore.get(position).getAddress());
        holder.imageView.setImageResource(arrStore.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return arrStore.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvAddress;
        private ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
