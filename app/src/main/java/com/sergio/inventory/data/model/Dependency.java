package com.sergio.inventory.data.model;

import java.io.Serializable;
import java.util.Objects;

public class Dependency implements Serializable {
    private String name;
    private String shortname;
    private String description;
    private String urlImage;


    public Dependency(String name, String shortname, String description, String urlImage) {
        this.name = name;
        this.shortname = shortname;
        this.description = description;
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependency that = (Dependency) o;
        return shortname.equals(that.shortname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortname);
    }
}
