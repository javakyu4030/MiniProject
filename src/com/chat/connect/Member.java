package com.chat.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import com.chat.VO.MemberVO;

//현재 클래스는 회원정보 페이지로 부터 회원정보데이터를 받아와 데이터 테이블에 삽입하는 역할
public class Member {

//-------------------------------메인 메서드--------------------------------------
	public static void main(String[] args) {
		
		//테스트용
		//getConnection();	//연결 호출
		//createMember("GGG", "김연희", "5678");	//연결이 됐는지 테스트용 더미데이터 삽입
		//getMember();
		
	}//메서드 끝
	
	//-------------------------------getConnection() 메서드--------------------------------------
	public static Connection getConnection() {	//mariaDB접근 정보를 con이라는 변수에 저장하여 연결할떄 사용 하기 위한 메서드
		try {
			//DB 연결 작업
			String uri = "jdbc:mariadb://127.0.0.1:3306/chat";	//db연결 ->  uri: ip주소	/데이터베이스명(chat)
			String userid = "supervisor"; //마리아DB의 사용자 계정
			String userpw = "1111"; //마리아DB의 사용자 비밀번호
			String query = "select no, userid, username, userpw, regdate from ch_member";	//데이터 테이블 쿼리문
			Class.forName("org.mariadb.jdbc.Driver"); //(jdbc안에 Driver경로) /Class.forName() ->을 이용해서 드라이버 로드/Class.forName()은 클래스로더 라는 녀석을 통해서 해당 데이터베이스 드라이버를 로드할 뿐 데이터베이스와의 연결에 관해서는 아무런 동작도 하지 않음
			Connection con = DriverManager.getConnection(uri, userid, userpw);	// DB접근 정보를  con 변수에 넣음
			System.out.println("THE Connection Successfull");
			return con;
		}catch(Exception e){
			System.out.println(e.getMessage( ));
			return null;
		}
	}//getConnection메서드 끝
	
	//----------------------------------createMember()-> 데이터 저장-----------------------------------------
	//DB에 접근 메서드(회원가입 정보 저장)
	public static void createMember(String inputUserid, String inputUsername, String inputUserpw) {
		try {
			Connection con = getConnection();	//연결정보(DB port,사용자 계정,사용자 비밀번호)를 호출하여 저장 ->DB와 연결 하기 위함
			PreparedStatement insert = con.prepareStatement(""
					+"INSERT INTO ch_member"		//테이블명:ch_member
					+"(userid, username, userpw)"	//데이터 삽입할 칼럼명
					+"VALUE "						//실제 들어갈 데이터 값
					+"('"+inputUserid+"', '"+inputUsername+"','"+inputUserpw+"')");	//데이터를 집어 넣기위한 쿼리문 작성 (입력한 아이디,이름,비밀번호가 저장)
			insert.executeUpdate(); //위의  쿼리문 삽입을 실행
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}//createMember메서드 끝
	
	//----------------------------------getRegistrationMember()-> 데이터 호출 ★좀더 이해 필요-----------------------------------------
	//DB에 접근 메서드(회원가입 정보 저장)
	public static ArrayList<String> getRegistrationMember() {
		try {
			Connection con = getConnection();	//연결정보(DB port,사용자 계정,사용자 비밀번호)를 호출하여 저장 ->DB와 연결 하기 위함	
			
			//Statement, PreparedStatement 인터페이스 공통점-> 두 인터페이스 모두 SQL 질의문 전달(반드시 try-catch또는 throws처리 필수),
			//차이점)Statement 객체가 생성되면 ->executeQuery( ) 메소드를 호출하여 SQL문을 실행시킬 수 있다. 메소드의 인수로 SQL문을 담은 String객체를 전달한다.
			//차이점)PreparedStatement ->Connection 객체의 preparedStatement( ) 메소드를 사용해서 생성, Statement 객체의 SQL은 실행될 때 매번 서버에서 분석해야 하는 반면, PreparedStatement 객체는 한 번 분석되면 재사용이 용이하다.

			PreparedStatement statement = con.prepareStatement("SELECT userid FROM ch_member");		//가입정보 불러오기 위한 쿼리문
			ResultSet results = statement.executeQuery();	// ResultSet인터페이스 ->명령에 대한 반환값 즉, 쿼리문("Select * from ch_member")을 통해 명령을 보내면 테이블에서 값을 가져오는데 가져온 결과값이 ResultSet객체임
			ArrayList<String> list_id = new ArrayList<String>();	//불러온 DB를 리스트에 저장
			while(results.next()) {	//next()->순차적으로 반복해서 add()메서드로 값을 list배열에 저장
				list_id.add(results.getString("userid"));	
									}
			System.out.println(list_id.toString());	// 정상적으로 불어와 졌는지 테스트
			return list_id;	//ArrayList타입의 list에 배열형태로 멤버의 아이디가 저장-> list를 반환 
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}//getRegistrationMember()메서드 끝

	//----------------------------------getLoginMember()-> 데이터 호출( ID 입력--> 해당 아이디의PW 반환) ★-----------------------------------------
	//DB에 접근 메서드(회원가입 정보 저장)
	public static String getLoginMember(String a) {	//파라미터값을 이용하여 입력받은 아이디 값을 where 조건문으로 쿼리에 넣어서 해당 아이디에 맞는 userpw 값을 가져오는 방법
		try {
			Connection con = getConnection();	//연결정보(DB port,사용자 계정,사용자 비밀번호)를 호출하여 저장 ->DB와 연결 하기 위함	
			
			//Statement, PreparedStatement 인터페이스 공통점-> 두 인터페이스 모두 SQL 질의문 전달(반드시 try-catch또는 throws처리 필수),
			//차이점)Statement 객체가 생성되면 ->executeQuery( ) 메소드를 호출하여 SQL문을 실행시킬 수 있다. 메소드의 인수로 SQL문을 담은 String객체를 전달한다.
			//차이점)PreparedStatement ->Connection 객체의 preparedStatement( ) 메소드를 사용해서 생성, Statement 객체의 SQL은 실행될 때 매번 서버에서 분석해야 하는 반면, PreparedStatement 객체는 한 번 분석되면 재사용이 용이하다.
			
			String getPass="";
			PreparedStatement statement = con.prepareStatement("SELECT userpw FROM ch_member WHERE userid= '"+a +"'");		//가입정보 불러오기 위한 쿼리문
			ResultSet results = statement.executeQuery();	// ResultSet인터페이스 ->명령에 대한 반환값 즉, 쿼리문("Select * from ch_member")을 통해 명령을 보내면 테이블에서 값을 가져오는데 가져온 결과값이 ResultSet객체임
			
			while(results.next()) {	//next()->순차적으로 반복해서 add()메서드로 값을 list배열에 저장
				getPass = results.getString("userpw");
				System.out.println(getPass);
			}
			/*
			ArrayList<String> list = new ArrayList<String>();	//불러온 DB를 리스트에 저장하기 위한 ArrayList 생성
			}
			*/
			//System.out.println(list.toString());	// 정상적으로 불어와 졌는지 테스트
			return getPass;	//ArrayList타입의 list에 배열형태로 멤버의 아이디가 저장-> list를 반환 
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}//getLoginMember()메서드 끝
		
		//----------------------------------getMemberId()-> 데이터 호출( NAME 입력--> 해당 아이디 반환) ★-----------------------------------------
		//DB에 접근 메서드(회원가입 정보 저장)
		public static String getMemberId(String a) {	//파라미터값을 이용하여 입력받은 아이디 값을 where 조건문으로 쿼리에 넣어서 해당 이름에 맞는 ID 값을 가져오는 방법
			try {
				Connection con = getConnection();	//연결정보(DB port,사용자 계정,사용자 비밀번호)를 호출하여 저장 ->DB와 연결 하기 위함	
				
				String getId="";
				PreparedStatement statement = con.prepareStatement("SELECT userid FROM ch_member WHERE username= '"+a +"'");		//가입정보(Id) 불러오기 위한 쿼리문
				ResultSet results = statement.executeQuery();	// ResultSet인터페이스 ->명령에 대한 반환값 즉, 쿼리문("Select * from ch_member")을 통해 명령을 보내면 테이블에서 값을 가져오는데 가져온 결과값이 ResultSet객체임
				
				while(results.next()) {	//next()->순차적으로 반복해서 add()메서드로 값을 list배열에 저장
					getId = results.getString("userid");
					System.out.println(getId);
				}
			
				return getId;	//ArrayList타입의 list에 배열형태로 멤버의 아이디가 저장-> list를 반환 
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		
	}//getMemberId()메서드 끝
		//----------------------------------getMemberPw()-> 데이터 호출( ID 입력--> 해당 아이디의PW 반환) ★-----------------------------------------
		//DB에 접근 메서드(회원가입 정보 저장)
		public static String getMemberPw(String a) {	//파라미터값을 이용하여 입력받은 아이디 값을 where 조건문으로 쿼리에 넣어서 해당 이름에 맞는 ID 값을 가져오는 방법
			try {
				Connection con = getConnection();	//연결정보(DB port,사용자 계정,사용자 비밀번호)를 호출하여 저장 ->DB와 연결 하기 위함	
				
				String getPw="";
				PreparedStatement statement = con.prepareStatement("SELECT userpw FROM ch_member WHERE userid= '"+a +"'");		//가입정보(Id) 불러오기 위한 쿼리문
				ResultSet results = statement.executeQuery();	// ResultSet인터페이스 ->명령에 대한 반환값 즉, 쿼리문("Select * from ch_member")을 통해 명령을 보내면 테이블에서 값을 가져오는데 가져온 결과값이 ResultSet객체임
				
				while(results.next()) {	//next()->순차적으로 반복해서 add()메서드로 값을 list배열에 저장
					getPw = results.getString("userpw");
					System.out.println(getPw);
				}
				
				return getPw;	//ArrayList타입의 list에 배열형태로 멤버의 아이디가 저장-> list를 반환 
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
			
		}//getMemberId()메서드 끝
		
		//----------------------------------setLogin()-> 로그인 성공 아이디 저장-----------------------------------------
		//DB에 접근 메서드(회원가입 정보 저장)
		public void setLogin(String a) {	//파라미터값을 이용하여 입력받은 아이디 값을 where 조건문으로 쿼리에 넣어서 해당 이름에 맞는 ID 값을 가져오는 방법
			try {
				Connection con = getConnection();	//연결정보(DB port,사용자 계정,사용자 비밀번호)를 호출하여 저장 ->DB와 연결 하기 위함
				PreparedStatement insert = con.prepareStatement
						("INSERT userid FROM ch_login WHERE userid= '"+a +"'");
				insert.executeUpdate(); //위의  쿼리문 삽입을 실행
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//setLogin()메서드 끝

}//클래스 끝