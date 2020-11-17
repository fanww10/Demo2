package com.iflytek.demo2;

public class ImageItem {
    public String imagePath;
    public String imageName;

    public ImageItem(){

    }

    public ImageItem(String imagePath, String imageName) {
        this.imagePath = imagePath;
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}
