package UCAN;

import java.util.List;
 
 class AutoDetect extends java.util.Timer
 {
   private boolean blisSearching = true;
   private boolean blcurrentState = false;
   
   private java.util.TimerTask AD_TimerTask = new java.util.TimerTask()
   {
 
     public void run()
     {
       List<String> Connect_Ports = Serial_connection.Get_Ports();
       AutoDetect.this.Bar_Update(Connect_Ports.size());
       for (short counter = 0; counter < Connect_Ports.size(); counter = (short)(counter + 1))
       {
         if (!serial_Globals.Istesting)
         {
           String PortName = (String)Connect_Ports.get(counter);
           if (serial_Globals.Ports_list.indexOf(PortName) == -1)
           {
             AutoDetect.this.blisSearching = true;
             AutoDetect.this.Bar_Update(Connect_Ports.size());
             serial_Globals.selectedPort = PortName;
             Serial_connection.Start_connection();
           }
           else
           {
             AutoDetect.this.blisSearching = false;
           }
         }
       }
     }
   };
   
   private void Bar_Update(int size)
   {
     if ((size > 0) && (this.blisSearching) && (!this.blcurrentState))
     {
       this.blcurrentState = true;
       //Globals.comPortBar.setString("Searching");
       //Globals.comPortBar.setIndeterminate(true);
     }
     else if ((this.blcurrentState) && ((!this.blisSearching) || (size == 0)))
     {
       this.blcurrentState = false;
       //Globals.comPortBar.setString("No COM port detected");
       //Globals.comPortBar.setIndeterminate(false);
     }
   }
   
   public AutoDetect() {
     scheduleAtFixedRate(this.AD_TimerTask, 1000L, 500L);
   }
 }