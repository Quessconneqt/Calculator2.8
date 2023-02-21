package dbconnection;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import java.math.RoundingMode;  
import java.text.DecimalFormat;  

public class DisplayDataFromDatabase extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table_2;
	private JButton btnCi_Acct_Char;
	private JTable table_3;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table_4;
	private DefaultTableModel model;
	private JTable table_5;
	private JTable table;
	private JTextField textField;
	private JLabel lblBill_Id;
	private String text;
	private JTable table_6;
	private JScrollPane scrollPane_4;
	private JButton btnci_bseg_sq;
	private JTable table_7;
	private JScrollPane scrollPane_5;
	private JTable table_8;
	private JTable table_9;
	private JTextField ECtextField;
	private String text2;
	private String text3;
	private String Percent_text;
	private JLabel lblFCRate;
	private JTextField FCtextField;
	private int IntManualFC;
	private final JButton btnNextStepCheck = new JButton("ED Result");
	private JTable table_11;
	private JTextField Percent_textField;
	private static final DecimalFormat decfor = new DecimalFormat("0.00");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDataFromDatabase frame = new DisplayDataFromDatabase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	
	public DisplayDataFromDatabase() throws SQLException, ClassNotFoundException, IOException {
		MemoryManagementCommonData mmcd = new MemoryManagementCommonData();
		getContentPane().setLayout(null);
		
		table_2 = new JTable();
		table_2.setBounds(180, 11, 246, 184);
		getContentPane().add(table_2);
		getContentPane().setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(176, 11, 250, 174);
		getContentPane().add(table_1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1301, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 74, 74));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream("C:\\Users\\301584\\eclipse-workspace\\CCBDatabse\\Config.properties");
//		prop.load(fis);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		textField.setBounds(72, 13, 144, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblBill_Id = new JLabel("BILL ID");
		lblBill_Id.setForeground(new Color(255, 255, 255));
		lblBill_Id.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		lblBill_Id.setBounds(10, 7, 76, 30);
		contentPane.add(lblBill_Id);
		
		JButton btnCi_Sa_Char = new JButton("LMV, ST TYPE, ED FLAG, LT CONSUMER");
		btnCi_Sa_Char.setForeground(new Color(255, 255, 255));
		btnCi_Sa_Char.setBounds(61, 53, 271, 23);
		
		
		 btnCi_Sa_Char.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 MemoryManagementCommonData mmcd = new MemoryManagementCommonData();
            	 
            	 text = textField.getText();
            	 try {
            		 
            		 String HalfQuery ="SELECT A.sa_id, A.char_type_cd, A.char_val \r\n"
            		 		+ "from cisadm.ci_sa_char A\r\n"
            		 		+ "inner join cisadm.ci_bseg B\r\n"
            		 		+ "on A.sa_id = B.sa_id \r\n"
            		 		+ "where A.char_type_cd in('CMSTCD','EDEXMFLG','LTHT','PUROFSUP') and B.bill_id=";
					mmcd.commonDataThreeColumns(HalfQuery+"'"+text+"'", table);
            		 
//				MouseEvent me = null;
//				if (me.getClickCount()==2) {
//					model.setRowCount(0);
//				};
				
//			        int columnIndex = 2; 
//			        TableModel model = table.getModel();
//			       String val= (String) model.getValueAt(2, 2);
//			       int intval=Integer.parseInt(val);
//			       
//			       System.out.println(val);

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
             }
            
          	
      });
		
		contentPane.setLayout(null);
		btnCi_Sa_Char.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		contentPane.add(btnCi_Sa_Char);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBounds(1160, 13, 89, 23);
		btnClear.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				table_3.setModel(new DefaultTableModel());
				table_4.setModel(new DefaultTableModel());
				table_5.setModel(new DefaultTableModel());
				table_6.setModel(new DefaultTableModel());
				table_7.setModel(new DefaultTableModel());
				table_8.setModel(new DefaultTableModel());
				table_9.setModel(new DefaultTableModel());
			//	table_10.setModel(new DefaultTableModel());
				table_11.setModel(new DefaultTableModel());
			}
		});
		contentPane.add(btnClear);
		
		btnCi_Acct_Char = new JButton("POWERLOOM,GOVT CONSUMER");
		btnCi_Acct_Char.setForeground(new Color(255, 255, 255));
		btnCi_Acct_Char.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnCi_Acct_Char.setBounds(517, 17, 271, 23);
		contentPane.add(btnCi_Acct_Char);
		
		btnCi_Acct_Char.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MemoryManagementCommonData mmcd = new MemoryManagementCommonData();
            	text = textField.getText();
            	try {
            		String HalfQuery2 ="select A.acct_id, A.char_type_cd, A.char_val \r\n"
            				+ "from cisadm.ci_acct_char A\r\n"
            				+ "inner join cisadm.ci_bill B\r\n"
            				+ "on A.Acct_id = B.Acct_id \r\n"
            				+ "where A.char_type_cd in ('CONST','TYPEUNIT') AND B.bill_id=";
					mmcd.commonDataThreeColumns(HalfQuery2+"'"+text+"'", table_3);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
     });
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 87, 396, 101);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(460, 56, 396, 60);
		contentPane.add(scrollPane_1);
		
		table_3 = new JTable();
		table_3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		scrollPane_1.setViewportView(table_3);
		
		table_4 = new JTable(model);
		table_4.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(460, 161, 396, 263);
		contentPane.add(scrollPane_2);
		
		scrollPane_2.setViewportView(table_4);
		
		JButton btnci_bseg_calc_ln = new JButton("CALC LINE Data -FC,EC,ED,CS etc");
		btnci_bseg_calc_ln.setForeground(new Color(255, 255, 255));
		btnci_bseg_calc_ln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemoryManagementCommonData mmcd = new MemoryManagementCommonData();
				text = textField.getText();
				try {
					String HalfQuery3 ="select A.bseg_id, A.descr_on_bill, A.audit_calc_amt \r\n"
							+ "from cisadm.ci_bseg_calc_ln A\r\n"
							+ "inner join cisadm.ci_bseg B\r\n"
							+ "on A.bseg_id = B.bseg_id\r\n"
							+ "where B.bill_id=";
					mmcd.commonDataThreeColumns(HalfQuery3+"'"+text+"'", table_4);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        }
				
		});
		btnci_bseg_calc_ln.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnci_bseg_calc_ln.setBounds(517, 127, 271, 23);
		contentPane.add(btnci_bseg_calc_ln);
		
		JButton btnci_bseg_calc_ln2 = new JButton("BSQ");
		btnci_bseg_calc_ln2.setForeground(new Color(255, 255, 255));
		btnci_bseg_calc_ln2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemoryManagementCommonData mmcd = new MemoryManagementCommonData();
				text = textField.getText();
				try {
					String HalfQuery4="select B.bseg_id, B.sqi_cd, B.bill_sq \r\n"
							+ "from cisadm.ci_bseg A\r\n"
							+ "inner join cisadm.ci_bseg_calc_ln B\r\n"
							+ "on A.bseg_id = B.bseg_id \r\n"
							+ "WHERE B.sqi_cd in('X-SLFC','X-R100','X-SLB50','X-SLB300','X-SLB500') and A.bill_id=";
					mmcd.commonDataThreeColumns(HalfQuery4+"'"+text+"'", table_5);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnci_bseg_calc_ln2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnci_bseg_calc_ln2.setBounds(887, 158, 230, 23);
		contentPane.add(btnci_bseg_calc_ln2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(889, 212, 394, 101);
		contentPane.add(scrollPane_3);
		
		table_5 = new JTable();
		table_5.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		scrollPane_3.setViewportView(table_5);
		
		JButton btnci_sa_cont_qty = new JButton("SANCTION LOAD");
		btnci_sa_cont_qty.setForeground(new Color(255, 255, 255));
		btnci_sa_cont_qty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemoryManagementCommonData mmcd = new MemoryManagementCommonData();
				text = textField.getText();
				try {
					String HalfQuery5="select A.sa_id, A.cont_qty_type_cd, A.cont_qty \r\n"
							+ "from cisadm.ci_sa_cont_qty A\r\n"
							+ "inner join cisadm.ci_bseg B\r\n"
							+ "on A.sa_id = B.sa_id \r\n"
							+ "where A.cont_qty_type_cd IN ('SANCBHP','SANCKVA','SANCKW') and b.bill_id =";
					mmcd.commonDataThreeColumns(HalfQuery5+"'"+text+"'", table_6);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnci_sa_cont_qty.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnci_sa_cont_qty.setBounds(878, 13, 230, 23);
		contentPane.add(btnci_sa_cont_qty);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(878, 56, 405, 72);
		contentPane.add(scrollPane_4);
		
		table_6 = new JTable();
		table_6.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		scrollPane_4.setViewportView(table_6);
		
		btnci_bseg_sq = new JButton("BILL DAYS, NO OF MONTH");
		btnci_bseg_sq.setForeground(new Color(255, 255, 255));
		btnci_bseg_sq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemoryManagementCommonData mmcd = new MemoryManagementCommonData();
				text = textField.getText();
				try {
					String HalfQuery7="select A.bseg_id, A.sqi_cd, A.bill_sq \r\n"
							+ "from cisadm.ci_bseg_sq A\r\n"
							+ "inner join cisadm.ci_bseg B\r\n"
							+ "on A.bseg_id = B.bseg_id\r\n"
							+ "where A.sqi_cd in ('BILLDAYS','FC') and B.bill_id=";
					mmcd.commonDataThreeColumns(HalfQuery7+"'"+text+"'", table_7);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnci_bseg_sq.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnci_bseg_sq.setBounds(72, 199, 230, 23);
		contentPane.add(btnci_bseg_sq);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 233, 394, 94);
		contentPane.add(scrollPane_5);
		
		table_7 = new JTable();
		table_7.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		scrollPane_5.setViewportView(table_7);
		
		JButton btnCheckFC = new JButton("CHECK FC");
		btnCheckFC.setForeground(new Color(255, 255, 255));
		btnCheckFC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemoryManagementCommonData mmcd = new MemoryManagementCommonData();
				text = textField.getText();
				text2 =FCtextField.getText();
				try {
					mmcd.commonDataEightColumns("SELECT BSEG_ID,DESCR_ON_BILL,CCB_BSQ,MANUAL_BSQ_FC,CALC_AMT CCB_FC,CONT_QTY,MSR_QTY,CALCULATED_FC from\r\n"
							+ "(SELECT A.*,manual_bsq_fc * "+""+ text2 +""+" CALCULATED_FC, CASE WHEN CCB_BSQ = manual_bsq_fc THEN 'PASS' ELSE 'FAIL' END RESULT_BSQ,\r\n"
							+ "CASE WHEN CALC_AMT = manual_bsq_fc * "+""+ text2 +""+" THEN 'PASS' ELSE 'FAIL' END RESULT_FC_AMOUNT,\r\n"
							+ "row_number()over(partition by bseg_id order by CONT_QTY desc) rn\r\n"
							+ "FROM\r\n"
							+ "(SELECT A.BSEG_ID,A.DESCR_ON_BILL,A.BILL_SQ CCB_BSQ,\r\n"
							+ "case when A.DESCR_ON_BILL like '%LT%' then greatest(CONT_QTY*.75,MSR_QTY)* e.CHAR_VAL\r\n"
							+ "     when MSR_QTY < CONT_QTY and A.DESCR_ON_BILL not like '%LT%' AND CONT_QTY_TYPE_CD = 'SANCBHP' and A.sqi_cd <> 'XXSLKVFC' then ROUND(greatest((CONT_QTY),MSR_QTY)*0.7457,2)\r\n"
							+ "     when MSR_QTY > CONT_QTY and A.DESCR_ON_BILL not like '%LT%' AND CONT_QTY_TYPE_CD = 'SANCBHP' and A.sqi_cd <> 'XXSLKVFC' then ROUND(greatest((CONT_QTY),MSR_QTY)*0.7457,2)\r\n"
							+ "     when MSR_QTY > CONT_QTY and A.DESCR_ON_BILL not like '%LT%' AND CONT_QTY_TYPE_CD = 'SANCBHP' and A.sqi_cd = 'XXSLKVFC' \r\n"
							+ "     then round(greatest(((CONT_QTY*.7457)/.9),MSR_QTY),2)\r\n"
							+ "     when MSR_QTY < CONT_QTY and A.DESCR_ON_BILL not like '%LT%' AND CONT_QTY_TYPE_CD = 'SANCBHP' and A.sqi_cd = 'XXSLKVFC' \r\n"
							+ "     then round(greatest(((CONT_QTY*.7457)/.9),MSR_QTY),2)\r\n"
							+ "--     when MSR_QTY >= 0 and A.DESCR_ON_BILL not like '%LT%' and A.SQI_CD LIKE '%KW%' then greatest((CONT_QTY*.75),MSR_QTY) \r\n"
							+ "     when MSR_QTY >= 0 and A.DESCR_ON_BILL not like '%LT%' and A.sqi_cd = 'XXSLKVFC' then round(greatest((CONT_QTY/.9),MSR_QTY),2)\r\n"
							+ "     when MSR_QTY >= 0 and A.DESCR_ON_BILL not like '%LT%' then round(greatest(((CONT_QTY/.9)*.75),MSR_QTY),2)\r\n"
							+ "     else CONT_QTY end manual_bsq_fc,calc_amt,d.CONT_QTY,MSR_QTY \r\n"
							+ "FROM CISADM.CI_BSEG_CALC_LN A,CISADM.ci_bseg_read b,CISADM.CI_BSEG c, CISADM.ci_sa_cont_qty d,CISADM.ci_sa_char e,CISADM.CI_BILL F\r\n"
							+ "WHERE A.BSEG_ID = B.BSEG_ID\r\n"
							+ "AND B.bseg_id = C.bseg_id\r\n"
							+ "AND c.SA_ID = d.SA_ID\r\n"
							+ "and d.sa_id = e.sa_id\r\n"
							+ "AND C.BILL_ID = F.BILL_ID\r\n"
							+ "and e.CHAR_TYPE_CD in ('EDEXMFLG')\r\n"
							+ "AND d.CONT_QTY_TYPE_CD IN ('SANCKW','SANCKVA','SANCBHP')\r\n"
							+ "AND b.UOM_CD IN ('KVA','KW','BHP')\r\n"
							+ "AND F.bill_id ="+"'"+ text +"'"+"--'256520170230'--'008994670063'--'382005491844'--'382005491844'--'197852056454'\r\n"
							+ "--'521205728985' --'521209227610'  ----'042200491644' --'987604553007'  --'162057191014'  -- FOR SLAB 257005725419\r\n"
							+ "--AND A.BSEG_ID in ('125203158183','872009589077','026508445804','157442704257','847305336827','042205048227') --872009589077 (prob - 343662420326)  026508445804 157442704257\r\n"
							+ "and A.DESCR_ON_BILL like '%Fixed Charge%'\r\n"
							+ "and A.DESCR_ON_BILL not like '%Summary%') A) where rn = 1 \r\n"
							+ "", table_8);
					
					
					DefaultTableModel model = (DefaultTableModel) table_8.getModel();
					
					 int columnIndex = 7; 
				     TableModel model2 = table_8.getModel();
				    String ManualFC= (String) model2.getValueAt(0, 7);
				    String CCBFC= (String) model2.getValueAt(0, 4);
				    String ManualBSQ= (String) model2.getValueAt(0, 3);
				    String CCBBSQ= (String) model2.getValueAt(0, 2);
				   // String FCSum= (String) model2.getValueAt(0, 8);
				    
				    System.out.println("String Manual FC = "+ ManualFC);
				    System.out.println("String CCB FC = "+ CCBFC);
				    System.out.println("String Manual BSQ = "+ ManualBSQ);
				    System.out.println("String CCB BSQ = "+ CCBBSQ);
				  //  System.out.println("String FCSUM = "+ FCSum);
				    
				    double doubleManualFC = Double.parseDouble(ManualFC);
				    double doubleCCBFC = Double.parseDouble(CCBFC);
				    double doubleManualBSQ = Double.parseDouble(ManualBSQ);
				    double doubleCCBBSQ = Double.parseDouble(CCBBSQ);
				  //  double doubleFCSum = Double.parseDouble(FCSum);
				    
				    String result;
				    String result1;
				    if(doubleManualFC==doubleCCBFC) {
				    	
				    result = "PASS";
				    }
				    else {
				    result = "FAIL";
				    }
				    
					model.setValueAt(result, 0, 10);
					
					if(doubleManualBSQ==doubleCCBBSQ) {
				    	
					    result1 = "PASS";
					    }
					    else {
					    result1 = "FAIL";
					    }
					
					model.setValueAt(result1, 0, 9);
				    
				    System.out.println("String Manual FC = "+ ManualFC);
				    
				    String FCSummary=mmcd.FCSummary("SELECT A.CALC_AMT FC_SUMMARY \r\n"
				    		+ "FROM CISADM.CI_BSEG_CALC_LN A,CISADM.CI_BSEG B,CISADM.CI_BILL C\r\n"
				    		+ "WHERE A.BSEG_ID = B.BSEG_ID\r\n"
				    		+ "AND B.BILL_ID = C.BILL_ID\r\n"
				    		+ "AND C.BILL_ID = "+ "'" +text+ "'" + "    --Here you can input the BILL_id\r\n"
				    		+ "AND A.DESCR_ON_BILL = 'Fixed Charge Summary'");
					
					System.out.println("FCSUMMARY!:"+FCSummary);
					
					double doubleFCSummary = Double.parseDouble(FCSummary);
					model.setValueAt(doubleFCSummary, 0, 8);
				    
				    	mmcd.fcexcelwriteData(ManualFC, text, CCBFC,FCSummary);
				 
					 
							

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

				
		btnCheckFC.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnCheckFC.setBounds(17, 413, 89, 23);
		contentPane.add(btnCheckFC);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(17, 447, 1266, 88);
		contentPane.add(scrollPane_6);
		
		table_8 = new JTable();
		table_8.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		scrollPane_6.setViewportView(table_8);
		
		JButton btncheck_EC = new JButton("CHECK EC");
		btncheck_EC.setForeground(new Color(255, 255, 255));
		btncheck_EC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemoryManagementCommonData mmcd = new MemoryManagementCommonData();
				text = textField.getText();
				text3 =ECtextField.getText();
				try {
					mmcd.commonDataEightColumns("select BSEG_ID,DESCR_ON_BILL,CCB_BSQ,manual_bsq_ec,CCB_EC,CONT_QTY,MSR_QTY,MANUAL_EC from\r\n"
							+ "\r\n"
							+ "(select A.*,manual_bsq_ec * "+""+ text3 +""+" manual_EC,CASE WHEN CCB_BSQ = manual_bsq_ec THEN 'PASS' ELSE 'FAIL' END Manual_bsq_result,\r\n"
							+ "\r\n"
							+ "CASE WHEN CCB_EC = manual_bsq_ec * "+""+ text3 +""+" THEN 'PASS' ELSE 'FAIL' END RESULT_EC_AMOUNT from (\r\n"
							+ "\r\n"
							+ "SELECT A.BSEG_ID,F.bill_id,A.DESCR_ON_BILL,A.BILL_SQ CCB_BSQ,\r\n"
							+ "\r\n"
							+ "CASE WHEN b.UOM_CD = 'KWH' AND A.DESCR_ON_BILL LIKE '%Energy Charge LT%' THEN MSR_QTY*1.02\r\n"
							+ "\r\n"
							+ "     WHEN b.UOM_CD = 'KVAH' AND A.DESCR_ON_BILL LIKE '%Energy Charge LT%' THEN MSR_QTY*1.03\r\n"
							+ "\r\n"
							+ "     WHEN E.CHAR_TYPE_CD = 'BPCEIL' AND E.CHAR_VAL = 'Y' THEN D.CONT_QTY * 1500\r\n"
							+ "\r\n"
							+ "     ELSE msr_qty END manual_bsq_ec,\r\n"
							+ "\r\n"
							+ "calc_amt CCB_EC,d.CONT_QTY,MSR_QTY,\r\n"
							+ "\r\n"
							+ "row_number()over(partition by B.BSEG_ID order by msr_qty) rn\r\n"
							+ "\r\n"
							+ "FROM CISADM.CI_BSEG_CALC_LN A,CISADM.ci_bseg_read b,CISADM.CI_BSEG c, CISADM.ci_sa_cont_qty d,CISADM.ci_sa_char e,CISADM.CI_BILL F\r\n"
							+ "\r\n"
							+ "WHERE A.BSEG_ID = B.BSEG_ID\r\n"
							+ "\r\n"
							+ "AND B.bseg_id = C.bseg_id\r\n"
							+ "\r\n"
							+ "AND c.SA_ID = d.SA_ID\r\n"
							+ "\r\n"
							+ "and d.sa_id = e.sa_id\r\n"
							+ "\r\n"
							+ "AND C.BILL_ID = F.BILL_ID\r\n"
							+ "\r\n"
							+ "and e.CHAR_TYPE_CD in ('EDEXMFLG')\r\n"
							+ "\r\n"
							+ "AND b.UOM_CD IN ('KWH','KVAH')\r\n"
							+ "\r\n"
							+ "and MSR_QTY = greatest(MSR_QTY)\r\n"
							+ "\r\n"
							+ "AND F.bill_id = "+"'"+ text +"'"+"\r\n"
							+ "\r\n"
							+ "--AND A.BSEG_ID in ('135419831066') --872009589077 (prob - 343662420326)  026508445804 157442704257\r\n"
							+ "\r\n"
							+ "and A.DESCR_ON_BILL like '%Energy Charge%'\r\n"
							+ "\r\n"
							+ "and A.DESCR_ON_BILL not like '%Summary%')A where rn =1)", table_9);
					
					
					
				//	int columnIndex = 7; 
				     TableModel model2 = table_9.getModel();
				    String ManualEC= (String) model2.getValueAt(0, 7);
				   String CCBEC= (String) model2.getValueAt(0, 4);
				   String ManualBSQEC= (String) model2.getValueAt(0, 3);
				    String CCBBSQEC= (String) model2.getValueAt(0, 2);
				 //   String ECSum= (String) model2.getValueAt(0, 8);
				    
				    System.out.println("String Manual EC = "+ ManualEC);
				    System.out.println("String CCB EC = "+ CCBEC);
				    System.out.println("String Manual BSQEC = "+ ManualBSQEC);
				    System.out.println("String CCB BSQEC = "+ CCBBSQEC);
				 //   System.out.println("String ECSUM = "+ ECSum);
				    
				    double doubleManualEC = Double.parseDouble(ManualEC);
				    double doubleCCBEC = Double.parseDouble(CCBEC);
				    double doubleManualBSQEC = Double.parseDouble(ManualBSQEC);
				    double doubleCCBBSQEC = Double.parseDouble(CCBBSQEC);
				//    double doubleECSum = Double.parseDouble(ECSum);
				   
				    
				    String result2;
				    String result3;
				    if(doubleManualEC==doubleCCBEC) {
				    	
				    result2 = "PASS";
				    }
				    else {
				    result2 = "FAIL";
				    }
				    
					model2.setValueAt(result2, 0, 10);
					
					if(doubleManualBSQEC==doubleCCBBSQEC) {
				    	
					    result3 = "PASS";
					    }
					    else {
					    result3 = "FAIL";
					    }
					
					model2.setValueAt(result3, 0, 9);
					
					String TotalSummary=mmcd.TotalSummary("SELECT A.CALC_AMT TOTAL_SUMMARY \r\n"
							+ "FROM CISADM.CI_BSEG_CALC_LN A,CISADM.CI_BSEG B,CISADM.CI_BILL C\r\n"
							+ "WHERE A.BSEG_ID = B.BSEG_ID\r\n"
							+ "AND B.BILL_ID = C.BILL_ID\r\n"
							+ "AND C.BILL_ID ="+ "'" +text+ "'" + "   -- Here you can input the BILL_id\r\n"
							+ "AND A.DESCR_ON_BILL = 'Total Summary'");
					
					System.out.println("totalsummary"+TotalSummary);
					double doubleTotalSummary = Double.parseDouble(TotalSummary);
					model2.setValueAt(doubleTotalSummary, 0, 8);
				    
				    	mmcd.ecexcelwriteData(ManualEC, text, CCBEC,TotalSummary);
				    	//mmcd.ecexcelwriteData(CCBEC, text);
				    	
				    	
							
							
							

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btncheck_EC.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btncheck_EC.setBounds(17, 546, 89, 23);
		contentPane.add(btncheck_EC);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(10, 580, 1266, 72);
		contentPane.add(scrollPane_7);
		
		table_9 = new JTable();
		table_9.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		scrollPane_7.setViewportView(table_9);
		
		JLabel lblECRate = new JLabel("EC RATE");
		lblECRate.setForeground(new Color(255, 255, 255));
		lblECRate.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		lblECRate.setBounds(226, 13, 71, 19);
		contentPane.add(lblECRate);
		
		ECtextField = new JTextField();
		ECtextField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		ECtextField.setBounds(294, 13, 50, 23);
		contentPane.add(ECtextField);
		ECtextField.setColumns(10);
		
		lblFCRate = new JLabel("FC RATE");
		lblFCRate.setForeground(new Color(255, 255, 255));
		lblFCRate.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		lblFCRate.setBounds(354, 17, 59, 14);
		contentPane.add(lblFCRate);
		
		FCtextField = new JTextField();
		FCtextField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		FCtextField.setBounds(423, 14, 50, 22);
		contentPane.add(FCtextField);
		FCtextField.setColumns(10);
		btnNextStepCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MemoryManagementCommonData mmcd =new MemoryManagementCommonData();	
			text = textField.getText();
			Percent_text = Percent_textField.getText();
			double Percent_text1 = Double.parseDouble(Percent_text);
				try {
					String ManualECEXCELREAD=mmcd.ecexcelreadData(1, 1);
					String ManualFCEXCELREAD=mmcd.fcexcelreadData(1, 1);
					String CCBECSUMEXCELREAD=mmcd.ecexcelreadData(1, 3);
					String CCBFCSUMEXCELREAD=mmcd.fcexcelreadData(1, 3);
					
					
					double ManualEC_EXCEL = Double.parseDouble(ManualECEXCELREAD);
					double ManualFC_EXCEL = Double.parseDouble(ManualFCEXCELREAD);
					double CCBECSUM_EXCEL = Double.parseDouble(CCBECSUMEXCELREAD);
					double CCBFCSUM_EXCEL = Double.parseDouble(CCBFCSUMEXCELREAD);
					
					//double CCBED = ((CCBEC_EXCEL + CCBFC_EXCEL) * Percent_text1/100);
					
					
					
					//String CCBEDString = Double.toString(CCBED);
					//System.out.println("CCBED Value = "+CCBED);
					
					String result;
				//	if(ManualEDString==CCBEDString) {
//					if(ManualED==CCBED) {
//						result = "PASS";
//					}
//					else {
//						result = "FAIL";
//					}
					String CCBED=mmcd.CCBED("select calc_amt from cisadm.ci_bseg_calc_ln a,cisadm.ci_bseg b \r\n"
							+ "where a.bseg_id=b.bseg_id \r\n"
							+ "and a.descr_on_bill in('Electricity Duty Charge','Electricity Duty Charge Summary','Electricity Duty','Electricity Duty Summary')\r\n"
							+ "and b.bill_id="+"'"+ text +"'");
					
				
					double doubleCCBED = Double.parseDouble(CCBED);
					
					double ManualED = ((CCBECSUM_EXCEL + CCBFCSUM_EXCEL) * Percent_text1/100);
					decfor.setRoundingMode(RoundingMode.HALF_EVEN);
					String DManualED =decfor.format(ManualED);
					
					double DManualED2 = Double.parseDouble(DManualED);
					String ManualEDString = Double.toString(ManualED);
					System.out.println("MANUALED Value = "+ManualED);
					if(DManualED2==doubleCCBED) {
						
							result = "PASS";
						}
						else {
							
							result = "FAIL";
						}
					

				        DefaultTableModel model = (DefaultTableModel)table_11.getModel();
				        model.addColumn("Bill ID");
				        model.addColumn("Manual ED");
				       // model.addColumn("CCB Calc ED");
				        model.addColumn("CCB ED");
				        model.addColumn("Result");
				        
				       model.addRow(new Object[]{text,DManualED,CCBED, result});
				        
					}	 catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNextStepCheck.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnNextStepCheck.setBounds(998, 342, 144, 23);
		contentPane.add(btnNextStepCheck);
		
		JScrollPane scrollPane_9 = new JScrollPane(table_11);
		scrollPane_9.setBounds(887, 376, 297, 60);
		contentPane.add(scrollPane_9);
		
		table_11 = new JTable();
		table_11.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		scrollPane_9.setViewportView(table_11);
		
		table.setBackground(Color.YELLOW);
		table_1.setBackground(Color.YELLOW);
		table_3.setBackground(Color.YELLOW);
		table_4.setBackground(Color.YELLOW);
		table_5.setBackground(Color.YELLOW);
		table_6.setBackground(Color.YELLOW);
		table_7.setBackground(Color.YELLOW);
		table_8.setBackground(Color.YELLOW);
		table_9.setBackground(Color.YELLOW);
		table_11.setBackground(Color.YELLOW);
		
		btncheck_EC.setBackground(new Color(0, 128, 0));
		btnCheckFC.setBackground(new Color(0, 128, 0));
		btnci_bseg_calc_ln.setBackground(new Color(0, 128, 0));
		btnci_bseg_calc_ln2.setBackground(new Color(0, 128, 0));
		btnCi_Sa_Char.setBackground(new Color(0, 128, 0));
		btnci_sa_cont_qty.setBackground(new Color(0, 128, 0));
		btnClear.setBackground(new Color(0, 128, 0));
		btnCi_Acct_Char.setBackground(new Color(0, 128, 0));
		btnci_bseg_sq.setBackground(new Color(0, 128, 0));
		btnNextStepCheck.setBackground(new Color(0, 128, 0));
		
		//  btnNextStepCheck.setFont(getFont());
		btnNextStepCheck.setForeground(Color.WHITE);
		
		Percent_textField = new JTextField();
		Percent_textField.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		Percent_textField.setBounds(950, 343, 25, 20);
		contentPane.add(Percent_textField);
		Percent_textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ED %");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		lblNewLabel_1.setBounds(904, 346, 53, 14);
		contentPane.add(lblNewLabel_1);
		
		textField.setBackground(Color.cyan);
		ECtextField.setBackground(Color.cyan);
		FCtextField.setBackground(Color.cyan);
		Percent_textField.setBackground(Color.cyan);
		
		JTableHeader header = table.getTableHeader();
	    Font font = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header.setFont(font);
	    header.setBackground(Color.BLUE);
	    header.setForeground(Color.WHITE);
	    
	    JTableHeader header1 = table_1.getTableHeader();
	    Font font1 = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header1.setFont(font1);
	    header1.setBackground(Color.BLUE);
	    header1.setForeground(Color.WHITE);
	    
	    JTableHeader header2 = table_11.getTableHeader();
	    Font font2 = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header2.setFont(font2);
	    header2.setBackground(Color.BLUE);
	    header2.setForeground(Color.WHITE);
	    
	    JTableHeader header3 = table_3.getTableHeader();
	    Font font3 = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header3.setFont(font3);
	    header3.setBackground(Color.BLUE);
	    header3.setForeground(Color.WHITE);
	    
	    
	    JTableHeader header4 = table_4.getTableHeader();
	    Font font4 = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header4.setFont(font4);
	    header4.setBackground(Color.BLUE);
	    header4.setForeground(Color.WHITE);
	    
	    JTableHeader header5 = table_5.getTableHeader();
	    Font font5 = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header5.setFont(font5);
	    header5.setBackground(Color.BLUE);
	    header5.setForeground(Color.WHITE);
	    
	    JTableHeader header6 = table_6.getTableHeader();
	    Font font6 = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header6.setFont(font6);
	    header6.setBackground(Color.BLUE);
	    header6.setForeground(Color.WHITE);
	    
	    JTableHeader header7 = table_7.getTableHeader();
	    Font font7 = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header7.setFont(font7);
	    header7.setBackground(Color.BLUE);
	    header7.setForeground(Color.WHITE);
	    
	    JTableHeader header8 = table_8.getTableHeader();
	    Font font8 = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header8.setFont(font8);
	    header8.setBackground(Color.BLUE);
	    header8.setForeground(Color.WHITE);
	    
	    JTableHeader header9 = table_9.getTableHeader();
	    Font font9 = new Font("Berlin Sans FB Demi", Font.BOLD, 12); // set your desired font here
	    header9.setFont(font9);
	    header9.setBackground(Color.BLUE);
	    header9.setForeground(Color.WHITE);
		
		
	}
}
