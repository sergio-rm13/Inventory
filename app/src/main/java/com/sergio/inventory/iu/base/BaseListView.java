package com.sergio.inventory.iu.base;

import java.util.List;

/**
 * Esta interfaz corresponde at odas las vistas que reciban del origen de datos un listado de objeto genérico

 */
public interface BaseListView <T>{
    void onSuccess(List<T> list);
}
