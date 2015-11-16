package difflib;


public class PatchFailedException extends difflib.DiffException {
    private static final long serialVersionUID = 1L;

    public PatchFailedException() {
    }

    public PatchFailedException(java.lang.String msg) {
        super(msg);
    }
}

