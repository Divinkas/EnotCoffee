package com.example.divin.enotcoffe.Presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.enotcoffe.Contract.ITovarView;
import com.example.divin.enotcoffe.Data.DefaultItemsDb;
import com.example.divin.enotcoffe.Model.DatabaseModel;

@InjectViewState
public class TovarPresenter extends MvpPresenter<ITovarView> {
    private Context context;
    private DatabaseModel databaseModel;
    private DefaultItemsDb defaultItemsDb;

    public TovarPresenter() {
    }

    public void setDefaultContext(Context context){
        if(this.context == null){
            this.context = context;

            // it's checked having default data and install if they are not
            defaultItemsDb = new DefaultItemsDb(this.context);
        }
    }
}
