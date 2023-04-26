package com.example.skeleton.data.api.delegate;

import com.example.skeleton.api.DataApiDelegate;
import com.example.skeleton.api.model.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DataApiDelegateImpl implements DataApiDelegate {

    @Override
    public ResponseEntity<Data> getData(Long exampleId, Long dataId) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Data> createData(Long exampleId, Data data){
        return ResponseEntity.ok().build();
    }
}
