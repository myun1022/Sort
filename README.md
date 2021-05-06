# sort

버블 정렬, 선택 정렬, 삽입 정렬, 쉘 정렬



## Bubble Sort

이웃하는 숫자를 비교하여 작은 수를 앞쪽으로 이동시키는 과정을 반복하여 정렬하는 알고리즘이다.

```
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
```

첫번째 for문을 반복하면서 가장 큰  숫자가 인덱스의 맨 마지막부터 정렬되므로 i가 n-1부터 1씩 줄어들도록 설정하였다. 

두번째 for문에서 인덱스 j(=0)부터 j+1와 비교하며 더 작은 값을 앞의 인덱스로 이동하게 하였다.



##  Selection Sort

입력 배열 전체에서 최소값을 선택하여 배열의 0번 원소와 자리를 바꾸고, 다음엔 0번 원소를 제외한 나머지 원소에서 최솟값을 선택하여, 배열의 1번 원소와 자리를 바꾼다. 이러한 방식으로 마지막에 2개의 원소 중 최소값을 선택하여 자리를 바꿈으로써 오름차순의 정렬을 마친다.

```
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
```

먼저 최솟값의 인덱스 번호인 min을 i로 설정하고 두번째 for문을 이용하여 i+1부터 n-1까지 비교하며 min의 값보다 작은 값이 있으면 그 값의 인덱스 번호를 min으로 설정한다. 

두번째 for문이 끝나면 min의 위치와 i의 위치를 바꾸어주고 i가 n-2가 될때까지 반복한다(첫번째 for문).



## Insertion Sort

배열을 정렬된 부분 (앞부분)과 정렬 안 된 부분 (뒷부분)으로 나누고, 정렬 안 된 부분의 가장 왼쪽 원소를 정렬된 부분의 적절한 위치에 삽입하여 정렬되도록 하는 과정을 반복한다.

```
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
```

CurrentElement C를 설정하여 C의 앞에 있는 값이 C에 위치해있는 값보다 크면 그 인덱스를 오른쪽으로 한칸 이동시켰다. 

j가 0보다 작아지거나 앞의 값이 C의 값보다 작아서  while문이 반복되지 않으면  j+1 인덱스에 C의 값을 넣어준다. 

이 과정을 i가 n-1이 될때까지 반복한다(for문).



##  Shell Sort

버블 정렬과 삽입 정렬의 단점을 보완하기 위하여 삽입 정렬을 이용하여 배열 뒷부분의 작은 숫자를 앞부분으로 빠르게 이동시키고, 동시에 앞부분의 큰 숫자는 뒷부부능로 이동시키며, 가장 마지막에는 삽입 정렬을 수행한다.

```
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
```

gap의 크기를 n/2에서 부터 계속 2로 나누어 주며 gap의 크기가 0보다 클 동안 반복한다(첫번째 for문).

위의  for문에서 gap의 크기가 0이 나온 경우 gap의 크기를 1로 설정해준다(if문).

그룹들끼리 정렬을 해준다(두번째 for문).

j=i+gap으로 설정하여 j 인덱스에 있는 값을 CurrentElement C에 저장해주고 자신이 속한 그룹에서 인덱스가 j보다 작은 값들과 비교하여 C의 값이 더 작다면 비교한 인덱스의 위치를 그 그룹의 오른쪽으로 한칸 이동시킨다(3번째 for문, while문).



## 성능 평가

배열의 값을 랜덤한 값, 내림차순, 앞부분 절반은 정렬되어있고 뒷부분 절반은 랜덤한 3가지 경우로 성능을 평가하였다.

수행시간(ms)

### 랜덤한 값

![랜덤](https://user-images.githubusercontent.com/80511975/117315502-b8aa7780-aec2-11eb-8c16-26fb28952193.PNG)

### 내림차순

![내림차순](https://user-images.githubusercontent.com/80511975/117315438-a92b2e80-aec2-11eb-8552-c30c9b199071.PNG)

### 앞부분 절반 정렬, 뒷부분 절반 랜덤

![절반](https://user-images.githubusercontent.com/80511975/117315639-d2e45580-aec2-11eb-8cfc-1e98701d9df7.PNG)



## 전체 코드

```
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
```

