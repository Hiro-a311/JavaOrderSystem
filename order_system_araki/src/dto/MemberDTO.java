package dto;

// ユーザ情報を保持するクラス
public class MemberDTO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberMail;

	public MemberDTO() {

	}

	public MemberDTO(String memberId, String memberPw, String memberName, String memberMail, String profile) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberMail = memberMail;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberMail() {
		return memberMail;
	}

	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}



}
