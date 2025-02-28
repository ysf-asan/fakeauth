package auto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class auto1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					auto1 frame = new auto1();
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
	public auto1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(102, 23, 188, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 57, 188, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("FakeAuth ba\u015Flat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String target_mac = textField.getText();
				String own_mac = textField_1.getText();
				runPythonScript(target_mac, own_mac);
			

			
			}
		});
		
		
		
		btnNewButton.setBounds(102, 114, 111, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblTargetMac = new JLabel("Target MAC");
		lblTargetMac.setBounds(25, 27, 80, 19);
		contentPane.add(lblTargetMac);
		
		JLabel lblOwnMac = new JLabel("Own MAC");
		lblOwnMac.setBounds(25, 59, 56, 19);
		contentPane.add(lblOwnMac);
	}
	
	private void runPythonScript(String target_mac, String own_mac){
		try{
			ProcessBuilder pb = new ProcessBuilder("/usr/bin/python3.9", "Wmain.py", target_mac, own_mac);
			pb.redirectErrorStream(true);
			Process p = pb.start();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			p.waitFor();
			
		}catch(Exception e ){
			System.out.println(e);
			
		}
	}

}

