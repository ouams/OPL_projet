package gui;


public class MarkingPDF extends gui.types.MSPanel {
    private static final java.lang.String[] COLUMN_NAMES = new java.lang.String[]{ "Description" , "Grade" , "Max Grade" };

    private java.lang.Object[][] table;

    private int studentID;

    private java.lang.String courseID;

    private java.lang.String actName;

    private java.lang.String stud_name;

    private java.lang.Object[] student_list;

    private types.Activity activity;

    public MarkingPDF(final java.lang.String courseID ,final types.Activity act ,final int stud_id ,java.lang.String student_name ,java.lang.Object[] stud_list) {
        super(act.getName(), gui.types.MSPanel.CANT_NAV);
        initComponents();
        this.student_list = stud_list;
        this.activity = act;
        this.stud_name = student_name;
        student_name_label.setText(student_name);
        id_label.setText(java.lang.Integer.toString(stud_id));
        grade_field.setEditable(false);
        max_grade_field.setEditable(false);
        float max = 0;
        this.courseID = courseID;
        this.actName = act.getName();
        this.studentID = stud_id;
        java.lang.String last_indice_check = (student_name + " - ") + (studentID);
        if (last_indice_check.equalsIgnoreCase(((java.lang.String)(stud_list[((stud_list.length) - 1)]))))
            this.next_button.setEnabled(false);
        
        SwingController submittedController = new SwingController();
        SwingViewBuilder submittedPDF = new SwingViewBuilder(submittedController);
        SwingController solutionController = new SwingController();
        SwingViewBuilder solutionPDF = new SwingViewBuilder(solutionController);
        ComponentKeyBinding.install(submittedController, submitted_panel);
        submittedController.getDocumentViewController().setAnnotationCallback(new org.icepdf(submittedController.getDocumentViewController()));
        ComponentKeyBinding.install(solutionController, solution_panel);
        solutionController.getDocumentViewController().setAnnotationCallback(new org.icepdf(solutionController.getDocumentViewController()));
        submitted_panel = submittedPDF.buildViewerPanel();
        solution_panel = solutionPDF.buildViewerPanel();
        pdf_tabbed_pane.addTab("Submission", submitted_panel);
        pdf_tabbed_pane.addTab("Solution", solution_panel);
        java.lang.String[] paths = database.CourseAccess.accessSubmissionPath(courseID, act.getName());
        submittedController.openDocument(((((((paths[0]) + "/") + stud_id) + "/") + (act.getName())) + ".pdf"));
        solutionController.openDocument(paths[1]);
        grade_field.setText("");
        java.lang.Object[][] temp = database.CourseAccess.accessRubricItems(courseID, act.getName());
        if ((temp.length) != 0) {
            table = new java.lang.Object[temp.length][3];
            for (int i = 0 ; i < (table.length) ; i++) {
                table[i][0] = temp[i][0];
                table[i][1] = 0;
                table[i][2] = temp[i][1];
                max += ((float)(temp[i][1]));
            }
            javax.swing.table.DefaultTableModel tm = new javax.swing.table.DefaultTableModel(table, COLUMN_NAMES) {
                public boolean isCellEditable(int row, int column) {
                    if ((column == 0) || (column == 2))
                        return false;
                    
                    return true;
                }
            };
            tm.addTableModelListener(new javax.swing.event.TableModelListener() {
                public void tableChanged(javax.swing.event.TableModelEvent e) {
                    table_change_actionPerformed(e);
                }
            });
            rubric_table.setModel(tm);
        } 
        java.lang.Object[] grades = database.GradeAccess.accessGrades(courseID, act.getName(), stud_id);
        java.lang.System.out.println(grades.length);
        if ((grades.length) != 0) {
            for (int i = 0 ; i < (grades.length) ; i++) {
                table[i][1] = grades[i];
                java.lang.System.out.println(grades[i]);
            }
            javax.swing.table.DefaultTableModel tm = new javax.swing.table.DefaultTableModel(table, COLUMN_NAMES) {
                public boolean isCellEditable(int row, int column) {
                    if ((column == 0) || (column == 2))
                        return false;
                    
                    return true;
                }
            };
            tm.addTableModelListener(new javax.swing.event.TableModelListener() {
                public void tableChanged(javax.swing.event.TableModelEvent e) {
                    table_change_actionPerformed(e);
                }
            });
            rubric_table.setModel(tm);
            float gradeTotal = 0;
            for (int i = 0 ; i < (rubric_table.getRowCount()) ; i++)
                gradeTotal += java.lang.Float.parseFloat(rubric_table.getModel().getValueAt(i, 1).toString());
            java.lang.String currentGrade = "" + gradeTotal;
            grade_field.setText(currentGrade);
        } 
        java.lang.String maxField = "" + max;
        max_grade_field.setText(maxField);
        rubric_table.getColumnModel().getColumn(0).setPreferredWidth(500);
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        rubric_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rubric_table = new javax.swing.JTable();
        max_grade_field = new javax.swing.JTextField();
        grade_field = new javax.swing.JTextField();
        slash_label = new javax.swing.JLabel();
        total_label = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        student_name_label = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        student_id_label = new javax.swing.JLabel();
        next_button = new javax.swing.JButton();
        save_button = new javax.swing.JButton();
        pdf_tabbed_pane = new javax.swing.JTabbedPane();
        submitted_panel = new javax.swing.JPanel();
        solution_panel = new javax.swing.JPanel();
        rubric_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Rubric"));
        rubric_panel.setMinimumSize(new java.awt.Dimension(400 , 500));
        rubric_panel.setPreferredSize(new java.awt.Dimension(400 , 500));
        rubric_table.setModel(new javax.swing.table.DefaultTableModel(new java.lang.Object[][]{ new java.lang.Object[]{ null , null , null } }, new java.lang.String[]{ "Description" , "Grade" , "Max Grade" }) {
            java.lang.Class[] types = new java.lang.Class[]{ java.lang.String.class , java.lang.Integer.class , java.lang.Integer.class };

            public java.lang.Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        rubric_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(rubric_table);
        if ((rubric_table.getColumnModel().getColumnCount()) > 0) {
            rubric_table.getColumnModel().getColumn(1).setResizable(false);
            rubric_table.getColumnModel().getColumn(1).setPreferredWidth(8);
            rubric_table.getColumnModel().getColumn(2).setResizable(false);
            rubric_table.getColumnModel().getColumn(2).setPreferredWidth(10);
        } 
        max_grade_field.setFont(new java.awt.Font("Tahoma" , 0 , 24));
        max_grade_field.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        max_grade_field.setText("Max");
        grade_field.setFont(new java.awt.Font("Tahoma" , 0 , 24));
        grade_field.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grade_field.setText("Grade");
        slash_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slash_label.setText("/");
        total_label.setFont(new java.awt.Font("Tahoma" , 0 , 24));
        total_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_label.setText("Total:");
        name_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name_label.setText("Name:");
        student_name_label.setText("...");
        id_label.setText("...");
        student_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        student_id_label.setText("Student ID:");
        javax.swing.GroupLayout rubric_panelLayout = new javax.swing.GroupLayout(rubric_panel);
        rubric_panel.setLayout(rubric_panelLayout);
        rubric_panelLayout.setHorizontalGroup(rubric_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, java.lang.Short.MAX_VALUE).addGroup(rubric_panelLayout.createSequentialGroup().addComponent(total_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(grade_field, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(slash_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(max_grade_field, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(rubric_panelLayout.createSequentialGroup().addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(student_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)).addGroup(rubric_panelLayout.createSequentialGroup().addComponent(student_id_label, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(id_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)));
        rubric_panelLayout.setVerticalGroup(rubric_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(rubric_panelLayout.createSequentialGroup().addGroup(rubric_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(student_id_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(id_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)).addGap(9, 9, 9).addGroup(rubric_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(student_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(rubric_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(max_grade_field, javax.swing.GroupLayout.DEFAULT_SIZE, 47, java.lang.Short.MAX_VALUE).addComponent(slash_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(grade_field, javax.swing.GroupLayout.Alignment.TRAILING).addComponent(total_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE))));
        next_button.setText("Next");
        next_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_buttonActionPerformed(evt);
            }
        });
        save_button.setText("Save");
        save_button.setMaximumSize(new java.awt.Dimension(57 , 25));
        save_button.setMinimumSize(new java.awt.Dimension(57 , 25));
        save_button.setPreferredSize(new java.awt.Dimension(57 , 25));
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });
        submitted_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0 , 0 , 0)));
        submitted_panel.setMinimumSize(new java.awt.Dimension(400 , 500));
        submitted_panel.setPreferredSize(new java.awt.Dimension(400 , 500));
        javax.swing.GroupLayout submitted_panelLayout = new javax.swing.GroupLayout(submitted_panel);
        submitted_panel.setLayout(submitted_panelLayout);
        submitted_panelLayout.setHorizontalGroup(submitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, java.lang.Short.MAX_VALUE));
        submitted_panelLayout.setVerticalGroup(submitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, java.lang.Short.MAX_VALUE));
        solution_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0 , 0 , 0)));
        solution_panel.setMinimumSize(new java.awt.Dimension(400 , 500));
        solution_panel.setPreferredSize(new java.awt.Dimension(400 , 500));
        javax.swing.GroupLayout solution_panelLayout = new javax.swing.GroupLayout(solution_panel);
        solution_panel.setLayout(solution_panelLayout);
        solution_panelLayout.setHorizontalGroup(solution_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 581, java.lang.Short.MAX_VALUE));
        solution_panelLayout.setVerticalGroup(solution_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 580, java.lang.Short.MAX_VALUE));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addComponent(next_button, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(rubric_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(pdf_tabbed_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 588, java.lang.Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pdf_tabbed_pane).addGroup(layout.createSequentialGroup().addComponent(rubric_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 544, java.lang.Short.MAX_VALUE).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(next_button, javax.swing.GroupLayout.DEFAULT_SIZE, 50, java.lang.Short.MAX_VALUE).addComponent(save_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)))).addContainerGap()));
    }

    private void next_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String next_stud = gui.utils.GUIUtils.getNextStudent(stud_name, studentID, student_list);
        java.lang.String[] split_array = next_stud.split(" - ");
        java.lang.String next_name = split_array[0];
        java.lang.String next_number = split_array[1];
        int next_number_int = java.lang.Integer.parseInt(next_number);
        setOkToNav();
        gui.utils.GUIUtils.getMasterFrame(this).movePage(new gui.MarkingPDF(courseID , activity , next_number_int , next_name , student_list));
    }

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        for (int i = 0 ; i < (rubric_table.getColumnCount()) ; i++) {
            try {
                database.GradeAccess.enterGrade(studentID, courseID, actName, rubric_table.getModel().getValueAt(i, 0).toString(), java.lang.Float.parseFloat(rubric_table.getModel().getValueAt(i, 1).toString()));
            } catch (java.lang.NumberFormatException e) {
                e.printStackTrace();
            } catch (java.sql.SQLException e) {
                database.GradeAccess.updateGrade(studentID, courseID, actName, rubric_table.getModel().getValueAt(i, 0).toString(), java.lang.Float.parseFloat(rubric_table.getModel().getValueAt(i, 1).toString()));
            }
        }
        setOkToNav();
        javax.swing.JOptionPane.showMessageDialog(this, "Grade saved.");
    }

    private void table_change_actionPerformed(javax.swing.event.TableModelEvent e) {
        float grades = 0;
        for (int i = 0 ; i < (rubric_table.getRowCount()) ; i++)
            grades += java.lang.Float.parseFloat(rubric_table.getModel().getValueAt(i, e.getColumn()).toString());
        java.lang.String currentGrade = "" + grades;
        grade_field.setText(currentGrade);
    }

    private javax.swing.JTextField grade_field;

    private javax.swing.JLabel id_label;

    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JTextField max_grade_field;

    private javax.swing.JLabel name_label;

    private javax.swing.JButton next_button;

    private javax.swing.JTabbedPane pdf_tabbed_pane;

    private javax.swing.JPanel rubric_panel;

    private javax.swing.JTable rubric_table;

    private javax.swing.JButton save_button;

    private javax.swing.JLabel slash_label;

    private javax.swing.JPanel solution_panel;

    private javax.swing.JLabel student_id_label;

    private javax.swing.JLabel student_name_label;

    private javax.swing.JPanel submitted_panel;

    private javax.swing.JLabel total_label;
}

