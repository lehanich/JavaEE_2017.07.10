package ru.spec.javaee.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class MyWizard
 */
@Stateful(mappedName = "wizard")
@LocalBean
public class MyWizard implements MyWizardRemote, Serializable {

	String msg;
	
	@Override
	public void greet(String msg) {
		this.msg = msg;
	}
	
	@PreDestroy
	@PostActivate
	@PrePassivate
	@PostConstruct
	@Override
	public void log() {
		System.out.println("+++++ "+msg);
	}
	
	@Override
	@Remove
	public String get() {
		return msg;
	}
}
