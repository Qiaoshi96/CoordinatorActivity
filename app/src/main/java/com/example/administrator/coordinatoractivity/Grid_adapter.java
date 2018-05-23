package com.example.administrator.coordinatoractivity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class Grid_adapter extends BaseAdapter {
    private Context mContext;
    private List<Bean.DataBean.ClassifyTwoListBean.ClassifyThreeListBean> list;

    public Grid_adapter(Context mContext, List<Bean.DataBean.ClassifyTwoListBean.ClassifyThreeListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    ViewHolder holder=null;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        holder=new ViewHolder();
        if (view==null){
            view=View.inflate(mContext,R.layout.grid_item,null);
            holder.imageView=view.findViewById(R.id.grid_img);
            holder.name=view.findViewById(R.id.grid_name);
            view.setTag(holder);
        }else {
            holder=(ViewHolder)view.getTag();
        }
        holder.name.setText(list.get(i).getName());
        return view;
    }
    class ViewHolder{
        private TextView name;
        private ImageView imageView;
    }
}
