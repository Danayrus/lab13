package com.g313.akindinova.lab13;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String link = "https://danayruss.pythonanywhere.com/";
    EditText num_Texta;
    EditText num_Textb;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num_Texta = findViewById(R.id.edit_a);
        num_Textb = findViewById(R.id.edit_b);
        res = findViewById(R.id.text_result);

    }

    public void b_act(View v)
    {
        String btn_id = ((Button)v).getText().toString().toLowerCase();
        String a = num_Texta.getText().toString();
        String b = num_Textb.getText().toString();
        HttpRequest r = new HttpRequest(this)
        {
          @Override
          public void  on_request_complete(String response)
          {
              Log.e("RESULT", response);
              res.setText(response);
          }
        };
        Toast toast_error = Toast.makeText(this, "Error: Wrong input data", Toast.LENGTH_LONG);

        switch (btn_id)
        {

            case "add":
                if (a.equals("") || b.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(link + "add/" + a + "/" + b);
                break;
            case "minus":
                if (a.equals("") || b.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(link + "sub/" + a + "/" + b);
                break;
            case "mult":
                if (a.equals("") || b.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(link + "mult/" + a + "/" + b);
                break;
            case "div":
                if (a.equals("") || b.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(link + "div/" + a + "/" + b);
                break;
            case "pow":
                if (a.equals("") || b.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(link + "pow/" + a + "/" + b);
                break;
            case "sqrt":
                if (a.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(link + "sqrt/" + a);
                break;
            case "sin":
                if (a.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(link + "sin/" + a);
                break;
            case "cos":
                if (a.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(link + "cos/" + a);
                break;
            case "tg":
                if (a.equals(""))
                {
                    toast_error.show();
                    return;
                }
                r.make_request(link + "tan/" + a);
                break;

        }


    }

}