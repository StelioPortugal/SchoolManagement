package com.schoolmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String address;

    @ManyToOne
    private Classes classes;
}
