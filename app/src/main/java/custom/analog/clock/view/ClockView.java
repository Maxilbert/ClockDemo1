package custom.analog.clock.view;

import java.util.Calendar;
//import java.util.TimeZone;

import custom.analog.clock.R;
//import custom.analog.clock.R.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
//import android.widget.LinearLayout;

public 	class ClockView extends View {

	static int viewCount = 0;

	Bitmap mBmpDial;
	Bitmap mBmpHour;
	Bitmap mBmpMinute;
	Bitmap mBmpSecond;

	BitmapDrawable bmdHour;
	BitmapDrawable bmdMinute;
	BitmapDrawable bmdSecond;
	BitmapDrawable bmdDial;

	Paint mPaint;

	Handler tickHandler;

	String Tag = "clock";
	int mWidth;
	int mTempWidth;
	int mHeigh;
	int mTempHeigh;
	int centerX;
	int centerY;

	int availableWidth;
	int availableHeight;

	public ClockView(Context context) {
		super(context);
		init();
	}

	public ClockView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ClockView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width = getMeasuredWidth();
//		int height = getMeasuredHeight();
//		int size;
//		if (width >= height){
//			size = height;
//		} else {
//			size = width;
//		}
//		System.out.println("Width:"+width+"; Height:"+height+"; Size:"+size);
		setMeasuredDimension(width, mHeigh);
		run();
	}

	public void init(){

System.out.println(viewCount++ + " view created.");
		//
		mBmpHour = BitmapFactory.decodeResource(getResources(),
				R.drawable.android_clock_hour);
		bmdHour = new BitmapDrawable(getResources(), mBmpHour);

		mBmpMinute = BitmapFactory.decodeResource(getResources(),
				R.drawable.android_clock_minute);
		bmdMinute = new BitmapDrawable(getResources(), mBmpMinute);

		mBmpSecond = BitmapFactory.decodeResource(getResources(),
				R.drawable.android_clock_second);
		bmdSecond = new BitmapDrawable(getResources(), mBmpSecond);

		mBmpDial = BitmapFactory.decodeResource(getResources(),
				R.drawable.android_clock_dial);
		bmdDial = new BitmapDrawable(getResources(), mBmpDial);

		//
		mWidth = mBmpDial.getWidth();
		mHeigh = mBmpDial.getHeight();
//		centerX = availableWidth / 2;
//		centerY = availableHeight / 2;

		mPaint = new Paint();
		mPaint.setColor(Color.GRAY);

	}

	public void run() {
		tickHandler = new Handler();
		tickHandler.post(tickRunnable);
	}

	private Runnable tickRunnable = new Runnable() {
		public void run() {
			postInvalidate();
			tickHandler.postDelayed(tickRunnable, 1000);
		}
	};

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawColor(Color.WHITE);

		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR) % 12;
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		float hourRotate = hour * 30.0f + minute / 60.0f * 30.0f;
		float minuteRotate = minute * 6.0f + second / 60.0f * 6.0f;
		float secondRotate = second * 6.0f;

		centerX = getMeasuredWidth()/2;
		centerY = mHeigh/2;
		availableHeight = getHeight();
		availableWidth = getWidth();
		boolean scaled = false;
		if (availableWidth < mWidth || availableHeight < mHeigh) {
			scaled = true;
			float scale = Math.min((float) availableWidth / (float) mWidth,
					(float) availableHeight / (float) mHeigh);
			canvas.save();
			canvas.scale(scale, scale, centerX, centerY);
		}

//System.out.println("centerX:"+centerX+"; centerY:"+centerY+"; mHeigh:"+mHeigh+"; mWidth:"+mWidth);

		bmdDial.setBounds(centerX - (mWidth / 2), centerY - (mHeigh / 2),
				centerX + (mWidth / 2), centerY + (mHeigh / 2));
		bmdDial.draw(canvas);

		mTempWidth = bmdHour.getIntrinsicWidth();
		mTempHeigh = bmdHour.getIntrinsicHeight();
		canvas.save();
		canvas.rotate(hourRotate, centerX, centerY);
		bmdHour.setBounds(centerX - (mTempWidth / 2), centerY
				- (mTempHeigh / 2), centerX + (mTempWidth / 2), centerY
				+ (mTempHeigh / 2));
		bmdHour.draw(canvas);
		canvas.restore();

		mTempWidth = bmdMinute.getIntrinsicWidth();
		mTempHeigh = bmdMinute.getIntrinsicHeight();
		canvas.save();
		canvas.rotate(minuteRotate, centerX, centerY);
		bmdMinute.setBounds(centerX - (mTempWidth / 2), centerY
				- (mTempHeigh / 2), centerX + (mTempWidth / 2), centerY
				+ (mTempHeigh / 2));
		bmdMinute.draw(canvas);
		canvas.restore();

		mTempWidth = bmdSecond.getIntrinsicWidth();
		mTempHeigh = bmdSecond.getIntrinsicHeight();
		canvas.rotate(secondRotate, centerX, centerY);
		bmdSecond.setBounds(centerX - (mTempWidth / 2), centerY
				- (mTempHeigh / 2), centerX + (mTempWidth / 2), centerY
				+ (mTempHeigh / 2));
		bmdSecond.draw(canvas);
		if (scaled) {
			canvas.restore();
		}
	}
}
