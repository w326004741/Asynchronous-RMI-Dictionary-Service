package ie.gmit.sw.utils;

import ie.gmit.sw.service.DictionaryService;
import ie.gmit.sw.servlet.InitListener;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.locks.Lock;

public class DictionaryRMIThread extends Thread implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				Query query = InitListener.INLIST.deleteFirst();// First in first out
				if (query != null) {  // if not found

					DictionaryService dictionary = (DictionaryService) Naming //check RMI interface
							.lookup("rmi://127.0.0.1:6600/dictionaryService");
					String outstr = dictionary.lookup(query.getStr());
					System.out.println("run thread--->>" + query.getStr() + ";"
							+ outstr);
					InitListener.OUTQUEUE.put(query.getJob_num(), outstr); //store into map

				}else {
					synchronized (Lock.class){
						 try {
			                    Lock.class.wait();
			                } catch (InterruptedException e) {
			                    e.printStackTrace();
			                }
					}
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

}
