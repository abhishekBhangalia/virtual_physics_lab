package com.example.virtualphysicslab;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link YMTheory2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YMTheory2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public YMTheory2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment YMTheory2.
     */
    // TODO: Rename and change types and number of parameters
    public static YMTheory2 newInstance(String param1, String param2) {
        YMTheory2 fragment = new YMTheory2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_y_m_theory2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] arr = getActivity().getResources().getStringArray(R.array.YMTheory2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, arr);
        ListView listView = view.findViewById(R.id.listviewYMTheory);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), YMTheory3.class);
                String [] item = getActivity().getResources().getStringArray(R.array.YMTheory2);
                switch (position) {
                    case 0: {
                        i.putExtra("item", item[0]);
                        startActivity(i);
                        break;
                    }
                    case 1: {
                        i.putExtra("item", item[1]);
                        startActivity(i);
                        break;
                    }
                    case 2:{
                        i.putExtra("item", item[2]);
                        startActivity(i);
                        break;
                    }
                    case 3: {
                        i.putExtra("item",item[3]);
                        startActivity(i);
                        break;

                    }
                    case 4: {
                        i.putExtra("item",item[4]);
                        startActivity(i);
                        break;
                    }
                    case 5: {
                        i.putExtra("item",item[5]);
                        startActivity(i);
                        break;

                    }
                    case 6: {
                        i.putExtra("item",item[6]);
                        startActivity(i);
                        break;

                    }
                    case 7: {
                        i.putExtra("item",item[7]);
                        startActivity(i);
                        break;

                    }
                    case 8: {
                        i.putExtra("item",item[8]);
                        startActivity(i);
                        break;
                    }
                }
            }
        });
    }
}