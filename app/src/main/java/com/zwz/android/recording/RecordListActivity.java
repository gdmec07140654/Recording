package com.zwz.android.recording;

import android.support.v4.app.Fragment;

public class RecordListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new RecordListFragment();
    }
}
