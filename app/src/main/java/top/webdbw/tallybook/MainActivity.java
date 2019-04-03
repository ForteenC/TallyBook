package top.webdbw.tallybook;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fragment mainFragment = MainFragment.newInstance(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, mainFragment)
                .commitAllowingStateLoss();
    }
}
