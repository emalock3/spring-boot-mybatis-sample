package com.github.emalock3.mybatis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "foobar")
public class FooBarProperties {
    private String fooName;
    private String barName;
    private String hoge;
    private int hogeNum;

    public String getFooName() {
        return fooName;
    }

    public void setFooName(String fooName) {
        this.fooName = fooName;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getHoge() {
        return hoge;
    }

    public void setHoge(String hoge) {
        this.hoge = hoge;
    }

    public int getHogeNum() {
        return hogeNum;
    }

    public void setHogeNum(int hogeNum) {
        this.hogeNum = hogeNum;
    }

    @Override
    public String toString() {
        return "FooBarProperties{" + "fooName=" + fooName + ", barName=" + barName + ", hoge=" + hoge + ", hogeNum=" + hogeNum + '}';
    }
}
