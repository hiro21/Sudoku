package sudoku.example.org.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/**
 * Created by setohiroyuki on 2016/06/02.
 */
//public class Prefs extends PreferenceActivity{
public class Prefs extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //addPreferencesFromResource(R.xml.settings);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingPrefFrag()).commit();
    }

    public static class SettingPrefFrag extends PreferenceFragment{
        @Override
        public void onCreate(Bundle saveInstanceState){
            super.onCreate(saveInstanceState);
            addPreferencesFromResource(R.xml.settings);
        }
    }
}
