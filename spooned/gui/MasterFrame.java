package gui;


public class MasterFrame extends javax.swing.JFrame {
    private enum Move {
AHEAD, BACK;    }

    private types.Account a;

    private gui.LoginScreen login_screen;

    private javax.swing.JPanel top_panel;

    private gui.types.MSPanel curr_page;

    private javax.swing.JButton logout_button;

    private javax.swing.JButton back_button;

    private javax.swing.JButton settings_button;

    private javax.swing.JLabel role_label;

    private java.util.LinkedList<gui.types.MSPanel> pages;

    private java.awt.GridBagConstraints c = new java.awt.GridBagConstraints();

    public MasterFrame(types.Account a ,gui.LoginScreen ls) {
        this.a = a;
        login_screen = ls;
        top_panel = new javax.swing.JPanel();
        logout_button = new javax.swing.JButton("Logout");
        back_button = new javax.swing.JButton("Back");
        settings_button = new javax.swing.JButton("Settings");
        role_label = new javax.swing.JLabel();
        pages = new java.util.LinkedList<gui.types.MSPanel>();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 700);
        back_button.setEnabled(false);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("markshark-1x.png")).getImage());
        if ((a.getAccountType()) == (types.Account.Type.ACADEMICADMIN)) {
            role_label.setText("Role: Academic Administrator");
            curr_page = new gui.LandingPageAdmin(((types.AcademicAdmin)(a)));
        } else if ((a.getAccountType()) == (types.Account.Type.ASSISTANTADMIN)) {
            role_label.setText("Role: Assistant Academic Administrator");
            curr_page = new gui.LandingPageAssistAdmin(((types.AssistantAdmin)(a)));
        } else if ((a.getAccountType()) == (types.Account.Type.INSTRUCTOR)) {
            role_label.setText("Role: Instructor");
            curr_page = new gui.LandingPageInstructor(((types.Instructor)(a)));
        } else if ((a.getAccountType()) == (types.Account.Type.SYSTEMADMIN)) {
            role_label.setText("Role: System Administrator");
            curr_page = new gui.LandingPageSysAdmin(((types.SystemAdmin)(a)));
        } else if ((a.getAccountType()) == (types.Account.Type.TATMMARKER)) {
            role_label.setText("Role: TA/TM");
            curr_page = new gui.LandingPageTA(((types.TATM)(a)));
        } else {
            java.lang.System.out.println("Unknown account type!! Everyone overboard!! Eject!!");
            curr_page = null;
        }
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                goBackAction(e);
            }
        });
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                logoutAction(e);
            }
        });
        settings_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                settingsAction(e);
            }
        });
        top_panel.setLayout(new java.awt.GridBagLayout());
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        c.anchor = java.awt.GridBagConstraints.NORTHEAST;
        top_panel.add(role_label, c);
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1.0;
        c.weightx = 0;
        c.anchor = java.awt.GridBagConstraints.WEST;
        top_panel.add(back_button, c);
        c.gridx = 1;
        c.weighty = 0;
        c.weightx = 0;
        c.anchor = java.awt.GridBagConstraints.CENTER;
        top_panel.add(settings_button, c);
        c.gridx = 2;
        c.gridy = 1;
        c.anchor = java.awt.GridBagConstraints.EAST;
        c.weightx = 1.0;
        c.weighty = 1.0;
        top_panel.add(logout_button, c);
        setLayout(new java.awt.GridBagLayout());
        c = new java.awt.GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 50;
        c.weightx = 1.0;
        add(top_panel, c);
        c.gridy = 1;
        c.weighty = 1.0;
        c.gridwidth = 10;
        add(curr_page, c);
        setTitle(("MarkShark Grading System - " + (curr_page.getPanelTitle())));
        setLocationRelativeTo(null);
        pack();
    }

    public void run() {
        setVisible(true);
        gui.utils.GUIUtils.centerFrame(this);
    }

    private void pleaseMove(gui.types.MSPanel p, Move movement) {
        if (!(curr_page.okToNav())) {
            int answer = javax.swing.JOptionPane.showConfirmDialog(this, "You may have some unsaved changes. Are you sure you want to navigate away?", "Navigate away?", javax.swing.JOptionPane.YES_NO_OPTION);
            if (answer == (javax.swing.JOptionPane.YES_OPTION)) {
                curr_page.setOkToNav();
                pleaseMove(p, movement);
            } 
        } else {
            curr_page.setVisible(false);
            remove(curr_page);
            if (movement == (Move.AHEAD)) {
                pages.push(curr_page);
                curr_page = p;
            } else if (movement == (Move.BACK)) {
                java.lang.System.out.println("Going back.");
                curr_page = pages.pop();
            } else {
                java.lang.System.out.println("You should never see this.");
            }
            showPage(curr_page);
        }
    }

    public void movePage(gui.types.MSPanel p) {
        if (pages.isEmpty())
            back_button.setEnabled(true);
        
        pleaseMove(p, Move.AHEAD);
    }

    private void showPage(gui.types.MSPanel p) {
        add(p, c);
        p.setVisible(true);
        setTitle(("MarkShark Grading System - " + (p.getPanelTitle())));
        pack();
        java.lang.System.out.println(("Moving to: " + (p.getPanelTitle())));
    }

    public void goBack() {
        goBackAction(null);
    }

    private void goBackAction(java.awt.event.ActionEvent e) {
        pleaseMove(null, Move.BACK);
        if (pages.isEmpty())
            back_button.setEnabled(false);
        
        if (!(settings_button.isEnabled()))
            settings_button.setEnabled(true);
        
    }

    public void settingsAction(java.awt.event.ActionEvent e) {
        movePage(new gui.SettingsPage(a));
        settings_button.setEnabled(false);
    }

    private void logoutAction(java.awt.event.ActionEvent e) {
        java.lang.System.out.println("Logging out...");
        setVisible(false);
        login_screen.clearFields();
        login_screen.setVisible(true);
    }
}

