/*    */ package UCAN;
/*    */ 
/*    */ import java.util.Timer;
/*    */ 
/*    */ public class TXMsg {
/*  6 */   public long ID = 0L;
/*  7 */   public byte[] data = new byte[8];
/*  8 */   public int RTR = 0;
/*  9 */   public int EXT = 0;
/* 10 */   public int Dlength = 0;
/* 11 */   public String trigger = "None";
/* 12 */   public int timerstate = 0;
/*    */   public Timer TX_Timer;
/* 14 */   public short timer_Per_ms = 500;
/* 15 */   public int List_Index = 0;
/*    */   public String Comment;
/* 17 */   public int count = 0;
/* 18 */   public boolean isRuning = false;
/*    */   public char TriggerCode;
/*    */   public float Last_time;
/* 21 */   public float Now_time = Globals.Time_stamp.get();
/*    */   
/*    */ 
/*    */   public TXMsg() {}
/*    */   
/*    */   public TXMsg(long id, byte[] d, int rtr, int ext, int dlength, int lindex, String str)
/*    */   {
/* 28 */     this.ID = id;
/* 29 */     this.RTR = rtr;
/* 30 */     this.EXT = ext;
/* 31 */     this.Dlength = dlength;
/* 32 */     this.data = d;
/* 33 */     this.List_Index = lindex;
/* 34 */     this.Comment = str;
/*    */   }
/*    */   
/*    */   public void pause() {
/* 38 */     this.TX_Timer.cancel();
/* 39 */     this.TX_Timer = null;
/* 40 */     this.isRuning = false;
/*    */   }
/*    */   
/* 43 */   public void start() { this.TX_Timer = new Timer();
/* 44 */     this.TX_Timer.scheduleAtFixedRate(new java.util.TimerTask()
/*    */     {
/*    */ 
/*    */       public void run()
/*    */       {
/* 49 */         TXMsg.this.tx_send();
/*    */       }
/* 51 */     }, 0L, this.timer_Per_ms);
/* 52 */     this.isRuning = true;
/*    */   }
/*    */   
/*    */   public void tx_send() {
/* 56 */     long tempID = this.ID;
/* 57 */     byte[] b = new byte[13];
/* 58 */     tempID = tempID << 1 | this.EXT & 0x1;
/* 59 */     for (int i = 0; i < 4; i++)
/*    */     {
/* 61 */       b[i] = ((byte)(int)tempID);
/* 62 */       tempID >>= 8;
/*    */     }
/* 64 */     b[4] = ((byte)((short)this.Dlength | (short)((this.RTR & 0x1) << 7)));
/* 65 */     for (int i = 0; i < 8; i++)
/*    */     {
/* 67 */       if (i < this.Dlength)
/*    */       {
/* 69 */         b[(i + 5)] = this.data[i];
/*    */       }
/*    */       else
/*    */       {
/* 73 */         b[(i + 5)] = 0;
/*    */       }
/*    */     }
/* 76 */     serial.Serial_Write(b);
/* 77 */     this.count += 1;
/* 78 */     this.Last_time = this.Now_time;
/* 79 */     this.Now_time = Globals.Time_stamp.get();
/* 80 */     //Globals.thrTX_tbl.resume();
/*    */   }
/*    */ }