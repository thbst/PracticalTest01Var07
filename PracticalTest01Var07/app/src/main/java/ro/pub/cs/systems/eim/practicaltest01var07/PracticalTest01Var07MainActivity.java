package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;





public class PracticalTest01Var07MainActivity extends AppCompatActivity {
    private Button navButton = null;
    private final String TAG = "EIM";
    private final String MY_ACTION = "ro.pub.cs.systems.eim.practicaltest01var07.intent.action.PracticalTest01Activity";

    private class HandleClick implements Button.OnClickListener {
        @Override
        public void onClick(View view) {

            navButton = (Button) findViewById(R.id.nav_button);

            switch (view.getId()) {
                case R.id.nav_button:
                    Log.d(TAG, "nav_button");
//                    final String THE_ACTION="ro.pub.cs.systems.eim.lab04.intent.action.PracticalTest01Activity";
//                    final String THE_CATEGORY="android.intent.category.DEFAULT";
                    Intent intent = new Intent();
                    intent.setAction(MY_ACTION);
//                    intent.addCategory(THE_CATEGORY);
//                    intent.putExtra(MY_ACTION+".count1", count1);
                    try {
//                        startActivityForResult(intent,ID);
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                        Log.d("TAG", "Secondary Activity not found");
                    }
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);
        navButton = (Button) findViewById(R.id.nav_button);

        navButton.setOnClickListener(new HandleClick());

    }

}
