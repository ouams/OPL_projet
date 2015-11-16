package gui;


public class MarkSharkGUI {
    private gui.LoginScreen login;

    public MarkSharkGUI() {
        login = new gui.LoginScreen();
    }

    public void startGUI() {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (java.lang.ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui.LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (java.lang.InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (java.lang.IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        login.setVisible(true);
    }
}

