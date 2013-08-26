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
		// �I�s��X��������禡
		findViews();

		// ���ݴ�����s�Q�W�禡
		CalcSetListeners(ImageButton img_button);

		// ����BMI�p����s�Q�W�禡
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

	// ���ݬP�����s�Q�W�禡
	private void CalcSetListeners(ImageButton img_button)
	{
		// �z�L�e���ŧi��TAG_Calc���ҡA��K�bCalcSetListeners()�[����Debug
		// d=debug ������T
		Log.d(TAG_Calc, "Calc Set Listeners");
		img_button.setOnClickListener(btn);
	}

	// ��촫��{��(����>�S�A����>�^�`)
	private Button.OnClickListener btn = new Button.OnClickListener()
	{

		public void onClick(View V)
		{

			// Try error
			try
			{

				DecimalFormat nFormat = new DecimalFormat("0.00");

				// ������^�`
				double feet = Double.parseDouble(field_height.getText()
						.toString()) / 30.48;

				// ������^�S
				double pound = Double.parseDouble(field_weight.getText()
						.toString()) * 2.2;

				// �N���⵲�G�s��view_result_feet�Pview_result_pound�o���TextView���C
				view_result_feet.setText(getText(R.string.result_height)
						+ nFormat.format(feet));
				view_result_pound.setText(getText(R.string.result_weight)
						+ nFormat.format(pound));

			} catch (Exception error)
			{

				//
				Log.e(TAG_Calc, "Error" + error.toString());

				// ���~�B�z�AToast�禡�C
				Toast.makeText(Main.this, R.string.error_msg, Toast.LENGTH_LONG)
						.show();
			}

		}

	};
}
