package org.androidtown.doltmission06;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {

    LinearLayout layout;
    Animation animation;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button_search);
    }

    public void onButton1Clicked(View v){
        layout=(LinearLayout)findViewById(R.id.linear_up);


        if(btn.getText().equals("검색하기")){

            layout.setVisibility(View.VISIBLE);
            btn.setText("검색페이지");
            Animation animation= AnimationUtils.loadAnimation(this, R.anim.anim_down);
            layout.startAnimation(animation);

        }else{
            btn.setVisibility(View.INVISIBLE);
        }

    }

    public void onButton2Clicked(View v){
        EditText editText=(EditText)findViewById(R.id.editText);
        WebView webView =(WebView)findViewById(R.id.webView1);

        String site=editText.getText().toString();

        animation= AnimationUtils.loadAnimation(this, R.anim.anim_up);
        layout.startAnimation(animation);
        layout.setVisibility(View.GONE);

        btn.setText("검색하기");

        webView.loadUrl("http://m."+site);



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
}
