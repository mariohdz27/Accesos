package com.unchesquito.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unchesquito.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

	@Query(nativeQuery = true, value = "SELECT * FROM users where (user = ?1 OR email =?1 OR telephone =?1  )AND password = ?2 AND id_estatus=1")
	public abstract UserEntity login(String correo, String password);
	
	@Query(nativeQuery = true, value = "SELECT * FROM users where id_estatus= 1 AND (user = ?1 OR email =?2 OR telephone =?3)")
	public abstract UserEntity findAccount(String user,String email,String telephone );

}
