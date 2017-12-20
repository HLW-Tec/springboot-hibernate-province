package com.zwd.core.entity;

import javax.persistence.*;

@Entity
@Table(name= "province")
public class Province {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}