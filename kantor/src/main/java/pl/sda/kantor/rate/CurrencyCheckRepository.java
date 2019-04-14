package pl.sda.kantor.rate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyCheckRepository extends CrudRepository<CurrencyCheck, Integer> {

    long countByCurrency(String currency);

    @Query("SELECT c.currency FROM CurrencyCheck c GROUP BY c.currency ORDER BY COUNT(c.currency) DESC")
    List<String> getMostPopularCurrency();

}
