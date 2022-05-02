package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView imgIcon = findViewById(R.id.imageViewMiddleIcon);

        imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent toMain = new Intent(ListActivity.this, MainActivity.class);
                        Random rand = new Random();
                        long randNo = (long)(rand.nextDouble() * 10000000000L);
                        String value = Long.toString(randNo);
                        toMain.putExtra("rand", value);
                        startActivity(toMain);
                    }
                });
                builder.show();
            }
        });
    }
}