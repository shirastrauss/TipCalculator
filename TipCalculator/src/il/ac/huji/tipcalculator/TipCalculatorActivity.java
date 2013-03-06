package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This class implements a Tip Calculator application
 * @author Shira Strauss
 *
 */
public class TipCalculatorActivity extends Activity {

	public static final int TIP_PERCENT = 12;
	boolean _roundTip = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);

		// text box for the input-the bill amount
		final EditText edtBillAmount = (EditText) findViewById(R.id.edtBillAmount);
		
		// textView for the tip result display 
		final TextView txtTipResult = (TextView) findViewById(R.id.txtTipResult);

		// check box for choosing whether to round the result or not
		final CheckBox cb = (CheckBox) findViewById(R.id.chkRound);
		cb.setOnCheckedChangeListener(
				new OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
						_roundTip = !_roundTip;	
					}
				});

		// "calculate" button
		final Button b = (Button) findViewById(R.id.btnCalculate);
		b.setOnClickListener(
				new OnClickListener() {
					public void onClick(View v) {
						
						// gets the bill amount from the text box
						String bill = edtBillAmount.getText().toString();
						
						// checks the bill text box is not empty
						if (!bill.equals("")){
							
							// calculates tip
							double billAmount=Double.parseDouble(bill);
							double tip = billAmount*TIP_PERCENT/100.0;
							
							String txtTip="Tip: $";
							if(_roundTip){ // rounding requested
								txtTip += (int)Math.round(tip);
							}
							else{ // no rounding
								
								// formats the result to display only two trailing digits
								txtTip += String.format("%.2f", tip);
							}
							// displays result
							txtTipResult.setText(txtTip);
						}
					}
				});

	}

}
