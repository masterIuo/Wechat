package com.example.wechat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class fragment_friend extends Fragment {

    private RecyclerView recycleView;
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
        context = this.getActivity();
        String[] label = {"huawei", "Apple", "xiaomi"};
        String[] price = {"4399", "6799", "1299"};
        String[] config = {"128G", "256G", "512G"};
        int[] photos = {R.drawable.huawei, R.drawable.apple, R.drawable.xiaomi};
        Object[] activities = {info_huawei.class,info_apple.class,info_xiaomi.class};
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < label.length; i++) {
            Map<String, Object> listitem = new HashMap<String, Object>();
            listitem.put("品牌", label[i]);
            listitem.put("价格", price[i]);
            listitem.put("配置", config[i]);
            listitem.put("图片", photos[i]);
            listitem.put("详情",activities[i]);
            list.add(listitem);
        }

        myadapter = new Myadapter(list, context);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(myadapter);
        recycleView.addItemDecoration(new MyItemDecoration());
        recycleView.setHasFixedSize(true);


        return view;
    }

}