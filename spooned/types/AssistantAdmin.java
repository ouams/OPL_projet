package types;


public class AssistantAdmin extends types.Account {
    public AssistantAdmin(java.lang.String fn ,java.lang.String ln ,int empID ,java.lang.String un ,java.lang.String pass) {
        super(fn, ln, empID, un, pass, types.Account.Type.ASSISTANTADMIN);
    }

    public void createCourse(java.lang.String name, java.lang.String id, types.Instructor inst, java.lang.String start, java.lang.String end) {
        types.Course c = new types.Course(name , id , inst , start , end);
        inst.addCourse(c);
    }
}

