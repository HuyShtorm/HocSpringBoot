package com.example.projectfinal.Entity;

import com.example.projectfinal.enumStatic.UserStatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.example.projectfinal.Entity.BaseEntity_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> nameSearch;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> id;
	public static volatile SingularAttribute<User, String> avatar;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, UserStatus> status;

	public static final String PASSWORD = "password";
	public static final String NAME_SEARCH = "nameSearch";
	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String AVATAR = "avatar";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";
	public static final String STATUS = "status";

}

