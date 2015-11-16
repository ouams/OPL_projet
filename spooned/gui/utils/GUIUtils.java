package gui.utils;


public abstract class GUIUtils {
    public static gui.MasterFrame getMasterFrame(java.awt.Component c) {
        if (c instanceof gui.MasterFrame) {
            return ((gui.MasterFrame)(c));
        } else {
            return gui.utils.GUIUtils.getMasterFrame(c.getParent());
        }
    }

    public static void centerFrame(javax.swing.JFrame f) {
        java.awt.GraphicsEnvironment env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
        java.awt.GraphicsDevice[] allDevices = env.getScreenDevices();
        int topLeftX;
        int topLeftY;
        int screenX;
        int screenY;
        int windowPosX;
        int windowPosY;
        topLeftX = allDevices[0].getDefaultConfiguration().getBounds().x;
        topLeftY = allDevices[0].getDefaultConfiguration().getBounds().y;
        screenX = allDevices[0].getDefaultConfiguration().getBounds().width;
        screenY = allDevices[0].getDefaultConfiguration().getBounds().height;
        windowPosX = ((screenX - (f.getWidth())) / 2) + topLeftX;
        windowPosY = ((screenY - (f.getHeight())) / 2) + topLeftY;
        f.setLocation(windowPosX, windowPosY);
    }

    public static void nothing() {
        java.lang.System.out.println("Do nothing.");
    }

    public static java.lang.String generatePassword() {
        java.security.SecureRandom random = new java.security.SecureRandom();
        java.lang.String pass = new java.math.BigInteger(30 , random).toString(32);
        return pass;
    }

    public static java.util.LinkedList<java.lang.String> lines(java.lang.String filename) {
        java.util.LinkedList<java.lang.String> lines = new java.util.LinkedList<java.lang.String>();
        java.lang.String line = "";
        try {
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(filename));
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static java.util.ArrayList<java.lang.String> generateArrayFromResultSet(java.sql.ResultSet rs, int index) {
        java.util.ArrayList<java.lang.String> list = new java.util.ArrayList<java.lang.String>();
        java.sql.Array a;
        try {
            while (rs.next()) {
                list.add(rs.getNString(index));
            }
        } catch (java.sql.SQLException e) {
            java.lang.System.out.println(((("SQL Exception occured, the state : " + (e.getSQLState())) + "\nMessage: ") + (e.getMessage())));
        }
        return list;
    }

    public static void generateGradeCSV(java.lang.String courseID, java.lang.String actName, java.lang.String path, java.lang.String name) {
        java.sql.ResultSet res = database.GradeAccess.accessGrades(courseID, actName);
        java.lang.String s = "";
        int x = 0;
        try {
            while (res.next()) {
                if (x == (res.getInt(1))) {
                    s += "," + (res.getFloat(2));
                } else {
                    if (x == 0)
                        s += ((res.getInt(1)) + ",") + (res.getFloat(2));
                    else
                        s += (("\n" + (res.getInt(1))) + ",") + (res.getFloat(2));
                    
                }
                x = res.getInt(1);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            java.io.PrintWriter out = new java.io.PrintWriter(((path + "/") + name));
            out.write(s);
            out.close();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static java.lang.String getNextStudent(java.lang.String name, int student_id, java.lang.Object[] array) {
        java.util.ArrayList<java.lang.String> string_arraylist = new java.util.ArrayList();
        int index;
        for (java.lang.Object n : array)
            string_arraylist.add(((java.lang.String)(n)));
        java.lang.String line = (name + " - ") + (java.lang.Integer.toString(student_id));
        index = string_arraylist.indexOf(line);
        if (index == (-1))
            return null;
        else
            return string_arraylist.get((index + 1));
        
    }
}

