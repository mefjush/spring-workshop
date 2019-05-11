package pl.sda.kantor.wallet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<WalletEntry, Integer> {

    @Query("SELECT SUM(w.change) FROM WalletEntry w WHERE w.currency = :#{#currency}")
    Double getWalletAmount(@Param("currency") String currency);
}
