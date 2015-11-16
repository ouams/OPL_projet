package gui;


public class CourseSelection extends gui.types.MSPanel {
    public CourseSelection() {
        super("Course Selection");
        initComponents();
    }

    public CourseSelection(int page ,types.Account acct) {
        super("Course Selection");
        this.a = acct;
        marking = false;
        switch (page) {
            case 1 :
                initComponents();
                break;
            case 2 :
                initComponents();
                for (java.awt.event.ActionListener act : ok_button.getActionListeners())
                    ok_button.removeActionListener(act);
                ok_button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ok_deleteCourse_buttonActionPerformed(evt);
                    }
                });
                break;
            case 3 :
                initComponents();
                marking = true;
                course_selection_dropdown.setModel(new javax.swing.DefaultComboBoxModel(database.CourseAccess.accessCourseList(a.getEmpID())));
                for (java.awt.event.ActionListener act : ok_button.getActionListeners())
                    ok_button.removeActionListener(act);
                ok_button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ok_markingCourse_buttonActionPerformed(evt);
                    }
                });
                break;
            case 4 :
                initComponents();
                course_selection_dropdown.setModel(new javax.swing.DefaultComboBoxModel(database.CourseAccess.accessCourseList(a.getEmpID())));
                for (java.awt.event.ActionListener act : ok_button.getActionListeners())
                    ok_button.removeActionListener(act);
                ok_button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ok_activityManagement_buttonActionPerformed(evt);
                    }
                });
                break;
            case 5 :
                initComponents();
                marking = true;
                for (java.awt.event.ActionListener act : ok_button.getActionListeners())
                    ok_button.removeActionListener(act);
                ok_button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ok_grading_buttonActionPerformed(evt);
                    }
                });
                break;
            case 6 :
                break;
            case 7 :
                initComponents();
                marking = true;
                course_selection_dropdown.setModel(new javax.swing.DefaultComboBoxModel(database.CourseAccess.accessCourseListTA(a.getEmpID())));
                for (java.awt.event.ActionListener act : ok_button.getActionListeners())
                    ok_button.removeActionListener(act);
                ok_button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ok_markingCourse_buttonActionPerformed(evt);
                    }
                });
                break;
        }
    }

    java.lang.Boolean marking = false;

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        course_selection_header = new javax.swing.JPanel();
        course_selection_dropdown = new javax.swing.JComboBox();
        courses_label = new javax.swing.JLabel();
        ok_button = new javax.swing.JButton();
        course_selection_header.setBorder(javax.swing.BorderFactory.createTitledBorder("Course Selection"));
        course_selection_header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        course_selection_header.setName("");
        course_selection_dropdown.setModel(new javax.swing.DefaultComboBoxModel(database.CourseAccess.accessCourseList()));
        course_selection_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_selection_dropdownActionPerformed(evt);
            }
        });
        courses_label.setText("Courses:");
        ok_button.setText("OK");
        ok_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout course_selection_headerLayout = new javax.swing.GroupLayout(course_selection_header);
        course_selection_header.setLayout(course_selection_headerLayout);
        course_selection_headerLayout.setHorizontalGroup(course_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, course_selection_headerLayout.createSequentialGroup().addContainerGap(66, java.lang.Short.MAX_VALUE).addComponent(courses_label, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(course_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(course_selection_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(ok_button, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(69, 69, 69)));
        course_selection_headerLayout.setVerticalGroup(course_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(course_selection_headerLayout.createSequentialGroup().addGap(114, 114, 114).addGroup(course_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(course_selection_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(courses_label)).addGap(18, 18, 18).addComponent(ok_button).addContainerGap(101, java.lang.Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 479, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(course_selection_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 321, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(course_selection_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))));
    }

    private void ok_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String test = course_selection_dropdown.getSelectedItem().toString();
        java.lang.System.out.println(test);
        types.Course course = database.CourseAccess.constructCourseObject(test);
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.CreateCourse(course));
    }

    private void ok_activityManagement_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String courseid = course_selection_dropdown.getSelectedItem().toString();
        types.Course course_choice = database.CourseAccess.constructCourseObject(courseid);
        if (marking)
            gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.SelectActivityMatrix(course_choice));
        else
            gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.ActivityManagement(courseid , ((types.Instructor)(a))));
        
    }

    private void ok_deleteCourse_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String toDelete = course_selection_dropdown.getSelectedItem().toString();
        int check = javax.swing.JOptionPane.showConfirmDialog(this, (("Delete course " + toDelete) + "?"), "", javax.swing.JOptionPane.YES_NO_OPTION);
        if (check == 0) {
            boolean deleted = database.CourseAccess.deleteCourse(toDelete);
            if (deleted)
                course_selection_dropdown.removeItem(toDelete);
            else
                javax.swing.JOptionPane.showMessageDialog(this, ("This course has activities associated with it, " + "so it was not deleted."));
            
        } 
    }

    private void ok_markingCourse_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String courseID = course_selection_dropdown.getSelectedItem().toString();
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.SelectActivityMatrix(database.CourseAccess.constructCourseObject(courseID)));
    }

    private void ok_grading_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String courseID = course_selection_dropdown.getSelectedItem().toString();
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.SelectActivityMatrix(database.CourseAccess.constructCourseObject(courseID)));
    }

    private void course_selection_dropdownActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private types.Account a;

    private javax.swing.JComboBox course_selection_dropdown;

    private javax.swing.JPanel course_selection_header;

    private javax.swing.JLabel courses_label;

    private javax.swing.JButton ok_button;
}

