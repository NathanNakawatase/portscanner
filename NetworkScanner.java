import java.net.Socket;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class NetworkScanner
{
  
 public NetworkScanner() 
 {
 }
 //scans using input IP adress and Port 
 public boolean scan(String hostname, int port) {
   System.out.println("Attempting to scan " + hostname + ":" + port);
   try {
   Socket mysocket = new Socket(hostname, port);
   mysocket.setSoTimeout(20);
   return true;
   } 
   catch(Exception catchall) {
   return false;
   }
 }
public boolean scanAll(String hostname) {

  boolean[] results = new boolean[65535]; 

  try{
    FileWriter file = new FileWriter(hostname);
    BufferedWriter out = new BufferedWriter(file);

    // For debugging, only scanning ports 0-3
    
 for (int y = 0 ; y < 3 ; y++) {
    results[y] = scan(hostname, y);
    if (results[y] == true) {
      
        out.write(y +":OPEN\n");
        System.out.println("Port OPEN :" + y);
    }
    else {
        out.write(y+":CLOSED\n");
        System.out.println("Port CLOSED:" + y);
    }
 }
 out.close();
  }
  catch(Exception e) {
  }
  
   return true;
}

 





 public static void main (String [] args ) {
 
    NetworkScanner networkScanner = new NetworkScanner();

      
    for (int x = 0 ; x < args.length ; x++) 
 {

    {
      System.out.println("encountered error while creating file");
    }
     System.out.println("Scanning:" + args[x]);
     System.out.println(networkScanner.scanAll(args[x]));
     
    }
    

  
  }
}