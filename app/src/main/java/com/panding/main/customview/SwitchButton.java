package com.panding.main.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.panding.main.R;


/**
 * Created by Administrator on 2017/7/11.
 */

public class SwitchButton extends View {

    private int mTitleTextSize;
    private int mTitleTextColor;
    private String mTitleText;
    private Context mContext;
    private int mWidth;
    private int mHeight;
    private Paint paintBottom;
    private Paint paintTopTrue;
    private Paint paintTopFalse;

    private boolean check;
    private Paint paintText;
    private Rect mBound;

    private OnSwitchListener mListener;

    public interface OnSwitchListener{
        void onSwitch(boolean check);
    }

    public void setOnSwitchListener( OnSwitchListener mListener){
        this.mListener = mListener;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
        invalidate();
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SwitchButton, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++)
        {
            int attr = a.getIndex(i);
            switch (attr)
            {
                case R.styleable.SwitchButton_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.SwitchButton_titleTextColor:
                    // 默认颜色设置为白色
                    mTitleTextColor = a.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.SwitchButton_titleTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }
        a.recycle();

        init(context);
    }

    private void init(Context context) {
        mContext = context;
        initPaint();
        initAttr();
    }

    private void initAttr() {
        check = true;
    }

    private void initPaint() {
        //初始化画笔
        paintBottom = new Paint();
        paintBottom.setAntiAlias(true);
        paintBottom.setStyle(Paint.Style.FILL);
        paintBottom.setStrokeWidth(10);
        paintBottom.setColor(getResources().getColor(R.color.white));
        paintBottom.setDither(true);

        paintTopTrue = new Paint();
        paintTopTrue.setAntiAlias(true);
        paintTopTrue.setStyle(Paint.Style.FILL);
        paintTopTrue.setStrokeWidth(10);
        paintTopTrue.setColor(getResources().getColor(R.color.colorPrimary));
        paintTopTrue.setDither(true);

        paintTopFalse = new Paint();
        paintTopFalse.setAntiAlias(true);
        paintTopFalse.setStyle(Paint.Style.FILL);
        paintTopFalse.setStrokeWidth(10);
        paintTopFalse.setColor(getResources().getColor(R.color.colorAccent));
        paintTopFalse.setDither(true);

        paintText = new Paint();
        paintText.setAntiAlias(true);
        paintText.setStyle(Paint.Style.FILL);
        paintText.setDither(true);
        paintText.setColor(mTitleTextColor);
        paintText.setTextSize(mTitleTextSize);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int realWidth = startMeasure(widthMeasureSpec);
        int realHeight = startMeasure(heightMeasureSpec);
        setMeasuredDimension(realWidth, realHeight);
    }
    private int startMeasure(int msSpec) {
        int result = 0;
        int mode = MeasureSpec.getMode(msSpec);
        int size = MeasureSpec.getSize(msSpec);
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = PxUtils.dpToPx(200, mContext);
        }
        return result;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = getWidth();
        mHeight = getHeight();

        mBound = new Rect();
        paintText.getTextBounds(mTitleText, 0,mTitleText.length(), mBound);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawColor(getResources().getColor(R.color.rightRight));
        canvas.translate(mWidth/2,mHeight/2);//移动坐标原点到中心
        drawBottom(canvas);
        drawTop(canvas);
    }

    private void drawBottom(Canvas canvas){
        //矩形宽为控件宽度，高为1/3控件高度
        RectF rectF = new RectF(-mWidth/2,-mHeight/6,mWidth/2,mHeight/6);
        canvas.drawRect(rectF,paintBottom);
    }

    private void drawTop(Canvas canvas){
        if(check) {
            RectF rectF = new RectF(-mWidth / 2, -mHeight / 4, 0, mHeight / 4);
            canvas.drawRoundRect(rectF,10,10,paintTopTrue);
            canvas.drawText("已启用",-mWidth / 4- mBound.width() / 2,mBound.height()/2,paintText);

        }else{
            RectF rectF = new RectF(0, -mHeight / 4, mWidth/2, mHeight / 4);
            canvas.drawRoundRect(rectF,10,10,paintTopFalse);
            canvas.drawText("未启用",mWidth / 4- mBound.width() / 2,mBound.height()/2,paintText);
        }

    }

    private void startAnimation() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // ▼ 注意这里使用的是 getAction()，单点触控用这个，多点触控用getActionMasked
        // 需要设置控件的clickable为true才能触发up事件
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                // 手指按下
                break;
            case MotionEvent.ACTION_MOVE:
                // 手指移动
                break;
            case MotionEvent.ACTION_UP:
                check = !check;
                if(mListener!=null){
                    mListener.onSwitch(check);
                }
                invalidate();
                // 手指抬起
                break;
            case MotionEvent.ACTION_CANCEL:
                // 事件被拦截
                break;
            case MotionEvent.ACTION_OUTSIDE:
                // 超出区域
                break;
        }
        return super.onTouchEvent(event);
    }


}
