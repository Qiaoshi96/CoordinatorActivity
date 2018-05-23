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

public class left_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Bean.DataBean> list;
    OnItemClickListener listener;//定义监听事件
    public left_adapter(Context mContext, List<Bean.DataBean> list) {
        this.mContext = mContext;
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    /**
     * 设置监听事件
     *
     * @param listener
     */
    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {
        if (holder instanceof MyViewHolder){
       MyViewHolder myViewHolder=(MyViewHolder)holder;
       myViewHolder.textView.setText(list.get(position).getName()+"");
       myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (listener!=null){
                   listener.onItemClick(view,position);
               }
           }
       });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.left_text);
        }
    }
    //设置点击时间
    public interface OnItemClickListener {
        void onItemClick(View var2, int var3);
    }
}
