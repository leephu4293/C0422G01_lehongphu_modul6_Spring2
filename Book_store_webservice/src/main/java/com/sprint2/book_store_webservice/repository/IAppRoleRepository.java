package com.sprint2.book_store_webservice.repository;

import com.sprint2.book_store_webservice.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAppRoleRepository extends JpaRepository<AppRole,Long> {
    @Query(value = "SELECT r.id, r.role from app_role as r join account_role as ar on ar.role_id = r.id" +
            " join `account` as a on a.id = ar.account_id where a.email = ?1", nativeQuery = true)
    List<AppRole> findRole(String email);
}
