import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class WorstFitDecreasing

{
    public static void main(String[] args) throws FileNotFoundException
    {

            Scanner scanner = new Scanner(new File("input20.txt"));
            ArrayList<Integer> list = new ArrayList<>();
            while (scanner.hasNext())
            {
                list.add(scanner.nextInt());
            }
            scanner.close();
  
            Collections.sort(list, Collections.reverseOrder());
            

            double totalSize = 0;
            Queue<Disk> pq = new PriorityQueue<>();
            int ID = 0;


            while (!list.isEmpty()) {
                int curr = list.get(0);
                totalSize += curr;
                boolean added = false;
                Disk x = null;
                for (Disk disk : pq) {
                    if (disk.spaceLeft >= curr) {
                        if (x == null || disk.spaceLeft > x.spaceLeft) {
                            x = disk;
                        }
                    }
                }
                if (x != null) {
                    x.add(curr);
                    added = true;
                }
                if (!added) {
                    Disk newDisk = new Disk(ID++);
                    newDisk.add(curr);
                    pq.add(newDisk);
                    
                }
                list.remove(0);
            }
        
            System.out.println("Total size: " + (totalSize / 1000000) + " GB");
            System.out.println("Disks Required: " + ID);
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