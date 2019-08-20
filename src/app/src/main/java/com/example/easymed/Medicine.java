package com.example.easymed;

/**
 * The type Medicine.
 */
public class Medicine {

    private String medicineName;
    private String medicineBrandName;
    private  String medicinePower;
    private int mediImage;

    /**
     * Instantiates a new Medicine.
     */
    public Medicine() {
    }

    /**
     * Instantiates a new Medicine.
     *
     * @param medicineName      the medicine name
     * @param medicineBrandName the medicine brand name
     * @param medicinePower     the medicine power
     * @param medi_image        the medi image
     */
    public Medicine(String medicineName, String medicineBrandName,
                    String medicinePower, int medi_image) {
        this.medicineName = medicineName;
        this.medicineBrandName = medicineBrandName;
        this.medicinePower = medicinePower;
        this.mediImage = medi_image;
    }

    /**
     * Gets medicine name.
     *
     * @return the medicine name
     */
    public String getMedicineName() {
        return medicineName;
    }

    /**
     * Sets medicine name.
     *
     * @param medicineName the medicine name
     */
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    /**
     * Gets medicine brand name.
     *
     * @return the medicine brand name
     */
    public String getMedicineBrandName() {
        return medicineBrandName;
    }

    /**
     * Sets medicine brand name.
     *
     * @param medicineBrandName the medicine brand name
     */
    public void setMedicineBrandName(String medicineBrandName) {
        this.medicineBrandName = medicineBrandName;
    }

    /**
     * Gets medicine power.
     *
     * @return the medicine power
     */
    public String getMedicinePower() {
        return medicinePower;
    }

    /**
     * Sets medicine power.
     *
     * @param medicinePower the medicine power
     */
    public void setMedicinePower(String medicinePower) {
        this.medicinePower = medicinePower;
    }

    /**
     * Gets medi image.
     *
     * @return the medi image
     */
    public int getMediImage() {
        return mediImage;
    }

    /**
     * Sets medi image.
     *
     * @param medi_image the medi image
     */
    public void setMediImage(int medi_image) {
        this.mediImage = medi_image;
    }
}

