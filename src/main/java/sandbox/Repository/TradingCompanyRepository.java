package sandbox.Repository;

import sandbox.Model.TradingCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingCompanyRepository extends JpaRepository<TradingCompany, Long> {
}
