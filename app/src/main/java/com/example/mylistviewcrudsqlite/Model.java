package com.example.mylistviewcrudsqlite;

public class Model {
    private int id;
    private String title;
    private String console;
    private String year;
    private byte[] image;

    public Model(int id, String title, String console, String year, byte[] image) {
        this.id = id;
        this.title = title;
        this.console = console;
        this.year = year;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
