package difflib.myers;


public interface Equalizer<T> {
    public boolean equals(T original, T revised);
}

