package view;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.ButtonListener;
import controller.Helper;

import model.Print;
import model.User;



public class GUI_Print extends GUI_Header{

//	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	
    private JFileChooser fc;
    private File file;
    private JTextArea txtFiles;
    
    private JButton btnSend;
    private JButton btnChoiseFile;
	private JButton btnCancel;   
	private JComboBox comboBox;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Print frame = new GUI_Print(new User("",""));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	* Create the frame.
	*/
	public GUI_Print(User user) {
		super(user);
		setTitle("Print File");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 329);
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(230, 230, 250));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setDefaults();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Receiver:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(31, 11, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("File:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(31, 45, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		btnSend = new JButton("Send");
		btnSend.setBounds(381, 245, 89, 23);
		contentPane.add(btnSend);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(280, 245, 91, 23);
		contentPane.add(btnCancel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(120, 7, 271, 22);
		contentPane.add(comboBox);
		
		txtFiles = new JTextArea();
		txtFiles.setRows(1);
		txtFiles.setBounds(118, 41, 273, 23);
		contentPane.add(txtFiles);
		
		fc = new JFileChooser();
		btnChoiseFile = new JButton("Choise File");
		btnChoiseFile.setActionCommand("Choose File");
		btnChoiseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            int returnVal = fc.showOpenDialog(GUI_Print.this);

	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                file = fc.getSelectedFile();
	                if( txtFiles.getText().equals("") )
	                {
	                	txtFiles.setText( file.getAbsolutePath());
	                }
	                else
	                {	                	
	                	txtFiles.setText( txtFiles.getText() + ";" + file.getAbsolutePath() );
	                }
	            }
			}
		});
		btnChoiseFile.setBounds(400, 42, 70, 22);
		contentPane.add(btnChoiseFile);
		
		
		//String filename = args[0];
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		DocFlavor flavor = DocFlavor.INPUT_STREAM.PNG;
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		
		
		for (int i=0;i<printService.length;i++)
		{
			comboBox.addItem(printService[i].toString());
		}
	}
	public void setActionListener(ButtonListener lbl)  {
		this.btnCancel.setActionCommand("CancelPrint");
		this.btnCancel.addActionListener(lbl);
		this.btnSend.setActionCommand("SendPrint");
		this.btnSend.addActionListener(lbl);
	}
	
	public Print getPrint(){
//		this.comboBox.getSelectedItem();
		//TODO: Receiver
		String[] receiver = new String[1];  
		String[] files = this.txtFiles.getText().split(";");
		return new Print(this.user.getUsername(), receiver , this.user.getUserID(),  files) {
		};
		
	}
	
	public void setPrint(Print print){
		
//		StringBuffer strBuffer = new StringBuffer();
//		for(int i = 0; i < print.getReceiver().length; i++ ){
//			if(i == 0)
//			{ 
//				strBuffer.append(print.getReceiver()[i]);
//			}
//			else
//			{
//				strBuffer.append(";" + print.getReceiver()[i]);
//			}
//		}
		
		comboBox.removeAllItems();
		comboBox.addItem(Helper.arrayToString( print.getReceiver()));
		
//		strBuffer = new StringBuffer();
//		for(int i = 0; i < print.getFiles().length; i++ ){
//			if(i == 0)
//			{ 
//				strBuffer.append(print.getFiles()[i]);
//			}
//			else
//			{
//				strBuffer.append(";" + print.getFiles()[i]);
//			}
//		}
		this.txtFiles.setText( Helper.arrayToString(print.getFiles()));		
	}

	public void setReadOnly(boolean editable){
		//TODO: reciver
		this.txtFiles.setEditable(editable);
		this.btnChoiseFile.setEnabled(editable);
		this.btnSend.setEnabled(editable);
		this.comboBox.setEnabled(editable);

	}
}


