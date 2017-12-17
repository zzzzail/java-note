package spring4.core.imporvements03;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zail
 * @version 0.0.1
 */
@Component
@Order(3)
public class RankServiceImpl03 implements RankService {
  @Override
  public String toString() {
    return "RankServiceImpl03";
  }
}
