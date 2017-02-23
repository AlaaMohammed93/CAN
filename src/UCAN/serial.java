package UCAN;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
//import java.io.OutputStream;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
//import javax.swing.JMenuItem;




//////////////////////////////////////////////
// t2reban jfram w kol ly by3tmd 3lih gui bs

/////////////////////////////////////////////




public class serial
  extends JFrame
{
  private static final long serialVersionUID = 1L;
/*  37 */   public static String[] baudRate = { "5", "10", "20", "31.25", "40", "50", "80", "100", "125", "200", "250", "500", "1000" };
  private GridLayout gLayout;
  
  public serial() {
/*  42 */     super("Connect");
/*  43 */     setDefaultCloseOperation(2);
/*  44 */     setSize(new Dimension(400, 410));
/*  45 */     setResizable(false);
/*  46 */     this.gLayout = new GridLayout(1, 0);
/*  47 */     setLayout(this.gLayout);
/*  48 */     setLocationRelativeTo(this.rootPane);
/*  49 */     //add(Globals.contentPane);
/*  50 */     //BRCB_Add(Globals.contentPane.bitrateComboBox);
    
/*  52 */     addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent windowEvent) {
/*  55 */         serial.this.setVisible(false);
/*  56 */         serial_Globals.AD = new AutoDetect();
      }
      
/*  59 */     });
/*  60 */     serial_Globals.AD = new AutoDetect();
  }
  
			 /* private void BRCB_Add(JComboBox<String> CB) {
			    for (short c = 0; c < 13; c = (short)(c + 1)) {
			      CB.addItem(baudRate[c] + " Kbps");
			     }
			     CB.setSelectedIndex(11);
				}*/

				  /*public static void btns_status(boolean blisconnected)
				  {
				     Globals.tool_disconnect.setEnabled(blisconnected);
				     Globals.tool_connect.setEnabled(!blisconnected);
				     Globals.disconnect.setEnabled(blisconnected);
				     Globals.connect.setEnabled(!blisconnected);
				     Globals.new_message.setEnabled(blisconnected);
				     Globals.edit_message.setEnabled(blisconnected);
				     Globals.send_message.setEnabled(blisconnected);
				     mytoolBar.btns_status(blisconnected);
				 }*/
  
  public static void Serial_Write(byte[] mybyte) {
/*  85 */     if (!serial_Globals.stopWrite) {
      try
      {
/*  88 */         serial_Globals.output.write(mybyte);
      } catch (IOException e) {
/*  90 */         e.printStackTrace();
      }
    }
  }
  
  public static void Serial_Write(int myint)
  {
/*  97 */     if (!serial_Globals.stopWrite) {
      try
      {
/* 100 */         serial_Globals.output.write(myint);
      } catch (IOException e) {
/* 102 */         e.printStackTrace();
      }
    }
  }
}
