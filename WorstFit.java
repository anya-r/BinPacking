import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class WorstFit
{
    public static void main(String[] args) throws FileNotFoundException{

        double totalSize = 0;
        Queue<Disk> pq = new PriorityQueue<>();
        int ID = 0;
        Disk disk = new Disk(ID);
        pq.offer(disk);

        Scanner scanner = new Scanner(new File("input20.txt"));
        while (scanner.hasNext())
        {
            
            int currFile = scanner.nextInt();
            totalSize += currFile;

            Disk d = pq.peek();
            if (currFile <= disk.spaceLeft || d == null)
                disk.add(currFile);
            
            else
            {
                ID++;
                disk = new Disk(ID);
                disk.add(currFile);
                pq.offer(disk);

            }
        }

        scanner.close();
    
        //print
        System.out.println("Total size: " + (totalSize / 1000000) + " GB");
        System.out.println("Disks Required: " + (ID + 1));
        ArrayList<Disk> array = new ArrayList<>();
        
        while (!pq.isEmpty())
        {
           array.add(pq.poll());
        }
        Collections.sort(array);
        while (!array.isEmpty())
        {
            Disk temp = array.remove(array.size() - 1);
            System.out.println("    " + temp.ID + " " + temp.spaceLeft + ": " + temp.nums);
        }
    }
}


    

