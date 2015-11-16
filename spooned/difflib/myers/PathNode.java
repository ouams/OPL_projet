package difflib.myers;


public abstract class PathNode {
    public final int i;

    public final int j;

    public final difflib.myers.PathNode prev;

    public PathNode(int i ,int j ,difflib.myers.PathNode prev) {
        this.i = i;
        this.j = j;
        this.prev = prev;
    }

    public abstract boolean isSnake();

    public boolean isBootstrap() {
        return ((i) < 0) || ((j) < 0);
    }

    public final difflib.myers.PathNode previousSnake() {
        if (isBootstrap())
            return null;
        
        if ((!(isSnake())) && ((prev) != null))
            return prev.previousSnake();
        
        return this;
    }

    public java.lang.String toString() {
        java.lang.StringBuffer buf = new java.lang.StringBuffer("[");
        difflib.myers.PathNode node = this;
        while (node != null) {
            buf.append("(");
            buf.append(java.lang.Integer.toString(node.i));
            buf.append(",");
            buf.append(java.lang.Integer.toString(node.j));
            buf.append(")");
            node = node.prev;
        }
        buf.append("]");
        return buf.toString();
    }
}

