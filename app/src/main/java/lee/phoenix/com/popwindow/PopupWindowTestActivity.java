package lee.phoenix.com.popwindow;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;


public class PopupWindowTestActivity extends Activity {

    private Button button;
    private View popupWindowView;
    private PopupWindow popupWindow;
    private Button confirmButton;
    private Button cancleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init( );
    }

    private void init() {
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new ButtonOnClickListener());

    }

    private class ButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                    popupWindowView = inflater.inflate(R.layout.popupwindow, null);
                    popupWindow = new PopupWindow(popupWindowView, ViewGroup.LayoutParams.FILL_PARENT, 200,true);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    //设置PopupWindow的弹出和消失效果
                    popupWindow.setAnimationStyle(R.style.popupAnimation);

                    confirmButton = (Button) popupWindowView.findViewById(R.id.confirmButton);
                    confirmButton.setOnClickListener(new ButtonOnClickListener());
                    cancleButton = (Button) popupWindowView.findViewById(R.id.cancleButton);
                    cancleButton.setOnClickListener(new ButtonOnClickListener());
                    popupWindow.showAtLocation(cancleButton, Gravity.NO_GRAVITY, -50,100);
                    break;
                case R.id.confirmButton:
                    System.out.println("点击了确定按钮");
                    break;
                case R.id.cancleButton:
                    popupWindow.dismiss();
                    break;
                default:
                    break;
            }

        }}


}
