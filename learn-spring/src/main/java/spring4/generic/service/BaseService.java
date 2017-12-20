package spring4.generic.service;

import org.springframework.beans.factory.annotation.Autowired;
import spring4.generic.repository.BaseRepository;

/**
 * @author zail
 * @since 2017-12-20
 */
public class BaseService<T> {
  
  @Autowired
  protected BaseRepository<T> repository;
  
  public void add() {
    System.out.println("BaseService#add");
    System.out.println(repository);
  }
  
}
