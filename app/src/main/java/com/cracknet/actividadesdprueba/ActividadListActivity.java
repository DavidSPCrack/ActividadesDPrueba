package com.cracknet.actividadesdprueba;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class ActividadListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] lista = getResources().getStringArray(R.array.acts);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        setListAdapter(adaptador);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        try {
            ListAdapter listAdapter = getListAdapter();
            String elemento = (String) listAdapter.getItem(position);
            Class<?> clase = Class.forName("com.cracknet.actividadesdprueba.".concat(elemento));
            Intent intent = new Intent(this, clase);
            startActivity(intent);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
