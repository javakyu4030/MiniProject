package com.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Main extends JFrame {
	
	Socket socket;
	JPanel contentPane;
	JPanel panel_1 = new JPanel();
	JTextArea textArea;
	JTextArea userArea;
	JScrollPane scrollPane;
	JLabel userName = new JLabel("userName");
	String IPText = "127.0.0.1";
	int port = 9876;
	String InputNickName;
	String UserList = "";
	
	// Ŭ���̾�Ʈ ���α׷��� �۵��� �����ϴ� �޼ҵ�
	public void startClient(String IP, int port) {
		Thread thread = new Thread() {
			public void run() {
				try {
					socket = new Socket(IP, port);
					receive();
				} catch (Exception e) {
					if(!socket.isClosed()) {
						stopClient();
						System.out.println("[���� ���� ����]");
					}
				}
			}
		};
		thread.start();
	}
	
	// Ŭ���̾�Ʈ ���α׷��� �۵��� �����ϴ� �޼ҵ�
	public void stopClient() {
		try {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �����κ��� �޼����� ���޹޴� �޼ҵ�
	public void receive() {
		while(true) {
			try {
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				int length = in.read(buffer);
				if(length == -1) throw new IOException();
				String message = new String(buffer, 0, length, "UTF-8");
				// messageContent�� �����:ä�ó���ƻ���ڸ���Ʈ  ���� �����:ä�ó��� �� �ǹ���. textArea�� append���ִ� �׸�
				String messageContent = message.split("��")[0];
				// userArea �ʱ�ȭ. �ʱ�ȭ���� ������ ������ �ִ� userArea�� ���ο� userArea�� ��� append�Ǽ� �˾ƺ� �� ����
				userArea.setText("");
				// userArea�� ����� ����� append
				userArea.append(message.split("��")[1]);
				// textArea�� ��ȭ ������ append
				textArea.append(messageContent);
				
				scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
				
			} catch (Exception e) {
				stopClient();
				break;
			}
		}
	}
	
	// ������ �޼����� �����ϴ� �޼ҵ�
	public void send(String message) {
		Thread thread = new Thread() {
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch (Exception e) {
					stopClient();
				}
			}
		};
		thread.start();
	}
	
	// ��ȭ�� ����
	public void setName() {
		InputNickName = JOptionPane.showInputDialog("��ȭ���� �Է��ϼ���.");
		while(true) {
			if(InputNickName == null) {
				stopClient();
			}
			if(!InputNickName.equals("")) {
				userName.setText(InputNickName);
				userName.setEnabled(false);
				break;
			}
			else {
				JOptionPane.showMessageDialog(null, "��ȭ���� �Է��ϼ���.", "�߸��� ��ȭ���Դϴ�.", JOptionPane.ERROR_MESSAGE);
				InputNickName = JOptionPane.showInputDialog("��ȭ���� �Է��ϼ���.");
			}
		}
	}
	
	public Main() {
		setName();
		startClient(IPText, port);
		
		setTitle("[ä�� Ŭ���̾�Ʈ]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		userName.setFont(new Font("�޸յձ�������", Font.BOLD, 17));
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		
		userName.setForeground(Color.black);
		userName.setBackground(Color.white);
		userName.setEnabled(false);
		userName.setBounds(0, 0, 370, 71);
		panel.add(userName);
		
		JLabel userList = new JLabel("userList");
		userList.setHorizontalAlignment(SwingConstants.CENTER);
		userList.setEnabled(false);
		userList.setBounds(368, 0, 104, 81);
		panel.add(userList);
		panel_1.setBounds(10, 80, 345, 530);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		textArea.setForeground(SystemColor.textInactiveText);
		textArea.setFont(new Font("�޸յձ�������", Font.PLAIN, 18));
		textArea.setEnabled(true);
		textArea.setEditable(true);
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(367, 80, 105, 530);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		userArea = new JTextArea();
		userArea.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
		userArea.setBounds(0, 0, 105, 530);
		panel_2.add(userArea);
		
		
		//-----------------------------------�Է�+���۹�ư ���� �г�--------------------------
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 636, 484, 100);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		//---------------------------------�ؽ�Ʈ �Է�----------------------------
		JTextField input = new JTextField();
		input.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
		input.setHorizontalAlignment(SwingConstants.LEFT);
		input.setBorder(null);
		input.setBounds(12, 27, 336, 45);
		
		panel_3.add(input);
		input.setColumns(30);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				send(userName.getText() + " : " + t.getText() + "\n");
				input.setText("");
				input.requestFocus();
			}
		});

		//-----------------------�޽��� ���� ��ư------------------------
		JButton btnSend = new JButton("");
		btnSend.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\send.png"));
		btnSend.setBounds(373, 27, 98, 44);
		btnSend.setBorderPainted(false);
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				send(userName.getText() + " : " + input.getText() + "\n");
				input.setText("");
				input.requestFocus();
			}
		});
		panel_3.add(btnSend);
	}
	
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}