package difflib;


public interface DiffAlgorithm<T> {
    public difflib.Patch<T> diff(T[] original, T[] revised);

    public difflib.Patch<T> diff(java.util.List<T> original, java.util.List<T> revised);
}

