
//현재까지 이 프로젝트에서 VO를 사용하고 있지 않는 중
package com.chat.VO;

//DB에 저장된 데이터테이블 (ch_member)
public class MemberVO {

		private int no;
		private String userid;
		private String username;
		private String userpw;
		private String regdate;
		
		//--------------------constructor-----------------------
		public MemberVO() {}
		
		public MemberVO(String userid) {
			this.userid = userid;
		}
	
		public MemberVO(int no,String userid,String username,String userpw, String regdate) {
			this.no = no;
			this.userid = userid;
			this.username = username;
			this.userpw = userpw;
			this.regdate = regdate;
			
		}

		//---------------------getter setter---------------------
		public int getNo() {
			return no;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUserpw() {
			return userpw;
		}
		public void setUserpw(String userpw) {
			this.userpw = userpw;
		}
		public String getRegdate() {
			return regdate;
		}
		
		
}
