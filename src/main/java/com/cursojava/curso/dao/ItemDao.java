package com.cursojava.curso.dao;

import com.cursojava.curso.models.Item;

import java.util.List;

public interface ItemDao {

    List<Item> getItems();

    void eliminar(int id);

    void agregar(Item item);
}
