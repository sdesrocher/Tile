package css.cis3334.tile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    EditText etwidth, etlength;





    private static final int REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.textViewResult);
        etwidth = (EditText) findViewById(R.id.editTextLength);
        etlength = (EditText) findViewById(R.id.editTextLength);
    }


    public void onButtonClick( View view) {
        // Call the second activity
        Double width = Double.parseDouble( etwidth.getText().toString() );
        Double length = Double.parseDouble( etlength.getText().toString() );
        Intent secActIntent = new Intent(this, SecondActivity.class);
        secActIntent.putExtra("Width", width);
        secActIntent.putExtra("Length", length);
        //startActivity(secActIntent)     // if no result is returned
        startActivityForResult(secActIntent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("Flooring")) {
                String result = data.getExtras().getString("Flooring");
                if (result != null && result.length() > 0) {
                    tvResult.setText("Results: " + result);
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }








}
