import java.util.Scanner;
public class Calculator2
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects=scanner.nextInt();
        if (numSubjects<=0)
        {
            System.out.println("Number of subjects must be greater than zero.");
            return;
        }
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        for (int i=0;i<numSubjects;i++)
        {
            System.out.print("Enter marks for subject "+(i+1)+" (out of 100): ");
            marks[i]=scanner.nextInt();
            if (marks[i]<0||marks[i]>100)
            {
                System.out.println("Marks should be between 0 and 100. Please enter again.");
                i--; 
                continue;
            }
            totalMarks += marks[i];
        }
        double averagePercentage = (double) totalMarks / numSubjects;
        char grade = calculateGrade(averagePercentage);
        System.out.println("Total Marks: "+totalMarks);
        System.out.println("Average Percentage: "+averagePercentage+ "%");
        System.out.println("Grade: "+grade);
        scanner.close();
    }
    private static char calculateGrade(double averagePercentage) 
    {
        if(averagePercentage>=90)
        {
            return 'A';
        }
        else if (averagePercentage>=80)
        {
            return 'B';
        }
        else if (averagePercentage>=70)
        {
            return 'C';
        }
        else if (averagePercentage>=60)
        {
            return 'D';
        }
        else
        {
            return 'F';
        }
    }
}
/*
 Output:-

 Enter the number of subjects: 5
Enter marks for subject 1 (out of 100): 75
Enter marks for subject 2 (out of 100): 75
Enter marks for subject 3 (out of 100): 70
Enter marks for subject 4 (out of 100): 785
Marks should be between 0 and 100. Please enter again.
Enter marks for subject 4 (out of 100): 85 
Enter marks for subject 5 (out of 100): 80
Total Marks: 385
Average Percentage: 77.0%
Grade: C
PS D:\codesoft> 

 */