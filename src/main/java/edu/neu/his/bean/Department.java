package edu.neu.his.bean;

public class Department {
    private int id;
    private String code;
    private String name;
    private String classification;
    private boolean is_clinical;

    public Department(int id,String code,String name,String classification,boolean is_clinical) {
        this.setId(id);
        this.setIs_clinical(is_clinical);
        this.setCode(code);
        this.setName(name);
        this.setClassification(classification);
    }

    public Department(){

    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
