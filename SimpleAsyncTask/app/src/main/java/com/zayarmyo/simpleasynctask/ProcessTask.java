package com.zayarmyo.simpleasynctask;

import android.os.AsyncTask;

public class ProcessTask extends AsyncTask<Integer,Integer,String> {
    @Override
    protected void onPreExecute() {
        //The first execution method
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Integer... integers) {
        //Background Process
        return "Completion of execution";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //Upgrade Progress to UI
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        //after execution
        super.onPostExecute(s);
    }
}
