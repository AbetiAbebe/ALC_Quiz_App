package abeni.com.quizafrica;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;




import static android.content.Context.MODE_PRIVATE;

/**
 * Created by zhang on 2016.08.07.
 */
public class Main1Fragment extends Fragment implements View.OnClickListener, View.OnTouchListener {

    private ImageView img_main_card2_share, img_main_card2_bookmark, img_main_card2_favorite;
    private boolean isBookmarkClicked, isFavoriteClicked, isBookmark41Clicked, isBookmark42Clicked, isFavorite41Clicked, isFavorite42Clicked;
    private LinearLayout ll_card_main3_rate;
    private Button btn_card_main1_action1, btn_card_main1_action2;
    private ImageView img_main_card_1, img_main_card_2, img_card_main_3, img_main_card_41, img_main_card_42,
            img_main_card41_favorite, img_main_card42_favorite, img_main_card41_bookmark, img_main_card42_bookmark,
            img_main_card41_share, img_main_card42_share;
    private CardView card_main_1_1, card_main_1_2, card_main_1_3, card_main_1_4_1, card_main_1_4_2;
    private AlphaAnimation alphaAnimation, alphaAnimationShowIcon;
    private CardView card_ad;
    public Button btnA, btnB , btnC, btnD;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NestedScrollView nestedScrollView = (NestedScrollView) inflater.inflate(R.layout.fragment_main_1, container, false);

        btnA = (Button) nestedScrollView.findViewById(R.id.btn_card_main1_action1);
        btnB = (Button) nestedScrollView.findViewById(R.id.btn_card_main1_action2);

        btnC = (Button) nestedScrollView.findViewById(R.id.btn_card_main1_action3);
        btnD = (Button) nestedScrollView.findViewById(R.id.btn_card_main1_action4);

        card_main_1_1 = (CardView) nestedScrollView.findViewById(R.id.card_main_1_1);

//        btnA = (Button) findViewById(R.id.btn_card_main1_action1);
//        btnB = (Button) findViewById(R.id.btn_card_main1_action2);
//
//        btnC = (Button) findViewById(R.id.btn_card_main1_action3);
//        btnD = (Button) findViewById(R.id.btn_card_main1_action4);

        btnA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String text = btnA.getText().toString();
                Snackbar.make(v, text, Snackbar.LENGTH_SHORT).show();
                Log.d("Answer btn1", text);
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String text2 = btnB.getText().toString();
                Snackbar.make(v, text2, Snackbar.LENGTH_SHORT).show();
                Log.d("Answer btn2", text2);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String text3 = btnC.getText().toString();
                Snackbar.make(v, text3, Snackbar.LENGTH_SHORT).show();
                Log.d("Answer btnC", text3);
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String text4 = btnD.getText().toString();
                Snackbar.make(v, text4, Snackbar.LENGTH_SHORT).show();
                Log.d("Answer btnD", text4);
            }
        });

        return nestedScrollView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn_card_main1_action1.setOnClickListener(this);
        btn_card_main1_action2.setOnClickListener(this);


        card_main_1_1.setOnClickListener(this);


        card_main_1_1.setOnTouchListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_card_main1_action1 :

                String text = btnA.getText().toString();
                Snackbar.make(v, text, Snackbar.LENGTH_SHORT).show();
                Log.d("Answer btn1", text);
                break;

            case R.id.btn_card_main1_action2:

                String text2 = btnB.getText().toString();
                Snackbar.make(v, text2, Snackbar.LENGTH_SHORT).show();
                Log.d("Answer btn1", text2);


                break;
            case R.id.btn_card_main1_action3:

                String text3 = btnC.getText().toString();
                Snackbar.make(v, text3, Snackbar.LENGTH_SHORT).show();
                Log.d("Answer btn1", text3);


                break;
            case  R.id.btn_card_main1_action4:

                String text4 = btnD.getText().toString();
                Snackbar.make(v, text4, Snackbar.LENGTH_SHORT).show();
                Log.d("Answer btn1", text4);


                break;






        }

    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ObjectAnimator upAnim = ObjectAnimator.ofFloat(view, "translationZ", 16);
                upAnim.setDuration(150);
                upAnim.setInterpolator(new DecelerateInterpolator());
                upAnim.start();
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                ObjectAnimator downAnim = ObjectAnimator.ofFloat(view, "translationZ", 0);
                downAnim.setDuration(150);
                downAnim.setInterpolator(new AccelerateInterpolator());
                downAnim.start();
                break;
        }
        return false;
    }


}
