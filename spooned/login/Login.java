package login;


public class Login {
    public static boolean login(java.lang.String username, java.lang.String password) {
        types.Account acct = null;
        java.lang.String acctPW = "";
        acct = database.AccountAccess.constructAccountObject(username);
        try {
            acctPW = acct.getPassword();
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("No account");
        }
        if (acctPW.equals(password)) {
            return true;
        } 
        java.lang.System.out.println("Failed login");
        return false;
    }
}

