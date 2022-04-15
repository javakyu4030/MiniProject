package com.chat.front;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


//-----------------------------------------------임시 빽업용으로 저장해둔 소스파일------------------------------------------------
public class Reg_Backup {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private final Action action = new SwingAction();
	private JButton btnNewButton;
	private JLabel ID;
	private JLabel Name;
	private JLabel Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Reg_Backup window = new Reg_Backup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reg_Backup() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 386, 709);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 359, 204, 39);
		panel.add(textField_1);
		
		textField = new JTextField();
		textField.setBounds(132, 419, 204, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 479, 204, 39);
		panel.add(passwordField);
		
		lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 33));
		lblNewLabel_1.setBounds(104, 290, 184, 59);
		panel.add(lblNewLabel_1);
		
		btnNewButton = new JButton("submit");	//데이터 값 전송버튼
		btnNewButton.setBounds(132, 549, 120, 39);
		panel.add(btnNewButton);
		
		ID = new JLabel("ID");
		ID.setFont(new Font("굴림", Font.PLAIN, 20));
		ID.setBounds(63, 359, 94, 39);
		panel.add(ID);
		
		Name = new JLabel("Name");
		Name.setFont(new Font("굴림", Font.PLAIN, 20));
		Name.setBounds(45, 417, 94, 39);
		panel.add(Name);
		
		Password = new JLabel("Password");
		Password.setFont(new Font("굴림", Font.PLAIN, 20));
		Password.setBounds(35, 479, 94, 39);
		panel.add(Password);
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
