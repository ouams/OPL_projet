package types;


public class Course {
    private java.lang.String courseName;

    private java.lang.String startDate;

    private java.lang.String endDate;

    private java.lang.String courseID;

    private types.Instructor instructor;

    private java.util.ArrayList<types.TATM> markers;

    private java.util.ArrayList<types.Student> students;

    private java.util.ArrayList<types.Activity> activities;

    public java.lang.String getCourseName() {
        return courseName;
    }

    public java.lang.String getStartDate() {
        return startDate;
    }

    public java.lang.String getEndDate() {
        return endDate;
    }

    public java.lang.String getCourseID() {
        return courseID;
    }

    public types.Instructor getInstructor() {
        return instructor;
    }

    public types.Account[] getTA() {
        types.Account[] tas = new types.Account[markers.size()];
        for (types.Account a : markers) {
            tas[markers.indexOf(a)] = a;
        }
        return tas;
    }

    public Course(java.lang.String n ,java.lang.String id ,types.Instructor ins ,java.lang.String start ,java.lang.String end) {
        courseName = n;
        courseID = id;
        instructor = ins;
        startDate = start;
        endDate = end;
        markers = new java.util.ArrayList<types.TATM>();
        students = new java.util.ArrayList<types.Student>();
        activities = new java.util.ArrayList<types.Activity>();
    }

    public void addMarker(types.TATM m) {
        java.util.ArrayList<types.TATM> a = new java.util.ArrayList<types.TATM>(1);
        a.add(m);
        updateMarkers(a);
    }

    public void addStudent(types.Student s) {
        java.util.ArrayList<types.Student> a = new java.util.ArrayList<types.Student>(1);
        a.add(s);
        updateStudents(a);
    }

    public void addActivity(types.Activity s) {
        java.util.ArrayList<types.Activity> a = new java.util.ArrayList<types.Activity>(1);
        a.add(s);
    }

    public void updateMarkers(java.util.ArrayList<types.TATM> t) {
        for (types.TATM i : t) {
            boolean c = markers.contains(i);
            if (c == true) {
            } else {
                markers.add(i);
            }
        }
        java.util.Collections.sort(markers, new java.util.Comparator<types.TATM>() {
            @java.lang.Override
            public int compare(types.TATM m1, types.TATM m2) {
                int o1 = m1.getEmpID();
                int o2 = m2.getEmpID();
                return o1 > o2 ? -1 : o1 == o2 ? 0 : 1;
            }
        });
    }

    public void updateStudents(java.util.ArrayList<types.Student> t) {
        for (types.Student i : t) {
            boolean c = students.contains(i);
            if (c == true) {
            } else {
                students.add(i);
            }
        }
        java.util.Collections.sort(students, new java.util.Comparator<types.Student>() {
            @java.lang.Override
            public int compare(types.Student s1, types.Student s2) {
                return 5;
            }
        });
    }
}

