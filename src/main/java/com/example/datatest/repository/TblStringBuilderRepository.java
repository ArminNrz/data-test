package com.example.datatest.repository;

import com.example.datatest.entity.TblQueryStringBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblStringBuilderRepository extends JpaRepository<TblQueryStringBuilder, Long> {
}
