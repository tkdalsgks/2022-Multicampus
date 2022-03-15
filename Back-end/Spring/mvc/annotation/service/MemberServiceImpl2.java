package annotation.service;

public class MemberServiceImpl2 implements MemberService{
	MemberDAO dao;
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}
	@Override
	public void regiterMember() {
		boolean result = dao.selectMember(); 
		if(!result) {
			dao.insertMember();
		}
		
	}

	@Override
	public void login() {
		boolean result = dao.selectMember();
		if(result) {
			System.out.println("정상 로그인 사용자");
		}
		else {
			System.out.println("비정상 로그인 사용자");			
		}
		
	}

}
