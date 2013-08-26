package com.game.reversalchequer;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.RDQA.bmi_calc.Main;
import com.example.reversalchequer.R;

public class MainActivity extends Activity
{

	private ImageButton chessman1;
	private ImageButton chessman2;
	private ImageButton chessman3;
	private ImageButton chessman4;
	private ImageButton chessman5;
	private ImageButton chessman6;
	private ImageButton chessman7;
	private ImageButton chessman8;
	private ImageButton chessman9;
	private static final String TAG_Calc = "Debug_calc";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 呼叫找出介面元件函式
		findViews();

		// 等待換算按鈕被戳函式
		CalcSetListeners(ImageButton img_button);

		// 等待BMI計算按鈕被戳函式
		BMISetListeners();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void findViews()
	{
		chessman1 = (ImageButton) findViewById(R.id.chessman1);
		chessman2 = (ImageButton) findViewById(R.id.chessman2);
		chessman3 = (ImageButton) findViewById(R.id.chessman3);
		chessman4 = (ImageButton) findViewById(R.id.chessman4);
		chessman5 = (ImageButton) findViewById(R.id.chessman5);
		chessman6 = (ImageButton) findViewById(R.id.chessman6);
		chessman7 = (ImageButton) findViewById(R.id.chessman7);
		chessman8 = (ImageButton) findViewById(R.id.chessman8);
		chessman9 = (ImageButton) findViewById(R.id.chessman9);
	}

	// 等待星狀按鈕被戳函式
	private void CalcSetListeners(ImageButton img_button)
	{
		// 透過前面宣告的TAG_Calc標籤，方便在CalcSetListeners()涵式中Debug
		// d=debug 除錯資訊
		Log.d(TAG_Calc, "Calc Set Listeners");
		img_button.setOnClickListener(btn);
	}

	// 單位換算程式(公斤>磅，公分>英呎)
	private Button.OnClickListener btn = new Button.OnClickListener()
	{

		public void onClick(View V)
		{

			// Try error
			try
			{

				DecimalFormat nFormat = new DecimalFormat("0.00");

				// 公分轉英呎
				double feet = Double.parseDouble(field_height.getText()
						.toString()) / 30.48;

				// 公斤轉英磅
				double pound = Double.parseDouble(field_weight.getText()
						.toString()) * 2.2;

				// 將換算結果存到view_result_feet與view_result_pound這兩個TextView中。
				view_result_feet.setText(getText(R.string.result_height)
						+ nFormat.format(feet));
				view_result_pound.setText(getText(R.string.result_weight)
						+ nFormat.format(pound));

			} catch (Exception error)
			{

				//
				Log.e(TAG_Calc, "Error" + error.toString());

				// 錯誤處理，Toast函式。
				Toast.makeText(Main.this, R.string.error_msg, Toast.LENGTH_LONG)
						.show();
			}

		}

	};
}
