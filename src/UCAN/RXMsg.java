/*    */ package UCAN;
/*    */ 
/*    */ public class RXMsg
/*    */ {
/*    */   public long canID;
/*  6 */   public byte[] data = new byte[8];
/*  7 */   public String RTR = "";
/*  8 */   public int dataLength = 0;
/*  9 */   public int count = 1;
/*    */   public float Last_time;
/* 11 */   //public float Now_time = Globals.Time_stamp.get();
/*    */   
/*    */   public RXMsg(long id, byte[] d, String rtr, int length) {
/* 14 */     this.canID = id;
/* 15 */     this.data = d;
/* 16 */     this.RTR = rtr;
/* 17 */     this.dataLength = length;
/* 18 */     this.count = 1;
/*    */   }
/*    */   
/*    */   public RXMsg() {}
/*    */   
/*    */   public void RXMsg_Update(byte[] d, String rtr, int length)
/*    */   {
/* 25 */     this.count += 1;
/* 26 */     //this.Last_time = this.Now_time;
/* 27 */     //this.Now_time = Globals.Time_stamp.get();
/* 28 */     this.data = d;
/* 29 */     this.RTR = rtr;
/* 30 */     this.dataLength = length;
/*    */   }
/*    */ }
