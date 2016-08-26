package search.reel.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MenuItem doneItem;

    @Override
    @SuppressWarnings("all")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final RAMReel picker = (RAMReel) findViewById(R.id.picker);
        picker.setValues(getResources().getStringArray(R.array.capitals));
        picker.setOnItemClickListener(new RAMReel.OnItemClickListener() {
            @Override
            public void onItemClick(String text) {
                Toast toast = Toast.makeText(getApplicationContext(), text + " selected", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 200);
                toast.show();
                picker.clear();
            }
        });
        picker.setOnTextChangeListener(new RAMReel.OnTextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s) {
                if (doneItem != null) {
                    doneItem.setEnabled(TextUtils.isEmpty(s));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        doneItem = menu.findItem(R.id.action_done);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_done) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
