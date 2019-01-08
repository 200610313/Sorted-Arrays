//Angelu Ferdinand Garcia
//BSCS1
//1/9/2019
//Sir Jesse Lagrosas
//This program enables user to make a list of numbers; insert, delete, search, and display values


import java.util.Scanner;
public class sortedArraysProgram
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of values to insert: ");
        int size = input.nextInt();
        int[] array = new int[size];
        int choice;
        //int ctr=0;
        int delLoc=size-1;
        boolean userHasDeleted = false;

        manipulateArray manipulator = new manipulateArray(0);//create obj

        do{
            manipulator.printMenu();
            choice = input.nextInt();

            switch(choice)
            {
                case 0:
                    return;
                case 1:
                    if (manipulator.getArrayIndex()<size)
                    {
                        System.out.print("Enter value to insert: ");

                        if (manipulator.getArrayIndex()==0)//if first insert, do not sort yet
                        {
                            int el = input.nextInt();
                            array=manipulator.addFirstElement(array,el);
                            break;
                        }
                        else
                        {
                            int el = input.nextInt();
                            array=manipulator.addElement(array,el);

                            if (userHasDeleted)
                            {
                                delLoc++;
                            }
                            break;
                        }
                    }
                    else
                    {
                        System.out.print("Error: exceeded number of insertions, delete a value first.");
                        break;
                    }

                case 2:
                    System.out.print("Enter value to delete: ");
                    int el = input.nextInt();

                    array=manipulator.delElement(array,el);


                    if (manipulator.isSuccessDelete())
                    {
                        array[delLoc]=0;
                        userHasDeleted=true;
                        delLoc--;
                        break;
                    }
                    else
                        System.out.println(el+" is not in the list.");
                        break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int ele = input.nextInt();
                    manipulator.elSearch(array,ele);
                    break;
                case 4:
                    System.out.print("Numbers in the list : ");
                    manipulator.printArray(array);
                    break;
            }
        }while(true);
    }
}

public class manipulateArray
{
    private int arrayIndex;//fields
    private boolean successDelete;

    public manipulateArray(int val)//initializing array index
                                    // constructor
                                    //setter
    {
       arrayIndex=val;
    }
    public int getArrayIndex()
    {
        return arrayIndex;
    }
    //operations
    public void printMenu()
    {
        System.out.println("");
        System.out.println("0 - Exit");
        System.out.println("1 - Insert");
        System.out.println("2 - Delete");
        System.out.println("3 - Search");
        System.out.println("4 - Display");
        System.out.print("Enter choice: ");
    }

    public int[] addFirstElement(int[] arr, int el)//no need to sort
    {
        arr[arrayIndex]=el;
        arrayIndex++;
        return arr;
    }

    public int[] addElement(int[] arr, int el)
    {
        arr[arrayIndex]=el;

        for (int j = 0; j<arrayIndex; j++)
        {
            if (arr[arrayIndex]<arr[j])
            {
                int temp = arr[arrayIndex];
                for (int k = arrayIndex; k>j; k--)
                {
                    arr[k]=arr[k-1];
                }
                arr[j]=temp;//store
            }
        }
        arrayIndex++;
        return arr;
    }

    public int[] delElement(int[] arr, int el)
    {
        int delVal=el;
        successDelete=false;//reset
        for (int c = 0; c<arr.length;c++)
        {
            if (arr[c]==delVal)
            {
                successDelete=true;
                for (int d = c; d<arr.length-1;d++)
                {
                    arr[d]=arr[d+1];
                }
            }
        }
        arrayIndex--;
        return arr;
    }

    public boolean isSuccessDelete()
    {
        return successDelete;
    }

    public void elSearch(int[] arr, int el)
    {
        for (int l = 0; l<arr.length;l++)
        {
            if (arr[l]==el)
            {
                System.out.println(el+" is in the list.");
                return;
            }
        }
        System.out.print(el+" is not in the list.");
        System.out.println(" ");
        return;
    }

    public void printArray(int[] arr)
    {
        for (int a =0; a<arr.length; a++)
        {
            if(arr[a]>0)
            {
                System.out.print(arr[a]+" ");
            }
        }
        System.out.println("");
        return;
    }
}

