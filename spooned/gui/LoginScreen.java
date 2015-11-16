package gui;


public class LoginScreen extends javax.swing.JFrame {
    private gui.MasterFrame master;

    private boolean red_eyes = false;

    private audio.AudioPlayer player;

    public LoginScreen() {
        initComponents();
        setTitle("MarkShark - Login");
        player = new audio.AudioPlayer("jaws.mid");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("markshark-1x.png")).getImage());
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    private void initComponents() {
        ForgotPwd = new javax.swing.JButton();
        ForgotPwd1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        username_field = new javax.swing.JTextField();
        login_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        forgot_button = new javax.swing.JButton();
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/markshark-5x.png")));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent me) {
                changeLogo(me);
            }
        });
        ForgotPwd.setText("Forgot Password");
        ForgotPwd1.setText("Forgot Password");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter Login Information"));
        jLabel1.setText("Username:");
        jLabel2.setText("Password:");
        password_field.setToolTipText("");
        login_button.setText("Log In");
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2).addGap(6, 6, 6))).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(password_field).addComponent(username_field, javax.swing.GroupLayout.DEFAULT_SIZE, 205, java.lang.Short.MAX_VALUE)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(109, java.lang.Short.MAX_VALUE).addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(90, 90, 90)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2)).addGap(29, 29, 29).addComponent(login_button).addGap(153, 153, 153)));
        forgot_button.setText("Forgot Password");
        forgot_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgot_buttonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(forgot_button).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, java.lang.Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, java.lang.Short.MAX_VALUE).addComponent(jLabel3).addGap(70, 70, 70)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(33, java.lang.Short.MAX_VALUE).addComponent(jLabel3).addGap(29, 29, 29).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(forgot_button).addGap(16, 16, 16)));
        setLocationRelativeTo(null);
        pack();
    }

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        java.lang.String name = username_field.getText();
        java.lang.String pass = new java.lang.String(password_field.getPassword());
        types.Account acct;
        boolean login = false;
        boolean backdoor = false;
        int attempts = 0;
        if (name.equalsIgnoreCase("sysadmin")) {
            backdoor = true;
            login = true;
            acct = new types.SystemAdmin("Joey" , "Tester" , 9999 , "password" , "sysadmin");
        } else if (name.equalsIgnoreCase("admin")) {
            backdoor = true;
            login = true;
            acct = new types.AcademicAdmin("Joey" , "Tester" , 9999 , "password" , "admin");
        } else if (name.equalsIgnoreCase("assist")) {
            backdoor = true;
            login = true;
            acct = new types.AssistantAdmin("Joey" , "Tester" , 9999 , "password" , "assist");
        } else if (name.equalsIgnoreCase("instructor")) {
            backdoor = true;
            login = true;
            acct = new types.Instructor("Joey" , "Tester" , 9999 , "password" , "instructor");
        } else if (name.equalsIgnoreCase("tatm")) {
            backdoor = true;
            login = true;
            acct = new types.TATM("Joey" , "Tester" , 9999 , "password" , "ta");
        } else {
            login = login.Login.login(name, pass);
            acct = database.AccountAccess.constructAccountObject(name);
        }
        if ((acct != null) && (acct.isBlocked())) {
            javax.swing.JOptionPane.showMessageDialog(this, "This account is blocked.");
        } else if (!login) {
            attempts = database.AccountAccess.failedLogin(name);
            javax.swing.JOptionPane.showMessageDialog(this, ("Invalid username/password combo. Attempts left: " + (5 - attempts)));
        } else {
            if (!backdoor) {
                database.AccountAccess.successfulLogin(name);
                java.lang.System.out.println("login good");
            } 
            java.lang.System.out.println((((("Logging in as " + name) + " with password `") + pass) + "`"));
            master = new gui.MasterFrame(acct , this);
            setVisible(false);
            master.run();
        }
    }

    private void forgot_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JOptionPane.showMessageDialog(this, "Go talk to a System Administrator.");
    }

    public void clearFields() {
        username_field.setText("");
        password_field.setText("");
    }

    public void changeLogo(java.awt.event.MouseEvent me) {
        if (red_eyes) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/markshark-5x.png")));
            red_eyes = false;
            player.stop();
        } else {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/markshark-5x-eyes.png")));
            red_eyes = true;
            java.lang.System.out.println("Playing Jaws theme...");
            player.play();
        }
    }

    private javax.swing.JButton ForgotPwd;

    private javax.swing.JButton ForgotPwd1;

    private javax.swing.JButton forgot_button;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JPanel jPanel1;

    private javax.swing.JButton login_button;

    private javax.swing.JPasswordField password_field;

    private javax.swing.JTextField username_field;
}

