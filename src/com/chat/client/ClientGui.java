//package com.chat.client;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import java.awt.Color;
//import javax.swing.JTextPane;
//import javax.swing.JButton;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.Socket;
//import java.awt.event.ActionEvent;
//
//public class ClientGui extends JFrame{
//
//	Socket socket;
//	Socket socket2;
//	//JLabel userName = new JLabel("userName");
//	JFrame ChattingRoom;
//   String IPText = "127.0.0.1";
//   String InputNickName;
//   
////--------------------------------------------startClient----------------------------------------------
//   // 클라이언트 프로그램의 작동을 시작하는 메소드
//   public void startClient(String IP, int port) {
//      Thread thread = new Thread() {
//         public void run() {
//            try {
//               socket = new Socket(IP, port);
//              // receive();
//            } catch(Exception e) {
//               if(!socket.isClosed()) {
//                  stopClient();
//                  System.out.println("[서버 접속 실패]");
//               }
//            }
//         }
//      };
//      thread.start();
//   }
////--------------------------------------------stopClient----------------------------------------------
//// 클라이언트 프로그램의 작동을 종료하는 메소드
//   public void stopClient() {
//      try {
//         if(socket != null && !socket.isClosed()) {
//            socket.close();
//         }
//      } catch(Exception e) {
//         e.printStackTrace();
//      }
//   }
//   
////--------------------------------------------receive----------------------------------------------
//   // 서버로부터 메세지를 전달받는 메소드
//  /* public void receive() {
//      while(true) {
//         try {
//            InputStream in = socket.getInputStream();
//            byte[] buffer = new byte[512];
//            int length = in.read(buffer);
//            if(length == -1) throw new IOException();
//            String message = new String(buffer, 0, length, "UTF-8");
//            if (message.contains(":")) {
//               textArea.append(message);               
//               
//            }
//            else {
//               Boolean flag = true;
//               String tmp = userArea.getText();
//               if (tmp.contains(message)) {
//                  flag = false;
//               }
////               String tmps[] = tmp.split("\n");
//               
////               for(var i = 0; i < tmps.length; i++) {
////                  if(message.equals(tmps[i])) {
////                     flag = false;
////                  }
////               }
//               if(flag == true) {
//                  userArea.append(message);
//               }
////               System.out.println(tmp);
////               String tmp[] = userArea.getText().split("\n");
////               for(var i = 0; i < tmp.length; i++) {
////                  if(message.equals(tmp[i])) {
////                     flag = false;
////                  }
////               }
////               if(flag == true)
////                  userArea.append(message);
//            }
//         } catch(Exception e) {
//            stopClient();
//            break;
//         }
//      }
//   }
//   */
//   
////--------------------------------------------Main start----------------------------------------------
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientGui window = new ClientGui();
//					window.ChattingRoom.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
////--------------------------------------------Main end----------------------------------------------
//
//	public ClientGui() {
//		initialize();
//	}
//
//	private void initialize() {
//		ChattingRoom = new JFrame();
//		ChattingRoom.setBounds(100, 100, 500, 800);
//		ChattingRoom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		ChattingRoom.getContentPane().setLayout(null);
//		
//		//-----------------------채팅창 백그라운드 패널-----------------------------
//		JPanel backGround_panel = new JPanel();
//		backGround_panel.setBackground(Color.WHITE);
//		backGround_panel.setBounds(0, 0, 484, 761);
//		ChattingRoom.getContentPane().add(backGround_panel);
//		backGround_panel.setLayout(null);
//		
//		//-----------------------채팅 텍스트 입력 패널-----------------------------
//		JTextField input_textField = new JTextField();
//		input_textField.setBackground(Color.LIGHT_GRAY);
//		input_textField.setText("\uD14D\uC2A4\uD2B8 \uC785\uB825\uCC3D");
//		input_textField.setBounds(12, 548, 341, 166);
//		backGround_panel.add(input_textField);
//		input_textField.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JTextField textPane =(JTextField)e.getSource();
//				send(userName.getText() + ": " + textPane.getText() + "\n");
//				input_textField.setText("");
//				input_textField.requestFocus();
//			}
//		});
//		
//		
//		//-----------------------입력 전송 버튼-----------------------------
//		JButton btnSend = new JButton("전송");
//		btnSend.setBounds(343, 0, 91, 34);
//		
//		//btn_submit -> 전송버튼
//		JButton btn_submit = new JButton("\uC804\uC1A1");
//		//전송 버튼 동작 ActionLIstener
//		btn_submit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				send(userName.getText() + ": " + input.getText() + "\n");
//				input.setText("");
//				input.requestFocus();
//			}
//		});
//		panel_3.add(btnSend);
//		btn_submit.setBounds(364, 548, 108, 59);
//		backGround_panel.add(btn_submit);
//		
//		//----------------------채팅 대화 출력------------------------------
//		JTextArea output_textArea = new JTextArea();
//		output_textArea.setText("\uD14D\uC2A4\uD2B8 \uCD9C\uB825");
//		output_textArea.setBackground(Color.LIGHT_GRAY);
//		output_textArea.setBounds(12, 113, 460, 410);
//		backGround_panel.add(output_textArea);
//		
//
//	}
//}
