package ru.spec.java.ee;

import java.util.Date;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class MySingleton
 */
@Singleton(mappedName="MySingleton")
@LocalBean
@Startup
public class MySingleton implements MySingletonRemote {
	
	public MySingleton() {
		System.out.println("+++MySingleton() "+Thread.currentThread());
	}
	
	@PostConstruct
	public void init() {
		System.out.println(">>>MySingleton.init() "+Thread.currentThread());
	}
	
	long count=0;
	
	@Override
	@Asynchronous
	@Lock(LockType.READ)
	public Future<Long> increment() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AsyncResult<Long>(count++);
	}
	
	@Schedule(persistent=false, second="*/10", minute="*", hour="*", month="*", year="*", dayOfMonth="*")
	public void printHello() {
		System.out.println("hello "+ new Date());
	}

}
