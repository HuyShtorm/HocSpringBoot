package com.example.projectfinal.Entity;

import com.example.projectfinal.enumStatic.UserRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SingularAttribute<Role, UserRole> roleName;
	public static volatile SingularAttribute<Role, String> id;

	public static final String ROLE_NAME = "roleName";
	public static final String ID = "id";

}

