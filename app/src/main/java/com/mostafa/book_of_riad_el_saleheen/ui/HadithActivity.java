package com.mostafa.book_of_riad_el_saleheen.ui;

import android.os.Bundle;

import com.mostafa.book_of_riad_el_saleheen.R;
import com.mostafa.book_of_riad_el_saleheen.model.Message;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

public class HadithActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahadith);

        //initialize the pager
        this.initialisePaging();

    }

    private void initialisePaging() {

        Bundle extras = getIntent().getExtras();

        String value = Objects.requireNonNull(extras).getString("first_hadith_index");

        int position = 1;

        if (Objects.requireNonNull(value).equals("No_Index")) {

            Message.message(this, "There is no Ahadith in this chapter." +
                    " Choose another chapter.");

        } else {

            position = Integer.parseInt(Objects.requireNonNull(value)) - 1;

        }

        List<Fragment> fragments = new LinkedList<>();

        for (int i = 0; i < 1896; i++)
            fragments.add(new HadithFragment(i));

        ViewPagerAdapter mAdapter = new ViewPagerAdapter(super.getSupportFragmentManager(), fragments);

        ViewPager viewPager = findViewById(R.id.viewpager);

        viewPager.setAdapter(mAdapter);

        viewPager.setCurrentItem(position);

        viewPager.setOffscreenPageLimit(2);

    }

}
