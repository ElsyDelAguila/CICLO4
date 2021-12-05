/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catalogo.productosmadreselva.app.model;

/**
 *
 * @author Marina Del Águila
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_mail", unique = true, length = 50, nullable = false)
    private String email;
    @Column(name = "user_password", length = 50, nullable = false)
    private String password;
    @Column(name = "user_name", length = 80, nullable = false)
    private String name;
}