import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIMain extends JFrame implements ActionListener {
    /* 
     * Fields
     */
    // GUI Components
    private JLabel id_Label = new JLabel("   ID:");
    private JLabel name_Label = new JLabel("   Name:");
    private JLabel gpa_Label = new JLabel("   Major:");
    private JLabel select_Label = new JLabel("   Choose Selection:");
    private JButton process_button = new JButton("   Process Request");
    private JTextField id_TextField = new JTextField(50);
    private JTextField name_TextField = new JTextField(50);
    private JTextField major_TextField = new JTextField(50);

    // Map and JComboBox for info storage
    private Map<String, Student> map = new HashMap<String, Student>();
    private JComboBox<String> select = new JComboBox<>(new String[] { "Insert", "Delete", "Find", "Update" });

    /* 
     * Constructor
     */
    public GUIMain() {
	// Window setup
	super("Student Data Base");
	setSize(400, 175);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new GridLayout(5, 2));

	// Add components to Frame
	add(id_Label);
	add(id_TextField);
	add(name_Label);
	add(name_TextField);
	add(gpa_Label);
	add(major_TextField);
	add(select_Label);
	add(select);
	add(process_button);

	setVisible(true);

	process_button.addActionListener(this);
    }

    /*
     * Action Listener
     */
    public void actionPerformed(ActionEvent e) {
	String actPerformed = select.getSelectedItem().toString();

	try {
	    if (actPerformed.compareTo("Insert") == 0) {
		String id = id_TextField.getText();
		String name = name_TextField.getText();
		String major = major_TextField.getText();

		map.put(id, new Student(name, major));
		JOptionPane.showMessageDialog(null,
			"New Student Added\n" + "ID: " + id + "\n" + "Name: " + name + "\n" + "Major: " + major,
			"Successful", JOptionPane.INFORMATION_MESSAGE);
	    }

	    else {
		if (actPerformed.compareTo("Find") == 0) {
		    String id = id_TextField.getText();
		    Student student = map.get(id);

		    if (student != null) {
			name_TextField.setText(student.getName());
			major_TextField.setText(String.valueOf(student.getMajor()));
			JOptionPane.showMessageDialog(null, student.toString(), "", JOptionPane.INFORMATION_MESSAGE);
		    }

		    else {
			JOptionPane.showMessageDialog(null, 
				"Does not contain ID: " + id, "ID NOTICE", JOptionPane.INFORMATION_MESSAGE);
		    }

		}

		else {

		    if (actPerformed.compareTo("Delete") == 0) {
			String id = id_TextField.getText();

			if (map.remove(id) != null) {
			    JOptionPane.showMessageDialog(null, 
				    "Deleted: " + id, "DELETION NOTICE", JOptionPane.INFORMATION_MESSAGE);
			}

			else {
			    JOptionPane.showMessageDialog(null, 
				    "Database does not contain ID: " + id, "COULD NOT FIND",
				    JOptionPane.INFORMATION_MESSAGE);
			}

		    }

		    else if (actPerformed.compareTo("Update") == 0) {
			String[] Grade = { "A", "B", "C", "D", "F" };
			String gradeS = (String) JOptionPane.showInputDialog(null, "Grade:", "",
				JOptionPane.QUESTION_MESSAGE, null, Grade, Grade[0]);

			int grade = 0;

			if (gradeS.equals("A")) {
			    grade = 4;
			}

			else if (gradeS.equals("B")) {
			    grade = 3;
			}

			else if (gradeS.equals("C")) {
			    grade = 2;
			}

			else if (gradeS.equals("D")) {
			    grade = 1;
			}

			else {
			    grade = 0;
			}

			String[] Credits = { "2", "3", "4", "5", "6" };
			int credits = Integer.parseInt((String) JOptionPane.showInputDialog(null, 
				"Credits:", "", JOptionPane.QUESTION_MESSAGE, null, Credits, Credits[0]));

			String id = id_TextField.getText();

			if (map.containsKey(id)) {
			    Student student = map.get(id);
			    student.addCourse(grade, credits);
			    map.put(id, student);
			    student.addCourse(grade, credits);
			    JOptionPane.showMessageDialog(null, 
				    student.toString(), "", JOptionPane.INFORMATION_MESSAGE);
			}
		    } // End of else if
		} // End of 2nd else statement

	    } // End of 1st else statement

	} catch (Exception ex) {
	    JOptionPane.showMessageDialog(null, 
		    "Error while " + actPerformed + " : " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	    ex.printStackTrace();
	}
    }

    /*
     * MAIN METHOD
     */
    public static void main(String[] args) {
	GUIMain start = new GUIMain();
    }

}
