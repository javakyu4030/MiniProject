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
//   // 클라이언트 프로그램의 작동을 시작하는 메소드
//   public void startClient(String IP, int port) {
//      Thread thread = new Thread() {
//         public void run() {
//            try {
//               socket = new Socket(IP, port);
//               receive();
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
//   
//   // 클라이언트 프로그램의 작동을 종료하는 메소드
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
//   // 서버로부터 메세지를 전달받는 메소드
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
//   // 서버로부터 사용자 명단을 받아오는 메소드
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
//   // 서버로 메세지를 전송하는 메소드
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
//      InputNickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
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
//            JOptionPane.showMessageDialog(null, "닉네임을 입력하시라고", "내 말이 똥으로 보여?", JOptionPane.ERROR_MESSAGE);
////            continue;
//            InputNickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
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
////      textArea.append("[ 채팅방 접속 ]\n");
//      
//      setTitle("[채팅 클라이언트]");
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
//      JButton btnChangeNickName = new JButton("대화명 바꾸기");
//      btnChangeNickName.setBounds(248, 0, 97, 34);
//      btnChangeNickName.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            String reNickName = JOptionPane.showInputDialog("바꿀 대화명을 입력하세요.");
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
//      JButton btnNewButton = new JButton("파일 전송(F)");
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
//      JButton btnSend = new JButton("전송");
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
//      //메인함수부 추가한내용 client part
//      OutputStream out;
//        FileInputStream fin;
//        
//        try{
//            Socket soc = new Socket("127.0.0.1",9676); //127.0.0.1은 루프백 아이피로 자신의 아이피를 반환해주고,
//            System.out.println("Server Start!");        //11111은 서버접속 포트입니다.
//            out =soc.getOutputStream();                 //서버에 바이트단위로 데이터를 보내는 스트림을 개통합니다.
//            DataOutputStream dout = new DataOutputStream(out); //OutputStream을 이용해 데이터 단위로 보내는 스트림을 개통합니다.
//            
//            
//            Scanner s = new Scanner(System.in);   //파일 이름을 입력받기위해 스캐너를 생성합니다.
//            
//            
//            while(true){
//                String filename = s.next();    //스캐너를 통해 파일의 이름을 입력받고,
//            fin = new FileInputStream(new File(filename)); //FileInputStream - 파일에서 입력받는 스트림을 개통합니다.
//            
//        byte[] buffer = new byte[1024];        //바이트단위로 임시저장하는 버퍼를 생성합니다.
//        int len;                               //전송할 데이터의 길이를 측정하는 변수입니다.
//        int data=0;                            //전송횟수, 용량을 측정하는 변수입니다.
//        
//        while((len = fin.read(buffer))>0){     //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
//            data++;                        //데이터의 양을 측정합니다.
//        }
//        
//        int datas = data;                      //아래 for문을 통해 data가 0이되기때문에 임시저장한다.
// 
//        fin.close();
//        fin = new FileInputStream(filename);   //FileInputStream이 만료되었으니 새롭게 개통합니다.
//        dout.writeInt(data);                   //데이터 전송횟수를 서버에 전송하고,
//        dout.writeUTF(filename);               //파일의 이름을 서버에 전송합니다.
//        
//         len = 0;
//        
//        for(;data>0;data--){                   //데이터를 읽어올 횟수만큼 FileInputStream에서 파일의 내용을 읽어옵니다.
//            len = fin.read(buffer);        //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
//            out.write(buffer,0,len);       //서버에게 파일의 정보(1kbyte만큼보내고, 그 길이를 보냅니다.
//        }
//        
//        System.out.println("약 "+datas+" kbyte");
//            }
//        }catch(Exception e){
//        }
//        */
//
//   }
//}