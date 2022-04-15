//package com.chat.client;
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//
//
//public class Client_backup extends JFrame {
//
//   Socket socket;
//   Socket socket2;
//   JPanel contentPane;
//   JPanel panel_1 = new JPanel();
//   JTextArea textArea;
//   JTextArea userArea;
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
//   // �����κ��� ����� ������ �޾ƿ��� �޼ҵ�
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
//   public Client_backup() {
//      
//      setName();
//      receiveUserList();
//      int port = 9876;
//      startClient(IPText, port);
////      textArea.append("[ ä�ù� ���� ]\n");
//      
//      setTitle("[ä�� Ŭ���̾�Ʈ]");
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      setBounds(100, 100, 450, 300);
//      contentPane = new JPanel();
//      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//      setContentPane(contentPane);
//      contentPane.setLayout(null);
//      
//      JPanel panel = new JPanel();
//      panel.setBounds(0, 0, 434, 34);
//      contentPane.add(panel);
//      panel.setLayout(null);
//      
//      userName.setForeground(Color.BLACK);
//      userName.setBackground(Color.WHITE);
//      userName.setEnabled(false);
//      userName.setBounds(0, 0, 154, 34);
//      panel.add(userName);
//      
//      JButton btnChangeNickName = new JButton("��ȭ�� �ٲٱ�");
//      btnChangeNickName.setBounds(248, 0, 97, 34);
//      btnChangeNickName.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            String reNickName = JOptionPane.showInputDialog("�ٲ� ��ȭ���� �Է��ϼ���.");
//            if(reNickName != null) {
//               userName.setText(reNickName);
//            }
//         }
//      });
//      panel.add(btnChangeNickName);
//      
//      JLabel userList = new JLabel("userList");
//      userList.setEnabled(false);
//      userList.setBounds(345, 0, 89, 34);
//      panel.add(userList);
//      
//      JButton btnNewButton = new JButton("���� ����(F)");
//      btnNewButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            
//            
//         }
//      });
//      
//      
//      btnNewButton.setBounds(143, 6, 109, 23);
//      panel.add(btnNewButton);
//      panel_1.setBounds(0, 33, 344, 190);
//      contentPane.add(panel_1);
//      panel_1.setLayout(null);
//      
//      textArea = new JTextArea();
//      textArea.setEnabled(false);
//      textArea.setEditable(false);
////      JScrollPane scrollPane = new JScrollPane(textArea);
//      textArea.setBounds(0, 0, 340, 190);
////      scrollPane.setBounds(340, 0, 344, 190);
////      scrollPane.setBackground(Color.black);
//      panel_1.add(textArea);
////      panel_1.add(scrollPane);
//      
//      JPanel panel_2 = new JPanel();
//      panel_2.setBounds(345, 33, 89, 190);
//      contentPane.add(panel_2);
//      panel_2.setLayout(null);
//      
//      userArea = new JTextArea();
////      userArea.setEditable(false);
////      userArea.setEnabled(false);
////      userArea.append(InputNickName);
////      userArea.setText("userArea");
//      userArea.setBounds(0, 0, 89, 190);
//      panel_2.add(userArea);
//      
//      JPanel panel_3 = new JPanel();
//      panel_3.setBounds(0, 227, 434, 34);
//      contentPane.add(panel_3);
//      panel_3.setLayout(null);
//      
//      JTextField input = new JTextField();
//      input.setBounds(0, 0, 345, 34);
//      
//      panel_3.add(input);
//      input.setColumns(10);
//      input.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            JTextField t = (JTextField)e.getSource();
//            send(userName.getText() + ": " + t.getText() + "\n");
//            input.setText("");
//            input.requestFocus();
//         }
//      });
//   
//      JButton btnSend = new JButton("����");
//      btnSend.setBounds(343, 0, 91, 34);
//      btnSend.addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            send(userName.getText() + ": " + input.getText() + "\n");
//            input.setText("");
//            input.requestFocus();
//         }
//      });
//      panel_3.add(btnSend);
//   }
//   /**
//    * Launch the application.
//    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               Client_backup frame = new Client_backup();
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