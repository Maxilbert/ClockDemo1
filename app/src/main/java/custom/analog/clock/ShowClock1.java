package custom.analog.clock;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import custom.analog.clock.view.ClockView;

public class ShowClock1 extends Activity {
	
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.showclock);
//        ClockView clock1 = new ClockView(this);
//    }

	private final int FP = ViewGroup.LayoutParams.MATCH_PARENT;
	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;

	private ClockView clock1;
	private ClockView clock2;
	private ClockView clock3;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout lLayout = new LinearLayout(this);
		lLayout.setLayoutParams(new LinearLayout.LayoutParams(FP, FP));
		lLayout.setOrientation(LinearLayout.VERTICAL);

		clock1 = new ClockView(this);
		lLayout.addView(clock1, new LinearLayout.LayoutParams(WC, WC));

		clock2 = new ClockView(this);
		lLayout.addView(clock2, new LinearLayout.LayoutParams(WC, WC));

		clock3 = new ClockView(this);
		lLayout.addView(clock3, new LinearLayout.LayoutParams(WC, WC));

		setContentView(lLayout);
	}

//	class QAnalogClock extends View {
//		Bitmap mBmpDial;
//		Bitmap mBmpHour;
//		Bitmap mBmpMinute;
//		Bitmap mBmpSecond;
//
//		BitmapDrawable bmdHour;
//		BitmapDrawable bmdMinute;
//		BitmapDrawable bmdSecond;
//		BitmapDrawable bmdDial;
//
//		Paint mPaint;
//
//		Handler tickHandler;
//
//		int mWidth;
//		int mHeigh;
//		int mTempWidth;
//		int mTempHeigh;
//		int centerX;
//		int centerY;
//
//		int availableWidth = 300;
//		int availableHeight = 300;
//
//		private String sTimeZoneString;
//
//		public QAnalogClock(Context context, String sTime_Zone) {
//			super(context);
//			sTimeZoneString = sTime_Zone;
//
//			mBmpHour = BitmapFactory.decodeResource(getResources(),
//					R.drawable.android_clock_hour);
//			bmdHour = new BitmapDrawable(getResources(), mBmpHour);
//
//			mBmpMinute = BitmapFactory.decodeResource(getResources(),
//					R.drawable.android_clock_minute);
//			bmdMinute = new BitmapDrawable(getResources(), mBmpMinute);
//
//			mBmpSecond = BitmapFactory.decodeResource(getResources(),
//					R.drawable.android_clock_second);
//			bmdSecond = new BitmapDrawable(getResources(), mBmpSecond);
//
//			mBmpDial = BitmapFactory.decodeResource(getResources(),
//					R.drawable.android_clock_dial);
//			bmdDial = new BitmapDrawable(getResources(), mBmpDial);
//			mWidth = mBmpDial.getWidth();
//			mHeigh = mBmpDial.getHeight();
//			centerX = availableWidth / 2;
//			centerY = availableHeight / 2;
//
//			mPaint = new Paint();
//			mPaint.setColor(Color.BLUE);
//			run();
//		}
//
//		public void run() {
//			tickHandler = new Handler();
//			tickHandler.post(tickRunnable);
//		}
//
//		private Runnable tickRunnable = new Runnable() {
//			public void run() {
//				postInvalidate();
//				tickHandler.postDelayed(tickRunnable, 1000);
//			}
//		};
//
//		protected void onDraw(Canvas canvas) {
//			super.onDraw(canvas);
//
//			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(sTimeZoneString));
//			int hour = cal.get(Calendar.HOUR);
//			int minute = cal.get(Calendar.MINUTE);
//			int second = cal.get(Calendar.SECOND);
//			float hourRotate = hour * 30.0f + minute / 60.0f * 30.0f;
//			float minuteRotate = minute * 6.0f;
//			float secondRotate = second * 6.0f;
//
//			boolean scaled = false;
//
//			if (availableWidth < mWidth || availableHeight < mHeigh) {
//				scaled = true;
//				float scale = Math.min((float) availableWidth / (float) mWidth,
//						(float) availableHeight / (float) mHeigh);
//				canvas.save();
//				canvas.scale(scale, scale, centerX, centerY);
//			}
//
//			bmdDial.setBounds(centerX - (mWidth / 2), centerY - (mHeigh / 2),
//					centerX + (mWidth / 2), centerY + (mHeigh / 2));
//			bmdDial.draw(canvas);
//
//			mTempWidth = bmdHour.getIntrinsicWidth();
//			mTempHeigh = bmdHour.getIntrinsicHeight();
//			canvas.save();
//			canvas.rotate(hourRotate, centerX, centerY);
//			bmdHour.setBounds(centerX - (mTempWidth / 2), centerY
//					- (mTempHeigh / 2), centerX + (mTempWidth / 2), centerY
//					+ (mTempHeigh / 2));
//			bmdHour.draw(canvas);
//
//			canvas.restore();
//
//			mTempWidth = bmdMinute.getIntrinsicWidth();
//			mTempHeigh = bmdMinute.getIntrinsicHeight();
//			canvas.save();
//			canvas.rotate(minuteRotate, centerX, centerY);
//			bmdMinute.setBounds(centerX - (mTempWidth / 2), centerY
//					- (mTempHeigh / 2), centerX + (mTempWidth / 2), centerY
//					+ (mTempHeigh / 2));
//			bmdMinute.draw(canvas);
//
//			canvas.restore();
//
//			mTempWidth = bmdSecond.getIntrinsicWidth();
//			mTempHeigh = bmdSecond.getIntrinsicHeight();
//			canvas.rotate(secondRotate, centerX, centerY);
//			bmdSecond.setBounds(centerX - (mTempWidth / 2), centerY
//					- (mTempHeigh / 2), centerX + (mTempWidth / 2), centerY
//					+ (mTempHeigh / 2));
//			bmdSecond.draw(canvas);
//
//			if (scaled) {
//				canvas.restore();
//			}
//		}
//	}
	
}
