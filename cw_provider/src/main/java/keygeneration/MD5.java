
package keygeneration;

import java.math.BigInteger;
import java.security.MessageDigest;


public class MD5  {
    
  
    public String getMD5Key(String str)
    {
       String hashkey="";
       
       try
       {
           MessageDigest md = MessageDigest.getInstance("MD5");
           byte[] messageDigest = md.digest(str.getBytes());
           BigInteger no = new BigInteger(1, messageDigest);
             hashkey = no.toString(16);
            while (hashkey.length() < 32) 
            {
                hashkey = "0" + hashkey;
            }
           
       }
       catch(java.security.NoSuchAlgorithmException e)
       {
           System.out.println("Exception in MD5 Class is: "+e);
       }
        
        
        return hashkey;
    }

    
    
}

