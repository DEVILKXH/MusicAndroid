package com.devil.music.activity;

import android.app.Activity;
import android.os.Bundle;

import com.devil.music.R;
import com.devil.music.fragment.BookDetailFragment;
import com.devil.music.fragment.BookListFragment;

/**
 * Created by Devil on 2017/3/24.
 */

public class BookActivity extends Activity implements BookListFragment.Callbacks {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }

    @Override
    public void onItemSelected(Integer id) {
        Bundle arguments = new Bundle();
        arguments.putInt(BookDetailFragment.ITEM_ID,id);
        BookDetailFragment fragment = new BookDetailFragment();
        fragment.setArguments(arguments);
        getFragmentManager().beginTransaction().replace(R.id.book_detail_container,fragment).commit();
    }
}
