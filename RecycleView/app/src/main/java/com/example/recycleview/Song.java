package com.example.recycleview;

public class Song {
    private String name;
    private String author;
    private String imageUrl;

    public Song(String name, String author, String imageUrl) {
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
