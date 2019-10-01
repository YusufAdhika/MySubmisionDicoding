package com.example.mysubmisiondicoding;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListRumahAdatAdapter extends RecyclerView.Adapter<ListRumahAdatAdapter.ListViewHolder> {
    private ArrayList<Rumah> listRumah;

    public ListRumahAdatAdapter (ArrayList<Rumah>list){this.listRumah = list;}


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemerow_hero, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        Rumah rumah = listRumah.get(position);

        Glide.with(holder.itemView.getContext())
                .load(rumah.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(rumah.getName());
        holder.tvDetail.setText(rumah.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mh = new Intent(view.getContext(),DetailContent.class);
                mh.putExtra("objek",listRumah.get(position));
                view.getContext().startActivity(mh);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listRumah.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

}
