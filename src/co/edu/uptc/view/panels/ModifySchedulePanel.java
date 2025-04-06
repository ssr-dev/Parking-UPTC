package co.edu.uptc.view.panels;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ModifySchedulePanel extends JPanel {
    private JComboBox<String> dayComboBox;
    private JTextField openTimeField, closeTimeField;
    private JButton modifyButton, saveButton, backButton;
    private JTable scheduleTable;

    public ModifySchedulePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel title = new JLabel("Modificar Horario", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(title, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);


        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Día:"), gbc);

        gbc.gridx = 0;
        gbc.gridy=1;
        dayComboBox = new JComboBox<>(new String[]{
                "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo", "Festivos"
        });
        formPanel.add(dayComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Hora de apertura:"), gbc);

        gbc.gridx = 2;
        gbc.gridy=0;
        openTimeField = new JTextField(10);
        formPanel.add(openTimeField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Hora de cierre:"), gbc);

        gbc.gridx = 2;
        gbc.gridy=1;
        closeTimeField = new JTextField(10);
        formPanel.add(closeTimeField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        modifyButton = new JButton("Modificar");
        formPanel.add(modifyButton, gbc);

        mainPanel.add(formPanel, BorderLayout.NORTH);

    
        String[] columnNames = {"Días", "Hora de apertura", "Hora de cierre"};
        String[][] data = {{},
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        scheduleTable = new JTable(model);
        scheduleTable.setRowHeight(24);
        scheduleTable.setFont(new Font("Arial", Font.PLAIN, 14));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < scheduleTable.getColumnCount(); i++) {
            scheduleTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        scrollPane.setPreferredSize(new Dimension(450, 180));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        backButton = new JButton("Atrás");
        saveButton = new JButton("Guardar cambios");

        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(saveButton, BorderLayout.EAST);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
