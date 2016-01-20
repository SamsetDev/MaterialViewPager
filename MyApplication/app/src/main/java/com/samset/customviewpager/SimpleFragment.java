package com.samset.customviewpager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samset.customviewpager.adapter.SimpleAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {
    private RecyclerView recyclerview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerview = (RecyclerView) inflater.inflate(R.layout.fragment_material_up_concept_fake_page, container, false);
        return recyclerview;
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerview.setAdapter(new SimpleAdapter(20));
    }

    public static Fragment getInstance() {
        return new SimpleFragment();
    }



}
