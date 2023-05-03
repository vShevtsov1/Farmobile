package com.project.Farmobile.users.data;

import com.project.Farmobile.users.data.help.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users",uniqueConstraints = { @UniqueConstraint(columnNames = { "email"})})
public class users {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idusers")
    private Long idusers;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;
}
