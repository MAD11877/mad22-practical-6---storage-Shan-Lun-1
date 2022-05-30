package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListActivityViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView desc;
    ImageView image;

    public ListActivityViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.username);
        desc = itemView.findViewById(R.id.description);
        image = itemView.findViewById(R.id.profilePic);
    }
}
