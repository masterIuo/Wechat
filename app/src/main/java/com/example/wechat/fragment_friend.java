package com.example.wechat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class fragment_friend extends Fragment {

    private RecyclerView recycleView;
    private List<String> data;
    private Context context;
    private Myadapter myadapter;

    public fragment_friend() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        recycleView = view.findViewById(R.id.RecycleView);
        data = new ArrayList<>();
        context = this.getActivity();
        for (int i=0;i<10;i++){
            data.add("这是第"+i+"行数据");
        }
        myadapter = new Myadapter(data,context);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(myadapter);

        return view;
    }
}