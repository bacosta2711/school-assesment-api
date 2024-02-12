package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Integer userId;

    @Column(name="username")
    private String userName;

    @Column(name="useremail")
    private String userEmail;

    @Column(name="userpassword")
    private String userPassword;

    @Column(name="userrole")
    private String userRole;

    @Column(name="userenabled")
    private Boolean userEnabled;

    @OneToOne(mappedBy = "user")
    private Clas clase;

}

