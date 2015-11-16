package gui;


public class ActivityCreation extends gui.types.MSPanel {
    private java.lang.String courseid;

    private java.lang.String actName;

    private java.util.ArrayList<java.lang.String> filepath_temp;

    java.lang.String[] columnNames = new java.lang.String[]{ "Description" , "Max Grade" };

    java.lang.Object[][] data = new java.lang.Object[1][2];

    public ActivityCreation(java.lang.String courseid) {
        super("Activity Modification", gui.types.MSPanel.CANT_NAV);
        this.courseid = courseid;
        initComponents();
        activity_test_in_button.setEnabled(false);
        activity_test_in_field.setEnabled(false);
        activity_test_in_field.setText("");
        activity_test_out_button.setEnabled(false);
        activity_test_out_field.setEnabled(false);
        activity_test_out_field.setText("");
        activity_test_number_field.setEnabled(false);
        activity_test_number_field.setText("0");
    }

    public ActivityCreation(final java.lang.String courseID ,final types.Activity act) {
        super("Activity Modification");
        this.courseid = courseID;
        this.actName = act.getName();
        initComponents();
        activity_name_field.setText(act.getName());
        activity_desc_field.setText(act.getActivityDesc());
        activity_lang_field.setText(act.getLanguage());
        activity_student_submissionpath_field.setText(act.getStudentSubPath());
        activity_solution_field.setText(act.getSolnPath());
        activity_due_date_1_field.setText(act.getDueDate());
        generate_csv.setEnabled(true);
        if (act.isGroup())
            activity_group_checkbox.doClick();
        else
            activity_individual_checkbox.doClick();
        
        if (act.isProgramming()) {
            activity_type_combo.setSelectedIndex(1);
            activity_test_in_field.setText(database.CourseAccess.accessTestIn(courseID, act.getName()));
            activity_test_out_field.setText(database.CourseAccess.accessTestOut(courseID, act.getName()));
            activity_test_number_field.setText(java.lang.Integer.toString(act.getNumOfTests()));
        } else
            activity_type_combo.setSelectedIndex(0);
        
        for (java.awt.event.ActionListener actLis : activity_submit_button.getActionListeners())
            activity_submit_button.removeActionListener(actLis);
        activity_submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_submitModify_buttonActionPerformed(evt, courseID, act.getName());
            }
        });
        java.lang.Object[][] temp = database.CourseAccess.accessRubricItems(courseID, act.getName());
        if ((temp.length) != 0) {
            data = temp;
            rubric_table.setModel(new javax.swing.table.DefaultTableModel(data , columnNames));
        } 
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        individual_button_group = new javax.swing.ButtonGroup();
        create_activity_pane = new javax.swing.JTabbedPane();
        create_activity_tab = new javax.swing.JPanel();
        activity_name_label = new javax.swing.JLabel();
        activity_type_label = new javax.swing.JLabel();
        activity_desc_label = new javax.swing.JLabel();
        activity_lang_label = new javax.swing.JLabel();
        activity_due_date_1_label = new javax.swing.JLabel();
        activity_name_field = new javax.swing.JTextField();
        activity_type_combo = new javax.swing.JComboBox();
        activity_desc_field = new javax.swing.JTextField();
        activity_lang_field = new javax.swing.JTextField();
        activity_due_date_1_time = new javax.swing.JTextField();
        activity_due_date_1_field = new javax.swing.JFormattedTextField();
        activity_individual_checkbox = new javax.swing.JRadioButton();
        activity_group_checkbox = new javax.swing.JRadioButton();
        additional_due_date_button = new javax.swing.JButton();
        activity_solution_button = new javax.swing.JButton();
        activity_test_in_button = new javax.swing.JButton();
        activity_test_in_field = new javax.swing.JTextField();
        activity_test_out_button = new javax.swing.JButton();
        activity_test_out_field = new javax.swing.JTextField();
        activity_submit_button = new javax.swing.JButton();
        activity_solution_field = new javax.swing.JTextField();
        activity_testcomment_label = new javax.swing.JLabel();
        activity_test_number_label = new javax.swing.JLabel();
        activity_test_number_field = new javax.swing.JTextField();
        activity_student_submissionpath_button = new javax.swing.JButton();
        activity_student_submissionpath_field = new javax.swing.JTextField();
        activity_reset_button = new javax.swing.JButton();
        activity_rubric_tab = new javax.swing.JPanel();
        rubric_additional_row_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        rubric_table = new javax.swing.JTable();
        rubric_submit_button = new javax.swing.JButton();
        Edit_row_button = new javax.swing.JButton();
        delete_row_button = new javax.swing.JButton();
        generate_csv = new javax.swing.JButton();
        activity_name_label.setText("Activity Name");
        activity_type_label.setText("Type");
        activity_desc_label.setText("Description");
        activity_lang_label.setText("Language");
        activity_due_date_1_label.setText("Due Date 1");
        activity_due_date_1_field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        activity_due_date_1_field.setText("yyyy-MM-dd");
        java.lang.Object[] types = new java.lang.Object[]{ "Essay/Problem Set" , "Programming" };
        activity_type_combo.setModel(new javax.swing.DefaultComboBoxModel(types));
        activity_type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_type_comboActionPerformed(evt);
            }
        });
        activity_due_date_1_time.setText("23:59");
        individual_button_group.add(activity_individual_checkbox);
        activity_individual_checkbox.setText("Individual");
        individual_button_group.add(activity_group_checkbox);
        activity_group_checkbox.setText("Group");
        additional_due_date_button.setText("Additional Due Date");
        additional_due_date_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additional_due_date_buttonActionPerformed(evt);
            }
        });
        activity_solution_button.setText("Attach Solution");
        activity_solution_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_solution_buttonActionPerformed(evt);
            }
        });
        activity_test_in_button.setText("Test Input**");
        activity_test_in_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_test_in_buttonActionPerformed(evt);
            }
        });
        activity_test_in_field.setText("File Location...");
        activity_test_out_button.setText("Test Output**");
        activity_test_out_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_test_out_buttonActionPerformed(evt);
            }
        });
        activity_test_out_field.setText("File Location...");
        activity_submit_button.setText("Submit");
        activity_submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_submit_buttonActionPerformed(evt);
            }
        });
        activity_solution_field.setText("File Location...");
        activity_solution_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_solution_fieldActionPerformed(evt);
            }
        });
        activity_testcomment_label.setText("** Leave empty if Activity Type is not Programming!");
        activity_testcomment_label.setToolTipText("");
        activity_test_number_label.setText("Number of Programming Tests **");
        activity_test_number_field.setText("0");
        activity_test_number_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_test_number_fieldActionPerformed(evt);
            }
        });
        activity_student_submissionpath_button.setText("Path to Student Submission");
        activity_student_submissionpath_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_student_submissionpath_buttonActionPerformed(evt);
            }
        });
        activity_student_submissionpath_field.setText("File Location...");
        activity_reset_button.setText("Reset");
        activity_reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_reset_buttonActionPerformed(evt);
            }
        });
        generate_csv.setText("Generate CSV");
        generate_csv.setEnabled(false);
        generate_csv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_csvActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout create_activity_tabLayout = new javax.swing.GroupLayout(create_activity_tab);
        create_activity_tab.setLayout(create_activity_tabLayout);
        create_activity_tabLayout.setHorizontalGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(create_activity_tabLayout.createSequentialGroup().addContainerGap().addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, create_activity_tabLayout.createSequentialGroup().addComponent(activity_submit_button).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(activity_reset_button)).addGroup(create_activity_tabLayout.createSequentialGroup().addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(create_activity_tabLayout.createSequentialGroup().addComponent(activity_individual_checkbox).addGap(10, 10, 10).addComponent(activity_group_checkbox)).addGroup(create_activity_tabLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(create_activity_tabLayout.createSequentialGroup().addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(activity_name_label).addComponent(activity_type_label).addComponent(activity_desc_label).addComponent(activity_lang_label)).addGap(50, 50, 50).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(activity_lang_field, javax.swing.GroupLayout.DEFAULT_SIZE, 290, java.lang.Short.MAX_VALUE).addComponent(activity_desc_field).addComponent(activity_type_combo).addComponent(activity_name_field))).addGroup(create_activity_tabLayout.createSequentialGroup().addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(javax.swing.GroupLayout.Alignment.LEADING, create_activity_tabLayout.createSequentialGroup().addComponent(activity_test_number_label).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(activity_test_number_field)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, create_activity_tabLayout.createSequentialGroup().addComponent(activity_due_date_1_label).addGap(12, 12, 12).addComponent(activity_due_date_1_field, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(18, 18, 18).addComponent(activity_due_date_1_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(additional_due_date_button)))).addGroup(create_activity_tabLayout.createSequentialGroup().addComponent(activity_student_submissionpath_button).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(activity_student_submissionpath_field)).addGroup(create_activity_tabLayout.createSequentialGroup().addComponent(activity_solution_button).addGap(18, 18, 18).addComponent(activity_solution_field)).addComponent(activity_testcomment_label).addGroup(create_activity_tabLayout.createSequentialGroup().addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(activity_test_in_button, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(activity_test_out_button, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(activity_test_out_field).addComponent(activity_test_in_field)))).addGap(0, 80, java.lang.Short.MAX_VALUE))).addContainerGap()).addComponent(generate_csv));
        create_activity_tabLayout.setVerticalGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(create_activity_tabLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_name_label).addComponent(activity_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_type_label).addComponent(activity_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_desc_label).addComponent(activity_desc_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_lang_label).addComponent(activity_lang_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_individual_checkbox).addComponent(activity_group_checkbox)).addGap(8, 8, 8).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_due_date_1_label).addComponent(activity_due_date_1_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(activity_due_date_1_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(additional_due_date_button)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_test_number_label, javax.swing.GroupLayout.DEFAULT_SIZE, 42, java.lang.Short.MAX_VALUE).addComponent(activity_test_number_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_test_in_button).addComponent(activity_test_in_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_test_out_button).addComponent(activity_test_out_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addComponent(activity_testcomment_label).addGap(18, 18, 18).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_student_submissionpath_button).addComponent(activity_student_submissionpath_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_solution_button).addComponent(activity_solution_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addComponent(generate_csv).addGap(18, 18, 18).addGroup(create_activity_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_reset_button).addComponent(activity_submit_button)).addGap(86, 86, 86)));
        create_activity_pane.addTab("Activity", create_activity_tab);
        rubric_additional_row_button.setText("Add Row");
        rubric_additional_row_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rubric_additional_row_buttonActionPerformed(evt);
            }
        });
        rubric_table.setModel(new javax.swing.table.DefaultTableModel(new java.lang.Object[][]{ new java.lang.Object[]{ null , null } }, new java.lang.String[]{ "Description" , "Max Grade" }) {
            java.lang.Class[] types = new java.lang.Class[]{ java.lang.String.class , java.lang.Integer.class };

            public java.lang.Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(rubric_table);
        rubric_submit_button.setText("Submit");
        rubric_submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rubric_submit_buttonActionPerformed(evt, courseid, activity_name_field.getText());
            }
        });
        Edit_row_button.setText("Edit Row");
        Edit_row_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_row_buttonActionPerformed(evt);
            }
        });
        delete_row_button.setText("Delete row");
        delete_row_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_row_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout activity_rubric_tabLayout = new javax.swing.GroupLayout(activity_rubric_tab);
        activity_rubric_tab.setLayout(activity_rubric_tabLayout);
        activity_rubric_tabLayout.setHorizontalGroup(activity_rubric_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(activity_rubric_tabLayout.createSequentialGroup().addContainerGap().addGroup(activity_rubric_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, activity_rubric_tabLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(rubric_submit_button)).addGroup(activity_rubric_tabLayout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 78, java.lang.Short.MAX_VALUE))).addContainerGap()).addGroup(activity_rubric_tabLayout.createSequentialGroup().addGap(0, 0, java.lang.Short.MAX_VALUE).addComponent(delete_row_button).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(Edit_row_button).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(rubric_additional_row_button).addGap(75, 75, 75)));
        activity_rubric_tabLayout.setVerticalGroup(activity_rubric_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(activity_rubric_tabLayout.createSequentialGroup().addGap(25, 25, 25).addGroup(activity_rubric_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(rubric_additional_row_button).addComponent(Edit_row_button).addComponent(delete_row_button)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, java.lang.Short.MAX_VALUE).addComponent(rubric_submit_button).addContainerGap()));
        create_activity_pane.addTab("Rubric", activity_rubric_tab);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(create_activity_pane));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(create_activity_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 11, java.lang.Short.MAX_VALUE)));
        create_activity_pane.getAccessibleContext().setAccessibleName("create_activity_pane");
    }

    private void activity_solution_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        java.lang.String path_container;
        if ((chooser.showOpenDialog(null)) == (javax.swing.JFileChooser.APPROVE_OPTION)) {
            java.lang.System.out.println(("getCurrentDirectory(): " + (chooser.getCurrentDirectory())));
            path_container = chooser.getSelectedFile().toString();
            activity_solution_field.setText(path_container);
            filepath_temp = types.TextAnalyzer.getInput(path_container);
            java.lang.System.out.println(("getSelectedFile() : " + (chooser.getSelectedFile())));
        } else {
            java.lang.System.out.println("No Selection");
            filepath_temp = null;
        }
    }

    private void activity_test_in_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        java.lang.String path_container;
        if ((chooser.showOpenDialog(null)) == (javax.swing.JFileChooser.APPROVE_OPTION)) {
            java.lang.System.out.println(("getCurrentDirectory(): " + (chooser.getCurrentDirectory())));
            path_container = chooser.getSelectedFile().toString();
            activity_test_in_field.setText(path_container);
            filepath_temp = types.TextAnalyzer.getInput(path_container);
            java.lang.System.out.println(("getSelectedFile() : " + (chooser.getSelectedFile())));
        } else {
            java.lang.System.out.println("No Selection");
            filepath_temp = null;
        }
    }

    private void activity_solution_fieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void activity_type_comboActionPerformed(java.awt.event.ActionEvent evt) {
        if (activity_type_combo.getSelectedItem().toString().equalsIgnoreCase("Essay/Problem Set")) {
            activity_test_in_button.setEnabled(false);
            activity_test_in_field.setEnabled(false);
            activity_test_in_field.setText("");
            activity_test_out_button.setEnabled(false);
            activity_test_out_field.setEnabled(false);
            activity_test_out_field.setText("");
            activity_test_number_field.setEnabled(false);
            activity_test_number_field.setText("0");
        } else {
            activity_test_in_button.setEnabled(true);
            activity_test_in_field.setEnabled(true);
            activity_test_out_button.setEnabled(true);
            activity_test_out_field.setEnabled(true);
            activity_test_number_field.setEnabled(true);
        }
    }

    private void rubric_additional_row_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if ((data[0][1]) != null) {
            java.lang.Object[][] temp = new java.lang.Object[(data.length) + 1][2];
            for (int i = 0 ; i < (data.length) ; i++) {
                for (int j = 0 ; j < 2 ; j++) {
                    temp[i][j] = data[i][j];
                }
            }
            temp[data.length][0] = javax.swing.JOptionPane.showInputDialog("Enter Rubric Description");
            temp[data.length][1] = javax.swing.JOptionPane.showInputDialog("Enter Max Grade");
            data = temp;
            rubric_table.setModel(new javax.swing.table.DefaultTableModel(data , columnNames));
        } else {
            java.lang.Object[][] temp = new java.lang.Object[1][2];
            temp[0][0] = javax.swing.JOptionPane.showInputDialog("Enter Rubric Description");
            temp[0][1] = javax.swing.JOptionPane.showInputDialog("Enter Max Grade");
            data = temp;
            rubric_table.setModel(new javax.swing.table.DefaultTableModel(data , columnNames));
        }
    }

    private void activity_test_number_fieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void activity_student_submissionpath_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        java.lang.String path_container;
        if ((chooser.showOpenDialog(null)) == (javax.swing.JFileChooser.APPROVE_OPTION)) {
            java.lang.System.out.println(("getCurrentDirectory(): " + (chooser.getCurrentDirectory())));
            path_container = chooser.getSelectedFile().toString();
            activity_student_submissionpath_field.setText(path_container);
            filepath_temp = types.TextAnalyzer.getInput(path_container);
            java.lang.System.out.println(("getSelectedFile() : " + (chooser.getSelectedFile())));
        } else {
            java.lang.System.out.println("No Selection");
            filepath_temp = null;
        }
    }

    private void additional_due_date_buttonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void activity_reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void activity_submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        boolean prog;
        boolean group;
        if (activity_type_combo.getSelectedItem().toString().equalsIgnoreCase("Programming"))
            prog = true;
        else
            prog = false;
        
        if (activity_group_checkbox.isSelected())
            group = true;
        else
            group = false;
        
        types.Activity new_activity = new types.Activity(activity_name_field.getText() , activity_desc_field.getText() , activity_student_submissionpath_field.getText() , activity_solution_field.getText() , activity_lang_field.getText() , activity_due_date_1_field.getText() , prog , group , java.lang.Integer.parseInt(activity_test_number_field.getText()));
        database.CourseAccess.addActivity(courseid, new_activity);
        if (prog)
            database.CourseAccess.addTest(courseid, new_activity, activity_test_in_field.getText(), activity_test_out_field.getText());
        else
            database.CourseAccess.deleteTests(courseid, new_activity);
        
        javax.swing.JOptionPane.showMessageDialog(this, "Activity submitted.");
        gui.utils.GUIUtils.getMasterFrame(this).goBack();
    }

    private void activity_submitModify_buttonActionPerformed(java.awt.event.ActionEvent evt, java.lang.String courseID, java.lang.String actName) {
        boolean prog;
        boolean group;
        if (activity_type_combo.getSelectedItem().toString().equalsIgnoreCase("Programming"))
            prog = true;
        else
            prog = false;
        
        if (activity_group_checkbox.isSelected())
            group = true;
        else
            group = false;
        
        types.Activity new_activity = new types.Activity(activity_name_field.getText() , activity_desc_field.getText() , activity_student_submissionpath_field.getText() , activity_solution_field.getText() , activity_lang_field.getText() , activity_due_date_1_field.getText() , prog , group , java.lang.Integer.parseInt(activity_test_number_field.getText()));
        database.CourseAccess.modifyActivity(courseID, actName, new_activity);
        if (prog)
            database.CourseAccess.addTest(courseid, new_activity, activity_test_in_field.getText(), activity_test_out_field.getText());
        else
            database.CourseAccess.deleteTests(courseid, new_activity);
        
        javax.swing.JOptionPane.showMessageDialog(this, "Activity modified.");
        setOkToNav();
        gui.utils.GUIUtils.getMasterFrame(this).goBack();
    }

    private void Edit_row_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if ((rubric_table.getSelectedRow()) >= 0) {
            java.lang.String desc = javax.swing.JOptionPane.showInputDialog("Enter Rubric Description", rubric_table.getModel().getValueAt(rubric_table.getSelectedRow(), 0).toString());
            java.lang.String MaxGrade = javax.swing.JOptionPane.showInputDialog("Enter Max Grade", rubric_table.getModel().getValueAt(rubric_table.getSelectedRow(), 1).toString());
            rubric_table.getModel().setValueAt(desc, rubric_table.getSelectedRow(), 0);
            rubric_table.getModel().setValueAt(MaxGrade, rubric_table.getSelectedRow(), 1);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a row to edit.");
        }
    }

    private void delete_row_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        int deleterow = rubric_table.getSelectedRow();
        java.lang.Object[][] temp = new java.lang.Object[(data.length) - 1][2];
        for (int i = 0 ; i < deleterow ; i++) {
            temp[i][0] = data[i][0];
            temp[i][1] = data[i][1];
        }
        for (int i = deleterow + 1 ; i < (data.length) ; i++) {
            temp[(i - 1)][0] = data[i][0];
            temp[(i - 1)][1] = data[i][1];
        }
        data = temp;
        rubric_table.setModel(new javax.swing.table.DefaultTableModel(data , columnNames));
    }

    private void activity_test_out_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        java.lang.String path_container;
        if ((chooser.showOpenDialog(null)) == (javax.swing.JFileChooser.APPROVE_OPTION)) {
            java.lang.System.out.println(("getCurrentDirectory(): " + (chooser.getCurrentDirectory())));
            path_container = chooser.getSelectedFile().toString();
            activity_test_out_field.setText(path_container);
            filepath_temp = types.TextAnalyzer.getInput(path_container);
            java.lang.System.out.println(("getSelectedFile() : " + (chooser.getSelectedFile())));
        } else {
            java.lang.System.out.println("No Selection");
            filepath_temp = null;
        }
    }

    private void rubric_submit_buttonActionPerformed(java.awt.event.ActionEvent evt, java.lang.String courseID, java.lang.String actName) {
        int entrynum = rubric_table.getRowCount();
        database.CourseAccess.deleteRubric(courseID, actName);
        for (int i = 0 ; i < entrynum ; i++) {
            java.lang.String desc = rubric_table.getValueAt(i, 0).toString();
            float MaxGrade = java.lang.Float.parseFloat(rubric_table.getValueAt(i, 1).toString());
            data[i][0] = desc;
            data[i][1] = MaxGrade;
            database.CourseAccess.addRubricItem(courseID, actName, desc, MaxGrade);
        }
        setOkToNav();
        javax.swing.JOptionPane.showMessageDialog(this, "Rubric Submitted.");
    }

    private void generate_csvActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        java.io.File path_container;
        if ((chooser.showOpenDialog(null)) == (javax.swing.JFileChooser.APPROVE_OPTION)) {
            path_container = chooser.getCurrentDirectory();
            java.lang.String s = path_container.toString();
            gui.utils.GUIUtils.generateGradeCSV(courseid, actName, s, ((actName) + ".csv"));
        } else {
            java.lang.System.out.println("No Selection");
            filepath_temp = null;
        }
    }

    private javax.swing.JButton Edit_row_button;

    private javax.swing.JTextField activity_desc_field;

    private javax.swing.JLabel activity_desc_label;

    private javax.swing.JFormattedTextField activity_due_date_1_field;

    private javax.swing.JLabel activity_due_date_1_label;

    private javax.swing.JTextField activity_due_date_1_time;

    private javax.swing.JRadioButton activity_group_checkbox;

    private javax.swing.JRadioButton activity_individual_checkbox;

    private javax.swing.JTextField activity_lang_field;

    private javax.swing.JLabel activity_lang_label;

    private javax.swing.JTextField activity_name_field;

    private javax.swing.JLabel activity_name_label;

    private javax.swing.JButton activity_reset_button;

    private javax.swing.JPanel activity_rubric_tab;

    private javax.swing.JButton activity_solution_button;

    private javax.swing.JTextField activity_solution_field;

    private javax.swing.JButton activity_student_submissionpath_button;

    private javax.swing.JTextField activity_student_submissionpath_field;

    private javax.swing.JButton activity_submit_button;

    private javax.swing.JButton activity_test_in_button;

    private javax.swing.JTextField activity_test_in_field;

    private javax.swing.JTextField activity_test_number_field;

    private javax.swing.JLabel activity_test_number_label;

    private javax.swing.JButton activity_test_out_button;

    private javax.swing.JTextField activity_test_out_field;

    private javax.swing.JLabel activity_testcomment_label;

    private javax.swing.JComboBox activity_type_combo;

    private javax.swing.JLabel activity_type_label;

    private javax.swing.JButton additional_due_date_button;

    private javax.swing.JTabbedPane create_activity_pane;

    private javax.swing.JPanel create_activity_tab;

    private javax.swing.JButton delete_row_button;

    private javax.swing.ButtonGroup individual_button_group;

    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JButton rubric_additional_row_button;

    private javax.swing.JButton rubric_submit_button;

    private javax.swing.JTable rubric_table;

    private javax.swing.JButton generate_csv;
}

