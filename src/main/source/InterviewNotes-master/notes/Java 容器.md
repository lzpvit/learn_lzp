<!-- GFM-TOC -->
* [����](#����)
    * [1. List](#1-list)
    * [2. Set](#2-set)
    * [3. Queue](#3-queue)
    * [4. Map](#4-map)
    * [5. Java 1.0/1.1 ����](#5-java-1011-����)
* [�����е����ģʽ](#�����е����ģʽ)
    * [1. ������ģʽ](#1-������ģʽ)
    * [2. ������ģʽ](#2-������ģʽ)
* [ɢ��](#ɢ��)
* [Դ�����](#Դ�����)
    * [1. ArraList](#1-arralist)
    * [2. Vector �� Stack](#2-vector-��-stack)
    * [3. LinkedList](#3-linkedlist)
    * [4. TreeMap](#4-treemap)
    * [5. HashMap](#5-hashmap)
    * [6. LinkedHashMap](#6-linkedhashmap)
    * [7. ConcurrentHashMap](#7-concurrenthashmap)
* [�ο�����](#�ο�����)
<!-- GFM-TOC -->

# ����

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/ebf03f56-f957-4435-9f8f-0f605661484d.jpg)

������Ҫ���� Collection �� Map ���֣�Collection �ְ����� List��Set �Լ� Queue��

## 1. List

- ArrayList�����ڶ�̬����ʵ�֣�֧��������ʣ�

- LinkedList������˫��ѭ������ʵ�֣�ֻ��˳����ʣ����ǿ��Կ��ٵ��������м�����ɾ��Ԫ�ء�������ˣ�LinkedList ����������ջ�����к�˫�˶��С�

## 2. Set

- HashSet������ Hash ʵ�֣�֧�ֿ��ٲ��ң�����ʧȥ�����ԣ�

- TreeSet�����ں����ʵ�֣��������򣬵��ǲ���Ч�ʲ��� HashSet��

- LinkedListHashSet������ HashSet �Ĳ���Ч�ʣ����ڲ�ʹ������ά��Ԫ�صĲ���˳����˾��������ԡ�

## 3. Queue

ֻ������ʵ�֣�LinkedList �� PriorityQueue������ LinkedList ֧��˫����У�PriorityQueue �ǻ��ڶѽṹʵ�֡�

## 4. Map

- HashMap������ Hash ʵ��

- LinkedHashMap��ʹ��������ά��Ԫ�ص�˳��˳��Ϊ����˳������������ʹ�ã�LRU��˳��

- TreeMap�����ں����ʵ��

- ConcurrentHashMap���̰߳�ȫ Map�����漰������ HashTable ��ͬ������

## 5. Java 1.0/1.1 ����

���ھɵ����������Ǿ���Ӧ��ʹ�����ǣ�ֻ��Ҫ�����ǽ����˽⡣

- Vector���� ArrayList ���ƣ��������̰߳�ȫ��

- HashTable���� HashMap ���ƣ��������̰߳�ȫ��

# �����е����ģʽ

## 1. ������ģʽ

�Ӹ���ͼ���Կ�����ÿ�������඼��һ�� Iterator ���󣬿���ͨ��������������������������е�Ԫ�ء�

[Java �еĵ�����ģʽ ](https://github.com/CyC2018/InterviewNotes/blob/master/notes/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.md#92-java-%E5%86%85%E7%BD%AE%E7%9A%84%E8%BF%AD%E4%BB%A3%E5%99%A8)

## 2. ������ģʽ

java.util.Arrays#asList() ���԰���������ת��Ϊ List ���͡�

```java
 List list = Arrays.asList(1, 2, 3);
 int[] arr = {1, 2, 3};
 list = Arrays.asList(arr);
```

# ɢ��

ʹ�� hasCode() ������ɢ��ֵ��ʹ�õ��Ƕ���ĵ�ַ��

�� equals() �������ж����������Ƿ���ȵģ���ȵ���������ɢ��ֵһ��Ҫ��ͬ������ɢ��ֵ��ͬ����������һ����ȡ�

��ȱ�����������������ʣ�

1. �Է���
2. �Գ���
3. ������
4. һ���ԣ���ε��� x.equals(y)��������䣩
5. ���κβ��� null �Ķ��� x ���� x.equals(nul) �����Ϊ false

# Դ�����

�������Ķ� [ �㷨 - ���� ](https://github.com/CyC2018/InterviewNotes/blob/master/notes/%E7%AE%97%E6%B3%95.md#%E7%AC%AC%E4%B8%89%E7%AB%A0-%E6%9F%A5%E6%89%BE) ���֣��Լ�����Դ�������кܴ������

Դ�����أ�[OpenJDK 1.7](http://download.java.net/openjdk/jdk7)

## 1. ArraList

[ArraList.java](https://github.com/CyC2018/InterviewNotes/blob/master/notes/src/ArrayList.java)

ʵ���� RandomAccess �ӿڣ����֧��������ʣ�����������Ȼ�ģ���Ϊ ArrayList �ǻ�������ʵ�ֵġ�

```java
public class ArrayList<E> extends AbstractList<E>
    implements List<E>, RandomAccess, Cloneable, java.io.Serializable
```

��������ʵ�֣�����Ԫ�ص�����ʹ�� transient ���Σ�������Ϊ�����鲻һ������λ�ö�ռ��Ԫ�أ����Ҳ��û��Ҫȫ�����������л�����Ҫ��д writeObject() �� readObject()��

```java
private transient Object[] elementData;
```

�����Ĭ�ϴ�СΪ 10

```java
public ArrayList(int initialCapacity) {
    super();
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
    this.elementData = new Object[initialCapacity];
}

public ArrayList() {
    this(10);
}
```

ɾ��Ԫ��ʱ���� System.arraycopy() ��Ԫ�ؽ��и��ƣ����ɾ�������ɱ��ܸߣ�����ڴ���ʱ��ָ����ŵ�������С�����ٸ��Ʋ�����ִ�д�����

```java
public E remove(int index) {
    rangeCheck(index);

    modCount++;
    E oldValue = elementData(index);

    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index, numMoved);
    elementData[--size] = null; // Let gc do its work

    return oldValue;
}
```

���Ԫ��ʱʹ�� ensureCapacity() ��������֤�����㹻���������ʱ����Ҫ�������ݣ�ʹ��������Ϊ�������� 1.5 ����

modCount ������¼ ArrayList �����仯�Ĵ�������Ϊÿ���ڽ��� add() �� addAll() ʱ����Ҫ���� ensureCapacity()�����ֱ���� ensureCapacity() �ж� modCount �����޸ġ�

```java
public void ensureCapacity(int minCapacity) {
    if (minCapacity > 0)
        ensureCapacityInternal(minCapacity);
}

private void ensureCapacityInternal(int minCapacity) {
    modCount++;
    // overflow-conscious code
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}

private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}

private static int hugeCapacity(int minCapacity) {
    if (minCapacity < 0) // overflow
        throw new OutOfMemoryError();
    return (minCapacity > MAX_ARRAY_SIZE) ?
        Integer.MAX_VALUE :
        MAX_ARRAY_SIZE;
}
```

�ڽ������л����ߵ����Ȳ���ʱ����Ҫ�Ƚϲ���ǰ�� modCount �Ƿ�ı䣬����ı�����Ҫ�׳� ConcurrentModificationException��

```java
private void writeObject(java.io.ObjectOutputStream s)
    throws java.io.IOException{
    // Write out element count, and any hidden stuff
    int expectedModCount = modCount;
    s.defaultWriteObject();

    // Write out array length
    s.writeInt(elementData.length);

    // Write out all elements in the proper order.
    for (int i=0; i<size; i++)
        s.writeObject(elementData[i]);

    if (modCount != expectedModCount) {
        throw new ConcurrentModificationException();
    }

}
```

**�� Vector ������**

1.  Vector �� ArrayList ��������ȫ��ͬ�ģ�Ψһ���������� Vector ��ͬ���ģ���˿����ͱ� ArrayList Ҫ�󣬷���Ҫ�������ʹ�� ArrayList ������ Vector����Ϊͬ����ȫ�����ɳ���Ա�Լ������ƣ�
2.  Vector ÿ�������������С�� 2 ���ռ䣬�� ArrayList �� 1.5 ����

Ϊ��ʹ���̰߳�ȫ�� ArrayList������ʹ�� Collections.synchronizedList(new ArrayList<>()); ����һ���̰߳�ȫ�� ArrayList��Ҳ����ʹ�� concurrent �������µ� CopyOnWriteArrayList �ࣻ

**�� LinkedList ������**

1.  ArrayList ���ڶ�̬����ʵ�֣�LinkedList ����˫��ѭ������ʵ�֣�
2. ArrayList ֧��������ʣ�LinkedList ��֧�֣�
3. LinkedList ������λ�����ɾ��Ԫ�ظ��졣

## 2. Vector �� Stack

[Vector.java](https://github.com/CyC2018/InterviewNotes/blob/master/notes/src/Vector.java)

## 3. LinkedList

[LinkedList.java](https://github.com/CyC2018/InterviewNotes/blob/master/notes/src/LinkedList.java)

## 4. TreeMap

[TreeMap.java](https://github.com/CyC2018/InterviewNotes/blob/master/notes/src/TreeMap.java)

## 5. HashMap

[HashMap.java](https://github.com/CyC2018/InterviewNotes/blob/master/notes/src/HashMap.java)

ʹ���������������ͻ��

Ĭ������ capacity Ϊ 16����Ҫע������������뱣֤Ϊ 2 �Ĵη����������� Entry[] table ����ĳ��ȣ�size �������ʵ��ʹ������

threshold �涨��һ�� size ���ٽ�ֵ��size ����С�� threshold��������ڵ��ڣ��ͱ���������ݲ�����

threshold = capacity * load_factor������ load_factor Ϊ table �����ܹ�ʹ�õı�����load_factor ����ᵼ�¾۴صĳ��֣��Ӷ�Ӱ���ѯ�Ͳ����Ч�ʣ�����㷨�ʼǡ�

```java
static final int DEFAULT_INITIAL_CAPACITY = 16;

static final int MAXIMUM_CAPACITY = 1 << 30;

static final float DEFAULT_LOAD_FACTOR = 0.75f;

transient Entry[] table;

transient int size;

int threshold;

final float loadFactor;

transient int modCount;
```

����������Ԫ�ش����п��Կ���������Ҫ����ʱ���� capacity Ϊԭ����������

```java
void addEntry(int hash, K key, V value, int bucketIndex) {
    Entry<K,V> e = table[bucketIndex];
    table[bucketIndex] = new Entry<>(hash, key, value, e);
    if (size++ >= threshold)
        resize(2 * table.length);
}
```

Entry ������ʾһ����ֵ��Ԫ�أ����е� next ָ�������л�ʱ��ʹ�á�

```java
static class Entry<K,V> implements Map.Entry<K,V> {
    final K key;
    V value;
    Entry<K,V> next;
    final int hash;
}
```

get() ������Ҫ�ֳ����������key Ϊ null �� ��Ϊ null�����п��Կ��� HashMap ������� null ��Ϊ����

```java
public V get(Object key) {
    if (key == null)
        return getForNullKey();
    int hash = hash(key.hashCode());
    for (Entry<K,V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
        Object k;
        if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
            return e.value;
    }
    return null;
}
```

put() ����Ҳ��Ҫ���� key �Ƿ�Ϊ null ����ͬ�Ĵ�����Ҫע������������û�� key Ϊ null �ļ�ֵ�ԣ��²���һ�� key Ϊ null �ļ�ֵ��ʱĬ���Ƿ�������� 0 λ�ã�������Ϊ null ���ܼ��� hash ֵ��Ҳ���޷�֪��Ӧ�÷����ĸ������ϡ�

```java
public V put(K key, V value) {
    if (key == null)
        return putForNullKey(value);
    int hash = hash(key.hashCode());
    int i = indexFor(hash, table.length);
    for (Entry<K,V> e = table[i]; e != null; e = e.next) {
        Object k;
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
            V oldValue = e.value;
            e.value = value;
            e.recordAccess(this);
            return oldValue;
        }
    }

    modCount++;
    addEntry(hash, key, value, i);
    return null;
}
```

```java
private V putForNullKey(V value) {
    for (Entry<K,V> e = table[0]; e != null; e = e.next) {
        if (e.key == null) {
            V oldValue = e.value;
            e.value = value;
            e.recordAccess(this);
            return oldValue;
        }
    }
    modCount++;
    addEntry(0, null, value, 0);
    return null;
}
```

## 6. LinkedHashMap

[LinkedHashMap.java](https://github.com/CyC2018/InterviewNotes/blob/master/notes/src/HashMap.java)

## 7. ConcurrentHashMap

[ConcurrentHashMap.java](https://github.com/CyC2018/InterviewNotes/blob/master/notes/src/HashMap.java)

[ ̽�� ConcurrentHashMap �߲����Ե�ʵ�ֻ��� ](https://www.ibm.com/developerworks/cn/java/java-lo-concurrenthashmap/)

# �ο�����

- Java ���˼��
