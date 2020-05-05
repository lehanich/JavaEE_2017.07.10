package ru.spec.rmi;

import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.spec.javaee.ejb.CheckListService;
import ru.spec.javaee.ejb.CheckListServiceRemote;
import ru.spec.javaee.ejb.EchoService;
import ru.spec.javaee.ejb.MyWizardRemote;
import ru.spec.javaee.entity.CheckList;

public class Main {

	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext();
		
		CheckListServiceRemote cl 
			= (CheckListServiceRemote) ctx.lookup("CheckListService");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("enter option name:");
		String itemName = scan.nextLine();
		
//		CheckList newItem = cl.createCheckList(itemName);
//		System.out.println(newItem.getId());
		
		cl.createOption(itemName, 7L);
		
		
		cl.getCheckLists().forEach(element -> System.out.println(element.getText()));
//		interceptors(ctx);

	}

	private static void wizard(Context ctx) throws NamingException {
		MyWizardRemote wizard = (MyWizardRemote)ctx.lookup("wizard");
//		MyWizardRemote wizard2 = (MyWizardRemote)ctx.lookup("wizard");

		wizard.greet("hello from cli");
//		wizard2.get();
		
//		wizard2.greet("qwertyui");
		
		wizard.log();
		System.out.println(wizard.get());
//		System.out.println(wizard2.get());
	}

	private static void interceptors(Context ctx) throws NamingException {
		EchoService echoBean = (EchoService)ctx.lookup("echo");

		System.out.println(echoBean.echo("hello"));
		System.out.println(echoBean.echo2("hello"));
	}

}
