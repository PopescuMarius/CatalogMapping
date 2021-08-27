package com.example.demo.catalog.entities;

import lombok.Data;

@Data
public class CatalogData {
    private Integer siteId;
    private Long catalogId;
    private Long categoryId;
    private String categoryName;

    public static CatalogData getInstance(String[] dataInLine){
        CatalogData catalogData = new CatalogData();
        catalogData.setSiteId(Integer.valueOf(dataInLine[0]));
        catalogData.setCatalogId(Long.valueOf(dataInLine[1]));
        catalogData.setCategoryId(Long.valueOf(dataInLine[2]));
        catalogData.setCategoryName(dataInLine[3]);
        return catalogData;
    }

}
