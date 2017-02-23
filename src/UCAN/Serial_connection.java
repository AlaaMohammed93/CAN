/*     */ package UCAN;
/*     */ 
/*     */ import gnu.io.CommPort;
/*     */ import gnu.io.CommPortIdentifier;
/*     */ import gnu.io.NoSuchPortException;
/*     */ import gnu.io.PortInUseException;
/*     */ import gnu.io.SerialPort;
/*     */ import java.io.IOException;
/*     */ //import java.io.PrintStream;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ //import javax.swing.JCheckBox;
/*     */ //import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ //import javax.swing.JProgressBar;
/*     */ 
/*     */ public class Serial_connection
/*     */ {
/*     */   static final int TIMEOUT = 2000;
/*  22 */   private static Object stopReadMutex = new Object();
/*  23 */   private static Object stopWriteMutex = new Object();
/*  24 */   private static SerialPort serialPort = null;
/*  25 */   private static CommPort COMPort = null;
/*     */   private static Thread RX_thread;
/*     */   
/*     */   public static void enable_Stream()
/*     */   {
/*  30 */     synchronized (stopReadMutex) {
/*  31 */       serial_Globals.stopRead = false; }
/*  32 */     synchronized (stopWriteMutex) {
/*  33 */       serial_Globals.stopWrite = false;
/*     */     }
/*     */   }
/*     */   
/*  37 */   public static void disable_Stream() { synchronized (stopReadMutex) {
/*  38 */       serial_Globals.stopRead = true; }
/*  39 */     synchronized (stopWriteMutex) {
/*  40 */       serial_Globals.stopWrite = true;
/*     */     }
/*     */   }
/*     */   
/*  44 */   public static List<String> Get_Ports() { List<String> AV_Ports = new java.util.ArrayList();
/*  45 */     Enumeration<?> ports = null;
/*     */     
/*  47 */     ports = CommPortIdentifier.getPortIdentifiers();
/*     */     
/*  49 */     while (ports.hasMoreElements()) {
/*  50 */       CommPortIdentifier curPort = (CommPortIdentifier)ports.nextElement();
/*     */       
/*     */ 
/*  53 */       if (curPort.getPortType() == 1) {
/*  54 */         AV_Ports.add(curPort.getName());
/*     */       }
/*     */     }
/*  57 */     return AV_Ports;
/*     */   }
/*     */   
/*     */   public static void Start_connection()
/*     */   {
/*  62 */     serial_Globals.Istesting = true;
/*  63 */     CommPortIdentifier selectedPortIdentifier = null;
/*     */     try
/*     */     {
/*  66 */       selectedPortIdentifier = CommPortIdentifier.getPortIdentifier(serial_Globals.selectedPort);
/*     */     } catch (NoSuchPortException e1) {
/*  68 */       e1.printStackTrace();
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  73 */       COMPort = selectedPortIdentifier.open("TigerControlPanel", 2000);
/*     */       
/*  75 */       serialPort = (SerialPort)COMPort;
/*     */       
/*  77 */       serialPort.setSerialPortParams(115200, 8, 1, 
/*  78 */         0);
/*  79 */       serialPort.setDTR(true);
/*  80 */       serial_Globals.input = serialPort.getInputStream();
/*  81 */       serial_Globals.output = serialPort.getOutputStream();
/*  82 */       RX_thread = new Thread(new SerialReader());
/*  83 */       RX_thread.start();
/*  84 */       enable_Stream();
/*  85 */       Timer tmrInit = new Timer();
/*  86 */       tmrInit.schedule(new TimerTask()
/*     */       {
/*     */         public void run()
/*     */         {
/*  90 */           byte[] b = { 105, 115, 85, 50, 67 };
/*  91 */           serial_Globals.UCAN_Timer = new Timer();
/*  92 */           serial_Globals.UCAN_Timer.schedule(new TimerTask()
/*     */           {
/*     */             public void run()
/*     */             {
/*  96 */               System.out.println("error not UCAN");
/*  97 */               serial_Globals.Ports_list.add(serial_Globals.selectedPort);
/*  98 */               Serial_connection.disconnect();
/*  99 */               if (serial_Globals.blConnect_btn)
/*     */               {
/* 101 */                 //JOptionPane.showMessageDialog(null, serial_Globals.selectedPort + " is not UCAN device","COM port warning", 2);
								
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							System.out.println(serial_Globals.selectedPort + "is not UCAN device COM port warning");
/* 103 */                 serial_Globals.blConnect_btn = false;
/*     */               }
/*     */               
/*     */             }
/*     */             
/* 108 */           }, 50L);
/* 109 */           serial.Serial_Write(b);
/*     */         }
/* 111 */       }, 2000L);
/*     */       
/* 113 */       System.out.println("port " + serial_Globals.selectedPort + " is opened");
/*     */     } catch (PortInUseException e) {
/* 115 */       serial_Globals.Ports_list.add(serial_Globals.selectedPort);
/* 116 */       System.out.println(serial_Globals.selectedPort + " is in use. (" + e.toString() + ")");
/* 117 */       if (serial_Globals.blConnect_btn)
/*     */       {
/* 119 */         //JOptionPane.showMessageDialog(null, serial_Globals.selectedPort + " is in use", "COM port error", 0);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println(serial_Globals.selectedPort + " is in use COM port error");
/* 121 */         serial_Globals.blConnect_btn = false;
/*     */       }
/*     */     } catch (Exception e) {
/* 124 */       serial_Globals.Ports_list.add(serial_Globals.selectedPort);
/* 125 */       System.out.println("Failed to open " + serial_Globals.selectedPort + "(" + e.toString() + ")");
/* 126 */       if (serial_Globals.blConnect_btn)
/*     */       {
/* 128 */         //JOptionPane.showMessageDialog(null, "Failed to open " + serial_Globals.selectedPort, "COM port error", 0);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
System.out.println("Failed to open " + serial_Globals.selectedPort + "COM port error");


/* 130 */         serial_Globals.blConnect_btn = false;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void disconnect()
/*     */   {
/*     */     try
/*     */     {
/* 139 */       disable_Stream();
/* 140 */       serial_Globals.output.close();
/* 141 */       serial_Globals.input.close();
/* 142 */       serialPort.close();
/*     */     } catch (IOException e) {
/* 144 */       e.printStackTrace();
/*     */     }
/* 146 */     serial_Globals.Istesting = false;
/* 147 */     if (serial_Globals.state != serial_Globals.connection_state.COMPort_ok)
/*     */     {
/* 149 */       serial_Globals.AD_resume = new Timer();
/* 150 */       serial_Globals.AD_resume.schedule(new TimerTask()
/*     */       {
/*     */         public void run()
/*     */         {
/* 154 */           serial_Globals.AD = new AutoDetect();
/*     */         }
/* 156 */       }, 10000L);
/* 157 */       //Globals.comPortBar.setString("Disconnected");
/* 158 */       //Globals.comPortBar.setIndeterminate(false);
/* 159 */       //Globals.TimeCheckBox.setEnabled(false);
/* 160 */       //Globals.TimeCheckBox.setSelected(true);
/* 161 */       //Globals.keyCheckBox.setEnabled(false);
/* 162 */       //Globals.keyCheckBox.setSelected(true);
/* 163 */       //Globals.RTRCheckBox.setEnabled(false);
/* 164 */       //Globals.RTRCheckBox.setSelected(true);
/* 165 */       //serial.btns_status(false);
/* 166 */       //Globals.bitRate.setText(Globals.bitRate_string + "       ");
/* 167 */       //Globals.statusImageUrl = "/no.png";
/* 168 */       //Globals.statusImage.setIcon(new javax.swing.ImageIcon(myStatusBar.class.getResource(Globals.statusImageUrl)));
/* 169 */       //Globals.statusConnection.setText("Disconnected   ");
/* 170 */       //Globals.audioPath = "/Disconnect.wav";
/* 171 */       //Globals.player.run(Globals.audioPath);
/*     */     }
/* 173 */     if (serial_Globals.blDisConnect_btn)
/*     */     {
/* 175 */       serial_Globals.Ports_list.add(serial_Globals.selectedPort);
/* 176 */       serial_Globals.blDisConnect_btn = false;
/*     */     }
/* 178 */     Globals.Time_stamp.cancel();
/* 179 */     RX_thread.stop();
/*     */   }
/*     */ }
