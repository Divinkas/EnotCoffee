package com.example.divin.enotcoffe.Presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.enotcoffe.Adapter.RenderCoffeeListAdapter;
import com.example.divin.enotcoffe.Contract.IFragmentCoffeeView;
import com.example.divin.enotcoffe.Model.DatabaseModel;

@InjectViewState
public class CoffeeFragmentPresenter extends MvpPresenter<IFragmentCoffeeView> {
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private Context context;
    private RenderCoffeeListAdapter adapter;
    private DatabaseModel databaseModel;

    public CoffeeFragmentPresenter() {
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
    }

    public void setDefaultContext(Context context){
        if(this.context == null){
            this.context = context;
            databaseModel = new DatabaseModel(this.context);
            adapter = new RenderCoffeeListAdapter(databaseModel.getDefaulMockListSells(), this.context);
        }
    }

    public StaggeredGridLayoutManager getLayoutManager(){
        return staggeredGridLayoutManager;
    }

    public RenderCoffeeListAdapter getAdapter(){
        return adapter;
    }
}
