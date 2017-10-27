package com.flymetothemoon.siaqueue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.flymetothemoon.siaqueue.R;
import com.flymetothemoon.siaqueue.dialogs.ConfirmQueueDialog;
import com.flymetothemoon.siaqueue.dialogs.InputPNRDialog;
import com.flymetothemoon.siaqueue.model.RequestType;

public class CategoriesActivity extends AppCompatActivity {

    private static final int REQUEST_PNR = 2;
    private static final int REQUEST_CONFIRM = 3;
    private ListView mainRequestListView;
    private ListView subRequestListView;
    private Button continueButton;
    private SparseBooleanArray[] subRequestChoices = new SparseBooleanArray[7];
    private SparseBooleanArray mainRequestChoices;
    private int currentRequestPosition;
    private boolean isInputedPNR;
    private boolean isForgotPNR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        initToolbar();
        initViews();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.categories_activity_toolbar);
        this.setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void initViews() {
        mainRequestListView = findViewById(R.id.main_request_list);
        subRequestListView = findViewById(R.id.sub_request_list);
        continueButton = findViewById(R.id.continue_button);

        String[] requestList = getResources().getStringArray(R.array.request_types);
        final ArrayAdapter<String> mainRequestAdapter = new ArrayAdapter<>(this, R.layout.row_main_request_list, requestList);
        mainRequestListView.setAdapter(mainRequestAdapter);
        mainRequestListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        subRequestListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        mainRequestListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray sp = mainRequestListView.getCheckedItemPositions();

                if (!sp.get(position)) {
                    subRequestListView.setVisibility(View.INVISIBLE);
                    return;
                }

                currentRequestPosition = position;
                mainRequestListView.setSelection(position);

                subRequestListView.setVisibility(View.VISIBLE);
                String[] subList = RequestType.values()[position].getList(CategoriesActivity.this);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CategoriesActivity.this,
                        R.layout.row_sub_request_list,
                        subList);

                subRequestListView.setAdapter(adapter);

                if (subRequestChoices[currentRequestPosition] != null) {
                    for (int i = 0; i < subList.length; i++) {
                        if (subRequestChoices[currentRequestPosition].get(i)) {
                            subRequestListView.setItemChecked(i, true);
                        }
                    }
                }

            }
        });

        subRequestListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray sp = subRequestListView.getCheckedItemPositions().clone();
                subRequestChoices[currentRequestPosition] = sp;

                if (isForgotPNR || isInputedPNR) return;

                boolean[] pnrRequiredList = RequestType.values()[currentRequestPosition].getPNRrequiredList();
                if (pnrRequiredList[position]) {
                    Intent intent = new Intent(CategoriesActivity.this, InputPNRDialog.class);
                    startActivityForResult(intent, REQUEST_PNR);
                }
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(CategoriesActivity.this, ConfirmQueueDialog.class), REQUEST_CONFIRM);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_PNR) {
            if (resultCode == RESULT_OK) {
                isInputedPNR = true;
            } else {
                isForgotPNR = true;
            }
        } else if (requestCode == REQUEST_CONFIRM && resultCode == RESULT_OK) {
            startActivity(new Intent(CategoriesActivity.this, MainActivity.class));
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
