package ie.gmit.sw.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ie.gmit.sw.service.DictionaryService;
import ie.gmit.sw.utils.Dic;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DictionaryServiceImpl() throws RemoteException {
		super();
	}


	public String lookup(String s) throws RemoteException {
		String outstr = null;
		try {
			Thread.sleep(1000);
			outstr = Dic.GetParaphrase(s);
			if("".equals(outstr))
				outstr = "String not found";
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outstr;
	}

}
