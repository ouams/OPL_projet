package difflib.myers;


public final class DiffNode extends difflib.myers.PathNode {
    public DiffNode(int i ,int j ,difflib.myers.PathNode prev) {
        super(i, j, (prev == null ? null : prev.previousSnake()));
    }

    public boolean isSnake() {
        return false;
    }
}

