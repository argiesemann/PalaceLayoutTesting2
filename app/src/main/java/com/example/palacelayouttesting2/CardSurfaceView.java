package com.example.palacelayouttesting2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class CardSurfaceView extends SurfaceView {

    private PalaceGameState pgs;
    private Paint bitmapPaint = new Paint();
    float x;
    float y;

    public CardSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

    }

    public void onDraw(Canvas canvas) {

        x = 10;
        y = 100;
        pgs.shuffleTheDeck();
        for (Pair p : pgs.the_deck) {

            canvas.drawBitmap(p.get_card().getImage(), x, y, bitmapPaint);

            x+=110;
            if (x + 100 > getWidth()) {
                x = 10;
                y += 200;
            }

        }

    }

    public void setPgs(PalaceGameState pgs) {
        this.pgs = pgs;
    }
}
