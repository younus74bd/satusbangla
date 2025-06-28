package com.techguru.statusbangla;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    HashMap<String, String> statusMap;
    ArrayList<HashMap<String,String>> arrayList;
    List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Initialize HashMap
        statusMap = new HashMap<>();
        statusMap.put("ভালোবাসা", "ভালবাসা মানে শুধু পাওয়া নয়, ভালবাসা মানে অপেক্ষা করা।");
        statusMap.put("কান্না", "যে কাঁদতে জানে, সে সত্যিকারের ভালোবাসে।");
        statusMap.put("একতরফা প্রেম", "ভালোবাসা কখনো একতরফা হয় না।");
        statusMap.put("সাথী", "যে মানুষটা সব সময় তোমার পাশে থাকে, তাকেই সবচেয়ে বেশি মূল্য দাও।");
        statusMap.put("হারিয়ে যাওয়া", "হারিয়ে ফেললে বোঝা যায়, কতটা দরকার ছিলো।");
        statusMap.put("হাসি", "তোমার হাসি আমার জীবনের সবচেয়ে বড় প্রাপ্তি।");

        // Get keys for ListView
        titleList = new ArrayList<>(statusMap.keySet());

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                titleList
        );

        listView.setAdapter(adapter);

        // On Click – Show full status
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = titleList.get(position);
                String fullStatus = statusMap.get(key);

                Toast.makeText(MainActivity.this, fullStatus, Toast.LENGTH_LONG).show();
            }
        });
    }
}
