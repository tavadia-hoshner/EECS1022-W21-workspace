package eecs1022.lab8.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import eecs1022.lab8.tictactoe.model.Game;

public class MainActivity extends AppCompatActivity {

    Game g;
    String board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentsOfTextView(R.id.status,"No Game Has Been Started");

        /* Hint: How do you display the initial status to the output textview
         * when the app is first launched?
         */
    }

    /* this mutator sets the output label */
    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    /* this accessor retrieves input entered on the text view  */
    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    private void updateStatus(){
        String r ="Game Board:\n";
        char[][] b = g.getBoard();
        r=r+b[0][0]+" "+b[0][1]+" "+b[0][2]+"\n"+b[1][0]+" "+b[1][1]+" "+b[1][2]+"\n"+b[2][0]+" "+b[2][1]+" "+b[2][2]+"\nCurrent Game Status:\n"+g.getStatus();
        setContentsOfTextView(R.id.status,r);
    }

    /* this accessor retrieves input chosen from some spinner (drop-down menu) */
    private String getItemSelected(int id) {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    public void onStartResetartonClick(View view){
        String p1=getInputOfTextField(R.id.p1);
        String p2=getInputOfTextField(R.id.p2);
        g = new Game(p1,p2);
        String x = getItemSelected(R.id.firstp);
        if (x.equals("Player X"))
            g.setWhoPlaysFirst('x');
        else
            g.setWhoPlaysFirst('o');
        updateStatus();
    }

    public void onMoveClicked(View view){
        int row = Integer.parseInt(getInputOfTextField(R.id.row));
        int col = Integer.parseInt(getInputOfTextField(R.id.col));
        g.move(row,col);
        updateStatus();
    }
    /* Hints on controller methods:
     *
     * Declare two controller methods, each of which declared with a parameter with type View (see Week 9 Tutorials).
     *  - One method (say cm1) should be attached to the "START/RESTART" button,
     *      whereas the other method (say cm2) should be attached to the "MOVE" button.
     *
     *  - Controller method cm1 should:
     *    + Retrieve the names of the two players from the corresponding textfields.
     *    + Retrieve the player (who will play first) from the spinner.
     *    + Then, re-create the shared game object and invoke the relevant method(s).
     *    + Finally, display the expected output of the game (i.e., board and status) to the output textview.
     *
     * - Controller method cm2 should:
     *    + Retrieve the row and column numbers (as strings) from the corresponding textfields.
     *      You may need to convert the retrieved text, e.g., "1" to an integer value using Double.parseInt.
     *    + Then, invoke the relevant method(s) on the shared game object.
     *    + Finally, display the expected output of the game (i.e., board and status) to the ouptut textview.
     */
}