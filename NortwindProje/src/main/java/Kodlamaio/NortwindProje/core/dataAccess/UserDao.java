package Kodlamaio.NortwindProje.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.NortwindProje.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer>{

	User findByEmail(String email);
}
