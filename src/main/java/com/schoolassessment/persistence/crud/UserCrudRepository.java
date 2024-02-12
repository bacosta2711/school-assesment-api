package com.schoolassessment.persistence.crud;

import com.schoolassessment.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserCrudRepository extends CrudRepository<User,Integer> {

    // @Query(value = "SELECT * FROM users WHERE userenabled = ?",nativeQuery = true) esto es manera nativa
    List<User> findByUserEnabled(Boolean userEnabled); //Esto es un querryMethod

}
