package com.techguru.statusbangla;

import static android.view.View.VISIBLE;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.techguru.statusbangla.FragmentCat;
import com.techguru.statusbangla.PrivacyPolicy;
import com.techguru.statusbangla.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    LinearLayout adContainerView;


    DrawerLayout drawer;
    NavigationView navDrawer;
    MaterialToolbar matToolBar;
    View viewAdsAbove;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        navDrawer = findViewById(R.id.navDrawer);
        matToolBar = findViewById(R.id.matToolBar);
        adContainerView= findViewById(R.id.adContainerView);
        viewAdsAbove = findViewById(R.id.viewAdsAbove);





        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frameLayoutMain, new FragmentCat()).commit();








        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this,drawer,matToolBar,R.string.drawer_open,R.string.drawer_close);

        drawer.addDrawerListener(toggle);

        matToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.share_app){
                    Intent sharetexT = new Intent(Intent.ACTION_SEND)
                            .setType("text/plain")
                            .putExtra(Intent.EXTRA_TEXT,"বাংলা স্ট্যাটাস invite you install it and make Romantic Love \n\n "+"https://play.google.com/store/apps/details?id="+getPackageName());
                    startActivity(Intent.createChooser(sharetexT, "Share Via"));

                }
                return false;
            }
        });

        navDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.rateus){

                    if (network()){
                        drawer.closeDrawer(GravityCompat.START);
                        try{
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
                        }
                        catch (ActivityNotFoundException e){
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                        }
                    } else {
                        drawer.closeDrawer(GravityCompat.START);
                        noInternet_alert();}


                } else if (item.getItemId()==R.id.moreapp) {

                    if (network()){
                        drawer.closeDrawer(GravityCompat.START);
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                    } else {
                        drawer.closeDrawer(GravityCompat.START);
                        noInternet_alert();}

                } else if (item.getItemId()==R.id.privacy) {
                    if (network()){
                        PrivacyPolicy.HEADER="Pivecy Policy";
                        startActivity(new Intent(MainActivity.this,PrivacyPolicy.class));
                        drawer.closeDrawer(GravityCompat.START);
                    } else {
                        drawer.closeDrawer(GravityCompat.START);
                        noInternet_alert();}


                } else if (item.getItemId()==R.id.feedback) {
                    if (network()){
                        drawer.closeDrawer(GravityCompat.START);
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:jtltd@gmail.com")));


                    } else {
                        drawer.closeDrawer(GravityCompat.START);
                        noInternet_alert();

                    }


                }

                return false;
            }
        });





    }//======================onCreate End===================================





    private static final int TIME= 2000;
    private long back;
    @Override
    public void onBackPressed() {
        if (back+TIME>System.currentTimeMillis()){
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
        } back = System.currentTimeMillis();
    }

    private void noInternet_alert() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("No Internet")
                .setMessage("Please check your Internet connection and try again ")
                .setIcon(R.drawable.icon_no_internet)
                .show();

    }

    private boolean network() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) return true;
        else return false;
    }






}//======================Method End===================================