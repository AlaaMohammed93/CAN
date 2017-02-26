/*    */ package UCAN;
/*    */ 
/*    */ //import java.awt.Color;
/*    */ import java.awt.EventQueue;
/*    */ //import java.awt.KeyboardFocusManager;
/*    */ //import javax.swing.UIManager;
/*    */
/*    */ public class maind
/*    */ {
/*    */   //private myFrame frmUcan;
/*    */   //private KeyboardFocusManager KeyBoard_Manger;
/*    */   
/*    */   public static void main(String[] args)
/*    */   {
/* 58 */     EventQueue.invokeLater(new Runnable() {
/*    */       public void run() {
/*    */         try {
/* 61 */           //UIManager.setLookAndFeel(
/* 62 */             //UIManager.getCrossPlatformLookAndFeelClassName());
/* 63 */           MainProgram window = new MainProgram();
/* 64 */           //window.frmUcan.setVisible(true);
/*    */           
/*    */ 
/*    */ 
/* 68 */           //UIManager.put("ToolTip.background", Color.YELLOW);
/*    */         } catch (Exception e) {
/* 70 */           e.printStackTrace();
/*    */         }
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */  }
