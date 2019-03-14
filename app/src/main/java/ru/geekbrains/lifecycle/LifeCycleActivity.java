package ru.geekbrains.lifecycle;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {
    LifeCycleFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        fragment = new LifeCycleFragment();
        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        showToastAndLog( instanceState + " - onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToastAndLog( "onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        showToastAndLog( "Повторный запуск!! - onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToastAndLog( "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToastAndLog( "onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        showToastAndLog( "onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToastAndLog( "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToastAndLog( "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToastAndLog("onDestroy()");
    }

    public void showToastAndLog(String msg){
        Toast.makeText(getApplicationContext(),"Activity: " + msg, Toast.LENGTH_SHORT).show();
        Log.i("ACTIVITY", msg);
    }

    public void on_fragment_create(View view){
        Fragment fragmentIn = fragment;
        if(!fragmentIn.isAdded()) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_frame_layout, fragmentIn);
            fragmentTransaction.commit();
        }else {
            showToastAndLog("Фрагмент создан ранее");
        }
    }

    public void on_fragment_delete(View view){
        Fragment fragmentIn = fragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragmentIn);
        fragmentTransaction.commit();
    }
}
