package com.github.emalock3.mybatis.mapper.domain;

public class Foo {
    private int id;
    private String name;

    public Foo() {
    }

    public Foo(int id, String name) {
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
        return "Foo{" + "id=" + id + ", name=" + name + '}';
    }
}
