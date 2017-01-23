package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.service.carrier.MessagePdu;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Administrator on 2016/8/4.
 */
public class View2  {
//    private String titleText;
//    private int titleTextColor;
//    private int titleTextSize;
//    private Bitmap mImage;
//    private int mImageScale;
//    private Rect mRect;
//    private Paint mPaint;
//    private Rect mTextRect;
//    int width=0;
//    int height=0;
//    public View2(Context context) {
//        this(context,null);
//    }
//
//    public View2(Context context, AttributeSet attrs) {
//        this(context, attrs,0);
//    }
//
//    public View2(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
////        TypedArray a=context.getTheme().obtainStyledAttributes(attrs,R.styleable.View2,defStyleAttr,0);
////        int n=a.getIndexCount();
////        for (int i = 0; i < n; i++) {
////            int attr=a.getIndex(i);
////            switch (attr){
////                case R.styleable.View2_titleTextColor:
////                    titleTextColor=a.getColor(attr, Color.BLACK);
////                    break;
////                case R.styleable.View2_titleText:
////                    titleText=a.getString(attr);
////                    break;
////                case R.styleable.View2_titleTextSize:
////                    titleTextSize=a.getDimensionPixelSize(attr,(int)(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics())));
////                    break;
////                case R.styleable.View2_image:
////                    mImage= BitmapFactory.decodeResource(getResources(),a.getResourceId(attr,0));
////                    break;
////                case R.styleable.View2_imageScaleType:
////                    mImageScale=a.getInt(attr,0);
////                    break;
//            }
//        }
////        a.recycle();
////        mRect=new Rect();
////        mPaint=new Paint(titleTextSize);
////        mTextRect=new Rect();
////        mPaint.getTextBounds(titleText,0,titleText.length(),mTextRect);
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
//
//        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
//
//
//        //设置宽
//        if (widthMode==MeasureSpec.EXACTLY){
//            width=MeasureSpec.getSize(widthMeasureSpec);
//        }else{
//            //图片的宽
//             int desireByImg=getPaddingLeft()+mImage.getWidth()+getPaddingRight();
//            //文字的宽
//            int deisreByText=getPaddingLeft()+mTextRect.width()+getPaddingRight();
//           // int deisreByText=getPaddingLeft()+mPaint.measureText(titleText)+getPaddingRight();
//            if (widthMode==MeasureSpec.AT_MOST){//wrap_content
//                int desire=Math.max(desireByImg,deisreByText);
//                width=Math.min(desire,MeasureSpec.getSize(widthMeasureSpec));
//            }
//        }
//
//        if (heightMode==MeasureSpec.EXACTLY){
//            height=MeasureSpec.getSize(heightMeasureSpec);
//        }else {
//            int deisreByImg=mImage.getHeight();//获取图片的高度
//            mPaint.setTextSize(titleTextSize);
//            mPaint.getTextBounds(titleText,0,titleText.length(),mTextRect);
//            Paint.FontMetrics fontMetrics=mPaint.getFontMetrics();
//            float textHeight=Math.abs((fontMetrics.bottom-fontMetrics.top));
//            int deisreByText=(int)(getPaddingTop()+getPaddingBottom()+textHeight);
//            int deisre=deisreByImg+deisreByText+getPaddingBottom()+getPaddingTop();
//            if (heightMode==MeasureSpec.AT_MOST){
//                height=Math.min(deisre,MeasureSpec.getSize(heightMeasureSpec));
//            }
//
//        }
//
//        setMeasuredDimension(width,height);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//     //   super.onDraw(canvas);
//        //边框
//        mPaint.setStrokeWidth(4);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setColor(Color.CYAN);
//        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
//
//        mRect.left=getPaddingLeft();
//        mRect.right=width-getPaddingRight();
//        mRect.top=getTop();
//        mRect.bottom=height-getPaddingBottom();
//
//        mPaint.setColor(titleTextColor);
//        mPaint.setStyle(Paint.Style.FILL);
//
//    }
}
