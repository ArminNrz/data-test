package com.example.datatest.controller;

import com.example.datatest.ServiceTest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string-builder")
@Slf4j
@RequiredArgsConstructor
public class TblStringBuilderController {

    private final ServiceTest serviceTest;

    @PostMapping("/{count}")
    public void create(@PathVariable("count") Long count) {
        log.info("Request to create {} identity", count);
        serviceTest.insertByQuery(count);
        log.info("Saved {}, tblIdentity", count);
    }


}
