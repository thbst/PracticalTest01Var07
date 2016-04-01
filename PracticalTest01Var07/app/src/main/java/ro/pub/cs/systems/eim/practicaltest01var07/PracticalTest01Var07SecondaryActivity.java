package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {
    private final String MY_ACTION = "ro.pub.cs.systems.eim.practicaltest01var07.intent.action.PracticalTest01Activity";
    private Button okButton = null;
    private Button cancelButton = null;
    private TextView textView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        Button okButton = (Button) findViewById(R.id.ok_button);
        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        TextView text1View = (TextView) findViewById(R.id.text1);
        TextView text2View = (TextView) findViewById(R.id.text2);

        okButton.setOnClickListener(new HandleClick());
        cancelButton.setOnClickListener(new HandleClick());

        Intent intentFromParent = getIntent();
        String name = intentFromParent.getStringExtra(MY_ACTION+".name");
        String group = intentFromParent.getStringExtra(MY_ACTION+".group");

        text1View.setText(name);
        text2View.setText(group);
////        Log.d(Constants.TAG,"ImportPrimary: count1="+count1+" count2="+count2);
//        textView.setText("clicks: first="+count1+", second="+count2);


    }

    private class HandleClick implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            Button okButton = (Button) findViewById(R.id.ok_button);
            Button cancelButton = (Button) findViewById(R.id.cancel_button);
            Intent intentToParent = new Intent();
            switch (view.getId()) {
                case R.id.ok_button:
                    intentToParent.putExtra(MY_ACTION+"result", 0);
                    setResult(RESULT_OK, intentToParent);
                    finish();
                    break;
                case R.id.cancel_button:
                    intentToParent.putExtra(MY_ACTION+"result", 1);
                    setResult(RESULT_CANCELED, intentToParent);
                    finish();
                    break;
            }
        }
    }
}
