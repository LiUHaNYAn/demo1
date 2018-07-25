package com.example.demo1.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "dict")
public class Dict implements Serializable {
    @Id
    @Length(max = 50)
    private  String id;
    @Length(max = 50)
    private String category;
    @Length(max = 50)
    private  String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
