
package keygeneration;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.*;
import java.util.*;




 public class CurrentDate
 {
public String getDate()
{

Calendar calendar = new GregorianCalendar();
 	 String am_pm;
 	 int hour = calendar.get(Calendar.HOUR);
 	 int minute = calendar.get(Calendar.MINUTE);
 	 int second = calendar.get(Calendar.SECOND);
  				     if(calendar.get(Calendar.AM_PM) == 0)
 					 am_pm = "AM";
 					 else
 					 am_pm = "PM";
                     String gg=  hour + ":"+ minute + ":" + second + " " + am_pm;
//                     System.out.println("Current time "+gg);

String fintime="";
       // System.out.println("Time is "+gg);
        if(gg.endsWith("PM"))
        {
            gg=gg.replaceAll("PM", "");
           String st[]=gg.split(":");
          String hs=st[0].trim();
          int hh=Integer.parseInt(hs);
          
          String ms=st[1].trim();
          int mm=Integer.parseInt(ms);
          
          String secs=st[2].trim();
          int ss=Integer.parseInt(secs);
          
          int total=12*3600+ hh*3600+mm*60+ss;
          int nh=total/3600;
          int r1=total%3600;
          int nmin=r1/60;
          int nseconds=r1%60;
           fintime=Integer.toString(nh)+":"+Integer.toString(nmin)+":"+Integer.toString(nseconds);
          
           
          
        }
        else
        {
             gg=gg.replaceAll("AM", "");
             gg=gg.trim();
             fintime=gg;
        }
 ///System.out.println("24 hours format time is "+fintime);
   
					return fintime;

}

 public int getDiffinMinutes(String oldtime,String newtime)
   {
       int diff=0;
       
       
       System.out.println("Old Time "+oldtime);
       System.out.println("new time "+newtime);
      
           String st1[]=oldtime.split(":");
          String hs=st1[0].trim();
          int hh1=Integer.parseInt(hs);
          
          String ms=st1[1].trim();
          int mm1=Integer.parseInt(ms);
          
          String secs=st1[2].trim();
          int ss1=Integer.parseInt(secs);
       
          int total1=hh1*3600+mm1*60+ss1;
          
          
        String st2[]=newtime.split(":");
          String hs1=st2[0].trim();
          int hh2=Integer.parseInt(hs1);
          
          String ms2=st2[1].trim();
          int mm2=Integer.parseInt(ms2);
          
          String secs2=st2[2].trim();
          int ss2=Integer.parseInt(secs2);
       
          int total2=hh2*3600+mm2*60+ss2;
          
          System.out.println("total 1 "+total1);
          System.out.println("total 2 "+total2);
          
          
          int  timediff=Math.abs(total1-total2);
          
          diff=timediff/60;
       
       
       return diff;
   }

 }