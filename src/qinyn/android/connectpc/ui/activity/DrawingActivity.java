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

	public boolean onTouch(View view, MotionEvent motionEvent) {
//		if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//			currentBrush.mouseDown(currentDrawingPath.path, motionEvent.getX(),
//					motionEvent.getY());
//		} else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//			currentBrush.mouseMove(currentDrawingPath.path, motionEvent.getX(),
//					motionEvent.getY());
//		} else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
//			currentBrush.mouseUp(currentDrawingPath.path, motionEvent.getX(),
//					motionEvent.getY());
//			drawingSurface.isDrawing = true;
//		}
		return true;
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			
			
			}
		}
	};

}
