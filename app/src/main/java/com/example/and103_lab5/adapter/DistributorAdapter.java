package com.example.and103_lab5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and103_lab5.databinding.ItemDistributorBinding;
import com.example.and103_lab5.model.Distributor;

import java.util.ArrayList;

public class DistributorAdapter extends RecyclerView.Adapter<DistributorAdapter.ViewHolder> {
    private ArrayList<Distributor> list;
    private Context context;
    private DistributorClick distributorClick;

    public DistributorAdapter(ArrayList<Distributor> list, Context context, DistributorClick distributorClick) {
        this.list = list;
        this.context = context;
        this.distributorClick = distributorClick;
    }

    public interface DistributorClick {
        void delete(Distributor distributor);
        void edit(Distributor distributor);
    }

    @NonNull
    @Override
    public DistributorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDistributorBinding binding = ItemDistributorBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DistributorAdapter.ViewHolder holder, int position) {
        Distributor distributor = list.get(position);
        holder.binding.tvName.setText(distributor.getName());
        holder.binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distributorClick.delete(distributor);
            }
        });

        holder.binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distributorClick.edit(distributor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemDistributorBinding binding;
        public ViewHolder(ItemDistributorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
