import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoListGUI {
    private DefaultListModel<String> model;
    private JList<String> taskList;
    
    public ToDoListGUI() {
        JFrame frame = new JFrame("To-Do List");
        model = new DefaultListModel<>();
        taskList = new JList<>(model);
        
        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        
        addButton.addActionListener(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                model.addElement(task);
                taskField.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) model.remove(selectedIndex);
        });

        JPanel panel = new JPanel();
        panel.add(taskField);
        panel.add(addButton);
        panel.add(removeButton);

        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListGUI::new);
    }
}
