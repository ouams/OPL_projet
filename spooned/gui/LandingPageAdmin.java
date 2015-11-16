package gui;


public class LandingPageAdmin extends gui.types.MSPanel {
    private types.AcademicAdmin a;

    public LandingPageAdmin(types.AcademicAdmin a) {
        super("Academic Administrator");
        this.a = a;
        initComponents();
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        tasks_panel = new javax.swing.JPanel();
        manage_grades_button = new javax.swing.JButton();
        tasks_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tasks"));
        manage_grades_button.setText("Manage Grades");
        manage_grades_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_grades_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout tasks_panelLayout = new javax.swing.GroupLayout(tasks_panel);
        tasks_panel.setLayout(tasks_panelLayout);
        tasks_panelLayout.setHorizontalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(120, 120, 120).addComponent(manage_grades_button, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(117, java.lang.Short.MAX_VALUE)));
        tasks_panelLayout.setVerticalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(117, 117, 117).addComponent(manage_grades_button).addContainerGap(128, java.lang.Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 306, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(4, 4, 4).addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))));
    }

    private void manage_grades_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.CourseSelection(GRADING , a));
    }

    private static final int GRADING = 5;

    private static final int VIEWING = 6;

    private javax.swing.JButton manage_grades_button;

    private javax.swing.JPanel tasks_panel;
}

