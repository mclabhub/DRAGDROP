package com.mclab.dragdrop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.GridLayout mGrid;
    private ScrollView mScrollView;
    private ValueAnimator mAnimator;
    private AtomicBoolean mIsScrolling = new AtomicBoolean(false);

    int indexf;
    int indexi;

    int column = 7;
    int NBR_ITEMS = column * column;

    int rndmmin = 1;
    int rndmmax = column * column;

    int countermoves = 0, countersum = 0, counterrest = 0, countermult = 0, counterdiv = 0, countercolor = 0, counterfaltan = 0;

    View viewf, viewi, viewrecorre, viewf1, viewf2;
    LayoutInflater inflater;
    TextView textr, textf1, textf2;
    String txtr, txtf1, txtf2;

    CardView cv, cvr, cvf1, cvf2;
    float resultadof, f1, f2, num;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mScrollView = (ScrollView)findViewById(R.id.scroll_view);
        mScrollView.setSmoothScrollingEnabled(true);

        mGrid = (android.support.v7.widget.GridLayout) findViewById(R.id.grid_layout);
        mGrid.setOnDragListener(new DragListener());
        mGrid.setColumnCount(column);

        inflater = LayoutInflater.from(this);

        for (int i = 0; i < NBR_ITEMS; i++) {

            int random = new Random().nextInt((rndmmax - rndmmin) + 1) + rndmmin;

            final View itemView = inflater.inflate(R.layout.grid_item, mGrid, false);

            cv = (CardView) itemView.findViewById(R.id.crdvw);

            textr = (TextView) itemView.findViewById(R.id.text);
            //textr.setText(String.valueOf(i + 1));
            textr.setText(String.valueOf(random));

            itemView.setOnTouchListener(new LongPressListener());
            //itemView.setOnLongClickListener(new LongPressListener());
            mGrid.addView(itemView);

            viewrecorre = mGrid.getChildAt(i);
            textr = (TextView) viewrecorre.findViewById(R.id.text);
            txtr = textr.getText().toString();

            num = Float.parseFloat(txtr);

            if(num >= 0 && num <= 9){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv09)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);

            }

            if(num >= 10 && num <= 19){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv1019)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);

            }
            if(num >= 20 && num <= 29){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv2029)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);
            }
            if(num >= 30 && num <= 39){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv3039)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);

            }
            if(num >= 40 && num <= 49){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv4049)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);

            }
            if(num >= 50 && num <= 59){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv5059)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);

            }
            if(num >= 60 && num <= 69){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv6069)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);

            }
            if(num >= 70 && num <= 79){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv7079)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);

            }
            if(num >= 80 && num <= 89){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv8089)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);

            }
            if(num >= 90 && num <= 99){

                cv.setCardBackgroundColor(Color.parseColor(this.getString(R.color.colorbcgrcrdv9099)));
                ColorStateList vclr = cv.getCardBackgroundColor();
                Log.d("colorr","colorr: " + vclr);

            }



        }
    }

    static class LongPressListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);

            //view.setBackgroundColor(5);

            //view.getSolidColor();
            return true;
        }
    }

/*
    static class LongPressListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View view) {
            final ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        }
    }
    */

    class DragListener implements View.OnDragListener {

        @SuppressLint("ResourceType")
        @Override
        public boolean onDrag(View v, DragEvent event) {
            final View view = (View) event.getLocalState();
            Log.d("view","view: "+ view);

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    // do nothing if hovering above own position
                    if (view == v)
                        return true;
/*
                    float xi = event.getX();
                    float yi = event.getY();
                    Log.d("xi","xi"+ xi);
                    Log.d("yi","yi"+ yi);

                    indexi = calculateNewIndex(event.getX(), event.getY());
*/
                    break;

                case DragEvent.ACTION_DRAG_LOCATION://ACTION_DRAG_LOCATION: //arrastrar
                    // do nothing if hovering above own position
                    if (view == v)
                        return true;

                    //if (view != v){

                    float xf = event.getX();
                    float yf = event.getY();
                    Log.d("xf","xf"+ xf);
                    Log.d("yf","yf"+ yf);

                        // get the new list index
                        indexf = calculateNewIndex(event.getX(), event.getY());

 /*
                    final Rect rect = new Rect();
                    mScrollView.getHitRect(rect);
                    final int scrollY = mScrollView.getScrollY();

                    if (event.getY() -  scrollY > mScrollView.getBottom() - 250) {
                        startScrolling(scrollY, mGrid.getHeight());
                    } else if (event.getY() - scrollY < mScrollView.getTop() + 250) {
                        startScrolling(scrollY, 0);
                    } else {
                        stopScrolling();
                    }
                    */

                    //}
                    Log.d("indexinicial","indexinicial: "+ indexi);
                    Log.d("index","index: "+ indexf);

                    break;
                case DragEvent.ACTION_DROP:

                    countermoves = countermoves + 1;

                    Log.d("countermoves","countermoves"+ countermoves);

                    view.setVisibility(View.VISIBLE);
                    viewf = mGrid.getChildAt(indexf);
                    Log.d("viewf","viewf: "+ viewf);

                    // remove the view from the old position
                    mGrid.removeView(view);

                    // and push to the new
                    mGrid.addView(view, indexf);

                    mGrid.removeView(viewf);

                    mGrid.addView(viewf, indexi);

                    //calculasuma();
/*
                    for (int i = 0; i < NBR_ITEMS; i++) {

                        ClipData.Item Item = event.getClipData().getItemAt(0);

                        String dato = Item.getText().toString();
                        Log.d("dragdata","dragdata: "+ dato);

                    }

*/

                    for (int i = 0; i < NBR_ITEMS; i++) {

                        viewrecorre = mGrid.getChildAt(i);
                        textr = (TextView) viewrecorre.findViewById(R.id.text);
                        txtr = textr.getText().toString();
                        Log.d("txtr", "txtr: " + txtr);

                        cvr = (CardView) viewrecorre.findViewById(R.id.crdvw);

                        //suma

                        suma(i);

                        //resta

                        resta(i);

                        //multiplicacion

                        multiplicacion(i);

                        //divicion
                        divicion(i);

                    }

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if (!event.getResult()) {
                        view.setVisibility(View.VISIBLE);
                        }

                    countercolor = 0;
                    for (int i = 0; i < NBR_ITEMS; i++) {

                        viewrecorre = mGrid.getChildAt(i);
                        textr = (TextView) viewrecorre.findViewById(R.id.text);
                        txtr = textr.getText().toString();
                        Log.d("txtr", "txtr: " + txtr);

                        cvr = (CardView) viewrecorre.findViewById(R.id.crdvw);

                        ColorStateList vclr = cvr.getCardBackgroundColor();
                        Log.d("colorsum", "colorsum: " + vclr);
                        int defcolor = vclr.getDefaultColor();
                        Log.d("defcolor", "defcolor: " + defcolor);

                        if (defcolor == -1) {

                            countercolor = countercolor + 1;

                            Log.d("countercolor", "countercolor: " + countercolor);

                            if (countercolor == (NBR_ITEMS)) {

                                Toast.makeText(getApplication(), R.string.ganaste, Toast.LENGTH_SHORT).show();

                            }

                        }


                    }

                    break;
            }

            return true;
        }
    }

    private void startScrolling(int from, int to) {
        if (from != to && mAnimator == null) {
            mIsScrolling.set(true);
            mAnimator = new ValueAnimator();
            mAnimator.setInterpolator(new OvershootInterpolator());
            mAnimator.setDuration(Math.abs(to - from));
            mAnimator.setIntValues(from, to);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    mScrollView.smoothScrollTo(0, (int) valueAnimator.getAnimatedValue());
                }
            });
            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mIsScrolling.set(false);
                    mAnimator = null;
                }
            });
            mAnimator.start();
        }
    }

    private void stopScrolling() {
        if (mAnimator != null) {
            mAnimator.cancel();
        }
    }

    private int calculateNewIndex(float x, float y) {
        // calculate which column to move to
        final float cellWidth = mGrid.getWidth() / mGrid.getColumnCount();
        final int column = (int)(x / cellWidth);
        //Log.d("column","column"+ column);
        //Log.d("x","x"+ x);
        //Log.d("cellWidth","cellWidth"+ cellWidth);

        // calculate which row to move to
        final float cellHeight = mGrid.getHeight() / mGrid.getRowCount();
        final int row = (int)Math.floor(y / cellHeight);
        //Log.d("row","row"+ row);
        //Log.d("y","y"+ y);
        //Log.d("cellHeight","cellHeight"+ cellHeight);

        // the items in the GridLayout is organized as a wrapping list
        // and not as an actual grid, so this is how to get the new index
        int index = row * mGrid.getColumnCount() + column;
        if (index >= mGrid.getChildCount()) {
            index = mGrid.getChildCount() - 1;

        }

        return index;
    }

    //suma
    @SuppressLint("ResourceType")
    private void suma (int i){

        if ((i + column) < NBR_ITEMS) {
            viewf1 = mGrid.getChildAt(i + column);
            textf1 = (TextView) viewf1.findViewById(R.id.text);
            txtf1 = textf1.getText().toString();
            Log.d("txtf1", "stxtf1: " + txtf1);

            cvf1 = (CardView) viewf1.findViewById(R.id.crdvw);

        } else {
            txtf1 = "0";
            Log.d("txtf1", "stxtf1: " + txtf1);
        }
        if ((i + (column * 2)) < NBR_ITEMS) {
            viewf2 = mGrid.getChildAt(i + (column + column));
            textf2 = (TextView) viewf2.findViewById(R.id.text);
            txtf2 = textf2.getText().toString();
            Log.d("txtf2", "stxtf2: " + txtf2);

            cvf2 = (CardView) viewf2.findViewById(R.id.crdvw);
        } else {
            txtf2 = "0";
            Log.d("txtf2", "stxtf2: " + txtf2);

        }

        resultadof = Float.parseFloat(txtr);
        f1 = Float.parseFloat(txtf1);
        f2 = Float.parseFloat(txtf2);


        if (resultadof == (f1 + f2)) {
            Toast.makeText(getApplication(), R.string.suma, Toast.LENGTH_SHORT).show();
            Log.d("suma", "suma: " + (f1 + f2));
            textf1.setText("0");
            textf2.setText("0");
            textr.setText("0");

            cvr.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf1.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf2.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));

            countersum = countersum + 1;
            Log.d("countersum", "countersum: " + countersum);

        }

    }

    //resta
    @SuppressLint("ResourceType")
    private void resta (int i){
        if ((i - column) < 0) {
            txtf1 = "0";
            Log.d("txtf1", "rtxtf1: " + txtf1);
        } else {
            viewf1 = mGrid.getChildAt(i - column);
            textf1 = (TextView) viewf1.findViewById(R.id.text);
            txtf1 = textf1.getText().toString();
            Log.d("txtf1", "rtxtf1: " + txtf1);

            cvf1 = (CardView) viewf1.findViewById(R.id.crdvw);
        }
        if ((i - (column * 2)) < 0) {
            txtf2 = "0";
            Log.d("txtf2", "rtxtf2: " + txtf2);
        } else {

            viewf2 = mGrid.getChildAt(i - (column + column));
            textf2 = (TextView) viewf2.findViewById(R.id.text);
            txtf2 = textf2.getText().toString();
            Log.d("txtf2", "rtxtf2: " + txtf2);

            cvf2 = (CardView) viewf2.findViewById(R.id.crdvw);

        }

        resultadof = Float.parseFloat(txtr);
        f1 = Float.parseFloat(txtf1);
        f2 = Float.parseFloat(txtf2);


        if (resultadof == (f2 - f1)) {
            Toast.makeText(getApplication(), R.string.resta, Toast.LENGTH_SHORT).show();
            Log.d("resta", "resta: " + (f2 - f1));

            textf1.setText("1");
            textf2.setText("1");
            textr.setText("1");

            cvr.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf1.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf2.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));

            counterrest = counterrest + 1;
            Log.d("counterrest", "counterrest: " + counterrest);


        }

    }

    //multiplicacion
    @SuppressLint("ResourceType")
    private void multiplicacion (int i){

        //1 multiplicacion <\


        if ((i + column + 1) < NBR_ITEMS) {
            viewf1 = mGrid.getChildAt(i + column + 1);
            textf1 = (TextView) viewf1.findViewById(R.id.text);
            txtf1 = textf1.getText().toString();
            Log.d("txtf1", "stxtf1: " + txtf1);

            cvf1 = (CardView) viewf1.findViewById(R.id.crdvw);

        } else {
            txtf1 = "0";
            Log.d("txtf1", "stxtf1: " + txtf1);
        }
        if ((i + (column * 2) + 2) < NBR_ITEMS) {
            viewf2 = mGrid.getChildAt(i + (column + column) + 2);
            textf2 = (TextView) viewf2.findViewById(R.id.text);
            txtf2 = textf2.getText().toString();
            Log.d("txtf2", "stxtf2: " + txtf2);

            cvf2 = (CardView) viewf2.findViewById(R.id.crdvw);

        } else {
            txtf2 = "0";
            Log.d("txtf2", "stxtf2: " + txtf2);

        }

        resultadof = Float.parseFloat(txtr);
        f1 = Float.parseFloat(txtf1);
        f2 = Float.parseFloat(txtf2);


        if (resultadof == (f1 * f2)) {
            Toast.makeText(getApplication(), R.string.multiplicacion, Toast.LENGTH_SHORT).show();
            Log.d("1multiplicacionupizq", "1multiplicacionupizq: " + (f1 * f2));

            textf1.setText("2");
            textf2.setText("2");
            textr.setText("2");

            cvr.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf1.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf2.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));

            countermult = countermult + 1;
            Log.d("countermult", "countermult: " + countermult);

        }

        //2 multiplicacion />

        if ((i + column - 1) < NBR_ITEMS) {
            viewf1 = mGrid.getChildAt(i + column - 1);
            textf1 = (TextView) viewf1.findViewById(R.id.text);
            txtf1 = textf1.getText().toString();
            Log.d("txtf1", "stxtf1: " + txtf1);

            cvf1 = (CardView) viewf1.findViewById(R.id.crdvw);

        } else {
            txtf1 = "0";
            Log.d("txtf1", "stxtf1: " + txtf1);
        }
        if ((i + (column * 2) - 2) < NBR_ITEMS) {
            viewf2 = mGrid.getChildAt(i + (column + column) - 2);
            textf2 = (TextView) viewf2.findViewById(R.id.text);
            txtf2 = textf2.getText().toString();
            Log.d("txtf2", "stxtf2: " + txtf2);

            cvf2 = (CardView) viewf2.findViewById(R.id.crdvw);

        } else {
            txtf2 = "0";
            Log.d("txtf2", "stxtf2: " + txtf2);

        }

        resultadof = Float.parseFloat(txtr);
        f1 = Float.parseFloat(txtf1);
        f2 = Float.parseFloat(txtf2);


        if (resultadof == (f1 * f2)) {
            Toast.makeText(getApplication(), R.string.multiplicacion, Toast.LENGTH_SHORT).show();
            Log.d("2multiplicacionupder", "2multiplicacionupder: " + (f1 * f2));
            textf1.setText("3");
            textf2.setText("3");
            textr.setText("3");

            cvr.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf1.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf2.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));

            countermult = countermult + 1;
            Log.d("countermult", "countermult: " + countermult);

        }


        //3 multiplicacion </

        if (!((i - column + 1) < 0)) {
            viewf1 = mGrid.getChildAt(i - column + 1);
            textf1 = (TextView) viewf1.findViewById(R.id.text);
            txtf1 = textf1.getText().toString();
            Log.d("txtf1", "stxtf1: " + txtf1);

            cvf1 = (CardView) viewf1.findViewById(R.id.crdvw);

        } else {
            txtf1 = "0";
            Log.d("txtf1", "stxtf1: " + txtf1);
        }
        if (!((i - (column * 2) + 2) < 0)) {
            viewf2 = mGrid.getChildAt(i - (column + column) + 2);
            textf2 = (TextView) viewf2.findViewById(R.id.text);
            txtf2 = textf2.getText().toString();
            Log.d("txtf2", "stxtf2: " + txtf2);

            cvf2 = (CardView) viewf2.findViewById(R.id.crdvw);

        } else {
            txtf2 = "0";
            Log.d("txtf2", "stxtf2: " + txtf2);

        }

        resultadof = Float.parseFloat(txtr);
        f1 = Float.parseFloat(txtf1);
        f2 = Float.parseFloat(txtf2);


        if (resultadof == (f1 * f2)) {
            Toast.makeText(getApplication(), R.string.multiplicacion, Toast.LENGTH_SHORT).show();
            Log.d("3multiplicaciondwnizq", "3multiplicaciondwnizq: " + (f1 * f2));

            textf1.setText("4");
            textf2.setText("4");
            textr.setText("4");

            cvr.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf1.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf2.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));

            countermult = countermult + 1;
            Log.d("countermult", "countermult: " + countermult);

        }


        //4 multiplicacion \>

        if (!((i - column - 1) < 0)) {
            viewf1 = mGrid.getChildAt(i - column - 1);
            textf1 = (TextView) viewf1.findViewById(R.id.text);
            txtf1 = textf1.getText().toString();
            Log.d("txtf1", "stxtf1: " + txtf1);

            cvf1 = (CardView) viewf1.findViewById(R.id.crdvw);

        } else {
            txtf1 = "0";
            Log.d("txtf1", "stxtf1: " + txtf1);
        }
        if (!((i - (column * 2) - 2) < 0)) {
            viewf2 = mGrid.getChildAt(i - (column + column) - 2);
            textf2 = (TextView) viewf2.findViewById(R.id.text);
            txtf2 = textf2.getText().toString();
            Log.d("txtf2", "stxtf2: " + txtf2);

            cvf2 = (CardView) viewf2.findViewById(R.id.crdvw);

        } else {
            txtf2 = "0";
            Log.d("txtf2", "stxtf2: " + txtf2);

        }

        resultadof = Float.parseFloat(txtr);
        f1 = Float.parseFloat(txtf1);
        f2 = Float.parseFloat(txtf2);


        if (resultadof == (f1 * f2)) {
            Toast.makeText(getApplication(), R.string.multiplicacion, Toast.LENGTH_SHORT).show();
            Log.d("4multiplicaciondwnder", "4multiplicaciondwnder: " + (f1 * f2));
            textf1.setText("5");
            textf2.setText("5");
            textr.setText("5");

            cvr.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf1.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf2.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));

            countermult = countermult + 1;
            Log.d("countermult", "countermult: " + countermult);


        }

    }

    //divicion
    @SuppressLint("ResourceType")
    private void divicion (int i){
        //1 divicion ->

        if (((i + 1) < NBR_ITEMS)) {
            viewf1 = mGrid.getChildAt(i + 1);
            textf1 = (TextView) viewf1.findViewById(R.id.text);
            txtf1 = textf1.getText().toString();
            Log.d("txtf1", "stxtf1: " + txtf1);

            cvf1 = (CardView) viewf1.findViewById(R.id.crdvw);

        } else {
            txtf1 = "0";
            Log.d("txtf1", "stxtf1: " + txtf1);
        }
        if (((i + 2) < NBR_ITEMS)) {
            viewf2 = mGrid.getChildAt(i + 2);
            textf2 = (TextView) viewf2.findViewById(R.id.text);
            txtf2 = textf2.getText().toString();
            Log.d("txtf2", "stxtf2: " + txtf2);

            cvf2 = (CardView) viewf2.findViewById(R.id.crdvw);

        } else {
            txtf2 = "0";
            Log.d("txtf2", "stxtf2: " + txtf2);

        }

        resultadof = Float.parseFloat(txtr);
        f1 = Float.parseFloat(txtf1);
        f2 = Float.parseFloat(txtf2);


        if (resultadof == (f2 / f1)) {
            Toast.makeText(getApplication(), R.string.divicion, Toast.LENGTH_SHORT).show();
            Log.d("divicionder", "divicionder: " + (f2 / f1));
            textf1.setText("6");
            textf2.setText("6");
            textr.setText("6");

            cvr.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf1.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf2.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));


            counterdiv = counterdiv + 1;
            Log.d("counterdiv", "counterdiv: " + counterdiv);


        }

        //2 divicion <-

        if (!((i - 1) < 0)) {
            viewf1 = mGrid.getChildAt(i - 1);
            textf1 = (TextView) viewf1.findViewById(R.id.text);
            txtf1 = textf1.getText().toString();
            Log.d("txtf1", "stxtf1: " + txtf1);

            cvf1 = (CardView) viewf1.findViewById(R.id.crdvw);

        } else {
            txtf1 = "0";
            Log.d("txtf1", "stxtf1: " + txtf1);
        }
        if (!((i - 2) < 0)) {
            viewf2 = mGrid.getChildAt(i - 2);
            textf2 = (TextView) viewf2.findViewById(R.id.text);
            txtf2 = textf2.getText().toString();
            Log.d("txtf2", "stxtf2: " + txtf2);

            cvf2 = (CardView) viewf2.findViewById(R.id.crdvw);

        } else {
            txtf2 = "0";
            Log.d("txtf2", "stxtf2: " + txtf2);

        }

        resultadof = Float.parseFloat(txtr);
        f1 = Float.parseFloat(txtf1);
        f2 = Float.parseFloat(txtf2);


        if (resultadof == (f2 / f1)) {
            Toast.makeText(getApplication(), R.string.divicion, Toast.LENGTH_SHORT).show();
            Log.d("divicionizq", "divicionizq: " + (f2 / f1));

            textf1.setText("7");
            textf2.setText("7");
            textr.setText("7");

            cvr.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf1.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));
            cvf2.setCardBackgroundColor(Color.parseColor(getApplicationContext().getString(R.color.colorbcgrcrdv)));

            counterdiv = counterdiv + 1;
            Log.d("counterdiv", "counterdiv: " + counterdiv);

        }

    }


}
