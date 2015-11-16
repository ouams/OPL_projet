package types;


public class SystemAdmin extends types.Account {
    public SystemAdmin(java.lang.String fn ,java.lang.String ln ,int empID ,java.lang.String un ,java.lang.String pass) {
        super(fn, ln, empID, un, pass, types.Account.Type.SYSTEMADMIN);
    }

    public void createAccount(java.lang.String fn, java.lang.String ln, int empID, java.lang.String un, java.lang.String pass, int type) {
        types.Account a;
        if (type == 1) {
            a = new types.SystemAdmin(fn , ln , empID , un , pass);
        } else if (type == 2) {
            a = new types.AcademicAdmin(fn , ln , empID , un , pass);
        } else if (type == 3) {
            a = new types.AssistantAdmin(fn , ln , empID , un , pass);
        } else if (type == 4) {
            a = new types.Instructor(fn , ln , empID , un , pass);
        } else if (type == 5) {
            a = new types.TATM(fn , ln , empID , un , pass);
        } 
    }
}

