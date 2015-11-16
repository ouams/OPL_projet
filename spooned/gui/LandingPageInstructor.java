package gui;


public class LandingPageInstructor extends gui.types.MSPanel {
    private types.Instructor a;

    public LandingPageInstructor(types.Instructor a) {
        super("Instructor");
        this.a = a;
        initComponents();
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        tasks_panel = new javax.swing.JPanel();
        marking_button = new javax.swing.JButton();
        activity_management_button = new javax.swing.JButton();
        tasks_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tasks"));
        marking_button.setText("Marking");
        marking_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marking_buttonActionPerformed(evt);
            }
        });
        activity_management_button.setText("Activity Management");
        activity_management_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activity_management_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout tasks_panelLayout = new javax.swing.GroupLayout(tasks_panel);
        tasks_panel.setLayout(tasks_panelLayout);
        tasks_panelLayout.setHorizontalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(146, 146, 146).addGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(activity_management_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(marking_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)).addContainerGap(153, java.lang.Short.MAX_VALUE)));
        tasks_panelLayout.setVerticalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(81, 81, 81).addComponent(marking_button).addGap(37, 37, 37).addComponent(activity_management_button).addContainerGap(98, java.lang.Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
    }

    private void marking_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.CourseSelection(MARKING , a));
    }

    private void activity_management_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.CourseSelection(ACTIVITY_MANAGEMENT , a));
    }

    private static final int MARKING = 3;

    private static final int ACTIVITY_MANAGEMENT = 4;

    private javax.swing.JButton activity_management_button;

    private javax.swing.JButton marking_button;

    private javax.swing.JPanel tasks_panel;
}

