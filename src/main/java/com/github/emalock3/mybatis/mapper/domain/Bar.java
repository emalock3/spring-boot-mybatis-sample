package com.github.emalock3.mybatis.mapper.domain;

public class Bar {
    private int id;
    private String name;

    public Bar() {
    }

    public Bar(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bar{" + "id=" + id + ", name=" + name + '}';
    }
    
}
