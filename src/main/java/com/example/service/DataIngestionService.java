package com.example.service;

import com.example.model.PlayerEntity;
import com.example.repo.PlayerRepo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class DataIngestionService {

    @Autowired
    PlayerRepo playerRepo;

    @PostConstruct
    public void init() throws IOException, CsvException {
        updateDb(parseCsvInput());
    }

    public List<String[]> parseCsvInput() throws IOException, CsvException {
        // externalize file
        File inputFile = ResourceUtils.getFile("classpath:playerdb/People.csv");
        try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
            List<String[]> r = reader.readAll();
            return r;
        }
    }

    public void updateDb(List<String[]> inputs) {
        // skip 1st row for header
        for (int i = 1; i < inputs.size(); i++) {
            log.info(Arrays.toString(inputs.get(i)));
            PlayerEntity player = new PlayerEntity(inputs.get(i));
            playerRepo.save(player);
        }
    }
}
