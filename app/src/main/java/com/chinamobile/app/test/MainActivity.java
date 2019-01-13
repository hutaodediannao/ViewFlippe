package com.chinamobile.app.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UpView vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vf = findViewById(R.id.vf);
        setData();

        vf.setOnItemClickListener(new UpView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, datas[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    String datas[] = {
            "1.鹿皮绒高腰小西装裤子女九分阔腿裤侧边条纹",
            "2.显瘦休闲运动裤女春秋薄款直筒长裤宽松卫裤",
            "3.鹿皮绒高腰小西装裤子女九分阔腿裤侧边条纹"
    };

    private void setData() {
        List<View> views = new ArrayList<>();
        for (int i = 0; i < datas.length; i = i + 2) { //一次遍历两条数据
            View v = View.inflate(this, R.layout.viewflter_lay, null);
            TextView tv1 = v.findViewById(R.id.tv1);
            tv1.setText(datas[i]);
            views.add(v);
        }
        vf.setViews(views);
    }

}
