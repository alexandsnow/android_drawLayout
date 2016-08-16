package com.alex.gy.sci.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alex.gy.sci.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gy on 2016/8/13.
 */
public class IndexFragment extends Fragment {

    private ListView listView;
    private List<String> data = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fragment,container,false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        data.add("item1");
        data.add("item2");
        data.add("item3");
        data.add("item4");
        data.add("item5");
        data.add("item6");
        data.add("item7");
        data.add("item8");
        listView = (ListView) view.findViewById(R.id.index_list);
        listView.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,data));
    }
}
