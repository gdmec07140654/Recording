package com.zwz.android.recording;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import java.util.UUID;


public class RecordActivity extends SingleFragmentActivity {
    //public static final String EXTRA_REOCRD_ID="com.zwz.android.recording.record_id";
    private static final String EXTRA_REOCRD_ID = "com.zwz.android.recording.record_id";

    public static Intent newIntent(Context packageContext, UUID recordId) {
        Intent intent = new Intent(packageContext, RecordActivity.class);
        intent.putExtra(EXTRA_REOCRD_ID, recordId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        //return new RecordFragment();
        UUID recordId = (UUID) getIntent().getSerializableExtra(EXTRA_REOCRD_ID);
        return RecordFragment.newInstance(recordId);
    }

   /*  @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragment_Container);
        if(fragment==null){
            fragment=new RecordFragment();
            fm.beginTransaction().add(R.id.fragment_Container,fragment).commit();

        }
    }
      */
}
