## Vector 분석
#### 기본 특성
* Thread-Safe한 자료구조 (synchronized), Thread-Safe하지 않은 ArrayList보다 느리다.
* 내부 element는 **배열**인 elementData에 보관.
    * 조회 : O(1)
    * 삭제 : O(n) System.arrayCopy() 연산으로 n개의 데이터를 덮어씀. 

#### 삭제; removeElementAt(int index)
```java
// Vector.java code
public synchronized void removeElementAt(int index) {
        modCount++;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                     elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            // 중간 요소가 삭제되면 그 뒤의 요소들을 shift해줘야 함.
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null; /* to let gc do its work */
    }
```
