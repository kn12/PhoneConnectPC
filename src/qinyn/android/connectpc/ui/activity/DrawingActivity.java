package qinyn.android.connectpc.ui.activity;

import qinyn.android.connectpc.view.PenBrush;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

public class DrawingActivity extends BaseFragmentActivity {

	private PenBrush currentBrush;

	@Override
	protected int getLayoutId() {
		return 0;
	}

	@Override
	protected void onContentView() {
		currentBrush = new PenBrush();
	}

	

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			
			
			}
		}
	};

}
