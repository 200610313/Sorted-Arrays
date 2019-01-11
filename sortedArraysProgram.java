//Angelu Ferdinand Garcia
//BSCS1
//1/12/19
//Sir Jesse Lagrosas
//This program enables user to make a list of numbers; insert, delete, search, and display values

import java.util.Scanner;
public class arrayMenu
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of values to insert: ");

        int size = input.nextInt();
        arrays array = new arrays(size);

        int choice;
        do{
            array.printOptions();
            choice = input.nextInt();

            switch(choice)
            {
                case 0:
                    return;
                case 1:
                    if (!array.isArrayFull())//(ctr<size)
                    {
                        System.out.print("Enter value to insert: ");
                        int el = input.nextInt();
                        array.insert(el);
                        break;
                    }
                    else
                    {
                        System.out.print("Error: exceeded number of insertions, delete a value first.");
                        System.out.println(" ");
                        break;
                    }

                case 2:
                    System.out.print("Enter value to delete: ");
                    int el=input.nextInt();
                    array.delete(el);
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int val = input.nextInt();

                    if (array.isFound(val) == true)
                    {
                        System.out.println(val+" is in the list.");
                        break;
                    }
                    else
                    {
                        System.out.print(val+" is not in the list.");
                        break;
                    }

                case 4:
                    System.out.print("Numbers in the list : ");
                    array.printList();
                    break;
            }
        }while(true);
    }
}

public class arrays
{
    private int[] array;
    private int size;
    private int ctr;
    private int delLoc;
    private boolean userHasDeleted;
    private boolean isDeleted;

    public arrays(int x)
    {
        size = x;
        array = new int[size];
        ctr = 0;
        delLoc = size-1;
        userHasDeleted = false;
        isDeleted = false;
    }

    public void printOptions()
    {
        System.out.println("");
        System.out.println("0 - Exit");
        System.out.println("1 - Insert");
        System.out.println("2 - Delete");
        System.out.println("3 - Search");
        System.out.println("4 - Display");
        System.out.print("Enter choice: ");
        return;
    }

    public boolean isArrayFull()
    {
        if (ctr<size)
            return false;
        else
            return true;
    }

    public void insert(int el)
    {
        array[ctr] = el;
        if (ctr == 0) //if first insertion, don't sort.
        {
            ctr++;
            return;
        }

        else {
            for (int j = 0; j < ctr; j++)//checking if the input is in the right position
            {
                if (array[ctr] < array[j])//j=index of array where the digit should be
                {
                    int temp = array[ctr];
                    for (int k = ctr; k > j; k--) {
                        array[k] = array[k - 1];//copy the element beside it
                    }
                    array[j] = temp;//storing the element to its right place
                }
            }
            ctr++;
            if (userHasDeleted)
            {
                delLoc++;
                return;
            }
            else
                return;

        }
    }

    public void delete(int el)
    {
        for (int c = 0; c<size; c++)
        {
            if (array[c]==el)
            {
                for (int d=c; d<size-1; d++)
                {
                    array[d]=array[d+1];
                }
                isDeleted = true;
            }
        }
        if (isDeleted == true)
        {
            array[delLoc]=0;
            userHasDeleted=true;
            delLoc--;
            ctr--;
            return;
        }
        else
            return;
    }

    public boolean isFound(int el)
    {
        for (int l = 0; l<size;l++)
        {
            if (array[l]==el)
            {
                System.out.println(el+" is in the list.");
                return true;
            }
        }
        return false;
    }

    public void printList()
    {
        for (int a =0; a<size; a++)
        {
            if(array[a]>0)
            {
                System.out.print(array[a]+" ");
            }
        }
        System.out.println("");
    }
}
