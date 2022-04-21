package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

public class Item {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String carpeta;

    @Getter @Setter
    private boolean estaCompletada;

    @Getter @Setter
    private String tarea;

}
