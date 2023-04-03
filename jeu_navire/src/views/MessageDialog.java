package views;

import javax.swing.JOptionPane;

public class MessageDialog {
    private String message;
    private int type;

    public MessageDialog(String message, int type) {
        this.message = message;
        this.type = type;
    }

    public void showMessageDialog() {
        switch (type) {
            case JOptionPane.ERROR_MESSAGE:
                JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
                break;
            case JOptionPane.INFORMATION_MESSAGE:
                JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                break;
            case JOptionPane.WARNING_MESSAGE:
                JOptionPane.showMessageDialog(null, message, "Avertissement", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, message);
                break;
        }
    }
}
