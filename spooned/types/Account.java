package types;


public abstract class Account {
    public enum Type {
INSTRUCTOR, TATMMARKER, ACADEMICADMIN, ASSISTANTADMIN, SYSTEMADMIN;    }

    private static final int MAX_FAILS = 5;

    protected java.lang.String first_name;

    protected java.lang.String last_name;

    protected Type accountType;

    protected java.lang.String username;

    private java.lang.String password;

    protected boolean blocked;

    protected int empID;

    private int bad_logins;

    public Account(java.lang.String fn ,java.lang.String ln ,int empID ,java.lang.String un ,java.lang.String pass ,Type ut) {
        first_name = fn;
        last_name = ln;
        this.empID = empID;
        username = un;
        password = pass;
        setAccountType(ut);
        blocked = false;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public java.lang.String getFirstName() {
        return first_name;
    }

    public java.lang.String getLastName() {
        return last_name;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public int getEmpID() {
        return empID;
    }

    public Type getAccountType() {
        return accountType;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public java.lang.String getAccountTypeString() {
        java.lang.String toReturn = null;
        if ((accountType) == (Type.SYSTEMADMIN)) {
            toReturn = "System Administrator";
        } else if ((accountType) == (Type.ACADEMICADMIN)) {
            toReturn = "Academic Administrator";
        } else if ((accountType) == (Type.ASSISTANTADMIN)) {
            toReturn = "Assistant Academic Administrator";
        } else if ((accountType) == (Type.INSTRUCTOR)) {
            toReturn = "Instructor";
        } else if ((accountType) == (Type.TATMMARKER)) {
            toReturn = "TA/TM Marker";
        } else {
            toReturn = "Error: invalid account type";
        }
        return toReturn;
    }

    public boolean checkPassword(java.lang.String pass) {
        boolean toReturn = false;
        if (password.matches(pass)) {
            bad_logins = 0;
            toReturn = true;
        } else {
            (bad_logins)++;
            if ((bad_logins) >= (MAX_FAILS)) {
                java.lang.System.out.println("This account has been blocked due to the repeated number of failed logins.");
                blocked = true;
            } 
            toReturn = false;
        }
        return toReturn;
    }

    public void setUsername(java.lang.String name) {
        username = name;
    }

    public void setPassword(java.lang.String new_pass) {
        password = new_pass;
    }

    public void setAccountType(Type type) {
        accountType = type;
    }

    public int getAccountTypeAsInt() {
        int typeInt;
        if ((accountType) == (Type.INSTRUCTOR)) {
            typeInt = 4;
        } else if ((accountType) == (Type.TATMMARKER)) {
            typeInt = 5;
        } else if ((accountType) == (Type.ACADEMICADMIN)) {
            typeInt = 2;
        } else if ((accountType) == (Type.ASSISTANTADMIN)) {
            typeInt = 3;
        } else if ((accountType) == (Type.SYSTEMADMIN)) {
            typeInt = 1;
        } else {
            java.lang.System.out.println("Invalid account type");
            typeInt = 0;
        }
        return typeInt;
    }

    public void unblock() {
        blocked = false;
    }
}

