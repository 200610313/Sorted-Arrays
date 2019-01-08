//Angelu Ferdinand Garcia
//BSCS1
//12/9/18
//Sir Jesse Lagrosas
//This program enables user to make a list of numbers; insert, delete, search, and display values


//N O T E : Sir, I'm not sure if I've done as expected.
//(I assumed that the user shall define the number of insertions to be made).
//Please let me know......



import java.util.Scanner;
public class sortedArraysProgram
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of values to insert: ");
        int size = input.nextInt();
        int[] array = new int[size];
        int choice;
        int ctr=0;
        int delLoc=size-1;
        boolean userHasDeleted = false;

        do{
            System.out.println("");
            System.out.println("0 - Exit");
            System.out.println("1 - Insert");
            System.out.println("2 - Delete");
            System.out.println("3 - Search");
            System.out.println("4 - Display");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch(choice)
            {
                case 0:
                    return;
                case 1:
                    if (ctr<size)
                    {
                        System.out.print("Enter value to insert: ");
                        if (ctr==0)
                        {
                            array[ctr]=input.nextInt();
                            ctr++;
                            break;
                        }
                        else
                        {
                            array[ctr]=input.nextInt();
                            for (int j = 0; j < ctr; j++)//checking if the input is in the right position
                            {
                                if (array[ctr] < array[j])//j=index of array where the digit should be
                                {
                                    int temp = array[ctr];
                                    for (int k = ctr; k>j; k--)
                                    {
                                        array[k]=array[k-1];//copy the element beside it
                                    }
                                    array[j]=temp;//storing the element to its right place
                                }
                            }
                            ctr++;
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
                    int delVal=input.nextInt();
                    for (int c = 0; c<size; c++)
                    {
                        if (array[c]==delVal)
                        {
                            for (int d=c; d<size-1; d++)
                            {
                                array[d]=array[d+1];
                            }
                        }
                    }
                    array[delLoc]=0;
                    userHasDeleted=true;
                    delLoc--;
                    ctr--;

                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    int searchedNum = input.nextInt();
                    for (int l = 0; l<size;l++)
                    {
                        if (array[l]==searchedNum)
                        {
                            System.out.println(searchedNum+" is in the list.");
                            break;
                        }
                    }
                    System.out.print(searchedNum+" is not in the list.");
                    break;
                case 4:
                    System.out.print("Numbers in the list : ");
                    for (int a =0; a<size; a++)
                    {
                        if(array[a]>0)
                        {
                            System.out.print(array[a]+" ");
                        }
                    }
                    System.out.println("");
                    break;
            }
        }while(true);
    }
}


