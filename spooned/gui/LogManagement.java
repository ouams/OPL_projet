package gui;


public class LogManagement extends gui.types.MSPanel {
    private types.SystemAdmin a;

    public LogManagement() {
        super("System Administrator");
        initComponents();
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        tasks_panel = new javax.swing.JPanel();
        system_log_scrollpane = new javax.swing.JScrollPane();
        system_log_textpane = new javax.swing.JTextPane();
        tasks_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("System Log"));
        system_log_scrollpane.setViewportView(system_log_textpane);
        javax.swing.GroupLayout tasks_panelLayout = new javax.swing.GroupLayout(tasks_panel);
        tasks_panel.setLayout(tasks_panelLayout);
        tasks_panelLayout.setHorizontalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addContainerGap().addComponent(system_log_scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 480, java.lang.Short.MAX_VALUE).addContainerGap()));
        tasks_panelLayout.setVerticalGroup(tasks_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(tasks_panelLayout.createSequentialGroup().addContainerGap().addComponent(system_log_scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 237, java.lang.Short.MAX_VALUE).addContainerGap()));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(tasks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
    }

    private javax.swing.JScrollPane system_log_scrollpane;

    private javax.swing.JTextPane system_log_textpane;

    private javax.swing.JPanel tasks_panel;
}

