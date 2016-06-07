package com.srigans.www.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private EditText etEditItem;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        this.pos = getIntent().getIntExtra("pos", 0);
        String item = getIntent().getStringExtra("item");
        etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.append(item);
    }

    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        this.finish();
    }

    public void onEditItem(View view) {
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("item", etEditItem.getText().toString());
        data.putExtra("pos", this.pos); // ints work too
        setResult(RESULT_OK, data); // set result code and bundle data for response
        this.finish(); // closes the activity, pass data to parent
    }
}
