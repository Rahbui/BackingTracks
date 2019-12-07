package com.example.api1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class linkAdapter extends RecyclerView.Adapter<linkAdapter.linkViewHolder> {


    public class linkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView linkText;
        ImageView thumbnail;

        linkViewHolder(View view){
            super(view);
            linkText = view.findViewById(R.id.title);
            thumbnail = view.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public linkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.from(parent.getContext()).inflate(R.layout.link_layout, parent, false);
        return new linkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(linkViewHolder holder, final int position) {
        String title = recylcerList.get(position).getTitle();
        String url = recylcerList.get(position).getThumbnailUrl();
        final String videoId = recylcerList.get(position).getId();
        Picasso.with(mContext).load(url).into(holder.thumbnail);

        holder.linkText.setText(title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(MainActivity.thisyouTubePlayer != null){
                        MainActivity.thisyouTubePlayer.release();
                        MainActivity.playVideo(videoId, MainActivity.youTubePlayerView);
                    }
                    else{
                        MainActivity.playVideo(videoId, MainActivity.youTubePlayerView);
                    }
                }
            });
    }


    Context mContext;
    ArrayList<youtubeLink> recylcerList;

    public linkAdapter(Context context, ArrayList<youtubeLink> linkList) {
        mContext = context;
        recylcerList = linkList;
    }

    @Override
    public int getItemCount() {
        return recylcerList.size();
    }


}
