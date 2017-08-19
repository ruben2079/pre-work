package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static android.R.attr.data;
import static com.codepath.simpletodo.R.id.editText;
import static com.codepath.simpletodo.R.id.etNewItem;
import static com.codepath.simpletodo.R.id.lvItems;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String getItem = getIntent().getStringExtra("getItem");
        EditText etEditItem = (EditText) findViewById(editText);
        etEditItem.setText(getItem);
        etEditItem.setSelection(etEditItem.getText().length());
    }
    public void onSaveItem(View view){

        EditText editText = (EditText) findViewById(R.id.editText);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("setItem", editText.getText().toString());
        // Activity finished ok, return the data
        setResult(MainActivity.RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
