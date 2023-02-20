import java.util.ArrayList;

public class Disk implements Comparable<Disk>
{
    double spaceLeft;
    int ID;
    ArrayList<Integer> nums = new ArrayList<>();
    
    public Disk(int id)
    {
        ID = id;
        spaceLeft = 1000000;

    }
    public void add(int x)
    {
        spaceLeft -= x;
        nums.add(x);
    }
    
    public int compareTo(Disk other) 
    {
        if(spaceLeft > other.spaceLeft || other == null)
            return 1;
        else if (spaceLeft < other.spaceLeft)
            return -1;
        return 0;
        
    }
}
