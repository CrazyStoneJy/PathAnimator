package me.crazystone.study.pathanimator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import me.crazystone.study.pathanimator.utils.Views;

@Deprecated
public class MotionView extends View {

    private static float RADIUS;
    private Context context;
    private Paint mPaint;
    private Rect rect;
    private Path path;

    public MotionView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public MotionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }


    MotionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {

        RADIUS = Views.dp2px(getContext(), 5);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setStrokeWidth(Views.dp2px(getContext(), 2));
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        rect = new Rect(0, 0, Views.getScreenWidth(getContext()), Views.getScreenHeight(getContext()));

        path = new Path();
        path.moveTo(Views.dp2px(getContext(), RADIUS), Views.dp2px(getContext(), RADIUS));
        path.rLineTo(Views.dp2px(getContext(), 50), Views.dp2px(getContext(), 200));
//        path.rQuadTo(Views.dp2px(getContext(), -20), Views.dp2px(getContext(), -30), Views.dp2px(getContext(), 100), Views.dp2px(getContext(), 100));
        path.close();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawRect(canvas);
        drawBall(canvas);
        mPaint.setColor(getResources().getColor(R.color.white));
        canvas.drawPath(path, mPaint);

    }

    private void drawBall(Canvas canvas) {
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawCircle(Views.dp2px(getContext(), RADIUS), Views.dp2px(getContext(), RADIUS), Views.dp2px(getContext(), RADIUS), mPaint);

    }

    private void drawRect(Canvas canvas) {
        mPaint.setColor(getResources().getColor(R.color.colorPrimary));
        canvas.drawRect(rect, mPaint);
    }

}
