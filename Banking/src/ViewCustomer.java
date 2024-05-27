import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;

import model.CustomerRecord;
import repository.CustomerRepository;

public class ViewCustomer extends JInternalFrame {

	private JPanel jpShow = new JPanel();

	private DefaultTableModel dtmCustomer;
	private JTable tbCustomer;
	private JScrollPane jspTable;

	ViewCustomer() {

		// super(Title, Resizable, Closable, Maximizable, Iconifiable)
		super("View All Account Holders", false, true, false, true);
		setSize(475, 280);

		jpShow.setLayout(null);

		tbCustomer = makeTable();
		jspTable = new JScrollPane(tbCustomer);
		jspTable.setBounds(20, 20, 425, 200);

		// Adding the Table to Panel.
		jpShow.add(jspTable);

		// Adding Panel to Window.
		getContentPane().add(jpShow);

		// In the End Showing the New Account Window.
		setVisible(true);

	}

	// Function to Create the Table and Add Data to Show.
	private JTable makeTable() {
		var r = CustomerRepository.getInstance();
		if (r.size() == 0) {
			JOptionPane.showMessageDialog(null, "Records File is Empty.\nEnter Records to Display.",
					"BankSystem - EmptyFile", JOptionPane.PLAIN_MESSAGE);
			return null;
		}
		var rowData = new String[r.size()][4];
		var rec = r.getRecords();
		int i = 0;
		for (var o : rec) {
			rowData[i][0] = o.getAccount_no();
			rowData[i][1] = o.getName();
			rowData[i][2] = o.getMonth() + ", " + o.getDay() + ", " + o.getYear();
			rowData[i][3] = o.getYear() + "";
			i++;
		}
		// String Type Array use to Give Table Column Names.
		String cols[] = { "Account No.", "Customer Name", "Opening Date", "Bank Balance" };

		dtmCustomer = new DefaultTableModel(rowData, cols);
		tbCustomer = new JTable(dtmCustomer) {
			public boolean isCellEditable(int iRow, int iCol) {
				return false; // Disable All Columns of Table.
			}
		};
		// Sizing the Columns of Table.
		(tbCustomer.getColumnModel().getColumn(0)).setPreferredWidth(180);
		(tbCustomer.getColumnModel().getColumn(1)).setPreferredWidth(275);
		(tbCustomer.getColumnModel().getColumn(2)).setPreferredWidth(275);
		(tbCustomer.getColumnModel().getColumn(3)).setPreferredWidth(200);
		tbCustomer.setRowHeight(20);
		tbCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return tbCustomer;

	}

}