package com.example.administrator.coordinatoractivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class right_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<List<Bean.DataBean.ClassifyTwoListBean>> list;

    public right_adapter(Context mContext, List<List<Bean.DataBean.ClassifyTwoListBean>> list) {
        this.mContext = mContext;
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
       MyViewHolder myViewHolder=(MyViewHolder)holder;
       myViewHolder.textView.setText(list.get(position).get(0).getName()+"");
            List<Bean.DataBean.ClassifyTwoListBean.ClassifyThreeListBean> classifyThreeList = list.get(position).get(0).getClassifyThreeList();
            Grid_adapter grid_adapter = new Grid_adapter(mContext, classifyThreeList);
            myViewHolder.myGridView.setAdapter(grid_adapter);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private MyGridView myGridView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.title);
            myGridView=itemView.findViewById(R.id.grid);
        }
    }
}
