package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "class")
@IdClass(ClasPk.class)
@AllArgsConstructor
@NoArgsConstructor
public class Clas {
    @Id
    @Column(name ="classlevel" , nullable = false)
    private Integer classLevel;

    @Id
    @Column(name ="classuser" , nullable = false)
    private Integer classUser;

    @Id
    @Column(name ="classyear" , nullable = false)
    private LocalDate classYear;

    @Column(name = "classchilderns")
    private Integer classChildrens;

    @Column(name = "classgrade")
    private String classGrade;


    @OneToOne()
    @JoinColumn(name ="classuser" , insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "clas")
    private List<EvaluationRegistry> evaluationRegistriesList;

}
