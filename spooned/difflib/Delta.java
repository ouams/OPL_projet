package difflib;


public abstract class Delta<T> {
    private difflib.Chunk<T> original;

    private difflib.Chunk<T> revised;

    public enum TYPE {
CHANGE, DELETE, INSERT;    }

    public Delta(difflib.Chunk<T> original ,difflib.Chunk<T> revised) {
        if (original == null) {
            throw new java.lang.IllegalArgumentException("original must not be null");
        } 
        if (revised == null) {
            throw new java.lang.IllegalArgumentException("revised must not be null");
        } 
        this.original = original;
        this.revised = revised;
    }

    public abstract void verify(java.util.List<T> target) throws difflib.PatchFailedException;

    public abstract void applyTo(java.util.List<T> target) throws difflib.PatchFailedException;

    public abstract void restore(java.util.List<T> target);

    public abstract difflib.Delta.TYPE getType();

    public difflib.Chunk<T> getOriginal() {
        return original;
    }

    public void setOriginal(difflib.Chunk<T> original) {
        this.original = original;
    }

    public difflib.Chunk<T> getRevised() {
        return revised;
    }

    public void setRevised(difflib.Chunk<T> revised) {
        this.revised = revised;
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((original) == null ? 0 : original.hashCode());
        result = (prime * result) + ((revised) == null ? 0 : revised.hashCode());
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
        
        difflib.Delta<T> other = ((difflib.Delta)(obj));
        if ((original) == null) {
            if ((other.original) != null)
                return false;
            
        } else if (!(original.equals(other.original)))
            return false;
        
        if ((revised) == null) {
            if ((other.revised) != null)
                return false;
            
        } else if (!(revised.equals(other.revised)))
            return false;
        
        return true;
    }
}

