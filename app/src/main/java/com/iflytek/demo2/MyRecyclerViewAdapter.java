package com.iflytek.demo2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {


    private Context context;
    private ArrayList<ImageItem> imageData;

    public MyRecyclerViewAdapter(Context context, ArrayList<ImageItem> imageData) {
        this.context = context;
        this.imageData = imageData;
    }
    /**
     * 相当于getview方法中创建View和viewHolder
     * */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.item, null);
        return new MyViewHolder(itemView);
    }

    /**
     * 数据和View绑定
     * */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //根据位置得到对应的数据
        ImageItem data = imageData.get(position);
        holder.mTextView.setText(data.getImageName());
    }
    /**
     * 得到总数
     * */
    @Override
    public int getItemCount() {
        return imageData == null ? 0 : imageData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mTextView;
        public MyViewHolder(View itemView){
            super(itemView);

            mImageView = itemView.findViewById(R.id.item_image);
            mTextView = itemView.findViewById(R.id.item_text);
        }
    }
}
