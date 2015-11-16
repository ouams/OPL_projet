package gui;


public class SelectActivityMatrix extends gui.types.MSPanel {
    private types.Course c;

    public SelectActivityMatrix(types.Course course) {
        super("Activity Selection");
        this.c = course;
        initComponents();
        java.lang.System.out.println("Accessing Student List");
        student_select_dropdown.setModel(new javax.swing.DefaultComboBoxModel(database.CourseAccess.accessStudentList(c.getCourseID())));
        java.lang.Object[] assignment_list = database.CourseAccess.accessActivityList(course.getCourseID());
        assignment_select_dropdown.setModel(new javax.swing.DefaultComboBoxModel(assignment_list));
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        student_matrix_header = new javax.swing.JPanel();
        ok_button = new javax.swing.JButton();
        student_select_dropdown = new javax.swing.JComboBox();
        assignment_select_dropdown = new javax.swing.JComboBox();
        student_label = new javax.swing.JLabel();
        assignment_label = new javax.swing.JLabel();
        student_matrix_header.setBorder(javax.swing.BorderFactory.createTitledBorder("Select the Desired Activity:"));
        student_matrix_header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        student_matrix_header.setName("");
        ok_button.setText("OK");
        ok_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_buttonActionPerformed(evt);
            }
        });
        student_select_dropdown.setModel(new javax.swing.DefaultComboBoxModel(new java.lang.String[]{ "Student A" , "Student B" , "Student C" }));
        assignment_select_dropdown.setModel(new javax.swing.DefaultComboBoxModel(new java.lang.String[]{ "Assignment 1" , "Assignment 2" , "Assignment 3" }));
        student_label.setText("Student:");
        assignment_label.setText("Activity:");
        javax.swing.GroupLayout student_matrix_headerLayout = new javax.swing.GroupLayout(student_matrix_header);
        student_matrix_header.setLayout(student_matrix_headerLayout);
        student_matrix_headerLayout.setHorizontalGroup(student_matrix_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(student_matrix_headerLayout.createSequentialGroup().addGroup(student_matrix_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(student_matrix_headerLayout.createSequentialGroup().addGap(72, 72, 72).addGroup(student_matrix_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, student_matrix_headerLayout.createSequentialGroup().addComponent(assignment_label).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, java.lang.Short.MAX_VALUE).addComponent(assignment_select_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(student_matrix_headerLayout.createSequentialGroup().addComponent(student_label).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(student_select_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, student_matrix_headerLayout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(ok_button, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap()));
        student_matrix_headerLayout.setVerticalGroup(student_matrix_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(student_matrix_headerLayout.createSequentialGroup().addGap(52, 52, 52).addGroup(student_matrix_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(student_matrix_headerLayout.createSequentialGroup().addGroup(student_matrix_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(student_select_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(student_label)).addGap(78, 78, 78)).addGroup(student_matrix_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(assignment_label).addComponent(assignment_select_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, java.lang.Short.MAX_VALUE).addComponent(ok_button)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(student_matrix_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(student_matrix_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addContainerGap()));
    }

    private void ok_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String c_id = c.getCourseID();
        types.Activity act = database.CourseAccess.constructActivityObject(c_id, assignment_select_dropdown.getSelectedItem().toString());
        java.lang.String id = student_select_dropdown.getSelectedItem().toString();
        java.lang.Object[] student_list = database.CourseAccess.accessStudentList(c_id);
        java.lang.String[] pass_array = id.split(" - ");
        java.lang.String student_name = pass_array[0];
        int student_id = java.lang.Integer.parseInt(pass_array[1]);
        if (act.isProgramming())
            gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.MarkingCode(c_id , act , student_id , student_name , student_list));
        else
            gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.MarkingPDF(c_id , act , student_id , student_name , student_list));
        
    }

    private javax.swing.JLabel assignment_label;

    private javax.swing.JComboBox assignment_select_dropdown;

    private javax.swing.JButton ok_button;

    private javax.swing.JLabel student_label;

    private javax.swing.JPanel student_matrix_header;

    private javax.swing.JComboBox student_select_dropdown;
}

