package top.webdbw.tallybook;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import top.webdbw.tallybook.anim.MainRecyclerViewAnimator;
import top.webdbw.tallybook.model.MainListItem;

/**
 * 主页面
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    private Context mContext;

    private RecyclerView mRecyclerView;
    private MainRecyclerViewAdapter mAdapter;
    private FloatingActionButton mFloatButton;
    private Toolbar mToolbar;

    public static MainFragment newInstance(Bundle args) {
        MainFragment mainFragment = new MainFragment();
        if (args != null) {
            mainFragment.setArguments(args);
        }
        return new MainFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_home_layout, container, false);
        mToolbar = view.findViewById(R.id.toolbar);
        mRecyclerView = view.findViewById(R.id.recycler_main);
        mFloatButton = view.findViewById(R.id.float_btn_add);
        mFloatButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initToolBar();

        initRecyclerView();
    }

    private void initToolBar() {
        TextView title = mToolbar.findViewById(R.id.toolbar_title);
        title.setText("2019年4月20日");
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new MainRecyclerViewAdapter(mContext, createData());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new MainItemDecoration(mContext.getResources().getDimensionPixelOffset(R.dimen.main_list_item_offset)));

        MainRecyclerViewAnimator animator = new MainRecyclerViewAnimator();
        animator.setAddDuration(3000);
        animator.setRemoveDuration(3000);
        mRecyclerView.setItemAnimator(animator);
    }

    //TODO 临时拼接一个数据，后续接入网络请求
    private List<MainListItem> createData() {
        List<MainListItem> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            MainListItem item = new MainListItem();
            item.type = 1;
            item.content = "第" + i + "个卡片";
            data.add(item);
        }

        return data;
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.float_btn_add) {
//            DetailFragment detailFragment = new DetailFragment();
//            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//            transaction.add(R.id.container_main, detailFragment).addToBackStack(null).commit();
            addItem();
        }
    }

    private void addItem() {
        MainListItem item = new MainListItem();
        item.content = "新加的View";
        item.type = 3;

        mAdapter.addItem(item, 2);
    }

    private class MainItemDecoration extends RecyclerView.ItemDecoration {

        private int offset;

        MainItemDecoration(int topOffset) {
            this.offset = topOffset;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.top = offset;
        }
    }

}
