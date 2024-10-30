package com.example.recycleview;

import android.net.Uri;
public class Song {
    private String name;
    private String author;
    private int imageResId; // ID tài nguyên nội bộ của ảnh

    public Song(String name, String author, int imageResId) {
        this.name = name;
        this.author = author;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getImageResId() {
        return imageResId;
    }

}
