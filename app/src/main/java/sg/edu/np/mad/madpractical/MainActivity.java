package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*User u = new User("John", "Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 1, false);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        Intent i = getIntent();
        //String name = i.getStringExtra("name");
        //String desc = i.getStringExtra("desc");
        Integer id = i.getIntExtra("id", -1);
        //Boolean followStat = i.getBooleanExtra("followStatus", false);
        //User u = new User(name, desc, id, followStat);
        User u = db.getUsers().get(id);
        TextView n = findViewById(R.id.username);
        n.setText(u.name);
        TextView des = findViewById(R.id.description);
        des.setText(u.description);
        /*
        Intent i = getIntent();
        int randomInt = i.getIntExtra("randomInt", 1739039545);
        TextView name = findViewById(R.id.username);
        String displayName = u.name + " " + randomInt;
        name.setText(displayName);

        TextView des = findViewById(R.id.description);
        des.setText(u.description);
        */

        followStatus(u);
        Button follow = findViewById(R.id.followButton);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(u.followed){
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                    u.followed = false;
                }else{
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                    u.followed = true;
                }
                followStatus(u);
                db.updateUser(u);
            }
        });

        Button message = findViewById(R.id.messageButton);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(i2);
            }
        });

    }

    public void followStatus(User u){
        Button follow = findViewById(R.id.followButton);
        if(u.followed){
            follow.setText("Unfollow");
        } else {
            follow.setText("Follow");
        }
    }
}