package database;


public class Dbaccess {
    private static java.sql.Connection dbConnection;

    public static void backupdatabase(java.lang.String filepath) {
        java.lang.String query = ("BACKUP DATABASE c275g01A TO DISK = \'" + filepath) + "wiresharkbackup.BAK\'";
        database.Dbaccess.execUpdate(query);
    }

    public static void restoredatabase(java.lang.String filepath) {
        java.lang.String query = ("RESTORE DATABASE c275g01A FROM DISK = \'" + filepath) + "\'";
        database.Dbaccess.execUpdate(query);
    }

    private static void execUpdate(java.lang.String query) {
        java.sql.PreparedStatement prepStatement = null;
        database.Dbaccess.establishConnection();
        try {
            prepStatement = database.Dbaccess.dbConnection.prepareStatement(query);
            prepStatement.executeUpdate();
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
    }

    private static java.sql.ResultSet execQuery(java.lang.String query) {
        java.sql.PreparedStatement prepStatement = null;
        java.sql.ResultSet resSet = null;
        database.Dbaccess.establishConnection();
        try {
            prepStatement = database.Dbaccess.dbConnection.prepareStatement(query);
            resSet = prepStatement.executeQuery();
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return resSet;
    }

    private static void establishConnection() {
        try {
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (java.lang.ClassNotFoundException e) {
            java.lang.System.out.println("No JDBC driver found, exiting.");
        }
        try {
            database.Dbaccess.dbConnection = java.sql.DriverManager.getConnection(("jdbc:sqlserver://cypress.csil.sfu.ca;" + " user = c275g01; password = TAA2Md7nGrPj2LjN"));
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println("Connection failed, exiting.");
        }
    }

    private static int boolToBit(boolean b) {
        return b ? 1 : 0;
    }
}

