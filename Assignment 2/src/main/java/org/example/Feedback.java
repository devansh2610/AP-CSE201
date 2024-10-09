package org.example;

import java.util.ArrayList;

public interface Feedback {
    public void setFeedback(String feedback);
    public void associatefeedback();
    public void showfeedback(Visitor v);
    public void thankfeedback();
}
