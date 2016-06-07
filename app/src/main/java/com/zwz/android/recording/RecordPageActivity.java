package com.zwz.android.recording;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class RecordPageActivity extends AppCompatActivity {
    private static final String EXTRA_RECORD_ID = "com.zwz.android.recording.record_id";
    private ViewPager mViewPager;
    private List<Record> mRecordlist;

    public static Intent newIntent(Context packageContent, UUID recordId) {
        Intent intent = new Intent(packageContent, RecordPageActivity.class);
        intent.putExtra(EXTRA_RECORD_ID, recordId);
        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_pager);
        UUID recordId = (UUID) getIntent().getSerializableExtra(EXTRA_RECORD_ID);
        mViewPager = (ViewPager) findViewById(R.id.activity_record_view_pager);
        mRecordlist = RecordLab.get(this).getRecords();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Record record = mRecordlist.get(position);
                return RecordFragment.newInstance(record.getId());
            }

            @Override
            public int getCount() {
                return mRecordlist.size();
            }
        });
        for (int i = 0; i < mRecordlist.size(); i++) {
            if (mRecordlist.get(i).getId().equals(recordId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }
}
