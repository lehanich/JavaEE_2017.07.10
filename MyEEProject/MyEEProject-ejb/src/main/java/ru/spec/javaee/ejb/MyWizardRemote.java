package ru.spec.javaee.ejb;

import javax.ejb.Remote;

@Remote
public interface MyWizardRemote {

	String get();

	void greet(String msg);

	void log();

}
