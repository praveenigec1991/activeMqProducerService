package com.data.producer.entity;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = -1L;
    private String name ;
    private int id ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", id=" + id + '}';
    }
}
