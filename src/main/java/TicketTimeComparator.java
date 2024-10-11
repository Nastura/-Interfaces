import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int resultOne = t1.getTimeTo() - t1.getTimeFrom();
        int resultTwo = t2.getTimeTo() - t2.getTimeFrom();
        if (resultOne < resultTwo) {
            return -1;
        } else {
            if (resultOne > resultTwo) {
                return 1;
            }
            return 0;
        }
    }
}
