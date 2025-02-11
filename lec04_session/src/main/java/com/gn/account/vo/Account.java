package com.gn.account.vo;

public class Account {
	private int accountNo;
	private String accountId;
	private String accountPw;
	private String accountName;
	
	public Account() {
		super();
	}
	
	public Account(int accountNo, String accountId, String accountPw, String accountName) {
		super();
		this.accountNo = accountNo;
		this.accountId = accountId;
		this.accountPw = accountPw;
		this.accountName = accountName;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountPw() {
		return accountPw;
	}

	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	@Override
	public String toString() {
		return "[번호=" + accountNo
				+ ", 아이디=" + accountId
				+ ", 비밀번호=" + accountPw
				+ ", 이름=" + accountName + "]";
	}
}
