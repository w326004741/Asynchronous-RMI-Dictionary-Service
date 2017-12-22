package ie.gmit.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


import ie.gmit.sw.service.DictionaryService;
import ie.gmit.sw.service.impl.DictionaryServiceImpl;

public class ServiceSetup {
	public static void main(String[] args) {    
        // TODO Auto-generated method stub    
        try {    
        	DictionaryService dictionaryService = new DictionaryServiceImpl();    
            LocateRegistry.createRegistry(6600);    
            Naming.rebind("rmi://127.0.0.1:6600/dictionaryService", dictionaryService);    
            System.out.println("Service Start!");    
        }  catch (RemoteException e) {  
            e.printStackTrace();  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        }   
    }    
}
