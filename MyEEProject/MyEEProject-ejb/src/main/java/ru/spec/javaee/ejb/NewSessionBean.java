/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spec.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.inject.Named;

import ru.spec.javaee.aop.InfoString;
import ru.spec.javaee.aop.LogTime;

@Stateless(mappedName = "echo")
@LocalBean
public class NewSessionBean implements EchoService {
	
	@Inject
	@InfoString
	@Named("bus")
	Event<UserDto> bus;

	@LogTime
	public void processUser(@InfoString @Observes Object user) {

	}

	@LogTime
	public void checkUser(@Named("bus") @Observes(during = TransactionPhase.BEFORE_COMPLETION) UserDto user) {

	}

	@LogTime
	@Override
	public String echo(String msg) {
		UserDto userDto = new UserDto();
		bus.fire(userDto);
		
//		CDI.current().select(InfoString.class)
		// processUser(userDto);
		// checkUser(userDto);
		return "re:" + msg;
	}

	@Override
	@LogTime(printResult = true)
	public String echo2(String msg) {
		return "re2:" + msg;
	}
}
