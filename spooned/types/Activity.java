package types;


public class Activity {
    private java.lang.String name;

    private java.lang.String solnPath;

    private java.lang.String studentSubPath;

    private java.lang.String due_date;

    private java.lang.String activityDesc;

    private java.lang.String language;

    private int num_of_tests;

    private int num_of_files;

    private boolean isProgramming;

    private boolean isGroup;

    private java.util.ArrayList<types.ProgrammingTest> tests;

    private types.Rubric rubric;

    public Activity(java.lang.String n ,java.lang.String desc ,java.lang.String studPath ,java.lang.String soln ,java.lang.String lang ,java.lang.String dueDate ,boolean p ,boolean g ,int numTests) {
        name = n;
        activityDesc = desc;
        studentSubPath = studPath;
        solnPath = soln;
        language = lang;
        isProgramming = p;
        isGroup = g;
        num_of_tests = numTests;
        due_date = dueDate;
        isProgramming = p;
        isGroup = g;
        tests = new java.util.ArrayList<types.ProgrammingTest>();
    }

    public java.lang.String getActivityDesc() {
        return activityDesc;
    }

    public java.lang.String getStudentSubPath() {
        return studentSubPath;
    }

    public java.lang.String getSolnPath() {
        return solnPath;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getLanguage() {
        return language;
    }

    public java.lang.String getDueDate() {
        return due_date;
    }

    public boolean isProgramming() {
        return isProgramming;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public int getNumOfTests() {
        return num_of_tests;
    }

    public java.util.ArrayList<types.ProgrammingTest> getTests() {
        return tests;
    }

    public void setDueDate(java.lang.String date) {
        due_date = date;
    }

    public void addProgrammingTest(java.lang.String test) {
        types.ProgrammingTest p = new types.ProgrammingTest(test);
        tests.add(p);
        isProgramming = true;
    }

    public void addMultipleTests(java.util.ArrayList<types.ProgrammingTest> t) {
        for (types.ProgrammingTest p : t) {
            if (tests.contains(p)) {
            } else {
                tests.add(p);
            }
        }
    }

    public void setIsGroup(boolean b) {
        isGroup = b;
    }
}

