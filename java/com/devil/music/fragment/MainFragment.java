package com.devil.music.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.devil.music.R;

/**
 * Created by Devil on 2017/3/13.
 */

public class MainFragment extends Fragment {

    private Callbacks mcallbacks;

    public interface Callbacks{
        public void onFragmentSelected(Integer id);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view =  inflater.inflate(R.layout.fragment_main,container);
        return view;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if(!(activity instanceof Callbacks)){
            throw new IllegalStateException("activity必须实现Callbacks接口");
        }
        mcallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mcallbacks = null;
    }
}
