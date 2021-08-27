package com.example.demo.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogMapping {

    @Autowired
    private CatalogService catalogService;

    @GetMapping(path = "/catalogmapping/getcatalogmapping/json/{catalogId}/{siteID}")
    public ResponseEntity<CatalogStructure> getCatalogMapping(@PathVariable("catalogId") Long catalogId, @PathVariable("siteID") Integer siteId) {
        return new ResponseEntity<>(catalogService.getCatalogStructureBy(siteId, catalogId), HttpStatus.OK);
    }

}
