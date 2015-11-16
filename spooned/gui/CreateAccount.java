package gui;


public class CreateAccount extends gui.types.MSPanel {
    public CreateAccount() {
        super("Account Management", gui.types.MSPanel.CANT_NAV);
        initComponents();
        existing_account_dropdown.setModel(new javax.swing.DefaultComboBoxModel(database.AccountAccess.accessAccountList()));
        if ((existing_account_dropdown.getItemCount()) == 0) {
            modify_existing_checkbox.setEnabled(false);
            existing_account_dropdown.setEnabled(false);
            delete_account_button.setEnabled(false);
            ClearFields();
            java.lang.System.out.println("ERROR NOTHING IN DROPDOWN");
        } 
        existing_account_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                existing_account_dropdown = ((javax.swing.JComboBox)(e.getSource()));
                fillFieldsFromSelection();
            }
        });
    }

    private void ClearFields() {
        first_name_field.setText("");
        last_name_field.setText("");
        id_field.setText("");
        username_field.setText("");
        password_field.setText("");
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        account_creation_header = new javax.swing.JPanel();
        first_name_field = new javax.swing.JTextField();
        last_name_field = new javax.swing.JTextField();
        account_type_dropdown = new javax.swing.JComboBox();
        username_field = new javax.swing.JTextField();
        password_generate_button = new javax.swing.JButton();
        first_name_label = new javax.swing.JLabel();
        last_name_label = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        account_type_label = new javax.swing.JLabel();
        username_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        modify_existing_checkbox = new javax.swing.JCheckBox();
        existing_account_dropdown = new javax.swing.JComboBox();
        existing_account_separator = new javax.swing.JSeparator();
        ok_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        password_field = new javax.swing.JTextField();
        id_field = new javax.swing.JFormattedTextField();
        delete_account_button = new javax.swing.JButton();
        block_account_checkbox = new javax.swing.JCheckBox();
        account_creation_header.setBorder(javax.swing.BorderFactory.createTitledBorder("Create/Modify an Account:"));
        account_creation_header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        account_creation_header.setName("");
        first_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                first_name_fieldActionPerformed(evt);
            }
        });
        account_type_dropdown.setModel(new javax.swing.DefaultComboBoxModel(new java.lang.String[]{ "System Admin" , "Administrator" , "Assistant Admin" , "Instructor" , "TA" }));
        account_type_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                account_type_dropdownActionPerformed(evt);
            }
        });
        password_generate_button.setText("Generate");
        password_generate_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_generate_buttonActionPerformed(evt);
            }
        });
        first_name_label.setText("First Name");
        last_name_label.setText("Last Name");
        id_label.setText("Employee ID");
        account_type_label.setText("Account Type");
        username_label.setText("Username");
        password_label.setText("Password");
        modify_existing_checkbox.setText("Modify Existing Account");
        modify_existing_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify_existing_checkboxActionPerformed(evt);
            }
        });
        existing_account_dropdown.setEnabled(false);
        existing_account_separator.setForeground(new java.awt.Color(0 , 0 , 0));
        ok_button.setText("OK");
        ok_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_buttonActionPerformed(evt);
            }
        });
        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        id_field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#######################"))));
        delete_account_button.setText("Delete Account");
        delete_account_button.setEnabled(false);
        delete_account_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_account_buttonActionPerformed(evt);
            }
        });
        block_account_checkbox.setText("Block Account");
        block_account_checkbox.setEnabled(false);
        javax.swing.GroupLayout account_creation_headerLayout = new javax.swing.GroupLayout(account_creation_header);
        account_creation_header.setLayout(account_creation_headerLayout);
        account_creation_headerLayout.setHorizontalGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, account_creation_headerLayout.createSequentialGroup().addContainerGap().addComponent(existing_account_separator).addContainerGap()).addGroup(account_creation_headerLayout.createSequentialGroup().addGap(85, 85, 85).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, account_creation_headerLayout.createSequentialGroup().addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(account_creation_headerLayout.createSequentialGroup().addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(account_creation_headerLayout.createSequentialGroup().addComponent(password_label).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(password_generate_button)).addGroup(account_creation_headerLayout.createSequentialGroup().addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(last_name_label).addComponent(account_type_label).addComponent(username_label).addComponent(first_name_label)).addGap(0, 0, java.lang.Short.MAX_VALUE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(account_creation_headerLayout.createSequentialGroup().addComponent(id_label).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(password_field, javax.swing.GroupLayout.Alignment.LEADING).addComponent(first_name_field, javax.swing.GroupLayout.Alignment.LEADING).addComponent(last_name_field, javax.swing.GroupLayout.Alignment.LEADING).addComponent(account_type_dropdown, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(username_field, javax.swing.GroupLayout.Alignment.LEADING).addComponent(id_field, javax.swing.GroupLayout.Alignment.LEADING))).addGroup(account_creation_headerLayout.createSequentialGroup().addGap(214, 214, 214).addComponent(ok_button, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(cancel_button)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, account_creation_headerLayout.createSequentialGroup().addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(modify_existing_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(block_account_checkbox)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(existing_account_dropdown, 0, 120, java.lang.Short.MAX_VALUE).addComponent(delete_account_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)).addGap(16, 16, 16))).addGap(18, 18, 18)));
        account_creation_headerLayout.setVerticalGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, account_creation_headerLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(modify_existing_checkbox).addComponent(existing_account_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(delete_account_button).addComponent(block_account_checkbox)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(existing_account_separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(first_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(first_name_label)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(last_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(last_name_label)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(id_label).addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(account_type_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(account_type_label)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(username_label)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(password_generate_button).addComponent(password_label).addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, java.lang.Short.MAX_VALUE).addGroup(account_creation_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(ok_button).addComponent(cancel_button)).addGap(4, 4, 4)));
        ok_button.getAccessibleContext().setAccessibleDescription("");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(account_creation_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(account_creation_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(21, java.lang.Short.MAX_VALUE)));
    }

    private void first_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void account_type_dropdownActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void password_generate_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        password_field.setText(gui.utils.GUIUtils.generatePassword());
    }

    private void modify_existing_checkboxActionPerformed(java.awt.event.ActionEvent evt) {
        if (modify_existing_checkbox.isSelected()) {
            existing_account_dropdown.setEnabled(true);
            delete_account_button.setEnabled(true);
            block_account_checkbox.setEnabled(true);
            fillFieldsFromSelection();
        } else {
            block_account_checkbox.setSelected(false);
            block_account_checkbox.setEnabled(false);
            existing_account_dropdown.setEnabled(false);
            delete_account_button.setEnabled(false);
            ClearFields();
        }
    }

    private void fillFieldsFromSelection() {
        if ((existing_account_dropdown.getSelectedIndex()) == (-1))
            java.lang.System.out.println("No valid index selected, nothing to print.");
        else {
            java.lang.String account_username = ((java.lang.String)(existing_account_dropdown.getSelectedItem()));
            types.Account fill_acct = database.AccountAccess.constructAccountObject(account_username);
            first_name_field.setText(fill_acct.getFirstName());
            last_name_field.setText(fill_acct.getLastName());
            id_field.setValue(fill_acct.getEmpID());
            account_type_dropdown.setSelectedIndex(((fill_acct.getAccountTypeAsInt()) - 1));
            username_field.setText(fill_acct.getUsername());
            password_field.setText(fill_acct.getPassword());
            block_account_checkbox.setSelected(fill_acct.isBlocked());
        }
    }

    private void ok_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String first = first_name_field.getText();
        java.lang.String last = last_name_field.getText();
        int id = java.lang.Integer.parseInt(id_field.getText());
        java.lang.String username = username_field.getText();
        java.lang.String pass = password_field.getText();
        boolean block_value = block_account_checkbox.isSelected();
        types.Account creation;
        java.lang.String account_select = account_type_dropdown.getSelectedItem().toString();
        if (account_select.equalsIgnoreCase("System Admin"))
            creation = new types.SystemAdmin(first , last , id , username , pass);
        else if (account_select.equalsIgnoreCase("Administrator"))
            creation = new types.AcademicAdmin(first , last , id , username , pass);
        else if (account_select.equalsIgnoreCase("Assistant Admin"))
            creation = new types.AssistantAdmin(first , last , id , username , pass);
        else if (account_select.equalsIgnoreCase("Instructor"))
            creation = new types.Instructor(first , last , id , username , pass);
        else if (account_select.equalsIgnoreCase("TA"))
            creation = new types.TATM(first , last , id , username , pass);
        else {
            creation = null;
            java.lang.System.out.println(("Is it Christmas right now? Because you have an" + " error message to unwrap."));
        }
        if (modify_existing_checkbox.isSelected()) {
            creation.setBlocked(block_value);
            database.AccountAccess.modifyAccount(existing_account_dropdown.getSelectedItem().toString(), creation);
            if (!block_value)
                database.AccountAccess.successfulLogin(username);
            
            java.lang.System.out.println((("Account " + (username_field.getText())) + " modified."));
        } else {
            java.lang.System.out.println((("Creating " + account_select) + " type account."));
            database.AccountAccess.createAccount(creation);
            javax.swing.JOptionPane.showMessageDialog(this, ("Account Created: " + (username_field.getText())));
        }
        setOkToNav();
        gui.utils.GUIUtils.getMasterFrame(this).goBack();
    }

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).goBack();
    }

    private void delete_account_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String account = existing_account_dropdown.getSelectedItem().toString();
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, (("Delete account \"" + (username_field.getText())) + "\"?"), "", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            database.AccountAccess.deleteAccount(account);
            ClearFields();
            existing_account_dropdown.removeAllItems();
            existing_account_dropdown.setModel(new javax.swing.DefaultComboBoxModel(database.AccountAccess.accessAccountList()));
            existing_account_dropdown.setSelectedIndex(-1);
        } 
    }

    private javax.swing.JPanel account_creation_header;

    private javax.swing.JComboBox account_type_dropdown;

    private javax.swing.JLabel account_type_label;

    private javax.swing.JCheckBox block_account_checkbox;

    private javax.swing.JButton cancel_button;

    private javax.swing.JButton delete_account_button;

    private javax.swing.JComboBox existing_account_dropdown;

    private javax.swing.JSeparator existing_account_separator;

    private javax.swing.JTextField first_name_field;

    private javax.swing.JLabel first_name_label;

    private javax.swing.JFormattedTextField id_field;

    private javax.swing.JLabel id_label;

    private javax.swing.JTextField last_name_field;

    private javax.swing.JLabel last_name_label;

    private javax.swing.JCheckBox modify_existing_checkbox;

    private javax.swing.JButton ok_button;

    private javax.swing.JTextField password_field;

    private javax.swing.JButton password_generate_button;

    private javax.swing.JLabel password_label;

    private javax.swing.JTextField username_field;

    private javax.swing.JLabel username_label;
}

