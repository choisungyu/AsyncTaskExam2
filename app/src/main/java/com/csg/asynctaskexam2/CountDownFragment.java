package com.csg.asynctaskexam2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CountDownFragment extends Fragment {
    private static final String ARG_NUMBER = "number";

    public interface onCountChangedListener {
        void onStartClick();
        void onResetClick();
    }

    public onCountChangedListener mListener;

    public void setOnColorChangeListener(onCountChangedListener listener) {
        mListener = listener;
    }

    // TODO: Rename and change types of parameters
    private String mTextNumber;


    public CountDownFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CountDownFragment newInstance() {
        CountDownFragment fragment = new CountDownFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_NUMBER, num);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTextNumber = getArguments().getString(ARG_NUMBER);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conunt_down, container, false);
        view.findViewById(R.id.button_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onResetClick();
                }
            }
        });

        view.findViewById(R.id.button_reset).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onResetClick();
                }
            }
        });
        return view;
    }
}
