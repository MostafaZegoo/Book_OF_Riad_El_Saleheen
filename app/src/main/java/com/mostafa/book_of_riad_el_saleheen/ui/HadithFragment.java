package com.mostafa.book_of_riad_el_saleheen.ui;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mostafa.book_of_riad_el_saleheen.R;
import com.mostafa.book_of_riad_el_saleheen.model.Ahadith;
import com.mostafa.book_of_riad_el_saleheen.repository.DatabaseAccess;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HadithFragment extends Fragment {

    private int index;

    HadithFragment(int index) {
        this.index = index;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_webview, container, false);

        WebView webView = view.findViewById(R.id.webview);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());

        databaseAccess.open();

        List<Ahadith> ahadith = databaseAccess.getAhadith();

        List<String> ar_text = new ArrayList<>();

        for (Ahadith hadith : ahadith) {

            ar_text.add(hadith.getAr_Text());

        }

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        //webSettings.setBuiltInZoomControls(true);

        String data = "<html><body><div>"+
                ar_text.get(index) +
                "</div></body></html>";

        webView.loadDataWithBaseURL(null, data, "text/html; charset=utf-8", "utf-8", null);

        //webView.loadUrl("https://www.google.com/");

        // Force links and redirects to open in the WebView instead of in a browser
        webView.setWebViewClient(new WebViewClient());

        databaseAccess.close();

        return view;

    }

}

