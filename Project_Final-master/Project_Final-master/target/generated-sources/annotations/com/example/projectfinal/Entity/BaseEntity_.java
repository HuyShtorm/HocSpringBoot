package com.example.projectfinal.Entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntity.class)
public abstract class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, LocalDate> createdAt;
	public static volatile SingularAttribute<BaseEntity, String> updateBy;
	public static volatile SingularAttribute<BaseEntity, LocalDate> updateAt;

	public static final String CREATED_AT = "createdAt";
	public static final String UPDATE_BY = "updateBy";
	public static final String UPDATE_AT = "updateAt";

}

