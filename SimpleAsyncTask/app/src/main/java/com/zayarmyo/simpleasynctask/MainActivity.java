package com.zayarmyo.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar mProgressBar;
    TextView    mProgressTextView;
    TextView    mResultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar=findViewById(R.id.pb);
        mProgressTextView=findViewById(R.id.tv);
        mResultView=findViewById(R.id.result);

    }


    public void process(View view) {
        ProcessTask dTask=new ProcessTask();
        dTask.execute(50);
    }

    class ProcessTask extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            int random=0;
            for(int i=0;i<=100;i++){
                mProgressBar.setProgress(i);
                publishProgress(i,random);
                try{
                    Thread.sleep(params[0]);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                random=(int)(Math.random()*8+1);
            }
            return random;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressTextView.setText(values[0]+"%");
            mResultView.setText("Random Number: "+values[1]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            mResultView.setText("Final Lucky Number: "+integer);
            super.onPostExecute(integer);
        }
    }

}