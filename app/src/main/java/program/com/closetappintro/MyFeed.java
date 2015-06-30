package program.com.closetappintro;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by faith on 6/26/15.
 */
public class MyFeed extends Fragment {
    private GridView gridView;
    private GridViewAdapter gridAdapter;
    
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.myfeed,container,false);

        gridView = (GridView) v.findViewById(R.id.gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.d("ERROR", "before start activity");
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                Log.d("ERROR", "before  intent");
                //Create intent
                Intent intent = new Intent(getActivity().getApplicationContext(),SingleItemPage.class);
                getActivity().startActivity(intent);
                Log.d("ERROR", "starting activity");


            }
        });




        gridAdapter = new GridViewAdapter(getActivity(), R.layout.grid_item_layout, getData());

        Log.d("ERROR", "after grid adapter");
        gridView.setAdapter(gridAdapter);

        Log.d("ERROR", "BEfore return");
        return v;
    }



    private ArrayList getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);

        ArrayList<String>  mStringStyle= new ArrayList<String>();
        mStringStyle.add("AfricanWear");
        mStringStyle.add("Top");
        mStringStyle.add("Handbag");
        mStringStyle.add("heels");
        mStringStyle.add("White boots");
        mStringStyle.add("Short Dress");
        mStringStyle.add("ladies top");
        mStringStyle.add("Earings");

        for (int i = 0; i < imgs.length(); i++) {
            /*int sname=i+1;*/
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap,  mStringStyle.get(i)));
        }
        return imageItems;
    }
    }



