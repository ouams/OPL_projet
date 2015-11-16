package gui;


public class SettingsPage extends gui.types.MSPanel {
    private types.Account a;

    public SettingsPage(types.Account a) {
        super("User Settings");
        this.a = a;
        initComponents();
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        curr_pass_field = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        new_pass_field = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        new_pass_field2 = new javax.swing.JPasswordField();
        confirm_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        setLayout(new java.awt.GridLayout(4 , 2 , 20 , 50));
        jLabel1.setText("Current Password");
        jLabel1.setName("curr_pass");
        add(jLabel1);
        add(curr_pass_field);
        jLabel2.setText("New Password");
        add(jLabel2);
        add(new_pass_field);
        jLabel3.setText("Repeat New Password");
        add(jLabel3);
        add(new_pass_field2);
        confirm_button.setText("Confirm");
        confirm_button.setName("confirm_button");
        confirm_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_buttonActionPerformed(evt);
            }
        });
        add(confirm_button);
        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        add(cancel_button);
    }

    private void confirm_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String curr = new java.lang.String(curr_pass_field.getPassword());
        java.lang.String newP = new java.lang.String(new_pass_field.getPassword());
        java.lang.String newP2 = new java.lang.String(new_pass_field2.getPassword());
        if (!(curr.equals(a.getPassword()))) {
            javax.swing.JOptionPane.showMessageDialog(this, "Current password given isn\'t correct.");
        } else if (!(newP.equals(newP2))) {
            javax.swing.JOptionPane.showMessageDialog(this, "The two new passwords given do not match.");
        } else if ((newP.isEmpty()) || (newP2.isEmpty())) {
            javax.swing.JOptionPane.showMessageDialog(this, "Empty passwords are not allowed.");
        } else {
            int choice = javax.swing.JOptionPane.showConfirmDialog(this, "Really reset password?");
            if (choice == (javax.swing.JOptionPane.OK_OPTION)) {
                a.setPassword(newP);
                database.AccountAccess.modifyAccount(a.getUsername(), a);
                java.lang.System.out.println(("Password changed to " + newP));
            } 
        }
    }

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).goBack();
    }

    private javax.swing.JButton cancel_button;

    private javax.swing.JButton confirm_button;

    private javax.swing.JPasswordField curr_pass_field;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JPasswordField new_pass_field;

    private javax.swing.JPasswordField new_pass_field2;
}

