package com.example.demo.catalog;

import com.example.demo.catalog.entities.CatalogData;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


@Component
public class CatalogService {

    public static Map<Pair<Integer, Long>, CatalogData> easyToQueryData = new HashMap<>();
    public static Map<Integer, List<Long>> siteWithCatalogs = new HashMap<>();

    public CatalogStructure getCatalogStructureBy(Integer siteId, Long catalogId){
        if(catalogId == -1){

        }
        CatalogData catalogData = easyToQueryData.get(Pair.of(siteId, catalogId));
        return CatalogStructure.getInstance(catalogData);
    }

    @PostConstruct
    public void initDataInMemory(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/dataAsTest.txt"));
            easyToQueryData = readAllLines(reader);

            HashMap<Integer, HashMap<Long, CatalogData>> easyToQueryData = new HashMap<>();

        } catch (IOException e) {
            throw new RuntimeException("Data could not be loaded", e);
        }
    }

    private Map<Pair<Integer, Long>,CatalogData> readAllLines(BufferedReader reader) throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            CatalogData instance = CatalogData.getInstance(line.split("\\t"));
            easyToQueryData.put(Pair.of(instance.getSiteId(), instance.getCatalogId()), instance);
            //siteWithCatalogs.merge(instance.getSiteId(), ArrayList::new, (l1 , l2) -> l1.addAll(l2));
        }

        return easyToQueryData;
    }

}
