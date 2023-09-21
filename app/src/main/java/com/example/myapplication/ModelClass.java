package com.example.myapplication;

public class ModelClass {

    public ModelClass(int image, String name, String dob, String edu, String job, String company, String from) {
        this.image = image;
        this.name = name;
        this.dob = dob;
        this.edu = edu;
        this.job = job;
        this.company = company;
        this.from = from;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    private int image;
    private String name ,dob ,edu,job, company, from;



}

