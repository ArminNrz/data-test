package com.example.datatest.repository;

import com.example.datatest.entity.TblSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblSequenceRepository extends JpaRepository<TblSequence, Long> {
}
