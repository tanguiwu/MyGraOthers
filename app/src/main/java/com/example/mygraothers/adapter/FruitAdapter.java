package com.example.mygraothers.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mygraothers.R;
import com.example.mygraothers.bean.AccountItemInfo;
import com.example.mygraothers.bean.Fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> listData;
    private Context mContext;
    private LayoutInflater mIflater;
    private OnItemClickListener listener;


    public FruitAdapter(Context mContext, List<Fruit> listData, OnItemClickListener listener) {
        this.mContext = mContext;
        this.listData = listData;
        this.mIflater = LayoutInflater.from(mContext);
        this.listener = listener;

    }

    @NonNull
    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_itemlayout, parent, false);
        ViewHolder holder = new ViewHolder(view);

//        holder.fruitView.setOnClickListener(new View.OnClickListener()) {
//            @Override
//            public void onClick (View view){
//                int position = holder.getAdapterPosition();
//                Intent intent = new Intent(view.getContext(), DetailActivity; class);
//                intent.putExtra("myposition", mFruitlist.get(position));
//                view.getContext().startActivity(intent);
//
//            }
//        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.ViewHolder holder, final int position) {
        Fruit fruit = listData.get(position);
        Glide.with(mContext).load(fruit.getImageId()).into(holder.fruitImage);
//        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        holder.fruitIn.setText(fruit.getIntro());
        holder.fruitPrice.setText(fruit.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onItemClicked(position,v);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (listData == null)
            return 0;
        return listData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        View fruitview;
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitIn;
        TextView fruitPrice;

        public ViewHolder(View view) {
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruitImg);
            fruitName = (TextView) view.findViewById(R.id.fruitName);
            fruitIn = (TextView) view.findViewById(R.id.fruitIntroduce);
            fruitPrice = (TextView) view.findViewById(R.id.fruitPrice);


        }
    }

    public interface OnItemClickListener {
        void onItemClicked(int position, View v);
    }
}
