package com.vivek.myfirsttask;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Activity context;
    private List<Product> productArrayList;

    public MyAdapter(Activity context, List<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product currentItem = productArrayList.get(position);
        holder.title.setText(currentItem.getTitle());

        Picasso.get().load(currentItem.getThumbnail()).into(holder.image);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ShapeableImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.productTitle);
            image = itemView.findViewById(R.id.productImage);
        }
    }
}

