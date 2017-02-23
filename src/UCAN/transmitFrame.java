/*    */ package UCAN;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.GridLayout;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class transmitFrame
/*    */   extends JFrame
/*    */ {
/*    */   private GridLayout gLayout;
/*    */   
/*    */   public transmitFrame()
/*    */   {
/* 18 */     super("New Message");
/* 19 */     setSize(new Dimension(530, 210));
/* 20 */     setResizable(false);
/* 21 */     this.gLayout = new GridLayout(1, 0);
/* 22 */     setLayout(this.gLayout);
/* 23 */     setLocationRelativeTo(this.rootPane);
/* 24 */     //add(Globals.txPanel);
/*    */   }
/*    */ }