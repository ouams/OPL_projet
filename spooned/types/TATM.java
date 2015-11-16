package types;


public class TATM extends types.Marker {
    public TATM(java.lang.String fn ,java.lang.String ln ,int empID ,java.lang.String un ,java.lang.String pass) {
        super(fn, ln, empID, un, pass, types.Account.Type.TATMMARKER);
    }
}

