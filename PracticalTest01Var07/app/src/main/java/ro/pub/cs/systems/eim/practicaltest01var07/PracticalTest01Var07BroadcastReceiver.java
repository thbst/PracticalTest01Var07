package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class PracticalTest01Var07BroadcastReceiver extends BroadcastReceiver {

    public PracticalTest01Var07BroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String data = null;
//        if ((Constants.ACTION_STRING1.equals(action)) || (Constants.ACTION_STRING2.equals(action)) || (Constants.ACTION_STRING3.equals(action))) {
//            data = intent.getStringExtra(Constants.DATA);
//        }
//        Intent startedServiceActivityIntent = new Intent(context, PracticalTest01MainActivity.class);
//        startedServiceActivityIntent.putExtra(Constants.MESSAGE, data);
//        startedServiceActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        context.startActivity(startedServiceActivityIntent);
//
//        Log.d(Constants.TAG,"Message received inside bReceiver: "+data);
    }
}

