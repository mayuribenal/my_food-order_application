package com.mayuri.foodorderapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mayuri.foodorderapplication.DetailActivity;
import com.mayuri.foodorderapplication.Models.MainModel;
import com.mayuri.foodorderapplication.R;

import java.util.ArrayList;

public class MainAdapters  extends  RecyclerView.Adapter<MainAdapters.viewholder>{

    ArrayList<MainModel> list;
    Context context;

    public MainAdapters(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood, parent,false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final MainModel model = list.get(position);
        holder.foodimage.setImageResource(model.getImage());
        holder.mainName.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("price",model.getPrice());
                intent.putExtra("desc",model.getDescription());
                intent.putExtra("name",model.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView foodimage ;
        TextView mainName,price,description;


        public viewholder(@NonNull View itemView) {
            super(itemView);


            foodimage = itemView.findViewById(R.id.imageview);
            mainName = itemView.findViewById(R.id.Name);
            price = itemView.findViewById(R.id.orderprice);
            description = itemView.findViewById(R.id.description);
        }
    }
}
