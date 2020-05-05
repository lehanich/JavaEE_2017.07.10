package ru.spec.java.ee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

@Stateless(mappedName = "test")
@LocalBean
public class TestBeanImpl implements TestBean, TestBeanLocal {
	
	@Override
	public String echo(String msg) {
		System.out.println(msg);
		return "re:"+msg;
	}

	@Produces
	public long setRnd(){
		return 0; 
	}
	
	
}
