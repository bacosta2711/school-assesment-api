package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Table(name = "evaluationtype")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="typeid")
    private Integer typeId;

    @Column(name = "typedescription")
    private String typeDescription;

    @OneToMany(mappedBy = "evaluationType")
    private List<Evaluation> evaluationList;


}
