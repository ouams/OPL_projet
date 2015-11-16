package database;


public class GradeAccess {
    private static java.sql.Connection dbConnection;

    private static void establishConnection() {
        try {
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (java.lang.ClassNotFoundException e) {
            java.lang.System.out.println("No JDBC driver found, exiting.");
        }
        try {
            database.GradeAccess.dbConnection = java.sql.DriverManager.getConnection(("jdbc:sqlserver://cypress.csil.sfu.ca;" + " user = c275g01; password = TAA2Md7nGrPj2LjN"));
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println("Connection failed, exiting.");
        }
    }

    public static java.sql.ResultSet accessGrades(java.lang.String courseID, java.lang.String actName) {
        java.lang.String query = (((("SELECT StudentID,Grade FROM c275g01A.dbo.Grades WHERE" + " CourseID = \'") + courseID) + "\' AND ActivityName = \'") + actName) + "\' ORDER BY StudentID,RubricItem";
        return database.GradeAccess.execQuery(query);
    }

    public static java.lang.Object[] accessGrades(java.lang.String courseID, java.lang.String actName, int studentID) {
        java.util.ArrayList<java.lang.Float> grades = new java.util.ArrayList<java.lang.Float>();
        java.lang.String query = ((((("SELECT Grade FROM c275g01A.dbo.Grades WHERE" + " CourseID = \'") + courseID) + "\' AND ActivityName = \'") + actName) + "\' AND StudentID = ") + studentID;
        java.sql.ResultSet res = database.GradeAccess.execQuery(query);
        try {
            while (res.next())
                grades.add(res.getFloat(1));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return grades.toArray();
    }

    public static void enterGrade(int studentID, java.lang.String courseID, java.lang.String actName, java.lang.String rubricItem, float grade) throws java.sql.SQLException {
        java.lang.String query = ((((((((("INSERT INTO c275g01A.dbo.Grades VALUES (\'" + courseID) + "\',\'") + actName) + "\',\'") + rubricItem) + "\',") + studentID) + ",") + grade) + ")";
        java.sql.PreparedStatement prepStatement;
        database.GradeAccess.establishConnection();
        prepStatement = database.GradeAccess.dbConnection.prepareStatement(query);
        prepStatement.executeUpdate();
    }

    public static void updateGrade(int studentID, java.lang.String courseID, java.lang.String actName, java.lang.String rubricItem, float grade) {
        java.lang.String query = ((((((((("UPDATE c275g01A.dbo.Grades SET Grade = " + grade) + " WHERE StudentID = \'") + studentID) + "\' AND CourseID = \'") + courseID) + "\' AND ActivityName = \'") + actName) + "\' AND RubricItem = \'") + rubricItem) + "\'";
        database.GradeAccess.execUpdate(query);
    }

    private static void execUpdate(java.lang.String query) {
        java.sql.PreparedStatement prepStatement = null;
        database.GradeAccess.establishConnection();
        try {
            prepStatement = database.GradeAccess.dbConnection.prepareStatement(query);
            prepStatement.executeUpdate();
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
    }

    private static java.sql.ResultSet execQuery(java.lang.String query) {
        java.sql.PreparedStatement prepStatement = null;
        java.sql.ResultSet resSet = null;
        database.GradeAccess.establishConnection();
        try {
            prepStatement = database.GradeAccess.dbConnection.prepareStatement(query);
            resSet = prepStatement.executeQuery();
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return resSet;
    }
}

