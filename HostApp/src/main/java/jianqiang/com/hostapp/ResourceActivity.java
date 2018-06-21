package jianqiang.com.hostapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ResourceActivity extends BaseActivity {

    /**
     * 需要替换主题的控件
     * 这里就列举三个：TextView,ImageView,LinearLayout
     */
    private TextView textV;
    private ImageView imgV;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        textV = (TextView) findViewById(R.id.text);
        imgV = (ImageView) findViewById(R.id.imageview);
        layout = (LinearLayout) findViewById(R.id.layout);

        findViewById(R.id.btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                PluginInfo pluginInfo = plugins.get("plugin1.apk");

                loadResources(pluginInfo.getDexPath());

                doSomething(pluginInfo.getClassLoader());
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PluginInfo pluginInfo = plugins.get("plugin2.apk");

                loadResources(pluginInfo.getDexPath());

                doSomething(pluginInfo.getClassLoader());
            }
        });
    }

    private void doSomething(ClassLoader cl) {
        try {
            Class clazz = cl.loadClass("jianqiang.com.plugin1.UIUtil");

            String str = (String) RefInvoke.invokeStaticMethod(clazz, "getTextString", Context.class, this);
            textV.setText(str);

            Drawable drawable = (Drawable) RefInvoke.invokeStaticMethod(clazz, "getImageDrawable", Context.class, this);
            imgV.setBackground(drawable);

            layout.removeAllViews();
            View view = (View) RefInvoke.invokeStaticMethod(clazz, "getLayout", Context.class, this);
            layout.addView(view);

        } catch (Exception e) {
            Log.e("DEMO", "msg:" + e.getMessage());
        }
    }
}
