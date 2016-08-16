package com.alex.gy.sci;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alex.gy.sci.adapter.SliderMenuAdapter;
import com.alex.gy.sci.domain.MenuData;
import com.alex.gy.sci.view.DiscoveryFragment;
import com.alex.gy.sci.view.IndexFragment;
import com.alex.gy.sci.view.QuestionFragment;
import com.alex.gy.sci.view.SCIDrawerLayout;
import com.alex.gy.sci.view.SignFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private LinearLayout bottom_tab1;
    private LinearLayout bottom_tab2;
    private LinearLayout bottom_tab3;
    private LinearLayout bottom_tab4;

    private TextView bottom_tab1_icon;
    private TextView bottom_tab2_icon;
    private TextView bottom_tab3_icon;
    private TextView bottom_tab4_icon;

    private TextView bottom_tab1_text;
    private TextView bottom_tab2_text;
    private TextView bottom_tab3_text;
    private TextView bottom_tab4_text;

    private IndexFragment tab1;
    private DiscoveryFragment tab2;
    private QuestionFragment tab3;
    private SignFragment tab4;

    private ListView slideMenu_list;

    private SCIDrawerLayout sciDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    private void initView() {
//      加载SCIDrawerLayout
        sciDrawerLayout = (SCIDrawerLayout) findViewById(R.id.SCI_DrawerLayout);
//      加载字体
        Typeface font;
        font = Typeface.createFromAsset(getAssets(), "Gy.ttf");
        bottom_tab1= (LinearLayout) findViewById(R.id.bottom_tab1);
        bottom_tab2= (LinearLayout) findViewById(R.id.bottom_tab2);
        bottom_tab3= (LinearLayout) findViewById(R.id.bottom_tab3);
        bottom_tab4= (LinearLayout) findViewById(R.id.bottom_tab4);

        bottom_tab1_icon = (TextView) findViewById(R.id.bottom_tab1_icon);
        bottom_tab2_icon = (TextView) findViewById(R.id.bottom_tab2_icon);
        bottom_tab3_icon = (TextView) findViewById(R.id.bottom_tab3_icon);
        bottom_tab4_icon = (TextView) findViewById(R.id.bottom_tab4_icon);


        bottom_tab1_text = (TextView) findViewById(R.id.bottom_tab1_text);
        bottom_tab2_text = (TextView) findViewById(R.id.bottom_tab2_text);
        bottom_tab3_text = (TextView) findViewById(R.id.bottom_tab3_text);
        bottom_tab4_text = (TextView) findViewById(R.id.bottom_tab4_text);

        bottom_tab1_icon.setTypeface(font);
        bottom_tab2_icon.setTypeface(font);
        bottom_tab3_icon.setTypeface(font);
        bottom_tab4_icon.setTypeface(font);

        bottom_tab1_icon.setTextColor(getResources().getColor(R.color.primary_dark));
        bottom_tab2_icon.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab3_icon.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab4_icon.setTextColor(getResources().getColor(R.color.secondary_text));

        bottom_tab1_text.setTextColor(getResources().getColor(R.color.primary_dark));
        bottom_tab2_text.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab3_text.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab4_text.setTextColor(getResources().getColor(R.color.secondary_text));

        slideMenu_list= (ListView) findViewById(R.id.slideMenu_list);

//      加载侧滑菜单的数据
        List<MenuData> data = new ArrayList<>();

        MenuData bean1 = new MenuData(getString(R.string.fa_upload),"我的资料");
        MenuData bean2 = new MenuData(getString(R.string.fa_bars),"我的收藏");
        MenuData bean3 = new MenuData(getString(R.string.fa_anchor),"我的回答");
        MenuData bean4 = new MenuData(getString(R.string.fa_user_md),"我的提问");
        MenuData bean5 = new MenuData(getString(R.string.fa_windows),"待定了");

        data.add(bean1);
        data.add(bean2);
        data.add(bean3);
        data.add(bean4);
        data.add(bean5);

        SliderMenuAdapter menuAdapter = new SliderMenuAdapter(data,getApplicationContext()) ;
        slideMenu_list.setAdapter(menuAdapter);
//      加载fragment页面
        tab1= new IndexFragment();
        tab2=new DiscoveryFragment();
        tab3= new QuestionFragment();
        tab4=new SignFragment();

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.content_fragment,tab2);
        ft.add(R.id.content_fragment,tab3);
        ft.add(R.id.content_fragment,tab4);
        ft.add(R.id.content_fragment,tab1);
        ft.commit();
    }
    private void initEvent() {
        bottom_tab1.setOnClickListener(this);
        bottom_tab2.setOnClickListener(this);
        bottom_tab3.setOnClickListener(this);
        bottom_tab4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sciDrawerLayout.scrollTo(350,0);
        setUnSelectedTab();
        switch (v.getId()){
            case R.id.bottom_tab1:
                setSelectedFragment(0);
                break;
            case R.id.bottom_tab2:
                setSelectedFragment(1);
                break;
            case R.id.bottom_tab3:
                setSelectedFragment(2);
                break;
            case R.id.bottom_tab4:
                setSelectedFragment(3);
                break;
        }
    }
    public void setUnSelectedTab(){
        bottom_tab1_icon.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab2_icon.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab3_icon.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab4_icon.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab1_text.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab2_text.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab3_text.setTextColor(getResources().getColor(R.color.secondary_text));
        bottom_tab4_text.setTextColor(getResources().getColor(R.color.secondary_text));
    }

    public void setSelectedFragment(int index){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(tab1);
        fragmentTransaction.hide(tab2);
        fragmentTransaction.hide(tab3);
        fragmentTransaction.hide(tab4);
        switch (index){
            case 0:
                bottom_tab1_icon.setTextColor(getResources().getColor(R.color.primary_dark));
                bottom_tab1_text.setTextColor(getResources().getColor(R.color.primary_dark));
                fragmentTransaction.show(tab1);
                break;
            case 1:
                bottom_tab2_icon.setTextColor(getResources().getColor(R.color.primary_dark));
                bottom_tab2_text.setTextColor(getResources().getColor(R.color.primary_dark));
                fragmentTransaction.show(tab2);
                break;
            case 2:
                bottom_tab3_icon.setTextColor(getResources().getColor(R.color.primary_dark));
                bottom_tab3_text.setTextColor(getResources().getColor(R.color.primary_dark));
                fragmentTransaction.show(tab3);
                break;
            case 3:
                bottom_tab4_icon.setTextColor(getResources().getColor(R.color.primary_dark));
                bottom_tab4_text.setTextColor(getResources().getColor(R.color.primary_dark));
                fragmentTransaction.show(tab4);
                break;
        }
        fragmentTransaction.commit();
    }

}
