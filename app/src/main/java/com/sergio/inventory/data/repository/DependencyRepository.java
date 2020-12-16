package com.sergio.inventory.data.repository;

import com.sergio.inventory.data.model.Dependency;

import java.util.ArrayList;
import java.util.List;

public class DependencyRepository {
    private List<Dependency> list;
    private static DependencyRepository repository;

    static{
        repository = new DependencyRepository();
    }

    private DependencyRepository() {
        this.list = new ArrayList<>();
        initialice();
    }

    private void initialice() {
        list.add(new Dependency("2º Ciclo Formativo DAM", "2DAM", "Aula del alumnado de 2ºDam", ""));
        list.add(new Dependency("1º Ciclo Formativo DAM", "1DAM", "Aula del alumnado de 1ºDam", ""));
        list.add(new Dependency("2º Ciclo Formativo SMR", "2SMR", "Aula del alumnado de 2ºSMR", ""));
        list.add(new Dependency("1º Ciclo Formativo SMR", "1SMR", "Aula del alumnado de 1ºSMR", ""));
    }

    public static DependencyRepository getInstance(){
        return  repository;
    }

    public List<Dependency> getList(){
        return list;
    }


}
