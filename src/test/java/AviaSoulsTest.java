import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {


    Ticket ticket = new Ticket("Москва", "Казахстан", 24999, 8, 15);
    Ticket ticket2 = new Ticket("Москва", "Севастопль", 15999, 12, 16);
    Ticket ticket3 = new Ticket("Москва", "Удмуртия", 45999, 14, 19);
    Ticket ticket4 = new Ticket("Москва", "Ростов-на-Дону", 35999, 10, 15);
    Ticket ticket5 = new Ticket("Москва", "Казахстан", 14999, 10, 16);
    Ticket ticket6 = new Ticket("Москва", "Индонезия", 98999, 10, 22);
    Ticket ticket7 = new Ticket("Москва", "Казахстан", 10999, 15, 22);
    Ticket ticket8 = new Ticket("Москва", "Анапа", 13999, 10, 20);
    Ticket ticket9 = new Ticket("Москва", "Казахстан", 12999, 10, 13);


    @Test   /// поиск билета/  по аэропорту вылета и прилета
    public void searchForAticket() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] expected = {ticket3};
        Ticket[] actual = aviaSouls.search("Москва", "Удмуртия");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test  // поиск всех билетов
    public void searchAllTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        Ticket[] expected = {ticket, ticket2};
        Ticket[] actual = aviaSouls.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test  // сортировка цен
    public void priceSorting() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] tickets = {ticket, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);
        Ticket[] expected = {ticket5, ticket2, ticket, ticket4, ticket3};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test  // сортировка массива ответа в методе search
    public void arraySorting() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        Ticket[] expected = {ticket7, ticket9, ticket5, ticket};
        Ticket[] actual = aviaSouls.search("Москва", "Казахстан");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test  // сортировка с передаваемым методом комп оратора.
    public void sortingComparator() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};
        Arrays.sort(tickets, ticketTimeComparator);
        Ticket[] expected = {ticket9, ticket2, ticket3, ticket4, ticket5, ticket, ticket7, ticket8, ticket6};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // // сортировка с передаваемым методом комп оратора.

    public void seaffrctgteh() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Казахстан", ticketTimeComparator);
        Ticket[] expected = {ticket9, ticket5, ticket, ticket7};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test  // Тест на мтод поиска и выброс исключения если параметры не найдены.
    public void seaffrcttrgteh() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        Assertions.assertThrows(SearchException.class, () -> {
            aviaSouls.search("Москва", "Пекин");
        });

    }
}