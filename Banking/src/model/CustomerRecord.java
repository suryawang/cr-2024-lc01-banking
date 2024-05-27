package model;

import java.util.Date;

public class CustomerRecord {
	private String account_no;
	private String name;
	private Date date;
	private int balance;

	public CustomerRecord(String account_no, String name, Date date, int balance) {
		this.account_no = account_no;
		this.name = name;
		this.date = date;
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccount_no() {
		return account_no;
	}

	public String getName() {
		return name;
	}
}
