package gui;


public class DatabaseManagement extends gui.types.MSPanel {
    private types.SystemAdmin a;

    private java.util.ArrayList<java.lang.String> filepath_temp;

    public DatabaseManagement(types.SystemAdmin a) {
        super("System Administrator");
        initComponents();
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        tasks_panel = new javax.swing.JPanel();
        backup_button = new javax.swing.JButton();
        restore_button = new javax.swing.JButton();
        backup_separator = new javax.swing.JSeparator();
        backup_path_field = new javax.swing.JTextField();
        restore_db_label = new javax.swing.JLabel();
        change_backuppath_button = new javax.swing.JButton();
        backup_db_label = new javax.swing.JLabel();
        restore_db_path_field = new javax.swing.JTextField();
        change_restorepath_button = new javax.swing.JButton();
        tasks_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Database Management"));
        backup_button.setText("Backup");
        backup_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backup_buttonActionPerformed(evt);
            }
        });
        restore_button.setText("Restore ");
        restore_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restore_buttonActionPerformed(evt);
            }
        });
        backup_path_field.setText("C://");
        restore_db_label.setText("Path:");
        change_backuppath_button.setText("Change");
        change_backuppath_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_backuppath_buttonActionPerformed(evt);
            }
        });
        backup_db_label.setText("Path:");
        restore_db_path_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restore_db_path_fieldActionPerformed(evt);
            }
        });
        change_restorepath_button.setText("Change");
        change_restorepath_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_restorepath_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout tasks_panelLayout = new javax.swing.GroupLayout(tasks_panel);
        tasks_panel.setLayout(tasks_panelLayout);
        tasks_panelLayout.setHorizontalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(25, 25, 25).addComponent(backup_db_label).addGap(18, 18, 18).addComponent(backup_path_field, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(change_backuppath_button)).addGroup(tasks_panelLayout.createSequentialGroup().addGap(192, 192, 192).addComponent(restore_button, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(0, 39, java.lang.Short.MAX_VALUE)).addGroup(tasks_panelLayout.createSequentialGroup().addGap(28, 28, 28).addComponent(restore_db_label).addGap(18, 18, 18).addComponent(restore_db_path_field).addGap(18, 18, 18).addComponent(change_restorepath_button).addGap(39, 39, 39)).addGroup(tasks_panelLayout.createSequentialGroup().addContainerGap().addComponent(backup_separator))).addContainerGap()).addGroup(tasks_panelLayout.createSequentialGroup().addGap(189, 189, 189).addComponent(backup_button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)));
        tasks_panelLayout.setVerticalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tasks_panelLayout.createSequentialGroup().addGap(32, 32, 32).addGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(backup_path_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(change_backuppath_button).addComponent(backup_db_label)).addGap(18, 18, 18).addComponent(backup_button).addGap(18, 18, 18).addComponent(backup_separator, javax.swing.GroupLayout.DEFAULT_SIZE, 25, java.lang.Short.MAX_VALUE).addGap(56, 56, 56).addGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(restore_db_label).addComponent(restore_db_path_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(change_restorepath_button)).addGap(18, 18, 18).addComponent(restore_button).addGap(9, 9, 9)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
    }

    private void change_backuppath_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        java.lang.String path_container;
        if ((chooser.showOpenDialog(null)) == (javax.swing.JFileChooser.APPROVE_OPTION)) {
            java.lang.System.out.println(("getCurrentDirectory(): " + (chooser.getCurrentDirectory())));
            path_container = chooser.getSelectedFile().toString();
            backup_path_field.setText(path_container);
            filepath_temp = types.TextAnalyzer.getInput(path_container);
            java.lang.System.out.println(("getSelectedFile() : " + (chooser.getSelectedFile())));
        } else {
            java.lang.System.out.println("No Selection");
            filepath_temp = null;
        }
    }

    private void change_restorepath_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        java.lang.String path_container;
        if ((chooser.showOpenDialog(null)) == (javax.swing.JFileChooser.APPROVE_OPTION)) {
            java.lang.System.out.println(("getCurrentDirectory(): " + (chooser.getCurrentDirectory())));
            path_container = chooser.getSelectedFile().toString();
            restore_db_path_field.setText(path_container);
            filepath_temp = types.TextAnalyzer.getInput(path_container);
            java.lang.System.out.println(("getSelectedFile() : " + (chooser.getSelectedFile())));
        } else {
            java.lang.System.out.println("No Selection");
            filepath_temp = null;
        }
    }

    private void backup_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        database.Dbaccess.backupdatabase(backup_path_field.getText());
        javax.swing.JOptionPane.showMessageDialog(this, "Backup successfully made!");
    }

    private void restore_db_path_fieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void restore_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        database.Dbaccess.restoredatabase(restore_db_path_field.getText());
        javax.swing.JOptionPane.showMessageDialog(this, "Restore successfully made!");
    }

    private javax.swing.JButton backup_button;

    private javax.swing.JLabel backup_db_label;

    private javax.swing.JTextField backup_path_field;

    private javax.swing.JSeparator backup_separator;

    private javax.swing.JButton change_backuppath_button;

    private javax.swing.JButton change_restorepath_button;

    private javax.swing.JButton restore_button;

    private javax.swing.JLabel restore_db_label;

    private javax.swing.JTextField restore_db_path_field;

    private javax.swing.JPanel tasks_panel;
}

