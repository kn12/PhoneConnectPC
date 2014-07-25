package qinyn.android.connectpc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class PaintView extends View implements OnTouchListener{

	public PaintView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}
	
	@Override
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

}
