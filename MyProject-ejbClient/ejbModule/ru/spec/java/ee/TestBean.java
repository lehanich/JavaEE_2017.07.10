package ru.spec.java.ee;

import javax.ejb.Remote;

@Remote
public interface TestBean {

	String echo(String msg);

}
