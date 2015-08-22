package com.copper.view.activity;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.ClientEntityBean;
import com.copper.bean.InvoiceBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.prefs.MyPref;
import com.copper.utils.Utils;
import com.google.android.gms.internal.is;

public class EditInvoicesActivity extends ActionBarActivity implements
		CallBackListener {
	private Context mContext;
	private String items[] = { "Uppon Reciept", "Net 15", "Net 30", "Net 45",
			"custom" };
	private int position = 0;
	private View customActionView;
	private EditText subject, tax, desposite, discount, descr, cl_msg;
	private TextView clientDropdown, paymentDropDown;
	ArrayList<ClientChildBean> arrayList = new ArrayList<ClientChildBean>();
	protected String p_id;
	private TextView dueDateTextView, issueDateTextView;
	public Calendar calendar;
	private DatePickerDialog dialog = null;
	private int type = 0;
	private InvoiceBean invoiceBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mContext = this;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_invoice);
		invoiceBean = (InvoiceBean) getIntent().getExtras().get(
				ConstantLib.INVOICES);
		calendar = Calendar.getInstance();
		dialog = new DatePickerDialog(this, new PickDate(),
				calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));

		dueDateTextView = (TextView) findViewById(R.id.selectDueDate);
		issueDateTextView = (TextView) findViewById(R.id.selectIssueDate);
		descr = (EditText) findViewById(R.id.descriptionEditText);
		cl_msg = (EditText) findViewById(R.id.clientMssageEditText);

		subject = (EditText) findViewById(R.id.subjectEditText);
		tax = (EditText) findViewById(R.id.taxEditText);
		desposite = (EditText) findViewById(R.id.depositeEditText);
		discount = (EditText) findViewById(R.id.discountEditText);
		clientDropdown = (TextView) findViewById(R.id.selectClient);
		paymentDropDown = (TextView) findViewById(R.id.selectPayment);
		clientDropdown.setVisibility(View.GONE);
		paymentDropDown.setText(invoiceBean.getPayment());
		tax.setText(invoiceBean.getTax());
		desposite.setText(invoiceBean.getDeposite_amount());
		discount.setText(invoiceBean.getDiscount_amount());
		issueDateTextView.setText(invoiceBean.getIssued_date());
		dueDateTextView.setText(invoiceBean.getDue_date());
		descr.setText(invoiceBean.getAdditional_note());
		cl_msg.setText(invoiceBean.getClient_message());
		if (invoiceBean.getPayment().equalsIgnoreCase("custom")) {
			findViewById(R.id.selectDueDateLAyout).setVisibility(View.VISIBLE);
		}
		subject.setText(invoiceBean.getSubject());
		findViewById(R.id.selectDueDateLAyout).setVisibility(View.GONE);
		paymentDropDown.setText(items[0]);
		findViewById(R.id.selectDueDateLAyout).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.show();
						type = 1;
					}
				});
		findViewById(R.id.selectissueDateLAyout).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						dialog.show();
						type = 2;

					}
				});

		addActionBar();
		findViewById(R.id.save).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				saveRecord();
			}
		});
		findViewById(R.id.delete).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Utils.deleteDialog(EditInvoicesActivity.this,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								new DeleteCommunicator(
										EditInvoicesActivity.this,
										ConstantLib.INVOICES, invoiceBean
												.getId(), new DeleteListener() {

											@Override
											public void onDelete() {
												// TODO Auto-generated method
												// stub
												finish();

											}
										});
							}
						});
			}
		});
		findViewById(R.id.selectClient).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub

						RequestMethod.getClient(EditInvoicesActivity.this,
								MyPref.getInstance(EditInvoicesActivity.this)
										.readPrefs(MyPref.USER_ID),
								EditInvoicesActivity.this);

					}
				});
		findViewById(R.id.selectPayment).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						AlertDialog.Builder builder = null;

						if (android.os.Build.VERSION.SDK_INT >= 11) {
							builder = new AlertDialog.Builder(mContext,
									AlertDialog.THEME_HOLO_LIGHT);
						} else {
							builder = new AlertDialog.Builder(mContext);
						}
						builder.setTitle(getString(R.string.app_name));

						builder.setSingleChoiceItems(items, position,
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface arg0,
											int arg1) {
										// TODO Auto-generated method stub
										arg0.dismiss();
										position = arg1;
										paymentDropDown.setText(items[arg1]);
										if (position == 4) {
											dueDateTextView
													.setVisibility(View.VISIBLE);
										}
									}
								});
						final AlertDialog alert = builder.create();

						alert.setCanceledOnTouchOutside(true);
						alert.show();
					}
				});

	}

	void saveRecord() {
		if (subject.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter subject.", 1).show();

		} else if (tax.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter tax.", 1).show();

		} else if (desposite.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter desposite.", 1).show();

		} else if (discount.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter discount.", 1).show();

		}

		else {
			Utils.ID = invoiceBean.getId();
			RequestMethod.createInvoice(this, "", subject.getText().toString()
					.trim(), desposite.getText().toString().trim(), discount
					.getText().toString().trim(),
					((EditText) findViewById(R.id.clientMssageEditText))
							.getText().toString().trim(),

					((EditText) findViewById(R.id.descriptionEditText))
							.getText().toString().trim(), paymentDropDown
							.getText().toString().trim(),
					invoiceBean.getClient_id(),
					tax.getText().toString().trim(), dueDateTextView.getText()
							.toString().trim(), issueDateTextView.getText()
							.toString().trim(), this, true);
			// RequestMethod.createProperty(mContext, "", subject.getText()
			// .toString().trim(), tax.getText().toString().trim(),
			// desposite.getText().toString().trim(), zipcode.getText()
			// .toString().trim(), discount.getText().toString()
			// .trim(), p_id, this, false);
		}
	}

	private class PickDate implements DatePickerDialog.OnDateSetListener {

		public PickDate() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			view.updateDate(year, monthOfYear, dayOfMonth);
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, monthOfYear);
			cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			calendar = cal;
			if (type == 1)
				dueDateTextView.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
			else if (type == 2)
				issueDateTextView.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);

			dialog.hide();
		}

	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(EditInvoicesActivity.this)
				.inflate(R.layout.actionbar_layout, null);
		ColorDrawable colorDrawable = new ColorDrawable(getResources()
				.getColor(R.color.blue));
		getSupportActionBar().setBackgroundDrawable(colorDrawable);
		getSupportActionBar().setCustomView(customActionView);
		getSupportActionBar().getCustomView().findViewById(R.id.setting_btn)
				.setVisibility(View.GONE);
		getSupportActionBar().getCustomView().findViewById(R.id.menu_icon)
				.setVisibility(View.GONE);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		TextView titleTextView = (TextView) findViewById(R.id.title_text);
		titleTextView.setText("Update Invoice");
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		if (taskType == RequestResponseType.REQUEST_TYPE_UPDATE_INVOICE) {
			finish();
		} else if (taskType == RequestResponseType.REQUEST_TYPE_CLIENT) {
			if (object != null) {
				ClientEntityBean bean = (ClientEntityBean) object;
				arrayList = bean.getClientList();

			}
			if (arrayList.size() > 0) {
				String items[] = new String[arrayList.size()];
				for (int i = 0; i < arrayList.size(); i++) {
					items[i] = arrayList.get(i).getFirst_name()
							+ arrayList.get(i).getLast_name();
				}
				AlertDialog.Builder builder = null;

				if (android.os.Build.VERSION.SDK_INT >= 11) {
					builder = new AlertDialog.Builder(mContext,
							AlertDialog.THEME_HOLO_LIGHT);
				} else {
					builder = new AlertDialog.Builder(mContext);
				}
				builder.setTitle(getString(R.string.app_name));

				builder.setSingleChoiceItems(items, position,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								arg0.dismiss();
								position = arg1;
								clientDropdown.setText(arrayList.get(arg1)
										.getFirst_name()
										+ " "
										+ arrayList.get(arg1).getLast_name());
								p_id = arrayList.get(arg1).getId();
							}
						});
				final AlertDialog alert = builder.create();

				alert.setCanceledOnTouchOutside(true);
				alert.show();
			} else {
				Toast.makeText(mContext, "No job available.", 1).show();
			}
		}
	}

}
