import java.io.DataInputStream;
import java.io.FileInputStream;

public class RecordHandler {
	private int count;
	private int rows;
	private int total;
	private DataRecord[] records;
	private FileInputStream fis;
	private DataInputStream dis;

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

	public FileInputStream getFis() {
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}

	public DataInputStream getDis() {
		return dis;
	}

	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}
}