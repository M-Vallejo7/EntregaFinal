package com.vallejo.entregafinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditNoteActivity extends AppCompatActivity{

    private EditText titleEditText, contentEditText;
    private Button saveButton;
    private DatabaseHelper db;
    private long noteId = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_note);

        titleEditText = findViewById(R.id.edit_text_title);
        contentEditText = findViewById(R.id.edit_text_content);
        saveButton = findViewById(R.id.button_save);
        db = new DatabaseHelper(this);

        if (getIntent().hasExtra("note_id")) {
            noteId = getIntent().getLongExtra("note_id", -1);
            loadNoteDetails(noteId);
        }

        saveButton.setOnClickListener(v -> saveNote());
    }

    @SuppressLint("Range")
    private void loadNoteDetails(long noteId) {
        Cursor cursor = db.getNoteById(noteId);
        if (cursor.moveToFirst()) {
            titleEditText.setText(cursor.getString(cursor.getColumnIndex("title")));
            contentEditText.setText(cursor.getString(cursor.getColumnIndex("content")));
        }
    }

    private void saveNote() {
        String title = titleEditText.getText().toString().trim();
        String content = contentEditText.getText().toString().trim();

        if (TextUtils.isEmpty(title)) {
            titleEditText.setError("Se requiere un título");
            return;
        }

        if (noteId == -1) {
            // Insert new note
            long id = db.insertNote(title, content);
            if (id > 0) {
                Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error al guardar nota", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Update existing note
            int rowsAffected = db.updateNote(noteId, title, content);
            if (rowsAffected > 0) {
                Toast.makeText(this, "Nota actualizada", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error al actualizar nota", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
