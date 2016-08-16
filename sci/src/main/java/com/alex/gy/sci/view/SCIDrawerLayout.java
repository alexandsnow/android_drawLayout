package com.alex.gy.sci.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;


/**
 * Created by gy on 2016/8/14.
 */
public class SCIDrawerLayout extends HorizontalScrollView {

    private ViewGroup drawerLayoutWrap;
    private ViewGroup sliderMenu;
    private LinearLayout content;
    private static int screenWidth;
    private static int scrollLeft = 350;

    private boolean isFirst = true;

    public SCIDrawerLayout(Context context) {
        this(context,null);
    }

    public SCIDrawerLayout(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public SCIDrawerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取屏幕宽度,设置内容区域的宽度
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(isFirst) {
            drawerLayoutWrap = (ViewGroup) getChildAt(0);
            sliderMenu = (ViewGroup) drawerLayoutWrap.getChildAt(0);
            content = (LinearLayout) drawerLayoutWrap.getChildAt(1);
            sliderMenu.getLayoutParams().width = scrollLeft;
            content.getLayoutParams().width = screenWidth;
            isFirst = false;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //初始化移动到主页
        this.scrollTo(scrollLeft,0);
        if(changed){
            this.scrollTo(scrollLeft,0);
        }
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
                if(getScrollX()>=scrollLeft/2){
                    this.smoothScrollTo(scrollLeft,0);
                }else{
                    this.smoothScrollTo(0,0);
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        ViewHelper.setTranslationX(sliderMenu,l);

    }

}
