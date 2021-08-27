package com.example.demo.catalog;

import com.example.demo.catalog.entities.CatalogData;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class CatalogStructure {

    private ResponseStatus responseStatus;
    private List<String> errors;
    private List<CatalogData> mappingList;

    public static CatalogStructure getInstance(CatalogData data){
        CatalogStructure structure = new CatalogStructure();
        structure.setResponseStatus(ResponseStatus.SUCCESS);
        structure.setErrors(Collections.emptyList());
        structure.setMappingList(Collections.singletonList(data));
        return structure;
    }

}


