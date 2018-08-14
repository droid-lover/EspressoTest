package com.jarvis.espressotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {

    EditText etUserInput;
    Button btnSaveNote;
    ListView listViewNotes;

    ArrayList<String> notesList = new ArrayList<>();
    ArrayAdapter<String> notesAdapter;
    String noteValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        findViews();
    }

    private void findViews() {

        etUserInput = findViewById(R.id.et_user_input);
        btnSaveNote = findViewById(R.id.btn_save_note);
        listViewNotes = findViewById(R.id.list_view_notes);

        notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        listViewNotes.setAdapter(notesAdapter);

        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etUserInput.getText().toString())) {
                    return;
                } else {
                    noteValue = etUserInput.getText().toString();
                    saveNote(noteValue);
                }
            }
        });
    }


    private void saveNote(String noteValue) {
        notesList.add(noteValue);
        notesAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Note Saved" + notesList.size(), Toast.LENGTH_SHORT).show();
    }
}
