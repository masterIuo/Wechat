package com.example.wechat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    private View itemView;
    private Context context;
    private List<Map<String, Object>> data;

    public Myadapter(List<Map<String, Object>> data, Context context) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.label.setText("品牌:" + Objects.requireNonNull(data.get(position).get("品牌")).toString());
        holder.config.setText("配置:" + Objects.requireNonNull(data.get(position).get("配置")).toString());
        holder.price.setText("价格:" + Objects.requireNonNull(data.get(position).get("价格")).toString());
        holder.photo.setImageResource((Integer) data.get(position).get("图片"));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, (Class<?>) data.get(position).get("详情"));
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView label, config, price;
        ImageView photo;
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.Label);
            config = itemView.findViewById(R.id.Config);
            price = itemView.findViewById(R.id.Price);
            photo = itemView.findViewById(R.id.photo);
            button = itemView.findViewById(R.id.button);
        }
    }

}
