
package blockchain;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class TextFileWriter {
    public boolean getContent(String path,String cont)
    {
        boolean flag=true;
        try
        {
            FileOutputStream fo=new FileOutputStream(path);
            for(int i=0;i<cont.length();i++)
            {
            char ch=cont.charAt(i);
            int x=(int)ch;
            fo.write(x);
            }
            fo.close();
        }
        catch(Exception e)
        {
        System.out.println("Exception at TextFileWriter"+e);
        flag=false;
        }
        return flag;
    }
}
