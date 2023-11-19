package com.brahyan.app_tienda.Helper;

import android.content.Context;

import com.brahyan.app_tienda.Domain.PopularDomain;

import java.sql.Array;
import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);
    }

    public void insertFood(PopularDomain item){


    }

}
