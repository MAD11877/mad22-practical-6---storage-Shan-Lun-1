package sg.edu.np.mad.madpractical;

public class User {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public int id;

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
    }

    public boolean followed;

    public boolean getFollowed(){
        return followed;
    }
    public void setFollowed(boolean newFollowed){
        followed = newFollowed;
    }

    public User(){

    }

    public User(String newName, String newDescription, int newId, boolean newFollowed){
        this.name = newName;
        this.description = newDescription;
        this.id = newId;
        this.followed = newFollowed;
    }
}
