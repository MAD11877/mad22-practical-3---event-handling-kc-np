package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    User user = new User("Tom", "description", 1, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize text in follow button
        initFollowBtnTxt(user);

        // get value from ListActivity.java after clicking "view"
        Intent receiveRand = getIntent();
        String value = receiveRand.getStringExtra("rand");

        TextView txtHeader = findViewById(R.id.textViewHeader);
        String headerText = String.format("%s %s", user.name, value);
        txtHeader.setText(headerText);

        // show toast message, update user followed variable, change button text - follow button
        Button btnFollow = findViewById(R.id.buttonFollow);

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnFollow.getText() == "Follow"){
                    btnFollow.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
                else {
                    btnFollow.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                user.followed = !user.followed;
            }
        });

        // launch MessageGroup - message button
        Button btnMessage = findViewById(R.id.buttonMessage);

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMessageGroup = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(toMessageGroup);
            }
        });


    }

    public void initFollowBtnTxt(User user) {
        Button followBtn = findViewById(R.id.buttonFollow);
        if (!user.followed){
            followBtn.setText("Follow");
        }
        else {
            followBtn.setText("Unfollow");
        }
    }
}