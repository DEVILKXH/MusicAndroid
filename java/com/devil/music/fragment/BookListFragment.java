package com.devil.music.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devil.music.R;
import com.devil.music.common.model.BookContent;

/**
 * Created by Devil on 2017/3/24.
 */

public class BookListFragment extends ListFragment {
    private Callbacks mcallbacks;

    public interface Callbacks{
        public void onItemSelected(Integer id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(), R.layout.simple_list_item_activated_1,R.id.text1,BookContent.ITEMS));
    }

    @Override
    public void onAttach(Activity activety){
        super.onAttach(activety);
        if(!(activety instanceof Callbacks)){
            throw new IllegalStateException("BookListFragment 所在的Activity必须实现Callbacks接口");
        }
        mcallbacks = (Callbacks)activety;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mcallbacks = null;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        mcallbacks.onItemSelected(BookContent.ITEMS.get(position).id);
    }

    public void setActivateOnItemclick(boolean activateOnItemclick){
        getListView().setChoiceMode(activateOnItemclick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
    }
}



