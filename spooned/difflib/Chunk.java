package difflib;


public class Chunk<T> {
    private final int position;

    private java.util.List<T> lines;

    public Chunk(int position ,java.util.List<T> lines) {
        this.position = position;
        this.lines = lines;
    }

    public Chunk(int position ,T[] lines) {
        this.position = position;
        this.lines = java.util.Arrays.asList(lines);
    }

    public void verify(java.util.List<T> target) throws difflib.PatchFailedException {
        if ((last()) > (target.size())) {
            throw new difflib.PatchFailedException("Incorrect Chunk: the position of chunk > target size");
        } 
        for (int i = 0 ; i < (size()) ; i++) {
            if (!(target.get(((position) + i)).equals(lines.get(i)))) {
                throw new difflib.PatchFailedException("Incorrect Chunk: the chunk content doesn\'t match the target");
            } 
        }
    }

    public int getPosition() {
        return position;
    }

    public void setLines(java.util.List<T> lines) {
        this.lines = lines;
    }

    public java.util.List<T> getLines() {
        return lines;
    }

    public int size() {
        return lines.size();
    }

    public int last() {
        return ((getPosition()) + (size())) - 1;
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((lines) == null ? 0 : lines.hashCode());
        result = (prime * result) + (position);
        result = (prime * result) + (size());
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
        
        difflib.Chunk<T> other = ((difflib.Chunk)(obj));
        if ((lines) == null) {
            if ((other.lines) != null)
                return false;
            
        } else if (!(lines.equals(other.lines)))
            return false;
        
        if ((position) != (other.position))
            return false;
        
        return true;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((((("[position: " + (position)) + ", size: ") + (size())) + ", lines: ") + (lines)) + "]";
    }
}

