package com.sergio.inventory.iu.dependency;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sergio.inventory.R;
import com.sergio.inventory.data.model.Dependency;


public class EditDependencyFragment extends Fragment {

    private TextView tvName2;
    private TextView tvShorName2;
    private TextView tvDescription;
    private Dependency dependency;


    public EditDependencyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName2 = view.findViewById(R.id.tvName2);
        tvShorName2 = view.findViewById(R.id.tvShortName2);
        tvDescription = view.findViewById(R.id.tvDescription);
        dependency = EditDependencyFragmentArgs.fromBundle(getArguments()).getDependency();
        //Toast.makeText(getActivity(), "Nombre: "+dependency.getName(), Toast.LENGTH_SHORT).show();
        tvName2.setText(dependency.getName());
        tvShorName2.setText(dependency.getShortname());
        tvDescription.setText(dependency.getDescription());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_dependency, container, false);
    }

    /*private Dependency dependency;
    private static final String TAG = "EditDependencyFragment";



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //dependency = EditDependencyFragmentArgs.fromBundle(getArguments()).getDependency();
        Toast.makeText(getActivity(), "Nombre: "+dependency.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"EditDependencyFragment: onCreatedView()");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG,"EditDependencyFragment: onAttach()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"EditDependencyFragment: onPause()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"EditDependencyFragment: onDetach()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"EditDependencyFragment: onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"EditDependencyFragment: onDestroy()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"EditDependencyFragment: onResume()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_dependency2, container, false);
    }*/
}