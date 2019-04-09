package net.hafiznaufalr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Flowchart extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowchart);

        final TextView tv = (TextView) findViewById(R.id.flowchart);
        Spanned html = Html.fromHtml(
                "<a href='https://docs.google.com/document/d/1yY7Zcu26JhFZFz-9XUJksbqinKkCi1tZZiCz5Ggh6LM/edit?usp=sharing'>Flowchart</a>");

                /*
                    setMovementMethod(MovementMethod movement)
                        Sets the movement method (arrow key handler) to be used for this TextView.

                    LinkMovementMethod
                        A movement method that traverses links in the text buffer and
                        scrolls if necessary. Supports clicking on links with
                        DPad Center or Enter.
                 */
        tv.setMovementMethod(LinkMovementMethod.getInstance());

        // Set TextView text from html
        tv.setText(html);
    }
    }

