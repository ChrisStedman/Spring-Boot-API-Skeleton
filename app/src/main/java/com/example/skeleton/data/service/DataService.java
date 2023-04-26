package com.example.skeleton.data.service;

import com.example.skeleton.api.model.Data;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class DataService {

    public Data getData(Long exampleId, Long dataId){
        return new Data(dataId, OffsetDateTime.now(), "Content");
    }

    public Data createData(Long exampleId, Data data){
        return new Data(1L, data.getCreated(), data.getContent());
    }
}
