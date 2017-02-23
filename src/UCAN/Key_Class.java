/*    */ package UCAN;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class Key_Class
/*    */ {
/*    */   private List<Integer> msg_index;
/*    */   private List<Character> msg_char;
/*    */   
/*    */   public Key_Class()
/*    */   {
/* 12 */     this.msg_index = new java.util.ArrayList();
/* 13 */     this.msg_char = new java.util.ArrayList();
/*    */   }
/*    */   
/*    */   public void Add_keyEvent(int msgIndex, char msgChar)
/*    */   {
/* 18 */     this.msg_index.add(Integer.valueOf(msgIndex));
/* 19 */     this.msg_char.add(Character.valueOf(msgChar));
/*    */   }
/*    */   
/*    */   public int search_keyEvent(char msgChar)
/*    */   {
/* 24 */     int index = -1;
/* 25 */     for (int counter = 0; counter < this.msg_char.size(); counter++)
/*    */     {
/* 27 */       if (msgChar == ((Character)this.msg_char.get(counter)).charValue())
/*    */       {
/* 29 */         index = ((Integer)this.msg_index.get(counter)).intValue();
/* 30 */         break;
/*    */       }
/*    */     }
/* 33 */     return index;
/*    */   }
/*    */ }

