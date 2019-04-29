package top.webdbw.tallybook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import top.webdbw.tallybook.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fragment mainFragment = MainFragment.newInstance(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, mainFragment)
                .commitAllowingStateLoss();
    }
}
