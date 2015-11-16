package difflib;


public class Patch<T> {
    private java.util.List<difflib.Delta<T>> deltas = new java.util.LinkedList<difflib.Delta<T>>();

    public java.util.List<T> applyTo(java.util.List<T> target) throws difflib.PatchFailedException {
        java.util.List<T> result = new java.util.LinkedList<T>(target);
        java.util.ListIterator<difflib.Delta<T>> it = getDeltas().listIterator(deltas.size());
        while (it.hasPrevious()) {
            difflib.Delta<T> delta = ((difflib.Delta<T>)(it.previous()));
            delta.applyTo(result);
        }
        return result;
    }

    public java.util.List<T> restore(java.util.List<T> target) {
        java.util.List<T> result = new java.util.LinkedList<T>(target);
        java.util.ListIterator<difflib.Delta<T>> it = getDeltas().listIterator(deltas.size());
        while (it.hasPrevious()) {
            difflib.Delta<T> delta = ((difflib.Delta<T>)(it.previous()));
            delta.restore(result);
        }
        return result;
    }

    public void addDelta(difflib.Delta<T> delta) {
        deltas.add(delta);
    }

    public java.util.List<difflib.Delta<T>> getDeltas() {
        java.util.Collections.sort(deltas, difflib.DeltaComparator.INSTANCE);
        return deltas;
    }
}

