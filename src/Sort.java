import java.util.*;

public class Sort {

    //버블정렬
    static void Bubble(int[] A) {
        int n = A.length;
        for (int i = n - 1; i > 0; i--)
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    int t = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = t;
                }
            }
    }

    //선택정렬
    static void Selection(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[min])
                    min = j;
            }
            int t = A[i];
            A[i] = A[min];
            A[min] = t;
        }
    }

    //삽입정렬
    static void Insertion(int[] A) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            int C = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > C) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = C;
        }
    }

    //쉘정렬
    static void Shell(int[] A) {
        int n = A.length;
        for (int gap = n / 2; gap > 0; gap = gap / 2) {
            if (gap % 2 == 0) gap++;
            for (int i = 0; i < gap; i++)
                for (int j = i + gap; j < n; j = j + gap) {
                    int C = A[j];
                    while (j >= gap && A[j - gap] > C) {
                        A[j] = A[j-gap];
                        j=j-gap;
                    }
                    A[j]=C;
                }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Random rd = new Random();

        int[] A = new int[n];

        //랜덤
        for (int i = 0; i < n; i++)
            A[i] = rd.nextInt(n*10);

        //내림차순
        int k = n;
        for(int i = 0; i<n; i++)
            A[i]=k--;

        //앞부분 절반 정렬, 뒷부분 절반 랜덤
        for(int i = 0; i<n/2; i++)
            A[i]=i;
        for(int i = n/2+1; i<n; i++)
            A[i] = rd.nextInt(n);

        Bubble(A);
        Selection(A);
        Insertion(A);
        Shell(A);
    }
}
