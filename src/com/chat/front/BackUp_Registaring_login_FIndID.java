/*package com.chat.front;

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

import com.chat.connect.Member;



public class BackUp_Registaring_login_FIndID extends JButton{

	private JFrame frame;
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
	private JPanel Find_Idpanel;
	private JLabel id_find;
	private JButton btn_toFindId;
	private JLabel output_idText;
	private JTextField textField;
	private JLabel outPut_id;
	private JLabel BacktoLogin_1;
	private JButton btn_backToLoging;
	private JLabel output_id;

	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					BackUp_Registaring_login_FIndID window = new BackUp_Registaring_login_FIndID();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BackUp_Registaring_login_FIndID() {
		initialize();
		frame.setLocationRelativeTo(null);//실행시 중앙에 위치
		
	}

	*//**
	 * Initialize the contents of the frame.
	 *//*
	private void initialize() {
		
		//----------------------------WindowBuilder를 통해 form생성----------------------------
		frame = new JFrame();
		frame.setTitle("\uD68C\uC6D0\uAC00\uC785");
		frame.setPreferredSize(new Dimension(500, 800));
		frame.setSize(500, 800);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//================================================================패널========================================================================
		JPanel SignUpPanel = new JPanel();	//회원가입 패널
		Member member = new Member();	//Member클래스에서 저장한 DB접근 정보를 객체로 만들어 가입정보를 삽입하기 위해 생성
		LoginPanel = new JPanel();		//로그인 패널
		
		//backgraound 1방법
		File f =new File("./image/Background.jpg");	//background 이미지를 입히기 위해 파일 불러옴
		System.out.println(f.exists()?"Exists":"doesnt exist");	//파일 존재여부 확인
		frame.pack();	//pack()메서드-> "JFrame" 의 내용물에 알맞게 윈도우 크기를 조절
		//DB에서 불러온 데이터 리스트객체 생성
		ArrayList<String> DBdata = Member.getRegistrationMember();
		frame.getContentPane().setLayout(null);
		Find_Idpanel = new JPanel();	//아이디 찾기 패널
		
		
		//----------------------------------아이디 찾기 페널------------------------
		Find_Idpanel.setBackground(Color.WHITE);
		Find_Idpanel.setBounds(0, 0, 497, 763);
		frame.getContentPane().add(Find_Idpanel);
		Find_Idpanel.setLayout(null);
		Find_Idpanel.setVisible(false);
		
		id_find = new JLabel("\uC774\uB984\uC744 \uC785\uB825\uD558\uC138\uC694!");
		id_find.setForeground(SystemColor.activeCaptionBorder);
		id_find.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
		id_find.setBackground(SystemColor.activeCaptionBorder);
		id_find.setBounds(107, 212, 206, 39);
		Find_Idpanel.add(id_find);
		
		btn_backToLoging = new JButton("");
		btn_backToLoging.setIcon(new ImageIcon("C:\\Users\\hijic\\Desktop\\eclipseSave\\MiniProject\\image\\backToLogin _1.png"));
		btn_backToLoging.setBorderPainted(false);
		btn_backToLoging.setBounds(297, 527, 62, 22);
		Find_Idpanel.add(btn_backToLoging);
		//--------------------아이디 찾기에서 로그인 페이지로 이동 버튼-------------
		btn_backToLoging.addActionListener(new ActionListener() { //아이디 찾기에서 로그인으로 이동 버튼 끝
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Find_Idpanel.setVisible(false);
				LoginPanel.setVisible(true);
				
			}
		});//아이디 찾기에서 로그인으로 이동 버튼 끝
		

		
		
		JPanel Output_Id = new JPanel();
		Output_Id.setBounds(107, 372, 276, 119);
		Find_Idpanel.add(Output_Id);
		Output_Id.setLayout(null);
		
		outPut_id = new JLabel("\uC77C\uCE58\uD558\uB294 ID\uAC00 \uC5C6\uC2B5\uB2C8\uB2E4..");
		outPut_id.setHorizontalAlignment(SwingConstants.CENTER);
		outPut_id.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		outPut_id.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
		outPut_id.setBounds(14, 50, 248, 31);
		Output_Id.add(outPut_id);
		
		output_id = new JLabel("ID");
		output_id.setForeground(SystemColor.controlDkShadow);
		output_id.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 16));
		output_id.setBackground(SystemColor.activeCaptionBorder);
		output_id.setBounds(122, 12, 31, 39);
		Output_Id.add(output_id);
		
		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textField.setBackground(SystemColor.control);
		textField.setBounds(107, 251, 276, 39);
		Find_Idpanel.add(textField);
		textField.setColumns(10);
		textField.setBorder(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hijic\\Desktop\\eclipseSave\\MiniProject\\image\\Find_Id.png"));
		btnNewButton_1.setBounds(107, 302, 167, 37);
		Find_Idpanel.add(btnNewButton_1);
		btnNewButton_1.setBorder(null);
		
		BacktoLogin_1 = new JLabel("\uC544\uC774\uB514\uB97C \uCC3E\uC73C\uC168\uB098\uC694?");
		BacktoLogin_1.setForeground(SystemColor.activeCaptionBorder);
		BacktoLogin_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
		BacktoLogin_1.setBackground(SystemColor.activeCaptionBorder);
		BacktoLogin_1.setBounds(134, 517, 161, 39);
		Find_Idpanel.add(BacktoLogin_1);
		
		// -------------------아이디 찾기 버튼 액션-------------------
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputName = textField.getText();
				
				while(true) {
					if(Member.getMemberId(inputName) != null) {
						outPut_id.setText(Member.getMemberId(inputName));
						break;
					}else {
						outPut_id.setText("일치하는 아이디가 없습니다!");
						break;
					}
				}
			}
		});//아이디 찾기 버튼 메서드 끝
	
		
		//------------------로그인 페널---------------
		
		LoginPanel.setBounds(0, 0, 497, 761);
		frame.getContentPane().add(LoginPanel);
		LoginPanel.setLayout(null);
		
		Lpanel = new JPanel();
		Lpanel.setBounds(260, 9, 1, 1);
		Lpanel.setLayout(null);
		Lpanel.setBackground(Color.WHITE);
		LoginPanel.add(Lpanel);
		
		login_text = new JLabel("ID");
		login_text.setBounds(91, 203, 38, 39);
		LoginPanel.add(login_text);
		login_text.setForeground(SystemColor.activeCaptionBorder);
		login_text.setFont(new Font("Dialog", Font.PLAIN, 16));
		login_text.setBackground(SystemColor.activeCaptionBorder);
		
		Login_inputId = new JTextField();
		Login_inputId.setBounds(91, 254, 276, 39);
		LoginPanel.add(Login_inputId);
		Login_inputId.setFont(new Font("굴림", Font.PLAIN, 12));
		Login_inputId.setColumns(10);
		Login_inputId.setBackground(SystemColor.menu);
		
		Login_Pass = new JLabel("Password");
		Login_Pass.setBounds(91, 300, 94, 39);
		LoginPanel.add(Login_Pass);
		Login_Pass.setForeground(SystemColor.activeCaptionBorder);
		Login_Pass.setFont(new Font("Dialog", Font.PLAIN, 16));
		Login_Pass.setBackground(SystemColor.activeCaptionBorder);
		
		Login_inputPass = new JPasswordField();
		Login_inputPass.setBounds(91, 350, 276, 39);
		LoginPanel.add(Login_inputPass);
		Login_inputPass.setFont(new Font("굴림", Font.PLAIN, 12));
		Login_inputPass.setBackground(SystemColor.menu);
		
		btn_login = new JButton("");
		btn_login.setHorizontalAlignment(SwingConstants.CENTER);
		btn_login.setBackground(Color.YELLOW);
		btn_login.setBounds(91, 401, 296, 95);
		LoginPanel.add(btn_login);
		
		btn_toFindId = new JButton("\uC544\uC774\uB514\uCC3E\uAE30");
		btn_toFindId.setHorizontalAlignment(SwingConstants.CENTER);
		btn_toFindId.setBackground(Color.GREEN);
		btn_toFindId.setBounds(91, 632, 296, 95);
		LoginPanel.add(btn_toFindId);
		
		btn_toRegistration = new JButton("");
		btn_toRegistration.setBounds(91, 518, 296, 95);
		LoginPanel.add(btn_toRegistration);
		btn_toRegistration.setBackground(Color.RED);
		btn_toRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		//=============================================로그인에서 아이디 찾기 페이지이동 버튼 액션=========================================================
		btn_toFindId.addActionListener(new ActionListener() {//버튼을 눌렀을때 회원가입으로
			
			@Override
			public void actionPerformed(ActionEvent e) {//액션을 취할 로직 설정	//입력받은 값들을 각각 변수에 저장
				
				
				LoginPanel.setVisible(false);
				Find_Idpanel.setVisible(true);
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
		
						LoginPanel.setVisible(false);
						// 메인화면이 켜지는 setVisible(true) 배치 자리
						break;
					} else {
						JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다!");
						break;
					}
		
				} // while 문 끝
			} // actionPerformed 끝
		}); // addActionListener() 끝
		
		
		
		
		
		//======================================================================회원가입 페널====================================================================
		
		SignUpPanel.setBounds(0, 0, 484, 761);
		frame.getContentPane().add(SignUpPanel);
		SignUpPanel.setLayout(null);
		
		//background 넣을 패널 생성
		ImagePanel Bpanel = new ImagePanel(new ImageIcon("./image/Background_1.png").getImage());
		Bpanel.setBounds(0, 0, 486, 763);
		SignUpPanel.add(Bpanel);
		Bpanel.setLayout(null);
		
		ID = new JLabel("ID");
		ID.setBounds(107, 247, 38, 39);
		Bpanel.add(ID);
		ID.setForeground(SystemColor.activeCaptionBorder);
		ID.setBackground(SystemColor.activeCaptionBorder);
		ID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		inputID = new JTextField();
		inputID.setBounds(107, 284, 276, 39);
		Bpanel.add(inputID);
		inputID.setFont(new Font("굴림", Font.PLAIN, 12));
		inputID.setBackground(SystemColor.control);
		inputID.setColumns(10);
		inputID.setBorder(null);
		
		Name = new JLabel("Name");
		Name.setBounds(107, 334, 94, 39);
		Bpanel.add(Name);
		Name.setForeground(SystemColor.activeCaptionBorder);
		Name.setBackground(SystemColor.activeCaptionBorder);
		Name.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		inputName = new JTextField();
		inputName.setBounds(107, 373, 276, 39);
		Bpanel.add(inputName);
		inputName.setFont(new Font("굴림", Font.PLAIN, 12));
		inputName.setBackground(SystemColor.control);
		inputName.setColumns(10);
		inputName.setBorder(null);
		
		Password = new JLabel("Password");
		Password.setBounds(107, 422, 94, 39);
		Bpanel.add(Password);
		Password.setForeground(SystemColor.activeCaptionBorder);
		Password.setBackground(SystemColor.activeCaptionBorder);
		Password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		inputPassword = new JPasswordField();
		inputPassword.setBounds(107, 463, 276, 39);
		Bpanel.add(inputPassword);
		inputPassword.setFont(new Font("굴림", Font.PLAIN, 12));
		inputPassword.setBackground(SystemColor.control);
		inputPassword.setBorder(null);
		
			
			btn_SignUp = new JButton("");
			btn_SignUp.setBounds(108, 579, 277, 67);
			Bpanel.add(btn_SignUp);
			btn_SignUp.setIcon(new ImageIcon("C:\\Users\\hijic\\Desktop\\eclipseSave\\MiniProject\\image\\btn_submit.png"));
			btn_SignUp.setHorizontalAlignment(btn_SignUp.CENTER);
			btn_SignUp.setBorderPainted(false);
			
			JLabel BacktoLogin = new JLabel("\uC774\uBBF8 \uC544\uC774\uB514\uAC00 \uC788\uC73C\uC2E0\uAC00\uC694?");
			BacktoLogin.setBounds(118, 658, 200, 39);
			BacktoLogin.setForeground(SystemColor.activeCaptionBorder);
			BacktoLogin.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
			BacktoLogin.setBackground(SystemColor.activeCaptionBorder);
			Bpanel.add(BacktoLogin);
			
			
			//--------------------회원가입에서 로그인 페이지로 이동 버튼-------------
			JButton btnNewButton = new JButton("");
			btnNewButton.setBounds(314, 668, 62, 22);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignUpPanel.setVisible(false);
					LoginPanel.setVisible(true);
				}
			});	//로그인으로 이동 버튼 액션 끝
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\hijic\\Desktop\\eclipseSave\\MiniProject\\image\\backToLogin _1.png"));
			btnNewButton.setBorderPainted(false);
			Bpanel.add(btnNewButton);
			
			
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
/////////////////////
 참고 할것
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
*/