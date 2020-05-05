package ru.spec.java.client;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.spec.java.ee.DateService;
import ru.spec.java.ee.MySingletonRemote;
import ru.spec.java.ee.TestBean;

public class Main {
	
	public static void main(String[] args) throws NamingException, InterruptedException, ExecutionException {
		Context ctx = new InitialContext();
		
//		test(ctx);
		
//		stateless(ctx);
		MySingletonRemote s = (MySingletonRemote)ctx.lookup("MySingleton");
		int MAX = 15;
		Future<Long> array[] = new Future[MAX];
		
		for(int i=0;i<MAX;i++) {
			array[i]=s.increment();
		}
		System.out.println("---------------");
		for (Future<Long> future : array) {
			System.out.println(future.get());
		}
	}

	private static void stateless(Context ctx) throws NamingException {
		DateService datebean = (DateService) ctx.lookup("Date");
		Date date = datebean.getDate();
		for(int i=0;i<15;i++) {
			int j=i;
//			new Thread( ()->callServer(datebean) ).start();;
			callServer(datebean);
		}
		
		System.out.println(date);
	}

	private static void callServer(DateService datebean) {
		System.out.println(datebean.increment().isDone());
	}

	private static void test(Context ctx) throws NamingException {
		TestBean bean = (TestBean) ctx.lookup("test");
		String result = bean.echo("hello from client");
		System.out.println(result);
	}
	
}
