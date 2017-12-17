package spring4.core.imporvements03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zail
 * @version 0.0.1
 */
@Component
public class Results {

  @Autowired
  private List<RankService> rankService;

  @Override
  public String toString() {
    return rankService.toString();
  }
}
