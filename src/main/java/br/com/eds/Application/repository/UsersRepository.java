package br.com.eds.Application.repository;

import br.com.eds.Application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>, JpaRepository<Users, Long> {

}
