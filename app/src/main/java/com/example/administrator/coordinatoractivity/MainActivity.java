package com.example.administrator.coordinatoractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView left_recyc;
    private RecyclerView right_recyc;
    private List<Bean.DataBean> leftlist=new ArrayList<>();
   // private List<Bean.DataBean.ClassifyTwoListBean> rightlist=new ArrayList<>();
    List<Bean.DataBean.ClassifyTwoListBean> classifyTwoList;
    List<List<Bean.DataBean.ClassifyTwoListBean>> rightlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left_recyc=findViewById(R.id.recycle_left);
        right_recyc=findViewById(R.id.recycle_right);
        getData();
    }
    private void getData(){
        //加载Assets下面文件
        InputStream is = null;
        try {
            is = getAssets().open("sort.json");
            int lenght = is.available();
            byte[]  buffer = new byte[lenght];
            is.read(buffer);
            String result  = new String(buffer, "utf8");
            Gson gson = new Gson();
            Bean bean = gson.fromJson(result, Bean.class);
            //获取左边数据
            leftlist=bean.getData();
            for (int i=0;i<leftlist.size();i++){
                classifyTwoList = leftlist.get(i).getClassifyTwoList();
               rightlist.add(classifyTwoList);
            }


            LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
            left_adapter leftAdapter = new left_adapter(MainActivity.this, leftlist);
            left_recyc.setLayoutManager(manager);
            left_recyc.setAdapter(leftAdapter);
            leftAdapter.setListener(new left_adapter.OnItemClickListener() {
                @Override
                public void onItemClick(View var2, int var3) {
                    Toast.makeText(MainActivity.this,"点击了"+var3,Toast.LENGTH_LONG).show();

                    //点击这边某个位置加载右边的位置

                }
            });




            LinearLayoutManager manager1 = new LinearLayoutManager(MainActivity.this);
            right_adapter rightAdapter = new right_adapter(MainActivity.this, rightlist);
            right_recyc.setLayoutManager(manager1);
            right_recyc.setAdapter(rightAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
