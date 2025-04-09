package co.edu.uptc.view.panels;

import co.edu.uptc.presenter.Presenter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateReportPanel extends JPanel implements ActionListener {
    private JButton generateReportButton;
    private JLabel totalIncomeLabel;
    private JLabel totalVehiclesLabel;
    private JTable salesTable;
    private JButton backButton;
    private Presenter presenter;

    public GenerateReportPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        headerPanel.setBackground(Color.LIGHT_GRAY);
        JLabel selectDateLabel = new JLabel("Seleccionar fecha:");

        generateReportButton = new JButton("Generar Reporte");
        generateReportButton.addActionListener(this);
        headerPanel.add(selectDateLabel);
        headerPanel.add(generateReportButton);
        add(headerPanel, BorderLayout.NORTH);

        JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        summaryPanel.setBackground(Color.LIGHT_GRAY);
        totalIncomeLabel = new JLabel("Total ingresos: $------");
        totalIncomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalVehiclesLabel = new JLabel("Total vehículos: 00000");
        totalVehiclesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        summaryPanel.add(totalIncomeLabel);
        summaryPanel.add(totalVehiclesLabel);
        add(summaryPanel, BorderLayout.CENTER);

        String[] columnNames = {"Nombres", "Apellidos", "Ingresos", "Vehículos ingresados"};
        Object[][] data = {};
        salesTable = new JTable(new DefaultTableModel(data, columnNames));
        salesTable.setRowHeight(24);
        salesTable.setFont(new Font("Arial", Font.PLAIN, 14));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < salesTable.getColumnCount(); i++) {
            salesTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(salesTable);
        scrollPane.setPreferredSize(new Dimension(500, 150));
        add(scrollPane, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        backButton = new JButton("Atrás");
        backButton.addActionListener(this);
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.WEST);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == generateReportButton) {
            Object[][] data = presenter.getReceptionistReportTable();
            DefaultTableModel model = new DefaultTableModel(data, new String[]{
                    "Nombres", "Apellidos", "Ingresos", "Vehículos ingresados"
            });
            salesTable.setModel(model);

            if (data.length > 0) {
                totalIncomeLabel.setText("Total ingresos: " + data[0][2]);
                totalVehiclesLabel.setText("Total vehículos: " + data[0][3]);
            } else {
                totalIncomeLabel.setText("Total ingresos: $0");
                totalVehiclesLabel.setText("Total vehículos: 0");
            }
        } else if (source == backButton) {
            presenter.logOutToAdminMenu();
        }    }
}

