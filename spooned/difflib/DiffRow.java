package difflib;


public class DiffRow {
    private Tag tag;

    private java.lang.String oldLine;

    private java.lang.String newLine;

    public DiffRow(Tag tag ,java.lang.String oldLine ,java.lang.String newLine) {
        this.tag = tag;
        this.oldLine = oldLine;
        this.newLine = newLine;
    }

    public enum Tag {
INSERT, DELETE, CHANGE, EQUAL;    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public java.lang.String getOldLine() {
        return oldLine;
    }

    public void setOldLine(java.lang.String oldLine) {
        this.oldLine = oldLine;
    }

    public java.lang.String getNewLine() {
        return newLine;
    }

    public void setNewLine(java.lang.String newLine) {
        this.newLine = newLine;
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((newLine) == null ? 0 : newLine.hashCode());
        result = (prime * result) + ((oldLine) == null ? 0 : oldLine.hashCode());
        result = (prime * result) + ((tag) == null ? 0 : tag.hashCode());
        return result;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if ((this) == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if ((getClass()) != (obj.getClass()))
            return false;
        
        difflib.DiffRow other = ((difflib.DiffRow)(obj));
        if ((newLine) == null) {
            if ((other.newLine) != null)
                return false;
            
        } else if (!(newLine.equals(other.newLine)))
            return false;
        
        if ((oldLine) == null) {
            if ((other.oldLine) != null)
                return false;
            
        } else if (!(oldLine.equals(other.oldLine)))
            return false;
        
        if ((tag) == null) {
            if ((other.tag) != null)
                return false;
            
        } else if (!(tag.equals(other.tag)))
            return false;
        
        return true;
    }

    public java.lang.String toString() {
        return ((((("[" + (this.tag)) + ",") + (this.oldLine)) + ",") + (this.newLine)) + "]";
    }
}

