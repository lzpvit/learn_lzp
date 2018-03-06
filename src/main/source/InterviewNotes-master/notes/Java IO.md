<!-- GFM-TOC -->
* [����](#����)
* [���̲���](#���̲���)
* [�ֽڲ���](#�ֽڲ���)
* [�ַ�����](#�ַ�����)
* [�������](#�������)
* [�������](#�������)
    * [1. InetAddress](#1-inetaddress)
    * [2. URL](#2-url)
    * [3. Sockets](#3-sockets)
    * [4. Datagram](#4-datagram)
* [NIO](#nio)
    * [1. �����](#1-�����)
    * [2. ͨ���뻺����](#2-ͨ���뻺����)
        * [2.1 ͨ��](#21-ͨ��)
        * [2.2 ������](#22-������)
    * [3. ������״̬����](#3-������״̬����)
    * [4. ��д�ļ�ʵ��](#4-��д�ļ�ʵ��)
    * [5. �����������](#5-�����������)
        * [5.1 ����ʽ I/O](#51-����ʽ-io)
        * [5.2 ������ʽ I/O](#52-������ʽ-io)
    * [6. �׽���ʵ��](#6-�׽���ʵ��)
        * [6.1 ServerSocketChannel](#61-serversocketchannel)
        * [6.2 Selectors](#62-selectors)
        * [6.3 ��ѭ��](#63-��ѭ��)
        * [6.4 ����������](#64-����������)
        * [6.5 �����µ�����](#65-�����µ�����)
        * [6.6 ɾ��������� SelectionKey](#66-ɾ���������-selectionkey)
        * [6.7 ����� I/O](#67-�����-io)
* [�ο�����](#�ο�����)
<!-- GFM-TOC -->

# ����

Java �� I/O ��ſ��Էֳ����¼���

1. ���̲�����File
2. �ֽڲ�����InputStream �� OutputStream
3. �ַ�������Reader �� Writer
4. ���������Serializable
5. ���������Socket
6. ������ʽ IO��NIO

# ���̲���

File ��������ڱ�ʾ�ļ���Ŀ¼��������ֻ���ڱ�ʾ�ļ�����Ϣ��������ʾ�ļ������ݡ�

# �ֽڲ���

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/8143787f-12eb-46ea-9bc3-c66d22d35285.jpg)

Java I/O ʹ����װ����ģʽ��ʵ�֡��� InputStream Ϊ����InputStream �ǳ��������FileInputStream �� InputStream �����࣬���ھ���������ṩ���ֽ��������������FilterInputStream ���ڳ���װ���ߣ�װ��������װ�������Ϊ����ṩ����Ĺ��ܣ����� BufferedInputStream Ϊ FileInputStream �ṩ����Ĺ��ܡ�ʵ����һ�����л��湦�ܵ��ֽ�������ʱ��ֻ��Ҫ�� FileInputStream ����������һ�� BufferedInputStream ���󼴿ɡ�

```java
BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
```

DataInputStream װ�����ṩ�˶Ը����������ͽ�������Ĳ��������� int��double �Ȼ������͡�

���������ļ��е����ݵ��ֽ�������

```java
byte[] buf = new byte[20*1024];
int bytes = 0;
// ����ȡ buf.length ���ֽڣ����ص���ʵ�ʶ�ȡ�ĸ��������� -1 ��ʱ���ʾ���� eof�����ļ�β
while((bytes = in.read(buf, 0 , buf.length)) != -1) {
    // ...
}
```

# �ַ�����

�����Ǵ��̻������紫�䣬��С�Ĵ洢��Ԫ�����ֽڣ��������ַ������� I/O �����Ķ����ֽڶ������ַ��������ڳ����в���������ͨ�����ַ���ʽ�������Ҫ�ṩ���ַ����в����ķ�����

InputStreamReader ʵ�ִ��ı��ļ����ֽ���������ַ�����OutputStreamWriter ʵ���ַ��������Ϊ�ı��ļ����ֽ��������Ƕ��̳��� Reader �� Writer��

������ǰ��ַ�ת��Ϊ�ֽڣ��������ǰ��ֽ�������ϳ��ַ���

```java
byte[] bytes = str.getBytes(encoding);     // ����
String str = new String(bytes, encoding)�� // ����
```

GBK �����У�����ռ 2 ���ֽڣ�Ӣ��ռ 1 ���ֽڣ�UTF-8 �����У�����ռ 3 ���ֽڣ�Ӣ��ռ 1 ���ֽڣ�Java ʹ��˫�ֽڱ��� UTF-16be�����ĺ�Ӣ�Ķ�ռ 2 ���ֽڡ�

�������ͽ������ʹ�ò�ͬ�ı��뷽ʽ��ô�ͳ��������롣

# �������

���л����ǽ�һ������ת�����ֽ����У�����洢�ʹ��䡣

���л���ObjectOutputStream.writeObject()

�����л���ObjectInputStream.readObject()

���л�������Ҫʵ�� Serializable �ӿڣ���ֻ��һ����׼��û���κη�����Ҫʵ�֡�

transient �ؼ��ֿ���ʹһЩ���Բ��ᱻ���л���

**ArrayList ���л��ͷ����л���ʵ��**��ArrayList �д洢���ݵ��������� transient ���εģ���Ϊ��������Ƕ�̬��չ�ģ����������еĿռ䶼��ʹ�ã���˾Ͳ���Ҫ���е����ݶ������л���ͨ����д���л��ͷ����л�������ʹ�ÿ���ֻ���л������������ݵ��ǲ������ݡ�

```
private transient Object[] elementData;
```

# �������

Java �е�����֧�֣�

1. InetAddress�����ڱ�ʾ�����ϵ�Ӳ����Դ���� IP ��ַ��
2. URL��ͳһ��Դ��λ����ͨ�� URL ����ֱ�Ӷ�ȡ����д�������ϵ����ݣ�
3. Sockets��ʹ�� TCP Э��ʵ������ͨ�ţ�
4. Datagram��ʹ�� UDP Э��ʵ������ͨ�š�

## 1. InetAddress

û�й��й��캯����ֻ��ͨ����̬����������ʵ�������� InetAddress.getByName(String host)��InetAddress.getByAddress(byte[] addr)��

## 2. URL

����ֱ�Ӵ� URL �ж�ȡ�ֽ�������

```java
URL url = new URL("http://www.baidu.com");
InputStream is = url.openStream(); // �ֽ���
InputStreamReader isr = new InputStreamReader(is, "utf-8");                              // �ַ���
BufferedReader br = new BufferedReader(isr);
String line = br.readLine();
while (line != null) {
    System.out.println(line);
    line = br.readLine();
}
br.close();
isr.close();
is.close();
```

## 3. Sockets

Socket ͨ��ģ��

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/fa4101d7-19ce-4a69-a84f-20bbe64320e5.jpg)

- ServerSocket������������
- Socket���ͻ�����

�������Ϳͻ���ͨ�� InputStream �� OutputStream �������������

## 4. Datagram

- DatagramPacket�����ݰ���
- DatagramSocket��ͨ����

# NIO

NIO �����ʱ�� I/O ���� ( ��������ȡ������ ) ת�ƻز���ϵͳ����� ����Ҫ����Աȥ���ƾͿ��Լ������������ٶȡ�

## 1. �����

I/O �� NIO ����Ҫ�����������ݴ���ʹ���ķ�ʽ������ǰ���ᵽ�ģ�I/O �����ķ�ʽ�������ݣ��� NIO �Կ�ķ�ʽ�������ݡ�

�������� I/O һ��һ���ֽڽ��д������ݣ�һ������������һ���ֽڵ����ݣ�һ�����������һ���ֽڵ����ݡ�Ϊ��ʽ���ݴ����������ǳ����ף����Ӽ������������Ա�ÿ��������ֻ���𵥸����Ӵ�����Ƶ�һ���֣�����Ҳ����Լ򵥵ġ�������һ���ǣ��������� I/O ͨ���൱����

һ�������� I/O ϵͳ�Կ����ʽ�������ݣ�ÿһ����������һ���в�����������һ�����ݿ顣���鴦�����ݱȰ�����������Ҫ��öࡣ���������� I/O ȱ��һЩ�������� I/O �����е������Ժͼ��ԡ�

I/O ���� NIO �Ѿ��ܺõؼ����ˣ�java.io.\* �Ѿ��� NIO Ϊ��������ʵ���ˣ������������������� NIO ��һЩ���ԡ����磬 java.io.\* ���е�һЩ������Կ����ʽ��д���ݵķ�������ʹ�ü�ʹ�ڸ���������ϵͳ�У������ٶ�Ҳ����졣

## 2. ͨ���뻺����

### 2.1 ͨ��

ͨ�� Channel �Ƕ�ԭ I/O ���е�����ģ�⣬����ͨ������ȡ��д�����ݡ�

ͨ�������Ĳ�֮ͬ�����ڣ���ֻ����һ���������ƶ���(һ���������� InputStream ���� OutputStream ������)�� ��ͨ����˫��ģ��������ڶ���д����ͬʱ���ڶ�д��

ͨ�������������ͣ�

- FileChannel�����ļ��ж�д���ݣ�
- DatagramChannel��ͨ�� UDP ��д���������ݣ�
- SocketChannel��ͨ�� TCP ��д���������ݣ�
- ServerSocketChannel�����Լ����½����� TCP ���ӣ���ÿһ���½��������Ӷ��ᴴ��һ�� SocketChannel��

### 2.2 ������

���͸�һ��ͨ�������ж��󶼱������ȷŵ��������У�ͬ���أ���ͨ���ж�ȡ���κ����ݶ�Ҫ�����������С�Ҳ����˵������ֱ�Ӷ�ͨ�����ж�д���ݣ������Ⱦ�����������

������ʵ������һ�����飬������������һ�����顣�������ṩ�˶����ݵĽṹ�����ʣ����һ����Ը���ϵͳ�Ķ�/д���̡�

�����������������ͣ�

- ByteBuffer
- CharBuffer
- ShortBuffer
- IntBuffer
- LongBuffer
- FloatBuffer
- DoubleBuffer


## 3. ������״̬����

- capacity�����������
- position����ǰ�Ѿ���д���ֽ�����
- limit�������Զ�д���ֽ�����

״̬�����ĸı���̣�

1\. �½�һ����СΪ 8 ���ֽڵĻ���������ʱ position Ϊ 0���� limit == capacity == 9��capacity ��������ı䣬��������ۻ��������

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/1bea398f-17a7-4f67-a90b-9e2d243eaa9a.png)

2\. ������ͨ���ж�ȡ 3 ���ֽ�����д�뻺�����У���ʱ position �ƶ���Ϊ 3��limit ���ֲ��䡣

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/4628274c-25b6-4053-97cf-d1239b44c43d.png)

3\. �ڽ�������������д�����ͨ��֮ǰ����Ҫ�ȵ��� flip() ��������������� limit ����Ϊ��ǰ position������ position ����Ϊ 0��

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/952e06bd-5a65-4cab-82e4-dd1536462f38.png)

4\. �ӻ�������ȡ 4 ���ֽڵ���������У���ʱ position ��Ϊ 4��

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/b5bdcbe2-b958-4aef-9151-6ad963cb28b4.png)

5\. �����Ҫ���� clear() ��������ջ���������ʱ position �� limit ��������Ϊ���λ�á�

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/67bf5487-c45d-49b6-b9c0-a058d8c68902.png)

## 4. ��д�ļ�ʵ��

1\. ΪҪ��ȡ���ļ����� FileInputStream��֮��ͨ�� FileInputStream ��ȡ���� FileChannel��

```java
FileInputStream fin = new FileInputStream("readandshow.txt");
FileChannel fic = fin.getChannel();
```

2\. ����һ������Ϊ 1024 �� Buffer

```java
ByteBuffer buffer = ByteBuffer.allocate(1024);
```

3\. �����ݴ����� FileChannel д�뵽 Buffer �У����û�����ݵĻ��� read() �����᷵�� -1

```java
int r = fcin.read(buffer);
if (r == -1) {
     break;
}
```

4\. ΪҪд����ļ����� FileOutputStream��֮��ͨ�� FileOutputStream ��ȡ��� FileChannel

```java
FileOutputStream fout = new FileOutputStream("writesomebytes.txt");
FileChannel foc = fout.getChannel();
```

5\. ���� flip() �л���д

```java
buffer.flip();
```

6\. �� Buffer �е����ݶ�ȡ����� FileChannel ��

```java
foc.write(buffer);
```

7\. ������ clear() ���û�����

```java
buffer.clear();
```

## 5. �����������

Ӧ��ע�⣬FileChannel �����л���������ģʽ���׽��� Channel ���ԡ�

### 5.1 ����ʽ I/O

����ʽ I/O �ڵ��� InputStream.read() ����ʱ��һֱ�ȵ����ݵ���ʱ����ʱ���Ż᷵�أ��ڵ��� ServerSocket.accept() ����ʱ��Ҳ��һֱ�������пͻ������ӲŻ᷵�أ�ÿ���ͻ������ӹ����󣬷���˶�������һ���߳�ȥ����ÿͻ��˵�����

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/edc23f99-c46c-4200-b64e-07516828720d.jpg)

### 5.2 ������ʽ I/O

��һ��ר�ŵ��߳����������е� I/O �¼���������ַ���

�¼��������ƣ��¼�����ʱ�򴥷���������ͬ����ȥ�����¼���

�߳�ͨ�ţ��߳�֮��ͨ�� wait()��notify() �ȷ�ʽͨ�ţ���֤ÿ���������л�����������ģ�������ν���߳��л���

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/7fcb2fb0-2cd9-4396-bc2d-282becf963c3.jpg)

## 6. �׽���ʵ��

### 6.1 ServerSocketChannel

ÿһ���˿ڶ���Ҫ��һ�� ServerSocketChannel �����������ӡ�

```java
ServerSocketChannel ssc = ServerSocketChannel.open();
ssc.configureBlocking(false); // ����Ϊ������

ServerSocket ss = ssc.socket();
InetSocketAddress address = new InetSocketAddress(ports[i]);
ss.bind(address); // �󶨶˿ں�
```

### 6.2 Selectors

�첽 I/O ͨ�� Selector ע����ض� I/O �¼�����Ȥ �D �ɶ������ݵĵ���µ��׽������ӵȵȣ��ڷ����������¼�ʱ��ϵͳ���ᷢ��֪ͨ��

���� Selectors ֮�󣬾Ϳ��ԶԲ�ͬ��ͨ��������� register() ������register() �ĵ�һ������������� Selector���ڶ��������� OP_ACCEPT��������ָ��������Ҫ���� accept �¼���Ҳ�������µ����ӽ���ʱ���������¼���

SelectionKey �������ͨ���ڴ� Selector �ϵ����ע�ᡣ��ĳ�� Selector ֪ͨ��ĳ�������¼�ʱ������ͨ���ṩ��Ӧ�ڸ��¼��� SelectionKey �����еġ�SelectionKey ����������ȡ��ͨ����ע�ᡣ

```java
Selector selector = Selector.open();
SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
```

### 6.3 ��ѭ��

���ȣ����ǵ��� Selector �� select() ���������������������ֱ��������һ����ע����¼���������һ�����߸�����¼�����ʱ�� select() �������������������¼���������

�����������ǵ��� Selector �� selectedKeys() �����������ط������¼��� SelectionKey �����һ�� ���� ��

����ͨ������ SelectionKeys �����δ���ÿ�� SelectionKey �������¼�������ÿһ�� SelectionKey��������ȷ����������ʲô I/O �¼����Լ�����¼�Ӱ����Щ I/O ����

```java
int num = selector.select();
 
Set selectedKeys = selector.selectedKeys();
Iterator it = selectedKeys.iterator();
 
while (it.hasNext()) {
     SelectionKey key = (SelectionKey)it.next();
     // ... deal with I/O event ...
}
```

### 6.4 ����������

����ִ�е�������ǽ�ע���� ServerSocketChannel�����ҽ�ע�����ǡ����ա��¼���Ϊȷ����һ�㣬���Ƕ� SelectionKey ���� readyOps() ����������鷢����ʲô���͵��¼���

```java
if ((key.readyOps() & SelectionKey.OP_ACCEPT)
     == SelectionKey.OP_ACCEPT) {
     // Accept the new connection
     // ...
}
```

���Կ϶���˵�� readOps() �����������Ǹ��¼����µ����ӡ�

### 6.5 �����µ�����

��Ϊ����֪������������׽�������һ�����������ڵȴ������Կ��԰�ȫ�ؽ�������Ҳ����˵�����õ��� accept() ������������

```java
ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
SocketChannel sc = ssc.accept();
```

��һ���ǽ������ӵ� SocketChannel ����Ϊ�������ġ��������ڽ���������ӵ�Ŀ����Ϊ�˶�ȡ�����׽��ֵ����ݣ��������ǻ����뽫 SocketChannel ע�ᵽ Selector�ϣ�������ʾ��

```java
sc.configureBlocking( false );
SelectionKey newKey = sc.register( selector, SelectionKey.OP_READ );
```

ע������ʹ�� register() �� OP_READ �������� SocketChannel ע������ ��ȡ ������ ���� �����ӡ�

### 6.6 ɾ��������� SelectionKey

�ڴ��� SelectionKey ֮�����Ǽ������Է�����ѭ���ˡ��������Ǳ������Ƚ�������� SelectionKey ��ѡ���ļ�������ɾ�����������û��ɾ��������ļ�����ô����Ȼ��������������һ������ļ����֣���ᵼ�����ǳ����ٴδ����������ǵ��õ������� remove() ������ɾ��������� SelectionKey��

```java
it.remove();
```

�������ǿ��Է�����ѭ�������ܴ�һ���׽����д��������(����һ������� I/O �¼�)�ˡ�

### 6.7 ����� I/O

������һ���׽��ֵ����ݵ���ʱ�����ᴥ��һ�� I/O �¼�����ᵼ������ѭ���е��� Selector.select()��������һ�����߶�� I/O �¼�����һ�Σ� SelectionKey �������Ϊ OP_READ �¼���������ʾ��

```java
} else if ((key.readyOps() & SelectionKey.OP_READ)
     == SelectionKey.OP_READ) {
     // Read the data
     SocketChannel sc = (SocketChannel)key.channel();
     // ...
}
```


# �ο�����

- Eckel B, ���˶� , ��� , �� . Java ���˼�� [M]. ��е��ҵ������ , 2002.
- [IBM: NIO ����](https://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html)
- [ ������� Java I/O �Ĺ������� ](https://www.ibm.com/developerworks/cn/java/j-lo-javaio/index.html)
- [NIO �봫ͳ IO ������ ](http://blog.csdn.net/shimiso/article/details/24990499)
