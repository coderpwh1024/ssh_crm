package com.mycode.ssh.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDao<T> extends HibernateDaoSupport {
	@SuppressWarnings({ "rawtypes", "unused" })
	private Class classp;

	@SuppressWarnings("rawtypes")
	public BaseDao() {
		Class clazz = this.getClass();
        System.out.println("当前运行的类是:"+clazz.getName());
        
		Type type = clazz.getGenericSuperclass();
		
		ParameterizedType ptype = (ParameterizedType) type;
		
		Type[] types = ptype.getActualTypeArguments();
		// Type typeParameter = types[0];
		Class classParameter = (Class) types[0];
		
        System.out.println("参数化类型:"+classParameter);
		this.classp = classParameter;

	} 
	 @SuppressWarnings("unchecked")
	 
	public T findOne(int id){
		 return (T) this.getHibernateTemplate().get(classp, id);
	  }
      @SuppressWarnings("unchecked")
	public List <T> findAll(){
    	  return (List<T>) this.getHibernateTemplate().find("from "+classp.getSimpleName());
      }
	 
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}
	 

}
