package types;


public class Instructor extends types.Marker {
    private java.util.ArrayList<types.Course> courses;

    public Instructor(java.lang.String fn ,java.lang.String ln ,int empID ,java.lang.String un ,java.lang.String pass) {
        super(fn, ln, empID, un, pass, types.Account.Type.INSTRUCTOR);
        courses = new java.util.ArrayList<types.Course>();
    }

    public void addCourse(types.Course c) {
        courses.add(c);
    }

    public void addRubricToActivty(types.Activity a, java.lang.String path) {
    }
}

