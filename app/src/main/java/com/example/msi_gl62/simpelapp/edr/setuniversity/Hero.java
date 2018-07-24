package com.example.msi_gl62.simpelapp.edr.setuniversity;

public class Hero {

    private String school_name_thai;

    public Hero(String college_code, String college_code_prefix) {

        this.school_name_thai = college_code_prefix;
    }

    public String getCollege_code_prefix() {
        return school_name_thai;
    }
}
