# K번째수


>  [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42748)

### 퀵 정렬

---

+ [분할 정복(divide and conquer)]([https://ko.wikipedia.org/wiki/%EB%B6%84%ED%95%A0_%EC%A0%95%EB%B3%B5_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98](https://ko.wikipedia.org/wiki/분할_정복_알고리즘)) 방법을 통해 리스트를 정렬

  > 분할 정복이 뭔지 모르겠지만 재귀 함수로 해결하는 방법인 듯

+ 정렬해야 할 리스트를 피봇을 기준으로 왼쪽 배열과 오른쪽 배열로 나누고, 각 배열의 양끝 인덱스를 가르키는 포인터(start, end)를 이용하여 값을 비교 및 스왑

+ 구현 방법

  1. 리스트 가운데서 기준이 되는 원소를 하나 고른다. (pivot)
  2. pivot 앞에는 pivot보다 값이 작은 원소들을 모으고, pivot 뒤에는 pivot보다 값이 큰 원소들을 모으기 위해 리스트를 둘로 분할
  3. 분할된 두 개의 작은 리스트에 대해 재귀적으로 이 과정을 반복. (재귀를 빠져나오는 조건은 반드시 필요)

+ 재귀 함수가 적용되는 부분

  시작 포인터(start)가 끝 포인터(end)보다 값이 커지는 순간, 호출 당시 [left ~ end 배열], [right ~ start 배열] 각각에 소팅을 수행하도록 재귀적으로 호출됨

> 문제에 사용한 퀵 정렬

```java
    private void sort(int[] arr, int start, int end){
        int pivot = arr[(start + end) / 2];
        int pointLeft = start;
        int pointRight = end;

        if(start == end) // 배열의 길이가 1인 경우
            return;

        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
          // 여기 조건 조심
          // 헷갈려서 요소의 값 비교 했었음. 요소 값 비교는 이미 위에서 pivot과의 비교로 이루어지는 것
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
     	 	// 이동한 포인터를 기준으로 다시 한번 왼쪽, 오른쪽 배열로 분할
        // 분할된 요소의 개수가 1개 이하인 경우에는 더 이상 분할하지 않음
        if(pointLeft < end)
            sort(arr, pointLeft, end);

        if(pointRight > start)
            sort(arr, start, pointRight);
    }

    private void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
```

