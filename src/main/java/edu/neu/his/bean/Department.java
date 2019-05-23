package edu.neu.his.bean;

public class Department {
    private int id;
    private String name;
    private String classification;
    private boolean is_clinical;

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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public boolean isIs_clinical() {
        return is_clinical;
    }

    public void setIs_clinical(boolean is_clinical) {
        this.is_clinical = is_clinical;
    }
}
