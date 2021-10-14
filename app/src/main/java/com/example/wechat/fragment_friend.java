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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        String[] label = {"huawei","Apple","xiaomi"};
        String[] price = {"4399","6799","1299"};
        String[] config = {"128G","256G","512G"};
        int[] photos = {R.drawable.huawei, R.drawable.apple, R.drawable.xiaomi};
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        for (int i=0;i<label.length;i++){
            Map<String,Object> listitem = new HashMap<String,Object>();
            listitem.put("品牌",label[i]);
            listitem.put("价格",price[i]);
            listitem.put("配置",config[i]);
            listitem.put("图片",photos[i]);
            list.add(listitem);
        }

        myadapter = new Myadapter(list,context);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(myadapter);
        recycleView.addItemDecoration(new MyItemDecoration());
        return view;
    }
}