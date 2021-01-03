package com.example.chuanzhi_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuanzhi_1.adapter.ShouAdapter;

public class ShouFragment extends Fragment {
    private RecyclerView mRel;
    private ShouAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.shou_fragment, null);
        initView(view);
        return view;
    }

    private void initView(@NonNull final View itemView) {
        mRel = (RecyclerView) itemView.findViewById(R.id.rel);
        mRel.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRel.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        adapter = new ShouAdapter(getActivity());
        mRel.setAdapter(adapter);
    }
}
