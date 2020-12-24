package com.fivefour.homeexpense;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import static android.animation.ObjectAnimator.*;

public class ItemAnimation {

    private  static final long DURATION_IN_FADE_ID=300;

    private static final long DURATION_IN_LEFT_RIGHT=150;





    public static void animateFadeIn(View view, int position)
    {
        boolean not_first_item = position == -1;
        position = position+1;
        view.setAlpha(0.f);
        AnimatorSet animatorSet = new AnimatorSet();
       ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view,"alpha",0.f,0.5f,1.f);

        ObjectAnimator.ofFloat(view, "alpha", 0.f).start();

        animatorAlpha.setStartDelay(not_first_item ? DURATION_IN_FADE_ID / 2 : (position * DURATION_IN_FADE_ID/3));

        animatorAlpha.setDuration(DURATION_IN_FADE_ID);
        animatorSet.play(animatorAlpha);
        animatorSet.start();
    }


   /* public static void animateLeftToRight(View view, int position)
    {
        boolean not_first_item = position == -1;
        position = position+1;
        view.setTranslationX(-400f);
        view.setAlpha(0.f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(view,"translationX",-400f,0);

        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view,"alpha",1.f);
        ObjectAnimator.ofFloat(view,"alpha",0.f).start();
        animatorTranslateY.setStartDelay(not_first_item ? DURATION_IN_LEFT_RIGHT : (position * DURATION_IN_LEFT_RIGHT));
        animatorTranslateY.setDuration((not_first_item ? 2 : 1) * DURATION_IN_LEFT_RIGHT);
        animatorSet.playTogether(animatorTranslateY, animatorAlpha);
        animatorSet.start();

    }*/











}


