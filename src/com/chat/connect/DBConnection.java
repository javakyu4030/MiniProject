package com.chat.connect;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chat.VO.MemberVO;

//Dynamic Web Project : JSP와 같이 동적인 웹페이지를 가지는 웹 애플리케이션 개발 시에 사용하는 프로젝트
//DATABASE와 JAVA 연결  (DB연결 확인용 클레스)
public class DBConnection  {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
	
	//---------------------------------------MariaDB 연결------------------------------------------------	
	//DB 연결해서 데이터를 불러들이는 작업
	String uri = "jdbc:mariadb://127.0.0.1:3306/chat";	//db연결 ->  uri: ip주소	/데이터베이스명(chat)
	String userid = "supervisor"; //마리아DB의 사용자 계정
	String userpw = "1111"; //마리아DB의 사용자 비밀번호
	String query = "select no, userid, username,userpw, regdate from ch_member";	//데이터 테이블 쿼리문
	Class.forName("org.mariadb.jdbc.Driver"); //(jdbc안에 Driver경로) /Class.forName() ->을 이용해서 드라이버 로드/Class.forName()은 클래스로더 라는 녀석을 통해서 해당 데이터베이스 드라이버를 로드할 뿐 데이터베이스와의 연결에 관해서는 아무런 동작도 하지 않음
	
	//----------------------------------------DB데이터 객체화------------------------------------------------	
	Connection con; //Connection인터페이스->특정원본에 대한 커넥션은 Connection 인터페이스가 구현된 클래스의 객체로 표현
	Statement stmt;	//Statement인터페이스는 Connection 객체를 통해 프로그램에 리턴되는 객체에 의해 구현되는 일종의 메소드 집합을 정의 (이해 X 추가내용필요)->Statement객체는 파라미터가 없는 SQL문 전달에 사용됨
	ResultSet rs;	//ResultSet인터페이스 ->SQL문에서 SELECT문을 사용한 질의의 경우 성공시->결과물로 ResultSet 반환(인터페이스를 뜯어보면 주석에 반환 내용포함)(SQL 질의에 의해 생성된 테이블 담고있음)/ ResultSet객체->'커서(cursor)라고 불리는것을 가지고 있음(특정 행에 대한 참조를 조작)/커서란->ResultSet객체가 가져올 수있는 행의 위치를 지정 (참고 블로그 https://codedragon.tistory.com/5975)
	
	
	try {	//DB는 네트워크 연결의 문제 등에서 에러가 발생할 수 있습니다. 이에 **반드시** try-catch 문으로 에러를 잡아 StackTrace를 통해 추후 Exception이 발생한 위치를 정확히 알 수 있도록해야 함
	
	con = DriverManager.getConnection(uri, userid, userpw);	//DriverManager.getConnection() 으로 연결 얻기
	stmt = con.createStatement();	//createStatement 는 static parsing 으로 sql문을 parsing 할 때 입력된 해당 값을 sql문에 binding하여 같이 parsing 하여 실행한다
	rs = stmt.executeQuery(query);	//실행할 쿼리를 넣어줌	//객체의값을 반환  
	
	List<MemberVO> list = new ArrayList<>();	//DB의 데이터값을 베열에 담음
	
	//----------------------------------------DB연결 확인용 데이터 출력------------------------------------------------	
	while(rs.next()) {	//레코드(데이터 단위)를 While문을 통해 모두 받아옴	//선택한 요소의 다음 요소를 선택합니다.
		
		rs.getString("userid"); // Result객체를 이용 -> SELECT문의 결과를 getString()메서드를 이용하여 뽑아옴
		
		list.add(new MemberVO(rs.getInt("no"),
								rs.getString("userid"),
								rs.getString("username"),
								rs.getString("userpw"),
								rs.getString("regdate")));
	}//while문 끝
	
	 
	//DB와 연결이 정상적으로 됐느지 확인용 데이터 출력 
	for(MemberVO member: list)		//향상된 for문을 활용하여 배열에 담긴 데이터 정보를 순차적으로 꺼내서 출력
		System.out.println("멤버번호 = " +member.getNo()
				+", 아이디 = " + member.getUserid()
				+", 이름 = " + member.getUsername()
				+", 패스워드 = " + member.getUserpw()
				+", 가입날짜 = " + member.getRegdate());
	
	//    ResultSet, Statement, Connection이 null이 아니라면, 즉 어떠한 데이터를 받아오는 등 프로그램에 의하여 사용되었다면, 리소스 관리를 위해 반드시 종료.
	if(rs != null)rs.close();
	if(stmt != null)stmt.close();
	if(con != null)con.close();
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}//메인메서드 끝
	
	
}//클래스 끝
