package difflib.myers;


public final class Snake extends difflib.myers.PathNode {
    public Snake(int i ,int j ,difflib.myers.PathNode prev) {
        super(i, j, prev);
    }

    public boolean isSnake() {
        return true;
    }
}

