
package rcc;

import java.io.FileNotFoundException;


public class RccForTextFiles {

   
    public static void main(String[] args) throws FileNotFoundException 
    {
         String ekey="X134SY";
         String dkey="X134SY";
         
         String fcont=new TextFileReader().readTempFile("D://Sample.txt");
         
         
     
            ReverseEncryptionHelper  reh=new ReverseEncryptionHelper();
            String ens=reh.startEncryption(fcont,ekey);
            
            new TextFileWriter().createFile(ens,"D://Encryption_sample.txt");
      

      
            String cont=new TextFileReader().readTempFile("D://Encryption_sample.txt");
         

    

 
ReverseDecryptionHelper  rdh=new ReverseDecryptionHelper();
String ens1=rdh.startDecryption(cont,dkey);
  new TextFileWriter().createFile(ens1,"D://decrypt_sample.txt");

    }
    
}
