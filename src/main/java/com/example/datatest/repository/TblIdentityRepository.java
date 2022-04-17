package com.example.datatest.repository;

import com.example.datatest.entity.TblIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblIdentityRepository extends JpaRepository<TblIdentity, Long> {
}
