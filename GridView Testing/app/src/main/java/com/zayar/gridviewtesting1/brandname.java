package com.zayar.gridviewtesting1;

public class brandname {
    private int id;
    private String name;
    private int resource_index;

    public brandname(int id, String name, int resource_index) {
        this.id = id;
        this.name = name;
        this.resource_index = resource_index;
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

    public int getResource_index() {
        return resource_index;
    }

    public void setResource_index(int resource_index) {
        this.resource_index = resource_index;
    }
}
