package types;


public class Rubric {
    private java.util.ArrayList<types.RubricItem> items;

    public Rubric(java.lang.String file) {
        items = new java.util.ArrayList<types.RubricItem>();
    }

    public Rubric(boolean pass) {
        items = new java.util.ArrayList<types.RubricItem>(1);
        items.add(new types.RubricItem("This assignment is pass/fail" , 1));
    }

    public void addItem(java.lang.String desc, int max) {
        types.RubricItem r = new types.RubricItem(desc , max);
        items.add(r);
    }
}

