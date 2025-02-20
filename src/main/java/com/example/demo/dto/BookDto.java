package com.example.demo.dto;

import java.util.UUID;

public class BookDto {
    private UUID id;
    private String title;
    private String authorId;

    public BookDto() {
    }

    public BookDto(UUID id, String title, String authorId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
