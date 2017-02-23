 package UCAN;
/*     */ 

 
 
public class recieve_alaa
{
			private String data_prep(byte[] b, int Len)
/*     */   {
/*  85 */     String data = "";
/*  86 */     for (short c = 0; c < Len; c = (short)(c + 1))
/*     */     {
/*  88 */       switch (Globals.data_Format) {
/*     */       case 0: 
/*  90 */         data = data + String.format("%02X", new Object[] { Integer.valueOf(b[c] & 0xFF) });
/*  91 */         break;
/*     */       case 1: 
/*  93 */         data = data + String.format("%d", new Object[] { Integer.valueOf(b[c] & 0xFF) });
/*  94 */         break;
/*     */       case 2: 
/*  96 */         data = data + "'" + (char)(b[c] & 0xFF) + "'";
/*  97 */         break;
/*     */       }
/* 101 */       if (c < Len - 1)
/*     */       {
/* 103 */         if (Globals.data_Format == 2)
/*     */         {
/* 105 */           data = data + "  -  ";
/*     */         }
/*     */         else
/*     */         {
/* 109 */           data = data + "-";
/*     */         }
/*     */       }
/*     */     }
/* 113 */     return data;
/*     */   }
/*     */   
/*     */   private String[] ID_prep(long ID)
/*     */   {
/* 118 */     String[] CAN_ID = new String[3];
/* 119 */     CAN_ID[1] = ("0x" + String.format("%02X", new Object[] { Long.valueOf(ID) }));
/* 120 */     CAN_ID[2] = String.format("%d", new Object[] { Long.valueOf(ID) });
/* 121 */     switch (Globals.ID_Format) {
/*     */     case 0: 
/* 123 */       CAN_ID[0] = CAN_ID[1];
/* 124 */       break;
/*     */     case 1: 
/* 126 */       CAN_ID[0] = CAN_ID[2];
/* 127 */       break;
/*     */     }
/*     */     
/*     */     
/* 131 */     return CAN_ID;
/*     */   }
}