package abeni.com.quizafrica;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    private String TAG = MainActivity.class.getSimpleName();

    private ListView lv;

    // URL to get contacts JSON
    private static String url = "https://www.dagublogs.com/abeni_africa.json";

    ArrayList<HashMap<String, String>> questionList;

    public Button btnA, btnB , btnC, btnD;

    String choice_a ,choice_b ,choice_c , choice_d ,Question_ans ;

    private ViewPager mViewPager;
    Main1Fragment mainF;
//    @BindView(R.id.btn_card_main1_action1)
//    AppCompatButton btnA;
//    @BindView(R.id.btn_card_main1_action2) AppCompatButton btnB;
//    @BindView(R.id.btn_card_main1_action3) AppCompatButton btnC;
//    @BindView(R.id.btn_card_main1_action4) AppCompatButton btnD;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);



//        btnA = (Button) findViewById(R.id.btn_card_main1_action1);
//        btnB = (Button) findViewById(R.id.btn_card_main1_action2);
//
//        btnC = (Button) findViewById(R.id.btn_card_main1_action3);
//        btnD = (Button) findViewById(R.id.btn_card_main1_action4);
//
//        btnA.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//                String text = btnA.getText().toString();
//                Snackbar.make(v, text, Snackbar.LENGTH_SHORT).show();
//                Log.d("Answer btn1", text);
//            }
//        });
////
//        btnB.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//                String text2 = btnB.getText().toString();
//                Snackbar.make(v, text2, Snackbar.LENGTH_SHORT).show();
//                Log.d("Answer btn2", text2);
//            }
//        });
////
//        btnC.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//                String text3 = btnC.getText().toString();
//                Snackbar.make(v, text3, Snackbar.LENGTH_SHORT).show();
//                Log.d("Answer btnC", text3);
//            }
//        });
//
//        btnD.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//                String text4 = btnD.getText().toString();
//                Snackbar.make(v, text4, Snackbar.LENGTH_SHORT).show();
//                Log.d("Answer btnD", text4);
//            }
//        });
//


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
//
//        // Set up the ViewPager with the sections adapter.
//        mViewPager = (ViewPager) findViewById(R.id.container);
//        mViewPager.setAdapter(mSectionsPagerAdapter);

        questionList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetQuiz().execute();




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    /**
     * Async task class to get json by making HTTP call
     */
    private class GetQuiz extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
//            pDialog = new ProgressDialog(MainActivity.this);
//            pDialog.setMessage("Please wait...");
//            pDialog.setCancelable(false);
//            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray quest = jsonObj.getJSONArray("Questions");

                    // looping through All question
                    for (int i = 0; i < quest.length(); i++) {
                        JSONObject c = quest.getJSONObject(i);

                        String id = c.getString("id");
                         String question_type = c.getString("Question_Type");
                         String question_text = c.getString("Question_Text");
                         choice_a = c.getString("choice_a");
                         choice_b = c.getString("choice_b");
                         choice_c = c.getString("choice_b");
                         choice_d = c.getString("choice_b");
                         Question_ans = c.getString("Question_ans");



                        HashMap<String, String> question = new HashMap<>();

                        // adding each child node to HashMap key => value
                        question.put("id", id);
                        question.put("question_type", question_type);
                        question.put("question_text", question_text);
                        question.put("choice_a", choice_a);

                        question.put("choice_b", choice_b);
                        question.put("choice_c", choice_c);

                        question.put("choice_d", choice_d);
                        question.put("Question_ans", Question_ans);


                        questionList.add(question);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
//
//            btnA = (Button) findViewById(R.id.btn_card_main1_action1);
//            btnB = (Button) findViewById(R.id.btn_card_main1_action2);
//
//            btnC = (Button) findViewById(R.id.btn_card_main1_action3);
//            btnD = (Button) findViewById(R.id.btn_card_main1_action4);
//
//            btnA.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    // Code here executes on main thread after user presses button
//                    String text = btnA.getText().toString();
//                    Snackbar.make(v, text, Snackbar.LENGTH_SHORT).show();
//                    Log.d("Answer btn1", text);
//                }
//            });
//
//            btnB.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    // Code here executes on main thread after user presses button
//                    String text2 = btnB.getText().toString();
//                    Snackbar.make(v, text2, Snackbar.LENGTH_SHORT).show();
//                    Log.d("Answer btn2", text2);
//                }
//            });
//
//            btnC.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    // Code here executes on main thread after user presses button
//                    String text3 = btnC.getText().toString();
//                    Snackbar.make(v, text3, Snackbar.LENGTH_SHORT).show();
//                    Log.d("Answer btnC", text3);
//                }
//            });
//
//            btnD.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    // Code here executes on main thread after user presses button
//                    String text4 = btnD.getText().toString();
//                    Snackbar.make(v, text4, Snackbar.LENGTH_SHORT).show();
//                    Log.d("Answer btnD", text4);
//                }
//            });
//
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, questionList,
                    R.layout.card_main_1, new String[]{"question_text", "choice_a",
                    "choice_b", "choice_c", "choice_d"}, new int[]{R.id.tv_card_main_1_title,
                    R.id.btn_card_main1_action1, R.id.btn_card_main1_action2, R.id.btn_card_main1_action3, R.id.btn_card_main1_action4 });



            lv.setAdapter(adapter);

        }

    }
}
