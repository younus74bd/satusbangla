package com.techguru.statusbangla;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class PrivacyPolicy extends AppCompatActivity {
    ImageView imgBack, imgBitmap;
    WebView webView;
    ProgressBar progressBar;
    TextView tvHeader, tvLovePercent, tvName, tvPartner;
    RelativeLayout rlCalculator, rlLoveResult,rlwebView;
    Button btnCalculator, btnAgain, btnDownload;
    LottieAnimationView loveAnim,loading;
    EditText edPartner, edName;
    Animation left_to_right, right_to_left, zoom_in;

    CardView cardViewCalculator;




    public static String HEADER = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        imgBack = findViewById(R.id.imgBack);
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);
        tvHeader = findViewById(R.id.tvHeader);
        rlCalculator = findViewById(R.id.rlCalculator);
        tvLovePercent = findViewById(R.id.tvLovePercent);
        btnCalculator = findViewById(R.id.btnCalculator);
        loveAnim = findViewById(R.id.loveAnim);
        tvName = findViewById(R.id.tvName);
        tvPartner = findViewById(R.id.tvPartner);
        rlwebView = findViewById(R.id.rlwebView);
        edName = findViewById(R.id.edName);
        loading = findViewById(R.id.loading);
        edPartner = findViewById(R.id.edPartner);
        btnAgain = findViewById(R.id.btnAgain);
        btnDownload = findViewById(R.id.btnDownload);
        rlLoveResult = findViewById(R.id.rlLoveResult);
        imgBitmap = findViewById(R.id.imgBitmap);
        cardViewCalculator = findViewById(R.id.cardViewCalculator);
        left_to_right = AnimationUtils.loadAnimation(getBaseContext(), R.anim.left_to_right);
        right_to_left = AnimationUtils.loadAnimation(getBaseContext(), R.anim.right_to_left);
        zoom_in = AnimationUtils.loadAnimation(getBaseContext(), R.anim.zoom_in);


        tvHeader.setText(HEADER);

        btnCalculator.setOnClickListener(v -> {
            String sName = edName.getText().toString();
            String sPartner = edPartner.getText().toString();
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }


            if (sName.trim().length() > 2 && sPartner.trim().length() > 2) {

                loveAnim.setVisibility(View.VISIBLE);
                edName.setVisibility(View.GONE);
                edPartner.setVisibility(View.GONE);
                btnCalculator.setVisibility(View.GONE);





                    String sum = sName + sPartner;
                    sum = sum.toLowerCase(Locale.ROOT);
                    int value = sum.hashCode();
                    Random random = new Random(value);
                    String result = (random.nextInt(100) + 1) + "%";


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvLovePercent.setVisibility(View.VISIBLE);
                            loveAnim.setVisibility(View.GONE);
                            tvLovePercent.setText(result);
                            tvName.setText(sName);
                            tvPartner.setText(sPartner);
                            tvName.setVisibility(View.VISIBLE);
                            tvPartner.setVisibility(View.VISIBLE);
                            tvName.startAnimation(right_to_left);
                            tvPartner.startAnimation(left_to_right);
                            tvLovePercent.startAnimation(zoom_in);
                            btnAgain.setVisibility(View.VISIBLE);
                            btnDownload.setVisibility(View.VISIBLE);
                            imgLoveCalculator();

                        }
                    }, 2000);


            } else if (sName.trim().length() > 2) {
                edPartner.setError("Enter Partner Name");

            } else if (sPartner.trim().length() > 2) {
                edName.setError("Enter Your Name");
            } else {
                edName.setError("Enter Your Name");
                edPartner.setError("Enter Partner Name");
            }

        });

        btnAgain.setOnClickListener(v -> {
            edName.setText("");
            edPartner.setText("");
            recreate();

        });

        btnDownload.setOnClickListener(v -> {
            if (isStoragePermissionGranted()) {
                Bitmap bitmapD = ((BitmapDrawable) imgBitmap.getDrawable()).getBitmap();
                saveImage(bitmapD);
            }


        });


        if (HEADER.contains("Love Calculator")) {
            rlwebView.setVisibility(View.GONE);
            rlCalculator.setVisibility(View.VISIBLE);


        } else if (HEADER.contains("Pivecy Policy")) {



            rlCalculator.setVisibility(View.GONE);
            rlwebView.setVisibility(View.VISIBLE);
            webView.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onProgressChanged(WebView view, int progress) {

                    loading.setProgress(progress * 100);


                    if(progress == 100){
                        loading.setVisibility(View.INVISIBLE);
                    }else {
                        loading.setVisibility(View.VISIBLE);
                    }


                }
            });
            webView.setWebViewClient(new HelloWebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);

            webView.loadUrl("https://sites.google.com/view/mimr-valentines-privacy-policy");

        }


        imgBack.setOnClickListener(view -> {
            finish();
        });

    }// onCreate End================================

    private  class HelloWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("permissionIssue","Permission is granted");
                return true;
            } else {

                Log.v("permissionIssue","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("permissionIssue","Permission is granted");
            return true;
        }
    }





    //===================================================================
    //===================================================================
    private void saveImage(Bitmap finalBitmap) {
        String folderName = "Love Calculator";
        String root = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES).toString();

        File myDir = new File(root + "/"+folderName);
        myDir.mkdirs();

        Random generator = new Random();

        int n = 10000;
        n = generator.nextInt(n);
        String fname = "MimR.Image-"+ n +".jpg";
        File file = new File (myDir, fname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            Toast.makeText(getApplicationContext(), "Download Done!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.d("storageException", e.toString());
            e.printStackTrace();
        }

        MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        Log.i("ExternalStorage", "Scanned " + path + ":");
                        Log.i("ExternalStorage", "-> uri=" + uri);
                    } });
    }


    private void imgLoveCalculator() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = Bitmap.createBitmap(cardViewCalculator.getWidth(), cardViewCalculator.getHeight(),
                        Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                cardViewCalculator.draw(canvas);
                imgBitmap.setImageBitmap(bitmap);
                rlLoveResult.setVisibility(View.GONE);
                imgBitmap.setVisibility(View.VISIBLE);


            }
        }, 2000);

    }


}