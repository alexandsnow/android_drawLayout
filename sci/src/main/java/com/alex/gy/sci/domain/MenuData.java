package com.alex.gy.sci.domain;

/**
 * Created by gy on 2016/8/15.
 */
public class MenuData {
    private String icon;
    private String title;

    public MenuData(String icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
