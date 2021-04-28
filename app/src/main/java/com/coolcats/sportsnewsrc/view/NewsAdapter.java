package com.coolcats.sportsnewsrc.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolcats.sportsnewsrc.R;
import com.coolcats.sportsnewsrc.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> newsList;
    private NewsDelegate newsDelegate;

    int count = 0;
    int count2 = 0;

    public interface NewsDelegate {
        void selectNews(News news);
    }

    public NewsAdapter(List<News> newsList, NewsDelegate newsDelegate) {
        this.newsList = newsList;
        this.newsDelegate = newsDelegate;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        Log.d("TAG_X", "viewHolder Created and inflated "+(++count));

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item_layout, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News item = newsList.get(position);
        Log.d("TAG_X", "viewHolder BOUND TO "+(++count2));
        holder.headlineTextView.setText(item.getHeadLine());
        holder.dateTextView.setText(item.getDate());

        holder.itemView.setOnClickListener(view -> {
            newsDelegate.selectNews(item);
        });
//        Glide.with(holder.itemView)
//                .setDefaultRequestOptions(RequestOptions.centerCropTransform())
//                .load( )

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView headlineTextView;
        TextView dateTextView;
        ImageView sportImageView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            headlineTextView = itemView.findViewById(R.id.headline_textview);
            dateTextView = itemView.findViewById(R.id.news_date);
            sportImageView = itemView.findViewById(R.id.sports_imageview);
        }
    }

}
