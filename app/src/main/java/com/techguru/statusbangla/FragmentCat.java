package com.techguru.statusbangla;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class FragmentCat extends Fragment {

    ArrayList<HashMap<String, String>> arrayList = new ArrayList();
    HashMap<String, String> hashMap;

    GridView gridView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView= inflater.inflate(R.layout.fragment_cat, container, false);



        gridView=myView.findViewById(R.id.gridView);

        catTable();
        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);




        return myView;


    }


    private class MyAdapter extends BaseAdapter {

        ImageView imgCat;
        TextView textCat;
        RelativeLayout rrCat;
        Animation zoom_in;
        CardView catCardView;


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.design_cat, viewGroup, false);

            imgCat = myView.findViewById(R.id.imgCat);
            textCat = myView.findViewById(R.id.textCat);
            rrCat = myView.findViewById(R.id.rrCat);
            catCardView = myView.findViewById(R.id.catCardView);

            zoom_in = AnimationUtils.loadAnimation(getContext(),R.anim.zoom_in);

            hashMap = arrayList.get(i);
            String scatName = hashMap.get("catName");
            String scatImg = hashMap.get("catImg");
            int icatImg = Integer.parseInt(scatImg);

            imgCat.setImageResource(icatImg);
            textCat.setText(scatName);

            catCardView.startAnimation(zoom_in);

            rrCat.setOnClickListener(v -> {
                assert scatName != null;
                if (scatName.contains("Love Calculator")){
                    PrivacyPolicy.HEADER= scatName;
                    startActivity(new Intent(getContext(), PrivacyPolicy.class));

                } else {
                    ItemList.CAT_NAME=scatName;
                    startActivity(new Intent(getContext(), ItemList.class));
                }
            });





            return myView;
        }
    }//======================Adeptar End===================================

    private void catTable() {

        hashMap = new HashMap<>();
        hashMap.put("catName", "Rose Day- 7th Feb");
        hashMap.put("catImg", "" + R.drawable.rose);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("catName", "Propose Day- 8th Feb");
        hashMap.put("catImg", "" + R.drawable.propose);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("catName", "Chocolate Day- 9th Feb");
        hashMap.put("catImg", "" + R.drawable.chocolate);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("catName", "Teddy Day- 10th Feb");
        hashMap.put("catImg", "" + R.drawable.teddy);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("catName", "Promise Day- 11th Feb");
        hashMap.put("catImg", "" + R.drawable.propose);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("catName", "Kiss Day- 12th Feb");
        hashMap.put("catImg", "" + R.drawable.kiss);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("catName", "Hug Day- 13th Feb");
        hashMap.put("catImg", "" + R.drawable.hug);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("catName", "Valentine Day- 14th Feb");
        hashMap.put("catImg", "" + R.drawable.valentine);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("catName", "Love Calculator");
        hashMap.put("catImg", "" + R.drawable.lovecalculator);
        arrayList.add(hashMap);


    }


}