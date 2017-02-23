/*    */ package UCAN;
/*    */ 
/*    */ import java.awt.event.KeyEvent;
/*    */ //import java.util.ArrayList;
/*    */ 
/*    */ public class keyEvent implements java.awt.KeyEventDispatcher
/*    */ {
/*    */   public boolean dispatchKeyEvent(KeyEvent e)
/*    */   {
/* 10 */     if (!Globals.ispanelTX_open)
/*    */     {
/* 12 */       if (e.getID() == 400)
/*    */       {
/* 14 */        // Globals.lbKeyPress.setText("    Key: " + e.getKeyChar() + "           ");
/* 15 */         int index = Globals.Key_Event.search_keyEvent(e.getKeyChar());
/* 16 */         if (index != -1)
/*    */         {
/* 18 */           if (((TXMsg)Globals.TX.get(index)).TriggerCode == '&')
/*    */           {
/* 20 */             if (((TXMsg)Globals.TX.get(index)).isRuning)
/*    */             {
/* 22 */               ((TXMsg)Globals.TX.get(index)).isRuning = false;
/* 23 */               ((TXMsg)Globals.TX.get(index)).pause();
/* 24 */               //Globals.thrTX_tbl.resume();
/*    */             }
/*    */             else
/*    */             {
/* 28 */               ((TXMsg)Globals.TX.get(index)).isRuning = true;
/* 29 */               ((TXMsg)Globals.TX.get(index)).start();
/*    */             }
/*    */             
/*    */           }
/*    */           else {
/* 34 */             ((TXMsg)Globals.TX.get(index)).tx_send();
/*    */           }
/*    */         }
/*    */       }
/* 38 */       else if (e.getID() == 402)
/*    */       {
/* 40 */         //Globals.lbKeyPress.setText("    Key:              ");
/*    */       }
/*    */     }
/* 43 */     return false;
/*    */   }
/*    */ }
