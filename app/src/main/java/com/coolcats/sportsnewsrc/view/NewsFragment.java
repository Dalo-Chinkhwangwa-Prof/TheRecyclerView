package com.coolcats.sportsnewsrc.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coolcats.sportsnewsrc.MainActivity;
import com.coolcats.sportsnewsrc.R;
import com.coolcats.sportsnewsrc.model.News;

public class NewsFragment extends Fragment {



    public interface NewsInterface{
        void example();
    }

    private NewsInterface nInterface;

    //onCreateView
    //onViewCreated
    //onAttach
    //onDetach
    //onViewDestroyed
    //onResume
    //onStart
    //onCreate
    //onDestroy
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        News news = (News)getArguments().getSerializable("news");
        
        if(news != null){
            ((TextView)view.findViewById(R.id.textView)).setText(news.toString());
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        nInterface= (NewsInterface) context;
        nInterface.example();
    }
}
