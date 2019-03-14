package ru.geekbrains.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class LifeCycleFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        showToastAndLog("onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToastAndLog("onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        showToastAndLog("onCreateView()");
        return inflater.inflate(R.layout.fragment_life_cycle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        showToastAndLog("onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        showToastAndLog("onStartView()");
        super.onStart();
    }

    @Override
    public void onResume() {
        showToastAndLog("onResumeView()");
        super.onResume();
    }

    @Override
    public void onPause() {
        showToastAndLog("onPauseView()");
        super.onPause();
    }

    @Override
    public void onStop() {
        showToastAndLog("onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        showToastAndLog("onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        showToastAndLog("onDetach()");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        showToastAndLog("onDestroy()");
        super.onDestroy();
    }

    public void showToastAndLog(String msg){
        Toast.makeText(getContext(),"Fragment: " + msg, Toast.LENGTH_SHORT).show();
        Log.i("FRAGMENT", msg);
    }
}
