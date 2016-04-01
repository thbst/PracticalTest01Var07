package ro.pub.cs.systems.eim.practicaltest01var07;




import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Var07Service extends Service {

    private int startMode=START_REDELIVER_INTENT;
    private ProcessingThread processingThread=null;

    @Override
    public void onCreate() {
        super.onCreate();
//        Log.d(Constants.TAG, "onCreate() method was invoked");
    }

    @Override
    public int onStartCommand(Intent intent,
                              int flags,
                              int startId) {
        String name = intent.getStringExtra("name");
        String group = intent.getStringExtra("group");
//        double aritm = (count1+count2)/2;
//        double geom = Math.sqrt(count1*count2);

        if (intent == null) {
//            Log.d(Constants.TAG, "onStartCommand with null intent");
        }
        else {
//            Log.d(Constants.TAG, "onStartCommand with count1=" + count1 + ", count2=" + count2);
        }
        ProcessingThread processingThread = new ProcessingThread(this,name,group);
        processingThread.start();
//        stopSelf();
//        Log.d(Constants.TAG,"Stopping myself as as service");
        return startMode;
    }

    @Override
    public IBinder onBind(Intent intent) {
//        Log.d(Constants.TAG, "onBind() method was invoked");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
//        Log.d(Constants.TAG, "onUnbind() method was invoked");
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
//        Log.d(Constants.TAG, "onRebind() method was invoked");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        processingThread.stop();
//        Log.d(Constants.TAG, "onDestroy() method was invoked");
    }
}

