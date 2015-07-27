package lee.phoenix.com.gesturedemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by fhh on 7/23/2015.
 */
public class MyView extends View implements View.OnTouchListener,GestureDetector.OnGestureListener{

    private Paint mPaint;
    private Path mPath;
    private GestureDetector gestureDetector;
    private String mText="";
    private float mx;
    private float my;

    public MyView(Context context) {
        super(context);
        initView(null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);

    }


    private void initView(AttributeSet attrs) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPaint.setStrokeWidth(10f);
        mPaint.setStyle(Paint.Style.STROKE);


        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.MyView);
            int paint_color = array.getColor(R.styleable.MyView_paint_color, 0xff0000);
            mPaint.setColor(paint_color);
        }
        gestureDetector = new GestureDetector(getContext(),this);
        mPath = new Path();
        setOnTouchListener(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawText(mText,200,200,mPaint);
        canvas.drawPath(mPath,mPaint);

        super.onDraw(canvas);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mPath.reset();
        mx = e.getX();
        my = e.getY();

        mPath.moveTo(mx,my);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

      // mx = e1.getX();
      //  my = e1.getY();

        mPath.quadTo(mx,my,e2.getX(),e2.getY());

        mx = e2.getX();
        my = e2.getY();
        invalidate();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float dx = e2.getX() - e1.getX();
        float dy = e2.getY() - e1.getY();

        if (dx >100 && Math.abs(dy) < 15){
            mText = "横";
        }else if (dy >100 && Math.abs(dx) < 15){
            mText = "竖";
        }else if (dx < 0 && Math.abs(dx) > 50  && velocityX > velocityY){
            mText ="撇";
        }else if(dx > 50 && velocityX > velocityY){
            mText = "捺";
        }
        invalidate();


        invalidate();


        return false;
    }
}
