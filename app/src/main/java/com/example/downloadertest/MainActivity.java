package com.example.downloadertest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.PRDownloaderConfig;
import com.downloader.Progress;

import java.io.File;

public class MainActivity extends AppCompatActivity {
Button downBtn,viewBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downBtn =findViewById(R.id.downBtn);
        viewBtn =findViewById(R.id.viewBtn);
        PRDownloader.initialize(getApplicationContext());

        PRDownloaderConfig config = PRDownloaderConfig.newBuilder()
                .setDatabaseEnabled(true)
                .build();
        PRDownloader.initialize(getApplicationContext(), config);

        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Download();
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,showpdf.class);
                startActivity(intent);
            }
        });

    }

    private void Download()
    {   String url ="https://firebasestorage.googleapis.com/v0/b/downloader-test-f1bf4.appspot.com/o/os_syllabus.pdf?alt=media&token=17cc509c-130e-4c44-9507-8a117ca06602";
        String fileName = "notes.pdf";
        String dirPath = getFilesDir().getAbsolutePath()+ File.separator+"downloads";
        int downloadId = PRDownloader.download(url, dirPath, fileName)
            .build()
            .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                @Override
                public void onStartOrResume() {

                    Log.d("TAG", "navdeep");

                }
            })
            .setOnPauseListener(new OnPauseListener() {
                @Override
                public void onPause() {
                    Log.d("TAG", "navdeep1");

                }
            })
            .setOnCancelListener(new OnCancelListener() {
                @Override
                public void onCancel() {
                    Log.d("TAG", "navdeep2");
                }
            })
            .setOnProgressListener(new OnProgressListener() {
                @Override
                public void onProgress(Progress progress) {
                    Log.d("TAG", "navdeep3");

                }
            })
            .start(new OnDownloadListener() {
                @Override
                public void onDownloadComplete() {
                    Log.d("TAG", "navdeep4");


                }

                @Override
                public void onError(Error error) {

                    Log.d("TAG", "error");

                }


            });

//        PRDownloader.pause(downloadId);
//        PRDownloader.cancel(downloadId);


    }


}

