package com.ct.plantera.dto;

/**
 * Created by charlest on 11/27/17.
 */

public class TreeDTO extends PlantDTO {

    private int size;

    private String fallColor;


    public String getFallColor() {
        return fallColor;
    }

    public void setFallColor(String fallColor) {
        this.fallColor = fallColor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Tree: " + super.toString() + " " + getSize() + " " + getFallColor();
    }
}
