package com.bonniepeng.apollo.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bonniepeng.apollo.LogView;
import com.bonniepeng.apollo.R;
import com.bonniepeng.apollo.RecyclerOnItemClick;
import com.bonniepeng.apollo.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DashboardFragment extends Fragment implements RecyclerOnItemClick {

    private DashboardViewModel dashboardViewModel;
    private ArrayList<Map<String, String>> logs = new ArrayList<>();
    private Map<String, String> item1 = new HashMap<>();
    private Map<String, String> item2 = new HashMap<>();
    private Map<String, String> item3 = new HashMap<>();
    private Map<String, String> item4 = new HashMap<>();
    private Map<String, String> item5 = new HashMap<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });


        return root;
    }

    @Override
    public void onClick(View view, int position) {
        Map<String, String> currentLog = logs.get(position);
        Intent intent = new Intent(getActivity(), LogView.class);
        intent.putExtra("date", currentLog.get("date"));
        intent.putExtra("keywords", currentLog.get("keywords"));
        startActivity(intent);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        item1.put("date", "2021-01-17");
        item2.put("date", "2021-01-16");
        item3.put("date", "2021-01-15");
        item4.put("date", "2021-01-14");
        item5.put("date", "2021-01-13");
        item1.put("keywords", "Aching, Fever");
        item2.put("keywords", "Severe BDE");
        item3.put("keywords", "Cough, Stuffy Nose");
        item4.put("keywords", "Heart Attack, Leg Fell Off");
        item5.put("keywords", "Big Brains, Monkey Mode");

        logs.add(item1);
        logs.add(item2);
        logs.add(item3);
        logs.add(item4);
        logs.add(item5);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), this);
        RecyclerView recycler = requireView().findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        adapter.setLogs(logs);
    }
}