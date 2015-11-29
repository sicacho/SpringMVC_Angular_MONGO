package com.manga.domain;

import javax.xml.bind.annotation.*;

/**
 * Created by khangtnse60992 on 1/24/2015.
 */


public class Chapter {

    private String name;
    private String data;

    public String getName() {
        return name;
    }

    //@XmlElement(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    //@XmlElement(required = true)
    public void setData(String data) {
        this.data = data;
    }
}
