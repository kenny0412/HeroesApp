package com.app.kenny.heroesapp.customwidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.kenny.heroesapp.R;

import androidx.constraintlayout.widget.ConstraintLayout;

public class WidgetHeroEmpty extends ConstraintLayout {

    private ImageView imgEmpty;
    private TextView messageTxt;
    public WidgetHeroEmpty(Context context) {
        super(context);
        init(context,null,0,0);
    }

    public WidgetHeroEmpty(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs,0,0);
    }

    public WidgetHeroEmpty(Context context, AttributeSet attrs, int defStyleAttr,int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr,defStyleRes);
    }

    private void init (Context context,AttributeSet attrs, int defStyleAttr,int defStyleRes){
        View view = LayoutInflater.from(context).inflate(R.layout.widget_hero_empty,this,true);
         imgEmpty = view.findViewById(R.id.img_empty);
         messageTxt = view.findViewById(R.id.txt_message);
        if (attrs != null){
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,R.styleable.widgetHeroEmpty,defStyleAttr,defStyleRes);
            String message = typedArray.getString(R.styleable.widgetHeroEmpty_message);
            messageTxt.setText(message);
            typedArray.getDrawable(R.styleable.widgetHeroEmpty_icon);
            imgEmpty.setBackground(typedArray.getDrawable(R.styleable.widgetHeroEmpty_icon));
            typedArray.recycle();
        }
    }

    public void setMessageTxt(String message) {
        messageTxt.setText(message);
    }
}
