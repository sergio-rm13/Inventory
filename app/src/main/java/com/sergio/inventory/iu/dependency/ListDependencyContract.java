package com.sergio.inventory.iu.dependency;

import com.sergio.inventory.data.model.Dependency;
import com.sergio.inventory.iu.base.BaseListView;
import com.sergio.inventory.iu.base.BasePresenter;

public interface ListDependencyContract {

    interface View extends BaseListView<Dependency>{

        void showProgress();

        void hideProgress();

        //Activa la parte de la vista que indica que no hay datos
        void setNoData();
    }

    interface Presenter extends BasePresenter{
        void load();
    }
}
