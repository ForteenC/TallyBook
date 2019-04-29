package top.webdbw.tallybook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.webdbw.tallybook.model.MainListItem;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder> {

    private Context mContext;
    private List<MainListItem> mData;

    public MainRecyclerViewAdapter(@NonNull Context context, @NonNull List<MainListItem> data) {
        mContext = context;
        mData = data;
    }

    public void addItem(MainListItem item) {
        this.addItem(item, getItemCount());
    }

    public void addItem(MainListItem item, int position) {
        if (0 <= position && position <= getItemCount()) {
            mData.add(position, item);

            notifyItemInserted(position);
        }
    }

    public void removeItem(int position) {
        if (0 <= position && position <= getItemCount()) {
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_list_item_layout, viewGroup, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        MainListItem item = mData.get(i);
        if (item != null) {
            mainViewHolder.content.setText(item.content);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).type;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView content;

        MainViewHolder(@NonNull View itemView) {
            super(itemView);

            content = itemView.findViewById(R.id.main_item_content);
        }
    }
}
