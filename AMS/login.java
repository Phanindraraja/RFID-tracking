

import javax.swing.JPanel;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class login implements ActionListener
{

	private JPanel pnl_parent = null;  //  @jve:decl-index=0:visual-constraint="377,54"
	private JLabel lbl_welcome = null;
	private JLabel lbl_uname = null;
	private JTextField txt_un = null;
	private JLabel lbl_password = null;
	private JPasswordField tpx_pass = null;
	private JButton btn_submit = null;
	private JButton btn_cancel = null;
	private JLabel lbl_logo = null;
	private JButton btn_fp = null;
	static JFrame frame=null;
	/**
	 * This method initializes pnl_parent	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	public JPanel getPnl_parent() {
		if (pnl_parent == null) {
			lbl_logo = new JLabel();
			lbl_logo.setBounds(new Rectangle(6, 85, 104, 96));
			lbl_logo.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
			lbl_logo.setText("");
			lbl_password = new JLabel();
			lbl_password.setBounds(new Rectangle(119, 130, 90, 20));
			lbl_password.setText("Password");
			lbl_uname = new JLabel();
			lbl_uname.setBounds(new Rectangle(119, 91, 100, 20));
			lbl_uname.setText("Staff User Name");
			lbl_welcome = new JLabel();
			lbl_welcome.setBounds(new Rectangle(27, 42, 363, 23));
			lbl_welcome.setText("Welcome to SASTRA - Attendance Maintanence System (AMS)");
			pnl_parent = new JPanel();
			pnl_parent.setLayout(null);
			pnl_parent.setSize(new Dimension(479, 265));
			pnl_parent.add(lbl_welcome, null);
			pnl_parent.add(lbl_uname, null);
			txt_un = new JTextField();
			txt_un.setBounds(new Rectangle(227, 91, 150, 20));
			pnl_parent.add(txt_un, null);
			pnl_parent.add(lbl_password, null);
			tpx_pass = new JPasswordField();
			tpx_pass.setBounds(new Rectangle(226, 130, 150, 20));
			pnl_parent.add(tpx_pass, null);
			btn_submit = new JButton();
			btn_submit.setBounds(new Rectangle(130, 190, 88, 20));
			btn_submit.setText("Submit");
			pnl_parent.add(btn_submit, null);
			btn_cancel = new JButton();
			btn_cancel.setBounds(new Rectangle(240, 190, 90, 20));
			btn_cancel.setText("Cancel");
			pnl_parent.add(btn_cancel, null);
			pnl_parent.add(lbl_logo, null);
			btn_fp = new JButton();
			btn_fp.setBounds(new Rectangle(236, 154, 137, 20));
			btn_fp.setText("Forget Password");
			pnl_parent.add(btn_fp, null);
			btn_submit.addActionListener(this);
			btn_cancel.addActionListener(this);
		}
		return pnl_parent;
	}

	

	public static void main(String[] args) 
	{
		login lg = new login();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gs = ge.getDefaultScreenDevice();
		frame = new JFrame(gs.getDefaultConfiguration());
		frame.setTitle("Login-AMS");
		frame.setVisible(true);
		frame.add(lg.getPnl_parent());
		Toolkit tk		= Toolkit.getDefaultToolkit();
		int x		= (tk.getScreenSize().width - 600) / 3;
		int y		= (tk.getScreenSize().height - 400) / 2;
		frame.setBounds(500, y, 430, 280);
	}



	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==btn_submit)
		{
			if(ConnectionProvider.getAvailability(txt_un.getText().toString(),tpx_pass.getText().toString()))
			{
				new Home(txt_un.getText().toString().trim());
				frame.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid User Details");
			}
		}
		else if(ae.getSource()==btn_cancel)
		{
			
		}
		
	}
}
