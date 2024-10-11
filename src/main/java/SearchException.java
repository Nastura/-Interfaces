public class SearchException extends RuntimeException {

    public SearchException(String s) {
        super(s);
        System.out.println(s);
    }
}
