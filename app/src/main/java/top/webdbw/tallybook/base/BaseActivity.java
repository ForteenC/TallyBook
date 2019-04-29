package top.webdbw.tallybook.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去除ActionBar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
