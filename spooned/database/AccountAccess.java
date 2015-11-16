package database;


public class AccountAccess {
    private static java.sql.Connection dbConnection;

    private static void establishConnection() {
        try {
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (java.lang.ClassNotFoundException e) {
            java.lang.System.out.println("No JDBC driver found, exiting.");
        }
        try {
            database.AccountAccess.dbConnection = java.sql.DriverManager.getConnection(("jdbc:sqlserver://cypress.csil.sfu.ca;" + " user = c275g01; password = TAA2Md7nGrPj2LjN"));
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println("Connection failed, exiting.");
        }
    }

    public static java.sql.ResultSet accessAccount(java.lang.String username) {
        java.lang.String query = ("SELECT * FROM c275g01A.dbo.Account WHERE Username = \'" + username) + "\'";
        return database.AccountAccess.execQuery(query);
    }

    public static java.lang.Object[] accessAccountList() {
        java.util.ArrayList<java.lang.String> accounts = new java.util.ArrayList<java.lang.String>();
        java.lang.String query = "SELECT Username FROM c275g01A.dbo.Account";
        java.sql.ResultSet res = database.AccountAccess.execQuery(query);
        try {
            while (res.next()) {
                accounts.add(res.getNString(1));
            }
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return accounts.toArray();
    }

    public static java.lang.Object[] accessAllTAs() {
        java.util.ArrayList<java.lang.String> accounts = new java.util.ArrayList<java.lang.String>();
        java.lang.String query = "SELECT EmployeeName, EmployeeID FROM " + "c275g01A.dbo.Account WHERE AccountType = 5";
        java.sql.ResultSet res = database.AccountAccess.execQuery(query);
        try {
            while (res.next()) {
                accounts.add((((res.getNString(1)) + " - ") + (res.getInt(2))));
            }
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return accounts.toArray();
    }

    public static java.lang.Object[] accessAllInstructors() {
        java.util.ArrayList<java.lang.String> accounts = new java.util.ArrayList<java.lang.String>();
        java.lang.String query = "SELECT EmployeeName,EmployeeID FROM " + "c275g01A.dbo.Account WHERE AccountType = 4";
        java.sql.ResultSet res = database.AccountAccess.execQuery(query);
        try {
            while (res.next()) {
                accounts.add((((res.getNString(1)) + " - ") + (res.getInt(2))));
            }
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return accounts.toArray();
    }

    public static java.lang.String accessUsername(int empID) {
        java.lang.String query = ("SELECT Username from c275g01A.dbo.Account WHERE EmployeeID = \'" + empID) + "\'";
        java.lang.String username = null;
        java.sql.ResultSet res = database.AccountAccess.execQuery(query);
        try {
            res.next();
            username = res.getNString(1);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return username;
    }

    public static types.Account constructAccountObject(java.lang.String username) {
        java.sql.ResultSet result = database.AccountAccess.accessAccount(username);
        types.Account account = null;
        try {
            result.next();
            java.lang.String uname = result.getNString(1);
            java.lang.String pass = result.getNString(2);
            int employee_id = result.getInt(3);
            java.lang.String employee_name = result.getNString(4);
            int type = result.getInt(5);
            java.lang.String[] names = employee_name.split("\\s+");
            java.lang.String fname = names[0];
            java.lang.String lname = names[1];
            java.lang.Boolean blocked = result.getBoolean(6);
            if (type == 1) {
                account = new types.SystemAdmin(fname , lname , employee_id , uname , pass);
            } else if (type == 2) {
                account = new types.AcademicAdmin(fname , lname , employee_id , uname , pass);
            } else if (type == 3) {
                account = new types.AssistantAdmin(fname , lname , employee_id , uname , pass);
            } else if (type == 4) {
                account = new types.Instructor(fname , lname , employee_id , uname , pass);
            } else if (type == 5) {
                account = new types.TATM(fname , lname , employee_id , uname , pass);
            } else {
                account = new types.TATM(fname , lname , employee_id , uname , pass);
                java.lang.System.out.println(("There was an error with account type; " + "account type set to TA/TM"));
            }
            account.setBlocked(blocked);
            return account;
        } catch (java.sql.SQLException ex) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (ex.getSQLState())) + "\nMessage: ") + (ex.getMessage())));
        }
        java.lang.System.out.println(("Returning a null account because something " + "failed while retrieving the account"));
        return account;
    }

    public static java.sql.ResultSet accessAllAccounts() {
        java.lang.String query = "SELECT Username FROM c275g01A.dbo.account";
        return database.AccountAccess.execQuery(query);
    }

    public static void createAccount(types.Account acct) {
        java.lang.String username = acct.getUsername();
        java.lang.String password = acct.getPassword();
        int empID = acct.getEmpID();
        java.lang.String empName = ((acct.getFirstName()) + " ") + (acct.getLastName());
        int acctType = acct.getAccountTypeAsInt();
        boolean blockFlag = acct.isBlocked();
        java.lang.String query = ((((((((((("INSERT INTO c275g01A.dbo.Account VALUES (\'" + username) + "\',\'") + password) + "\',") + empID) + ",\'") + empName) + "\',") + acctType) + ",") + (database.AccountAccess.boolToBit(blockFlag))) + ", 0)";
        database.AccountAccess.execUpdate(query);
    }

    public static void modifyAccount(java.lang.String accessUsername, types.Account acct) {
        java.lang.String username = acct.getUsername();
        java.lang.String password = acct.getPassword();
        int empID = acct.getEmpID();
        java.lang.String empName = ((acct.getFirstName()) + " ") + (acct.getLastName());
        int acctType = acct.getAccountTypeAsInt();
        boolean blockFlag = acct.isBlocked();
        java.lang.String query = ((((((((((((("UPDATE c275g01A.dbo.Account SET Username = \'" + username) + "\', Pass = \'") + password) + "\', EmployeeID = ") + empID) + ", EmployeeName = \'") + empName) + "\', AccountType = ") + acctType) + ", BlockAccountFlag = ") + (database.AccountAccess.boolToBit(blockFlag))) + "WHERE Username = \'") + accessUsername) + "\'";
        database.AccountAccess.execUpdate(query);
    }

    public static void deleteAccount(java.lang.String username) {
        java.lang.String query = ("DELETE FROM c275g01A.dbo.Account WHERE Username = \'" + username) + "\'";
        database.AccountAccess.execUpdate(query);
    }

    public static int failedLogin(java.lang.String username) {
        java.lang.String query = ("SELECT PWAttempts FROM c275g01A.dbo.Account WHERE Username = \'" + username) + "\'";
        java.sql.ResultSet res = database.AccountAccess.execQuery(query);
        int attempts = 0;
        try {
            res.next();
            attempts = res.getInt(1);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        attempts++;
        if (attempts < 5) {
            query = ((("UPDATE c275g01A.dbo.Account SET PWAttempts = " + attempts) + " WHERE Username = \'") + username) + "\'";
        } else {
            query = ((("UPDATE c275g01A.dbo.Account SET PWAttempts = " + attempts) + ", BlockAccountFlag = 1 WHERE Username = \'") + username) + "\'";
        }
        database.AccountAccess.execQuery(query);
        return attempts;
    }

    public static void successfulLogin(java.lang.String username) {
        java.lang.String query = ("UPDATE c275g01A.dbo.Account SET PWAttempts = 0 WHERE Username = \'" + username) + "\'";
        database.AccountAccess.execUpdate(query);
    }

    private static void execUpdate(java.lang.String query) {
        java.sql.PreparedStatement prepStatement = null;
        database.AccountAccess.establishConnection();
        try {
            prepStatement = database.AccountAccess.dbConnection.prepareStatement(query);
            prepStatement.executeUpdate();
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
    }

    private static java.sql.ResultSet execQuery(java.lang.String query) {
        java.sql.PreparedStatement prepStatement = null;
        java.sql.ResultSet resSet = null;
        database.AccountAccess.establishConnection();
        try {
            prepStatement = database.AccountAccess.dbConnection.prepareStatement(query);
            resSet = prepStatement.executeQuery();
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return resSet;
    }

    private static int boolToBit(boolean b) {
        return b ? 1 : 0;
    }
}

