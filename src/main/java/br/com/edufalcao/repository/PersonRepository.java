package br.com.edufalcao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edufalcao.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
}
