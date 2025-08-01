package mkt.lockerpm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import de.hdodenhof.circleimageview.*;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.CompoundButton;
import android.view.View;
import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class PasgenActivity extends  AppCompatActivity  { 
	
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private double n = 0;
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private CircleImageView circleimageview1;
	private TextView textview6;
	private LinearLayout linear2;
	private CheckBox checkbox1;
	private Button login;
	private TextView textview5;
	private LinearLayout linear3;
	private TextView pad;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.pasgen);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_app_bar = (AppBarLayout) findViewById(R.id._app_bar);
		_coordinator = (CoordinatorLayout) findViewById(R.id._coordinator);
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		textview6 = (TextView) findViewById(R.id.textview6);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
		login = (Button) findViewById(R.id.login);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		pad = (TextView) findViewById(R.id.pad);
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (n == 0) {
					n++;
					checkbox1.setText("Hide Password");
					pad.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
				}
				else {
					n = 0;
					checkbox1.setText("Show Password");
					pad.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
			}
		});
		
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					_password_gen(10, pad);
				} catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), "invalid operation !!! ");
				}
			}
		});
	}
	
	private void initializeLogic() {
		_hide_password();
		_design();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _design () {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			SketchUi.setCornerRadius(d*7);
			SketchUi.setStroke(d*2,0xFF008DCD);
			pad.setElevation(d*30);
			pad.setBackground(SketchUi);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			SketchUi.setCornerRadius(d*7);
			SketchUi.setStroke(d*2,0xFF008DCD);
			login.setElevation(d*30);
			login.setBackground(SketchUi);
		}
	}
	
	
	public void _MENU () {
	}
	@Override
	public boolean onCreateOptionsMenu (Menu menu){
		menu.add(0, 0, 0, "print").setIcon(R.drawable.copi).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
			case 0:
			((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", pad.getText().toString()));
			SketchwareUtil.showMessage(getApplicationContext(), "copied to clipboard  !!! ");
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void _password_gen (final double _length, final TextView _text) {
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		while (stringBuilder.length() < ((int)_length))
		{
			stringBuilder.append("a#bc124>de#fg#hijk#lm57no75pqr#st3wx42@yzA6%CD#21E9G5HIJ8>7L#MN#634#OPQRS#3U&T#4V#W#32X#Y51#@234567890{}[]".charAt((int)(random.nextFloat() * (float)"a65de5#fghi45%@#jklmno43pqr#32A#BCD43#E567>5IJK#LM67N67#QR#S74T4>#3U5VW#XY#5Z1234#567#890{}[]".length())));
		} 
		
		_text.setText(stringBuilder);
	}
	
	
	public void _hide_password () {
		pad.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
