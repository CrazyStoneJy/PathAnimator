package me.crazystone.study.pathanimator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import me.crazystone.study.pathanimator.utils.Logs;
import me.crazystone.study.pathanimator.utils.Views;


public class MainActivity extends AppCompatActivity {


    BallView ballView;
    PathView pathView;
    ImageView img;
    private Animator animator;
    private Path path;
    private PathMeasure pathMeasure;
    private float[] points = new float[2];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initPath();

        initContentView();


        animation();

    }

    private void animation() {
        //主要是用pathMeasure这个类，通过 {@link PathMeasure#getPosTan()}获取path对应的(x,y)的点
        animator = ValueAnimator.ofFloat(0, pathMeasure.getLength());
        ((ValueAnimator) animator).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                animation.getAnimatedFraction();
                Logs.d("animator value:" + value);
                pathMeasure.getPosTan(value, points, null);
                Logs.d("x:" + points[0] + ",y:" + points[1]);
                img.setX(points[0]);
                img.setY(points[1]);

//                pathView.setFraction(points[0], points[1]);
            }
        });
        animator.setDuration(3000);
    }

    private void initPath() {
        // 根据自己的需求重新绘制path,画曲线可以用quadTo(),cubicTo, rQuadTo()和rCubicTo()坐标是相对于上一次的点，看看api.
        path = new Path();
        path.moveTo(0, 0);
//        path.rLineTo(Views.dp2px(this, 50), Views.dp2px(this, 200));
        path.rQuadTo(Views.dp2px(this, 100), Views.dp2px(this, 100), Views.dp2px(this, 0), Views.dp2px(this, 200));

        pathMeasure = new PathMeasure();
        pathMeasure.setPath(path, false);

        Logs.d(pathMeasure.getLength());

    }

    private void initContentView() {
        LinearLayout container = new LinearLayout(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(Views.getScreenWidth(this), Views.getScreenHeight(this));
        container.setLayoutParams(lp);
        container.setOrientation(LinearLayout.VERTICAL);

        Button button = new Button(this);
        button.setText("start");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animator != null && !animator.isRunning()) {
                    animator.start();
                }
            }
        });
        LinearLayout.LayoutParams btnLp = new LinearLayout.LayoutParams(Views.getScreenWidth(this), Views.dp2px(this, 50));
        button.setLayoutParams(btnLp);
        container.addView(button);

        FrameLayout frameLayout = new FrameLayout(this);


        pathView = new PathView(this);
        pathView.setPath(path);
        frameLayout.addView(pathView);

//        ballView = new BallView(this);
        img = new ImageView(this);
        LinearLayout.LayoutParams imgLp = new LinearLayout.LayoutParams(Views.dp2px(this, 40), Views.dp2px(this, 40));
        img.setLayoutParams(imgLp);
        img.setImageResource(R.mipmap.ic_launcher);
        frameLayout.addView(img);


        container.addView(frameLayout);

        setContentView(container);

    }

}
