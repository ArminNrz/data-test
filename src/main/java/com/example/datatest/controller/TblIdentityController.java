package com.example.datatest.controller;

import com.example.datatest.entity.TblIdentity;
import com.example.datatest.repository.TblIdentityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/identity")
@Slf4j
@RequiredArgsConstructor
public class TblIdentityController {

    private final TblIdentityRepository repository;

    @PostMapping("/{count}")
    public void create(@PathVariable("count") Long count) {
        log.info("Request to create {} identity", count);
        Random random = new Random();
        List<TblIdentity> entities = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            TblIdentity entity = new TblIdentity();
            entity.setName("TestName");
            entity.setCode(random.nextLong());
            entities.add(entity);
        }

        repository.saveAll(entities);
        log.info("Saved {}, tblIdentity", count);
    }
}
