package sg.rp.edu.rp.c346.id22038845.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;

    String wordClicked="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.textViewTranslatedText);
        tv2=findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tv1);
        registerForContextMenu(tv2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == tv1){
            wordClicked = "hello";
        }else if(v ==tv2){
            wordClicked = "bye";
        }
        menu.setHeaderTitle(getResources().getString(R.string.choice));
        getMenuInflater().inflate(R.menu.menu_main, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();

        if (wordClicked.equalsIgnoreCase("hello")) {
            if (id==R.id.EnglishSelection) {
                //code for action
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tv1.setText(getResources().getString(R.string.hello));

                return true; //menu item successfully handled
            } else if (id == R.id.italianSelection) {
                //code for action
                //Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tv1.setText(getResources().getString(R.string.helloI));

                return true;  //menu item successfully handled
            }


        }else if(wordClicked.equalsIgnoreCase("bye")){
            if (id==R.id.EnglishSelection) {
                tv2.setText(getResources().getString(R.string.bye));

                return true; //menu item successfully handled
            } else if (id==R.id.italianSelection) {
                tv2.setText(getResources().getString(R.string.byeI));

                return true;  //menu item successfully handled
            }
        }
                return super.onContextItemSelected(item);

    }

}