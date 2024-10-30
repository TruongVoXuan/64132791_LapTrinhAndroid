package com.example.recycleview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> songList;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position); // Add this method for delete functionality
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SongAdapter(Context context, List<Song> songList) {
        this.context = context;
        this.songList = songList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.tvSongName.setText(song.getName());
        holder.tvAuthorName.setText(song.getAuthor());

        // Load image with Picasso
        if (!TextUtils.isEmpty(song.getImageUrl())) {
            Picasso.get()
                    .load(song.getImageUrl())
                    .placeholder(R.drawable.default_image)
                    .error(R.drawable.default_image)
                    .into(holder.imgSong, new Callback() {
                        @Override
                        public void onSuccess() {
                            // Image loaded successfully
                        }

                        @Override
                        public void onError(Exception e) {
                            Toast.makeText(context, "Error loading image", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            holder.imgSong.setImageResource(R.drawable.default_image);
        }
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    // Method to remove item
    public void removeItem(int position) {
        if (position >= 0 && position < songList.size()) {
            songList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, songList.size());
        }
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView tvSongName, tvAuthorName;
        ImageView imgSong;
        ImageButton btnDelete;

        public SongViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            tvSongName = itemView.findViewById(R.id.tvSongName);
            tvAuthorName = itemView.findViewById(R.id.tvAuthorName);
            imgSong = itemView.findViewById(R.id.imgSong);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            // Set click listener for delete button
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }
}