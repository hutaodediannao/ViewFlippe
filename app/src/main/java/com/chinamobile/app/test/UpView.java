package com.chinamobile.app.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;

import java.util.List;

/**
 * 描述: 轮播广告
 * 作者: 胡涛
 * 时间: 2019-1-13 20:02
 */
public class UpView extends ViewFlipper {
    private Context content;

    public UpView(Context context) {
        super(context);
        init(context);
    }

    private int Interval = 3000;//设置轮播间隔毫秒值

    public UpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.content = context;
        setFlipInterval(Interval);//设置时间间隔
        setInAnimation(context, R.anim.go);
        setOutAnimation(context, R.anim.exit);
    }

    public void setInterval(int i) {
        Interval = i;
    }

    /**
     * 设置循环滚动的View数组
     */
    public void setViews(final List<View> views) {
        if (views == null || views.size() == 0) return;
        removeAllViews();
        for (int i = 0; i < views.size(); i++) {
            final int finalposition = i;
            //设置监听回调
            views.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(finalposition, views.get(finalposition));
                    }
                }
            });
            addView(views.get(i));
        }
        startFlipping();
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }
}