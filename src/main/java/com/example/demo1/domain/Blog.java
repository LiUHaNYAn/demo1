package com.example.demo1.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_blog")
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Length(max = 30)
    private String title;
    @Length(max = 200)
    private  String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
