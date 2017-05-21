package com.example.zubai.myapplication;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
double gpa;
double credits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });
                        credits=0;
    }

public double calcuteGpa(String g,String c)
{

    Double cr=Double.parseDouble(c);
 if(g.equals("A"))
{
   credits= credits+cr;
    return  4.00 * cr;

}else if(g.equals("A-"))
 {
credits=credits+cr;
     return 3.67 * cr;

 }
 else if(g.equals("B+"))
 {
     credits=credits+cr;
     return 3.33 * cr;
 }
 else if(g.equals("B"))
 {
     credits=credits+cr;
     return 3.00 * cr;
 }else if(g.equals("B-"))
 {

     return 2.67 * cr;
 }else if(g.equals("C+"))
 {
     credits=credits+cr;
     return 2.33 * cr;
 }else if(g.equals("C"))
 {
     credits=credits+cr;
     return 2.00 * cr;
 }else if(g.equals("C-"))
 {
     credits=credits+cr;
     return 1.67 * cr;
 }
 else if(g.equals("D+"))
 {
     credits=credits+cr;
     return 1.33 * cr;
 }
 else if(g.equals("D"))
 {
     credits=credits+cr;
     return 1.00 * cr;
 }else if(g.equals("F"))
 {
     credits=credits+cr;
     return 0 * cr;
 }
    return 0;
}


     TextToSpeech t1;

public void speak(View v)
{

    Spinner s1=(Spinner) findViewById(R.id.s1);
String grade1= s1.getSelectedItem().toString();
    Spinner s2=(Spinner) findViewById(R.id.s2);
    String grade2= s2.getSelectedItem().toString();
    Spinner s3=(Spinner) findViewById(R.id.s3);
    String grade3= s3.getSelectedItem().toString();
    Spinner s4=(Spinner) findViewById(R.id.s4);
    String grade4= s4.getSelectedItem().toString();
    Spinner s5=(Spinner) findViewById(R.id.s5);
    String grade5= s5.getSelectedItem().toString();
    Spinner s6=(Spinner) findViewById(R.id.s6);
    String grade6= s6.getSelectedItem().toString();
Spinner c1=(Spinner) findViewById(R.id.c1);
String cr1=c1.getSelectedItem().toString();
    Spinner c2=(Spinner) findViewById(R.id.c2);
    String cr2=c2.getSelectedItem().toString();
    Spinner c3=(Spinner) findViewById(R.id.c3);
    String cr3=c3.getSelectedItem().toString();
    Spinner c4=(Spinner) findViewById(R.id.c4);
    String cr4=c4.getSelectedItem().toString();
    Spinner c5=(Spinner) findViewById(R.id.c5);
    String cr5=c5.getSelectedItem().toString();
    Spinner c6=(Spinner) findViewById(R.id.c6);
    String cr6=c6.getSelectedItem().toString();
gpa=(calcuteGpa(grade1,cr1)+calcuteGpa(grade2,cr2)+calcuteGpa(grade3,cr3)+calcuteGpa(grade4,cr4)+calcuteGpa(grade5,cr5)+calcuteGpa(grade6,cr6))/credits;
credits=0;
    TextView e1=(TextView) findViewById(R.id.textgpa);
    String val=gpa+"";
    if(val.length()>5)
    val=val.substring(0,5);
e1.setText(val);

if(gpa>3.5)
t1.speak("Excellect you deserve Credit",TextToSpeech.QUEUE_ADD,null);
else if(gpa>=3.0&&gpa<=3.5)
    t1.speak("Very Good Keep it up",TextToSpeech.QUEUE_ADD,null);
   else if(gpa>=2.5&&gpa<3.0)
        t1.speak("well Done",TextToSpeech.QUEUE_ADD,null);
   else if(gpa>=2.0&&gpa<2.5)
        t1.speak("Good but you need to work hard",TextToSpeech.QUEUE_ADD,null);
   else if(gpa>=1.0&&gpa<2.0)
    t1.speak("poor work hard",TextToSpeech.QUEUE_ADD,null);
    else{
    t1.speak("Its not working u need to change Your field",TextToSpeech.QUEUE_ADD,null);

}
}


}
