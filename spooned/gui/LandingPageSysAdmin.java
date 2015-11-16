package gui;


public class LandingPageSysAdmin extends gui.types.MSPanel {
    private types.SystemAdmin a;

    public LandingPageSysAdmin(types.SystemAdmin a) {
        super("System Administrator");
        this.a = a;
        initComponents();
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        tasks_panel = new javax.swing.JPanel();
        manage_database_button = new javax.swing.JButton();
        manage_accounts_button = new javax.swing.JButton();
        manage_log_button = new javax.swing.JButton();
        tasks_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tasks"));
        manage_database_button.setText("Manage Database");
        manage_database_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_database_buttonActionPerformed(evt);
            }
        });
        manage_accounts_button.setText("Manage Accounts");
        manage_accounts_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_accounts_buttonActionPerformed(evt);
            }
        });
        manage_log_button.setText("Manage Logs");
        manage_log_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_log_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout tasks_panelLayout = new javax.swing.GroupLayout(tasks_panel);
        tasks_panel.setLayout(tasks_panelLayout);
        tasks_panelLayout.setHorizontalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(146, 146, 146).addGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(manage_accounts_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(manage_log_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(manage_database_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)).addContainerGap(153, java.lang.Short.MAX_VALUE)));
        tasks_panelLayout.setVerticalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(56, 56, 56).addComponent(manage_database_button).addGap(34, 34, 34).addComponent(manage_accounts_button).addGap(32, 32, 32).addComponent(manage_log_button).addContainerGap(71, java.lang.Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
    }

    private void manage_database_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.DatabaseManagement(a));
    }

    private void manage_accounts_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.CreateAccount());
    }

    private void manage_log_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.LogManagement());
    }

    private javax.swing.JButton manage_accounts_button;

    private javax.swing.JButton manage_database_button;

    private javax.swing.JButton manage_log_button;

    private javax.swing.JPanel tasks_panel;
}

