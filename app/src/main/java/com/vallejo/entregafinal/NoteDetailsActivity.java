package com.vallejo.entregafinal;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NoteDetailsActivity extends AppCompatActivity{

    private TextView titleTextView, contentTextView, timestampTextView;
    private DatabaseHelper db;
    private long noteId = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        titleTextView = findViewById(R.id.note_detail_title);
        contentTextView = findViewById(R.id.note_detail_content);
        timestampTextView = findViewById(R.id.note_detail_timestamp);

        db = new DatabaseHelper(this);

        if (getIntent().hasExtra("note_id")) {
            noteId = getIntent().getLongExtra("note_id", -1);
            loadNoteDetails(noteId);
        }
    }

    @SuppressLint("Range")
    private void loadNoteDetails(long noteId) {
        Cursor cursor = db.getNoteById(noteId);
        if (cursor.moveToFirst()) {
            titleTextView.setText(cursor.getString(cursor.getColumnIndex("title")));
            contentTextView.setText(cursor.getString(cursor.getColumnIndex("content")));
            timestampTextView.setText(cursor.getString(cursor.getColumnIndex("timestamp")));
        }
    }
}
