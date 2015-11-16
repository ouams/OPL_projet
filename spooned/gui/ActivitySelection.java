package gui;


public class ActivitySelection extends gui.types.MSPanel {
    java.lang.String courseID;

    public ActivitySelection(java.lang.String courseID) {
        super("Activity Selection");
        this.courseID = courseID;
        initComponents();
    }

    public ActivitySelection(int page ,java.lang.String courseID) {
        super("Activity Selection");
        this.courseID = courseID;
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
                        ok_deleteActivity_buttonActionPerformed(evt);
                    }
                });
                break;
            case 3 :
                initComponents();
                for (java.awt.event.ActionListener act : ok_button.getActionListeners())
                    ok_button.removeActionListener(act);
                ok_button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ok_markActivity_buttonActionPerformed(evt);
                    }
                });
                break;
        }
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        activity_selection_header = new javax.swing.JPanel();
        activity_dropdown = new javax.swing.JComboBox();
        activities_label = new javax.swing.JLabel();
        ok_button = new javax.swing.JButton();
        activity_selection_header.setBorder(javax.swing.BorderFactory.createTitledBorder("Activity Selection"));
        activity_selection_header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        activity_selection_header.setName("");
        activity_dropdown.setModel(new javax.swing.DefaultComboBoxModel(database.CourseAccess.accessActivityList(courseID)));
        activity_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_dropdownActionPerformed(evt);
            }
        });
        activities_label.setText("Activities:");
        ok_button.setText("OK");
        ok_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout activity_selection_headerLayout = new javax.swing.GroupLayout(activity_selection_header);
        activity_selection_header.setLayout(activity_selection_headerLayout);
        activity_selection_headerLayout.setHorizontalGroup(activity_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activity_selection_headerLayout.createSequentialGroup().addContainerGap(66, java.lang.Short.MAX_VALUE).addComponent(activities_label, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(activity_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(activity_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(ok_button, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(69, 69, 69)));
        activity_selection_headerLayout.setVerticalGroup(activity_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(activity_selection_headerLayout.createSequentialGroup().addGap(114, 114, 114).addGroup(activity_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(activity_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(activities_label)).addGap(18, 18, 18).addComponent(ok_button).addContainerGap(113, java.lang.Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 479, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(activity_selection_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 333, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(activity_selection_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))));
    }

    private void ok_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String activityName = activity_dropdown.getSelectedItem().toString();
        types.Activity act = database.CourseAccess.constructActivityObject(courseID, activityName);
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.ActivityCreation(courseID , act));
    }

    private void ok_deleteActivity_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String toDelete = activity_dropdown.getSelectedItem().toString();
        int check = javax.swing.JOptionPane.showConfirmDialog(this, (("Delete activity " + toDelete) + "?"), "", javax.swing.JOptionPane.YES_NO_OPTION);
        if (check == 0) {
            database.CourseAccess.deleteActivity(courseID, toDelete);
            activity_dropdown.removeItem(toDelete);
        } 
    }

    private void ok_markActivity_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.System.out.println("Getting activity name");
        java.lang.String activityName = activity_dropdown.getSelectedItem().toString();
        java.lang.System.out.println("Getting course");
        types.Course course = database.CourseAccess.constructCourseObject(courseID);
        java.lang.System.out.println(("Got course " + (course.getCourseID())));
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.SelectActivityMatrix(course));
    }

    private void activity_dropdownActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private javax.swing.JLabel activities_label;

    private javax.swing.JComboBox activity_dropdown;

    private javax.swing.JPanel activity_selection_header;

    private javax.swing.JButton ok_button;
}

