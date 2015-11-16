package database;


public class CourseAccess {
    private static java.sql.Connection dbConnection;

    public static java.lang.Object[] accessCourseList() {
        java.util.ArrayList<java.lang.String> courseIDs = new java.util.ArrayList<java.lang.String>();
        java.lang.String query = "SELECT CourseID FROM c275g01A.dbo.Course";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        try {
            while (res.next()) {
                courseIDs.add(res.getNString(1));
            }
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return courseIDs.toArray();
    }

    public static java.lang.Object[] accessCourseList(int instID) {
        java.util.ArrayList<java.lang.String> courseIDs = new java.util.ArrayList<java.lang.String>();
        java.lang.String query = ("SELECT CourseID FROM c275g01A.dbo.Course WHERE InstructorID = \'" + instID) + "\'";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        try {
            while (res.next()) {
                courseIDs.add(res.getNString(1));
            }
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return courseIDs.toArray();
    }

    public static java.lang.Object[] accessCourseListTA(int emplID) {
        java.util.ArrayList<java.lang.String> courseIDs = new java.util.ArrayList<java.lang.String>();
        java.lang.String query = ("SELECT CourseID FROM c275g01A.dbo.TeachingAssistant WHERE EmployeeID = \'" + emplID) + "\'";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        try {
            while (res.next()) {
                courseIDs.add(res.getNString(1));
            }
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return courseIDs.toArray();
    }

    public static java.sql.ResultSet accessCourse(java.lang.String courseID) {
        java.lang.String query = ("SELECT * FROM c275g01A.dbo.Course WHERE CourseID = \'" + courseID) + "\'";
        return database.CourseAccess.execQuery(query);
    }

    public static void createCourse(types.Course course) {
        java.lang.String courseID = course.getCourseID();
        java.lang.String courseName = course.getCourseName();
        java.lang.String instructorName = ((course.getInstructor().getFirstName()) + " ") + (course.getInstructor().getLastName());
        int instructorID = course.getInstructor().getEmpID();
        java.lang.String startDate = course.getStartDate();
        java.lang.String endDate = course.getEndDate();
        java.lang.String query = ((((((((((("INSERT INTO c275g01A.dbo.Course VALUES (\'" + courseID) + "\',\'") + courseName) + "\',\'") + instructorName) + "\',") + instructorID) + ",\'") + startDate) + "\',\'") + endDate) + "\')";
        database.CourseAccess.execUpdate(query);
    }

    public static void modifyCourse(java.lang.String accessID, types.Course course) {
        java.lang.String courseID = course.getCourseID();
        java.lang.String courseName = course.getCourseName();
        java.lang.String instructorName = ((course.getInstructor().getFirstName()) + " ") + (course.getInstructor().getLastName());
        int instructorID = course.getInstructor().getEmpID();
        java.lang.String startDate = course.getStartDate();
        java.lang.String endDate = course.getEndDate();
        java.lang.String query = ((((((((((((("UPDATE c275g01A.dbo.Course SET CourseID=\'" + courseID) + "\',CourseName=\'") + courseName) + "\',InstructorName=\'") + instructorName) + "\',InstructorID=") + instructorID) + ",StartDate=\'") + startDate) + "\',EndDate=\'") + endDate) + "\' WHERE CourseID=\'") + accessID) + "\'";
        database.CourseAccess.execUpdate(query);
    }

    public static boolean deleteCourse(java.lang.String courseID) {
        java.lang.String query = ("SELECT * FROM c275g01A.dbo.Activity WHERE CourseID = \'" + courseID) + "\'";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        try {
            boolean test = res.next();
            if (!test) {
                query = ("DELETE FROM c275g01A.dbo.Course WHERE CourseID = \'" + courseID) + "\'";
                database.CourseAccess.execUpdate(query);
                return true;
            } else {
                return false;
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @java.lang.SuppressWarnings(value = "unused")
    public static types.Course constructCourseObject(java.lang.String cID) {
        types.Course course = null;
        java.sql.ResultSet rs = null;
        java.lang.String courseName = null;
        java.lang.String courseID = null;
        java.lang.String instructorName = null;
        int instructorID;
        java.sql.Date startDate = null;
        java.sql.Date endDate = null;
        types.Instructor ins = null;
        java.util.ArrayList<types.TATM> markers = new java.util.ArrayList<types.TATM>();
        int taEID;
        java.lang.String taEName = null;
        java.util.ArrayList<types.Student> students = new java.util.ArrayList<types.Student>();
        int sID;
        java.lang.String sName = null;
        java.util.ArrayList<types.Activity> activities = new java.util.ArrayList<types.Activity>();
        java.lang.String aName = null;
        java.lang.String aDesc = null;
        java.lang.String sSolnPath = null;
        java.lang.String solnPath = null;
        java.lang.String aLang;
        boolean groupAct;
        boolean aType;
        rs = database.CourseAccess.accessCourse(cID);
        try {
            rs.next();
            courseName = rs.getNString("CourseName");
            courseID = cID;
            instructorName = rs.getNString("InstructorName");
            instructorID = rs.getInt("InstructorID");
            startDate = rs.getDate("StartDate");
            endDate = rs.getDate("EndDate");
            java.lang.String[] names = instructorName.split("\\s+");
            java.lang.String fname = names[0];
            java.lang.String lname = "";
            if ((names.length) > 1)
                lname = names[1];
            
            ins = new types.Instructor(fname , lname , instructorID , null , null);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        course = new types.Course(courseName , cID , ins , startDate.toString() , endDate.toString());
        rs = database.CourseAccess.accessTAs(cID);
        if (rs != null) {
            try {
                while (rs.next()) {
                    taEID = rs.getInt("EmployeeID");
                    taEName = rs.getNString("EmployeeName");
                    java.lang.System.out.println(taEName);
                    java.lang.String[] names = taEName.split("\\s+");
                    java.lang.String fname = names[0];
                    java.lang.String lname = names[1];
                    types.TATM temp = new types.TATM(fname , lname , taEID , null , null);
                    course.addMarker(temp);
                }
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        } 
        rs = database.CourseAccess.accessCourseActivities(cID);
        if (rs != null) {
            try {
                while (rs.next()) {
                    aName = rs.getNString("ActivityName");
                    aDesc = rs.getNString("ActivityDesc");
                    sSolnPath = rs.getNString("StudentSolnPath");
                    solnPath = rs.getNString("SolnPath");
                    aLang = rs.getNString("ActivityLang");
                    aType = rs.getBoolean("ActivityType");
                    groupAct = rs.getBoolean("GroupAct");
                    int numTests = rs.getInt("NumTests");
                    java.sql.Date dueDate = rs.getDate("DueDate");
                    types.Activity temp = new types.Activity(aName , aDesc , sSolnPath , solnPath , aLang , dueDate.toString() , aType , groupAct , numTests);
                    course.addActivity(temp);
                }
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        } 
        return course;
    }

    public static java.lang.Object[] accessStudentList(java.lang.String courseID) {
        java.util.ArrayList<java.lang.String> students = new java.util.ArrayList<java.lang.String>();
        java.lang.String query = (("SELECT StudentName,StudentID FROM c275g01A.dbo.Student " + "WHERE CourseID = \'") + courseID) + "\'";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        try {
            while (res.next()) {
                java.lang.String name = res.getNString(1);
                int id = res.getInt(2);
                students.add(((name + " - ") + id));
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return students.toArray();
    }

    public static void clearStudentList(java.lang.String courseID) {
        java.lang.String query = ("DELETE FROM c275g01A.dbo.Student WHERE CourseID = \'" + courseID) + "\'";
        database.CourseAccess.execUpdate(query);
    }

    public static void addStudent(java.lang.String studentName, int studentID, java.lang.String courseID) {
        java.lang.String query = ((((("INSERT INTO c275g01A.dbo.Student VALUES (\'" + studentName) + "\',") + studentID) + ",\'") + courseID) + "\')";
        database.CourseAccess.execUpdate(query);
    }

    public static java.sql.ResultSet accessCourseActivities(java.lang.String courseID) {
        java.lang.String query = ("SELECT * FROM c275g01A.dbo.Activity WHERE CourseID = \'" + courseID) + "\'";
        return database.CourseAccess.execQuery(query);
    }

    public static java.lang.Object[] accessActivityList(java.lang.String courseID) {
        java.util.ArrayList<java.lang.String> activities = new java.util.ArrayList<java.lang.String>();
        java.lang.String query = ("SELECT * FROM c275g01A.dbo.Activity WHERE CourseID = \'" + courseID) + "\'";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        try {
            while (res.next()) {
                activities.add(res.getNString("ActivityName"));
            }
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return activities.toArray();
    }

    public static java.sql.ResultSet accessActivity(java.lang.String courseID, java.lang.String activityName) {
        java.lang.String query = ((("SELECT * FROM c275g01A.dbo.Activity WHERE CourseID = \'" + courseID) + "\' AND ActivityName = \'") + activityName) + "\'";
        return database.CourseAccess.execQuery(query);
    }

    public static types.Activity constructActivityObject(java.lang.String courseID, java.lang.String activityName) {
        java.sql.ResultSet res = database.CourseAccess.accessActivity(courseID, activityName);
        types.Activity act = null;
        try {
            res.next();
            java.lang.String aName = res.getNString("ActivityName");
            java.lang.String aDesc = res.getNString("ActivityDesc");
            java.lang.String sSolnPath = res.getNString("StudentSolnPath");
            java.lang.String solnPath = res.getNString("SolnPath");
            java.lang.String aLang = res.getNString("ActivityLang");
            java.lang.String dueDate = res.getDate("DueDate").toString();
            boolean aType = res.getBoolean("ActivityType");
            boolean groupAct = res.getBoolean("GroupAct");
            int numTests = res.getInt("NumTests");
            act = new types.Activity(aName , aDesc , sSolnPath , solnPath , aLang , dueDate , aType , groupAct , numTests);
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return act;
    }

    public static java.lang.String[] accessSubmissionPath(java.lang.String courseID, java.lang.String actName) {
        java.lang.String[] paths = new java.lang.String[2];
        java.lang.String query = ((("SELECT StudentSolnPath,SolnPath FROM c275g01A.dbo.Activity WHERE CourseID = \'" + courseID) + "\' AND ActivityName = \'") + actName) + "\'";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        try {
            res.next();
            paths[0] = res.getNString(1);
            paths[1] = res.getNString(2);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return paths;
    }

    public static void addActivity(java.lang.String courseID, types.Activity act) {
        java.lang.String activityName = act.getName();
        java.lang.String activityDesc = act.getActivityDesc();
        java.lang.String studentSolnPath = act.getStudentSubPath();
        java.lang.String solnPath = act.getSolnPath();
        java.lang.String activityLang = act.getLanguage();
        boolean activityType = act.isProgramming();
        boolean group = act.isGroup();
        int numTests = act.getNumOfTests();
        java.lang.String dueDate = act.getDueDate();
        java.lang.String query = ((((((((((((((((((("INSERT INTO c275g01A.dbo.Activity VALUES (\'" + courseID) + "\',\'") + activityName) + "\',\'") + activityDesc) + "\',\'") + activityLang) + "\',") + (database.CourseAccess.boolToBit(activityType))) + ",") + (database.CourseAccess.boolToBit(group))) + ",\'") + studentSolnPath) + "\',\'") + solnPath) + "\',") + numTests) + ",\'") + dueDate) + "\')";
        database.CourseAccess.execUpdate(query);
    }

    public static void modifyActivity(java.lang.String courseID, java.lang.String accessName, types.Activity act) {
        java.lang.String activityName = act.getName();
        java.lang.String activityDesc = act.getActivityDesc();
        java.lang.String studentSolnPath = act.getStudentSubPath();
        java.lang.String solnPath = act.getSolnPath();
        java.lang.String activityLang = act.getLanguage();
        boolean activityType = act.isProgramming();
        boolean group = act.isGroup();
        int numTests = act.getNumOfTests();
        java.lang.String dueDate = act.getDueDate();
        java.lang.String query = ((((((((((((((((((((("UPDATE c275g01A.dbo.Activity SET ActivityName=\'" + activityName) + "\',ActivityDesc=\'") + activityDesc) + "\',ActivityLang=\'") + activityLang) + "\',activityType=") + (database.CourseAccess.boolToBit(activityType))) + ",GroupAct=") + (database.CourseAccess.boolToBit(group))) + ",StudentSolnPath=\'") + studentSolnPath) + "\',SolnPath=\'") + solnPath) + "\',NumTests=") + numTests) + ",DueDate = \'") + dueDate) + "\' WHERE CourseID = \'") + courseID) + "\' AND ActivityName = \'") + accessName) + "\'";
        database.CourseAccess.execUpdate(query);
    }

    public static void deleteActivity(java.lang.String courseID, java.lang.String activityName) {
        java.lang.String query = ((("DELETE FROM c275g01A.dbo.Activity WHERE CourseID = \'" + courseID) + "\' AND ActivityName = \'") + activityName) + "\'";
        database.CourseAccess.execUpdate(query);
    }

    public static java.sql.ResultSet accessTAs(java.lang.String courseID) {
        java.lang.String query = ("SELECT EmployeeID, EmployeeName FROM c275g01A.dbo.TeachingAssistant WHERE CourseID = \'" + courseID) + "\'";
        return database.CourseAccess.execQuery(query);
    }

    public static void addTA(java.lang.String courseID, int empID, java.lang.String empName) {
        java.lang.String query = ((((("INSERT INTO c275g01A.dbo.TeachingAssistant VALUES (\'" + courseID) + "\',") + empID) + ",\'") + empName) + "\')";
        database.CourseAccess.execUpdate(query);
    }

    public static void clearTAs(java.lang.String courseID) {
        java.lang.String query = ("DELETE FROM c275g01A.dbo.TeachingAssistant WHERE CourseID = \'" + courseID) + "\'";
        database.CourseAccess.execUpdate(query);
    }

    public static java.sql.ResultSet accessRubric(java.lang.String courseID, java.lang.String activityName) {
        java.lang.String query = ((("SELECT RubricItem, MaxGrade FROM c275g01A.dbo.Rubric WHERE CourseID = \'" + courseID) + "\' AND ActivityName = \'") + activityName) + "\'";
        return database.CourseAccess.execQuery(query);
    }

    public static java.lang.Object[][] accessRubricItems(java.lang.String courseID, java.lang.String actName) {
        java.sql.ResultSet res = database.CourseAccess.accessRubric(courseID, actName);
        java.lang.Object[][] rubric = null;
        int i = 0;
        try {
            while (res.next())
                i++;
            res = database.CourseAccess.accessRubric(courseID, actName);
            rubric = new java.lang.Object[i][2];
            i = 0;
            while (res.next()) {
                rubric[i][0] = res.getNString(1);
                rubric[i][1] = res.getFloat(2);
                i++;
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return rubric;
    }

    public static void addRubricItem(java.lang.String courseID, java.lang.String activityName, java.lang.String rubricItem, float maxGrade) {
        java.lang.String query = ((((((("INSERT INTO c275g01A.dbo.Rubric VALUES (\'" + courseID) + "\',\'") + activityName) + "\',\'") + rubricItem) + "\',") + maxGrade) + ")";
        database.CourseAccess.execUpdate(query);
    }

    public static void deleteRubric(java.lang.String courseID, java.lang.String activityName) {
        java.lang.String query = ((("DELETE FROM c275g01A.dbo.Rubric WHERE CourseID = \'" + courseID) + "\' AND ActivityName = \'") + activityName) + "\'";
        database.CourseAccess.execUpdate(query);
    }

    public static java.lang.String accessTestIn(java.lang.String courseID, java.lang.String actName) {
        java.lang.String query = ((("SELECT TestInput FROM c275g01A.dbo.ProgTests WHERE CourseID = \'" + courseID) + "\' AND ActivityName = \'") + actName) + "\'";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        java.lang.String test = "";
        try {
            if (res.next())
                test = res.getNString("TestInput");
            
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static java.lang.String accessTestOut(java.lang.String courseID, java.lang.String actName) {
        java.lang.String query = ((("SELECT TestOutput FROM c275g01A.dbo.ProgTests WHERE CourseID = \'" + courseID) + "\' AND ActivityName = \'") + actName) + "\'";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        java.lang.String test = "";
        try {
            if (res.next())
                test = res.getNString("TestOutput");
            
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static void addTest(java.lang.String courseID, types.Activity act, java.lang.String testIn, java.lang.String testOut) {
        java.lang.String query = ((("SELECT * FROM c275g01A.dbo.ProgTests WHERE CourseID = \'" + courseID) + "\' AND ActivityName = \'") + (act.getName())) + "\'";
        java.sql.ResultSet res = database.CourseAccess.execQuery(query);
        java.lang.System.out.println(((courseID + ",") + (act.getName())));
        try {
            if (res.next()) {
                java.lang.System.out.println("update");
                query = ((((((("UPDATE c275g01A.dbo.ProgTests SET TestInput = \'" + testIn) + "\',TestOutput = \'") + testOut) + "\' WHERE CourseID = \'") + courseID) + "\' AND ActivityName = \'") + (act.getName())) + "\'";
                database.CourseAccess.execUpdate(query);
            } else {
                java.lang.System.out.println("insert");
                query = ((((((("INSERT INTO c275g01A.dbo.ProgTests VALUES (\'" + courseID) + "\',\'") + (act.getName())) + "\',\'") + testIn) + "\',\'") + testOut) + "\')";
                database.CourseAccess.execUpdate(query);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTests(java.lang.String courseID, types.Activity act) {
        java.lang.String query = ((("DELETE FROM c275g01A.dbo.ProgTests WHERE CourseID = \'" + courseID) + "\' AND ActivityName = \'") + (act.getName())) + "\'";
        database.CourseAccess.execUpdate(query);
    }

    private static void execUpdate(java.lang.String query) {
        java.sql.PreparedStatement prepStatement = null;
        database.CourseAccess.establishConnection();
        try {
            prepStatement = database.CourseAccess.dbConnection.prepareStatement(query);
            prepStatement.executeUpdate();
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
    }

    private static java.sql.ResultSet execQuery(java.lang.String query) {
        java.sql.PreparedStatement prepStatement = null;
        java.sql.ResultSet resSet = null;
        database.CourseAccess.establishConnection();
        try {
            prepStatement = database.CourseAccess.dbConnection.prepareStatement(query);
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
            database.CourseAccess.dbConnection = java.sql.DriverManager.getConnection(("jdbc:sqlserver://cypress.csil.sfu.ca;" + " user = c275g01; password = TAA2Md7nGrPj2LjN"));
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println("Connection failed, exiting.");
        }
    }

    private static int boolToBit(boolean b) {
        return b ? 1 : 0;
    }
}

