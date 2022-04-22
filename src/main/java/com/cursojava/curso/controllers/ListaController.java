package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.ItemDao;
import com.cursojava.curso.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListaController {

    @Autowired
    private ItemDao itemDao;

    @RequestMapping(value = "/items")
    public List<Item> cargarItems(){
        return itemDao.getItems();
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    public void eliminarItem(@PathVariable int id){
        itemDao.eliminar(id);
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public void agregarItem(@RequestBody Item item){
        itemDao.agregar(item);
    }

}
