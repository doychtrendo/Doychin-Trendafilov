package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class CommentImpl implements Comment {

    private static final int CONTENT_LEN_MIN = 3;
    private static final int CONTENT_LEN_MAX = 200;
    private static final String CONTENT_LEN_ERR = format(
            "Content must be between %d and %d characters long!",
            CONTENT_LEN_MIN,
            CONTENT_LEN_MAX);

    private String content;
    private final String author;

    public CommentImpl(String content, String author) {
        setContent(content);
        this.author = author;
    }

    @Override
    public String getContent() {
        return content;
    }

    private void setContent(String content) {
        ValidationHelpers.validateStringRange(content, CONTENT_LEN_MIN, CONTENT_LEN_MAX, CONTENT_LEN_ERR);
        this.content = content;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "----------\n" +
                getContent() + "\n" +
                "User: " + getAuthor() + "\n" +
                "----------";
    }

}