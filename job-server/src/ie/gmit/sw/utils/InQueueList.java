package ie.gmit.sw.utils;

public class InQueueList {
	 
 	private class Data{
        private Query obj;  
        private Data next = null;  
          
        Data(Query obj){  
            this.obj = obj;  
        }  
    }  
	      
	 private Data first = null;  
	 private Data last = null;  
	      
     public void insertLast(Query obj){ 
        Data data = new Data(obj);  
        if(first == null){  
            first = data;  
        }else{  
            last.next = data;  
        }  
        last = data;  
     }  
      
     public Query deleteFirst() {  
        if(first == null)  
            return null;  
        Data temp = first;  
        if(first.next == null)  
            last = null;  
        first = first.next;  
        return temp.obj;  
     }  
              
     public void display(){  
        if(first == null)  
            System.out.println("empty");  
        System.out.print("first -> last : | ");  
        Data cur = first;  
        while(cur != null){  
            System.out.print(cur.obj.toString() + " | ");  
            cur = cur.next;  
        }  
        System.out.print("\n");  
     }  
	
}
