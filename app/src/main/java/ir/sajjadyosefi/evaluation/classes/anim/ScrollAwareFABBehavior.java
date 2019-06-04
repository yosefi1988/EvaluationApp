package ir.sajjadyosefi.evaluation.classes.anim;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;


public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {
    Context cx;

    public ScrollAwareFABBehavior(Context context, AttributeSet attributeSet) {
        super();
        cx = context;

    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);


//        SharedPreferences values = cx.getSharedPreferences(Statics.MAHAN, 0);
//        if (values.getBoolean("fab", false)) {
//            if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
//                child.hide();
//            } else if (dyConsumed < 0 && child.getVisibility() == View.GONE) {
//                child.show();
//            }
//        }
    }
}