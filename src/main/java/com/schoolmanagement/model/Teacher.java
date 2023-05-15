package com.schoolmanagement.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String address;

//    @ManyToMany(mappedBy = "teachers", fetch = FetchType.EAGER)
//    @Fetch(value = FetchMode.SUBSELECT)
//    private List<Classes> classes = new ArrayList<Classes>();

    @ManyToMany(mappedBy = "teachers", fetch = FetchType.EAGER)
    private List<Subject> subjects = new ArrayList<Subject>();

}
