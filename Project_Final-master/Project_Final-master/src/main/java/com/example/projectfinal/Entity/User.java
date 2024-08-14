package com.example.projectfinal.Entity;

import com.example.projectfinal.enumStatic.UserStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "tb_user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy ="uuid2")
    private String id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String nameSearch;
    private String avatar;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
