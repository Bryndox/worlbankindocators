package com.ubunifuconcepts.wbdatacatalog.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ubunifuconcepts.wbdatacatalog.R;
import com.ubunifuconcepts.wbdatacatalog.adapter.CatalogArrayAdapter;
import com.ubunifuconcepts.wbdatacatalog.constant.Constants;
import com.ubunifuconcepts.wbdatacatalog.loader.CatalogLoader;
import com.ubunifuconcepts.wbdatacatalog.model.WBindicator;

import java.util.List;

public class CatalogActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<WBindicator>> {

    CatalogArrayAdapter adapter;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_catalog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle(R.string.page_indicators);

        list = (ListView) findViewById(R.id.list_catalog);
        adapter = new CatalogArrayAdapter(this, R.layout.catalog_list_item);

        list.setAdapter(adapter);

        if(adapter.getCount() ==0){
            getSupportLoaderManager().initLoader(0, null, this);
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                WBindicator wb = (WBindicator) adapter.getItemAtPosition(position);
                if (wb != null && wb.getUrl()!=null) {
                    Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);

                    intent.putExtra(Constants.INTENT_WEBVIEW_URL, wb.getUrl());
                    intent.putExtra(Constants.INTENT_WEBVIEW_NAME, wb.getName());
                    startActivity(intent);
                }
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<List<WBindicator>> onCreateLoader(int id, Bundle args){
        return new CatalogLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<WBindicator>> loader, List<WBindicator> data) {
        adapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<List<WBindicator>> loader) {
        adapter.setData(null);
    }
}
