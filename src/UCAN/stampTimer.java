/*    */ package UCAN;
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ 
/*    */ public class stampTimer
/*    */ {
/*    */   private Timer timestamp;
/*  9 */   private float timernow = 0.0F;
/*    */   
/*    */   public void Start()
/*    */   {
/* 13 */     this.timestamp = new Timer();
/* 14 */     this.timestamp.scheduleAtFixedRate(new TimerTask()
/*    */     {
/*    */ 
/*    */       public void run()
/*    */       {
/* 19 */         stampTimer tmp4_1 = stampTimer.this;tmp4_1.timernow = ((float)(tmp4_1.timernow + 1.0D));
/*    */       }
/* 21 */     }, 0L, 1L);
/*    */   }
/*    */   
/*    */   public void cancel()
/*    */   {
/* 26 */     this.timernow = 0.0F;
/* 27 */     this.timestamp.cancel();
/*    */   }
/*    */   
/*    */   public float get()
/*    */   {
/* 32 */     return this.timernow;
/*    */   }
/*    */ }