package com.schoolassessment.persistence;

import java.util.List;
import java.util.Optional;

import com.schoolassessment.domain.dto.UserResponse;
import com.schoolassessment.persistence.crud.UserCrudRepository;
import com.schoolassessment.persistence.entity.User;
import com.schoolassessment.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //Puedo usar @Component que generaliza que es componente de spring, con repository especificamos cual es
public class UserRepository implements com.schoolassessment.domain.repository.UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserMapper mapper;

    @Override
     public List<UserResponse> getAll(){
         List<User> list = (List<User>) userCrudRepository.findAll();
        return mapper.toUsers(list);
    };

    @Override
    public List<UserResponse> getAllEnabled(){
        List<User> list = (List<User>) userCrudRepository.findByUserEnabled(true);
        return  mapper.toUsers(list);
    }

    @Override
    public Optional<UserResponse> getUserById(int id){
        Optional<User> user =userCrudRepository.findById(id);
        return user.map(usr -> mapper.toUser(usr));
    }
    @Override
    public UserResponse saveUser(UserResponse user){
        User usr = mapper.userFromResponse(user);
        return mapper.toUser(userCrudRepository.save(usr));
    }

    @Override
    public void deleteUser(int id){
        userCrudRepository.deleteById(id);
    }
}
