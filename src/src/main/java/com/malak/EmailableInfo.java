package com.malak;

public class EmailableInfo implements Emailable {
    private String title;
    private String fileType;

    public EmailableInfo(Book book) {
        title = book.getTitle();
        fileType = book.getFileType();
    }

    public String getTitle() {
        return title;
    }

    public String getFileType() {
        return fileType;
    }
}
