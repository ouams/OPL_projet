package types;


public class AcademicAdmin extends types.Marker {
    public AcademicAdmin(java.lang.String fn ,java.lang.String ln ,int empID ,java.lang.String un ,java.lang.String pass) {
        super(fn, ln, empID, un, pass, types.Account.Type.ACADEMICADMIN);
    }
}

