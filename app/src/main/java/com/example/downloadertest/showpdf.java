package com.example.downloadertest;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.Util;

import java.io.File;

public class showpdf extends AppCompatActivity {
PDFView pdfsample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_showpdf);
        pdfsample = findViewById(R.id.pdfsample);
        File file = new File(getFilesDir().getAbsolutePath()+ File.separator+"downloads"+File.separator+"notes.pdf");
        pdfsample.fromFile(file).load();
    }
}
