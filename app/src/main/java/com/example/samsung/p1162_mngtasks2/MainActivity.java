package com.example.samsung.p1162_mngtasks2;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import static android.app.ActivityManager.RunningTaskInfo;


public class MainActivity extends AppCompatActivity {

    private List<ActivityManager.RunningTaskInfo> list;
    private ActivityManager activityManager;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = getString(R.string.app_name) + " : " + getLocalClassName();
        setTitle(message);
        activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    }

    public void onClickBtn(View view) {

        //noinspection deprecation
        list = activityManager.getRunningTasks(10);

        switch (view.getId()) {

            case R.id.btnInfo:
                for (RunningTaskInfo taskInfo : list) {
                    if (taskInfo.baseActivity.flattenToShortString().startsWith("com.example.samsung.p116")) {
                        message = "------------------------";
                        Messager.sendTpOnlyLog(message);
                        message = "Count: " + taskInfo.numActivities;
                        Messager.sendTpAllRecipients(getBaseContext(), message);
                        message = "Root: " + taskInfo.baseActivity.flattenToShortString();
                        Messager.sendTpAllRecipients(getBaseContext(), message);
                        message = "Top: " + taskInfo.topActivity.flattenToShortString();
                        Messager.sendTpAllRecipients(getBaseContext(), message);
                    }
                }
                break;
            case R.id.btnStart :
                startActivity(new Intent("mngtasks1_activity_c")
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                break;
            default :
                break;
        }
    }
}
