/*     */ package UCAN;
/*     */ 
/*     */ import java.io.IOException;
/*     */ //import java.io.PrintStream;
/*     */ //import java.util.ArrayList;
/*     */ import java.util.Timer;
/*     */ //import javax.swing.JCheckBox;
/*     */ //import javax.swing.JLabel;
/*     */ 
/*     */ class SerialReader implements Runnable
/*     */ {
/*  12 */   short Byte_Num = 2;
/*     */   static Timer UCANConfig_Timer;
/*     */   
/*     */   public SerialReader() {
/*  16 */     serial_Globals.state = serial_Globals.connection_state.COMPort_ok;
/*     */   }
/*     */   
/*     */   public void run() {
/*  20 */     byte[] buffer = new byte[13];
/*  21 */     int len = -1;
/*     */     try
/*     */     {
/*  24 */       len = serial_Globals.input.read(buffer);
/*  25 */       while (len > -1) {
/*  26 */         while (len < this.Byte_Num) {
/*  27 */           if (!serial_Globals.stopRead) {
/*  28 */             len += serial_Globals.input.read(buffer, len, this.Byte_Num - len);
/*     */           }
/*     */           else
/*     */           {
/*  32 */             len = 0;
/*  33 */             break;
/*     */           }
/*     */         }
/*  36 */         if (len > 0) {
/*  37 */           switch (serial_Globals.state) {
/*     */           case COMPort_ok: 
/*  39 */             System.out.println("COMPort_ok");
/*  40 */             if ((buffer[0] == 89) && (buffer[1] == 73)) {
/*  41 */               serial_Globals.AD.cancel();
/*  42 */               serial_Globals.AD.purge();
/*  43 */               serial_Globals.UCAN_Timer.cancel();
/*  44 */               serial_Globals.UCAN_Timer.purge();
/*  45 */               UCANConfig_Timer = new Timer();
/*  46 */               UCANConfig_Timer.schedule(new java.util.TimerTask()
/*     */               {
/*     */                 public void run()
/*     */                 {
/*  50 */                   System.out.println("ERROR");
/*  51 */                   if (serial_Globals.blConnect_btn)
/*     */                   {
/*  53 */                     //javax.swing.JOptionPane.showMessageDialog(null, "Error in CAN Configuration", "Configuration error", 0);
								System.out.println("Error in CAN Configuration Configuration error");
/*     */                   }
/*     */                 }
/*  57 */               }, 50L);
/*  58 */               serial.Serial_Write(serial_Globals.BaudRate + 1);
/*  59 */               serial_Globals.state = serial_Globals.connection_state.UCAN_ok;
/*  60 */               this.Byte_Num = 1;
/*     */             }
/*  62 */             break;
/*     */           case UCANConfig_ok: 
/*  64 */             System.out.println("UCAN_ok");
/*  65 */             if (buffer[0] == serial_Globals.BaudRate + 1) {
/*  66 */               UCANConfig_Timer.cancel();
/*  67 */               UCANConfig_Timer.purge();
/*     */               try {
/*  69 */                 serial_Globals.AD_resume.cancel();
/*  70 */                 serial_Globals.AD_resume.purge();
/*     */               }
/*     */               catch (Exception localException) {}
/*     */               
/*  74 */               System.out.println("Connected");
/*  75 */               serial_Globals.Istesting = false;
/*  76 */               //Globals.comPortBar.setString("Connected");
/*  77 */               //Globals.comPortBar.setIndeterminate(false);
/*  78 */               serial_Globals.state = serial_Globals.connection_state.UCANConfig_ok;
/*  79 */               this.Byte_Num = 13;
/*  80 */               //serial.btns_status(true);
/*  81 */               //Globals.TimeCheckBox.setEnabled(true);
/*  82 */               //Globals.TimeCheckBox.setSelected(false);
/*  83 */               //Globals.keyCheckBox.setEnabled(true);
/*  84 */               //Globals.keyCheckBox.setSelected(false);
/*  85 */               //Globals.RTRCheckBox.setEnabled(true);
/*  86 */               //Globals.RTRCheckBox.setSelected(false);
/*  87 */               //Globals.bitRate.setText(Globals.bitRate_string + serial.baudRate[serial_Globals.BaudRate] + "Kbps" + "    ");
/*  88 */               //Globals.statusImageUrl = "/ok.png";
/*  89 */               //Globals.statusImage.setIcon(new javax.swing.ImageIcon(myStatusBar.class.getResource(Globals.statusImageUrl)));
/*  90 */               //Globals.statusConnection.setText("Connected   ");
/*  91 */               Globals.Time_stamp.Start();
/*  92 */               //Globals.audioPath = "/Connect.wav";
/*  93 */              // Globals.player.run(Globals.audioPath);
/*     */             }
/*     */             
/*  96 */             break;
/*     */           case UCAN_ok: 
/*  98 */             RXhandler(buffer);
/*  99 */             break;
/*     */           }
/*     */           
/*     */           
/* 103 */           len = 0;
/*     */         }
/*     */       }
/*     */     } catch (IOException e) {
/* 107 */       Serial_connection.disconnect();
/* 108 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void RXhandler(byte[] RX_bytes)
/*     */   {
/* 116 */     String RTR = "";
/* 117 */     long RXID = RX_bytes[0] & 0xFE | RX_bytes[1] << 8 | RX_bytes[2] << 16 | RX_bytes[3] << 24;
/* 118 */     RXID >>= 1;
/* 119 */     int RXL = RX_bytes[4] & 0xF;
/* 120 */     byte[] data = new byte[RXL];
/* 121 */     if ((RX_bytes[4] & 0x80) != 0)
/*     */     {
/* 123 */       RTR = "RTR";
/*     */     }
/*     */     else
/*     */     {
/* 127 */       RTR = "Data";
/* 128 */       for (short c = 0; c < RXL; c = (short)(c + 1))
/*     */       {
/* 130 */         data[c] = ((byte)(RX_bytes[(5 + c)] & 0xFF));
/*     */       }
/*     */     }
/* 133 */     int index = -1;
/* 134 */     for (short c = 0; c < Globals.RX.size(); c = (short)(c + 1))
/*     */     {
/* 136 */       if (((RXMsg)Globals.RX.get(c)).canID == RXID)
/*     */       {
/* 138 */         index = c;
/* 139 */         break;
/*     */       }
/*     */     }
/* 142 */     if (index == -1)
/*     */     {
/* 144 */       Globals.RX.add(new RXMsg(RXID, data, RTR, RXL));
/*     */     }
/*     */     else
/*     */     {
/* 148 */       ((RXMsg)Globals.RX.get(index)).RXMsg_Update(data, RTR, RXL);
/*     */     }
/* 150 */     //Globals.thrRX_tbl.resume();
/*     */   }
/*     */ }