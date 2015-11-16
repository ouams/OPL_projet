package gui;


public class ActivityManagement extends gui.types.MSPanel {
    private types.Instructor a;

    private java.lang.String courseID;

    public ActivityManagement(java.lang.String courseID ,types.Instructor a) {
        super("Activity Management");
        this.a = a;
        this.courseID = courseID;
        initComponents();
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        activity_management_panel = new javax.swing.JPanel();
        create_activity_button = new javax.swing.JButton();
        modify_activity_button = new javax.swing.JButton();
        delete_activity_button = new javax.swing.JButton();
        activity_management_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Activity Management"));
        create_activity_button.setText("Create an Activity");
        create_activity_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_activity_buttonActionPerformed(evt);
            }
        });
        modify_activity_button.setText("Modify Existing Activity");
        modify_activity_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify_activity_buttonActionPerformed(evt);
            }
        });
        delete_activity_button.setText("Delete Existing Activity");
        delete_activity_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_activity_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout tasks_panelLayout = new javax.swing.GroupLayout(activity_management_panel);
        activity_management_panel.setLayout(tasks_panelLayout);
        tasks_panelLayout.setHorizontalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(146, 146, 146).addGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(delete_activity_button).addGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(modify_activity_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(create_activity_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))).addContainerGap(184, java.lang.Short.MAX_VALUE)));
        tasks_panelLayout.setVerticalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(81, 81, 81).addComponent(create_activity_button).addGap(18, 18, 18).addComponent(modify_activity_button).addGap(18, 18, 18).addComponent(delete_activity_button).addContainerGap(70, java.lang.Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(activity_management_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(activity_management_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
    }

    private void create_activity_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.ActivityCreation(courseID));
    }

    private void modify_activity_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.ActivitySelection(MODIFY_ACTIVITY , courseID));
    }

    private void delete_activity_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.ActivitySelection(DELETE_ACTIVITY , courseID));
    }

    private static final int MODIFY_ACTIVITY = 1;

    private static final int DELETE_ACTIVITY = 2;

    private javax.swing.JButton create_activity_button;

    private javax.swing.JButton delete_activity_button;

    private javax.swing.JButton modify_activity_button;

    private javax.swing.JPanel activity_management_panel;
}

