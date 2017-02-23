 package UCAN;
 
 //import java.awt.Color;
 //import java.awt.GridLayout;
 //import java.awt.Rectangle;
 import java.util.ArrayList;
 //import javax.swing.JButton;
 //import javax.swing.JCheckBox;
 //import javax.swing.JCheckBoxMenuItem;
 //import javax.swing.JLabel;
 //import javax.swing.JMenuItem;
 //import javax.swing.JPanel;
 //import javax.swing.JProgressBar;
 //import javax.swing.JTabbedPane;
 //import javax.swing.JTextField;
 //import javax.swing.border.LineBorder;
 //import javax.swing.table.DefaultTableModel;

 public class Globals
 {
	 		//public static myFrame frmUcanG;
/*  35 */   //public static myMenu file = new myMenu("File");
/*  36 */   //public static myMenu edit = new myMenu("Edit");
/*  37 */   //public static myMenu CAN = new myMenu("CAN Setting");
/*  38 */   //public static myMenu transmit = new myMenu("Transmit");
/*  39 */   //public static myMenu help = new myMenu("Help");
/*  40 */  // public static JMenuItem open = new JMenuItem("Open");
/*  41 */   //public static JMenuItem save = new JMenuItem("Save");
/*  42 */   //public static JMenuItem saveas = new JMenuItem("Save As");
/*  43 */   //public static myMenu setting = new myMenu("Setting");
/*  44 */   //public static JMenuItem exit = new JMenuItem("Exit");
/*  45 */   //public static JMenuItem connect = new JMenuItem("Connect");
/*  46 */   //public static JMenuItem disconnect = new JMenuItem("Disconnect");
/*  47 */   //public static JMenuItem reset = new JMenuItem("Reset");
/*  48 */   //public static JMenuItem new_message = new JMenuItem("New Message");
/*  49 */   //public static JMenuItem edit_message = new JMenuItem("Edit Message");
/*  50 */   //public static JMenuItem send_message = new JMenuItem("Send Message");
/*  51 */   //public static myMenu themeMenu = new myMenu("Theme");
   
 
/*  54 */   //public static JLabel resizeLabel = new JLabel();
/*  55 */   //public static LineBorder mainFrameBorder = new LineBorder(Color.DARK_GRAY, 2);
   
 
/*  58 */   //public static JLabel titleLabel = new JLabel(" UCAN 1.2 ");
   
 
/*  61 */   //public static Rectangle boundFrame = new Rectangle();
/*  62 */   //public static myMenu canid_format = new myMenu("CAN ID Format");
/*  63 */   //public static myMenu data_format = new myMenu("Data Byte Format");
   
/*  65 */  // public static JTabbedPane tabbedPane = new JTabbedPane();
/*  66 */   //public static GridLayout layout = new GridLayout(2, 1);
   
/*  68 */   //public static JLabel closeLabel = new JLabel(" ");
/*  69 */   //public static JLabel maxLabel = new JLabel(" ");
/*  70 */   //public static JLabel minLabel = new JLabel(" ");
   
/*  72 */   //public static JPanel panelTable = new JPanel();
/*  73 */   //public static JPanel panelSetting = new JPanel();
   
/*  75 */   //public static DefaultTableModel model_receive = new DefaultTableModel();
/*  76 */   //public static DefaultTableModel model_transmit = new DefaultTableModel();
/*  77 */   //public static short[] widthColumnReceive = { 5, 5, 20, 300, 5, 5 };
/*  78 */   //public static short[] widthColumnTransmit = { 50, 50, 50, 250, 5, 5, 5, 5 };
/*  79 */   //public static myButton tool_connect = new myButton("", new ImageIcon(mytoolBar.class.getResource("/connect.png")));
/*  80 */   //public static myButton tool_disconnect = new myButton("", new ImageIcon(mytoolBar.class.getResource("/disconnect.png")));
/*  81 */   //public static Object[] receive_columns = { "CAN ID", "Type", "DLC", "Data", "Cycle Time", "Count" };
/*  83 */   //public static String[][] receive_rows = { { "", "", "", "", "", "" } };
/*  84 */   //public static String[][] transmit_rows = { { "", "", "", "", "", "", "", "" } };
/*  85 */   //public static Object[] transmit_columns = { "CAN ID", "Type", "DLC", "Data",  "Cycle Time", "Count", "Trigger", "Sending" };
   
 
/*  89 */   //public static connectPanel contentPane = new connectPanel();
   
/*  91 */   //public static JLabel statusConnection = new JLabel("Disconnected   ");
/*  92 */   //public static JLabel statusImage = new JLabel();
   			//public static String statusImageUrl;
/*  94 */   //public static JLabel statusLabel = new JLabel(" Status: ");
/*  95 */   //public static String bitRate_string = "                                  Bit Rate: ";
/*  96 */   //public static JLabel bitRate = new JLabel(bitRate_string + "                     ");
			//public static JProgressBar comPortBar;
/*  98 */   //public static JLabel lbKeyPress = new JLabel("    Key:              ");
   
/* 100 */   //public static myTable receiveTable = new myTable(receive_rows, receive_columns, model_receive, widthColumnReceive);
/* 101 */   //public static myTable transmitTable = new myTable(transmit_rows, transmit_columns, model_transmit, widthColumnTransmit);
   
/* 103 */   //public static JCheckBoxMenuItem data_hexa = new JCheckBoxMenuItem("Hexadecimal");
/* 104 */   //public static JCheckBoxMenuItem data_decimal = new JCheckBoxMenuItem("Decimal");
/* 105 */   //public static JCheckBoxMenuItem data_ascii = new JCheckBoxMenuItem("ASCII");
/* 106 */   //public static JCheckBoxMenuItem canid_hexa = new JCheckBoxMenuItem("Hexadecimal");
/* 107 */   //public static JCheckBoxMenuItem canid_decimal = new JCheckBoxMenuItem("Decimal");
/* 108 */   //public static JCheckBoxMenuItem themeBlack = new JCheckBoxMenuItem("Dark Gray");
/* 109 */   //public static JCheckBoxMenuItem themeWhite = new JCheckBoxMenuItem("Silver White");
   
			public static serial Serial_frame;
/* 112 */   public static ArrayList<TXMsg> TX = new ArrayList();
/* 113 */   public static ArrayList<RXMsg> RX = new ArrayList();
   
/* 115 */   //public static JPanel statusPanel = new JPanel();
/* 116 */   //public static myMenuBar menuBar = new myMenuBar();
/* 117 */   //public static mytoolBar toolBar = new mytoolBar();
   
/* 119 */   //public static myThemes theme = new myThemes();
   
/* 121 */   //public static JCheckBox TimeCheckBox = new JCheckBox("Time");
/* 122 */   //public static JCheckBox keyCheckBox = new JCheckBox("Key");
/* 123 */   //public static JCheckBox RTRCheckBox = new JCheckBox("Remote Frame");
   
/* 125 */   //public static panelTransmit txPanel = new panelTransmit();
/* 126 */   public static transmitFrame txFrame = new transmitFrame();
   
/* 128 */   //public static JTextField[] txTextField = new JTextField[12];
/* 129 */   //public static JLabel[] labelTxPanel = new JLabel[14];
/* 130 */   //public static JButton[] buttonTxPanel = new JButton[2];
   
/* 132 */   //public static tableReceiveThread thr = new tableReceiveThread();
/* 133 */   //public static String audioPath = new String();
/* 134 */   //public static myAudioPlayer player = new myAudioPlayer();
   
   			//public static tableReceiveThread thrRX_tbl;
   
   			//static tableTransmitThread thrTX_tbl;
   
   			public static short data_Format;
   			public static short ID_Format;
/* 142 */   public static Key_Class Key_Event = new Key_Class();
/* 143 */   public static boolean ispanelTX_open = false;
   
/* 145 */   public static stampTimer Time_stamp = new stampTimer();
 }
