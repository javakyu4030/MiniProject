package com.chat.front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.chat.VO.MemberVO;
import com.chat.client.Main;
import com.chat.connect.Member;


public class Registration extends JButton{

	private JFrame frmChat;
	private JTextField inputName;
	private JPasswordField inputPassword;
	private JTextField inputID;
	private final Action action = new SwingAction();
	private JButton btn_SignUp;
	private JLabel ID;
	private JLabel Name;
	private JLabel Password;
	private JPanel LogPanel;
	private JButton toSignUp;
	private JPanel LoginPanel;
	private JPanel Lpanel;
	private JButton btn_toRegistration;
	private JLabel login_text;
	private JTextField Login_inputId;
	private JLabel Login_Pass;
	private JPasswordField Login_inputPass;
	private JButton btn_login;
	private JPanel Find_IDpanel;
	private JLabel id_find;
	private JButton btn_toFindId;
	private JLabel output_idText;
	private JTextField find_inputName;
	private JLabel outPut_id;
	private JLabel BacktoLogin_1;
	private JButton btn_backToLoging1;
	private JLabel output_id;
	private JButton btn_toFindPW;
	private JTextField find_inputId;
	private JPanel Output_pw;
	private JLabel outPut_pw;
	private JLabel output_pw;
	private JButton btn_FIndPwButton;
	private JButton btn_backToLoging3;
	private JLabel BacktoLogin_2;
	private JPanel find_id_backPenel;
	private JPanel Cpanel;
	private JPanel Fpanel_1;
	private JPanel Logo_panel;
	private ArrayList<MemberVO> tmp= new ArrayList<MemberVO>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frmChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public Registration() {
		initialize();
		frmChat.setLocationRelativeTo(null);//실행시 중앙에 위치
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//----------------------------WindowBuilder를 통해 form생성----------------------------
		frmChat = new JFrame();
		frmChat.setTitle("GROUP BY 3");
		frmChat.setPreferredSize(new Dimension(500, 800));
		frmChat.setSize(500, 800);
		frmChat.setResizable(false);
		frmChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Member member = new Member();	//Member클래스에서 저장한 DB접근 정보를 객체로 만들어 가입정보를 삽입하기 위해 생성
		
		//================================================================패널 끝========================================================================
		
		//backgraound 1방법
		File f =new File("./image/Background.jpg");	//background 이미지를 입히기 위해 파일 불러옴
		System.out.println(f.exists()?"Exists":"doesnt exist");	//파일 존재여부 확인
		frmChat.pack();	//pack()메서드-> "JFrame" 의 내용물에 알맞게 윈도우 크기를 조절
		//DB에서 불러온 데이터 리스트객체 생성
		ArrayList<String> DBdata = Member.getRegistrationMember();
		frmChat.getContentPane().setLayout(null);
		
				
				/*
				 //background 넣을 패널 생성
				ImagePanel Bpanel = new ImagePanel(new ImageIcon("./image/SignUp_Background_1.png").getImage());
				Bpanel.setBounds(0, 0, 497, 763);
				SignUpPanel.add(Bpanel);
				Bpanel.setLayout(null); 
				 */
		

			
			//----------------------------------아이디 찾기 패널------------------------
			Find_IDpanel = new JPanel();	//아이디 찾기 패널
			
			Find_IDpanel.setBackground(Color.WHITE);
			Find_IDpanel.setBounds(0, 0, 497, 763);
			frmChat.getContentPane().add(Find_IDpanel);
			Find_IDpanel.setLayout(null);
			Find_IDpanel.setVisible(false);
			
			
			
			//----------------------------------아이디 찾기 background 페널------------------------
			ImagePanel Fpanel_1_1 = new ImagePanel(new ImageIcon("./image/Find_background_form.png").getImage());
			Fpanel_1_1.setBounds(0, 0, 485, 763);
			Find_IDpanel.add(Fpanel_1_1);
			
			id_find = new JLabel("\uC774\uB984\uC744 \uC785\uB825\uD558\uC138\uC694!");
			id_find.setBounds(107, 280, 206, 39);
			Fpanel_1_1.add(id_find);
			id_find.setForeground(SystemColor.activeCaptionBorder);
			id_find.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 20));
			id_find.setBackground(SystemColor.activeCaptionBorder);
			
			btn_backToLoging1 = new JButton("");
			btn_backToLoging1.setBounds(297, 595, 62, 22);
			Fpanel_1_1.add(btn_backToLoging1);
			btn_backToLoging1.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\backToLogin _1.png"));
			btn_backToLoging1.setBorderPainted(false);
			

			
			
			JPanel Output_Id = new JPanel();
			Output_Id.setBounds(107, 440, 276, 119);
			Fpanel_1_1.add(Output_Id);
			Output_Id.setForeground(Color.DARK_GRAY);
			Output_Id.setLayout(null);
			
			outPut_id = new JLabel("");
			outPut_id.setHorizontalAlignment(SwingConstants.CENTER);
			outPut_id.setForeground(UIManager.getColor("CheckBox.darkShadow"));
			outPut_id.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
			outPut_id.setBounds(14, 50, 248, 31);
			Output_Id.add(outPut_id);
			
			output_id = new JLabel("ID");
			output_id.setHorizontalAlignment(SwingConstants.CENTER);
			output_id.setForeground(SystemColor.controlDkShadow);
			output_id.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 16));
			output_id.setBackground(SystemColor.activeCaptionBorder);
			output_id.setBounds(14, 12, 248, 39);
			Output_Id.add(output_id);
			
			find_inputName = new JTextField();
			find_inputName.setBounds(107, 319, 276, 39);
			Fpanel_1_1.add(find_inputName);
			find_inputName.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
			find_inputName.setBackground(SystemColor.control);
			find_inputName.setColumns(10);
			find_inputName.setBorder(null);
			
			JButton btn_FIndIdButton = new JButton("");
			btn_FIndIdButton.setBounds(107, 370, 168, 37);
			Fpanel_1_1.add(btn_FIndIdButton);
			btn_FIndIdButton.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\Find_Id2.png"));
			btn_FIndIdButton.setBorder(null);
			
			BacktoLogin_1 = new JLabel("\uC544\uC774\uB514\uB97C \uCC3E\uC73C\uC168\uB098\uC694?");
			BacktoLogin_1.setBounds(134, 585, 161, 39);
			Fpanel_1_1.add(BacktoLogin_1);
			BacktoLogin_1.setForeground(SystemColor.activeCaptionBorder);
			BacktoLogin_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 15));
			BacktoLogin_1.setBackground(SystemColor.activeCaptionBorder);
			
			// -------------------아이디 찾기 버튼 액션-------------------
			btn_FIndIdButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String inputName = find_inputName.getText();
					
					while(true) {
						if(Member.getMemberId(inputName).trim() != "") {
							outPut_id.setText(Member.getMemberId(inputName));
							break;
						}else {
							outPut_id.setText("일치하는 정보가 없습니다!");
							break;
						}
					}
				}
			});//아이디 찾기 버튼 메서드 끝
			//--------------------아이디 찾기에서 로그인 페이지로 이동 버튼-------------
			btn_backToLoging1.addActionListener(new ActionListener() { //아이디 찾기에서 로그인으로 이동 버튼 끝
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Find_IDpanel.setVisible(false);
					LoginPanel.setVisible(true);
					
				}
			});//아이디 찾기에서 로그인으로 이동 버튼 끝
			Find_IDpanel.setVisible(false);
		
		//======================================================================회원가입 페널====================================================================
		
		JPanel SignUpPanel = new JPanel();	//회원가입 패널
		SignUpPanel.setBounds(0, 0, 497, 761);
		frmChat.getContentPane().add(SignUpPanel);
		SignUpPanel.setLayout(null);
		
		//background 넣을 패널 생성
		ImagePanel Bpanel = new ImagePanel(new ImageIcon("./image/SignUp_Background_1.png").getImage());
		Bpanel.setBounds(0, 0, 497, 763);
		SignUpPanel.add(Bpanel);
		Bpanel.setLayout(null);
		
		ID = new JLabel("ID");
		ID.setBounds(107, 247, 38, 39);
		Bpanel.add(ID);
		ID.setForeground(SystemColor.activeCaptionBorder);
		ID.setBackground(SystemColor.activeCaptionBorder);
		ID.setFont(new Font("Arial Black", Font.PLAIN, 16));
		
		inputID = new JTextField();
		inputID.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		inputID.setBounds(107, 284, 276, 39);
		Bpanel.add(inputID);
		inputID.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
		inputID.setBackground(SystemColor.control);
		inputID.setColumns(10);
		inputID.setBorder(null);
		
		Name = new JLabel("Name");
		Name.setBounds(107, 334, 94, 39);
		Bpanel.add(Name);
		Name.setForeground(SystemColor.activeCaptionBorder);
		Name.setBackground(SystemColor.activeCaptionBorder);
		Name.setFont(new Font("Arial Black", Font.PLAIN, 16));
		
		inputName = new JTextField();
		inputName.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		inputName.setBounds(107, 373, 276, 39);
		Bpanel.add(inputName);
		inputName.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
		inputName.setBackground(SystemColor.control);
		inputName.setColumns(10);
		inputName.setBorder(null);
		
		Password = new JLabel("Password");
		Password.setBounds(107, 422, 94, 39);
		Bpanel.add(Password);
		Password.setForeground(SystemColor.activeCaptionBorder);
		Password.setBackground(SystemColor.activeCaptionBorder);
		Password.setFont(new Font("Arial Black", Font.PLAIN, 16));
		
		inputPassword = new JPasswordField();
		inputPassword.setBounds(107, 463, 276, 39);
		Bpanel.add(inputPassword);
		inputPassword.setFont(new Font("굴림", Font.PLAIN, 12));
		inputPassword.setBackground(SystemColor.control);
		inputPassword.setBorder(null);
		
			
			btn_SignUp = new JButton("");
			btn_SignUp.setBounds(108, 579, 276, 69);
			Bpanel.add(btn_SignUp);
			btn_SignUp.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\btn_submit.png"));
			btn_SignUp.setHorizontalAlignment(btn_SignUp.CENTER);
			btn_SignUp.setBorderPainted(false);
			
			JLabel BacktoLogin = new JLabel("\uC774\uBBF8 \uC544\uC774\uB514\uAC00 \uC788\uC73C\uC2E0\uAC00\uC694?");
			BacktoLogin.setBounds(118, 658, 200, 39);
			BacktoLogin.setForeground(Color.LIGHT_GRAY);
			BacktoLogin.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
			BacktoLogin.setBackground(SystemColor.windowBorder);
			Bpanel.add(BacktoLogin);
			
			
			//--------------------회원가입에서 로그인 페이지로 이동 버튼-------------
			JButton btn_backToLoging2 = new JButton("");
			btn_backToLoging2.setBounds(314, 668, 62, 22);
			btn_backToLoging2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignUpPanel.setVisible(false);
					LoginPanel.setVisible(true);
				}
			});	//로그인으로 이동 버튼 액션 끝
			btn_backToLoging2.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\backToLogin _1.png"));
			btn_backToLoging2.setBorderPainted(false);
			Bpanel.add(btn_backToLoging2);
			
			
			//=============================================회원가입 액션=========================================================
			btn_SignUp.addActionListener(new ActionListener() {//버튼을 눌렀을때 액션을 취하도록 하는 메서드
				@Override
				public void actionPerformed(ActionEvent e) {	//액션을 취할 로직 설정	//입력받은 값들을 각각 변수에 저장
					String newId = inputID.getText();	//id입력값 newId 변수에 저장
					String newName = inputName.getText();	//이름 입력값 newName 변수에 저장
					String newPw = inputPassword.getText();	//패스워드 입력값 newPw 변수에 저장
					
					
					//조건절을 통해 입력한 값이 데이터테이블에 저장되어있는 정보와 중복되는지 여부를 판단하여 중복X->저장및 가입성공 메시지 띄움/ 중복O-> 중복임을 알리는 메시지 띄움/
					System.out.println("=====================1==========================");
					try {
					while(true) {	//반복문을 통해 배열에 담긴 값과 비교
					if(!DBdata.contains(newId) && !newId.trim().equals("") && !newName.trim().equals("") && !newPw.trim().equals("")) { //입력한 아이디값이 DB에서 가져온 데이터값(배열)과 비교해서 있으면 거부 출력 없으면 저장하도록	//설정한 조건->아이디가 일치하지 않고 이름이 null값이 아니고 비밀번호가 null값이 아닐때 (공백의 경우 trime()메서드로 제거)->member.createMember(newId, newName, newPw);실행
						//String을 뜯어보면->      this.value = "".value; //Initializes a newly created {@code String} object so that it represents-> 스트링 타입의 새로운 객체를 생성할때 ""이렇게 초기화 된다, 즉 null이 아닌 '빈값'으로 초기화 되고 그래서 equals에서 비교할때 null값으로 비교했을시 오류가 발생하고  ""비교시 작동 했던것..
						member.createMember(newId, newName, newPw);
						System.out.println(DBdata.toString());
						System.out.println("=====================2==========================");
						JOptionPane.showMessageDialog(null, "회원가입을 성공하였습니다");
						System.out.println("=====================3==========================");
						SignUpPanel.setVisible(false);	//회원가입 성공 후 데이터베이스에 저장된 후  더이상 회원가입패널이 보여지지 않게함
						LoginPanel.setVisible(true);
						
						break;
					}else {// 아이디 비밀번호가 다를 경우
						JOptionPane.showMessageDialog(null, "입력한 아이디가 이미 존재하거나 \n 작성이 완료되지 않았습니다");
						System.out.println("=====================4==========================");
						break;
					}
					}//WHile문 끝
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
					
				}//actionPerformed 끝
			});	//addActionListener끝 
			
			
				
				
			SignUpPanel.setVisible(false);
			
		/*	//background 넣을 패널 생성
			ImagePanel Lpanel = new ImagePanel(new ImageIcon("./image/Login_background.png").getImage());
			Lpanel.setBounds(0, 0, 497, 763);
			LoginPanel.add(Lpanel);
			Lpanel.setLayout(null);*/
			LoginPanel = new JPanel();		//로그인 패널
			LoginPanel.setBackground(Color.WHITE);
			
				
				//------------------로그인 페널---------------
				
				LoginPanel.setBounds(0, 0, 497, 761);
				frmChat.getContentPane().add(LoginPanel);
				LoginPanel.setLayout(null);
				
				
				Lpanel = new JPanel();
				Lpanel.setBounds(260, 9, 1, 1);
				Lpanel.setLayout(null);
				Lpanel.setBackground(Color.WHITE);
				LoginPanel.add(Lpanel);
				
				login_text = new JLabel("ID");
				login_text.setBounds(94, 287, 38, 39);
				LoginPanel.add(login_text);
				login_text.setForeground(Color.GRAY);
				login_text.setFont(new Font("Arial Black", Font.PLAIN, 20));
				login_text.setBackground(SystemColor.activeCaptionBorder);
				
				Login_inputId = new JTextField();
				Login_inputId.setBounds(94, 325, 317, 45);
				Login_inputId.setForeground(UIManager.getColor("CheckBox.darkShadow"));
				LoginPanel.add(Login_inputId);
				Login_inputId.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
				Login_inputId.setColumns(10);
				Login_inputId.setBackground(SystemColor.menu);
				Login_inputId.setBorder(null);
				
				Login_Pass = new JLabel("Password");
				Login_Pass.setBounds(94, 382, 133, 39);
				LoginPanel.add(Login_Pass);
				Login_Pass.setForeground(Color.GRAY);
				Login_Pass.setFont(new Font("Arial Black", Font.PLAIN, 20));
				Login_Pass.setBackground(SystemColor.activeCaptionBorder);
				
				Login_inputPass = new JPasswordField();
				Login_inputPass.setBounds(94, 421, 317, 45);
				Login_inputPass.setForeground(UIManager.getColor("CheckBox.darkShadow"));
				LoginPanel.add(Login_inputPass);
				Login_inputPass.setFont(new Font("굴림체", Font.PLAIN, 15));
				Login_inputPass.setBackground(SystemColor.menu);
				Login_inputPass.setBorder(null);
				
				btn_login = new JButton("");
				btn_login.setBounds(94, 495, 317, 53);
				btn_login.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\Login.png"));
				btn_login.setHorizontalAlignment(SwingConstants.CENTER);
				btn_login.setBackground(Color.WHITE);
				btn_login.setBorderPainted(false);
				LoginPanel.add(btn_login);
				
				btn_toFindId = new JButton("");
				btn_toFindId.setBounds(133, 627, 105, 23);
				btn_toFindId.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\btn_find_id.png"));
				btn_toFindId.setHorizontalAlignment(SwingConstants.CENTER);
				btn_toFindId.setBackground(Color.WHITE);
				LoginPanel.add(btn_toFindId);
				btn_toFindId.setBorder(null);
				
				btn_toFindPW = new JButton("");
				btn_toFindPW.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\btn_find_pw.png"));
				btn_toFindPW.setHorizontalAlignment(SwingConstants.CENTER);
				btn_toFindPW.setBorder(null);
				btn_toFindPW.setBackground(Color.WHITE);
				btn_toFindPW.setBounds(253, 627, 127, 24);
				LoginPanel.add(btn_toFindPW);
				
				btn_toRegistration = new JButton("");
				btn_toRegistration.setBounds(94, 560, 315, 55);
				btn_toRegistration.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\SignUp.png"));
				LoginPanel.add(btn_toRegistration);
				btn_toRegistration.setBackground(new Color(255, 255, 255));
				btn_toRegistration.setHorizontalAlignment(SwingConstants.CENTER);
				btn_toRegistration.setBorderPainted(false);
				
				
				//로그인 로고 이미지
				ImagePanel Logo_Panel = new ImagePanel(new ImageIcon("./image/Login_Logo_1.png").getImage());
				Logo_Panel.setBounds(103, 68, 331, 209);
				LoginPanel.add(Logo_Panel);
				
				
				//=============================================로그인에서 아이디 찾기 페이지이동 버튼 액션=========================================================
				btn_toFindId.addActionListener(new ActionListener() {//버튼을 눌렀을때 회원가입으로
					
					@Override
					public void actionPerformed(ActionEvent e) {//액션을 취할 로직 설정	//입력받은 값들을 각각 변수에 저장
						
						
						LoginPanel.setVisible(false);
						Find_IDpanel.setVisible(true);
					}
				});
				
							
				//=============================================로그인에서 회원가입 페이지이동 버튼 액션=========================================================
				btn_toRegistration.addActionListener(new ActionListener() {//버튼을 눌렀을때 회원가입으로
					
					@Override
					public void actionPerformed(ActionEvent e) {//액션을 취할 로직 설정	//입력받은 값들을 각각 변수에 저장
						
						
						LoginPanel.setVisible(false);
						SignUpPanel.setVisible(true);
					}
				});
				
				
				// -------------------로그인 버튼 액션-------------------
				btn_login.addActionListener(new ActionListener() {// 버튼을 눌렀을때 액션을 취하도록 하는 메서드
				
					@Override
					public void actionPerformed(ActionEvent e) {// 액션을 취할 로직 설정 //입력받은 값들을 각각 변수에 저장
						String newLogId = Login_inputId.getText(); // id입력값 newId 변수에 저장
						String newLogPw = Login_inputPass.getText(); // 패스워드 입력값 newPw 변수에 저장
						
						while (true) {
							if (Member.getLoginMember(newLogId).equals(newLogPw) && !newLogId.trim().equals("")
									&& !newLogPw.trim().equals("")) {
								
								/*
								while(true) {
									if(tmp.contains(newLogId)){
										JOptionPane.showMessageDialog(null, "이미 로그인 되어있습니다!");
										break;
									}else {
										tmp.add(newLogId);
										break;
									}
								}
								*/
								LoginPanel.setVisible(false);

								Main frame = new Main();
								//채팅창 open
								frame.setVisible(true);//로그인 성공후 채팅창 동작
								// 메인화면이 켜지는 setVisible(true) 배치 자리
								break;
							} else {
								JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다!");
								break;
							}
				
						} // while 문 끝
					} // actionPerformed 끝
				}); // addActionListener() 끝
			Bpanel.setLayout(null);

			
			JLabel id_find_1 = new JLabel("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694!");
			id_find_1.setBounds(105, 214, 206, 39);
			id_find_1.setForeground(SystemColor.activeCaptionBorder);
			id_find_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 20));
			id_find_1.setBackground(SystemColor.activeCaptionBorder);
			
			
			//----------------------------------비밀번호 찾기 페널------------------------
			JPanel FInd_PWpanel = new JPanel();
			FInd_PWpanel.setBackground(Color.WHITE);
			FInd_PWpanel.setBounds(0, 0, 497, 761);
			frmChat.getContentPane().add(FInd_PWpanel);
			FInd_PWpanel.setLayout(null);
			FInd_PWpanel.add(id_find_1);
			
					
					find_inputId = new JTextField();
					find_inputId.setBounds(105, 253, 276, 39);
					find_inputId.setForeground(Color.DARK_GRAY);
					find_inputId.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
					find_inputId.setColumns(10);
					find_inputId.setBorder(null);
					find_inputId.setBackground(SystemColor.menu);
					FInd_PWpanel.add(find_inputId);
					
					Output_pw = new JPanel();
					Output_pw.setBounds(105, 372, 276, 119);
					Output_pw.setLayout(null);
					FInd_PWpanel.add(Output_pw);
					
					outPut_pw = new JLabel("");
					outPut_pw.setHorizontalAlignment(SwingConstants.CENTER);
					outPut_pw.setForeground(SystemColor.controlDkShadow);
					outPut_pw.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
					outPut_pw.setBounds(14, 50, 248, 31);
					Output_pw.add(outPut_pw);
					
					output_pw = new JLabel("PASSWORD");
					output_pw.setHorizontalAlignment(SwingConstants.CENTER);
					output_pw.setForeground(SystemColor.controlDkShadow);
					output_pw.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 16));
					output_pw.setBackground(SystemColor.activeCaptionBorder);
					output_pw.setBounds(14, 12, 248, 39);
					Output_pw.add(output_pw);
					
					// -------------------비밀번호 찾기 버튼 액션-------------------
					btn_FIndPwButton = new JButton("");
					btn_FIndPwButton.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\btn_find_pw_1.png"));
					btn_FIndPwButton.setBounds(105, 304, 180, 38);
					btn_FIndPwButton.setBorder(null);
					btn_FIndPwButton.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {	
							String inputId = find_inputId.getText();	//Member 클레스에서 만든 getMemberId()메서드를 통해서 입력한 Id를 전달하고 pw를 반환받음
							
							while(true) {
								if(Member.getMemberPw(inputId).trim() != "") {
									System.out.println("=================1_1=======================");
									outPut_pw.setText(Member.getMemberPw(inputId));
									System.out.println("=================1_2=======================");
									break;
								}else{
									System.out.println("=================1=======================");
									outPut_pw.setText("일치하는 회원정보가 없습니다!");
									System.out.println("=================2=======================");
									break;
								}
							}
						}
					});	//비밀번호 찾기 버튼 액션 끝
					
							//-----------비밀번호 찾기 페이지에서 비번찾기 버튼-----------
							btn_FIndPwButton.setBorder(null);
							FInd_PWpanel.add(btn_FIndPwButton);
							
							btn_backToLoging3 = new JButton("");
							btn_backToLoging3.setBounds(308, 525, 62, 22);
							btn_backToLoging3.setIcon(new ImageIcon("C:\\Users\\aaa\\eclipse-workspace\\MiniProject\\image\\backToLogin _1.png"));
							btn_backToLoging3.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
								}
							});
							btn_backToLoging3.setBorderPainted(false);
							FInd_PWpanel.add(btn_backToLoging3);
							
							//--------------------비밀번호 찾기에서 로그인 페이지로 이동 버튼-------------
							btn_backToLoging3.addActionListener(new ActionListener() { //아이디 찾기에서 로그인으로 이동 버튼 끝
								
								@Override
								public void actionPerformed(ActionEvent e) {
									FInd_PWpanel.setVisible(false);
									LoginPanel.setVisible(true);
									
								}
							});//비밀번호 찾기에서 로그인으로 이동 버튼 끝
							
							BacktoLogin_2 = new JLabel("\uBE44\uBC00\uBC88\uD638\uB97C \uCC3E\uC73C\uC168\uB098\uC694?");
							BacktoLogin_2.setBounds(133, 515, 194, 39);
							BacktoLogin_2.setForeground(Color.LIGHT_GRAY);
							BacktoLogin_2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 15));
							BacktoLogin_2.setBackground(SystemColor.activeCaptionBorder);
							FInd_PWpanel.add(BacktoLogin_2);
							
							
							//--------------------이이디찾기 background 이미지-----------	//find_background_form
							ImagePanel Fpanel_2 = new ImagePanel(new ImageIcon("./image/Find_background_form_1.png").getImage());
							Fpanel_2.setBounds(0, 0, 497, 761);
							FInd_PWpanel.add(Fpanel_2);
							FInd_PWpanel.setVisible(false);
			
			//=============================================로그인에서 비밀번호 찾기 페이지이동 버튼 액션=========================================================
			btn_toFindPW.addActionListener(new ActionListener() {//버튼을 눌렀을때 회원가입으로
				
				@Override
				public void actionPerformed(ActionEvent e) {//액션을 취할 로직 설정	//입력받은 값들을 각각 변수에 저장
					
					
					LoginPanel.setVisible(false);
					FInd_PWpanel.setVisible(true);
				}
			});
			
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}//소스 파일 끝
//--------------------------------------------background panel----------------------------------------------

class ImagePanel extends JPanel{	//panel에 백그라운드 이미지를 삽입 하기 위한 클래스 생성
		private Image img;
		
		public ImagePanel(Image img) {
			this.img=img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
		}//생성자 끝
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	
}

/* 참고 할것
panelClock2.setLayout(null);

JButton Clock2 = new JButton("");
Clock2.setIcon(new ImageIcon("C:\\Users\\Nam\\Desktop\\clock2.jpg"));
Clock2.setBounds(0, 0, 433, 433);
panelClock2.add(Clock2);



panelClock2.setVisible(false);

btnBCU.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel_beaconU.setVisible(false);
		panel_beaconE.setVisible(true);
		
	}
});
btnBCE.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel_beaconU.setVisible(true);
		panel_beaconE.setVisible(false);
		
	}
});

Clock1.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panelClock1.setVisible(false);
		panelClock2.setVisible(true);
		
	}
});
Clock2.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panelClock1.setVisible(true);
		panelClock2.setVisible(false);
		
	}
});

			
		
			
 		//background 넣을 패널 생성
		ImagePanel Find_IDpanel = new ImagePanel(new ImageIcon("./image/Find_background.png").getImage());
		ImagePanel Bpanel = new ImagePanel(new ImageIcon("./image/SignUp_Background_1.png").getImage());
		Bpanel.setBounds(0, 0, 497, 763);
		SignUpPanel.add(Bpanel);
		Bpanel.setLayout(null);
		
			
*/