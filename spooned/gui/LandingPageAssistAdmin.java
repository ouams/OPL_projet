package gui;


public class LandingPageAssistAdmin extends gui.types.MSPanel {
    private types.AssistantAdmin a;

    public LandingPageAssistAdmin(types.AssistantAdmin a) {
        super("Assistant Academic Administrator");
        this.a = a;
        initComponents();
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        course_selection_header = new javax.swing.JPanel();
        course_management_button = new javax.swing.JButton();
        course_selection_header.setBorder(javax.swing.BorderFactory.createTitledBorder("Tasks"));
        course_selection_header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        course_selection_header.setName("");
        course_management_button.setText("Course Management");
        course_management_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_management_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout course_selection_headerLayout = new javax.swing.GroupLayout(course_selection_header);
        course_selection_header.setLayout(course_selection_headerLayout);
        course_selection_headerLayout.setHorizontalGroup(course_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, course_selection_headerLayout.createSequentialGroup().addContainerGap(193, java.lang.Short.MAX_VALUE).addComponent(course_management_button).addGap(169, 169, 169)));
        course_selection_headerLayout.setVerticalGroup(course_selection_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(course_selection_headerLayout.createSequentialGroup().addGap(123, 123, 123).addComponent(course_management_button).addContainerGap(125, java.lang.Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 525, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(course_selection_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 325, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(course_selection_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(20, java.lang.Short.MAX_VALUE))));
    }

    private void course_management_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.CourseManagement(a));
    }

    private static final int MODIFY_COURSE = 1;

    private static final int DELETE_COURSE = 2;

    private javax.swing.JButton course_management_button;

    private javax.swing.JPanel course_selection_header;
}

