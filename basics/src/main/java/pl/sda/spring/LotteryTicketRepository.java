package pl.sda.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.*;

public class LotteryTicketRepository {

    private final Logger logger = LoggerFactory.getLogger(LotteryTicketRepository.class);

    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private List<LotteryTicket> tickets = new ArrayList<>();

    public LotteryTicketRepository() {
        logger.info("Creating LotteryTicketRepository");
        this.tickets.addAll(Collections.nCopies(9000, LotteryTicket.BLANK));
        this.tickets.addAll(Collections.nCopies(990, LotteryTicket.PEN));
        this.tickets.addAll(Collections.nCopies(10, LotteryTicket.TV));
    }

    public LotteryTicket getTicket() {
        int ticketIndex = randomNumberGenerator.randomInt(tickets.size());
        LotteryTicket ticket = tickets.remove(ticketIndex);
        return ticket;
    }
}
