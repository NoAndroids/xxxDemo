package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Administrator on 2016/8/3.
 * 1.在res/values 下面创建一个xml文件  viewattrs 并设置属性
 * 2.重写 构造方法
 */
public class View1 extends View {
    private String titleText;//文本内容
    private int titleColor;//文本颜色
    private int titleSize;//文本字体大小
    //文本绘制范围
    private Rect mRect;
    private Paint mPaint;

    public View1(Context context) {
        this(context, null);
    }

    public View1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //获取自定义属性的样式
    public View1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.View1, defStyleAttr, 0);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.View1_titleText:
                    titleText = typedArray.getString(attr);
                    break;
                case R.styleable.View1_titleColor:
                    titleColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.View1_titleTextSize:
                    titleSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }

        }
        typedArray.recycle();
        //获得绘制文本的宽和高
        mPaint = new Paint();
        mPaint.setTextSize(titleSize);
        mPaint.setColor(titleColor);

        mRect = new Rect();
        mPaint.getTextBounds(titleText, 0, titleText.length(), mRect);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /**
         * EXACTLY：一般是设置了明确的值或者是MATCH_PARENT
         AT_MOST：表示子布局限制在一个最大值内，一般为WARP_CONTENT
         UNSPECIFIED：表示子布局想要多大就多大，很少使用
         * */
        //  super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取 控件的宽高模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width;
        int height;
        //如果是match_parent  则用设置好的属性 如果是warp_content 则获取内容的宽高度
        if (widthMode == MeasureSpec.EXACTLY) {
            width = MeasureSpec.getSize(widthMeasureSpec);
        } else {
            mPaint.setTextSize(titleSize);
            mPaint.getTextBounds(titleText, 0, titleText.length(), mRect);
            //float textwidth = mRect.width();//得到填充内容后的矩形的宽度 原始方式，这是一种粗略的文字宽度计算
            float textwidth=mPaint.measureText(titleText);//改进，这是比较精确的测量文字宽度的方式
            int desired = (int) (getPaddingLeft() + textwidth + getPaddingRight());//得到 实际宽度
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = MeasureSpec.getSize(heightMeasureSpec);
            //先了解一下Android是怎么样绘制文字的，这里涉及到几个概念，分别是文本的top，bottom，ascent，descent，baseline
            //Baseline是基线，在Android中，文字的绘制都是从Baseline处开始的，
            // Baseline往上至字符“最高处”的距离我们称之为ascent（上坡度），
            // Baseline往下至字符“最低处”的距离我们称之为descent（下坡度）；
            //Baseline是基线，Baseline以上是负值，以下是正值，因此 ascent，top是负值， descent和bottom是正值。
        } else {
            mPaint.setTextSize(titleSize);
            mPaint.getTextBounds(titleText, 0, titleText.length(), mRect);
          //  float textheight = mRect.height();
            Paint.FontMetrics fontMetrics=mPaint.getFontMetrics();
            float textheight=Math.abs((fontMetrics.bottom-fontMetrics.top));
            int desired = (int) (getPaddingBottom() + textheight + getPaddingTop());
            height = desired;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(titleColor);
        Paint.FontMetrics fontMetrics=mPaint.getFontMetrics();
       // canvas.drawText(titleText, getWidth() / 2 - mRect.width() / 2, getHeight() / 2 + mRect.height() / 2, mPaint);
        canvas.drawText(titleText, getWidth() / 2 - mRect.width() / 2,getHeight()/2-fontMetrics.descent+(fontMetrics.descent - fontMetrics.ascent)/ 2,mPaint);
    }

}
