package com.khaled.wakecap.wakecaptask.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.khaled.wakecap.wakecaptask.R;
import com.khaled.wakecap.wakecaptask.databinding.ListItemWorkerBinding;
import com.khaled.wakecap.wakecaptask.network.model.Worker;
import com.khaled.wakecap.wakecaptask.util.DataBoundListAdapter;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;

public class WorkersAdapter extends DataBoundListAdapter<Worker, ListItemWorkerBinding> {

    WorkersAdapter() {
        super(new DiffUtil.ItemCallback<Worker>() {

            @Override
            public boolean areItemsTheSame(@NonNull Worker oldItem, @NonNull Worker newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Worker oldItem, @NonNull Worker newItem) {
                return oldItem.getAttributes().getFirstName().equals(newItem.getAttributes().getFirstName())
                        && oldItem.getAttributes().getLastName().equals(newItem.getAttributes().getLastName())
                        && oldItem.getAttributes().getFullName().equals(newItem.getAttributes().getFullName());
            }
        });
    }

    @NotNull
    @Override
    protected ListItemWorkerBinding createBinding(@NotNull ViewGroup parent) {
        return DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_worker,
                parent,
                false
        );
    }

    @Override
    protected void bind(@NotNull ListItemWorkerBinding binding, Worker item) {
        binding.setWorker(item);
    }
}
