

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Home implements ActionListener {

	private JPanel pnl_parent = null;  //  @jve:decl-index=0:visual-constraint="106,54"
	private JLabel lbl_welcome = null;
	private JButton btn_logout = null;
	private JLabel lbl_filecode = null;
	private JTextField txt_code = null;
	private JButton btn_submit = null;
	public static JFrame frm_container = null; 
	public static String user=null;
	public static JPanel pnl_details = null;
	private JLabel lbl_fn = null;
	public static JTextField txt_fn = null;
	private JLabel lbl_accdate = null;
	public static JTextArea txa_accdate = null;
	public static JLabel lbl_moddate = null;
	public static JTextField txt_moddate = null;
	public static Vector data = new Vector();
	private JScrollPane spnl_additem = null;
	private JTable tbl_additem = null;
	public static DefaultTableModel dft_additem=null;
	public static Vector vct_main=new Vector();
	/**
	 * This method initializes pnl_parent	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	public Home(String username) 
	{
		user=username;
		initialize();
	}
	public void initialize() 
	{
		frm_container = new JFrame(" AMS-SASTRA ");
		
		Toolkit tk		= Toolkit.getDefaultToolkit();
		
		int x		= (tk.getScreenSize().width-1000 ) / 2;
		int y		= (tk.getScreenSize().height-680 ) / 2;
		frm_container.setBounds(x, y, 1000, 700);
		frm_container.setResizable(false);
		frm_container.setSize(new Dimension(1006, 680));
		frm_container.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frm_container.addWindowListener(new WindowListener(){

			public void windowActivated(WindowEvent arg0) {}

			public void windowClosed(WindowEvent arg0) 
			{
				System.exit(0);
			}
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
				
			}

			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		frm_container.add(getPnl_parent());
		frm_container.setVisible(true);
		pnl_parent.setVisible(true);
	}
	public JPanel getPnl_parent() {
		if (pnl_parent == null) {
			lbl_filecode = new JLabel();
			lbl_filecode.setBounds(new Rectangle(179, 76, 122, 20));
			lbl_filecode.setText("Enter the File Code");
			lbl_welcome = new JLabel();
			lbl_welcome.setBounds(new Rectangle(75, 20, 302, 20));
			lbl_welcome.setText("Welcome :  "+user);
			pnl_parent = new JPanel();
			pnl_parent.setLayout(null);
			pnl_parent.setSize(new Dimension(958, 528));
			pnl_parent.add(lbl_welcome, null);
			btn_logout = new JButton();
			btn_logout.setBounds(new Rectangle(793, 20, 77, 20));
			btn_logout.setText("Logout");
			pnl_parent.add(btn_logout, null);
			pnl_parent.add(lbl_filecode, null);
			txt_code = new JTextField();
			txt_code.setBounds(new Rectangle(317, 76, 254, 20));
			pnl_parent.add(txt_code, null);
			btn_submit = new JButton();
			btn_submit.setBounds(new Rectangle(585, 76, 95, 20));
			btn_submit.setText("Submit");
			pnl_parent.add(btn_submit, null);
			pnl_parent.add(getPnl_details(), null);
			pnl_parent.add(getSpnl_additem(), null);
			pnl_details.setVisible(false);
			btn_submit.addActionListener(this);
			btn_logout.addActionListener(this);
		}
		return pnl_parent;
	}
		/**
	 * This method initializes pnl_details	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private  JPanel getPnl_details() {
		if (pnl_details == null) {
			lbl_moddate = new JLabel();
			lbl_moddate.setBounds(new Rectangle(60, 150, 92, 20));
			lbl_moddate.setText("Modified Date");
			lbl_accdate = new JLabel();
			lbl_accdate.setBounds(new Rectangle(60, 60, 91, 20));
			lbl_accdate.setText("Access Date");
			lbl_fn = new JLabel();
			lbl_fn.setBounds(new Rectangle(60, 30, 91, 20));
			lbl_fn.setText("File Name ");
			pnl_details = new JPanel();
			pnl_details.setLayout(null);
			pnl_details.setBounds(new Rectangle(177, 115, 500, 250));
			pnl_details.add(lbl_fn, null);
			txt_fn = new JTextField();
			txt_fn.setBounds(new Rectangle(166, 30, 210, 20));
			pnl_details.add(txt_fn, null);
			pnl_details.add(lbl_accdate, null);
			txa_accdate = new JTextArea();
			txa_accdate.setBounds(new Rectangle(166, 59, 208, 80));
			pnl_details.add(txa_accdate, null);
			pnl_details.add(lbl_moddate, null);
			txt_moddate = new JTextField();
			txt_moddate.setBounds(new Rectangle(166, 150, 208, 20));
			pnl_details.add(txt_moddate, null);
		}
		return pnl_details;
	}
	private JScrollPane getSpnl_additem() {
		if (spnl_additem == null) {
			spnl_additem = new JScrollPane();
			spnl_additem.setBounds(new Rectangle(100, 380, 650, 250));
			Vector vct_additem=new Vector();
			vct_additem.add("S.No");
			vct_additem.add("File Name");
			vct_additem.add("Original Location");
			vct_additem.add("Current Location");
			vct_additem.add("Date - Time");
			dft_additem=new DefaultTableModel(){
				public boolean isCellEditable(int ln_row,int ln_col)
				{
					return false;
				}
			};
			dft_additem.setColumnIdentifiers(vct_additem);
			dft_additem.setRowCount(17);
			
			tbl_additem = new JTable();
			tbl_additem.setModel(dft_additem);
//			tbl_additem.getColumnModel().getColumn(0).setPreferredWidth(50);
//			tbl_additem.getColumnModel().getColumn(1).setPreferredWidth(200);
//			tbl_additem.getTableHeader().setResizingAllowed(false);
			tbl_additem.getTableHeader().setReorderingAllowed(false);
			spnl_additem.setViewportView(tbl_additem);
			spnl_additem.setVisible(false);
			
		}
		return spnl_additem;
	}
		private  static void setnulldata()
		{
			try
			{
				txt_fn.setText("");
				txa_accdate.setText("");
				txt_moddate.setText("");
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) 
		{
	
		}
		public void actionPerformed(ActionEvent ae) 
		{
			if(ae.getSource()==btn_submit)
			{
				try
				{
					if(ConnectionProvider.getavailability1("select code from tbl_codes where code='"+txt_code.getText().toString().trim()+"'"))
					{
						System.out.println("true");
						pnl_details.setVisible(true);
						data=ConnectionProvider.loadfiledata("select Name,Acc_Date,Mod_Date from tbl_codes where code='"+txt_code.getText().toString().trim()+"'");
						System.out.println(data);
						txt_fn.setText(data.get(0).toString().trim());
						txt_moddate.setText(data.get(data.size()-1).toString().trim());
						txa_accdate.setText(data.get(1).toString().trim());
						spnl_additem.setVisible(true);
						if(dft_additem.getRowCount()>0)
						{
							dft_additem.setRowCount(0);
							vct_main=ConnectionProvider.getdataSetall("select * from tbl_location where code = '"+txt_code.getText().trim()+"'");
							System.err.println(vct_main);
							for(int ln_row=0;ln_row<vct_main.size();ln_row++)
							{
								dft_additem.addRow((Vector)vct_main.get(ln_row));
							}
						}
					}
					else
					{
						pnl_details.setVisible(false);
						spnl_additem.setVisible(false);
						setnulldata();
						System.out.println("false");
					}
				}catch (Exception e) 
				{
					// TODO: handle exception
				}
				
			}
			else
			{
				frm_container.dispose();
				System.exit(0);
				
			}
			
		}
	

	
	

}
