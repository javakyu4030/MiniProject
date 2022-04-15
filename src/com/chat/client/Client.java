//package com.chat.client;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.border.EmptyBorder;
//
//
//public class Client extends JFrame {
//
//   Socket socket;
//   Socket socket2;
//   JPanel contentPane;
//   JPanel panel_1 = new JPanel();
//   JTextArea textArea;
//   JTextArea userArea;
//   JScrollPane scrollPane;
//   JLabel userName = new JLabel("userName");
//   String IPText = "127.0.0.1";
//   String InputNickName;
//
//
//   // Ŭ���̾�Ʈ ���α׷��� �۵��� �����ϴ� �޼ҵ�
//   public void startClient(String IP, int port) {
//      Thread thread = new Thread() {
//         public void run() {
//            try {
//               socket = new Socket(IP, port);
//               receive();
//            } catch(Exception e) {
//               if(!socket.isClosed()) {
//                  stopClient();
//                  System.out.println("[���� ���� ����]");
//               }
//            }
//         }
//      };
//      thread.start();
//   }
//   
//   // Ŭ���̾�Ʈ ���α׷��� �۵��� �����ϴ� �޼ҵ�
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
//   // �����κ��� �޼����� ���޹޴� �޼ҵ�
//   public void receive() {
//      while(true) {
//         try {
//            InputStream in = socket.getInputStream();
//            byte[] buffer = new byte[512];
//            int length = in.read(buffer);
//            if(length == -1) throw new IOException();
//            String message = new String(buffer, 0, length, "UTF-8");
//            if (message.contains(":")) {
//               textArea.append(message); 
//               scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
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
//   
//   // �����κ��� ����� ����� �޾ƿ��� �޼ҵ�
//   public void receiveUserList() {
//      while(true) {
//         try {
//            InputStream in = socket.getInputStream();
//            byte[] buffer = new byte[512];
//            int length = in.read(buffer);
//            if(length == -1) throw new IOException();
//            String message = new String(buffer, 0, length, "UTF-8");
//            String user_name = message.split(":")[0];
//            userArea.append(user_name);
//         } catch(Exception e) {
//            stopClient();
//            break;
//         }
//      }
//      
//   }
//   
//   public void sendUserName(String user_name) {
//      Thread thread = new Thread() {
//         public void run() {
//            try {
//               OutputStream out = socket.getOutputStream();
//               byte[] buffer = user_name.getBytes("UTF-8");
//               out.write(buffer);
//               out.flush();
//            } catch(Exception e) {
//               stopClient();
//            }
//         }
//      };
//      thread.start();      
//   }
//   
//   // ������ �޼����� �����ϴ� �޼ҵ�
//   public void send(String message) {
//      Thread thread = new Thread() {
//         public void run() {
//            try {
//               OutputStream out = socket.getOutputStream();
//               byte[] buffer = message.getBytes("UTF-8");
//               out.write(buffer);
//               out.flush();
//            } catch(Exception e) {
//               stopClient();
//            }
//         }
//      };
//      thread.start();
//   }
//   
//   public void setName() {
//      InputNickName = JOptionPane.showInputDialog("��ȭ���� �Է��ϼ���.");
//      while(true) {
//         if(InputNickName == null) {
//            stopClient();
//         }
//         
//         if(!InputNickName.equals("")) {
//            userName.setText(InputNickName);
////            userName.setEnabled(false);
//            break;
//         }
//         else {
//            JOptionPane.showMessageDialog(null, "�г����� �Է��Ͻö��", "�� ���� ������ ����?", JOptionPane.ERROR_MESSAGE);
////            continue;
//            InputNickName = JOptionPane.showInputDialog("��ȭ���� �Է��ϼ���.");
//         }
//      }
////      userArea.append(InputNickName);
//      sendUserName(InputNickName);
//   }   
//
//   /**
//    * Create the frame.
//    */
//   public Client() {
//      
//      setName();
//      receiveUserList();
//      int port = 9876;
//      startClient(IPText, port);
////      textArea.append("[ ä�ù� ���� ]\n");
//      
//      setTitle("[ä�� Ŭ���̾�Ʈ]");
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      setBounds(100, 100, 500, 850);
//      contentPane = new JPanel();
//      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//      setContentPane(contentPane);
//      contentPane.setLayout(null);
//      panel_1.setBounds(10, 74, 348, 545);
//      contentPane.add(panel_1);
//      //panel_1.setLayout(null);
//      panel_1.setLayout(new BorderLayout());
//      
//      textArea = new JTextArea();
//      textArea.setFont(new Font("�޸յձ�������", Font.PLAIN, 16));
//    textArea.setEnabled(false);
//      textArea.setEditable(false);
//  	 scrollPane = new JScrollPane(textArea);
////      textArea.setBounds(0, 0, 348, 545);
////    scrollPane.setBounds(340, 0, 344, 190);
////     scrollPane.setBackground(Color.black);
////      panel_1.add(textArea);
////    panel_1.add(scrollPane);
//    panel_1.add(scrollPane, BorderLayout.CENTER);  
//    
//    
//      JPanel panel_2 = new JPanel();
//      panel_2.setBounds(370, 116, 102, 503);
//      contentPane.add(panel_2);
//      panel_2.setLayout(null);
//      
//      userArea = new JTextArea();
//      userArea.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
//      userArea.setBounds(0, 0, 102, 503);
//      panel_2.add(userArea);
//         
//         JPanel panel_3 = new JPanel();
//         panel_3.setBackground(Color.WHITE);
//         panel_3.setBounds(0, 629, 484, 172);
//         contentPane.add(panel_3);
//         panel_3.setLayout(null);
//         
//         JTextField input = new JTextField();
//         input.setHorizontalAlignment(SwingConstants.LEFT);
//         input.setFont(new Font("�޸յձ�������", Font.PLAIN, 15));
//         input.setBounds(12, 10, 345, 152);
//         panel_3.add(input);
//         input.setColumns(50);
//         
//            JButton btnSend = new JButton("");
//            btnSend.setBackground(Color.WHITE);
//            btnSend.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\send.png"));
//            btnSend.setBounds(375, 10, 97, 43);
//            panel_3.add(btnSend);
//            btnSend.setBorderPainted(false);
//            
//            JButton btnNewButton = new JButton("\uD30C\uC77C \uC804\uC1A1");
//            btnNewButton.setIcon(null);
//            btnNewButton.setBounds(375, 84, 97, 37);
//            panel_3.add(btnNewButton);
//            userName.setFont(new Font("�޸յձ�������", Font.BOLD, 15));
//            userName.setHorizontalAlignment(SwingConstants.CENTER);
//            userName.setBounds(0, 0, 484, 74);
//            contentPane.add(userName);
//            
//            userName.setForeground(Color.WHITE);
//            userName.setBackground(Color.MAGENTA);
//            
//            JPanel panel = new JPanel();
//            panel.setBounds(370, 72, 102, 34);
//            contentPane.add(panel);
//            panel.setLayout(null);
//            
//            JLabel userList = new JLabel("userList");
//            userList.setBounds(0, 0, 102, 34);
//            panel.add(userList);
//            userList.setHorizontalAlignment(SwingConstants.CENTER);
//            userList.setEnabled(false);
//            btnNewButton.addActionListener(new ActionListener() {
//               public void actionPerformed(ActionEvent e) {
//                  
//                  
//               }
//            });
//            btnSend.addActionListener(new ActionListener() {
//               @Override
//               public void actionPerformed(ActionEvent e) {
//                  send(userName.getText() + ": " + input.getText() + "\n");
//                  input.setText("");
//                  input.requestFocus();
//               }
//            });
//         input.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               JTextField t = (JTextField)e.getSource();
//               send(userName.getText() + ": " + t.getText() + "\n");
//               input.setText("");
//               input.requestFocus();
//            }
//         });
//   }
//   /**
//    * Launch the application.
//    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               Client frame = new Client();
//               frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//      
//      
//      
//      /*
//      //�����Լ��� �߰��ѳ��� client part
//      OutputStream out;
//        FileInputStream fin;
//        
//        try{
//            Socket soc = new Socket("127.0.0.1",9676); //127.0.0.1�� ������ �����Ƿ� �ڽ��� �����Ǹ� ��ȯ���ְ�,
//            System.out.println("Server Start!");        //11111�� �������� ��Ʈ�Դϴ�.
//            out =soc.getOutputStream();                 //������ ����Ʈ������ �����͸� ������ ��Ʈ���� �����մϴ�.
//            DataOutputStream dout = new DataOutputStream(out); //OutputStream�� �̿��� ������ ������ ������ ��Ʈ���� �����մϴ�.
//            
//            
//            Scanner s = new Scanner(System.in);   //���� �̸��� �Է¹ޱ����� ��ĳ�ʸ� �����մϴ�.
//            
//            
//            while(true){
//                String filename = s.next();    //��ĳ�ʸ� ���� ������ �̸��� �Է¹ް�,
//            fin = new FileInputStream(new File(filename)); //FileInputStream - ���Ͽ��� �Է¹޴� ��Ʈ���� �����մϴ�.
//            
//        byte[] buffer = new byte[1024];        //����Ʈ������ �ӽ������ϴ� ���۸� �����մϴ�.
//        int len;                               //������ �������� ���̸� �����ϴ� �����Դϴ�.
//        int data=0;                            //����Ƚ��, �뷮�� �����ϴ� �����Դϴ�.
//        
//        while((len = fin.read(buffer))>0){     //FileInputStream�� ���� ���Ͽ��� �Է¹��� �����͸� ���ۿ� �ӽ������ϰ� �� ���̸� �����մϴ�.
//            data++;                        //�������� ���� �����մϴ�.
//        }
//        
//        int datas = data;                      //�Ʒ� for���� ���� data�� 0�̵Ǳ⶧���� �ӽ������Ѵ�.
// 
//        fin.close();
//        fin = new FileInputStream(filename);   //FileInputStream�� ����Ǿ����� ���Ӱ� �����մϴ�.
//        dout.writeInt(data);                   //������ ����Ƚ���� ������ �����ϰ�,
//        dout.writeUTF(filename);               //������ �̸��� ������ �����մϴ�.
//        
//         len = 0;
//        
//        for(;data>0;data--){                   //�����͸� �о�� Ƚ����ŭ FileInputStream���� ������ ������ �о�ɴϴ�.
//            len = fin.read(buffer);        //FileInputStream�� ���� ���Ͽ��� �Է¹��� �����͸� ���ۿ� �ӽ������ϰ� �� ���̸� �����մϴ�.
//            out.write(buffer,0,len);       //�������� ������ ����(1kbyte��ŭ������, �� ���̸� �����ϴ�.
//        }
//        
//        System.out.println("�� "+datas+" kbyte");
//            }
//        }catch(Exception e){
//        }
//        */
//
//   }
//}