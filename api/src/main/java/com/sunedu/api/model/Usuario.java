package com.sunedu.api.model;
import javax.persistence.Entity;

import javax.persistence.Table;



import javax.persistence.Id;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_user")
public class Usuario implements Serializable{
    @Id
    @Column(name = "admin_user")
    private String adminUser;
    private String password;
}