import java.io.DataInputStream;
import java.io.FileInputStream;

public class RecordHandler {
	public int count;
	public int rows;
	public int total;
	public DataRecord[] records;
	public FileInputStream fis;
	public DataInputStream dis;

	public RecordHandler(int count, int rows, int total, DataRecord[] records) {
		this.count = count;
		this.rows = rows;
		this.total = total;
		this.records = records;
	}
}