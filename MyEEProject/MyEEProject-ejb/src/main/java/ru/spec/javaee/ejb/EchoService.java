package ru.spec.javaee.ejb;

import javax.ejb.Remote;

import ru.spec.javaee.aop.LogTime;

@Remote
public interface EchoService {

	@LogTime
	String echo(String msg);

	String echo2(String msg);

}