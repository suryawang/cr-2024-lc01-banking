package repository;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.CustomerRecord;

public class CustomerRepository {
	private static CustomerRepository _instance = new CustomerRepository();

	private CustomerRepository() {
		populate();
	}

	public static CustomerRepository getInstance() {
		return _instance;
	}

	public boolean exists(String account_no) {
		for (var o : records)
			if (o.getAccount_no().equals(account_no))
				return true;
		return false;
	}
	public void Add(CustomerRecord record) throws IOException {
			FileOutputStream fos = new FileOutputStream("Bank.dat", true);
			DataOutputStream dos = new DataOutputStream(fos);
			var y = new SimpleDateFormat("yyyy");
			var m = new SimpleDateFormat("MMMM");
			var d = new SimpleDateFormat("dd");
			dos.writeUTF(record.getAccount_no());
			dos.writeUTF(record.getName());
			dos.writeUTF(m.format(record.getDate()));
			dos.writeUTF(d.format(record.getDate()));
			dos.writeUTF(y.format(record.getDate()));
			dos.writeUTF(""+record.getBalance());
			records.add(record);
			dos.close();
			fos.close();
	}

	private Vector<CustomerRecord> records = new Vector<CustomerRecord>();

	private void populate() {
		records = new Vector<CustomerRecord>();
		try {
			var fis = new FileInputStream("Bank.dat");
			var dis = new DataInputStream(fis);
			try {
				String r[] = new String[6];
				while (true) {
					for (int i = 0; i < 6; i++) {
						r[i] = dis.readUTF();
					}
					var s = new SimpleDateFormat("MMMM dd yyyy");
					records.add(new CustomerRecord(r[0], r[1], s.parse(r[2] + " " + r[3] + " " + r[4]),
							Integer.parseInt(r[5])));
				}
			} catch (Exception ex) {
			}
			try {
				dis.close();
				fis.close();
			} catch (Exception exp) {
			}
		} catch (Exception ex) {

		}
	}
}
