package difflib;


public class DeltaComparator implements java.io.Serializable , java.util.Comparator<difflib.Delta<?>> {
    private static final long serialVersionUID = 1L;

    public static final java.util.Comparator<difflib.Delta<?>> INSTANCE = new difflib.DeltaComparator();

    private DeltaComparator() {
    }

    public int compare(final difflib.Delta<?> a, final difflib.Delta<?> b) {
        final int posA = a.getOriginal().getPosition();
        final int posB = b.getOriginal().getPosition();
        if (posA > posB) {
            return 1;
        } else if (posA < posB) {
            return -1;
        } 
        return 0;
    }
}

