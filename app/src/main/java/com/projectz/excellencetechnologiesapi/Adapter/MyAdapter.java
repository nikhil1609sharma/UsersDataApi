package com.projectz.excellencetechnologiesapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.projectz.excellencetechnologiesapi.Model.UserModel;
import com.projectz.excellencetechnologiesapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



    private final List<UserModel.data> list;
    private Context context;

    public MyAdapter(List<UserModel.data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getFirst_name());
        holder.textView1.setText(list.get(position).getLast_name());
        holder.textView2.setText(list.get(position).getEmail());
        Picasso.get().load(list.get(position).getAvatar()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView,textView1,textView2;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtFirst);
            textView1 = itemView.findViewById(R.id.txtLast);
            textView2 = itemView.findViewById(R.id.txtEmail);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }

}
