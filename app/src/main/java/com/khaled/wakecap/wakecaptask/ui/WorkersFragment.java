package com.khaled.wakecap.wakecaptask.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khaled.wakecap.wakecaptask.R;
import com.khaled.wakecap.wakecaptask.databinding.FragmentWorkersBinding;
import com.khaled.wakecap.wakecaptask.util.SimpleDividerItemDecoration;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class WorkersFragment extends Fragment {
    private String role = "";
    private WorkersViewModel workersViewModel;
    private WorkersAdapter workersAdapter = new WorkersAdapter();
    private static String ARG_ROLE = WorkersFragment.class.getName() + "ARG_ROLE";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            role = getArguments().getString(ARG_ROLE);
        } else {
            role = "";
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentWorkersBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_workers,
                container,
                false
        );

        binding.rvWorkers.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvWorkers.setAdapter(workersAdapter);
        binding.rvWorkers.addItemDecoration(new SimpleDividerItemDecoration(Objects.requireNonNull(getContext())));

        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            workersViewModel = ViewModelProviders.of(getActivity()).get(WorkersViewModel.class);
        }

        workersAdapter.submitList(workersViewModel.getWorkersPerRole(role));
    }

    public static WorkersFragment newInstance(String role) {
        WorkersFragment workersFragment = new WorkersFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_ROLE, role);
        workersFragment.setArguments(bundle);
        return workersFragment;
    }


}
