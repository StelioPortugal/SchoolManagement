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
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "classes", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Student> students = new ArrayList<Student>();
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @Fetch(value = FetchMode.SUBSELECT)
//    @JoinTable(
//            name = "classes_teacher",
//            joinColumns = @JoinColumn(name = "classes_id"),
//            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
//    private List<Teacher> teachers = new ArrayList<Teacher>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "classes_subject",
            joinColumns = @JoinColumn(name = "classes_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects = new ArrayList<Subject>();
}
