package com.example.skeleton.data.api.delegate;

import com.example.skeleton.api.DataApiDelegate;
import com.example.skeleton.api.model.Data;
import com.example.skeleton.data.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataApiDelegateImpl implements DataApiDelegate {

    private final DataService dataService;

    @Override
    public ResponseEntity<Data> getData(Long exampleId, Long dataId) {

        Data data = dataService.getData(exampleId, dataId);

        return ResponseEntity.ok().body(data);
    }

    @Override
    public ResponseEntity<Data> createData(Long exampleId, Data data){

        Data createdData = dataService.createData(exampleId, data);

        return ResponseEntity.ok().body(createdData);
    }
}
