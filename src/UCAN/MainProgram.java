/*    */ package UCAN;
/*    */ 
/*    */ //import java.awt.Color;
/*    */ //import java.awt.EventQueue;
/*    */ //import java.awt.KeyboardFocusManager;
/*    */ //import javax.swing.UIManager;
/*    */
/*    */ public class MainProgram
/*    */ {
/*    */   //private myFrame frmUcan;
/*    */   //private KeyboardFocusManager KeyBoard_Manger;
/*    */   
/*    */   
/*    */   
/*    */ 
/*    */ 
/*    */   public MainProgram()
/*    */   {
/* 80 */     initialize();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private void initialize()
/*    */   {
/* 88 */    // this.frmUcan = new myFrame();
/* 89 */     //myStatusBar status = new myStatusBar(this.frmUcan);
/* 90 */     //Globals.frmUcanG = this.frmUcan;
/* 91 */     Globals.Serial_frame = new serial();
/* 92 */    //Globals.thrRX_tbl = new tableReceiveThread();
/* 93 */     //Globals.thrRX_tbl.start();
/* 94 */     //Globals.thrTX_tbl = new tableTransmitThread();
/* 95 */     //Globals.thrTX_tbl.start();
/* 96 */     //Globals.transmitTable.addMouseListener(new MouseListener_checkBox());
/* 97 */     //this.KeyBoard_Manger = KeyboardFocusManager.getCurrentKeyboardFocusManager();
/* 98 */     //this.KeyBoard_Manger.addKeyEventDispatcher(new keyEvent());
/*    */   }
/*    */ }
