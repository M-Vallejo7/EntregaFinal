package com.vallejo.entregafinal;

public class Note {
        private long id;
        private String title;
        private String content;
        private String timestamp;

        public Note(long id, String title, String content, String timestamp) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.timestamp = timestamp;
        }

        public long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getTimestamp() {
            return timestamp;
        }
}
