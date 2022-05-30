package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivityAdapter extends RecyclerView.Adapter<ListActivityViewHolder> {

    ArrayList<User> data;
    ListActivity cont;
    public ListActivityAdapter(ArrayList<User> data, ListActivity cont){
        this.data = data;
        this.cont = cont;
    }

    @NonNull
    @Override
    public ListActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        Log.d("ViewType", Integer.toString(viewType));
        if(viewType == 0){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_layout_one, null, false);
        }
        else{
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_layout_two, null, false);
        }
        return new ListActivityViewHolder(item);
    }

    @Override
    public int getItemViewType(int position){
        String name = data.get(position).name;
        if(Character.toString(name.charAt(name.length() - 1)).equals("7")){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ListActivityViewHolder holder, int position) {
        String name = data.get(position).name;
        holder.name.setText(name);
        String description = data.get(position).description;
        holder.desc.setText(description);
        Boolean follow = data.get(position).followed;

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab = new AlertDialog.Builder(cont);
                ab.setTitle("Profile").setMessage(name).setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Intent i2 = new Intent(cont, MainActivity.class);
                        //i2.putExtra("name", name);
                        //i2.putExtra("desc", description);
                        i2.putExtra("id", holder.getAdapterPosition());
                        //i2.putExtra("followStatus", follow);
                        cont.startActivity(i2);
                    }
                });
                ab.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                ab.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
