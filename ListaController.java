package com.example.demo.controllers;

import com.example.demo.dao.ItemDao;
import com.example.demo.models.Item;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListaController {

    @RequestMapping(value = "/items")
    public List<Item> cargarItems(){
        List<Item> listaDeItems = new ArrayList<Item>();
        Item item1 = new Item();
        item1.setEstaCompletada(true);
        item1.setTarea("Hacer la comida");
        Item item2 = new Item();
        item2.setEstaCompletada(false);
        item2.setTarea("Lavar la ropa");
        listaDeItems.add(item1);
        listaDeItems.add(item2);
        return listaDeItems;
    }

}
