
public class DataRecord {
	private String accountNumber;
	private String customerName;
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	private String month;
	private int date;
	private int year;
	private int balance;
	
	public static DataRecord from(String ar[]) {
		if(ar.length!=6) return null;
		var r = new DataRecord();
		r.accountNumber = ar[0];
		r.customerName = ar[1];
		r.month = ar[2];
		r.date = Integer.parseInt(ar[3]);
		r.year = Integer.parseInt(ar[4]);
		r.balance = Integer.parseInt(ar[5]);
		return r;
	}
	public String[] toArray() {
		return new String[] {accountNumber, customerName, month, date+"",year+"",balance+""};
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getMonth() {
		return month;
	}
	public int getDate() {
		return date;
	}
	public int getYear() {
		return year;
	}
	public int getBalance() {
		return balance;
	}
}
