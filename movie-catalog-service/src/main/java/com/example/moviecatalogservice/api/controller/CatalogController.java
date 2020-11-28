package com.example.moviecatalogservice.api.controller;

import com.example.moviecatalogservice.db.model.Catalog;
import com.example.moviecatalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;
    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    /**
     * Gets Catalog object by its id
     *
     * @param id    Catalog id
     * @return      Catalog object with such id
     */
    @GetMapping("/{id}")
    public Catalog getCatalog(
            @PathVariable("id") int id
    ){
        return catalogService.getCatalog(id);
    }


    /**
     * Inserts catalog into database
     *
     * @param catalog
     */
    @PostMapping("/insert")
    public void insertCatalog(
            @RequestBody Catalog catalog
    ){
        catalogService.insertCatalog(catalog);
    }
}
