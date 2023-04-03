package views;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MessageDialog {
    private String message;
    private int type;

    public MessageDialog(String message, int type) {
        // Charger une police qui prend en charge l'affichage des emojis
        Font font = new Font("Segoe UI Emoji", Font.PLAIN, 12);

        // Définir la police de Swing pour prendre en charge l'affichage des emojis
        UIManager.put("OptionPane.messageFont", font);

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
        loadDefaultFont();
    }

    public int showConfirmationMessageDialog(String okButtonLabel, String cancelButtonLabel) {
        int res = JOptionPane.showOptionDialog(null, message, "",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[] { okButtonLabel, cancelButtonLabel }, JOptionPane.OK_OPTION);

        loadDefaultFont();

        return res;
    }

    public void loadDefaultFont() {
        // Obtenir le nom de la classe de l'apparence système par défaut
        String defaultLAF = UIManager.getSystemLookAndFeelClassName();

        // Définir l'apparence par défaut de Swing
        try {
            UIManager.setLookAndFeel(defaultLAF);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Restaurer la police par défaut de Swing
        UIManager.put("OptionPane.messageFont", new Font(Font.DIALOG, Font.PLAIN, 12));
    }
}
