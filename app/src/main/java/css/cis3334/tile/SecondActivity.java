package css.cis3334.tile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by sdesrocher on 3/6/2017.
 */

public class SecondActivity extends AppCompatActivity {

    TextView tvResult;
    Double width, length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult = (TextView) findViewById(R.id.textViewWL);

        Bundle extras = getIntent().getExtras();
        width = extras.getDouble("Width");
        length = extras.getDouble("Length");
        tvResult.setText("Width : " + width + " Length : " + length + "Total: " + width * length);

    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("Width", width);
        intent.putExtra("Length", length);
        setResult(RESULT_OK, intent);
        super.finish();
    }





}
