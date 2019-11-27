package com.fsocity.security.springboot.repository;

import com.fsocity.security.springboot.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 人员仓库
 *
 * @author zail
 * @version 0.0.1
 */
@NoRepositoryBean
public interface PersonRepository {
    
    @Cacheable(cacheNames = "persons")
    Person findPerson(String id);
    
    boolean savePerson(Person person);
    
}
