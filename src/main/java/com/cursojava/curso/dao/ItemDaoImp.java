package com.cursojava.curso.dao;

import com.cursojava.curso.models.Item;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ItemDaoImp implements ItemDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Item> getItems() {
        String hql = "FROM Item";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        Item item = entityManager.find(Item.class, id);
        entityManager.remove(item);
    }

    @Override
    @Transactional
    public void agregar(Item item) {
        entityManager.merge(item);
    }

}
