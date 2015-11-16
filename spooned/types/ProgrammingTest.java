package types;


public class ProgrammingTest {
    private java.lang.String test_path;

    private java.lang.String console_input_path;

    private java.lang.String solution_path;

    private java.lang.String description;

    public ProgrammingTest(java.lang.String test) {
        test_path = test;
    }

    public ProgrammingTest(java.lang.String test ,java.lang.String console ,java.lang.String solution ,java.lang.String desc) {
        test_path = test;
        console_input_path = console;
        solution_path = solution;
        description = desc;
    }

    public java.lang.String getTestPath() {
        return test_path;
    }

    public java.lang.String getConsolenputPath() {
        return console_input_path;
    }

    public java.lang.String getSolutionPath() {
        return solution_path;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setTestPath(java.lang.String t) {
        test_path = t;
    }

    public void setConsolenputPath(java.lang.String t) {
        console_input_path = t;
    }

    public void set(java.lang.String t) {
        solution_path = t;
    }

    public void setDescription(java.lang.String t) {
        description = t;
    }
}

