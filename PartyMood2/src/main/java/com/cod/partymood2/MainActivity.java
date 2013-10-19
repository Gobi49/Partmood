package com.cod.partymood2;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            final Button crazyButton = (Button) rootView.findViewById(R.id.button_crazy);
            final Button barButton = (Button) rootView.findViewById(R.id.button_barhopping);
            final Button chillButton = (Button) rootView.findViewById(R.id.button_chill);
            final EditText moodText = (EditText) rootView.findViewById(R.id.editMood);

            View.OnClickListener handler = new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if (view == crazyButton)
                    {
                        moodText.setText("This is a crazy description for the Crazy Mood." +
                                " Party all you can man!");
                    }
                    if (view == barButton)
                    {
                        moodText.setText("This is the bar hopping mood, go to Blabla, then to Sonar" +
                                " and finish at Moon!");
                    }
                    if (view == chillButton)
                    {
                        moodText.setText("Just want to chill out, just go to Blabla; drink some Irouleguy" +
                                " and say Hi to the barman for me.");
                    }
                }
            };

            if (moodText == null)
            {
                Log.e("MoodError", "Mood Test is NULL");
            }

            if (crazyButton != null)
                crazyButton.setOnClickListener(handler);
            else
                moodText.setText("Crazy null");
            if (barButton != null)
                barButton.setOnClickListener(handler);
            else
                moodText.setText("Bar null");
            if (chillButton != null)
                chillButton.setOnClickListener(handler);
            else
                moodText.setText("Chill null");

            return rootView;
        }
    }

}
