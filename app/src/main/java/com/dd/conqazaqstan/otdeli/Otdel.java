package com.dd.conqazaqstan.otdeli;

/**
 * Created by dds86 on 17-Nov-17.
 */

public class Otdel {
    String textView1, textView2, textView3,textView4, textView5, textView6;

    public String getTextView2() {return textView2;}
    public String getTextView3() {return textView3;}
    public String getTextView4() {return textView4;}
    public String getTextView5() {return textView5;}

    public void setTextView2(String textView2) {this.textView2 = textView2;}
    public void setTextView3(String textView3) {this.textView3 = textView3;}
    public void setTextView4(String textView4) {this.textView4 = textView4;}
    public void setTextView5(String textView5) {this.textView5 = textView5;}

    public Otdel(String textView2, String textView3, String textView4, String textView5) {
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.textView4 = textView4;
        this.textView5 = textView5;
    }
}
