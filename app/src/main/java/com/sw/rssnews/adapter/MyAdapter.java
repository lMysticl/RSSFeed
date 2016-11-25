package com.sw.rssnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sw.rssnews.NewsDetail;
import com.sw.rssnews.model.FeedItem;
import com.sw.rssnews.R;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<FeedItem> feedItems;
    Context context;

    public MyAdapter(Context context,ArrayList<FeedItem> feedItems){
        this.feedItems = feedItems;
        this.context = context;
    }
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.custom_row_news_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view,context,feedItems);
        return holder;

    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        FeedItem current = feedItems.get(position);
        holder.Title.setText(current.getTitle());
        holder.Description.setText(current.getDescription());
        holder.Date.setText(current.getPubDate());
        Picasso.with(context).load(current.getThumbnailUrl()).into(holder.Thumbnail);
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView Title, Description, Date;
        ImageView Thumbnail;
        ArrayList<FeedItem> feedItems = new ArrayList<>();
        Context context;
        public MyViewHolder(View itemView,Context context, ArrayList<FeedItem> feedItems){
            super(itemView);
            this.feedItems = feedItems;
            this.context = context;
            itemView.setOnClickListener(this);
            Title = (TextView) itemView.findViewById(R.id.title_text);
            Description = (TextView) itemView.findViewById(R.id.description_text);
            Date = (TextView) itemView.findViewById(R.id.date_text);
            Thumbnail = (ImageView) itemView.findViewById(R.id.thumb_img);
        }

        @Override
        public void onClick(View view) {
            int position =getAdapterPosition();
            FeedItem feedItem = this.feedItems.get(position);
            Intent intent = new Intent(this.context, NewsDetail.class);
            intent.putExtra("Title",feedItem.getTitle());
            intent.putExtra("Description",feedItem.getDescription());
            intent.putExtra("Date",feedItem.getPubDate());
            intent.putExtra("Image",feedItem.getThumbnailUrl());
            intent.putExtra("Link",feedItem.getLink());
            this.context.startActivity(intent);

        }
    }


}
