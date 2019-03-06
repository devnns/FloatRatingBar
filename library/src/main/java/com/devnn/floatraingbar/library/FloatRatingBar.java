package com.devnn.floatraingbar.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


/**
 * create by devnn on 2019/2/22
 **/
public class FloatRatingBar extends LinearLayout {

    private int starWidth;//星星高度

    private int startHeight;//星星宽度

    private int starDistance;//星星之间的距离
    private int starForegroundRes;//选中时的图片资源
    private int starBackgroundRes;//未选中时的图片资源
    private float starRate;//评分值


    public FloatRatingBar(Context context) {
        super(context);
        init();
    }

    public FloatRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StyleFloatRatingBar);
        starWidth = (int) ta.getDimension(R.styleable.StyleFloatRatingBar_FloatRatingBarStarWidth, 50);
        startHeight = (int) ta.getDimension(R.styleable.StyleFloatRatingBar_FloatRatingBarStarHeight, 50);
        starForegroundRes = ta.getResourceId(R.styleable.StyleFloatRatingBar_FloatRatingBarStarForegroundDrawable, 0);
        starBackgroundRes = ta.getResourceId(R.styleable.StyleFloatRatingBar_FloatRatingBarStarBackgroundDrawable, 0);
        starDistance = (int) ta.getDimension(R.styleable.StyleFloatRatingBar_FloatRatingBarStarDistance, 10);
        starRate = ta.getFloat(R.styleable.StyleFloatRatingBar_FloatRatingBarStarRate, 0f);
        init();
        setRate(starRate);
    }

    private void init() {
        this.setOrientation(LinearLayout.HORIZONTAL);
        for (int i = 0; i < 5; i++) {
            RelativeLayout child = new RelativeLayout(getContext());
            ImageView ivBackground = new ImageView(getContext());
            ivBackground.setImageResource(starBackgroundRes);
            RelativeLayout.LayoutParams backLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            child.addView(ivBackground, backLayoutParams);

            ImageView ivForeground = new ImageView(getContext());
            ivForeground.setImageResource(starForegroundRes);
            RelativeLayout.LayoutParams foreLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            child.addView(ivForeground, foreLayoutParams);

            LayoutParams childLayoutParams = new LayoutParams(starWidth, startHeight);
            if (i != 0) {
                childLayoutParams.leftMargin = starDistance;
            }
            Drawable drawable = ivForeground.getDrawable();
            drawable.setLevel(0);
            this.addView(child, childLayoutParams);
        }
    }

    /**
     * set the rate
     * rate range in [0,5] including float number,such as 4.3
     *
     * @param rate
     */
    public void setRate(float rate) {
        if (rate < 0 || rate > 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            RelativeLayout child = (RelativeLayout) this.getChildAt(i);
            ImageView foreground = (ImageView) child.getChildAt(1);
            Drawable drawable = foreground.getDrawable();
            if (rate > i + 1) {
                drawable.setLevel(10000);
            } else {
                float left = rate - i;
                drawable.setLevel((int) (left * 10000));
                break;
            }
        }
    }
}
