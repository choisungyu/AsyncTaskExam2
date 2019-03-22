package com.csg.asynctaskexam2;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mCountNum;
    private CountTask mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCountNum = findViewById(R.id.text_count_num);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flag_count_down, new CountDownFragment())
                .commit();

        mTask = new CountTask();
        mTask.execute(0);


//        findViewById(R.id.button_start).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onStartClick(View v) {
//
//                mTask = new CountTask();
//                mTask.execute(0);
//
//                CountDownFragment countDownFragment = CountDownFragment.newInstance();
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.flag_count_down, countDownFragment)
//                        .commit();
//
//            }
//        });

//        findViewById(R.id.button_reset).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onStartClick(View v) {
//                mTask.cancel(true);
//                mCountNum.setText("0");
//
//            }
//        });
    }

    public class CountTask extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected Integer doInBackground(Integer... params) {
            do {
                try {
                    Thread.sleep(1000);
                    params[0]++;
                    publishProgress(params[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (params[0] < 10);
            return params[0];
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mCountNum.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Integer integer) {
            mCountNum.setText(String.valueOf(integer));
        }
    }


}
