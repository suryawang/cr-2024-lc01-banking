
public class DataRecord {
	private String accountNumber;
	private String customerName;
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
