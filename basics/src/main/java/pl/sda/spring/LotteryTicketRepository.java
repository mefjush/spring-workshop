package pl.sda.spring;

import java.security.SecureRandom;
import java.util.*;

public class LotteryTicketRepository {

    private SecureRandom secureRandom = new SecureRandom();
    private List<LotteryTicket> tickets = new ArrayList<>();

    public LotteryTicketRepository() {
        this.tickets.addAll(Collections.nCopies(9990, LotteryTicket.BLANK));
        this.tickets.addAll(Collections.nCopies(10, LotteryTicket.TV));
    }

    public LotteryTicket getTicket() {
        int ticketIndex = secureRandom.nextInt(tickets.size());
        LotteryTicket ticket = tickets.remove(ticketIndex);
        return ticket;
    }
}
