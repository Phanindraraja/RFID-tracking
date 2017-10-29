import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
public class Mains implements ActionListener
{

	private JPanel pnl_mains = null;  //  @jve:decl-index=0:visual-constraint="127,52"
	private JLabel lbl_welcome = null;
	private JRadioButton rbn_dtob = null;
	private JRadioButton rbn_btod = null;
	ButtonGroup rbg = new ButtonGroup();
	private JPanel pnl_calculator = null;  //  @jve:decl-index=0:visual-constraint="580,10"
	private JLabel lbl_dv = null;
	private JTextField txt_dv = null;
	private JButton btn_convert = null;
	private JLabel lbl_bv = null;
	private JTextField jTextField = null;
	
	private JPanel pnl_calculator1 = null;  //  @jve:decl-index=0:visual-constraint="580,10"
	private JLabel lbl_dv1 = null;
	private JTextField txt_dv1 = null;
	private JButton btn_convert1 = null;
	private JLabel lbl_bv1 = null;
	private JTextField jTextField1 = null;
	
	static int DN;
	static double FP;
	static String binaryNumber;
	static String fracpart="";  //  @jve:decl-index=0:
	static String fc="";  //  @jve:decl-index=0:
	static String rp="";  //  @jve:decl-index=0:
	static String fp="";  //  @jve:decl-index=0:
	
	static String fc1="";  //  @jve:decl-index=0:
	static String rp1="";  //  @jve:decl-index=0:
	static String fp1="";  //  @jve:decl-index=0:
	/**
	 * This method initializes pnl_mains	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnl_mains() {
		if (pnl_mains == null) {
			lbl_bv = new JLabel();
			lbl_bv.setBounds(new Rectangle(17, 110, 102, 20));
			lbl_bv.setText("Binary Value");
			lbl_dv = new JLabel();
			lbl_dv.setBounds(new Rectangle(17, 40, 102, 20));
			lbl_dv.setText("Decimal Value");
			lbl_welcome = new JLabel();
			lbl_welcome.setBounds(new Rectangle(173, 14, 77, 20));
			lbl_welcome.setText("Convertor");
			pnl_mains = new JPanel();
			pnl_mains.setLayout(null);
			pnl_mains.setSize(new Dimension(443, 297));
			pnl_mains.add(lbl_welcome, null);
			rbn_dtob = new JRadioButton();
			rbn_dtob.setBounds(new Rectangle(48, 60, 136, 20));
			rbn_dtob.setText("Decimal To Binary");
			
			rbn_btod = new JRadioButton();
			rbn_btod.setBounds(new Rectangle(190, 60, 154, 20));
			rbn_btod.setText("Binary To Decimal");
			
			
			rbg.add(rbn_dtob);
			rbg.add(rbn_btod);
			
			pnl_mains.add(rbn_dtob, null);
			pnl_mains.add(rbn_btod, null);
			pnl_calculator = new JPanel();
			pnl_calculator.setLayout(null);
			pnl_calculator.setBounds(new Rectangle(44, 91, 304, 173));
			pnl_calculator.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			pnl_mains.add(pnl_calculator);
			pnl_calculator.setVisible(false);
			pnl_calculator.add(lbl_dv, null);
			txt_dv = new JTextField();
			txt_dv.setBounds(new Rectangle(125, 40, 162, 20));
			pnl_calculator.add(txt_dv, null);
			btn_convert = new JButton();
			btn_convert.setBounds(new Rectangle(105, 72, 83, 20));
			btn_convert.setText("Convert");
			btn_convert.addActionListener(this);
			pnl_calculator.add(btn_convert, null);
			pnl_calculator.add(lbl_bv, null);
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(125, 109, 162, 20));
			pnl_calculator.add(jTextField, null);
			rbn_btod.addActionListener(this);
			rbn_dtob.addActionListener(this);
			
			lbl_bv1 = new JLabel();
			lbl_bv1.setBounds(new Rectangle(17, 110, 102, 20));
			lbl_bv1.setText("Decimal Value");
			lbl_dv1 = new JLabel();
			lbl_dv1.setBounds(new Rectangle(17, 40, 102, 20));
			lbl_dv1.setText("Binary Value");
			pnl_calculator1 = new JPanel();
			pnl_calculator1.setLayout(null);
			pnl_calculator1.setBounds(new Rectangle(44, 91, 304, 173));
			pnl_calculator1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			pnl_mains.add(pnl_calculator1);
			pnl_calculator1.setVisible(false);
			pnl_calculator1.add(lbl_dv1, null);
			txt_dv1 = new JTextField();
			txt_dv1.setBounds(new Rectangle(125, 40, 162, 20));
			pnl_calculator1.add(txt_dv1, null);
			btn_convert1 = new JButton();
			btn_convert1.setBounds(new Rectangle(105, 72, 83, 20));
			btn_convert1.setText("Convert");
			btn_convert1.addActionListener(this);
			pnl_calculator1.add(btn_convert1, null);
			pnl_calculator1.add(lbl_bv1, null);
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(125, 109, 162, 20));
			pnl_calculator1.add(jTextField1, null);
		}
		return pnl_mains;
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		Mains obj = new Mains();
		jf.add(obj.getPnl_mains());
		jf.setSize(443, 297);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==rbn_dtob)
		{
			if(rbn_dtob.isSelected()==true)
			{
				pnl_calculator.setVisible(true);
				pnl_calculator1.setVisible(false);
				
			}
			else 
			{
				pnl_calculator.setVisible(false);
			}
		}
		else if(ae.getSource()==rbn_btod)
		{
			if (rbn_btod.isSelected()==true)
			{
				pnl_calculator1.setVisible(true);
				pnl_calculator.setVisible(false);
			}
		}
		else if(ae.getSource()==btn_convert)
		{
			fc=txt_dv.getText().toString().trim();
			//System.out.println(fc);
			//System.out.println(fc.lastIndexOf('.'));
			rp=fc.substring(0,fc.lastIndexOf('.'));
			fp="."+fc.substring(fc.lastIndexOf('.')+1,fc.length());
			//System.out.println(rp);
			//System.out.println(fp);
			jTextField.setText("");
			jTextField.setText(DTOB_RPC(Integer.parseInt(rp))+"."+DTOB_FPC(Double.parseDouble(fp)));
			
			
		}
		else if(ae.getSource()==btn_convert1)
		{
			fc1=txt_dv1.getText().toString().trim();
			//System.out.println(fc);
			//System.out.println(fc.lastIndexOf('.'));
			rp1=fc1.substring(0,fc1.lastIndexOf('.'));
			fp1="."+fc1.substring(fc1.lastIndexOf('.')+1,fc1.length());
			//System.out.println(rp);
			//System.out.println(fp);
			jTextField1.setText("");
			System.out.println(fp1);
			jTextField1.setText(BTOD_RP(rp1)+"."+BTOD_FP(fp1));
			
			
		}
	}
	
	
	public static String DTOB_FPC(double fp)
	{
		int temp=0;
		String temps="";
		while(fp!=0)
		{
			fp = fp * 2;
			temp=(int)fp;
			fracpart=fracpart+temp;
			fp=fp-temp;
		}
		//System.out.println(fracpart);
		temps=String.valueOf(fracpart);
		return temps;
	}
	public static String DTOB_RPC(int decimalNumber)
	{
		String temp="";
		if (decimalNumber <= 0)
			System.out.println("ERROR: entered integer is nonpositive.");
		else {
			binaryNumber = "";
			
			while (decimalNumber != 0) 
			{
				if (binaryNumber.length() % 5 == 0)
					binaryNumber = " " + binaryNumber;
				binaryNumber = (decimalNumber % 2) + binaryNumber;
				decimalNumber /= 2;
			}
			//System.out.println("Binary: " + binaryNumber);
		}
		temp=String.valueOf(binaryNumber);
		return temp;
	}
	public static String BTOD_RP(String test)
	{
//		System.out.println(Integer.parseInt(test, 2));
		return String.valueOf(Integer.parseInt(test, 2));
	}
	public static String BTOD_FP(String test)
	{
		String reverse="",outcome="";
		test=test.substring(1,test.length());
		int length = test.length();
		int ch=0;
		double temp=0;
		 
	      for ( int i = length - 1 ; i >= 0 ; i-- )
	         reverse = reverse + test.charAt(i);
	      
	      //System.out.println(reverse);
	      while (length>=1)
	      {
	    	  //System.out.println(length);
	    	  //System.out.println("reverse "+reverse.charAt(ch));
	    	  //System.out.println("temp "+temp);
	    	  
	    	  temp+=Integer.parseInt(String.valueOf(reverse.charAt(ch)))*(1/(Math.pow(2, (int)length)));
	    	  //System.out.println("temp "+temp);
	    	  length--;
	    	  ch++;
	      }
	      outcome=String.valueOf(temp);
	      outcome=outcome.substring(outcome.lastIndexOf('.')+1,outcome.length());
	      return outcome;
	}
}
