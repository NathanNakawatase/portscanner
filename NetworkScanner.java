import java.net.Socket;

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
   return true;
   } //returns false if an exception is thrown
   catch(Exception catchall) {
   return false;
   }
 }
 
 public static void main (String [] args ) {
 
    NetworkScanner networkScanner = new NetworkScanner();
     
    for (int x = 0 ; x < args.length ; x++) 
    {
     System.out.println("Scanning:" + args[x]); 
     System.out.println(networkScanner.scan(args[x],443));
    }
    

  
  }
}