package com.example.song_info.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private int id;

    @NotBlank(message = "Song title can't be blank!")
    @Size(max = 800, message = "Song title no more than 800 characters!")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Song title can't contain special characters!")
    private String name;

    @NotBlank(message = "Singer name can't be blank!")
    @Size(max = 300,message = "Singer name can't exceed 300 characters!")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "Singer name can't contain special characters!")
    private String singer;

    @NotBlank(message = "Music genre is not allowed to be empty!")
    @Size(max = 1000,message = "Music genre does not exceed 1000 characters!")
    @Pattern(regexp = "^[a-zA-Z0-9, ]*$",message = "Category names do not contain special characters (except ',')!")
    private String category;

    @NotBlank(message = "The music link cannot be left blank.")
    private String file;

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
    }
}
