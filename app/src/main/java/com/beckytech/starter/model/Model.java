package com.beckytech.starter.model;

import java.io.Serializable;

public class Model implements Serializable {
    private String title, subtitle, category;
    private int image;

    public Model(String title, String subtitle, String category, int image) {
        this.title = title;
        this.subtitle = subtitle;
        this.category = category;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getCategory() {
        return category;
    }

    public int getImage() {
        return image;
    }
}
