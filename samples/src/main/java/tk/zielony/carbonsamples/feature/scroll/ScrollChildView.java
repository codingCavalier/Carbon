package tk.zielony.carbonsamples.feature.scroll;

import android.content.Context;
import android.util.AttributeSet;

import carbon.internal.MathUtils;
import carbon.widget.LinearLayout;

public class ScrollChildView extends LinearLayout implements ScrollChild {
    private int nestedScrollY;

    public ScrollChildView(Context context) {
        super(context);
    }

    public ScrollChildView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int onNestedScrollByY(int y) {
        this.nestedScrollY = MathUtils.constrain(nestedScrollY + y / 2, 0, getNestedScrollRange());
        getChildAt(0).setTranslationY(-nestedScrollY);
        return 0;
    }

    @Override
    public int getNestedScrollRange() {
        return getHeight();
    }

    @Override
    public int getNestedScrollY() {
        return nestedScrollY;
    }
}
