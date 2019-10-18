package com.example.palacelayouttesting2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Andres Giesemann, Fredrik Olsson, Meredith Marcinko, Maximilian Puglielli
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{


    private CardSurfaceView tableView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableView = findViewById(R.id.TableSurfaceView);

        PalaceGameState pgs = new PalaceGameState(getResources());
        tableView.setPgs(pgs);

        Button tester = findViewById(R.id.TestButton);
        tester.setOnClickListener(this);


    }//onCreate


    /**
     * This method listens to a ClickEvent and then
     * calls all the Use case methods in the PalaceGameState class
     *
     * @param view
     */
    @Override
    public void onClick(View view)
    {
        tableView.invalidate();

    }//onClick
}//class MainActivity