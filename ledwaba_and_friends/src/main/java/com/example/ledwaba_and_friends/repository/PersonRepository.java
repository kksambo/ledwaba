package com.example.ledwaba_and_friends.repository;



import com.example.ledwaba_and_friends.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Custom query methods can be added here if needed
}
