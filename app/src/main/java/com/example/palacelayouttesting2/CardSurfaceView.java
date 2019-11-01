package com.example.palacelayouttesting2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

public class CardSurfaceView extends SurfaceView implements View.OnTouchListener {

    private PalaceGameState pgs;
    private final int cardWidth = 110;
    private final int cardHeight = 130;
    private Paint bitmapPaint = new Paint();
    private Bitmap cardBack = BitmapFactory.decodeResource(getResources(), R.drawable.back);
    ArrayList<Pair> discardPile;


    public CardSurfaceView(Context context, AttributeSet attrs) {

        super(context, attrs);
        setWillNotDraw(false);





    }

    public void onDraw(Canvas canvas) {

        pgs.shuffleTheDeck();


        drawPlayerOnePalaces(canvas);

        drawHands(canvas);

        drawPlayerTwoPalaces(canvas);


        if (discardPile.size() != 0) {
            canvas.drawBitmap(discardPile.get(discardPile.size() - 1).get_card().getImage(), getWidth() / 2, getHeight() / 2 - cardHeight / 2, bitmapPaint);
        }

        if (!pgs.isDrawPileEmpty()) {
            canvas.drawBitmap(cardBack, getWidth()/2 + cardWidth, getHeight()/2 - 3*(cardHeight/4), bitmapPaint);
        }


    }

    private void drawPlayerTwoPalaces(Canvas canvas) {

        int xP2LP = getWidth()/2 - 3*(cardWidth)/2;
        int xP2UP = getWidth()/2 - 3*(cardWidth)/2;

        int yP2LP = 50;
        int yP2UP = 75;

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_TWO_LOWER_PALACE) {
                canvas.drawBitmap(cardBack, xP2LP, yP2LP, bitmapPaint);
                xP2LP += cardWidth;
            }

        }

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_TWO_UPPER_PALACE) {
                canvas.drawBitmap(p.get_card().getImage(), xP2UP, yP2UP, bitmapPaint);
                xP2UP += cardWidth;
            }
        }
    }

    private void drawHands(Canvas canvas) {

        int xP1H = 0;
        int yP1H = getHeight()/2 + (cardHeight/2);

        int xP2H = 0;
        int yP2H = getHeight()/2 - 2*(cardHeight);

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_ONE_HAND) {
                canvas.drawBitmap(p.get_card().getImage(), xP1H, yP1H, bitmapPaint);
                xP1H += cardWidth;
            }
        }

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_TWO_HAND) {
                canvas.drawBitmap(p.get_card().getImage(), xP2H, yP2H, bitmapPaint);
                xP2H += cardWidth;
            }
        }

    }

    private void drawPlayerOnePalaces(Canvas canvas) {

        int xP1LP = getWidth()/2 - 3*(cardWidth)/2;
        int xP1UP = getWidth()/2 - 3*(cardWidth)/2;
        int yP1LP = getHeight() - 200;
        int yP1UP = getHeight() - 225;



        for (Pair p : pgs.the_deck) {

            if (p.get_location() == Location.PLAYER_ONE_LOWER_PALACE) {


                canvas.drawBitmap(cardBack, xP1LP, yP1LP, bitmapPaint);
                xP1LP += cardWidth;
            }

        }

        for (Pair p : pgs.the_deck) {
            if (p.get_location() == Location.PLAYER_ONE_UPPER_PALACE) {


                canvas.drawBitmap(p.get_card().getImage(), xP1UP, yP1UP, bitmapPaint);
                xP1UP += cardWidth;
            }
        }
    }

    public void setPgs(PalaceGameState pgs) {
        this.pgs = pgs;
    }

    public void setDiscardPile(ArrayList<Pair> discardPile) {
        this.discardPile = discardPile;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return false;
    }
}
