package com.sergio.inventory.iu.dependency;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sergio.inventory.R;
import com.sergio.inventory.data.model.Dependency;
import com.sergio.inventory.data.repository.DependencyRepository;
import com.sergio.inventory.data.repository.UserRepository;
import com.sergio.inventory.iu.adapter.DependencyAdapter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListDependencyFragment extends Fragment implements ListDependencyContract.View, DependencyAdapter.onDependencyClickListener {
    private static final String TAG = "ListDependencyFragment";
    private LinearLayout llLoading;
    private LinearLayout llNoData;
    private RecyclerView rvDependency;
    private DependencyAdapter adapter;
    private ListDependencyContract.Presenter presenter;
    private List<Dependency> lista;

    public ListDependencyFragment() {

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        llLoading = view.findViewById(R.id.llLoading);
        llNoData = view.findViewById(R.id.llNoData);
        rvDependency = view.findViewById(R.id.rvDependency);
        //1.Crear adapter
        //Inicializar antes presenter porque sino la lista da nulo
        presenter = new ListDependencyPresenter(this);
        presenter.load();
        Collections.sort(lista, new Comparator<Dependency>() {
            @Override
            public int compare(Dependency o1, Dependency o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        adapter = new DependencyAdapter(lista, (DependencyAdapter.onDependencyClickListener) this);

        //2.DIseño RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        //3.Se asigna el diseño al recycler view
        rvDependency.setLayoutManager(layoutManager);

        //4.Vincular la vista al modelo
        rvDependency.setAdapter(adapter);

        //5.Se inicializa el presenter
        /*presenter = new ListDependencyPresenter(this);
        presenter.load();*/
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onStart() {
        super.onStart();
        presenter.load();

    }



    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "ListDependencyFragment: onPause()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "ListDependencyFragment: onDetach()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "ListDependencyFragment: onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "ListPizzaFragment: onResume()");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_dependency, container, false);
    }

    /**
     * Método que muestra linearlayout que contiene el progressbar
     */

    @Override
    public void showProgress() {
        llLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        llLoading.setVisibility(View.GONE);
    }

    @Override
    public void setNoData() {
        llNoData.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccess(List<Dependency> list) {
        lista = list;

        //1. Si está visible NODATA se cambia visibilidad a GONE
        if (llNoData.getVisibility() == View.VISIBLE)
            llNoData.setVisibility(View.GONE);

        //2. Se carga los datos en el REcycler
        //adapter.update(list);

    }

    @Override
    public void onClick(Dependency dependency) {
        //Toast.makeText(getActivity(), "Se ha pulsado"+dependency.getName(),Toast.LENGTH_SHORT).show();
        ListDependencyFragmentDirections.ActionListDependencyFragmentToEditDependencyFragment action =
                ListDependencyFragmentDirections.actionListDependencyFragmentToEditDependencyFragment(dependency);
        NavHostFragment.findNavController(ListDependencyFragment.this).navigate(action);
    }
}