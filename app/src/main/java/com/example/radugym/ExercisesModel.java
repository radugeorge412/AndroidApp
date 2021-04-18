package com.example.radugym;

public class ExercisesModel {

    private String title;
    private String time;
    private int imageId;

    public ExercisesModel(String title, String time, int imageId) {
        this.title = title;
        this.time=time;
        this.imageId=imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public int getImageId() {
        return imageId;
    }
}
