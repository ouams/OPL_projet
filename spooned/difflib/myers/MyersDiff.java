package difflib.myers;


public class MyersDiff<T> implements difflib.DiffAlgorithm<T> {
    private final difflib.myers.Equalizer<T> DEFAULT_EQUALIZER = new difflib.myers.Equalizer<T>() {
        public boolean equals(final T original, final T revised) {
            return original.equals(revised);
        }
    };

    private final difflib.myers.Equalizer<T> equalizer;

    public MyersDiff() {
        equalizer = DEFAULT_EQUALIZER;
    }

    public MyersDiff(final difflib.myers.Equalizer<T> equalizer) {
        if (equalizer == null) {
            throw new java.lang.IllegalArgumentException("equalizer must not be null");
        } 
        this.equalizer = equalizer;
    }

    public difflib.Patch<T> diff(final T[] original, final T[] revised) {
        return diff(java.util.Arrays.asList(original), java.util.Arrays.asList(revised));
    }

    public difflib.Patch<T> diff(final java.util.List<T> original, final java.util.List<T> revised) {
        if (original == null) {
            throw new java.lang.IllegalArgumentException("original list must not be null");
        } 
        if (revised == null) {
            throw new java.lang.IllegalArgumentException("revised list must not be null");
        } 
        difflib.myers.PathNode path;
        try {
            path = buildPath(original, revised);
            return buildRevision(path, original, revised);
        } catch (difflib.myers.DifferentiationFailedException e) {
            e.printStackTrace();
        }
        return new difflib.Patch<T>();
    }

    public difflib.myers.PathNode buildPath(final java.util.List<T> orig, final java.util.List<T> rev) throws difflib.myers.DifferentiationFailedException {
        if (orig == null)
            throw new java.lang.IllegalArgumentException("original sequence is null");
        
        if (rev == null)
            throw new java.lang.IllegalArgumentException("revised sequence is null");
        
        final int N = orig.size();
        final int M = rev.size();
        final int MAX = (N + M) + 1;
        final int size = 1 + (2 * MAX);
        final int middle = size / 2;
        final difflib.myers.PathNode[] diagonal = new difflib.myers.PathNode[size];
        diagonal[(middle + 1)] = new difflib.myers.Snake(0 , -1 , null);
        for (int d = 0 ; d < MAX ; d++) {
            for (int k = -d ; k <= d ; k += 2) {
                final int kmiddle = middle + k;
                final int kplus = kmiddle + 1;
                final int kminus = kmiddle - 1;
                difflib.myers.PathNode prev = null;
                int i;
                if ((k == (-d)) || ((k != d) && ((diagonal[kminus].i) < (diagonal[kplus].i)))) {
                    i = diagonal[kplus].i;
                    prev = diagonal[kplus];
                } else {
                    i = (diagonal[kminus].i) + 1;
                    prev = diagonal[kminus];
                }
                diagonal[kminus] = null;
                int j = i - k;
                difflib.myers.PathNode node = new difflib.myers.DiffNode(i , j , prev);
                while (((i < N) && (j < M)) && (equals(orig.get(i), rev.get(j)))) {
                    i++;
                    j++;
                }
                if (i > (node.i))
                    node = new difflib.myers.Snake(i , j , node);
                
                diagonal[kmiddle] = node;
                if ((i >= N) && (j >= M)) {
                    return diagonal[kmiddle];
                } 
            }
            diagonal[((middle + d) - 1)] = null;
        }
        throw new difflib.myers.DifferentiationFailedException("could not find a diff path");
    }

    private boolean equals(T orig, T rev) {
        return equalizer.equals(orig, rev);
    }

    public difflib.Patch<T> buildRevision(difflib.myers.PathNode path, java.util.List<T> orig, java.util.List<T> rev) {
        if (path == null)
            throw new java.lang.IllegalArgumentException("path is null");
        
        if (orig == null)
            throw new java.lang.IllegalArgumentException("original sequence is null");
        
        if (rev == null)
            throw new java.lang.IllegalArgumentException("revised sequence is null");
        
        difflib.Patch<T> patch = new difflib.Patch<T>();
        if (path.isSnake())
            path = path.prev;
        
        while (((path != null) && ((path.prev) != null)) && ((path.prev.j) >= 0)) {
            if (path.isSnake())
                throw new java.lang.IllegalStateException("bad diffpath: found snake when looking for diff");
            
            int i = path.i;
            int j = path.j;
            path = path.prev;
            int ianchor = path.i;
            int janchor = path.j;
            difflib.Chunk<T> original = new difflib.Chunk<T>(ianchor , copyOfRange(orig, ianchor, i));
            difflib.Chunk<T> revised = new difflib.Chunk<T>(janchor , copyOfRange(rev, janchor, j));
            difflib.Delta<T> delta = null;
            if (((original.size()) == 0) && ((revised.size()) != 0)) {
                delta = new difflib.InsertDelta<T>(original , revised);
            } else if (((original.size()) > 0) && ((revised.size()) == 0)) {
                delta = new difflib.DeleteDelta<T>(original , revised);
            } else {
                delta = new difflib.ChangeDelta<T>(original , revised);
            }
            patch.addDelta(delta);
            if (path.isSnake())
                path = path.prev;
            
        }
        return patch;
    }

    private java.util.List<T> copyOfRange(final java.util.List<T> original, final int fromIndex, final int to) {
        return new java.util.ArrayList<T>(original.subList(fromIndex, to));
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    public static <T>T[] copyOfRange2(T[] original, int from, int to) {
        return difflib.myers.MyersDiff.copyOfRange2(original, from, to, ((java.lang.Class<T[]>)(original.getClass())));
    }

    @java.lang.SuppressWarnings(value = "unchecked")
    public static <T, U>T[] copyOfRange2(U[] original, int from, int to, java.lang.Class<? extends T[]> newType) {
        int newLength = to - from;
        if (newLength < 0)
            throw new java.lang.IllegalArgumentException(((from + " > ") + to));
        
        T[] copy = ((java.lang.Object)(newType)) == ((java.lang.Object)(java.lang.Object[].class)) ? ((T[])(new java.lang.Object[newLength])) : ((T[])(java.lang.reflect.Array.newInstance(newType.getComponentType(), newLength)));
        java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(((original.length) - from), newLength));
        return copy;
    }
}

