package gui;


public class LandingPageTA extends gui.types.MSPanel {
    private types.TATM a;

    public LandingPageTA(types.TATM a) {
        super("TA/TM");
        this.a = a;
        initComponents();
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        tasks_panel = new javax.swing.JPanel();
        marking_button = new javax.swing.JButton();
        tasks_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tasks"));
        marking_button.setText("Marking");
        marking_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marking_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout tasks_panelLayout = new javax.swing.GroupLayout(tasks_panel);
        tasks_panel.setLayout(tasks_panelLayout);
        tasks_panelLayout.setHorizontalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(165, 165, 165).addComponent(marking_button, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(166, java.lang.Short.MAX_VALUE)));
        tasks_panelLayout.setVerticalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addGap(131, 131, 131).addComponent(marking_button).addContainerGap(142, java.lang.Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 496, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 341, java.lang.Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))));
    }

    private void marking_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.CourseSelection(TA_MARKING , a));
    }

    private static final int TA_MARKING = 7;

    private javax.swing.JButton marking_button;

    private javax.swing.JPanel tasks_panel;
}

