/*    */ package UCAN;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Timer;
/*    */ 
/*    */ public class serial_Globals
/*    */ {
/* 11 */   public static boolean Istesting = false;
/* 12 */   public static List<String> Ports_list = new ArrayList();
/*    */   public static String selectedPort;
/* 14 */   public static enum connection_state { COMPort_ok,  UCAN_ok,  UCANConfig_ok; }
/*    */   
/*    */   public static connection_state state;
/*    */   public static InputStream input;
/* 18 */   public static OutputStream output; public static boolean stopRead = true;
/* 19 */   public static boolean stopWrite = true;
/*    */   public static AutoDetect AD;
/*    */   public static Timer UCAN_Timer;
/* 22 */   public static boolean blConnect_btn = false;
/* 23 */   public static boolean blDisConnect_btn = false;
/*    */   public static Timer AD_resume;
/* 25 */   public static int BaudRate = 11;
/*    */ }
