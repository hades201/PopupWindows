package lee.phoenix.com.mobileadaptation;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int denstiyDPI = dm.densityDpi;
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;

        Log.e("density" ,""+ density);
        Log.e("denstiyDPI" ,""+ denstiyDPI);
        Log.e("xdpi" ,""+ xdpi);
        Log.e("ydpi" ,""+ ydpi);

        int screenWidthDip = dm.widthPixels;
        int screenHeightDip = dm.heightPixels;

        Log.e("screenWidthDip",""+ screenWidthDip);
        Log.e("screenHeightDip",""+ screenHeightDip);
    }


}
