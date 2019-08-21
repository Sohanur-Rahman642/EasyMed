package com.example.easymed;

public class Medicine {

    private String medicineName;
    private String medicineBrandName;
    private  String medicinePower;
    private int mediImage;

    public Medicine() {
    }

    public Medicine(String medicineName, String medicineBrandName,
                    String medicinePower, int medi_image) {
        this.medicineName = medicineName;
        this.medicineBrandName = medicineBrandName;
        this.medicinePower = medicinePower;
        this.mediImage = medi_image;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineBrandName() {
        return medicineBrandName;
    }

    public void setMedicineBrandName(String medicineBrandName) {
        this.medicineBrandName = medicineBrandName;
    }

    public String getMedicinePower() {
        return medicinePower;
    }

    public void setMedicinePower(String medicinePower) {
        this.medicinePower = medicinePower;
    }

    public int getMediImage() {
        return mediImage;
    }

    public void setMediImage(int medi_image) {
        this.mediImage = medi_image;
    }
}

