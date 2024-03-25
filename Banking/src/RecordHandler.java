import java.io.DataInputStream;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

public class RecordHandler {
	private int count;
	private int rows;
	private int total;
	private DataRecord[] records;
	
	public RecordHandler(int count, int rows, int total, DataRecord[] records) {
		this.setCount(count);
		this.setRows(rows);
		this.setTotal(total);
		this.setRecords(records);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public DataRecord[] getRecords() {
		return records;
	}

	public void setRecords(DataRecord[] records) {
		this.records = records;
	}

	int populateArray() {
		FileInputStream fis=null;
		DataInputStream dis=null;

		try {
			fis = new FileInputStream("Bank.dat");
			dis = new DataInputStream(fis);
			// Loop to Populate the Array.
			while (true) {
				String r[] = new String[6];
				for (int i = 0; i < 6; i++) {
					r[i] = dis.readUTF();
				}
				getRecords()[getRows()] = DataRecord.from(r);
				setRows(getRows() + 1);
			}

		} catch (Exception ex) {
			setTotal(getRows());
			if (getTotal() == 0) {
				return 0;
			} else {
				try {
					dis.close();
					fis.close();
				} catch (Exception exp) {
				}
			}
		}
		return getRows();
	}
}