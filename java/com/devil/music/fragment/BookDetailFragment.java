package com.devil.music.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devil.music.R;
import com.devil.music.common.model.BookContent;

/**
 * Created by Devil on 2017/3/24.
 */

public class BookDetailFragment extends Fragment {
    public static final String ITEM_ID = "item_id";
    BookContent.Book book;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey(ITEM_ID)){
            book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_book_detail,container,false);
        if(book != null){
            ((TextView) rootView.findViewById(R.id.book_title)).setText(book.title);
            ((TextView) rootView.findViewById(R.id.book_desc)).setText(book.desc);
        }
        return rootView;
    }

}
