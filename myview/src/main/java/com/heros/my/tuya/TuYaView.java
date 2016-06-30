package com.heros.my.tuya;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by my on 2016/6/30.
 */
public class TuYaView extends View {
    //花版
    private Canvas canvas;
    //纸啊
    private Bitmap bitmap;
    //画笔啊
    private Paint paint;

    //画的路径
    private Path path;
    //临时保存 X Y
    private float mx, my;

    public TuYaView(Context context, int screenWith, int screenHeight) {
        super(context);
        bitmap = Bitmap.createBitmap(screenWith, screenHeight, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setAntiAlias(true);//平滑效果
        paint.setStyle(Paint.Style.STROKE);//画实线
        paint.setStrokeWidth(5);


    }

    public TuYaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TuYaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        Log.i("aaa","获得动作："+action+"");
        float x = event.getX();
        Log.i("aaa","获得X："+x+"");
        float y = event.getY();
        Log.i("aaa","获得Y："+y+"");
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                Log.i("aaa","实例化路径");
                path.moveTo(x, y);
                path.lineTo(x, y);
                canvas.drawPath(path, paint);
                Log.i("aaa","画出移动路径");
                mx = x;
                my = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - mx);
                float dy = Math.abs(y - my);
                if (dx > 4 || dy > 4) {
                    path.lineTo(x, y);
                    canvas.drawPath(path, paint);
                }
                mx=x;
                my=y;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
