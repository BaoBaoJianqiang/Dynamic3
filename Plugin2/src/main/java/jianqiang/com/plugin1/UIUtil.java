package jianqiang.com.plugin1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

public class UIUtil {
    public static String getTextString(Context ctx){
        return ctx.getResources().getString(R.string.app_name);
    }

    public static Drawable getImageDrawable(Context ctx){
        return ctx.getResources().getDrawable(R.drawable.robert);
    }

    public static View getLayout(Context ctx){
        return LayoutInflater.from(ctx).inflate(R.layout.main_activity, null);
    }
}
