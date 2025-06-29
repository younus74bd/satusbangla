package com.techguru.statusbangla;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemList extends AppCompatActivity {


    public static String CAT_NAME="";

    ImageView imgBack;
    TextView tvItemName;
    ListView listViewItem;

    public static ArrayList<HashMap<String,String>> arrayList=new ArrayList();
    public static ArrayList<HashMap<String,String>> roseDay=new ArrayList();
    public static ArrayList<HashMap<String,String>> proposeDay=new ArrayList();
    public static ArrayList<HashMap<String,String>> chocolateDay=new ArrayList();
    public static ArrayList<HashMap<String,String>> teddyDay=new ArrayList();
    public static ArrayList<HashMap<String,String>> promiseDay=new ArrayList();
    public static ArrayList<HashMap<String,String>> kissDay=new ArrayList();
    public static ArrayList<HashMap<String,String>> hugDay=new ArrayList();
    public static ArrayList<HashMap<String,String>> valentineDay=new ArrayList();

    HashMap <String,String> hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        imgBack=findViewById(R.id.imgBack);
        tvItemName=findViewById(R.id.tvItemName);
        listViewItem=findViewById(R.id.listViewItem);

        tvItemName.setText(CAT_NAME);

        arrayList.clear();
        roseDay.clear();
        proposeDay.clear();
        chocolateDay.clear();
        teddyDay.clear();
        promiseDay.clear();
        kissDay.clear();
        hugDay.clear();
        valentineDay.clear();

        imgBack.setOnClickListener(v -> {
            finish();

        });

        if (CAT_NAME.contains("Rose Day- 7th Feb")) {

            ItemList.arrayList=roseDay;


        } else if (CAT_NAME.contains("Propose Day- 8th Feb")) {

            ItemList.arrayList=proposeDay;


        } else if (CAT_NAME.contains("Chocolate Day- 9th Feb")) {

            ItemList.arrayList=chocolateDay;


        } else if (CAT_NAME.contains("Teddy Day- 10th Feb")) {

            ItemList.arrayList=teddyDay;


        } else if (CAT_NAME.contains("Promise Day- 11th Feb")) {

            ItemList.arrayList=promiseDay;


        } else if (CAT_NAME.contains("Kiss Day- 12th Feb")) {

            ItemList.arrayList=kissDay;


        } else if (CAT_NAME.contains("Hug Day- 13th Feb")) {

            ItemList.arrayList=hugDay;

        } else {

            ItemList.arrayList=valentineDay;


        }


        itemTable();

        MyAdapter myAdapter=new MyAdapter();
        listViewItem.setAdapter(myAdapter);




    }//=======================onCreate End===================================


    private  class MyAdapter extends BaseAdapter{
        CardView cardViewItem,cardShare,cardCopy;
        Animation anim;
        TextView tvItem;

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = inflater.inflate(R.layout.design_item,parent,false);

            anim = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_in);
            cardViewItem=myView.findViewById(R.id.cardViewItem);
            cardShare=myView.findViewById(R.id.cardShare);
            cardCopy=myView.findViewById(R.id.cardCopy);
            tvItem=myView.findViewById(R.id.tvItem);


            hashMap=arrayList.get(position);
            String status =hashMap.get("status");

            tvItem.setText(status);




            cardViewItem.startAnimation(anim);
            cardCopy.setOnClickListener(v -> {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copy",status);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(ItemList.this, "Copied", Toast.LENGTH_SHORT).show();

            });

            cardShare.setOnClickListener(v -> {

                Intent sharetexT = new Intent(Intent.ACTION_SEND)
                        .setType("text/plain")
                        .putExtra(Intent.EXTRA_TEXT, status);
                startActivity(Intent.createChooser(sharetexT, "Share Via"));
            });




            return myView;
        }
    }//============================MyAdapter End========================

    private void itemTable(){




        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সবচেয়ে সুন্দর গোলাপ।\nশুভ রোজ ডে!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটি গোলাপ দিলাম ভালোবাসার নিদর্শন হিসেবে।\nতুমি আমার প্রাণ।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার হাসি গোলাপের মতো মিষ্টি।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "রোজ ডে'তে তোমাকে একগুচ্ছ গোলাপ দিলাম।\nভালোবাসা রইল অটুট।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের রঙিন ফুল।\nসদা পাশে থাকো তাই কামনা।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার জন্য গোলাপ, আমার হৃদয়ের ভাষা।\nশুভ রোজ ডে প্রিয়জন!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "প্রেমের শুরু গোলাপ দিয়ে,\nশেষ হবে ভালোবাসায় ভরা জীবনে।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার বাগানের গোলাপ।\nচিরসবুজ এবং অমলিন।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার জন্য রঙিন গোলাপের শুভেচ্ছা।\nশুভ রোজ ডে!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "গোলাপের মতোই তুমি কোমল ও সুন্দর।\nআমার ভালোবাসার প্রতীক তুমি।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার হাসিতে ফুটুক গোলাপের মত কোমলতা।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসায় রঙিন আমার জীবন।\nশুভ রোজ ডে তোমাকে!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের ফুলের বাগান।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "রোজ ডে’তে তোমায় দিলাম একগুচ্ছ ভালোবাসা।\nচিরদিন থাকো পাশে।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের রং, আমার ভালোবাসা।\nশুভ রোজ ডে তোমাকে।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার হাসি যেন গোলাপের মতোই কোমল।\nভালোবাসা রইল চিরকাল।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য।\nরোজ ডে’তে রইল ভালোবাসার উপহার।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটি গোলাপ তোমার জন্য,\nআমার ভালোবাসার নিদর্শন।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের একমাত্র রঙিন গোলাপ।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসায় ভাসি আমি,\nরোজ ডে’তে দিলাম গোলাপটি।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া বাগানটা শূন্য,\nতাই তোমায় দিলাম রোজ ডে’র শুভেচ্ছা।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার চোখের ভাষায় মিশে আছে গোলাপের সুবাস।\nভালোবাসা রইল চিরদিন।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার জন্য রঙিন গোলাপ আর ভালোবাসা।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "রোজ ডে’তে তোমায় দিলাম ভালোবাসার ফুল।\nচিরদিন পাশে থাকো তুমি।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের বসন্ত, আমার গোলাপ।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটি গোলাপ দিলাম তোমার জন্য,\nভালোবাসার নিদর্শন রোজ ডে’তে।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সেরা ফুল,\nশুভ রোজ ডে তোমায়।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার জন্য রোজ ডে’তে দিলাম গোলাপের শুভেচ্ছা।\nভালোবাসা চিরকাল অটুট।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের ফুল,\nতোমার জন্য রোজ ডে শুভেচ্ছা।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সবচেয়ে কোমল গোলাপ।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "রোজ ডে’তে দিলাম তোমার জন্য গোলাপের ভাষা।\nভালোবাসা রইল চিরদিন।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের ফুলের মতো।\nভালোবাসা রইল রোজ ডে’তে।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার গন্ধ,\nরোজ ডে’তে দিলাম এক গোলাপ।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসায় আমার জীবন রঙিন।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের একমাত্র গোলাপ।\nশুভ রোজ ডে তোমায়।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সবচেয়ে প্রিয় ফুল।\nরোজ ডে’তে দিলাম তোমায় ভালোবাসা।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসায় আমার হৃদয় ফুলে ভরে।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার বাগানের গোলাপ।\nচিরসবুজ ও মিষ্টি।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "রোজ ডে’তে তোমায় দিলাম হৃদয়ের ফুল।\nভালোবাসা রইল চিরকাল।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের ফুলের মতোই কোমল।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার জন্য রঙিন গোলাপের শুভেচ্ছা।\nভালোবাসা রইল সারা জীবন।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের রং, আমার ভালোবাসা।\nশুভ রোজ ডে!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটি গোলাপ দিলাম তোমার জন্য,\nআমার ভালোবাসার ভাষা।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের ফুলের মতো।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "রোজ ডে’তে তোমার জন্য দিলাম গোলাপ।\nভালোবাসা রইল চিরদিন।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের ফুলের মতোই মিষ্টি।\nশুভ রোজ ডে তোমায়।");
        roseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমাকে গোলাপের চেয়ে বেশি ভালোবাসি।\nশুভ রোজ ডে প্রিয়!");
        roseDay.add(hashMap);





        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সবচেয়ে সুন্দর সিদ্ধান্ত।\nআমার প্রেমে পড়বে কি?");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার ঠিকানা,\nতাই তোমাকে চাই সারা জীবন আমার পাশে।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আজকের দিনে বলছি তোমায়,\nআমার প্রেম তুমি গ্রহণ করবে কি?");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি যদি রাজি হও,\nআমার জীবন হয়ে যাবে পরিপূর্ণ।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের রানী,\nচলো, আমি হব তোমার রাজা।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আমার হাত তোমার হাতে দিলে,\nজীবনটা হবে সোনা ও মধুর।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আমার ভালোবাসার গল্পের শুরু তুমি,\nআজ প্রস্তাব করছি, আমার হয়ে যাও।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি যদি রাজি হও,\nআমি সারাজীবন তোমার হব।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আমার হৃদয়ের কথা শোনো,\nআমাকে তোমার জীবন করার অনুমতি দাও।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমায় পেয়ে জীবনটা হয়ে গেছে পূর্ণ,\nআমার প্রেম তুমি গ্রহণ করবে কি?");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আজকের দিনে, প্রণয়ের দিনে,\nতুমি কি আমার হয়ে যাও?");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া আমার জীবন শুন্য,\nতাই আজ প্রস্তাব দিচ্ছি তোমায়।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আমার হৃদয় তোমার জন্য কাঁদছে,\nতুমি কি আমার প্রেম গ্রহণ করবে?");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আমার জীবন তোমায় নিয়েই সুন্দর,\nচলো, আমরা শুরু করি একসাথে।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের রাণী,\nআমার ভালোবাসা তোমার কাছে।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আজকের দিনে বলছি তোমায়,\nআমার জীবন হও তোমার।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমাকে নিয়ে স্বপ্ন দেখি,\nআমার প্রেম তুমি গ্রহণ করবে কি?");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন অসূচি,\nতুমি কি আমার প্রেম গ্রহণ করবে?");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি যদি রাজি হও,\nআমি হব তোমার ছায়া সারাজীবন।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের আলো,\nতুমি কি আমার হয়ে যাবে?");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আমার প্রেমের প্রস্তাব নিচ্ছ?\nচলো, আমরা একসাথে থাকি।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nতাই আজ প্রস্তাব দিচ্ছি তোমায়।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার ঠিকানা,\nচলো, আমরা একসাথে থাকি।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি যদি রাজি হও,\nআমি হব তোমার পাশে সবসময়।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আমার ভালোবাসা তোমায় নিবেদিত,\nতুমি কি আমার প্রেম গ্রহণ করবে?");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আজকের দিনে বলছি তোমায়,\nআমার জীবন হয়ে যাও।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শুন্য,\nতাই আজ প্রস্তাব দিচ্ছি তোমায়।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আমার হৃদয়ের কথা শুনতে চাও?\nআমি তোমাকে চিরকাল ভালোবাসি।");
        proposeDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সবচেয়ে সুন্দর অধ্যায়,\nতুমি কি আমার হয়ে যাবে?");
        proposeDay.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের মিষ্টি চকলেট,\nভালোবাসা তোমায় চিরদিন রইল।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মত মিষ্টি তুমি,\nআমার ভালোবাসার প্রতীক।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার হাসি মিষ্টি চকলেটের মত,\nভালোবাসায় ভরা হৃদয় আমার।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের গন্ধে তোমার কথা,\nভালোবাসায় ভরে যায় মন।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন মিষ্টি নয়,\nচকলেটের মতো তোমাকে চাই।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "মিষ্টি চকলেটের মতো তোমার ভালোবাসা,\nচিরকালই রইল আমার কাছে।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার স্পর্শ,\nআমার হৃদয় দেয় ভালোবাসার বার্তা।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সেরা চকলেট,\nভালোবাসা দিয়ে ভরিয়ে দাও মন।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতোই মিষ্টি তোমার হাসি,\nভালোবাসায় ভরা জীবনের রঙ।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন ফাঁকা,\nচকলেট দিয়ে মিষ্টি করে দাও।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো তোমার ভালোবাসা,\nআমার জীবনের sweetest উপহার।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার হাতে চকলেটের মত মধুর স্পর্শ,\nভালোবাসায় ভরে যায় মন।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেট দিয়ে দিলাম ভালোবাসার বার্তা,\nতুমি চিরদিন থাকো পাশে।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চকলেট,\nভালোবাসা দিয়ে ভরিয়ে দাও।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার ভালোবাসা,\nআমার হৃদয় দেয় শান্তি।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest সঙ্গী,\nচকলেট দিয়ে ভালোবাসা জানাই।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি ভালোবাসা,\nতুমি আমার জীবনের আলোর ঝিলিক।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন ফাঁকা,\nচকলেটের মতো মিষ্টি ভালোবাসা চাই।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার হাসি মিষ্টি চকলেটের মত,\nভালোবাসায় ভরা হৃদয় আমার।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার ভালোবাসা,\nআমার হৃদয়ে চিরকাল থাকবে।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চকলেট,\nভালোবাসা দিয়ে ভরিয়ে দাও।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার স্পর্শ,\nআমার জীবন হয়ে গেছে রঙিন।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন মিষ্টি নয়,\nচকলেট দিয়ে মধুর করো।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসা মিষ্টি চকলেটের মতো,\nআমার হৃদয়ের সুর।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার হাসি,\nভালোবাসায় ভরা জীবন।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest অংশ,\nচকলেট দিয়ে দিলাম ভালোবাসা।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার ভালোবাসা,\nআমার হৃদয়ের আনন্দ।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nচকলেট দিয়ে পূর্ণ করো আমার মন।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসা মিষ্টি চকলেটের মতো,\nআমার জীবন ভরে গেছে আনন্দে।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার স্পর্শ,\nআমার হৃদয়ের শান্তি।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest সঙ্গী,\nচকলেট দিয়ে ভালোবাসা জানাই।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার ভালোবাসা,\nআমার হৃদয়ে চিরকাল থাকবে।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nচকলেট দিয়ে মধুর করো আমার মন।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চকলেট,\nভালোবাসায় ভরিয়ে দাও।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার হাসি,\nভালোবাসায় ভরা হৃদয় আমার।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest ফুল,\nচকলেট দিয়ে ভালোবাসা জানাই।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসা মিষ্টি চকলেটের মতো,\nআমার হৃদয়ের শান্তি।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চকলেটের মতো মিষ্টি তোমার স্পর্শ,\nআমার জীবন রঙিন করে।");
        chocolateDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest অংশ,\nচকলেট দিয়ে দিলাম ভালোবাসা।");
        chocolateDay.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের ছোট্ট টেডি,\nযার মতো স্নেহময় ও মিষ্টি।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো তোমার আলিঙ্গনে\nআমার মন পায় শান্তি।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার টেডির মতো কোমল,\nসব দুঃখ ভুলিয়ে দাও।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো তোমার ভালোবাসা\nআমার হৃদয় গরম করে।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো তুমি আমার পাশে থাকো,\nসুখ-দুঃখে সঙ্গী হও।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের মিষ্টি টেডি,\nযার স্পর্শে মন ভরে যায় ভালোবাসায়।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো তোমার স্নেহময় আলিঙ্গন\nআমার হৃদয়কে দেয় শান্তি।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ছোট্ট টেডি,\nযার মতো আমি সবসময় চাই কাছে।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার হাসি,\nআমার জীবন হয়ে যায় রঙিন।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের প্রিয় টেডি,\nতোমার ভালোবাসায় ভরে মন।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো তোমার স্পর্শে\nআমি খুঁজে পাই শান্তি।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার টেডির মতো কোমল,\nতোমার ভালোবাসায় জীবন মধুর।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো তুমি আমার সঙ্গী,\nসব সময় পাশে থাকো।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের টেডি,\nতোমার আলিঙ্গনে পায় মন শান্তি।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার ভালোবাসা,\nআমার হৃদয় গায়ে শান্তি দেয়।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার প্রিয় টেডি,\nতোমার হাসিতে ভরে মন।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো তোমার স্পর্শে\nআমি পাই শান্তি ও স্নেহ।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের টেডি,\nযার ভালোবাসা অমলিন।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার হৃদয়,\nসবসময় আমার পাশে থাকো।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ছোট্ট টেডি,\nযার ভালোবাসায় ভরে জীবন।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো তোমার আলিঙ্গন\nআমার মন ভরে দেয় ভালোবাসায়।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের প্রিয় টেডি,\nতোমার হাসি নিয়ে সুখী থাকি।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার স্পর্শ,\nআমার হৃদয় গুলো মিষ্টি হয়ে যায়।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার প্রিয় টেডি,\nতোমার ভালোবাসায় বেঁচে থাকি।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার মায়া,\nআমার হৃদয় খুশিতে ভরে যায়।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের টেডি,\nযার ভালোবাসা চিরন্তন।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার স্পর্শ,\nআমার মনকে দেয় শান্তি।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার প্রিয় টেডি,\nতোমার ভালোবাসায় জীবনের আনন্দ।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার মধুর হাসি,\nআমার হৃদয় গুলো পাগল হয়।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের প্রিয় টেডি,\nযার ভালোবাসা আমার সব।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার আলিঙ্গন,\nআমার মন ভরে যায় ভালোবাসায়।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের টেডি,\nতোমার ভালোবাসায় পায় সুখ।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার ভালোবাসা,\nআমার হৃদয় গুলো মধুর হয়।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের প্রিয় টেডি,\nতোমার সাথে কাটাবো চিরকাল।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার হাসি,\nআমার হৃদয় ভরে যায় ভালোবাসায়।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের টেডি,\nতোমার ভালোবাসা আমার শক্তি।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার স্পর্শ,\nআমার হৃদয়ে ভালোবাসার আগুন জ্বলে।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার প্রিয় টেডি,\nতোমার সাথে জীবনটা সুন্দর।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার মায়া,\nআমার হৃদয়ে চিরকাল থাকবে।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের প্রিয় টেডি,\nতোমার ভালোবাসায় ভরে মন।");
        teddyDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "টেডির মতো কোমল তোমার হাসি,\nআমার হৃদয় ভরে যায় প্রেমে।");
        teddyDay.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("status", "তোমাকে কখনো ছেড়ে যাবো না,\nআমার জীবনের অঙ্গ তুমি।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চিরকাল তোমার পাশে থাকবো,\nএই প্রতিজ্ঞা জানাই আজকে।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের একমাত্র,\nআমি তোমায় কখনো ভুলবো না।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "সুখে-দুঃখে তোমার সঙ্গী হবো,\nএই প্রতিজ্ঞা আমার চিরন্তন।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার ঠিকানা,\nতাই থাকবো পাশে সারাজীবন।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আমার ভালোবাসায় তোমায় বেঁধে রাখবো,\nচিরকাল তোমার হবো আমি।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন অসম্পূর্ণ,\nএই প্রতিজ্ঞা তোমায় দিলাম।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সাথী,\nচিরদিন তোমার পাশে থাকবো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমায় ভালোবেসে বাঁচবো আমি,\nএই প্রতিজ্ঞা আজ করছি।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের শান্তি,\nএই প্রতিজ্ঞা অটুট রাখবো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "সবসময় তোমার হাত ধরবো,\nচিরকাল থাকবে ভালোবাসা।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার পাশে থাকাই আমার স্বপ্ন,\nএই প্রতিজ্ঞা কখনো ভাঙবে না।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার চিরসঙ্গী,\nচিরকাল থাকবো তোমার কাছে।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার জন্য আমার প্রাণ উৎসর্গ,\nএই প্রতিজ্ঞা রাখবো সারা জীবন।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nএই প্রতিজ্ঞা তোমায় দিলাম।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের আলো,\nএই প্রতিজ্ঞা ভাঙবো না কখনো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার ঠিকানা,\nচিরকাল থাকবো তোমার সাথে।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমাকে কখনো ছেড়ে যাবো না,\nএই প্রতিজ্ঞা আমার অটুট।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সুখ,\nএই প্রতিজ্ঞা রাখবো চিরকাল।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন অসম্পূর্ণ,\nতাই এই প্রতিজ্ঞা দিলাম তোমায়।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার পরশ,\nএই প্রতিজ্ঞা ভাঙবে না কখনো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "সবসময় তোমার পাশে থাকবো,\nএই প্রতিজ্ঞা তোমায় দিলাম।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের শান্তি,\nএই প্রতিজ্ঞা অটুট রাখবো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসা কখনো মুছে যাবেনা,\nএই প্রতিজ্ঞা রাখবো সারাজীবন।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সাথী,\nএই প্রতিজ্ঞা তোমায় দিলাম।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nএই প্রতিজ্ঞা অটুট রাখবো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার ঠিকানা,\nএই প্রতিজ্ঞা কখনো ভাঙবে না।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "সবসময় তোমার হাত ধরবো,\nএই প্রতিজ্ঞা রাখবো চিরকাল।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমাকে ভালোবেসে বাঁচবো আমি,\nএই প্রতিজ্ঞা আজ করছি।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের আলো,\nএই প্রতিজ্ঞা ভাঙবো না কখনো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন অসম্পূর্ণ,\nএই প্রতিজ্ঞা তোমায় দিলাম।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের শান্তি,\nএই প্রতিজ্ঞা অটুট রাখবো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার চিরসঙ্গী,\nচিরকাল থাকবো তোমার কাছে।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সুখ,\nএই প্রতিজ্ঞা রাখবো সারাজীবন।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nএই প্রতিজ্ঞা তোমায় দিলাম।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার পরশ,\nএই প্রতিজ্ঞা ভাঙবে না কখনো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের আলো,\nএই প্রতিজ্ঞা ভাঙবো না কখনো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার ঠিকানা,\nচিরকাল থাকবো তোমার সাথে।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন অসম্পূর্ণ,\nএই প্রতিজ্ঞা তোমায় দিলাম।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সুখ,\nএই প্রতিজ্ঞা রাখবো চিরকাল।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের শান্তি,\nএই প্রতিজ্ঞা অটুট রাখবো।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের সাথী,\nএই প্রতিজ্ঞা তোমায় দিলাম।");
        promiseDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nএই প্রতিজ্ঞা ভাঙবো না কখনো।");
        promiseDay.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ঠোঁটের কোমল স্পর্শে\nআমার হৃদয় ভরে যায় ভালোবাসায়।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটা চুম্বন তোমার,\nআমার জীবনের sweetest মুহূর্ত।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ঠোঁটের মিষ্টি চুম্বন\nআমার মনকে দেয় শান্তি।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বন দিয়ে বলি আমি তোমায়\nভালোবাসি সবসময়।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nআমার হৃদয়ে চিরকাল থাকবে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার চুম্বন আমার জীবনের গান,\nভালোবাসায় ভরে যায় মন।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটা চুম্বনে তোমায় বলতে চাই\nতুমি আমার সব।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ঠোঁটের মিষ্টি স্পর্শ\nআমার জীবনের sweetest অংশ।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বন দিয়ে বলি আমি তোমায়\nভালোবাসি চিরদিন।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nতোমায় ভালোবাসি অন্তর থেকে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার চুম্বনে লুকিয়ে আছে আমার ভালোবাসা,\nচিরকাল থাকবে আমার হৃদয়ে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটা চুম্বনে তোমায় বলতে চাই\nতুমি আমার জীবন।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ঠোঁটের কোমল স্পর্শে\nআমার মন শান্ত হয়।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nআমার ভালোবাসার প্রতীক।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বন দিয়ে বলি আমি তোমায়\nভালোবাসি আজীবন।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার চুম্বন আমার জীবনের গান,\nভালোবাসায় ভরে যায় হৃদয়।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nচিরকাল থাকো আমার পাশে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বনের মাধ্যমে বলি তোমায়\nআমি তোমায় ভালোবাসি।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ঠোঁটের স্পর্শে\nআমার জীবন মধুর হয়ে ওঠে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nতোমায় ভালোবাসি অন্তর থেকে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বন দিয়ে বলি আমি তোমায়\nভালোবাসি সারাজীবন।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার চুম্বনে লুকিয়ে আছে আমার ভালোবাসা,\nচিরকাল থাকবে আমার হৃদয়ে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nআমার ভালোবাসার প্রতীক।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ঠোঁটের কোমল স্পর্শ\nআমার মন ভরে যায় প্রেমে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বন দিয়ে বলি আমি তোমায়\nভালোবাসি চিরকাল।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nআমার হৃদয়ে চিরকাল থাকবে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার চুম্বনে আমি খুঁজে পাই\nসুখ ও শান্তি।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বনের মাধ্যমে বলি তোমায়\nআমি তোমায় ভালোবাসি।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nতোমায় ভালোবাসি অন্তর থেকে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ঠোঁটের স্পর্শে\nআমার জীবন মধুর হয়ে ওঠে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nচিরকাল থাকো আমার পাশে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বন দিয়ে বলি তোমায়\nআমি তোমায় ভালোবাসি।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ঠোঁটের কোমল স্পর্শ\nআমার হৃদয় ভরে যায় ভালোবাসায়।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nআমার ভালোবাসার প্রতীক।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার চুম্বনে লুকিয়ে আছে আমার ভালোবাসা,\nচিরকাল থাকবে আমার হৃদয়ে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nআমার জীবনের আলো।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বন দিয়ে বলি আমি তোমায়\nভালোবাসি আজীবন।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nতুমি ছাড়া জীবন ফাঁকা।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ঠোঁটের স্পর্শে\nআমার জীবন মধুর হয়ে ওঠে।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest চুম্বন,\nভালোবাসায় ভরে যায় মন।");
        kissDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "চুম্বনের মাধ্যমে বলি তোমায়\nআমি তোমায় ভালোবাসি।");
        kissDay.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে আমি খুঁজে পাই শান্তি,\nহৃদয় ভরে যায় ভালোবাসায়।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটা আলিঙ্গন তোমার,\nআমার জীবনের sweetest অনুভূতি।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গন আমার জীবনের আশ্রয়,\nভালোবাসায় ভরে যায় মন।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গন দিয়ে বলি আমি তোমায়\nভালোবাসি চিরকাল।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nআমার হৃদয়ে চিরকাল থাকবে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে আমি খুঁজে পাই শান্তি,\nভালোবাসায় ভরে যায় মন।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটা আলিঙ্গনে তোমায় বলতে চাই\nতুমি আমার সব।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গন আমার জীবনের sweetest অংশ।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গন দিয়ে বলি আমি তোমায়\nভালোবাসি আজীবন।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nতোমায় ভালোবাসি অন্তর থেকে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে লুকিয়ে আছে আমার ভালোবাসা,\nচিরকাল থাকবে আমার হৃদয়ে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "একটা আলিঙ্গনে তোমায় বলতে চাই\nতুমি আমার জীবন।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে আমি খুঁজে পাই সুখ ও শান্তি।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nআমার ভালোবাসার প্রতীক।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গন দিয়ে বলি আমি তোমায়\nভালোবাসি সারাজীবন।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nচিরকাল থাকো আমার পাশে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গনের মাধ্যমে বলি তোমায়\nআমি তোমায় ভালোবাসি।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে আমার জীবন মধুর হয়ে ওঠে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nতোমায় ভালোবাসি অন্তর থেকে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গন দিয়ে বলি আমি তোমায়\nভালোবাসি চিরদিন।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে লুকিয়ে আছে আমার ভালোবাসা,\nচিরকাল থাকবে আমার হৃদয়ে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nআমার ভালোবাসার প্রতীক।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে আমার মন ভরে যায় প্রেমে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গন দিয়ে বলি আমি তোমায়\nভালোবাসি চিরকাল।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nআমার হৃদয়ে চিরকাল থাকবে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে আমি খুঁজে পাই সুখ ও শান্তি।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গনের মাধ্যমে বলি তোমায়\nআমি তোমায় ভালোবাসি।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nতোমায় ভালোবাসি অন্তর থেকে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে আমার জীবন মধুর হয়ে ওঠে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nচিরকাল থাকো আমার পাশে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গন দিয়ে বলি তোমায়\nআমি তোমায় ভালোবাসি।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে আমার হৃদয় ভরে যায় ভালোবাসায়।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nআমার ভালোবাসার প্রতীক।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে লুকিয়ে আছে আমার ভালোবাসা,\nচিরকাল থাকবে আমার হৃদয়ে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nআমার জীবনের আলো।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গন দিয়ে বলি আমি তোমায়\nভালোবাসি আজীবন।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nতুমি ছাড়া জীবন ফাঁকা।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার আলিঙ্গনে আমার জীবন মধুর হয়ে ওঠে।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest আলিঙ্গন,\nভালোবাসায় ভরে যায় মন।");
        hugDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "আলিঙ্গনের মাধ্যমে বলি তোমায়\nআমি তোমায় ভালোবাসি।");
        hugDay.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের চিরন্তন বাসা,\nতোমায় ভালোবাসি আজীবন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার হাসিই আমার জীবনের আলো,\nতুমি আমার ভালোবাসার ঠিকানা।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest গান,\nতোমায় ছাড়া আমি অসম্পূর্ণ।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসায় আমার জীবন রঙিন,\nতুমি আমার প্রাণের প্রিয়া।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nতাই তোমায় ভালোবাসি অন্তর থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের মধুর সুর,\nতোমায় ভালোবাসি চিরদিন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের আকাশ,\nভালোবাসার মেঘে ঢাকা।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তোমার ভালোবাসায় আমি বাঁচি,\nতুমি ছাড়া কিছু চাই না।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের স্পন্দন,\nতোমায় ছাড়া কিছু চাই না।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest স্বপ্ন,\nতোমায় ভালোবাসি আজীবন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের আলো,\nতুমি ছাড়া কিছু দেখতে পাই না।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার রং,\nআমার হৃদয়ের স্পন্দন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের ফুল,\nতোমায় ভালোবাসি অন্তর থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার প্রতীক,\nচিরকাল থাকো পাশে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের কবিতা,\nতোমায় ভালোবাসি প্রাণ থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nতাই তোমায় ভালোবাসি।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest অংশ,\nতোমায় ভালোবাসি অন্তর থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের গান,\nতোমায় ভালোবাসি চিরকাল।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের মিষ্টি হাসি,\nতুমি ছাড়া কিছু চাই না।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার আলো,\nআমার হৃদয়ের স্পন্দন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nতাই তোমায় ভালোবাসি।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের মধুর সুর,\nতোমায় ভালোবাসি অন্তর থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest গান,\nতোমায় ভালোবাসি আজীবন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের ফুল,\nতোমায় ভালোবাসি অন্তর থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের আলো,\nতোমায় ভালোবাসি চিরদিন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nতাই তোমায় ভালোবাসি।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার প্রতীক,\nচিরকাল থাকো পাশে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest অংশ,\nতোমায় ভালোবাসি অন্তর থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের গান,\nতোমায় ভালোবাসি চিরকাল।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের মিষ্টি হাসি,\nতুমি ছাড়া কিছু চাই না।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার আলো,\nআমার হৃদয়ের স্পন্দন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nতাই তোমায় ভালোবাসি।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের মধুর সুর,\nতোমায় ভালোবাসি অন্তর থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest গান,\nতোমায় ভালোবাসি আজীবন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের ফুল,\nতোমায় ভালোবাসি অন্তর থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের আলো,\nতোমায় ভালোবাসি চিরদিন।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি ছাড়া জীবন শূন্য,\nতাই তোমায় ভালোবাসি।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার প্রতীক,\nচিরকাল থাকো পাশে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের sweetest অংশ,\nতোমায় ভালোবাসি অন্তর থেকে।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার হৃদয়ের গান,\nতোমায় ভালোবাসি চিরকাল।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার জীবনের মিষ্টি হাসি,\nতুমি ছাড়া কিছু চাই না।");
        valentineDay.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("status", "তুমি আমার ভালোবাসার আলো,\nআমার হৃদয়ের স্পন্দন।");
        valentineDay.add(hashMap);



    }



}//==========================Method End=========================================