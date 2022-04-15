//package com.chat.client;
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JButton;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import java.awt.Color;
//import java.awt.Canvas;
//import javax.swing.JScrollBar;
//
//public class Client_2 extends JFrame {
//
//	Socket socket;
//	Socket socket2;
//	JPanel contentPane;
//	JPanel panel_1 = new JPanel();
//	JTextArea textArea;
//	JTextArea userArea;
//	JLabel userName = new JLabel("userName");
//	String IPText = "127.0.0.1";
//	String InputNickName;
//	JTextArea outPut_TArea;
//
//	// 클라이언트 프로그램의 작동을 시작하는 메소드
//	public void startClient(String IP, int port) {
//		Thread thread = new Thread() {
//			public void run() {
//				try {
//					socket = new Socket(IP, port);
//					receive();
//				} catch(Exception e) {
//					if(!socket.isClosed()) {
//						stopClient();
//						System.out.println("[서버 접속 실패]");
//					}
//				}
//			}
//		};
//		thread.start();
//	}
//	
//	// 클라이언트 프로그램의 작동을 종료하는 메소드
//	public void stopClient() {
//		try {
//			if(socket != null && !socket.isClosed()) {
//				socket.close();
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	// 서버로부터 메세지를 전달받는 메소드
//	public void receive() {
//		while(true) {
//			try {
//				InputStream in = socket.getInputStream();
//				byte[] buffer = new byte[512];
//				int length = in.read(buffer);
//				if(length == -1) throw new IOException();
//				String message = new String(buffer, 0, length, "UTF-8");
//				if (message.contains(":")) {
//			    textArea.append(message);					
//					
//				}
//				else {
//					Boolean flag = true;
//					String tmp = userArea.getText();
//					if (tmp.contains(message)) {
//						flag = false;
//					}
////					String tmps[] = tmp.split("\n");
//					
////					for(var i = 0; i < tmps.length; i++) {
////						if(message.equals(tmps[i])) {
////							flag = false;
////						}
////					}
//					if(flag == true) {
//						userArea.append(message);
//					}
////					System.out.println(tmp);
////					String tmp[] = userArea.getText().split("\n");
////					for(var i = 0; i < tmp.length; i++) {
////						if(message.equals(tmp[i])) {
////							flag = false;
////						}
////					}
////					if(flag == true)
////						userArea.append(message);
//				}
//			} catch(Exception e) {
//				stopClient();
//				break;
//			}
//		}
//	}
//	
//	// 서버로부터 사용자 명단을 받아오는 메소드
//	public void receiveUserList() {
//		while(true) {
//			try {
//				InputStream in = socket.getInputStream();
//				byte[] buffer = new byte[512];
//				int length = in.read(buffer);
//				if(length == -1) throw new IOException();
//				String message = new String(buffer, 0, length, "UTF-8");
//				String user_name = message.split(":")[0];
//				userArea.append(user_name);
//			} catch(Exception e) {
//				stopClient();
//				break;
//			}
//		}
//		
//	}
//	
//	public void sendUserName(String user_name) {
//		Thread thread = new Thread() {
//			public void run() {
//				try {
//					OutputStream out = socket.getOutputStream();
//					byte[] buffer = user_name.getBytes("UTF-8");
//					out.write(buffer);
//					out.flush();
//				} catch(Exception e) {
//					stopClient();
//				}
//			}
//		};
//		thread.start();		
//	}
//	
//	// 서버로 메세지를 전송하는 메소드
//	public void send(String message) {
//		Thread thread = new Thread() {
//			public void run() {
//				try {
//					OutputStream out = socket.getOutputStream();
//					byte[] buffer = message.getBytes("UTF-8");
//					out.write(buffer);
//					out.flush();
//				} catch(Exception e) {
//					stopClient();
//				}
//			}
//		};
//		thread.start();
//	}
//	
//	public void setName() {
//		InputNickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
//		while(true) {
//			if(InputNickName == null) {
//				stopClient();
//			}
//			
//			if(!InputNickName.equals("")) {
//				userName.setText(InputNickName);
////				userName.setEnabled(false);
//				break;
//			}
//			else {
//				JOptionPane.showMessageDialog(null, "닉네임을 입력하시라고", "내 말이 똥으로 보여?", JOptionPane.ERROR_MESSAGE);
////				continue;
//				InputNickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
//			}
//		}
////		userArea.append(InputNickName);
//		sendUserName(InputNickName);
//	}	
//
//	/**
//	 * Create the frame.
//	 */
//	public Client_2() {
//		
//		setName();
//		receiveUserList();
//		int port = 9876;
//		startClient(IPText, port);
////		textArea.append("[ 채팅방 접속 ]\n");
//		
//		setTitle("[채팅 클라이언트]");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 500, 800);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		//------------------------------------------------텍스트 출력 영역-----------------------------
//		textArea = new JTextArea();
//		textArea.setEnabled(false);
//		textArea.setEditable(false);
//		panel_1.setBackground(Color.WHITE);
//		panel_1.setBounds(0, 33, 344, 190);
//		contentPane.add(panel_1);
//		panel_1.setLayout(null);
//		
//
//		JTextArea outPut_TArea = new JTextArea();
//		outPut_TArea.setEnabled(false);
//		outPut_TArea.setEditable(false);
//		outPut_TArea.setBounds(12, 250, 237, 269);
//		contentPane.add(outPut_TArea);
//		
//		JScrollPane outPut_SPArea = new JScrollPane(outPut_TArea);
//		outPut_SPArea.setBounds(12, 253, 227, 255);
//		contentPane.add(outPut_SPArea);
//		
//		
//		this.getContentPane().add(outPut_SPArea);
//		outPut_TArea.setCaretPosition(outPut_TArea.getDocument().getLength());
//		//------------------------------------------------텍스트 출력 영역----------------------------
//		
//		JPanel panel = new JPanel();
//		panel.setBounds(0, 0, 434, 34);
//		contentPane.add(panel);
//		panel.setLayout(null);
//		
//		userName.setForeground(Color.BLACK);
//		userName.setBackground(Color.WHITE);
//		userName.setEnabled(false);
//		userName.setBounds(0, 0, 251, 34);
//		panel.add(userName);
//		
//		//------------------------------------------------------------수정중-------------------------------------
//		JLabel userList = new JLabel("userList");
//		userList.setEnabled(false);
//		userList.setBounds(345, 0, 89, 34);
//		panel.add(userList);
//		//------------------------------------------------------------수정중-------------------------------------
//		
//
//		/*
//		JScrollPane scrollPane = new JScrollPane(textArea);
//		textArea.setBounds(0, 0, 340, 190);
//		scrollPane.setBounds(340, 0, 344, 190);
//		scrollPane.setBackground(Color.black);
//		panel_1.add(textArea);
//		panel_1.add(scrollPane);
//		*/
//		JPanel panel_2 = new JPanel();
//		panel_2.setBounds(345, 33, 89, 190);
//		contentPane.add(panel_2);
//		panel_2.setLayout(null);
//		
//		userArea = new JTextArea();
////		userArea.setEditable(false);
////		userArea.setEnabled(false);
////		userArea.append(InputNickName);
////		userArea.setText("userArea");
//		userArea.setBounds(0, 0, 89, 190);
//		panel_2.add(userArea);
//		
//		JTextField input = new JTextField();
//		input.setBounds(12, 569, 361, 162);
//		contentPane.add(input);
//		input.setColumns(10);
//		
//			JButton btnSend = new JButton("전송");
//			btnSend.setBounds(381, 569, 91, 34);
//			contentPane.add(btnSend);
//			
//			JPanel panel_3 = new JPanel();
//			panel_3.setBounds(0, 547, 484, 204);
//			contentPane.add(panel_3);
//			panel_3.setLayout(null);
//			
//
//			//---------------------------------------------------------try
//			
//			
//			outPut_TArea.setBounds(10, 233, 235, 230);
//			
//			btnSend.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					send(userName.getText() + ": " + input.getText() + "\n");
//					input.setText("");
//					input.requestFocus();
//				}
//			});
//		input.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JTextField t = (JTextField)e.getSource();
//				send(userName.getText() + ": " + t.getText() + "\n");
//				input.setText("");
//				input.requestFocus();
//			}
//		});
//	}
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Client_2 frame = new Client_2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//}