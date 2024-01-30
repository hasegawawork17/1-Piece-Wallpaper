package wanpiece.wall.paper;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;


public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.WallpaperViewHolder> {

    private ArrayList<String> list;
    private Context context;

    public WallpaperAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_image_layout,parent,false);

        return new WallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Picasso.get().load(list.get(position)).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullImageActivity.class);
                intent.putExtra("Image",list.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

        public class WallpaperViewHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            public WallpaperViewHolder(@NonNull View itemView){
                super(itemView);

                imageView = itemView.findViewById(R.id.item_image);
            }


        }




}


