package co.edu.uptc.view;

import javax.swing.*;

public class JOptionMessages {

    public void successMessage() {
        JOptionPane.showMessageDialog(null, "Acción completada con éxito", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void errorMessage() {
        JOptionPane.showMessageDialog(null, "Credenciales no validas", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String requestData(String request, String MessageTitle, int icon) {
        return JOptionPane.showInputDialog(null, request, MessageTitle, icon);
    }
}
