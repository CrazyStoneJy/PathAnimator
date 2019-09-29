package me.crazystone.study.pathanimator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import me.crazystone.study.pathanimator.utils.Views;

public class PathView extends View {

    private Path mPath;
    private Paint mPaint;

    public PathView(Context context) {
        super(context);
        initPaint();
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.colorPrimary));
        mPaint.setStrokeWidth(Views.dp2px(getContext(), 2));
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mPath == null)
            return;
//        canvas.drawRect(0, 0, Views.dp2px(getContext(), 300), Views.dp2px(getContext(), 200), mPaint);

//        mPaint.setColor(getResources().getColor(R.color.black));
//        mPath.moveTo(0, 0);
//        mPath.rLineTo(Views.dp2px(getContext(), 100), Views.dp2px(getContext(), 20));
        canvas.drawPath(mPath, mPaint);
    }

    public void setPath(Path path) {
        this.mPath = path;
        mPath.offset(Views.dp2px(getContext(), 5), Views.dp2px(getContext(), 5));
    }

    public void setFraction(float dx, float dy) {
        if (this.mPath != null) {
//            mPath.offset(dx, dy);
            postInvalidate();

        }
    }


}
