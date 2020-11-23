package com.example.billbro.Party;

public class Companion {
    private int c_id;
    private String name;
    private double dept;
    private double freeDept;

    public Companion(int id, String name, double dept, double freeDept) {
        this.c_id = id;
        this.name = name;
        this.dept = dept;
        this.freeDept = freeDept;
    }

    public int getC_id() {
        return c_id;
    }

    public String getName() {
        return name;
    }

    public double getDept() {
        return dept;
    }

    public double getFreeDept() {
        return freeDept;
    }

    public void setDept(double dept) {
        this.dept = dept;
    }

    public void setFreeDept(double freeDept) {
        this.freeDept = freeDept;
    }
}
