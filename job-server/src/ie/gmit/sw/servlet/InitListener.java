package ie.gmit.sw.servlet;

import ie.gmit.sw.service.DictionaryService;
import ie.gmit.sw.utils.DictionaryRMIThread;
import ie.gmit.sw.utils.InQueueList;
import ie.gmit.sw.utils.Query;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener implements ServletContextListener {
	public static InQueueList INLIST = new InQueueList();
	public static Map<String, String> OUTQUEUE = new HashMap<String, String>();
	private boolean isgo = true;

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Listener starting>>>>>>");
		DictionaryRMIThread t = new DictionaryRMIThread();
		t.start();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
