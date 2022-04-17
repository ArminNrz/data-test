package com.example.datatest.controller;

import com.example.datatest.entity.TblSequence;
import com.example.datatest.repository.TblSequenceRepository;
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
@RequestMapping("/sequence")
@Slf4j
@RequiredArgsConstructor
public class TblSequenceController {

    private final TblSequenceRepository repository;

    @PostMapping("/{count}")
    public void create(@PathVariable("count") Long count) {
        log.info("Request to create {} sequence", count);
        Random random = new Random();
        List<TblSequence> entities = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            TblSequence entity = new TblSequence();
            entity.setName("TestName");
            entity.setCode(random.nextLong());
            entities.add(entity);
        }

        repository.saveAll(entities);
        log.info("Saved {}, tblSequence", count);
    }
}
