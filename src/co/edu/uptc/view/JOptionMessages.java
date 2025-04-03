package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class JOptionMessages {
    private Component parent;

    public JOptionMessages(Component parent){
        this.parent = parent;
    }

    public void successMessage() {
        JOptionPane.showMessageDialog(parent, "Acción completada con éxito", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void errorMessage() {
        JOptionPane.showMessageDialog(parent, "Credenciales no validas", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String requestData(String request, String MessageTitle, int icon) {
        return JOptionPane.showInputDialog(parent, request, MessageTitle, icon);
    }

    public boolean confirmAction(String question) {
        int option = JOptionPane.showConfirmDialog(parent, question, "Confirmacion", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }
}
