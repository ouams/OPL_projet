package gui.types;


public abstract class MSPanel extends javax.swing.JPanel {
    protected static final int CANT_NAV = 42;

    private java.lang.String panel_title;

    private boolean ok_to_navigate;

    public MSPanel(java.lang.String panel_title) {
        this.panel_title = panel_title;
        ok_to_navigate = true;
    }

    public MSPanel(java.lang.String panel_title ,int nav_status) {
        this.panel_title = panel_title;
        if (nav_status == (CANT_NAV))
            ok_to_navigate = false;
        
    }

    public java.lang.String getPanelTitle() {
        return panel_title;
    }

    public boolean okToNav() {
        return ok_to_navigate;
    }

    public void setCantNav() {
        ok_to_navigate = false;
    }

    public void setOkToNav() {
        ok_to_navigate = true;
    }
}

