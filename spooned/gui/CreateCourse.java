package gui;


public class CreateCourse extends gui.types.MSPanel {
    private java.util.ArrayList<java.lang.String> accounts_list;

    public CreateCourse() {
        super("Course Creation", gui.types.MSPanel.CANT_NAV);
        initComponents();
    }

    public CreateCourse(final types.Course course) {
        super("Course Modification", gui.types.MSPanel.CANT_NAV);
        initComponents();
        course_name_field.setText(course.getCourseName());
        course_id_field.setText(course.getCourseID());
        instruct_combo.setSelectedItem((((((course.getInstructor().getFirstName()) + " ") + (course.getInstructor().getLastName())) + " - ") + (course.getInstructor().getEmpID())));
        java.lang.String tas = "";
        types.Account[] a = course.getTA();
        for (int i = 0 ; i < (a.length) ; i++) {
            tas = (((((tas + (a[i].getFirstName())) + " ") + (a[i].getLastName())) + " - ") + (a[i].getEmpID())) + ", ";
        }
        ta_list.setText(tas);
        course_start_formatfield.setText(course.getStartDate());
        course_end_formatfield.setText(course.getEndDate());
        for (java.awt.event.ActionListener act : submit_button.getActionListeners())
            submit_button.removeActionListener(act);
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_modify_buttonActionPerformed(evt, course.getCourseID());
            }
        });
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        create_course_panel = new javax.swing.JPanel();
        course_name_label = new javax.swing.JLabel();
        course_id_label = new javax.swing.JLabel();
        instructor_username_label = new javax.swing.JLabel();
        ta_name_label = new javax.swing.JLabel();
        course_start_label = new javax.swing.JLabel();
        stud_list_label = new javax.swing.JLabel();
        course_end_label = new javax.swing.JLabel();
        course_id_field = new javax.swing.JTextField();
        course_start_formatfield = new javax.swing.JFormattedTextField();
        stud_list_file_location_field = new javax.swing.JTextField();
        choose_file_student_list_button = new javax.swing.JButton();
        submit_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        course_name_field = new javax.swing.JTextField();
        course_end_formatfield = new javax.swing.JFormattedTextField();
        ta_combo = new javax.swing.JComboBox();
        instruct_combo = new javax.swing.JComboBox();
        instructor_field = new javax.swing.JTextField();
        instructor_id_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_list = new javax.swing.JTextArea();
        add_ta_button = new javax.swing.JButton();
        delete_ta_button = new javax.swing.JButton();
        create_course_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Create A Course"));
        course_name_label.setText("Course Name");
        course_id_label.setText("Course ID");
        instructor_username_label.setText("Instructor Name");
        ta_name_label.setText("TA/Marker Name");
        course_start_label.setText("Course Start Date");
        stud_list_label.setText("Student List (.csv)");
        course_end_label.setText("Course End Date");
        course_start_formatfield.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        course_start_formatfield.setText("yyyy-MM-dd");
        stud_list_file_location_field.setText("File Location...");
        choose_file_student_list_button.setText("Choose File");
        choose_file_student_list_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose_file_student_list_buttonActionPerformed(evt);
            }
        });
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });
        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        course_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_name_fieldActionPerformed(evt);
            }
        });
        course_end_formatfield.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        course_end_formatfield.setText("yyyy-MM-dd");
        course_end_formatfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_end_formatfieldActionPerformed(evt);
            }
        });
        ta_combo.setModel(new javax.swing.DefaultComboBoxModel(database.AccountAccess.accessAllTAs()));
        ta_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ta_comboActionPerformed(evt);
            }
        });
        instruct_combo.setModel(new javax.swing.DefaultComboBoxModel(database.AccountAccess.accessAllInstructors()));
        instruct_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruct_comboActionPerformed(evt);
            }
        });
        instructor_field.setEditable(false);
        instructor_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructor_fieldActionPerformed(evt);
            }
        });
        instructor_id_label.setText("Instructor ID");
        ta_list.setEditable(false);
        ta_list.setColumns(20);
        ta_list.setRows(5);
        jScrollPane1.setViewportView(ta_list);
        add_ta_button.setText("Add TA");
        add_ta_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ta_buttonActionPerformed(evt);
            }
        });
        delete_ta_button.setText("Remove TA");
        delete_ta_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_ta_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout create_course_panelLayout = new javax.swing.GroupLayout(create_course_panel);
        create_course_panel.setLayout(create_course_panelLayout);
        create_course_panelLayout.setHorizontalGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(create_course_panelLayout.createSequentialGroup().addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(create_course_panelLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(create_course_panelLayout.createSequentialGroup().addComponent(stud_list_label).addGap(2, 2, 2).addComponent(stud_list_file_location_field, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(choose_file_student_list_button).addGap(0, 0, java.lang.Short.MAX_VALUE)).addGroup(create_course_panelLayout.createSequentialGroup().addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(create_course_panelLayout.createSequentialGroup().addComponent(course_start_label).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(course_start_formatfield, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(38, 38, 38)).addGroup(create_course_panelLayout.createSequentialGroup().addComponent(ta_name_label).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(ta_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1).addGroup(create_course_panelLayout.createSequentialGroup().addComponent(course_end_label).addGap(18, 18, 18).addComponent(course_end_formatfield)))))).addGroup(create_course_panelLayout.createSequentialGroup().addContainerGap().addComponent(submit_button).addGap(18, 440, java.lang.Short.MAX_VALUE).addComponent(cancel_button)).addGroup(create_course_panelLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(create_course_panelLayout.createSequentialGroup().addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(course_id_label).addComponent(course_name_label)).addGap(141, 141, 141).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(course_id_field).addComponent(course_name_field))).addGroup(create_course_panelLayout.createSequentialGroup().addComponent(instructor_username_label).addGap(18, 18, 18).addComponent(instruct_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(instructor_id_label).addGap(18, 18, 18).addComponent(instructor_field))))).addContainerGap()).addGroup(create_course_panelLayout.createSequentialGroup().addGap(125, 125, 125).addComponent(add_ta_button).addGap(5, 5, 5).addComponent(delete_ta_button).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)));
        create_course_panelLayout.setVerticalGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(create_course_panelLayout.createSequentialGroup().addContainerGap(28, java.lang.Short.MAX_VALUE).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(course_name_label).addComponent(course_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(course_id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(course_id_label)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(instructor_username_label).addComponent(instructor_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(instruct_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(instructor_id_label)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(ta_name_label).addComponent(ta_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(3, 3, 3).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(add_ta_button).addComponent(delete_ta_button)).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(course_start_label).addComponent(course_start_formatfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(course_end_label).addComponent(course_end_formatfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(stud_list_label).addComponent(stud_list_file_location_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(choose_file_student_list_button)).addGap(28, 28, 28).addGroup(create_course_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(submit_button).addComponent(cancel_button))));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(create_course_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(create_course_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(9, java.lang.Short.MAX_VALUE)));
    }

    private void instructor_fieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void course_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void course_end_formatfieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void ta_comboActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String taField = ta_combo.getSelectedItem().toString();
        taField = taField.substring(((taField.indexOf("-")) + 2));
    }

    private void instruct_comboActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String instField = instruct_combo.getSelectedItem().toString();
        instField = instField.substring(((instField.indexOf("-")) + 2));
        instructor_field.setText(instField);
    }

    private void add_ta_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (!(ta_list.getText().contains(ta_combo.getSelectedItem().toString())))
            ta_list.append(((ta_combo.getSelectedItem().toString()) + ", "));
        
    }

    private java.lang.Boolean fieldCheck() {
        java.lang.Boolean fields_pass_check;
        if (((((((course_name_field.getText().equalsIgnoreCase("")) || (course_id_field.getText().equalsIgnoreCase(""))) || (instructor_field.getText().equalsIgnoreCase(""))) || (ta_list.getText().equalsIgnoreCase(""))) || (course_start_formatfield.getText().equalsIgnoreCase(""))) || (course_end_formatfield.getText().equalsIgnoreCase(""))) || (stud_list_file_location_field.getText().equalsIgnoreCase(""))) {
            javax.swing.JOptionPane.showMessageDialog(this, "One of your fields is not filled in, please check all your fields and resubmit!");
            fields_pass_check = false;
        } else
            fields_pass_check = true;
        
        return fields_pass_check;
    }

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.Boolean ok_to_submit = fieldCheck();
        if (ok_to_submit) {
            types.Instructor instructor_taken;
            java.lang.String instField = instruct_combo.getSelectedItem().toString();
            instField = instField.substring(((instField.indexOf("-")) + 2));
            int instID = java.lang.Integer.parseInt(instField);
            instructor_taken = ((types.Instructor)(database.AccountAccess.constructAccountObject(database.AccountAccess.accessUsername(instID))));
            types.Course new_course = new types.Course(course_name_field.getText() , course_id_field.getText() , instructor_taken , course_start_formatfield.getText() , course_end_formatfield.getText());
            database.CourseAccess.createCourse(new_course);
            if ((ta_list.getText()) != null) {
                java.lang.String[] tasplit = ta_list.getText().split(",");
                for (int i = 0 ; i < ((tasplit.length) - 1) ; i++) {
                    java.lang.String[] ta = tasplit[i].split(" - ");
                    database.CourseAccess.addTA(course_id_field.getText(), java.lang.Integer.parseInt(ta[1].trim()), ta[0].trim());
                }
            } 
            if ((accounts_list) != null) {
                database.CourseAccess.clearStudentList(course_id_field.getText());
                java.lang.String student_name;
                java.lang.String student_id;
                for (java.lang.String i : accounts_list) {
                    java.lang.String[] arr = i.split(", ");
                    student_name = arr[0];
                    student_id = arr[1];
                    database.CourseAccess.addStudent(student_name, java.lang.Integer.parseInt(student_id), course_id_field.getText());
                }
            } 
            javax.swing.JOptionPane.showMessageDialog(this, (("Course " + (new_course.getCourseName())) + " added."));
            setOkToNav();
            gui.utils.GUIUtils.getMasterFrame(this).goBack();
        } 
    }

    private void submit_modify_buttonActionPerformed(java.awt.event.ActionEvent evt, java.lang.String courseIDToModify) {
        types.Instructor instructor_taken;
        java.lang.String instField = instruct_combo.getSelectedItem().toString();
        instField = instField.substring(((instField.indexOf("-")) + 2));
        int instID = java.lang.Integer.parseInt(instField);
        instructor_taken = ((types.Instructor)(database.AccountAccess.constructAccountObject(database.AccountAccess.accessUsername(instID))));
        types.Course new_course = new types.Course(course_name_field.getText() , course_id_field.getText() , instructor_taken , course_start_formatfield.getText() , course_end_formatfield.getText());
        database.CourseAccess.modifyCourse(courseIDToModify, new_course);
        database.CourseAccess.clearTAs(course_id_field.getText());
        if ((ta_list.getText()) != null) {
            java.lang.String[] tasplit = ta_list.getText().split(",");
            for (int i = 0 ; i < ((tasplit.length) - 1) ; i++) {
                java.lang.String[] ta = tasplit[i].split(" - ");
                database.CourseAccess.addTA(course_id_field.getText(), java.lang.Integer.parseInt(ta[1].trim()), ta[0].trim());
            }
        } 
        if ((accounts_list) != null) {
            database.CourseAccess.clearStudentList(course_id_field.getText());
            java.lang.String student_name;
            java.lang.String student_id;
            for (java.lang.String i : accounts_list) {
                java.lang.String[] arr = i.split(", ");
                student_name = arr[0];
                student_id = arr[1];
                database.CourseAccess.addStudent(student_name, java.lang.Integer.parseInt(student_id), course_id_field.getText());
            }
        } 
        javax.swing.JOptionPane.showMessageDialog(this, (("Course " + (new_course.getCourseName())) + " modified."));
        setOkToNav();
        gui.utils.GUIUtils.getMasterFrame(this).goBack();
    }

    private void choose_file_student_list_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        java.lang.String path_container;
        if ((chooser.showOpenDialog(null)) == (javax.swing.JFileChooser.APPROVE_OPTION)) {
            java.lang.System.out.println(("getCurrentDirectory(): " + (chooser.getCurrentDirectory())));
            path_container = chooser.getSelectedFile().toString();
            stud_list_file_location_field.setText(path_container);
            accounts_list = types.TextAnalyzer.getInput(path_container);
            java.lang.System.out.println(("getSelectedFile() : " + (chooser.getSelectedFile())));
        } else {
            java.lang.System.out.println("No Selection");
            accounts_list = null;
        }
    }

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).goBack();
    }

    private void delete_ta_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String tas = ta_list.getText();
        tas = tas.replaceFirst(((ta_combo.getSelectedItem().toString()) + ", "), "");
        ta_list.setText(tas);
    }

    private javax.swing.JButton add_ta_button;

    private javax.swing.JButton cancel_button;

    private javax.swing.JButton choose_file_student_list_button;

    private javax.swing.JFormattedTextField course_end_formatfield;

    private javax.swing.JLabel course_end_label;

    private javax.swing.JTextField course_id_field;

    private javax.swing.JLabel course_id_label;

    private javax.swing.JTextField course_name_field;

    private javax.swing.JLabel course_name_label;

    private javax.swing.JFormattedTextField course_start_formatfield;

    private javax.swing.JLabel course_start_label;

    private javax.swing.JPanel create_course_panel;

    private javax.swing.JComboBox instruct_combo;

    private javax.swing.JTextField instructor_field;

    private javax.swing.JLabel instructor_id_label;

    private javax.swing.JLabel instructor_username_label;

    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JTextField stud_list_file_location_field;

    private javax.swing.JLabel stud_list_label;

    private javax.swing.JButton submit_button;

    private javax.swing.JComboBox ta_combo;

    private javax.swing.JTextArea ta_list;

    private javax.swing.JLabel ta_name_label;

    private javax.swing.JButton delete_ta_button;
}

