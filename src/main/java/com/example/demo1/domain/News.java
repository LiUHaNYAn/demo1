package com.example.demo1.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Length(max = 20)
    private  String title;
    @Length(max = 500)
    private  String content;
    @Length(max = 20)
    private  String source;
    private  boolean isnew;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isIsnew() {
        return isnew;
    }

    public void setIsnew(boolean isnew) {
        this.isnew = isnew;
    }
}
