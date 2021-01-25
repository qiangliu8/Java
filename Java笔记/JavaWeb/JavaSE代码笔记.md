[TOC]

# Java入门知识



## 一、内存是什么？



对于计算机来说，

**CPU**：中央处理器，负责发送并执行指令，负责计算和运算

**内存**：程序运行过程中当中的临时数据存储空间，断电之后或者关机之后	内存的数据就消失了。cpu计算过程中的临时存储空间

**硬盘**：持久化硬盘，硬盘上的数据不会断电而丢失

**主板**：相当于人类的躯干，是一个载体：将电脑的CPU、内存条、硬盘等连接起来



## 二、java语言特性



#### 1.简单性

在java语言当中**真正操作内存**的是：**JVM(java虚拟机)**

所有Java程序都是运行在java虚拟机当中的

对于c或者c++来说程序员都是直接**通过指针操作内存**的

C或者C++更灵活，可以直接程序员操作内存，要求技术更精湛，有更驾驭感

java语言屏蔽了指针概念，不能直接操作指针，或者程序员不能直接操作内存

**优点**：不容易导致内存泄漏

**缺点**：效率问题较低

java语言层是C++,所以JVM使用C++语言写好的一个虚拟电脑，**安装JDK后，JVM就代表安装好了。**



#### 2.面向对象

java是完全面向对象，更容易让人理解，采用面向对象的方式可以让复杂问题简单化



#### 3.健壮性

主要是因为java有一种机制：**自动垃圾回收机制**（GC机制）

java不容易导致内存的泄漏，比C具有健壮性

C或者C++使用不当，易导致内存泄漏，没有健壮性

**JVM负责调度GC机制**。程序员不需要干扰



#### 4.完全支持多线程并发



#### 5.可移植性/跨平台

> 一次编写，到处运行！

例如：java编写完成后，可以运行在windows操作系统上，不需要做任何改动可以直接运行在Linux操作系统上，同样也可以运行到Mac os上面

![1](F:\Typora\代码笔记\1.png)

> **JVM屏蔽了操作系统之间的差异**

**优点**：一次到处运行，可以跨平台

**缺点**：麻烦，对于运行java程序来水必须先有JVM



## 三、Java的加载与执行



##### Java非常重要的两个阶段：

- **编译阶段**

  java程序员直接编写的java代码（普通文本）是无法执行被JVM识别的。Java代码必须经过一个编译，将这个普通文本变成**字节码**的过程，称为：编译。

  Java代码被称为Java源代码，编译生成JVM可以识别的字节码。

- **运行阶段**

##### Java程序从开发到运行经历的过程：

第一步：在硬盘的某个位置（随意），新建一个xxx.Java文件
		第二步：使用记事本或者其它文本编辑器例如EditPlus打开xxx.java文件

第三步：在xxx.java文件中编写"符合java语法规则的"源代码。

第四步：保存一定要将xxx.java文件保存一下

第五步：使用编译器(javac【JDK安装后自带】）对xxx.java文件进行编译。

第六步：如果xxx.java文件中编写的源代码是符合语法规则的，编译通过，如果xxx,java文件中编写的源代码违背了语法规则，那么编译器会报错，编译器报错之后class文件是不会生成的，只有编译通过了才会生成class字节码文件。并且一个java源文件是可以生成多个class文件的（编译实质上是检查语法）

**运行期(JRE在起作用）**：

第七步：如果是在Linux上运行，需要将windows上生成的class文件拷贝过去不需要拷贝源代码，真正运行的是字节码。

第八步：使用JDK自带的一个命令/工具：java（负责运行的命令/工具）执行字节码

第九步：往下的步骤就全部交给JVM了，就不需要程序员干涉了。JVM会将字节码文件装载进去，然后JvM对字节码进行解释（解释器负责将字节码解释为1o10101010..等的二进制）

第十步：JVM会将生成的二进制码交给os操作系统，操作系统会执行二进制码和硬件进行交互

##### Java HelloWorld的执行过程和原理

> **java命令切记只能跟类名，带路径的都不对**

第一步：会先启动JVM

第二步：JVM启动之后，JVM会去启动“类加载器classloader”

类加载器作用：加载类。本质上类加载器会负责去硬盘上找“类”对应的“字节码”文件

第三步：类加载器如果在硬盘上找不到会报错：找不到或无法加载主类

类加载器如果在硬盘上找到了对应的字节码文件，类加载器会将该字节码文件装载到JVM中，JVM启动“解释器”将字节码解释为“101010000....”这种二进制码，操作系统执行二进制码和硬件交互

##### 文件指令

classpath是一个环境变量，给类加载器指路的

不属于windows操作系统，隶属于Java，是Java特有的，需要新建

Java文件后缀：.java

字节码文件后缀：.class

JDK的bin目录文件下：

javac命令：负责编译

java命令：负责运行

**注意**：一个Java文件可以生成多个class文件，最终运行的是class文件

## 四、重点术语总结

##### 1.Java体系的技术被划分为三大块 

​	 **JavaSE**：标准版

​	**JavaEE**：企业版

​	**JavaME**：微型版

##### 2.安装JDK之后

​	**JDK**： java开发工具箱

​	**JRE**： java运行环境

​	**JVM**： java虚拟机

##### 3.JDK、JRE、JVM的关系

> ##### **JRE**包含**JRE**，**JRE**包含**JVM**

**JRE**和**JDK**都可以独立安装，都有独立的安装包。

安装**JDK**时，**JRE**就自动安装了，同时**JRE**内部的**JVM**也就自动安装了

安装**JRE**时，**JVM**也就自动安装了

**JDK13**安装的时候内置了一个JRE

**JDK8**安装时不仅内置了一个JRE，还在JDK**目录之外**独立生存一个单独的JRE

### Javadoc

```java
javadoc -d XXX xxxx.java 
```

java![](F:\Typora\代码笔记\2.png)

XXX为生成文件夹名，xxxx.java是你想要生成Java文档的Java源文件

## 五、问题汇总



##### 1.去外地跑项目，需要安装JDK么？

不需要跑项目只需要安装JRE就行，体积小，安装非常便捷快速

##### 2.为什么安装JDK自带JRE？

因为java程序员开发完程序的时候，要测试这个程序，让程序运行，需要JRE

##### 3.编译阶段和运行阶段可以在不同操作系统上完成么？

在windows上编译，编译生成之后生成字节码，把字节码放到linux上运行完全可以，因为Java是跨平台的

##### 4.Java代码一旦编译，源代码可以删除么？只留下字节码可以么？

完全可以执行，因为源代码不参与程序的执行过程，参与程序执行过程的是字节码，但是最好不要删除源代码，因为如果执行结果是错误的，可能需要重新修改

##### 5.字节码是二进制文件么？

不是，如果是二进制文件，就不需要JVM了。因为操作系统可以直接执行二进制

##### 6.path环境变量的作用是什么？

path环境变量的作用就是给windows操作系统指路的

告诉windows操作系统去哪里找这个命令文件

##### 7.path环境变量时Java中的机制还是windows操作系统中的机制？path环境变量时隶属于Java的么？path环境变量和Java有关么？

path环境变量时隶属于windows的,Java只是用了一下而已



# Java基础代码笔记



## 一、新版本特性



> java XXX.java 

直接编译源文件，跳过javac，不生成class文件，是为了简化开发

## 二、入门

### 类、方法

```java
public class XXX  //这是类体
{
 ///
    public static void main(String[] args) //这是方法
    {
        
    }
}
```

> 类体里面只能放方法，放语句会编译错误



### 打印输出

```java
System.out.println("")  //换行输出
System.out.print("")	//不换行输出
```

如果输出英文字符串 需要**英文双引号**

System是一个类名，那么说明out是一个静态变量（可以是个类new出来一个静态对象），System.out返回一个对象。

```java
Account act = new Account(); 
System.out.println(pro); //Account@1b083826
System.out.println(pro.tostring); //Account@1b083826
```

**如果println（pro）; pro参数是一个引用的话，会直接调用pro的toStrintg()方法**

### tips

1.一个Java源文件可以生成多个class

2.public的类不是必须的，可以没有

3.在源文件中只要有一个class的定义，那必然对应生成一个class的文件

4.public可以没有，但是如果有的话，必须和源文件名保持一致





## 三、标识符

### 定义

Java源代码中，editplus中显示高亮颜色是黑色时，这个单词属于标识符，红色是SUN写好的一个类

标识符可以标识：类名，方法名，变量名，接口名，常量名。。。。

一句话搞定：凡是程序员自己有权利命名的单词都是标识符（main是标识符，但不能更改）

### 命名规则

<u>属于语法机制，**必须遵守**，不遵守命名规则则编译器会报错</u>

1. 规则i标识符只能由**数字**、**字母**（包括中文）、**下划线**、**美元符号$**组成，不能含有其他符号
2. 标识符不能以数组开头，中不能有空格
3. 关键词不能做标识符，蓝色字体 public static 等都是关键字
4. 标识符严格区分大小写，大写A和小写a是不一样的
5. 标识符理论上没有长度限制

### 命名规范

<u>**不必须遵守**，不遵守命名规范编译器不会报错</u>

1. 见名知意
2. 遵循**驼峰**命名（一高一低），如HelloWorld
3. 类名，接口名有特殊要求：首字母大写，后面每个单词首字母大写
4. 变量名，方法名有特殊要求：首字母小写，后面每个单词首字母大写
5. 所有常量名全部大写，单词直接用下划线衔接

### 关键词

sun公司开发的特殊含义的单词，**全部小写**，不可做标识符，蓝色字体 public static 等都是关键字

Java严格区分大小写，public和Public不一样，后者不是关键字

## 四、变量

### 怎么在语法级别上区分字符型和字符串型？

主要看是双引号还是单引号

**单引号**一定是字符型

**双引号**一定是字符串型

### 变量大小

在Java中任何数据都是有数据类型的，根据不同的数据类型，**分配不同大小的数据空间**

1字节 = 8 比特位

1比特位 = 0或1 二进制位

变量可以重新赋值，但不能重新命名，且不能同名（不管数据类型是否相同）

### 变量分类

**局部变量**：方法体之内的变量，main函数结束，该变量的内存就释放了

**成员变量**：方法体之外的变量

### 变量作用域

作用域：变量的有效范围

就近原则：选择最近的方法的那一个域

```java
public class Test01  
{
	public static void main(String[] args) 
	{
		for(int i = 0;i<10;i++)
		{
            //
		}
		System.out.println(i) //不可以,和JavaScript不同 for循环结束，i会丢弃
	}
    public static std(String[] args) 
	{
        int i
		for(i = 0;i<10;i++)
		{
            //
		}
		System.out.println(i) //可以
	}
}
//出了大括号就不认识了
```



## 五、数据类型

### 作用

数据类型用来声明变量，程序在运行过程中根据不同的数据类型分配不同大小的空间

### 基本数据类型

4大类，8小种：

```java
//第一类：数值型
byte  short  int  long 
//第二类：浮点型
float  double 
//第三类：布尔型 只有两个值 true、false
boolean
//第四类：字符型 必须单引号括起来
char 
```

#### 数值型

byte		1个字节		最大值127

short 	 2个字节		最大值32767

int		   4个字节		2147483647是int最大值，超了这个范围可以使用long类型。

long		8个字节

1个字节-8个二进制位	1byte = 8bit

对于以上的四个类型来说，最常用的是int.

开发的时候不用斤斤计较，直接选择使用int就行了.

tips:

在任何时候，整数型的字面量或数据默认被当成int类型处理

如果希望该字面量被当错long类型来处理，需要在字面量后面加上L/l

```java
long y= 12122222221;
System.out.println(y); //错误: 整数太大，默认被当成int类型处理
long y= 12122222221L;
System.out.println(y); //打印: 12122222221
```

#### 浮点型

**float**	4个字节	单精度	10.0/3 = 3.33333

**double**	8个字节	双精度	更精确	10.0/3 = 3.3333333333

**java.math.BigDecimal** :专门用于财务软件（不是基本数据类型，属于引用数据类型）

哪个容量大？

​	注意：任何一个浮点型都比整数型空间大

​	float容量 > long容量

Java规定，任何一个浮点型数据**默认被当成double**来处理，如果向被当成float可以加上F/f

​	1.0	默认double

​	1.0F	这才是float类型

#### 布尔类型

在java语言中boolean类型只有两个值，没有其他值: 只有**true和false**。不像C或者C++，c语言中1和0也可以表示布尔类型。

```java
boolean x = 1 //错误，int无法转换为boolean
```

#### 字符型

char

1. char占用2个字节
2. char的取值范围:[0-65535]
3. char采用unicode的编码方式
4. char类型的字面量使用单引号括起来
5. char可以存储一个汉字（汉字占用2个字节，Java中的char类型占用2个字节）

#### 基础数据类型的区别

整数型：byte、short、int、long

浮点型：float、double

区别：占用的空间大小不同

类型				占用字节数量					取值范围					

-----------------------------------------

byte 				1										-128~127

short				2										-32768~32867

int					 4										-2147483648 ~ 2147483647

long				  8										0~65535

float				  4										

double			  8										

boolean		    1										

char				   2	

### 引用数据类型

String属于引用数据类型，不属于基本数据类型范畴

Java中除了基本数据类型之外，剩下的都是引用数据类型

引用数据类型后期面向对象的时候才会接触

## 六、字符编码			

认为定义的一套转换表，规定一系列的文字对应的二进制码。涉及编码和解码两个过程，编码和解码的时候必须采用同一套字符编码，不然会出现乱码。

ASCII码采用byte进行存储

‘a’——————->97

‘A’——————–>65

‘0’——————–>48

‘a’——(采用ASCII进行编码)——>01100001

01100001———(采用ASCII码进行编码)———>‘a’

## 七、转义字符

Java中“\”负责转义，会将后面紧挨着的字符进行转义

```java
char s= 't'; //普通t字符
char s= '\t'; //制表符 ，只是一个字符
```

如果只是想单纯打印单引号’或者斜杠\

```java
System.out.println('\''); // 打印 ’
System.out.println('\'); // 报错，因为会转义右边的’
System.out.println('\\')// 打印 \ 
System.out.println("\"test\""); // 打印"test"             
```

特别tips:

```java
char x = '\u4e2d'
system.out.println(x) // \u为显示后面的是一个字符的unicdoe编码，编码是16进制的
```

## 八、基本数据类型转换

### 转换规则

**1.八种基本数据类型，除了boolean剩下的七种都可以进行转换**

```java
boolean  t = 1;
System.out.println(t) // int无法转换为boolean
int  t = (int)true;
System.out.println(t); //boolean无法转换为int
```

**2.如果这个整数型字面量没有超出byte/short/char的取值范围，那么照这个整数型字面量可以直接赋值给byte/short/char类型的变量**

**3.小容量向大容量转换称为自动类型转换，容量从小到大的排序为：byte<short(shar)<int<long<float<double，其中short和char都占用两个字节，但是char可以表示更大的正整数**

```java
long a = 120; //是自动类型转换   int转成long类型
long b = 120L;//不是自动类型转换 120L联合起来就是一个long类型的字面量
```

**4.大容量转换成小容量，称为强制类型转换，编写时必须添加"强制类型转换符"，但运行时可能出现精度损失，谨慎使用**

```java
long a = 1231231323L;
int b= a;
System.out.println(b); //错误: 不兼容的类型: 从long转换到int可能会有损失
int b= (int)a;
System.out.println(b)  //打印：1231231323 编译虽然过了，还是可能会有损失精度
```

**5.char+ short+byte 运算时会先转换成int再做运算**

```java
char a = ‘a’;
byte b = 1;
System.out.println(a+1);//错误:不兼容的类型:从int转换到short可能会有损失
//编译器不知道这个加法最后的结果是多少。只知道是int类型。
short c = (short)(a +b);。
int a = 1;
short b =a;
system.out.println(x);//不可以，编译器只知道a是int类型，不知道a中存储的是哪个值。
```

**6.多种数据类型做混合运算时，最终结果时最大容量对于的类型**

```java
long a = 10L;
char b = 'a';
short c = 100;
int d = 30;
System.out.println(a+b+c+d); //237

int x = a+b+c+d;
System.out.println(x); // 错误: 不兼容的类型: 从long转换到int可能会有损失

int x = (int)(a+b+c+d);
System.out.println(x); //237

```

### 精度损失的原理

long类型100L: 00000000 00000000 00000000 00000000 00000000 00000000 00000000 01100100

转换从int类型，会将前面的4个字节砍掉： 00000000 00000000 00000000 01100100

```java
byte c = (byte)300; //300这个int类型对应的二进制:00000000 00000000 00000001 00101100
System.out.println(c);//byte占用1个字节，砍掉前3个字节，结果是:00101100 (44)

```

**计算机存储时二进制补码，补码 = 反码+1**

### char的类型转换

1. 当一个整数赋值给char类型变量的时候，会自动转换成char字符型，最终的结果是一个字符
2. 当一个整数没有超出byte、short、char的取值范围时，这个整数可以直接赋值过去

### 浮点型的类型转换

Java规定，任何一个浮点型数据**默认被当成double**来处理，如果向被当成float可以加上F/f

​	1.0	默认double

​	1.0F	这才是float类型

```java
float e = 3.14;
System.out.println(e); //错误: 不兼容的类型: 从double转换到float可能会有损失
float e = 3.14f;
System.out.println(e); //3.14
float e = (float)3.14;
System.out.println(e); //3.14  会有精度损失
```
### 不一定时精确

```java
int temp = 10/3;

System.out.println(temp); //3    Java规定，int类型和int类型的结果还是int类型

int temp1 =1/2;

System.out.println(temp1);//0
```

## 九、运算符

### 算数运算符

### 关系运算符 

**所有关系运算符的运算结果都是布尔类型**

### 逻辑运算符

&	逻辑与（并且）

|	逻辑或（或者）

！	逻辑非（取反）

&&	短路与

||	短路或

#### 短路与&& 和逻辑& 有什么区别

首先着两个运算符的运算结果没有任何区别，完全相同。

只不过前者会发生**短路现象**

##### 短路现象

使用短路与&&的时候，当左边的表达式为false的时候，右边的表达式不执行，这种现象被称为短路。

使用短路或||的时候，当左边的表达式为true的时候，右边的表达式不执行，这种现象被称为短路。

```java
int x = 10;
int y = 11;
System.out.println(x>y & x>y++); //false
System.out.println(y) // 12 通过这个测试，我们得知x>y++执行了

int m = 10;
int n = 11;
System.out.println(m>n && m>n++); //false
System.out.println(n) // 11  通过这个测试，我们得知x>y++没执行
```



#### 非常重要

**逻辑元素符两个要求都是布尔类型，并且最终运算结果也是布尔类型。**

```Java
100 & true //不行，语法错误
100 & 200  //不行，没有这种语法
true & false //可以
```

### 赋值运算符

使用扩展运算符时+=，不会改变运算结果类型

```Java
i += 10和i = i +10真的是完全一样吗? 不一样，并不完全相同

byte x = 100;

x  = x +1; ////错误:不兼容的类型:从int转换到byte可能会有损失

x +=1; //可以 相当于 x = (byte)(x+1) 强转会损失精度
```

### 三目运算符

### 字符串连接运算符

#### +号在Java中的作用

1.求和 ：当＋运算符两边都是数字类型的时候

2.字符串拼接：＋运算符两边的"任意一边“是字符串，结果是字符串

**遵循自左向右的原则，依次执行**

```Java
int x = 10;
int a = x+x++;
System.out.println(a); //20
System.out.println(x); //11
int b = x+++x;
System.out.println(b); //23
System.out.println(x); //12
int c = x+x--; 
System.out.println(c); //24
System.out.println(x); //11
int d = x + --x;
System.out.println(d); //21
System.out.println(x); //10
```
## 十、输入

```java
java.util.Scanner s = new java.util.Scanner(System.in);//创建一个键盘扫描器对象 

int i = s.nextInt();//接受用户的输入,从键盘上接受一个int类型的数据
String str = s.next()//接受用户的输入,从键盘上接受一个的数据
```

另一种写法

```java
import java.util.Scanner;
.....
Scanner i = new Scanner(System.in);
```

## 十一、控制语句

分类：

1. **选择语句**if..else
2. **循环语句**for、while、do...while
3. **转向语句**break、continue、return

### 选择语句

#### if...else

if和else if括号里面一定得是布尔语句，值必须是布尔类型，int类型的会报错

```java
if(布尔表达式){
	//java语句
}else{
    //java语句
}
```

if条件语句的大括号省略 相当于自动加了一个 { } 但是必须只能用于**一条语句**

```java
if(sex)
	System.out.println("男");
else
	System.out.println("女");
```

##### 简化改进操作

**流沙式条件，逐步递进，减少条件限制**

```java
//原始操作
if(age<0&&age>=150)
    System.out.println("对不起,年龄值不合法");
else if(age>=0&&age<=5)
    System.out.println("婴幼儿");
else if(age>6&&age<=10)
    System.out.println("少儿");
else if(age>11&&age<=18)
    System.out.println("少年");
else if(age>19&&age<=35)
    System.out.println("青年");
else if(age>35&&age<=55)
    System.out.println("中年");
else
    System.out.println("老年");

//简化操作 -1
if(age<0||age>=150)
    System.out.println("对不起,年龄值不合法");
else if(age<=5)
    System.out.println("婴幼儿");
else if(age<=10)
    System.out.println("少儿");
else if(age<=18)
    System.out.println("少年");
else if(age<=35)
    System.out.println("青年");
else if(age<=55)
    System.out.println("中年");
else
    System.out.println("老年");

//简化操作 -2
String ages = "";
if(age<0||age>=150)
    ages="对不起,年龄值不合法";
else if(age<=5)
    ages="婴幼儿";
else if(age<=10)
    ages="少儿";
else if(age<=18)
    ages="少年";
else if(age<=35)
    ages="青年";
else if(age<=55)
    ages="中年";
else
    ages="老年";
System.out.println(ages);
```

#### switch语句

switch可以叫做选择语句，也可以叫做分支语句

switch(值){

case 值1：

​	java语句；

​	break；

case 值2：

​	java语句；

​	break；

default:

​	java语句；

}

**以上是一个完整的switch语句：其中break并不是必须的，default也不是必须的**

switch支持的值有哪些：**int类型**和**String类型**（JDK8支持不支持String类型），short、byte、long会自动进行类型转换

**当case语句都不满足时，执行default语句**

##### 合并

```java
case 值1:case 值2:case 值3:
```

##### 执行原理

拿值与值1进行比较，如果相同，则执行该分支的Java语句，然后遇到break语句，swtich语句就结束了，如果没有break，就会出现穿透现象

### 循环语句

#### for循环

#####  语法机制

for(初始化表达式：条件表达式：更新表达式){

​	java语句循环体；

}

初始表达式最先执行，且只执行一次

条件表达式必须是一个布尔类型，true或false

#### while循环

#####  语法机制

while(布尔表达式){

​	循环体;

}

##### 执行原理

判断布尔表达式的结果，如果为true就执行循环体，循环体结束之后，再次判断布尔表达式的结果，如果
还是true，继续执行循坏体，直到布尔表这式结果为false，while循环结束

本质上，与for循环执行原理相同

#### do...while循环

#####  语法机制

do{

​	循环体;

}while();

注意别漏掉分号;

##### 执行原理

先执行循环体当中的代码，执行一次循环体之后，判断布尔表达式的结果，如果为true，则继续执行
循环体，如果为false循环结束

对于do..while循环来说，循环体至少执行1次。循环体的执行次数是:1~n次

对于while循坏来说，循坏体执行次数是:0~n次

#### foreach增强for循环

#####  语法机制

do{元素类型 变量名 ：数组或集合}{

​	循环体;

}

有一个缺点就是没有下标

```java
//遍历数组
int []arrs ={1,2,3,4,5,6};
for (int key:arrs) {
    System.out.println(key);
}
//遍历集合
List<String> list= new ArrayList<>();
list.add("abc");
list.add("def");
list.add("hgb");
for (String s: list) { //因为泛型是String
    System.out.println(s);
}
```

### 转向语句

#### break

一个单词成为一个完整的java语句。continue也是这样

第一个位置: switch语句当中，用来终止switch语句的执行

第二个位置: break;语句用在循环语句当中，用来终止循坏的执行

**会让离它最近的循环终止，不是针对if语句的**

##### 终止指定外层循环

```java
a:for(int i = 0;i<5;i++){
    b:for(int j = 0;j<5;j++){
        System.out.println(i*j);
        if(i==3){
            break a;
        }
    }			
}
```

#### continue

终止当前"本次"循环，直接进入下一次循环继续执行。

当continue语句执行时，continue下面的代码不执行，更新表达式。

## 十二、方法



### 语法机制

**[修饰符列表]	返回值类型 方法名	(实行参数列表)	{**

​	**方法体；**

**}**

**注意：**

[]符号叫做中括号，以上中括号的内容不是必须的，可选

方法体由Java语句构成

1. 关于修饰符列表

   修饰符列表不是必选项，是可选的。统一写成：public  static

2. 返回值类型返回值类型可以是任何类型，只要是java中合法的数据类型就行，数据类型包括基本数据类型和引用数据类型，也就是说返回值类型可以是:byte short int long float double boolean char String

3. 如果返回值类型"不是void”，那么你在方法体执行结束的时候**必须使用"return值**;"这样的语句来完成"值”的返回，如果没有"return值;"这样的语句那么编译器会报错。

4. 只要有"return"关键字的语句执行，**当前方法**必然结束。

5. 形式参数列表中每一个参数都是**局部变量**，方法结束内存释放

6. 返回类型不是void  **必须是100%的return语句**，在if语句中不行的，会报错，除非有else里也有return

**调用**：类名.方法名(实际参数列表)

**方法名要注意首单词字母小写，后面单词首字母大写**

方法有static,这种方法被称为：**静态方法**

​	**类名.方法名（）；**

方法没有static,这种方法被称为：**实例方法**

需要先new一个对象，再用对象调用这个方法：**对象.方法名（）；**

#### return和break的区别

**return** ：终止当前最近的方法

**break**：终止当前switch和循环

#### 执行时内存变化

方法只有调用的时候才会在栈内**分配空间**，并且调用就是**压栈**

方法执行结束之后，该方法所需要的**空间就会释放**，此时发生**出栈**

所以调用方法所传的参数和方法内用的参数并不在同一个内存

栈中存储

### 重载机制

使用重载机制，可以使功能相似的方法同名，更易于以后的代码编写

**如果方法名相同的情况下，编译器会通过方法的参数类型进行方法的区分**

```java
public static void mian(String[] args){
    sum(1,2);    //int求和
    sum(1L,2L);  //long求和
    sum(1.0,2.0);//double求和
}
public static int sum(int a,int b){
    System.out.println(“int求和”);
    return a+b;
}
public static int sum(long a,long b){
    System.out.println(“int求和”);
    return a+b;
}
public static int sum(double a,double b){
    System.out.println(“int求和”);
    return a+b;
}
```

这样代码既美观，又便于后期代码编写

注意：代码功能必须相似

#### 发生条件

1. 同一类中
2. 方法名相同
3. 参数列表不同 （个数、类型、顺序）

与返回值类型无关，主要看方法名和形参

```java
public static int sum(){
   return 1;
}
public static long sum(){
    return 1L;
}
// 错误: 已在类 MethodTest1中定义了方法 sum()
```

#### 参数传递

java中规定:参数传递的时候，和类型无关，不管是基本数据类型还是引用数据类型
统一都是将盒子中保存的那个“值”复制一份，传递下去。

**也就是说，传过去只是值，不是内存啥的，源数据不会改变**

## 十三、面向对象

### 面向过程、对象的区别

**从语言角度**

1. 对于C语言来说，是完全面向过程的
2. 对于C++来说，是一半面向过程，一般面向对象
3. 对于Java来说，是完全面向对象

**面向过程的开发方式**

主要特点：注重步骤，注重的是实现这个功能的步骤、实现功能的因果关系。没有对象的概念

缺点：面向过程最主要是每一步与每一步的因果关系，其中A步骤因果关系到B步骤，A和B联合起来形成一个子模块，子模块和子模块之间文因为因果关系结合在一起，假设其中任何一个因果关系出现问题（错误），此时整个系统的运转都会出现向题。(代码和代码之间的耦合度太高，扩展力太差。）

耦合度与扩展力成反比

优点：对于小型项目，采用面向过程的方式进行开发，效率教高，不需要前期进行对象的提取，模型的建立

**面向对象的开发方式**

更符合人类的思维方式，耦合度低，扩展力强

### 术语

**OOA**:	面向对象分析

**OOD**:	面向对象设计

**OOP**:	面向对象编程

整个软件开发过程中，都是采用oo进行贯穿的

实现一个软件的过程：

​		分析（A）---> 设计（D）---->编程（P）

### 类和对象的概念

类：实际上不存在，抽象的概念

对象：实际存在的个体

**类的语法格式**

[修饰符列表] class 类名{

​	//类体 = 属性+方法

​	//属性子在代码上以“变量”形式存在，也就是成员变量

​	//方法描述动作和行为

}

### 三大特征

**封装、继承、多态**

#### 封装

**优点**

保证内部结构的安全

屏蔽复杂，暴露简单

在代码级别上，调用代码人员不需要关心代码的复杂实现，只需要通过一个简单的入口就可以访问。另外，类体中安全级别高的数据封装起来，外部人员不可随意访问，来保证数据的安全性

**怎么实现**

1. 属性私有化（使用private关键字进行修饰）
2. 对外提供简单的操作入口，set、get

#### 继承

基本作用：子类继承父类，代码可以得到复用

重要作用：有了继承，才有了方法的覆盖和多态

##### 相关特性

1. B类继承A类，则称A类为超类、父类、基类，B类称为子类、派生类、扩展类
2. Java只支持单继承，不支持多继承（C++支持），可以有间接继承
3. Java中规定，子类继承父类，除**构造方法**不能被继承均可被继承。但是私有的属性无法**直接**在子类访问，可以通过间接的方法
4. Java中类没有显示的继承任何类，则默认继承Object类，也就是Java语言的**根**类

```java
public class ClassExtendTest
{
	public static void main(String[] args){
		Account act = new Account("1",1.0);
		System.out.println(act.getActno());
		System.out.println(act.getBalance());
		
		CreditAccount acts = new CreditAccount();
		acts.setActno("2");
		acts.setBalance(2.0);
		System.out.println(acts.getActno());
		System.out.println(acts.getBalance()); 
	}
}
class Account  //父类
{	
	private String actno;
	private double balance;

	//构造方法
	public Account(){
	}
	public Account(String actno,double balance){
		this.actno = actno;
		this.balance = balance;
	}
	//实例方法
	public void setActno(String actno){
		this.actno = actno;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public String getActno(){
		return this.actno;
	}
	public double getBalance(){
		return this.balance;
	}
}
class CreditAccount extends Account//子类
{
//	private String actno;
//	private double balance;  继承父类 不需要再单独申明	
}
```

#### 多态

**优点**：降低程序耦合度，提高程序扩展力

**父类型的引用 指向子类型的对象**

编译阶段（**绑定父类方法**）：对于编译器来说，编译器只知道c的类型是Animal，所有编译器在检查语法的时候，会去Animal.class字节码文件中去找move（）方法，找到了绑定move（）方法，编译通过，静态绑定成功！

运行阶段（**动态绑定子类型对象的方法**）：运行阶段的时候，实际在堆内存创建的Java对象是Cat对象，所有move的时候，真正参与move对象的是一只猫，运行阶段会动态执行Cat对象的move方法。这是动态绑定！

```java
public class duotai
{
	public static void main(String[] args){
		Animal a = new Animal();
		a.move(); //动物在移动
        
		Animal c = new Cat();
		c.move(); //猫在爬

		Animal d = new Dog();
		d.move(); //狗在跑
	}
}
class Animal  //父类
{	
	public void move(){
		System.out.println("动物在移动");
	}
}
class Cat extends Animal//子类
{
	public void move(){
		System.out.println("猫在爬");
	}
}
class Dog extends Animal//子类
{
	public void move(){
		System.out.println("狗在跑");
	}
}
```

**向上转型**

​		子---------------》父    自动转

**向下转型**

​		父---------------》子  强转

**如果你想访问的方法是子类特有的方法，需要向下转型，负责报错找不到该方法**

```java
Animal d = new Dog();
d.shit(); //找不到符号
Dog x = (Dog)d; //qian
d.shit()  //狗在叫
```

##### **避免ClassCastExceptio异常的发生**

**instanceof**

1. instanceof可以在运行阶段动态判断引用指向的对象的类型
2. instanceof运算结果只能是布尔类型



### static关键字

所有static关键字修饰的都是类相关的，类级别的

都采用“类名 . ”的方式访问

修饰静态变量，修饰静态方法

空指针对象可以调用静态变量

#### 静态代码块

**语法：**

static{

 	java语句；

}

static可以定义静态代码块，**类加载时执行，并且只执行一次**。静态代码块有这样的特征。

```java
public class Person2
{
	static{
		System.out.println("一个类可以有多个代码块，但都只执行一次");
	}
	static{
		System.out.println("静态代码块在类加载时执行，自上而下");
	}
	//入口
	public static void main(String[] args){
		System.out.println("main函数");
	}
	static{
		System.out.println("并且在main方法之前执行");
	}
	//一个类可以有多个代码块,但都只执行一次
	//静态代码块在类加载时执行，自上而下
	//并且在main方法之前执行
	//main函数
}

```

#### 静态代码块执行顺序

```java
public class Person2
{
    static int j = 0;
	static{
		System.out.println(j); //可以打印，都是静态，都是在类加载时执行
	}
    
    static{
		System.out.println(k); //报错，非法前向引用
	} 
    static int k = 0;
    
    int i = 0;
    static{
    	System.out.println(i);//报错，静态代码块在类加载时执行，此时i的变量空间还没开
    }
    public static void main(String[] args){
    
    }
}
```

#### 实例代码块

**构造方法执行一次，实例方法块就执行一次，且在这之前**

```java
public class Person3
{
	//入口
	public static void main(String[] args){
		new Person3();
		new Person3(3);
	}	
	//实例代码块
	{	
		System.out.println("实例代码块");
	}
	public Person3(){
		System.out.println("无参数构造方法");
	}
	public Person3(int i){
		System.out.println("有参数构造方法"+i);
	}
	//实例代码块
    //无参数构造方法
    //实例代码块
    //有参数构造方法3
}
```

#### 实例对象、实例方法、实例变量

关键在于static有没有加

```java
class User{
    int age;//这是实例变量
    static int sex; //这是静态变量
	public static void getAge(){ //这是静态方法
        //
    }
    public  void getSex(){ //这是实例方法
        //
    }
}
User u1 = new User(); 
u1.getAge();//对象可以调用静态方法 ✔
User.getAge();//类可以调用静态方法 ✔
u1.getSex();//对象可以调用实例方法 ✔
User.getSex();//类不可以调用实例方法 ×

u1.age();//对象可以调用实例变量 ✔
User.age();//类不可以调用实例变量 ×
u1.sex();//对象可以调用静态变量 ✔
User.sex();//类可以调用静态变量 ✔

切记 静态方法不可调用实例变量！！！！！！！！ 访问实例变量的方法一定只能是实例方法
```

### 方法覆盖

子类继承父类时，当继承过来的方法无法满足当前子类业务时，子类有权利进行重新编写，即"方法覆盖"

方法覆盖又称方法重写，Ove·rride，**和方法重载不同！！！**

```java
public class OverrideTest 
{
	public static void main(String[] args) 
	{
		Cat c = new Cat();
		c.move();
	}
}

class Animals
{
	public void move(){
		System.out.println("动物在移动");
	}
}
class Cat extends Animals
{
	public void move(){
		System.out.println("猫在爬");
	}
}
```

**覆盖之后，一定调用覆盖之后的方法！**

要求：

1. 之间要有继承关系
2. 重写与之前的方法之间具有： **相同的返回值类型、相同方法名、相同的形式参数列表**
3. 访问权限不能更低，只能更高（protected 方法不能覆盖public 方法）
4. 重写方法不能比原先方法抛出更多异常
5. **构造方法和私有方法**不能被覆盖 静态方法也不存在覆盖
6. 基本数据类型的返回值类型必须一致，但是引用数据类型可以（大变小可以，但小变大不行）



### ※※创建对象的JVM内存结构※※

![4](F:\Typora\代码笔记\4.png)

**对象**：通过new出来的，在堆内存中存储

**引用**：但凡是变量，并且该变量中保存了内存地址指向了堆内存当中的对象的

**静态变量存储在方法区 **

  静态变量在类加载时初始化，不需要new对象，静态变量空间就开始出来了

**实例变量存储在堆内存**

**局部变量存储在栈中**

### 构造方法

#### 定义

通过构造的方法完成对象的创建，以及实例变量的初始化

当一个类没有提供任何构造方法，系统回默认提供一个无参数的构造方法，这种构造方法被称为**缺省构造器**

当一个类中提供构造方法，系统将不会提供无参数构造方法     

#### 语法结构

**普通方法的语法结构**

[修饰符列表] 返回值类型 方法名（形式参数列表）{

​		方法体;

}

**构造方法的语法结构**

[修饰符列表] 构造方法名（形式参数列表）{

​		构造方法体

}

**注意：**

1. 修饰符列表目前统一写：public，**不要写public static**
2. 构造方法名和类名必须一致
3. 构造方法不需要指定返回类型，也不能写void

## 十三、this、super关键字

### this关键字

一个对象一个this

1. **this是一个关键字，是一个引用，保存内存地址指向自身**
2. **this可以使用在实例方法中，也可以使用在构造方法中**
3. **this出现在实例方法中其实代表的是当前对象**
4. **this不能使用静态方法**
5. **this. 大多情况可以省略，但是用来区分局部变量和实例变量的时候不能省略**
6. **this（）这种语法只能出现在构造方法的第一行**
7. **在实例方法中，调用实例变量可省略this.  在main中调用实例变量，不可省略this.** 也不可用this！！

#### 代码复用 this()

this除了调用对象，还可以用作调用构造函数-----**this(.....)**   》》

```java
public class  Man
{
	int id;
	String name;
	
	public Man(){
		//this.id =2;
		//this.name = "刘强";
		this(2,"刘强"); //代码复用,只能是第一行
	}
	public Man(int id,String name){
		this.id =id;
		this.name = name;
	}
	public static void main(String[] args) 
	{
		Man n = new Man();
		System.out.println(n.id);
		System.out.println(n.name);
	}
}

```



#### this的内存地址图

![5](F:\Typora\代码笔记\5.png)

### super关键字

super(）**只能出现在构造方法第一行**，通过当前的构造方法去调用父类中的构造方法，

**目的**:创建子类对象的时候，先初始化父类型特征。

super关键字代表的时当前对象的部分父类型特征

System.out.println(this)可以输出当前对象的toString方法;

System.out.println(super)报错，**super不可单独使用**

```java
class superTest 
{
	public static void main(String[] args) 
	{
		new B();
	}
}

class A
{
//	public A(){
//		System.out.println("A的无参构造方法");
//	}
	public A(int i){
		System.out.println("A的无参构造方法"+i);   
	}
}

class B extends A
{
	public B(){
        //super()   //默认存在的
		super(1);	//当子类继承父类时，子类的构造函数里面有一个默认super()会调用父类的构造函数
		System.out.println("B的无参构造方法");
	}
}

//当一个构造函数没有提供super(),this()时，默认提供super()!!!!!

//如果手动提供一个带参的构造函数，默认super()调用没有代参，执行会报错
```

小练习--判断输出结果

```java
public class superTest2
{
	public static void main(String[] args) 
	{
		new C();
	}
}

class A
{
	public A(){
		System.out.println("1");
	}
}
class B extends A
{
	public B(){
		System.out.println("2");
	}
	public B(int i){
		System.out.println("3");
	}
}
class C extends B
{
	public C(){
		this(1);
		System.out.println("4");
	}
	public C(int i){
		this(1,2);
		System.out.println("5");
	}
	public C(int i,int j){
		super(1);
		System.out.println("6");
	}
}


//13654
```

#### super内存图

![](F:\Typora\代码笔记\6.png)

### super与this的对比

|                                |                 this                  |                            super                             |
| :----------------------------- | :-----------------------------------: | :----------------------------------------------------------: |
| 能否出现在实例方法和构造方法中 |                   ✔                   |                              ✔                               |
| 语法                           |            this.  、this()            |                      super.  、super()                       |
| 能否出现在静态方法中           |                   ❌                   |                              ❌                               |
| 可以省略么                     |         this.大多情况可以省略         |                    super.大多情况可以省略                    |
| 什么时候不能省略               |    区分局部变量和实例变量不能省略     | 当子类和父类都用同名属性时，this指向当前对象属性，super指向父类对象的属性 |
| 第一行要求                     | this()构造器第一行，与super()不能共存 |            super()构造器第一行，与this()不能共存             |
| 单独使用println()              |                   ✔                   |                              ❌                               |



## 十四、JVM

JVM主要三块内存空间：**栈、堆、方法区**

![+](F:\Typora\代码笔记\3.png)



# Java进阶代码笔记



## 一、final关键字

final关键字标识最终的，不可变的

final修饰变量以及方法、类

```java
final class A{

}
class B extends A{
							//报错1，final修饰的类无法再继承
}

	
class C{				
    public final void doSome(){
        System.out.printf("C");
    }
}
class D extends C{
    public void doSome(){  //报错2'doSome()' cannot override 'doSome()' in 'C'; overridden method is final
        System.out.printf("D");
    }
}

final int s= 1;
s =3; 	//错误3:(4, 9) java: 无法为最终变量a分配值


final Person p  = new Person();
p = new Person();			//错误4:(4, 9) java: 无法为最终引用变量p分配值

static int s =1;
Person.s = 2;				//错误4:(4, 9) java: 无法为最终静态变量p分配值
```

final修饰的**引用变量**：

​	该引用只能指向1个对象，并且他只能永远指向该对象，无法在指向其他对象。并且在该方法执行过程中，该引用指向对象之后，该对象**不会被垃圾回收器回收**。直到**当前方法结束**，才会释放空间。但是**该对象内部的数据**可以被修改！！！！！

final修饰的**实例变量**：

​	系统不管赋默认值，要求程序员手动赋值。但是在构造方法中赋值的时候，可以。因为只赋值一次，赶在系统赋默认值之前就可以。

**final修饰的变量一般添加static修饰！**  变为静态的，存储在方法区。

**static final** 修饰的变量称为“常量”，并且都是在类加载时初始化，存储在方法区！



**总结**

​	1.1、final修饰的类无法继承。

​	1.2、final修饰的方法无法覆盖-

​	1.3、final修饰的变量只能赋一次值-

​	1.4、final修饰的引用一旦指向某个对象，则不能再重新指向其它对象，但该引用
指向的对象内部的薮据是可以修改的。

​	1.5、final修饰的实例变量必须手动初始化，不能采用系统默认值。

​	1.6、final修饰的实例变量一般和static联合使用，称为常量。

## 二、抽象类和接口

### 抽象类

类和类之间有共同特征，将这些具有共同特性的类再进一步抽象形成了抽象类，由于类本身是不存在的，所以抽象类无法实例化，无法创建对象。半抽象

**抽象类也属于引用数据类型**

语法：

​	[修饰符列表] **abstract** class 类名{

​	

​	}

**tips：**

虽然抽象类不可实例化对象，但是可以通过继承的子类调用构造函数！**super()!!!!**

#### 抽象方法

没有方法体，以分号结尾。

**抽象类中不一定有抽象方法，但抽象方法只能出现在抽象类中**

```java
abstract class  Animal
{
	public Animal(){
		System.out.println(123);
	}
	public abstract void move();
}
-----------------------------------------
Animal s = new Bird();
s.move();                //可以使用多态

class  Bird extends Animal
{
	public void move(){
		System.out.println("鸟在移动");		 
        //不重写就调用的话会错误: Bird不是抽象的, 并且未覆盖Animal中的抽象方法move()
	}
}
```

子类想调用父类的抽象方法时，需要将父类的方法覆盖掉（俗称，对抽象的实现），不然报错

** **一个非抽象类继承抽象类，必须将抽象类中的抽象方法实现了！！** **

### 接口

接口也是一种引用数据类型，**可以多继承**，是完全抽象的，可以说是特殊的抽象类

[修饰符列表] interface 接口名{ }

接口只包含两内容：常量（public static final 都可省略）、抽象方法（public abstract 都可省略）

接口中的方法都是抽象方法，故不**能有方法体**，不能加 {  }

接口所有元素都是公开的

类和类之间叫**继承**，使用**extends**

类和接口之间叫**实现**，使用**implements**

⭐⭐一个类可以实现多个接口，一个接口可以继承多个接口⭐⭐

```java
A a = new duojiekou(); //ok
a.m1();
interface A
{
	void m1();
}
interface B
{
	void m2();
}

class duojiekou implements A,B
{
	public void m1(){
	
	};
	public void m2(){	//不写方法会报错：duojiekou不是抽象的, 并且未覆盖A中的抽象方法m1()
	};
}
```

经过测试：接口与接口之间进行强制类型转换的时候，没有继承关系，也可以强转。但是一定要注意，运行时可能会出现ClassCastException异常

之前结论：继承类之间强转 不适用于接口

```java
A a = new duojiekou(); //ok
B b = (B)a;
b.m2();

interface A
{
	void m1();
}
interface B
{
	void m2();
}

class duojiekou implements A,B
{
	public void m1(){
	
	};
	public void m2(){
	};
}
```

#### extends和implements

```java
Flyable f = new Cat();
f.fly();			//插上了飞的接口

class Animal
{
}
interface Flyable
{
	void fly();
}

class Cat extends Animal implements Flyable
{
	public void fly(){
		System.out.println("插上了飞的接口");
	};
}
```

#### 接口在开发中的作用

类似于多态在开发中的作用

多态：面向抽象编程，不要面向具体编程。降低程序的耦合度，提高程序的扩展力

```java
public class Master{
	public void feed(Dog d){}
	public void feed(cat c){}
	//假设又要养其它的宠物，那么这个时候需要再加1个方法。（需要修改代码了)这样扩展力太差了，违背了OCP原则（对扩展开放，对修改关闭)
}

public class Master{
	public void feed(Animal a){
     //面向Animal父类编程，父类是比子类更抽象的。所以我们叫做面向抽象编程，不要面向具体编程。这样程序的扩展力就强。
    }
}


```

接口：完全抽象，面向抽象编程可以变为面向接口编程

可插拔表示扩展力很强，低耦合度

### 抽象类与接口的区别

1. 抽象类是半抽象的，接口是完全抽象的
2. 抽象类中有构造方法，接口中没有构造方法
3. 抽象类之间只支持单继承，接口与接口之间支持多继承
4. 抽象类只能由一个类继承，一个类可以同时实现多个接口

## 包机制

### package

Java中的包机制，是为了方便程序的管理，不同功能的类分别存放在不同的包下

package是一个关键字，后面加包名，如 package com.ssss.javase.charpter17 

注意：package语句只允许出现在Java源代码的第一行

命名规范 ：公司域名倒叙 +项目名+模块名+功能名

```java
java -d . HelloWorld.java
//javac 负责编译的命令
//-d 带包编译
//. 代表编译之后生成的东西放到当前目录下（.代表当前目录）
java com.qiangliu8.HelloWorld
```

### import

A类中使用B类，不在同一个包下，使用import

java.lang 底下文件不需要引入~~

```java
package XXXXX
import com.XXX.XXX.类名  //只能写在package的下面
import com.XXX.XXX.*	//引入包下所有类
```

## 访问控制修饰符

| 访问控制修饰符 | 本类 | 同包 | 子类 | 任意位置 |
| :------------: | :--: | :--: | :--: | :------: |
|     public     |  √   |  √   |  √   |    √     |
|    private     |  √   |  √   |  √   |    ❌     |
|   protected    |  √   |  √   |  √   |    ❌     |
|      默认      |  √   |  √   |  √   |    √     |



## 三、Object类

API  应用编程接口

### toString()

```java
public String toString() {
	return getClass().getName() + "@" + Integer.toHexString(hashCode());
}

```

通过调用该方法将一个Java对象转换成字符串的表示形式

```java
public class Test3
{
	public static void main(String[] args){
		User u = new User("小强");
		System.out.println(u);
	}
}

class User
{
	String name;
	public User(){
		
	}
	public  User(String name){
		this.name = name;
	}
	public String toString(){
		return this.name+"调用了toString方法！";
	}
} 

```

一般调用该对象，默认调用toString 方法，sun公司建议重写，并且按原格式重新写！！

### equals()

判断两java个对象是否相等 

```java
public boolean equals( Object obj){
	return (this == obj);
}

int no;
String school;
public boolean equals(Object obj){
    if(!(obj instanceof Student)||obj ==null) return false;
    if(this == obj) return true;
    Student s = (Student)obj;
    if(this.no == s.no&&this.school.equals(s.school)) return true;
    return false;
}
```

equals中，默认采用的是==判断两个Java对象是否相等。而==比较的是指向不同的内存地址，我们应该判断两个Java对象的内容是否相等，建议子类重写！并且一定要重写彻底！

String类的toString()和equals()已经重写

Java中所有**基本数据类型**比较是否相等，使用 ==

Java中所有**引用数据类型**统一使用equals()比较是否相等 (包括String类型的属性！！！！)

### finalize()——---已弃用

这个方法是protected修饰的，源代码：

```java
protected void finalize() throws Throwable { }
```

当Java对象即将背垃圾回收时，不需要程序员手动调用，JVM的垃圾回收器负责调用这个方法

### hashCode()

不是抽象方法，带有native关键字，底层调用C++程序

```java
public native int hashCode();
```

hashCode()方法返回的时哈希码：实际上就是一个**Java对象的内存地址**，经过哈希算法，得出一个值。

```java
Object o = new Object();
System.out.println(o.hashCode()); //1848415041
```

## 四、内部类

在类的内部又定义了一个新的类，被称为内部类

**分类**：

​		静态内部类：类似于静态变量

​		实例内部类：类似于实例变量

​		局部内部类：类似于局部变量

```java
public class test1
{
	static class n1   //静态内部类
	{
	}	
	class n2		//实例内部类
	{
		public n2()
		{
			
		}
		class n3	//局部内部类
		{
		}
	}

}
```

### 匿名内部类

接口里的方法不能自己去调用，需要一个类去实现这个接口的方法。

不建议使用，可读性太差

```java 
public class test1
{
	public static void main(String[] args){
		Jisuanqi j = new Jisuanqi();
		j.mysum(new ComputeClass(),1,2);//这是不用匿名内部类  接口需要一个类去下实现
       	j.mysum(new Compute(){
            		public int sum(int x,int y){
						return x+y;
					}
        },1,2); //这是用匿名内部类，相当于一个隐藏的类实现了它
	}
}

interface Compute
{
	int sum(int x,int y);
}

class ComputeClass implements Compute
{
	public int sum(int x,int y){			
		return x+y;
	}
}

class Jisuanqi 
{
	public void mysum(Compute c, int x,int y){
		System.out.println(c.sum(x,y));
	}
}

```

## 五、数组Array类

### 数组概述

1. Java语言中数组是一种引用数据类型，不属于基本数据类型，数组的父类是Object

2. 数组中可以存储基本数据类型的数据，也可以存储引用数据类型的数据

3. 数组因为是引用类型，所以数组对象是在堆内存当中

4. 数组当中如果存储的是Java对象的话，实际上存储的是对象的引用（内存地址）

5. 数组一点创建，长度不可变

6. 数组中的元素内存地址连续

7. ![image-20201021203626759](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201021203626759.png)

   **优点:** 

   查询/查找/检索某个下标上的元素时效率极高。可以说是查询效率最高的一个数据结构。
   	第一:每一个元素的内存地址在空间存储上是连续的。

   ​	第二:每一个元素类型相同，所以占用空间大小一样。

   ​	第三:知道第一个元素内存地址，知道每一个元素占用空间的大小，又知道下标，所以通过一个数学表达式就可以计算出某个下标上元素的内存地址。亘接通过内存地址定位元素，所以数组的检索效率是最高的。
   ​	数组中存储100个元素，或者存储100万个元素，在元素查询/检索方面，效率是相同的，因为数组中元素查找的时候不会一个一个找，是通过数学表达式计算出来的。（算出一个内存地址，疸接定位的。)
   **缺点**:

   ​	第一:由于为了保证数组中每个元素的内存地址连续，所以在数组上随机删除或者增加元素的时候，效率较低，因为随机增副元素会涉及到后面元素统一向前或者向后位移的操作。
   ​	第二:数组不能存储大数据量，为什么?
   因为很难在内存空间上找到一块特别大的连续的内存空间。

### 一维数组

```java
//静态初始化
int []array = {1,2,3,4};
//动态初始化
int []array = new int[5]; //初始化一个5个长度的int类型数组，每个元素默认值0
String []names = new String[6];  //初始化6个长度的String类型数组，每个元素默认值null。
```

**静态传数组方法**

```java
//特别静态方法 不需要要new对象
printArrays(new int[]{1,2,3,4,5});
public  static void printArrays(int[] arrays){
    for (int i=0;i<arrays.length;i++){
    	System.out.println(arrays[1]);
    }
}
```

**main方法的String数组**

```java
public static void main(String[] args) {
    System.out.println(args);	//[Ljava.lang.String;@5fd0d5ae
    System.out.println(args.length);//0
}
```

这个数组是留给用户的，用户可以在控制台上输入参数，这个参数自动转换成String[] args

例如运行程序 Java ArrayTest abc def xyz

JVM之后会自动将abc def xyz通过空格的方式进行分离，分离完成之后，自动放到String[] args数组之中{“abc”,"def","xyz"}，所以args是用来接受用户参数的

```java
public class ArrayTest1 {
    public static void main(String[] args) {
        System.out.println(args);
        System.out.println(args.length);
        printStrings(args);
    }
    public  static void printStrings(String[] strs){
        for (int i=0;i<strs.length;i++){
            System.out.println(strs[i]);
        }
    }
}

```

![image-20201023100815698](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201023100815698.png)

一般进行判断时

```java
usrename.equals("admin")&&password.equals("password")
"admin".equals(usrename)&&"password".equals(password)//避免空指针异常
```

**多态在数组中的应用**

```java
public class ArrayTest3 {
    public static void main(String[] args) {
        Animals []an1 = new Animals[2];
        an1[0] =  new Cat();
        an1[1] =  new Dog();
        for (int i = 0;i<an1.length;i++){
            an1[i].move();
        }
    }
}
class Animals{
    public void move(){
        System.out.println("动物在移动！");
    }
}
class Dog extends Animals{
    public void move(){
        System.out.println("狗在移动！");
    }
}
class Cat extends Animals{
    public void move(){
        System.out.println("猫在移动！");
    }
}
//猫在移动！
//狗在移动！
```

**数组扩容**

数组拷贝arraycopy()源码：

```java
@HotSpotIntrinsicCandidate
public static native void arraycopy(Object src,  int  srcPos,
                                    Object dest, int destPos,
									int length);
//src原数组，srcPos原数组起始位置
//dest扩容后的数组，destPos扩容数组的起始位置 
//复制的长度
```

```java
int []src = {1,2,3,4,5};
int []kuorong = new int[10];
System.arraycopy(src,1,kuorong,3,2); 0 0 0 2 3 0 0 0 0 0 
```

注意 引用数据对象的扩容数组存的还是对象内存地址

### 二维数组

**静态初始化**

[][]

```java
int [][]a = {
		{1,2,3,4},
		{1,2,3,4},
		{1,2,3,4},
		{0}
}
```

**动态初始化**

```java
int [][]aa = new int[3][4]
//二维数组遍历
for (int i = 0;i<aa.length;i++){
  for (int j= 0;j<aa[i].length;j++){
    System.out.println(aa[i][j]);
  }
}    
```

### 数据结构算法

#### 冒泡排序

```java
public static void maopao(int[]arrys,int n){
	int temp;
	boolean flag;
	for (int i = n-1; i > 0; i--) {
		flag = true;
		for (int j = 0; j < i ; j++) {
			if (arrys[j]>arrys[j+1]){
				temp = arrys[j];
				arrys[j] = arrys[i];
				arrys[i] = temp;
				flag = false;
			}
		}
		if ( flag ) return ;
	}
}
```

#### 简单选择排序

```java
public static void selectSort(int[]arrys,int n){
    int temp,k;
    for (int i = 0; i <n-1; i++) {
        k = i;
        for (int j = i+1; j <=n-1 ; j++) {
            if(arrys[j]<arrys[k]) k =j;
        }
        temp = arrys[k];
        arrys[k] =  arrys[i];
        arrys[i] =  temp;
    }
}
```

#### 二分查找

```java
public static int erfen(int[]arrys,int key){
    int left = 0,right =arrys.length-1,mid;
    while (left!=right){
        mid = (left+right)/2;
        if (arrys[mid]==key) return mid;
        else if (arrys[mid]>key) right = mid-1;
        else left = mid+1;
    }
    return -1;
}
```

#### Array工具类

java中提供了一个工具类：java.util.Arrays  都是静态方法

```java
//排序数组
public static void sort(int[] a) {
	DualPivotQuicksort.sort(a, 0, 0, a.length);
}
//查找数组
public static int binarySearch(long[] a, long key) {
    return binarySearch0(a, 0, a.length, key);
}
int []a ={12,2,4,12,22,0,-1,9};
Arrays.sort(a);  //-1 0 2 4 9 12 12 22
Arrays.binarySearch(a,0) //1
```

## 六、常用类

### String类

#### String概述

Java JDK中内置的一个类：java.lang.String

String表示字符串，属于引用数据类型，使用“ ”的都是String对象

双引号括起来的字符串，不可修改！！

**凡是双引号括起来的“abc” "def"自动放在方法区的字符串常量池中，生成组合的也是**

```java
String s1 = "abcdef";
String s2 = "abcdef"+"xy";
```

**new String的时候一定是在堆内存中开辟空间**，直接引用常量池的字符串

```java
String s3 = new String("xy")
```

![image-20201024170420817](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201024170420817.png)

#### 案例

```java
public class StringTest1 {
    User u = new User(1,"刘强");
}

class User{
    private int id;
    private String name;
    //.....
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

**JVM内存图**

![image-20201024172725515](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201024172725515.png)

#### String常用构造方法

```Java
//最常用方法
String s1 = "123";

//String(String original) 
//初始化新创建的String对象，使其表示与参数相同的字符序列; 换句话说，新创建的字符串是参数字符串的副本。 
String s6 = new String("hah");
System.out.println(s6);  //hah

//String(byte[] bytes) 
//String(byte[] value, int offset, int count)  offset起始位置，count长度
//通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
byte []b = {97,98,99};
String s2 = new String(b);
String s3 = new String(b,1,2);
System.out.println(s2);  //abc
System.out.println(s3);  //bc

//String(char[] value) 
//String(char[] value, int offset, int count) offset起始位置，count长度
//分配一个新的 String ，以便它表示当前包含在字符数组参数中的字符序列。 
char []c1 = {'我','是','刘','强'};
String s4 = new String(c1);
String s5 = new String(c1,1,2);
System.out.println(s4);  //我是刘强
System.out.println(s5);  //刘强

```

#### String常用方法

##### charAt（）

返回`char`指定索引处的值。  指数范围为`0`至`length() - 1` 。  该序列的第一个`char`值在索引`0` ，下一个索引为`1`  ，依此类推，与数组索引一样。 

```java
public char charAt(int index);
```

```java
char s = "我是刘强".charAt(1);
System.out.println(s); //是
```

##### compareTo（）

按字典顺序比较两个字符串。 比较是基于字符串中每个字符的Unicode值。返回字符串长度的差异(y一个一个比)

```java
public int compareTo(String anotherString)
```

```java
int result1 ="abc".compareTo("def"); //-3
int result2 ="def".compareTo("abc"); //3
int result3 ="xyz".compareTo("yxz"); //-1
int result4 ="xyz".compareTo("xyz"); //0
```

##### contains（）

当且仅当此字符串包含指定的char值序列时才返回true。 

```java
public boolean contains(CharSequence s);
```

```java
boolean result1 ="abc".contains("def"); //false
boolean result2 ="abc".contains("a"); //true
boolean result3 ="abc".contains("ad"); //true
```

##### endsWith() &&startsWith（）

测试此字符串是否以指定的后缀结尾。 

```java
public boolean endsWith(String suffix);
```

```java
boolean result1 ="abc".contains("bc"); //true
boolean result2 ="abc".contains("a"); //false
boolean result3 ="abc".contains("bd"); //false
boolean result4 ="abc".contains("a"); //true
boolean result5 ="abc".contains("abc"); //true
boolean result6 ="abc".contains("bc"); //false
```

##### equals()

将此字符串与指定对象进行比较。  其结果是`true`当且仅当该参数不是`null`并且是`String`对象，表示相同的字符序列作为该对象。 

```java
public boolean equals(Object anObject);
```

```java
"abc".equals("abc"); //true;
"abc".equals("Abc"); //false;
```

##### getBytes()

使用平台的默认字符集将此`String`编码为字节序列，将结果存储到新的字节数组中。

```java
public byte[] getBytes()
```

```java
byte []b = "abc".getBytes();
System.out.println(b[0]);//97
System.out.println(b[1]);//98
System.out.println(b[2]);//99
```

##### indexOf()

返回指定字符第一次出现的字符串内的索引。  如果与值的字符`ch`在此表示的字符序列发生`String`第一事件发生之对象，则索引（在Unicode代码单元）被返回。  对于从0到0xFFFF（含）范围内的`ch`的值，这是最小值*k* ，使得： 

```java
public int indexOf(int ch);
```

```java
System.out.println("sasssabc".indexOf("ab")); //5
```

##### isEmpty()

```
public boolean isEmpty()
```

```java
System.out.println("sasssabc".isEmpty());//false
String s1= "";
System.out.println(s1.isEmpty());//true
"sasssabc".length() //8
"".length() //0
```

##### replace() && replaceAll()

返回从替换所有出现的导致一个字符串`oldChar`在此字符串`newChar` 。 

```java
public String replace(char oldChar,char newChar)
```

```java
System.out.println("http://www.baidu,com".replace("http:","https:"));//https://www.baidu,com
```

##### split()

此方法返回的数组包含此字符串的每个子字符串，该字符串由与给定表达式匹配的另一个子字符串终止，或由字符串结尾终止。

```java
public String[] split(String regex,int limit)
```

```java
String []ss = "我-是-你-大爷".split("-");
for (int i = 0; i <ss.length ; i++) {
    System.out.println(ss[i]);
} 
//我
//是
//你
//大爷
```

##### substring()

返回一个字符串，该字符串是此字符串的子字符串。 子字符串以指定索引处的字符开头，并扩展到该字符串的末尾。 

```java
public String substring(int beginIndex);
public String substring(int beginIndex,int endIndex);
```

```java
System.out.println("我是刘强".substring(2));	//刘强
System.out.println("我是刘强".substring(0,2)); //我是
```

##### toCharArray（）

将此字符串转换为新的字符数组。 

```java
public char[] toCharArray();
```

```java
char []c = "我是刘强".toCharArray();
```

##### toLowerCase() && toUpperCase()

转换成小写、大写

```java
public String toLowerCase();
public String toUpperCase(Locale locale);
```

```java
System.out.println("Ss".toLowerCase()); //ss
System.out.println("ss".toUpperCase()); //SS
```

##### trim()

返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。 

```java
public String trim();
```

```java
 System.out.println(" L i u ".trim()); //Liu
```

##### valueOf()

将非字符串转换成字符串 

```java
public static String valueOf(****)
```

```java
System.out.println(String.valueOf(100)); //"100"
```

这是静态方法，如果用对象去调用那么调用该对象的toString()方法

```java
user u1 = new user();
System.out.println(String.valueOf(u1)); //qiangliu8.String.user@2d98a335
```

```java
class users{
    @Override
    public String toString() {
        return "我是你大爷";
    }
}
users u2 = new users();
System.out.println(String.valueOf(u2)); //我是你大爷
```

### StringBuffer类

实际开发中，如果需要进行字符串拼接，每一次拼接都会产生新的新字符串，这样会占用大量的方法区内存资源，所以需要StringBuffer类

构造函数

```java
//构造一个没有字符的字符串缓冲区，初始容量为16个字符。 
StringBuffer();
//构造一个没有字符的字符串缓冲区和指定的初始容量。 
StringBuffer(int capacity);

```

```java
//创建一个初始化容量为16byte[]数组
StringBuffer strintBuffer = new StringBuffer();
//拼接字符串，以后拼接字符串统一调用append()方法
strintBuffer.append("a");
strintBuffer.append("b");
strintBuffer.append("c");
strintBuffer.append(3.14);
//append方法底层在进行追加的时候如果byte数组满了，会自动扩容
strintBuffer.append(100L);
System.out.println(strintBuffer);//abc3.14100
System.out.println(strintBuffer.toString());//abc3.14100
```

### StringBuilder类

此类提供与`StringBuffer`的API，但**不保证同步**，也可以完成字符串的拼接。此类设计用作简易替换为`StringBuffer`在正在使用由单个线程字符串缓冲区的地方（如通常是这种情况）。  在可能的情况下，建议使用这个类别优先于`StringBuffer` ，因为它在大多数实现中将更快。 

```java
//创建一个初始化容量为16byte[]数组
StringBuilder strintBuffer = new StringBuilder();
//拼接字符串，以后拼接字符串统一调用append()方法
stringBuilder.append("a");
stringBuilder.append("b");
stringBuilder.append("c");
stringBuilder.append(3.14);
//append方法底层在进行追加的时候如果byte数组满了，会自动扩容
stringBuilder.append(100L);
System.out.println(stringBuilder);//abc3.14100
System.out.println(stringBuilder.toString());//abc3.14100
```

### StringBuffer与StringBuilder的区别

**StringBuffer**：都有synchronized修饰，表示StringBuffer在多线程环境运行是安全

**StringBuilder**：都没有synchronized修饰，表示StringBuffer在多线程环境运行是不安全的。

所以，StringBuffer是**线程安全**的，StringBuilder是**非线程安全**的。

### 包装类

8种包装类属于引用数据类型，父类是Object

| 基本数据类型 |      包装类型       |  父类  |
| :----------: | :-----------------: | :----: |
|     byte     |   java.lang.Byte    | Number |
|    short     |   java.lang.Short   | Number |
|     int      |  java.lang.Integer  | Number |
|     long     |   java.lang.Long    | Number |
|    float     |   java.lang.Float   | Number |
|    double    |  java.lang.Double   | Number |
|   boolean    |  java.lang.Boolean  |        |
|     char     | java.lang.Character |        |

#### 封装和拆箱

```java
//包装类实现了由基本数据类型向引用数据类型的转换 
//基本数据类型 --转换--》   引用数据类型 （装箱）
Integer i = new Integer(2); 
//引用数据类型 --转换--》   基本数据类型（拆箱）
System.out.println(i.floatValue()); //2.0
```

Number是一个抽象类，无法实例化对象，类中有以下方法：

`byte byteValue()`  返回指定号码作为值 `byte` 

 `abstract double doubleValue()`  返回指定数字的值为 `double`

`abstract float floatValue()`  返回指定数字的值为 `float` 

 `abstract int intValue()`  返回指定号码作为值 `int` 

`abstract long longValue()`  返回指定数字的值为 `long` 

`short shortValue()`  返回指定号码作为值 `short` 

这些方法其实所有数组包装类的子类都有，这些方法是负责拆箱的

```java
System.out.println(Integer.MAX_VALUE);//2147483647
System.out.println(Integer.MIN_VALUE);//-2147483648
System.out.println(Byte.MAX_VALUE);//127
System.out.println(Byte.MIN_VALUE);//-128
```

#### 自动装箱和自动拆箱

java5之后，引入了的一种新特性, 有了自动功能后，Number的方法就用不着了

**自动装箱**：基本数据类型自动转换成包装类

```java
Integer i = 100; //自动装箱：基本数据类型自动转换成包装类
```

**自动拆箱**：包装类自动转换成基本数据类型

```java
int y = x;
System.out.println(x+1) //没报错？ +号两边要求是基本数据类型的数组，x是包装类，不属于基本数据类型，这里会自动进行拆箱，将x转换成基本数据类型
```

a是一个引用变量，保存的是一个实例化对象的内存地址

```java
Integer a = 1000; //new Integer(1000)
Integer b = 1000; //new Integer(1000)
System.out.println(a==b); //a和b两个引用种保存的对象内存地址不一样 false
```

![image-20201025164905216](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201025164905216.png)

java为了提高程序的执行效率，将-128到127之间所有的包装对象提前创建好，放到了一个方法区的**整数型常量池**当中，不需要再new了，直接取出来

```java
Integer a = 128; 
Integer b = 128; 
System.out.println(a==b); // false
Integer x = 127; 
Integer y = 127; 
System.out.println(a==b); //true
Integer i = new Integer("中文");//Exception in thread "main" java.lang.NumberFormatException: For input string: "中文"
```

#### Integer方法

```java
system.out.println(Integer.parseInt("996"));  //String => int 996

Double.parseDouble("11.0") //String => double 11.00

System.out.println(Integer.toBinaryString(3)); //十进制 =》二进制

Integer i = Integer.valueOf(110); //转成int包装类
Integer i = Integer.valueOf("110");
```

#### int、String 、Integer

![image-20201025210353388](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201025210353388.png)

```java
//String --> int
String s1 = "100";
int i1 = Integer.parseInt(s1);
System.out.println(i1+1);//101
//int --> Sting
String s2 = i1 +"";
System.out.println(s2+1);//1001
//int --> Integer
Integer i2 = 1000;
Integer i3 = Integer.valueOf(1000);
//Integer --> int
int y = i2;
// String --> Integer
Integer i4 =Integer.valueOf("123");
//Integer --> String
String e = String.valueOf(i4);

```

### 日期类

#### Date() &&Date( long date)

```java
import java.text.SimpleDateFormat;
import java.util.Date;
//获取Date对象
Date nowTime = new Date();  //Date的toString 方法已经重写
Date nowTime2 = new Date(1000);  
System.out.println(nowTime); //Mon Oct 26 14:20:43 CST 2020
System.out.println(nowTime2); //Thu Jan 01 08:00:01 CST 1970
```

#### format（）

将Date对象转换成简单的时间String格式

```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
System.out.println(sdf.format(nowTime));  //2020/10/26 14:35:59
```

#### parse（）

将String对象转换成Date类型

```java
String time = "2008/12/09 01:10:25";
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date d = sdf.parse(time);
System.out.println(d); //Tue Dec 09 01:10:25 CST 2008
```

#### currentTimeMillis()

从1970.1.1到现在的总毫秒数

```java
long timemills = System.currentTimeMillis();
System.out.println(timemills);  //1603695598507
```

统计一个方法执行速度

```java
long begin = System.currentTimeMillis();
print();
long end = System.currentTimeMillis();
System.out.println("共执行"+(end-begin)+"毫秒");
```

#### System

```
System.out  out是System类的静态变量
System.out.println()  println()不是System类的,是PrintStream类的方法
System.gc() 建议启动垃圾回收机制
System.currentTimeMillis();  获取从1970.1.1到现在的总毫秒数
System.exit(0); 退出JVM
```

### Number类

#### DecimalFormat

java.text.DecimalFormat专门负责数字格式化的 

#表示任意数字

，表示千分位

. 表示小数点

```java
import java.text.DecimalFormat;

DecimalFormat df = new DecimalFormat("###,###.##");
DecimalFormat df = new DecimalFormat("###,###.000");
System.out.println(df.format(11123.22222)); //11,123.22
System.out.println(df.format(1)); //1.000
```

#### BigDecimal

BigDecimal属于大数据，精度极高。不属于基本数据类型，属于ava对象，用于财务软件中

```java
import java.math.BigDecimal;

BigDecimal bd1 = new BigDecimal(100);
BigDecimal bd2 = new BigDecimal(200);
//bd1+bd2 都是引用，不能直接使用+
BigDecimal result = bd1.add(bd2);
System.out.println(result);
```

#### Random

产生一个随机数

```java
import java.util.Random;

Random random = new Random();
System.out.println(random.nextInt());  //产生随机一个int变量
System.out.println(random.nextInt(100));//产生随机一个int变量  0-100 不超过100
```

### Enum类

枚举：可以列举出来的状态，才建议使用枚举类型(引用数据类型)

```java
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(divide(1,1));  //Success
    }
    public static  Result divide(int a, int b){
        try{
            int c = a/b;
            return Result.Success;
        }catch(Exception e){
            return Result.Fail;
        }
    }
}
public enum Result{
    // Success,Fail是枚举Result类型中的一个值
    Success,Fail
}
```

案例

```java
public class EnumTest2 {
    public static void main(String[] args) {
        Climate s = Climate.Winter;
        switch (s){
            case Spring:
                System.out.println("春天过去了");
            case Summer:
                System.out.println("夏天过去了");
            case Autumn:
                System.out.println("球天过去了");
            case Winter:
                System.out.println("冬天过去了");

        }
    }
}

enum Climate{
    Spring,Summer,Autumn,Winter;
}
```

## 七、异常

### 异常概述

以下程序发生了不正常情况，称为：异常

Java将该异常信息打印输出到控制台（JVM打印的），供程序员修改，使程序更加健壮

```java
System.out.println(10/0);  //Exception in thread "main" java.lang.ArithmeticException: / by zero
```

通过异常类实例化异常对象

```java
NumberFormatException nfe = new NumberFormatException("数字格式化异常");
System.out.println(nfe);  //java.lang.NumberFormatException: 数字格式化异常

NullPointerException npe = new NullPointerException("空指针异常");
System.out.println(npe);  //java.lang.NullPointerException: 空指针异常
```

由此可见，Java程序发生错误，JVM会new 异常对象然后抛出去

### 异常处理机制

异常在Java中以类和对象的形式存在，那么异常的继承结构是怎样的？

可以用UML图来描绘继承结构

UML是一种统一建模语言，图标式语言。只要是面向对象的编程语言，都有UML.

它可以描述类和类之间的关系，程序执行的流程，对象的状态

#### 异常继承结构

Object

Object类下有Throwable

Throwable类底下有两个分支：

​	Error(不可处理，直接退出JVM)和Exception（可处理）。

​	Exception下有两个分支：

​		Exception的直接子类（受控异常）：编译时异常（要求程序员异常处理）

​		runtimeException(未受控异常):运行时异常，可预先处理，也可以不管

##### 编译异常和运行异常的区别

编译异常一般发生概率较高，运行异常一般发生概率较低

#### 异常处理方式

1. 在方法声明的位置上，使用throws关键字(异常上抛)
2. 使用try...catch进行异常捕捉(异常捕捉)

Java中异常发生之后，如果一直上抛，最终抛给main方法，main方法继续向上抛，抛给了调用者JVM，JVM知道这个异常发生就会终止Java程序的执行

##### 无处理异常

```java
public class ExceptionTest2 {
    public static void main(String[] args) {
    //程序此处发生Arithmeticexception异常，底层new了一个Arithmeticexception异常对象，然后抛出了，由于mian方法调用了100/0，所以异常抛给了main方法，main方法没有处理，将这个异常地总抛给JVM,JVM自动终止程序
        System.out.println(100/0);
        //没有输出执行
        System.out.println("hello World!");
    }
}
```

##### 异常处理的方法

```java
public class ExceptionTest2 {
    public static void main(String[] args) {
     //main方法中调用doSome()方法
     //因为doSome()方法声明位置上有:throws CLassNotFoundException
     //我们在调用doSome()方法的时候必须对这种异常进行预先的处理。
     //如果不处理，编译器就报错。
     //编译器报错信息:Unhandle exception:javaang.ClassNotFoundException
        doSome();
    }

    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome");
    }
}
```

以上代码报错的原因：因为doSome()方法声明位置上使用了：throws ClassNotFoundException，而ClassNotFoundException是编译时异常，必须编写代码时处理，不然报错

第一种处理方式 --上抛异常--相当于推卸了异常

```java
public class ExceptionTest2 {
    public static void main(String[] args)throws ClassNotFoundException{
        doSome();
    }

    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome");
    }
}
```

第二种处理方式 --捕捉异常--相当于拦截了解决了异常

```java
public class ExceptionTest2 {
    public static void main(String[] args) {
        try{
            doSome();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome");
    }
}

```

##### 异常经典案例

```java
public class ExceptionTest3 {
    public static void main(String[] args) throws FileNotFoundException {
        //进行上抛
        m1();
    }
    public static void m1() throws Exception {
        System.out.println("m1--begin");
        //进行上抛
        m2();
        System.out.println("m1--end");
    }
    public static void m2() throws IOException {
        try {
            m3();
            System.out.println("发生异常不执行");
        }catch (Exception e){
            System.out.println("捕捉异常，继续执行");
        }
    }
    public static void m3() throws FileNotFoundException {
        //这里调用了一个构造方法：FileInputStream(String name)
        //这个构造方法的声明位置上有： throws FileNotFoundExfception
        //通过类的继承结构：FileNotFoundExfception的父类是IOException,IOException的父类是Exception，最终得知，FileNotFoundException是编译异常
        //需要程序员编写程序对它进行处理，不处理就报错，进行上抛
        new FileInputStream("F:\\Project_Java\\advanced\\d24\\文件流.txt");
    }

}
m1--begin
m2--begin
捕捉异常，继续执行
m2--end
m1--end
```

只要异常不捕捉，采用上报的方式，后续逮代码不会执行

```java
public class ExceptionTest4 {
    public static void main(String[] args)  {
        try{
            FileInputStream fs = new FileInputStream("F:\\Project_Java\\advanced\\d24\\s文件流.txt");
            fs.read();
            System.out.println("以上出现异常，这里无法执行");
        }catch (FileNotFoundException e){
            System.out.println("文件不存在");
        }catch (IOException e){
            System.out.println("文件报错了");
        }
        System.out.println("hello world!");
    }
}
```

**catch后面的小括号中的类型可以是具体的异常类型，也可以是异常类的父类型，可以写多个，Exception 吃全部**

##### Java8新特性

```java
try{
   FileInputStream fs = new FileInputStream("F:\\Project_Java\\advanced\\d24\\s文件流.txt");
   fs.read();
}catch (FileNotFoundException e | IOException e | NullPointException e){
   System.out.println("文件报错了");     //
}
```

#### 异常对象方法

**获取异常简单的描述信息**

```java
NullPointerException exception = new NullPointerException("卧槽，怎么空指针异常了");
String msg = exception.getMessage();
System.out.println(msg)  //卧槽，怎么空指针异常了
```

**打印异常追踪的堆栈信息**

```java
exception.printStackTrace();  //java.lang.NullPointerException: 卧槽，怎么空指针异常了
	at qiangliu8.Exception.ExceptionTest5.main(ExceptionTest5.java:5)
```

#### finally语句在try...catch

finally子句中的代码是最后执行的，并且是一定会执行的，鸡翅try语句中的代码出现了异常。finally必须跟try一起出现，不能单独编写

```java
public class ExceptionTest6 {
    public static void main(String[] args){
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("F:\\Project_Java\\advanced\\d24\\文件流.txt");
            String  s = null;
            //这里一定会出现空指针异常
            s.toString();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("不慌");
        }finally {
            //流使用完需要关闭，因为还站着资源\
            try {
                if (fis != null) fis.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

finally可见一般是用于释放资源

##### 只有JVM退出 不执行finally

```java
try{
    System.out.println("try");
    System.exit(0);
}finally {
    System.out.println("finally");   //try
}
```

#### 空指针异常

NULLPointExecption

```java
public class NULLPointTest{
	public static void main(String[] args){
		Customer c = new Customer();
        c.id = 9527;
        System.out.println(c.id);
        c.age = null;
        System.out.println(c.age);
	}
}
class Customer{
	int id;	//成员变量中的实例变量，应该先创建对象，然后通过“引用.”的方式引用
    int age;
}
```

Java中垃圾回收机制GC主要针对回收的是**堆内存当中**的垃圾数据，当一个Java对象没有任何引用指向该对象的时候，GC会考虑将该垃圾数据释放回收掉

出现空指针异常的前提条件

“空引用”访问实力【对象相关】相关的数据时，都会出现空指针异常

#### 自定义异常

```java
public class ExceptionTest8 {
    public static void main(String[] args) {
        MyException me = new MyException("这是我的自己的编译异常");
        me.printStackTrace();
        System.out.println(me.getMessage());
    }

}
class MyException extends Exception{        //编译时异常
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

class YourException extends RuntimeException{       //运行异常

}
```

##### 重写之后的方法不能比之前的方法抛出更多的编译异常，可以更少

```java
class A{
    public static  void dos(){

    }
    public static  void onther() throws Exception {

    }
}

class B extends A{
    public static  void dos() throws Exception {
	//报错  编译异常不行 运行异常可以
    }
    public static  void onther(){
	//正常
    }
}
```

## 八、集合

数组就是一个集合，就是一个容器，可以容纳其他类型的数据，可以一次容纳多个对象。

集合不能存储基本数据类型，也不能直接存储java对象，**存的是对象的内存地址**，是引用。同样集合也可以套集合

Java每一个不同的集合，底层会对应不同的数据结构，往不同的集合中存储元素，等于将数据放到了不同的数据结构当中

所有集合接口都在java.util.*下面

### 继承结构

#### Collection继承结构图

Java中集合分为两类：

一类是**单个方式存储元素**：单个方式存储元素，这一类集合中超级父接口：java.util.Collection

一类是**以键值对儿的方式存储元素**：以键值对的方式存储元素，这一类集合中的超级父接口：java.util.Map

![image-20201028195010933](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201028195010933.png)

**Iterator it = Collection对象.Iterator()**  it就是迭代器对象

![image-20201028195930712](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201028195930712.png)

#### Map继承结构图

![image-20201028201601179](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201028201601179.png)

#### 总结

**ArrayList**：底层是数组

**LinkedList**：底层是双向链表

**Vector**：底层是数组，线程安全的，效率较低，使用较少

**HashSet**：底层是HashMap,放到HashSet集合中的元素等同于放到HashMap集合key部分

**TreeSet**：底层是TreeMap，放到TreeSet集合中的元素等同于放到TreeMap集合key部分

**HashMap**：底层是哈希表

**Hashtable**：底层也是哈希表，只不过线程安全，效率较低，使用较少

**Properties**：是线程安全的，并且key和value只能存储字符串String

**TreeMap**：底层是二叉树。TreeMap集合的key可以自动按照大小顺序排序

List集合存储元素的特点

​		有序可重复：存进去的顺序和取出的顺序相同，每一个元素都有i下标，可以重复的元素

Set集合存储元素的特点

​		无序不可重复：存进去的顺序和取出的顺序不一定相同，且没有下标。不可存储重复的元素

SortedSet集合存储元素的特点

​		无序不可重复，但是其中的元素是可以按照大小顺序排列

Map集合的key就是一个set集合，往Set集合中放数据，实际就是放到Map集合Key部分

### Collection

没有使用泛型之前，Collection中可以存储Object的所有子类型。使用泛型之后，Collection中只能存储某个具体的类型。Collection中什么都能存，只要是Object的子类型就行

#### 常用方法

##### boolean add(Object e)

向集合中添加元素

```java
//接口是抽象的，无法实例化
//Collection c = new Collection();
Collection c = new ArrayList();
c.add(1200); //自动装箱。实际上就是放进去一个对象的内存地址 Integer in = new Integer(1200);
c.add(new Object());
c.add(true);
```

##### int size()

获取集合中元素的个数,不是容量！

```java
System.out.println(c.size()); //3
```

##### void clear()

清空集合

```java
c.clear();
System.out.println(c.size()); //0
```

##### boolean contains(Object o)

判断集合中是否包含该元素

```java
System.out.println(c.contains(1200)); //true
System.out.println(c.contains(100)); //false
```

contains方法是用来判断集合中是否包含**某个元素**的方法，底层调用了equals方法进行比对

equals()方法需要重写

##### boolean remove(Object o)

删除集合中某个元素

```java
System.out.println(c.remove(1200)); //true
System.out.println(c.contains(1200));//false
```

##### boolean isEmpty()

判断集合是否为空

```java
System.out.println(c.isEmpty());//false
c.clear();//false
System.out.println(c.isEmpty());//true
```

##### Object[] toArray()

将集合转为数组

```java
Collection c2 = new ArrayList();
c2.add(1);
c2.add("刘强");
c2.add("yu");
c2.add(true);
Object []o = c2.toArray();
for (int i = 0; i <o.length ; i++) {
    System.out.println(o);     
}
//1
//刘强
//yu
//true
```

#### Collection工具类

Java.util.Collection集合接口

Java.util.Collections集合工具类，方便集合的操作

```java
//list集合不是线程安全的
List<String> list = new ArrayList<>();
//变成线程安全的
Collections.synchronizedList(list);

//排序 对集合中元素排序，需要实现它的Compare接口
list.add("2123");
list.add("liuq");
list.add("2122");
Collections.sort(list);
for (int i = 0; i <list.size() ; i++) {
    System.out.println(list.get(i));   //2122  2123 liuq
}
```

对Set集合怎么进行排序呢

```java
Set<String> myset = new HashSet<>();
myset.add("def");
myset.add("abc");
myset.add("ab");
//将Set集合转换成List集合
List<String> mylist = new ArrayList<>(myset);
Collections.sort(mylist);
for (int i = 0; i <mylist.size() ; i++) {
    System.out.println(mylist.get(i));
}
```

### Iterator

![image-20201029111059021](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201029111059021.png)

```java
Collection c = new ArrayList();
c.add(1);
c.add("刘强");
c.add(new Object());
//获取集合对象的迭代器对象Iterator
Iterator it= c.iterator();
//boolean hasNext() 如果迭代具有更多的元素，则返回true 。
//E.next(); 返回迭代中的下一个元素
while(it.hasNext()){
    Object obj = it.next();
    System.out.println(obj);
}
```

**注意：集合结构发生改变，迭代器必须重新获取,不然会报错**

```java
Collection c = new ArrayList();
Iterator it = c.iterator(); //Exception in thread "main" java.util.ConcurrentModificationException
c.add(1);
c.add(2);
c.add(3);
while(it.hasNext()){
    System.out.println(it.next());
}
```

可以通过**迭代器去删除**解决这一问题

```java
Collection c = new ArrayList();
c.add(1);
c.add(2);
c.add(3);
Iterator it = c.iterator(); 
while(it.hasNext()){
    System.out.println(it.next());
    it.remove();
}
```

### List

**1.**List集合存储元素特点：有序可重复

​	有序：List集合中的元素有下标

​	可重复：有1，还可以存储1

**2.**List既然是Collection接口的子接口，那么肯定List接口有自己“特色”的方法

```java
boolean add(Object e)

Object  get(int index)

int indexOf(Object o)
    
int lastindexOf(Object o)

boolean remove(int index)

boolean  set(int index, Object element)
List list = new ArrayList();
list.add(1);
list.add(2);
list.add(1);
//指定位置插入
list.add(1,3);
Iterator it = list.iterator();
while (it.hasNext()){
    System.out.println(it.next());
}
```

因为有下标，所以List有自己的**遍历方式**

```java
for (int i = 0; i <list.size() ; i++) {
    System.out.println(list.get(i));
}
```

获取指定对象**第一次出现处的索引**

```java
System.out.println(list.indexOf(1));//0
```

获取指定对象**最后一次出现处的索引**

```java
 System.out.println(list.lastindexOf(1));//3
```

**修改**指定位置的元素

```java
System.out.println(list.get(1)); //3
list.set(1,"我改的"); 
System.out.println(list.get(1)); //我改的
```

#### ArrayList

集合底层是一个Object[]数组

```java
//默认初始化容量是10
List list1 = new ArrayList();
System.out.println(list.size());//0
//指定初始化容量
List list2 = new ArrayList(20);
System.out.println(list.size());//0
//将HashSet集合转换成List集合
Collection c = new HashSet();
c.add(1);
c.add(2);
c.add(3);
List list3 = new ArrayList(c);
```

ArrayList集合的扩容：**原容量的1.5倍**。尽可能少的扩容，数组扩容效率较低，但是舒徐末尾添加元素不受影响！！不是非线程安全的集合

数组优点：检索效率较高，每个元素占用空间大小相同，内存地址是连续的，通过数学表达式计算处元素内存地址，检索效率最高

数组缺点：随机删除元素效率较低，无法存储大数据量

#### LinkList

双向链表，有头节点和尾节点，不初始化容量

链表的优点:

由于链表上的元素在空间存储上内存地址不连续。所以随机增删元素的时候不会有大量元素位移，因此随机增删效率较高。在以后的开发中，如果遇到随机增删集合中元素的业务比较多时，建议使用LinkedList。

链表的缺点:

不能通过数学表达式计算被查找元素的内存地址，每一次查找都是从头节点开始逼历，查到找到为止。所以LinkedList集合检索/查找的效率较低。

ArrayList :把检索发挥到极致。LinkedList :把随机增删发挥到极致。

加元素都是往末尾添加，所以ArrayList用的比LinkedList多。l

#### Vector

底层也是一个数组，初始化容量

扩容之后的容量是原容量的2倍：10->20->40->40

ArrayList集合扩容：10->15->22.5

Vector所有的方法都是线程安全的

```java
//非线程安全
List list = new ArrayList();
Collections.synchronizedList(list);
//线程安全
for (int i = 1; i <=10 ; i++) {
    list.add(i);
}
```

#### HashSet

集合无序不可重复

```java
Set<String> set = new HashSet<>();
set.add("hello3");
set.add("hello4");
set.add("hello1");
set.add("hello2");
set.add("hello3");
set.add("hello3");
for (String s:set) {
    System.out.println(s);
}
//hello1
//hello4
//hello2
//hello3
存储时的顺序和取出的顺序不同，不可重复，放到HashSet集合中的元素实际上时放到HashMap集合的Key部分了
```

#### TreeSet

1. Tree底层是一个TreeMap
2. TreeMap底层是一个二叉树
3. 放到TreeSet集合中的元素，等同于放到TreeMap集合的key部分
4. TreeSet集合中的元素时无序不可重复，但是会暗战元素大小自动排序，称为可排序集合

```java
Set<String> set = new TreeSet<>();
set.add("hello3");
set.add("hello4");
set.add("hello1");
set.add("hello2");
set.add("hello3");
set.add("hello3");
for (String s:set) {
    System.out.println(s);
}
//hello1
//hello2
//hello3
//hello4
```

对存储自定义类型的TreeSet集合，需要进行自定义比较级，否则报错

```java
Person p1 = new Person(23,"刘强");                  
Person p2 = new Person(22,"俞文竹");                 
Person p3 = new Person(24,"吴云");                  
TreeSet<Person> ps = new TreeSet<>();             
ps.add(p1);                                       
ps.add(p2);                                       
ps.add(p3);                                       
//Exception in thread "main" java.lang.ClassCastException: class qiangliu8.Collection.Set.Person                       
//出现这个异常时因为TreeSet没有实现CompareTo接口
```

1.需要对其进行实现接口

```java
class Person implements Comparable<Person>{
    public int age;
    public String name;
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        if (this.age!= person.age) return (this.age-person.age);
        else return this.name.compareTo(person.name);
    }
}
//compareTo 方法的返回值很重要
返回0表示相同，value会覆盖
返回>0,会继续在右子树上找
返回<0,会继续在左子树上找
```

2.实现比较器接口

```java
public class TreeSetTest3 {
    public static void main(String[] args) {
        TreeSet<Wugui> ts = new TreeSet<>(new WuguiComparator());
        ts.add(new Wugui(112));
        ts.add(new Wugui(22));
        ts.add(new Wugui(32));
        for (Wugui w:ts
             ) {
            System.out.println(w);
        }
    }
}

class Wugui{
    int age;
    public Wugui(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Wugui{" +
                "age=" + age +
                '}';
    }
}

class WuguiComparator implements Comparator<Wugui> {

    @Override
    public int compare(Wugui wugui1,Wugui wugui2) {

        return wugui1.age- wugui2.age;
    }
}
```

3.匿名内部类实现比较器接口

```java
TreeSet<Wugui> ts = new TreeSet<>(new Comparator<Wugui>() {
    @Override
    public int compare(Wugui wugui, Wugui t1) {
        return wugui.age- t1.age;
    }
});
```



### 泛型机制

泛型这种语法机制，旨在程序编译阶段起作用，只是给编译器参考的，运行阶段没用

好处：集合中存储的元素类型统一，从集合中去除的元素类型是泛型指定的类型，不需要进行大量的向下转型

缺点：导致集合中存储的元素缺乏多样性

不使用泛型

```java
List myList = new ArrayList();

Cat c = new Cat();
Bird b = new Bird();

myList.add(c);
myList.add(b);
Iterator it = myList.iterator();
while(it.hasNext()){
    //通过迭代器取出的就是Object
    Object s = it.next();
    //Object没有move()方法，需要对其进行强转
    if (s instanceof Animal){
        Animal s1 = (Animal)s;
        s1.move();
    }

}
```

使用泛型

```java
//使用泛型List<Animal>之后，表示List集合中只允许存储Animal类型的数据
List<Animal> mylist1 = new ArrayList<Animal>();
Cat c = new Cat();
Bird b = new Bird();
mylist1.add(c);
mylist1.add(b);
//用了泛型之后，集合中的数据更统一了
Iterator<Animal> its = mylist1.iterator();
while (its.hasNext()) {
    //使用泛型之后通过迭代器取出的就是Animal类型
    Animal s1 = its.next();
    s1.move();
}
```

JDK8之后引入新特性：自动类型推断机制

```java
List<Animal> list =new ArrayList<>();//这里的类型会自动推断，可省略
list.add(new Animal());
list.add(new Cat());
list.add(new Bird());
list.add(new String());//类型不匹配，报错
```

#### 自定义泛型

**常见泛型 <E>是Element <T>是Type**

```java
//<>中的myGeneric只是一个标识符
public class GenericTest3<myGeneric>{
    public static void main(String[] args) {
        GenericTest3<String> mg = new GenericTest3<>();
        mg.doSome("abc");
    }
    //表示传入一个指定类型的对象
    public  void  doSome(myGeneric e){
        System.out.println(e);
    }
}
```

### Map

Map和Collection没有继承关系

Map集合以key和value的方式存储数据：键值对

key和value都是引用数据类型，存储的都是存储对象的内存地址，key起主导位置

#### HashMap

##### 常用接口方法

```java
V put(K key,V value) 向Map集合中添加键值对
    
V get(Object value) 通过key获取value
    
void clear()  清空Map集合

boolean containsKey(Object key) 判断Map中是否包含某个key

boolean containsValue(Object key) 判断Map中是否包含某个value

boolean isEmpty() 判断Map集合是否为空

Set<K>  keySet() 获取Map集合中所有key，是一个Set集合
    
Collection<v> values() 获取Map集合中所有的value,返回一个Collection集合

V remove(Object key) 通过key删除键值

int size()

Set<Map.Entry<K,V>> entrySet() 将Map集合转换成Set集合
key				value
=====================
1				zhanshan
2				liuq
3				wuyun
4				su

Set set = map1.entrySet();
1=zhanshan 【Map集合通过entrySet（）方法转换成的这个Set集合，集合中元素类型是Map.Entry<K,V>，是一个静态内部类】
2=liuq
3=wuyun
4=su
```

```java
Map<Integer,String> map1 = new HashMap<>();
map1.put(1,"刘强");//自动装箱
map1.put(2,"吴云");//自动装箱
map1.put(3,"吴凡");//自动装箱
map1.put(4,"狗比");//自动装箱

System.out.println(map1.get(1)); //刘强
System.out.println(map1.get(2)); //吴云
map1.remove(1);
System.out.println(map1.get(1)); //null
System.out.println(map1.size());//3

System.out.println(map1.containsKey(1));//false
System.out.println(map1.containsKey(2)); //true
System.out.println(map1.containsValue("刘强"));//false
System.out.println(map1.containsValue("吴云"));//true

map1.clear();
System.out.println(map1.size());// 0
System.out.println(map1.isEmpty());//true

获取所有value
Collection<String> cs = map1.values();
for(String str:cs) {
    System.out.println(str);
}

第一种获取所有key,通过遍历key，来遍历value
Map<Integer,String> map = new HashMap<>();
map.put(1,"我去");
map.put(2,"liuqiang");
map.put(3,"wuyun");
Set<Integer> set = map.keySet();
for (Integer i: set) {
    System.out.println(map.get(i));
}
第二中方法使用entrySet()
    //Set集合中类型是Map.Entry
Set<Map.Entry<Integer,String>> set1 = map.entrySet();
for (Map.Entry<Integer,String> i:set1) {
    System.out.println(i);
}
Iterator<Map.Entry<Integer,String>> it1 = set1.iterator();
//遍历Set集合，每一次取出一个Node
while (it1.hasNext()){
    Map.Entry<Integer,String> node = it1.next();
    Integer key = node.getKey();
    String str = node.getValue();
    System.out.print(key+'，'+str);
}

```

##### 底层源代码

```java
public class HashMap{
	//HashMap底层实际上就是一个一维数组
	Node<K,V>[] table;
	//静态内部类HashMap.Node
	static class Node<K,V> implements Map.Entry<K,V>{
		final int hash; //哈希值是key的hashCode()方法的执行结果，通过哈希函数转换成数组下标
		final K key;//存储到Map集合中的那个key
		V value; //存储到Map集合中的那个value
		Node<K,V> next; //下一个节点的内存地址
	}
}
```

![image-20201101142039174](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201101142039174.png)

Map集合中存，以及Map集合中取，都是先调用key的hashCode方法，然后调用equals方法（可能调，也可能不掉）。

put(k,v)中hashcode返回哈希值换算成数组下标，下标上的位置是null,equals不需要执行

get(k)中单向链表中只有1个元素，不需要调用equals方法

**equals重写的话，hashCode需要同时生成！！**

**HashMap的key为空时，可以存value,但是只能存一个**

#### 哈希表数据结构

HashMap集合底层是哈希表/散列表的数据结构

哈希表是一个数组和单向链表的结合体，

数组：在查询方面效率很低，随机增删方面效率很低

单向链表：在随机增删方面效率较高，在查询方面效率很低

哈希表将以上两种数据结构融合在一起，充分发挥各自的优点

HashMap集合的key部分特点:

​		无序：因为不一定挂到那个单向链表上

​		不可重复：equals方法老i保证HashMap集合的key不可重复，key重复，value会覆盖		

​		**放在HashMap集合key部分的元素其实就是放到HashSet集合中，所以HashSet中的元素也需要对HashCode和equals进行重写**

#### HashMap和Hashtable的区别

1.HashMap的key和value可以为空，Hashtable都不可为空

```java
Map<Integer,String> map1 = new HashMap<>();
map1.put(null,null);
System.out.println(map1.size());//1
map1.put(null,"1");
System.out.println(map1.size());//1
Map<Integer,String> map2 = new Hashtable<>();
map2.put(null,"123");//Exception in thread "main" java.lang.NullPointerException
```

2.HashMap线程不安全，Hashtable方法带有synchronized,线程安全，导致效率较低，使用较少

3.HashMap和Hashtable底层数据结构都是哈希表结构

4.Hashtable扩容容量为原容量*2+1，HashMap扩容容量为原容量*2

#### Properties

Properties是一个Map集合，继承Hashtable，Properties的key和value都是String类型，被称为属性类。所以也不能为null

```java
//常见一个Properties对象
Properties properties = new Properties();

properties.put("id","1123");
properties.put("name","刘强");
properties.put("sex","男");

System.out.println(properties.getProperty("id"));
System.out.println(properties.getProperty("name"));
System.out.println(properties.getProperty("sex"));
```

## 九、IO流

### IO概述

以内存为参照物，通过IO可以完成对硬盘的读和写

![image-20201101212939096](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201101212939096.png)

#### 流的分类

流的分类有多种方式，

一种是按照**流的方向**进行分类：以内存为参照物，

​	往内存中去，叫做输入或叫做读

​	从内存中出来，叫做输出，或者叫做写

另一种方式是按照**读取数据方式**不同进行分类：

​	1.有的流是按照**字节的方式**读取数据，一次读取1个字节byte,等同于一次读取8个二进制位，这种流是万能流

​	假设文件file1.txt，采用字节流的话是这样读的:

​	a中国bc张三fe

​	第一次读:一个字节,正好读到'a'

​	第二次读:一个字节,正好读到中字符的一半。

​	第三次读:一个字节，正好读到中'字符的另外一半。

​	2.有的流是按照**字符的方式**读取数据，一次读取一个字符，这种流是为了方便读取普通文件而存在的，这种流不能读取：图片、声音、视频等，只能读txt，不能读取word文件

​	假设文件file1.txt，采用字符流的话是这样读的:

​	a中国bc张三fe

​	第一次读: 'a'字符（'a'字符在windows系统中占用1个字节。)

​	第二次读:'中'字符（中字符在windows系统中占用2个字节。)

**综上所述：输入流、输出流、字节流、字符流**

Java中流：

```java
java.io.InputStream //字节输入流

java.io.OutputStream //字节输出流

java.io.Reader //字符输入流

java.io.Writer //字符输出流
//都是抽象类
```

注意：在Java中只要类名以Stream结尾的都是字节流，以Reader/Writer结尾的都是字符流

**所有流都实现了java.util.Closeable接口**，都是可关闭的，都有close方法。流毕竟是一个管道，这个是内存和硬盘之间的通道，用完之后一定要关闭。不然会耗费资源

**所有输出流都实现了java.util.Flushable接口**，都是可刷新的，都有flush()方法，用完输出流之后，一定要记得flush()书信一下。这个刷新表示将管道内的剩余未输出的数据强行输出完，清空管道，如果没有flush()可能会导致丢失数据

### 流的常用类

###### io包下需要掌握的流

```java
//文件专属
java.io.FileInputStream ⭐
java.io.FileOutputStream⭐
java.io.FileReader
java.io.FileWriter
//转换流：将字节流转换成字符流
java.io.InputStreamReader
java.io.OutputStreamWriter
//缓冲流专属
java.io.BufferedReader
java.io.BufferedWriter
java.io.BufferedInputStream
java.io.BufferedOutputStream
//数据流专属
java.io.DataInputStream
java.io.DataOutputStream
//对象流专属
java.io.ObjectInputStream⭐
java.io.ObjectOutputStream⭐
//标准输出流
java.io.PrintWriter
java.io.PrintSream⭐
```

#### 常用实例

##### java.io.FileInputStream

```java
FileInputStream fis = null;
/*
* java.io.FileInputStream
* 1.文件字节输入流，万能的，任何类型文件都可以采用这个流来读
* 2.字节的方式，完成输入的操作。从硬盘到内存
*/
//创建文件字节流输入对象
//文件路径F:\Project_Java\advanced\d26\src\qiangliu8\io ，idea自动转换\\ 防止转义
try{
    fis= new FileInputStream("F:\\Project_Java\\advanced\\d26\\src\\qiangliu8\\io\\temp");
    //这个方法的返回值：读取到字节本身
    int result;
    while((result = fis.read())!=-1){
        System.out.println(result);
    }
    //读取完，读取不到数据了一直返回-1
    //97 98 99 100 101 -1 -1 -1 -1
}catch (FileNotFoundException e){
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    //关闭流的前提是流不为空
    if (fis!=null){
        try {
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

改进

```java
/*
* int read(byte[] b)
* 一次读取b.lengtn个字节
* 减少硬盘和内存的交互，提高程序的执行效率
* 往btye数组当中读
* */
fis= new FileInputStream("src\\qiangliu8\\io\\temp");
byte[] b = new byte[4];
fis.read(b); //abcd
for (int i = 0; i <b.length ; i++) {
    System.out.println(b[i]);
fis.read(b);//同样，读是不可逆的，第二次读就只会读取剩余的部分字节 efabc
fis.read(b);//读取不到返回-1
```

最终

```java
fis= new FileInputStream("src\\qiangliu8\\io\\temp");
byte[] b = new byte[4];
int readCount;
while((readCount = fis.read(b))!=-1){
    //转换成String字符串
    System.out.println(new String(b,0,readCount));
}
```

java.io.FileInputStream类其他常用方法

```java
int available()  //返回流当中剩余没有读到的字节数量
long skip(long n)
```

```java
System.out.println(fis.available()); //6
int readCount = fis.read(6);
System.out.println(new String(b,0,readCount)); //abcd
System.out.println(fis.available()); //2
fis.skip(2);
System.out.println(fis.available());//0
```

available()一般可用于**初始化字节数组的长度**,但是不太适合大文件，byte数组太大！

```java
byte[] b1 = new byte[fis.available()];
fis.read(b1);
System.out.println(new String(b1)); //这样就不用循环abcdef
```

##### java.io.FileOutputStream

```java
//append属性为true,以追加的方式在末尾写入
fos = new FileOutputStream("src\\qiangliu8\\io\\temp",true);
String str = "我是刘强";
//byte数组全部写入
byte[] b = str.getBytes();
fos.write(b);
//byte数组一部分写出
fos.write(b,0,2);
```

##### 文件拷贝--FileOutputStream&&java.io.FileInputStream

```java
FileInputStream fis = null;
FileOutputStream fos = null;
int reacCount = 0 ;
try {
    byte[] b = new byte[1024*1024];//一次传入1m数据
    //创建一个输入流对象
    fis = new FileInputStream("src\\qiangliu8\\io\\FileStream\\输入的图片.jpg");
    //创建一个输出流对象
    fos = new FileOutputStream("src\\qiangliu8\\io\\FileStream\\输出的图片.jpg");
    //一边写一边读
    while ((reacCount=fis.read(b))!=-1){
        fos.write(b,0,reacCount);
    }
    fos.flush();
}catch (FileNotFoundException e){
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (fis!= null){
        try {
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    if (fos!= null){
        try {
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

##### java.io.FileReader

和FileInputStream大同小异，不同的是char数组

```java
/*
FileReader
文件字符输入流，只能读取普通文本
读取文本内容时，比较方便
*/
FileReader reader = null;
int readCount = 0;
try {
    reader = new FileReader("src\\qiangliu8\\io\\FileStream\\temp");
    char[] c = new char[4]; //一次读取4个字符
    while ((readCount= reader.read(c))!=-1){
        System.out.print(new String(c,0,readCount));
    }
```

##### java.io.FileWriter

```java
fw = new FileWriter("src\\qiangliu8\\io\\FileStream\\2",true);
char []c = {'我','是','刘','强'};
String str = ",我很喜欢俞文竹";
fw.write(c);
fw.write(str.toCharArray());
fw.flush();
```

##### 文件拷贝--java.io.FileReader&&java.io.FileWriter

//只能拷贝文本文件 char数组

```java
FileReader fr = null;
FileWriter fw = null;
int reacCount = 0 ;
try {
    char[] b = new char[1024*1024];//一次传入1m数据
    //创建一个输入流对象
    fr = new FileReader("src\\qiangliu8\\io\\FileStream\\2");
    //创建一个输出流对象
    fw = new FileWriter("src\\qiangliu8\\io\\FileStream\\3");
    //一边写一边读
    while ((reacCount=fr.read(b))!=-1){
        fw.write(b,0,reacCount);
    }
    fw.flush();
}catch (FileNotFoundException e){
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (fr!= null){
        try {
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    if (fw!= null){
        try {
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

##### java.util.BufferedReader

带有缓冲区的字符流

使用这个流的时候不需要自定义数组。自带缓冲

```java
//当一个流的构造方法中需要一个流的时候，这个被传进来的流叫做：节点流
//外部负责包装这个流，叫做包装流，还有一个名字叫做处理流
FileReader fr = new FileReader("src/qiangliu8/io/Buffer/1");
BufferedReader br = new BufferedReader(fr);

//读完的时候没有返回null
String str = null;
while((str = br.readLine())!=null){
    System.out.print(str); //读一个文本行，但不带换行符
}
//关闭liu
//对于包装流来说，只需要关闭最外层流就行，里面的节点流会自动关闭
br.close();
```

如果将字节流传进入是报错的，只能传reader。

```java
FileInputStream fis = new FileInputStream("src/qiangliu8/io/Buffer/1");
BufferedReader br1 = new BufferedReader(fis);
//错误:(22, 49) java: 不兼容的类型: java.io.FileInputStream无法转换为java.io.Reader
```

所以我们需要进行字节流转换成字符流

```java
//字节流
FileInputStream fis = new FileInputStream("src/qiangliu8/io/Buffer/1");
//通过转换流转换 InputStreamReader将字节流转换成字符流
//fis是节点流,fr1是包装流
InputStreamReader fr1 = new InputStreamReader(fis);
//fr1是节点流,br1是包装流
BufferedReader br1 = new BufferedReader(fr1);
while((str = br1.readLine())!=null){
	System.out.print(str);
}
br1.close();
```

##### java.util.BufferedWriter

带有缓冲的字符输出流

```java
FileWriter fw = new FileWriter("src/qiangliu8/io/Buffer/1",true);
BufferedWriter bw = new BufferedWriter(fw);
bw.write("\nHello World");
bw.write("\n");
bw.write("\n吴云");
bw.flush();
//通过转换流转换 OutputStreamWriter将字节流转换成字符流
BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/qiangliu8/io/Buffer/1",true)));
bw1.write("\n1");
bw1.write("\n");
bw1.write("\n2");
bw1.flush();
```

##### java.util.DataOuputStream

数据专属流，这个流可以将数据连同数据类型一并写入

```java
//创建数据专属的字节输出流
DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/qiangliu8/io/Data/data"));
//写数据
byte b = 100;
short s = 200;
int i = 400;
long l = 500;
float f = 3.0f;
double d = 3.14;
boolean sex = false;
char c = 'a';
//写
dos.writeByte(b);
dos.writeShort(s);
dos.writeInt(i);
dos.writeLong(l);
dos.writeFloat(f);
dos.writeDouble(d);
dos.writeBoolean(sex);
dos.writeChar(c);

dos.flush();
dos.close();
```

##### java.util.DataInputStream

数据字节输入流

数据专属流创建的文件必须只有DataInputStream才可以读。并且读的时候你需要提前知道写入的顺序，读的顺序和写的顺序一直，才可以正常取出顺序

```java
DataInputStream dis = new DataInputStream(new FileInputStream("src/qiangliu8/io/Data/data"));
System.out.println(dis.read());
System.out.println(dis.readShort());
System.out.println(dis.readInt());
System.out.println(dis.readLong());
System.out.println(dis.readFloat());
System.out.println(dis.readDouble());
System.out.println(dis.readBoolean());
System.out.println(dis.readChar());
System.out.println(dis.read()); //读完返回-1
dis.close();
```

##### java.util.PrintStream

标准字节输出流，默认输出到控制台

```java
PrintStream ps = System.out;
ps.println("123");
ps.println(122);
//标准输出流不需要手动关闭
```

将sout打印从控制台转移到文件中

```java
//标准输出流不在指向控制台，指向1这个文件
PrintStream ps1 = new PrintStream(new FileOutputStream("src/qiangliu8/io/Print/1",true));
System.setOut(ps1);
System.out.println("666");
System.out.println(123);
```





### File类

File类和四大家族类没关系，不能完成文件的读和写

File对象代表：文件和目录路径名的抽象表示形式

C:\Drivers这是一个File对象,C:\Drivers\1.text也是一个File对象。他只是一个路径名的抽象表示形式

File类中常用的方法

```java
//创建一个file对象
File file = new File("src/qiangliu8/io/File/1");
//判断是否存在
System.out.println(file.exists());
//如果不存在，则以文件的形式创建出来
if(!file.exists()){
    file.createNewFile();
}
//如果不存在，则以目录的形式创建出来
if(!file.exists()){
    file.mkdir();
    //以多重目录的形式新建
    file.mkdirs();
}
//获取文件的父路径
System.out.println(file.getParent());//src\qiangliu8\io\File
//获取文件的绝对路径
System.out.println(file.getAbsoluteFile())//F:\Project_Java\advanced\d26\src\qiangliu8\io\File\1
```

```java
File f = new File("src/qiangliu8/io/File/2");
//获取文件名
System.out.println("文件名:"+f.getName());
//判断是否是一个目录
System.out.println(f.isDirectory());
//判断是否是一个文件
System.out.println(f.isFile());
//获取文件最后一次修改时间 1970到现在的总毫秒数
System.out.println(f.lastModified());
//将总毫秒数转换成时间
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
System.out.println(sdf.format(f.lastModified()));
//获取文件大小
System.out.println(f.length());
```

```java
File ff = new File("src/qiangliu8/io/File");
//获取该文件夹下所有子文件
File []fileArr = ff.listFiles();
for (File i:fileArr) {
    System.out.println(i.getAbsolutePath());
}
```

##### java.util.ObjectInputStream

序列化:Serialize Java对象存储到文件中，将Java对象的状态保存下来的过程

反序列化：DeSerialize 将硬盘上的数据重新恢复到内存中，恢复成Java对象

![image-20201104160843206](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201104160843206.png)

**参与序列化的对象必须实现序列化Serializable的接口**

```java
//创建Java对象
Student student1 = new Student(111,"刘强");
//序列化
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/qiangliu8/io/ObjectStream/students",true));
//序列化对象
oos.writeObject(student1);
//刷新
oos.flush();
//关闭
oos.close();
```

通过源代码发现，Serializable接口只是一个标志接口

```java
public interface Serializable {
}
//起到标识的作用，Java虚拟机看到这个类是实现这个接口，会为该类自动生成一个版本号
```

**反序列化**

```java
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/qiangliu8/io/ObjectStream/students"));
Object o = ois.readObject();
System.out.println(o);
ois.close();
```

**序列化多个对象**

```java
//序列化
User u1 = new User(1,"刘强1");
User u2 = new User(2,"刘强2");
User u3 = new User(3,"刘强3");
User u4 = new User(4,"刘强4");
List<User> list = new ArrayList<>();
list.add(u1);
list.add(u2);
list.add(u3);
list.add(u4);
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/qiangliu8/io/ObjectStream/UserList",true));
oos.writeObject(list);
oos.flush();
oos.close();
//反序列化
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/qiangliu8/io/ObjectStream/UserList"));
Object o = ois.readObject();
System.out.println(o instanceof List);
for (User u :(List<User>)o
    ) {
    System.out.println(u);
}
ois.close();
```

Java中采用什么机制区分类

​	第一：首先通过类名进行比对，如果类名不同，则肯定不是同一个类

​	第二：如果类名一样，再怎么进行类的区别？靠序列化版本号进行区分

小鹏编写了一个类: com.bjpowernode .java.bean. Student impLements Serializable

胡浪编写了一个类: com.bjpowernode.java.bean.Student implemerits Serializable

不同的人编写了同一个类，但这两个类确实不是同一个类。这个时候序列化版本就起上作用了。对于java虚拟机来说，java虚拟机是可以区分开这两个类的，因为这两个类都实现了SeriaLizable接口，都有默认的序列化版本号，他们的序列化版本号不一样。所以区分开了。

自动生成序列化的缺陷：一旦代码确定之后，代码不可更改

所以建议手动生成固定序列号

```java
private static final lon serialVersionUID = 112312312322323;
```

### IO&&Properties

以后经常改变的数据，可以单独写到一个文件中，使用程序动态读取。将来只需要修改这个文件的内容，java代码不需要改动，不需要重新编译，服务器也不需要重启。就可以拿到动态的信息。类似于以上机制的这种文件被称为配置文件。
并且当配置文件中的内容格式是:
		key1=value
		key2=value
的时候，我们把这种配置文件叫做属性配置文件。key重复，value会自动覆盖

```java
/*
* Propertires是一个Map集合，key和value都是String类型
* 想将userinfo文件中的数据加载到Proeries对象当中
* */
//新建一个输入流对象
FileInputStream fis = new FileInputStream("src/qiangliu8/io/userinfo");
//新建一个Map对象
Properties pp = new Properties();
//调用Properties对象的load方法将文件中的数据加载到Map集合中
pp.load(fis);//文件中的数据顺着管道加载到Map集合中，其中等号左边做key,右边做value
System.out.println(pp);
System.out.println(pp.getProperty("username"));
System.out.println(pp.getProperty("password"));
```



## 十、多线程

### 进程和线程

1.进程是一个应用程序（软件）

线程是一个进程中的执行场/执行单元，一个进程可以启动多个线程

对于Java程序来说，当再DOS窗口中输入：java HelloWorld.java。之后会启动JVM,而JVM就是一个进程。JVM会再启动一个主线程调用main方法。同时再启动以恶垃圾回收线程负责看护，回收垃圾。

2.进程A和进程B的内存独立不共享

线程A和线程B,**堆内存和方法区内存共享**。但是**栈内存独立，一个线程一个栈**

假设启动10个线程，会有10个栈空间。每个栈和每个栈之间互不干扰，这就是多线程并发

![image-20201105102812437](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201105102812437.png)



对于单核CPU来说，真的可以实现多线程并发嘛？

### 线程的种类

Java中线程分为2类：

1. **用户线程**（main方法）
2. **守护线程**（后台线程），其中最具代表性的就是垃圾回收线程

守护线程的特点：一般是一个死循环，所有的用户线程结束，守护线程自动结束。

#### 守护线程的实现

**m.setDaemon(true);**

```java
public class ThreadTest10 {
    public static void main(String[] args) {
        MyThread10 m = new MyThread10();
        m.setName("守护线程");
        //启动线程之前，将m设置成守护线程
        m.setDaemon(true);
        m.start();
        for (int i = 1; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+(i));
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
class MyThread10 extends Thread{
    @Override
    public void run() {
        int i = 0;
        while (true){
            System.out.println(Thread.currentThread().getName()+"--->"+(++i));
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
```

### 实现线程的方法

Java支持多线程机制，并且已经实现了，我们只需要继承

第一种，编写一个类，直接继承java.lang.Thread,重写run方法

```java
//定义线程类
public class MyThread extends Thread{
	public void run(){
	
	}
}
//创建线程对象
MyThread t new MyThread();
//启动线程
t.start();
```

代码如下：

```java
public class ThreadTest1 {
    public static void main(String[] args) {
        //这里是main主线陈，在主栈种云心
        //新建一个分支线程对象
        myThread mt = new myThread();
        //不会启动线程，不会分配信的分支栈
        //mt.run();
        //启动线程 start作用是启动一个分支线程，在JVM种开辟一个新的栈空间，这段代码完成后就结束了
        //这段代码只是为了开启一个新的栈空间，之傲新的栈空间开发出，start方法就结束了，线程就启动了
        //启动成功的贤臣惠帝总调用run方法，并且run方法在分支栈的栈底部（压栈）
        //run方法在分支栈的栈底部，main方法在主站的栈底部，run和mian是平级的
        mt.start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println("主线程:"+i); //这里的代码还是运行在主线程中
        }
    }
}

class myThread extends Thread{
    @Override
    public void run() {
        //这段程序运行在分支线程种，一定要重写
        for (int i = 0; i <1000 ; i++) {
            System.out.println("分支线程:"+i);
        }
    }
}
```

**start（）方法，这行代码瞬间结束，因为他的任务只是启动分支栈**
第二种，编写一个类，实现java.util.Runnable接口，实现run方法

//定义一个可运行的类

class MyRunnable extends Runnable{

​	public void run(){

​	}

}

//创建线程对象

Thread t = new Thread( new MyRunnable);

//启动线程

t.start();

```java
public class ThreadTest2 {
    public static void main(String[] args) {
        //创建一个可运行的对象
        MyRunnable mr = new MyRunnable();
        //将可运行的对象封装成一个线程对象
        Thread t = new Thread(mr);
        t.start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println("主线程:"+i);
        }
    }

}

//这不是一个线程类，是一个可运行的类，还不是一个线程
class MyRunnable implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("分线程:"+i);
        }
    }
}
```

第二种方式实现接口比较常用，因为实现一个接口，还可以去继承其他类，更灵活

第三种，实现Callable接口（JDK8新特性）

这种方式实现的线程可以获取线程的返回值，前两种是无法获取返回值的

这种方式的优点:可以获取到线程的执行结果。

这种方式的缺点:效率比较低，在获取t线程执行结果的时候，当前线程爰阻塞，效率较低。

```java
//第一步，创建一个未来任务类对象
//参数非常重要，需要给Callable接口实现类对象
FutureTask task = new FutureTask(new Callable() {
    @Override
    public Object call() throws Exception { //call方法相当于run方法 只不过这个有返回值
        //线程执行一个任务，执行之后可能会有一个执行结果
        System.out.println("call begin");
        Thread.sleep(10000);
        System.out.println("call end");
        return new Object();
    }
});
//创建线程对象
Thread t = new Thread(task);
t.start();
Object o = task.get();
//main方法这个的程序要想执行必须等待get()方法的结束
//而get()方法可能需要很久。因为get()方法是为了拿另一个线程的执行结果，而另一个线程是需要执行时间的
System.out.println(o);
System.out.println("helloWorld");
```

### 线程生命周期

![image-20201106100815071](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201106100815071.png)



**新建状态、就绪状态、运行状态、阻塞状态、死亡状态**

### 线程方法

#### **获取线程名字**

```java
MyThread myThread = new MyThread();
myThread.setName("分支线程刘强");
System.out.println(myThread.getName());
myThread.start();
```

#### 获取当前线程

```java
 Thread currentThread = Thread.currentThread();
```

#### 线程sleep()

```java
/*
*   关于线程的sleep方法
* static void sleep(long millis)
* 1.静态方法 Thread.sleep(1000)
* 2.参数是毫秒
* 3。作用：让当前线程进入休眠，进入阻塞状态，放弃占有CPU时间片，让给其他线程使用
* 间隔特定的时间，去执行一定的代码
* */
public class ThreadTest4 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <1000 ; i++) {
                    System.out.println("分支线程："+i);
                    if (i%15==0){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread t = new Thread(r);

        t.start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println("主线程："+i);
        }
    }
}
```

#### 终止睡眠

注意：run()当中的异常不能throws,只能try...catch

因为run()方法在父类种没有抛出任何异常，子类不能比父类抛出更多的异常

```java
m.interrupt();
```

#### 终止线程执行

```java
t.stop()//过时
```

容易丢失数据，因为这种方式直接将线程杀死了，线程没有保存得数据会丢失

```java
public class ThreadTest7 {
    public static void main(String[] args) {
        NyRunnable2 my = new NyRunnable2();
        Thread t= new Thread(my);
        t.start();
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        my.flag= false;
    }
}

class NyRunnable2 implements Runnable{
    boolean flag = true;
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            if (flag){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                return;
            }
        }
    }
}
```

合理得方式

### 线程调度

#### 常见的线程调度

​	**抢占式调度模型**：那个线程的优先级比较高，抢到的CPU时间片的概率就高一点，Java采用的就是抢占式调度模型

**均分式调度模型**：平均分配CPU时间片，每个线程占有的CPU使劲按片时间长度一样。平均分配，一切平等

#### 调度方法

##### 实例方法

void setPriority(int newPriority)  设置线程的优先级

int getPriority() 获取线程优先级

最低优先级1

默认优先级5

最高默认值10

##### 静态方法

###### 让位方法

```java
static void yield（） //
```

暂停当前正在执行的线程对象，并执行其他线程。yield()方法不是阻塞方法，让当前线程让位，让给其他线程使用。yeild() 方法的执行会让当前线程从运行回到就绪状态

###### 合并线程

```java
void join() //
```

```java
class Thead1 extends Thread{
    public void doSome() throws InterruptedException {
        Thread2 t1 = new Thread2();//当前线程阻塞，t线程执行，直到t线程结束，当前线程才能继续
        t1.join();
    }

    @Override
    public void run() {
        super.run();
    }
}
class Thread2 extends Thread{
}
```

###### 优先级

优先级较高的，只是抢到的CPU时间片相对多一些，**大概率方向**更偏向于优先级较高

```java
System.out.println("最高优先级："+Thread.MAX_PRIORITY);//10
System.out.println("最低优先级："+Thread.MIN_PRIORITY);//1
System.out.println("默认优先级："+Thread.NORM_PRIORITY);//5

//获取当前线程对象，获取当前线程的优先级
Thread ct = Thread.currentThread();
System.out.println(ct.getPriority());//5
```

### 多线程安全

多线程安全问题的必须满足以下三个条件：

1. 多线程并发
2. 有共享数据
3. 共享数据有修改行为

##### 线程同步机制

当多线程并发的环境下，有共享数据，并且这个数据还会被修改，此时就存在线程安全问题。

解决：线程排队执行，用排队执行解决线程安全问题，这种机制被称为：**线程同步机制**

##### 异步编程模型

线程t1和线程t2，各自执行各自的,t1不管t2，t2不管t1，谁也不需要等谁，这种编程模型叫做:异步编程模型。其实就是:多线程并发(效率较高。)

异步就是并发。

##### 同步编程模型

线程t1和线程t2，在线程t1执行的时候，必须等待t2线程执行结束，或者说在t2线程执行的时候，必须等待t1线程执行结束，两个线程之间发生了等待关系，这就是同步编程模型。效率较低。线程排队执行

同步就是排队。

#### synchronized

##### 同步代码块

不是共享对象的线程还是异步

```java
synchronized(this){
    //线程同步代码块
    //传过来参数必须是多线程共享的数据 
    double before = this.getBalance();
    double after = before-money;
    try {
        Thread.sleep(1000);
    }catch (Exception e){
        e.printStackTrace();
    }
    this.setBalance(after);
}
```

![image-20201107092333068](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201107092333068.png)

```java
public void run() {
    double money = 500;
    synchronized(act){
        act.withdraw(money);
    }
    System.out.println(Thread.currentThread().getName()+"取款成功，还剩："+act.getBalance());
}
```

这种方法也可以，只不过扩大了同步的范围，效率更低

##### synchronized出现在实例方法上

synchronized出现在实例方法上，一定锁的是this。只能是this,所以这种方法不灵活。并且表示整个方法都需要同步，可能会无故扩大同步的范围，导致程序的执行效率降低，所以这种方式不常用

如果共享的对象就是this,并且需要同步的代码块是整个方法体，建议使用这种方式

```java
public synchronized void doSome(){

}
```

##### synchronized出现在静态方法上

```java
public synchronized static void doSome(){

}
```

#### 线程安全的解决

是一上来就选择线程同步吗? synchronized

不是，synchronized会让程序的执行效率降低，用户体验不好。系统的用户吞吐量降低。用户体验差。在不得已的情况下再选择线程同步机制。

第一种方案:尽量使用局部变量代替"实例变量和静态变量"。

第二种方案:如果必须是实例变量，那么可以考虑创建多个对象，这样实例变量的内存就不共享了。一个线程对应1个对象，100个线程对应100个对象，对象不共享,就没有数据安全问题了。

第三种方案:如果不能使用局部变量，对象也不能创建多个，这个时候就只能选择synchronized了。线程同步机制。



#### 哪些变量会影响线程的安全

Java中有三大变量?

实例变量:在堆中。

静态变量:在方法区。

局部变量:在栈中。

以上三大变量中:局部变量永远都不会存在线程安全问题。因为局部变量不共享。(一个线程一个栈。)局部变量在栈中。所以**局部变量永远都不会共享。**

实例变量在堆中,堆只有1个.

静态变量在方法区中，方法区只有1个-

**堆和方法区都是多线程共享**的，所以可能存在线程安全问题。

#### 死锁的产生

![image-20201107105925347](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201107105925347.png)



```java
class MyThread1 extends  Thread{
    Object o1;
    Object o2;
    public MyThread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
    @Override
    public void run() {
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

            }
        }
    }
}
class MyThread2 extends  Thread{
    Object o1;
    Object o2;

    public MyThread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
    @Override
    public void run() {
        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){

            }
        }
    }
}
```

### 定时器

间隔特定的时间，执行特定的程序

可以使用sleep方法，睡眠，设置睡眠时间，没到这个时间点醒来，执行任务。这种方式是最原始的定时器。(比较low )

在java的类库中已经写好了一个定时器:java.util.Timer，可以直接拿来用。

```java
public class TimerTest {
    public static void main(String[] args) throws ParseException {
        //创建定时器对象
        Timer timer = new Timer();
        //Timer timer = new Timer(true);//守护线程的方式
        int i = 0;
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstname = sim.parse("2020-03-14 09:30:00");
        //指定定时任务
        timer.schedule(new LogTimerTask(),firstname,5000);
    }
}
//编写一个定时任务类
class LogTimerTask extends TimerTask{

    @Override
    public void run() {
        Date firstname =new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sim.format(firstname)+"循环任务--已执行");
    }
}
```

还可以使用匿名内部类的方式

```java
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        
    }
}, firstname, 5000);
```

### 生产者和消费者模式

Object对象自带的wait() 、notify() ，不是线程对象的方法，任何一个Java对象都有

#### wait()方法

```java
Object obj = new Object();
obj.wait();//表示让obj对象上活动的线程进入等待状态，无期限等待，直到被唤醒为止
//o.wait()方法的调用会让当前线程进入等待状态
```

T线程在o对象上活动。T线程是当前线程对象。

当调用o.wait()方法之后。T线程进入**无期限等待**。当前线程进入等待状态。

直到最终调用o.notify()方法。o.notify()方法的调用可以让正在o对象上等待的线程**唤醒**。

#### notify()方法

```java
Object obj = new Object();
obj.notify();//表示唤醒正在o对象上等待的线程
obj.notifyAll();//表示唤醒正在o对象上处于等待的所有线程
```

#### 生产者和消费者模式结构图

![](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201107165311874.png)





生产线程负责生产，消费线程负责消费

生产线程和消费线程需要达到均衡。这是一种特殊的业务需求，在这种情况下，需要使用wait和notify方法

wait和notify方法建立在线程同步的基础上，因为多线程要同时操作一个仓库，有线程安全问题

wait方法的作用：o.wait()让正在o对象上活动的线程t进入等待状态，**并且释放掉t线程之前占有的o对象的锁**

notify方法的作用：o.notify让正在o对象上等待的线程唤醒，只是通知，**不会释放o对象上之前占有的锁**

#### 实现生产者和消费者模式

模拟需求如下：

仓库采用List集合，List集合中假设只能存储1个元素，1个元素就表示仓库满了。如果List集合中元素个数是0，就表示仓库空了。保证List集合永远都是最多存储1个元素。即生产1个，消费1个

```java
public class ProducerTest1 {
    public static void main(String[] args) {
        //创建一个仓库对象，共享的
        List list = new ArrayList();
        ///创建两个线程对象
        Produer p = new Produer(list);
        Consumer c = new Consumer(list);
        //生产者线程
        Thread t1 = new Thread(p);
        t1.setName("生产者线程");
        //消费者线程
        Thread t2 = new Thread(c);
        t2.setName("消费者线程");

        t1.start();
        t2.start();
    }
}
```

```java
//生产线程
class Produer implements Runnable{
    private List list;

    public Produer(List list) {
        this.list = list;
    }

    @Override
    public void run() { //一直生产
        while (true){
            //给仓库对象加锁
            synchronized (list){
                if (list.size()>0){//大于0说明仓库已经有1个元素了
                    //当前线程等待状态，并且释放Produer之前占有的List集合的锁
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果程序可以执行到这里，则可以生产
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName()+"-->"+obj);
                //唤醒消费者进行消费
                list.notify();
            }
        }
    }
}
```

```java
//消费线程
class Consumer implements Runnable{
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() { //一直消费
        while (true){
            synchronized (list){
                if (list.size()==0){//大于0说明仓库已经有1个元素了
                    //当前线程等待状态，并且释放Produer之前占有的List集合的锁
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName()+"-->"+obj);
                //唤醒生产者生产
                list.notify();
            }
        }
    }
}
```

## 十一、反射机制

通过java语言中的反射机制可以操作字节码文件，可以读和改字节码文件。通过反射机制可以操作代码片段

反射机制的相关类在哪个包：java.lang.reflect.*

反射机制的相关类：

java.lang.Class :代表字节码文件，代表整个类

java.lang.reflect.Method：代表字节码文件中的方法字节码，代表类中的方法

java.lang.reflect.Constructor: 代表字节码中的构造方法字节码，代表类中的构造方法

java.lang.reflect.Field：代表字节码中的属性字节码，代表类中的成员

![image-20201107202407719](C:\Users\xiaoqiang\AppData\Roaming\Typora\typora-user-images\image-20201107202407719.png)

```java
//操作一个类的字节码，需要首先获取这个类的字节码
//第一种： Class c= new Class.forName("完整类名带包名");
//第二种：Class c = 对象.getClass();
//第三种：Class c = String.class; Class c = Date.class;
```

```java
//静态方法
//方法的参数是个字符串，字符串需要一个完成类名，必须带有报名，java.lang不能省略
Class c1 = Class.forName("java.lang.String");
Class c2 = Class.forName("java.util.Date");
//Java中任何一个对象都有一个方法 getClass
String str ="123";
Class x = str.getClass();//x代表String.class字节码文件，x代表String类型
System.out.println(c1 ==x);//c2和y 两个变量中保存的内存地址是一样的，都指向方法区中的字节码文件
//==判断内存地址是否一样
```

#### 通过反射实例化对象

```java
Class c = Class.forName("qiangliu8.User.User");
//这个方法会调用User这个类的无参数构造方法，完成对象的创建
Object o = c.newInstance();
System.out.println(o);
```

通过Class的newInstance()方法来实例化对象。注意：newInstance()方法内部实际上调用了无参数构造方法，**必须保证无参构造存在**才可以

#### 通过读属性文件实例化对象

```java
Properties p = new Properties();
//通过IO读取user.properties文件
FileInputStream fis = new FileInputStream("src/qiangliu8/User/user");
p.load(fis);
System.out.println();
Class c1 = Class.forName(p.getProperty("admin"));
Object o = c1.newInstance();
System.out.println(o);
```

```java
admin=java.util.Date//src/qiangliu8/User/user的文件
```

#### 只执行静态代码块 可以使用forName

forName会导致类加载，类加载时静态代码块执行

```java
class ss{
    static {
        System.out.println("我是静态代码块");
    }
}


Class.forName("Reflect.ss"); //我是静态代码块
```

#### 绝对路径代替相对路径

```java
//这种方式缺点是移植性差，idea默认的当前路径是Project的根
FileInputStream fis = new FileInputStream("src/qiangliu8/User/user");


//Thread.currentThread() 当前线程对象
//getContextClassLoader() 线程对象的方法，可以获取到当前线程的类加载器对象
//getResource 获取子u按，这是类加载器对象的方法，当前线程的类加载器默认从类的根路径下加载资源

//获取文件的绝对路径，从类的根路径下作为起点开始 src文件夹
String path = Thread.currentThread().getContextClassLoader().getResource("qiangliu8/User/User").getPath();
System.out.println(path);//  /F:/Project_Java/advanced/d28/out/production/d28/qiangliu8/User/User
```

#### 以流的形式返回

**绝对路径传给流**

```java
String path = Thread.currentThread().getContextClassLoader().getResource("23").getPath();
FileInputStream fis = new FileInputStream(path);
Properties pp = new Properties();
pp.load(fis);
System.out.println(pp.getProperty("admin"));//123123
```

**流的形式传给Map**

```java
//getResourceAsStream直接返回流
InputStream path1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("23");
Properties pp1 = new Properties();
pp1.load(path1);
System.out.println(pp1.getProperty("admin"));////123123
```

#### 资源绑定器

java.util包下提供了一个资源绑定器，便于获取属性配置文件中的内容。

以下方法必须将属性配置文件放入类路径下

```java
//资源绑定器只能绑定xxx.properites,文件必须在类路径下
//并且文件扩展名必须是properties 写路径的时候 扩展名不用写
ResourceBundle bundle = ResourceBundle.getBundle("23");
System.out.println(bundle.getString("admin"));//123123
```

### 类加载器

专门负责加载类的命令/工具

JDK中自带了3个累加载器:**启动类加载器、扩展类加载器、应用类加载器**

```java
假设：String str = "adc";
//代码会在开始执行前，将所需要类全部加载到JVM中。通过类加载器加载，看到以上代码类加载器会找到String.class文件，找到就加载。
//1。首先通过“启动类加载器”，它专门加载：rt.jar文件。该文件都是JDK最核心的类库
//2.如果通过“启动类加载器”加载不到的时候，会通过“扩展类加载器”，它专门加载ext/*.jar
//3.如果通过“扩展类加载器”加载不到的时候，会通过“应用类加载器**”，它专门加载classpath的中的类
```

### 获取Field属性

```java
public class Student {
    //File属性
    public int no;
    private String name;
    protected int age;
    boolean sex;
}
```

#### 获取类中所有public 修饰的Filed

```java
//获取整个类
Class studentClass = Class.forName("Reflect.Student");
//获取类中所有public 修饰的Filed
Field[] fields1 = studentClass.getFields();
System.out.println(fields1.length); //1     获取一个field
Field f = fields1[0];
System.out.println(f.getName());//no
```

#### 获取类中所有的Filed

```java
//获取类中所有Filed
Field[] fields2 = studentClass.getDeclaredFields();
System.out.println(fields2.length);//4
//遍历field的类型
for (Field f1:fields2) {
	System.out.println(f1.getType().getName);
}
```

#### 获取类中Filed类型

```java
for (Field f1:fields2) {
    System.out.println(f1.getName());
}
//int
//java.lang.String
//int
//boolean
for (Field f1:fields2) {
    System.out.println(f1.getType().getSimpleName());
}
//int
//String
//int
//boolean
```

#### 获取类中Filed修饰符

```java
for (Field f1:fields2) {
    int i = f1.getModifiers();
    System.out.println(Modifier.toString(i));
}
```

#### 反编译Fileld

```java
//创建这个是为了拼接字符串
StringBuilder sb = new StringBuilder();

Class studentClass = Class.forName("Reflect.Student");
sb.append(Modifier.toString(studentClass.getModifiers())+" class"+studentClass.getSimpleName()+"{\n");
Field[] fields1 = studentClass.getDeclaredFields();
for (Field f: fields1) {
    sb.append("\t");
    sb.append(Modifier.toString(f.getModifiers()));
    sb.append("\t");
    sb.append(f.getType().getSimpleName());
    sb.append("\t");
    sb.append(f.getName());
    sb.append(";\n");
}
sb.append("}");
System.out.println(sb);
}
//public classStudent{    
//    public  int no;    
//    private String  name;    
//    protected   int age;        
//    boolean sex;
//}
```

#### 通过反射机制访问对象属性

```java
Class studentClass = Class.forName("Reflect.Student");

//        反射机制三要素
//                1.obj对象
//                2.属性名
//                3.属性值
//创建Student对象
Object obj = studentClass.newInstance();
//获取no属性（“根据属性名称赋值”）
Field nofiled = studentClass.getDeclaredField("no");
//给obj对象的属性no赋值
nofiled.set(obj,110);
//读取属性的值
System.out.println(nofiled.get(obj));
```

```java
//访问私有属性
Field namesfileds = studentClass.getDeclaredField("name");
namesfileds.set(obj,"刘强");
System.out.println(namesfileds.get("name"));
//报错！！！class Reflect.ReflectTest7 cannot access a member of class Reflect.Student with modifiers "private"
```

**反射机制缺点：可以打破封装！！**

```java
Field namesfileds = studentClass.getDeclaredField("name");
namesfileds.setAccessible(true);//可以打破
namesfileds.set(obj,"刘强");
System.out.println(namesfileds.get(obj));
```

### 反射Method

```java
//获取类
Class userServiceClass = Class.forName("Reflect.UserService");
//获取方法
Method[] methods = userServiceClass.getDeclaredMethods();
for (Method m:methods) {
    //获取方法名
    System.out.println(m.getName());
    //获取方法的返回值类型
    System.out.println(m.getReturnType().getSimpleName());
    //获取方法的修饰符
    System.out.println(Modifier.toString(m.getModifiers()));
    //返回方法的参数类型
    Class[] parameterTypes = m.getParameterTypes();
    for (Class c:parameterTypes) {
        System.out.println(c.getSimpleName());
    }
}
```

#### 反编译Method

```java
//获取类
Class userServiceClass = Class.forName("Reflect.UserService");
StringBuilder sb = new StringBuilder();
sb.append(Modifier.toString(userServiceClass.getModifiers())+" class "+userServiceClass.getSimpleName()+" {\n");

Method[] methods = userServiceClass.getDeclaredMethods();
for (Method m:methods) {
    sb.append("\t");
    sb.append(Modifier.toString(m.getModifiers())+" ");
    sb.append(m.getReturnType()+" "+m.getName());
    sb.append("(");
    Class[] parm = m.getParameterTypes();
    for (int i = 0; i <parm.length ; i++) {
        if ((i+1)<parm.length)sb.append(parm[i].getSimpleName()+" ,");
        else sb.append(parm[i].getSimpleName());
    }
    sb.append(")");
    sb.append("{\n\t}\n");
}
sb.append("\n}");
System.out.println(sb);
}
```

#### 反射机制调用Method方法

```java
Class UserSerVice = Class.forName("Reflect.UserService");
//创建对象
Object obj = UserSerVice.newInstance();
Method loginMethods = UserSerVice.getDeclaredMethod("login",String.class,String.class);
Method logoutMethods = UserSerVice.getDeclaredMethod("logout");
//调用对象方法
Object o = loginMethods.invoke(obj,"admin","123");
if (o .equals(true)){
    System.out.println("登录成功");
}
logoutMethods.invoke(obj);
```

### 反射Constructor

```java
StringBuilder sb = new StringBuilder();
Class vipClass = Class.forName("qiangliu8.Constructor.Vip");
sb.append(Modifier.toString(vipClass.getModifiers()));
sb.append(" class ");
sb.append(vipClass.getSimpleName());
sb.append(" {\n");

Constructor[] constructors = vipClass.getConstructors();
for (Constructor c:constructors) {
    sb.append("\t");
    sb.append(Modifier.toString(c.getModifiers()));
    sb.append(" ");
    sb.append(vipClass.getSimpleName());
    sb.append("(");
    Class[] Parms = c.getParameterTypes();
    for (int i = 0; i <Parms.length ; i++) {
        if(i+1<Parms.length )sb.append(Parms[i].getSimpleName()+", ");
        else sb.append(Parms[i].getSimpleName());
    }
    sb.append(")");
    sb.append(" {\n");
    sb.append("\t}\n");
}
sb.append("\n}");
System.out.println(sb);
```

#### 反射机制调用构造方法

```java
Class vipClass = Class.forName("qiangliu8.Constructor.Vip");
Object o = vipClass.newInstance();//调用无参数方法
//调用有参数构造方法
//第一步先获取这个有参数的构造方法
Constructor c =vipClass.getDeclaredConstructor(int.class, String.class,String.class,boolean.class);
//第二步调用构造方法new对象
Object o1 = c.newInstance(110,"刘强","19971003",true);
System.out.println(o1);//Vip{no=110, name='刘强', birth='19971003', sex=true}

//调用无参数构造方法
//第一步先获取这个有参数的构造方法
Constructor c1 = vipClass.getDeclaredConstructor();
//第二步调用构造方法new对象
Object o2 = c1.newInstance();
System.out.println(o2);//Vip{no=0, name='null', birth='null', sex=false}
```

#### 反射父类和父接口

```java
//String举例
Class StringClass = Class.forName("java.lang.String");
//获取String的父类
Class superClass = StringClass.getSuperclass();
System.out.println(superClass.getSimpleName());
//Object

//获取String实现的锁头接口
Class[] interfaces = StringClass.getInterfaces();
for (Class c:interfaces) {
    System.out.println(c.getName());
}
//java.io.Serializable
//java.lang.Comparable
//java.lang.CharSequence
```

### 可变长度参数

```java
public static void main(String[] args) {
    doSome(); //doSome!!!!
    doSome(23);//doSome!!!!
    doSome(123,123);//doSome!!!!
    //编译报错
    doSome("we");
}
public static void doSome(int...args){
    System.out.println("doSome!!!!");
}
```

**可变长度参数只能在参数列表中，最后一个位置上，且只能有一个**

```java
public static void doOther(int i,String...args){
    System.out.println("doSome!!!!");
}
```

**可变长度参数的arg可当作一个数组传进来，也可以传一个数组**

```java
public static void doOther(int i,String...args){
    System.out.println(args.length);
    for (String s:args) {
        System.out.println(s);
    }
}

doOther(1,"刘强","吴云");
String[] str = {"1","2","3"};
doOther(1,str);//数组只能由一个
```

## 十二、注解

```
注解，或者叫注释 Annotation
注解是一种引用数据类型，编译之后也是xxx.class文件
语法格式：
    【修饰符列表】 @interface 注解类型名{
    
    }
使用： @注解类型名
注解可以出现在类上、属性上、方法上、变量和注解类型上
```

**使用案例**

```java
public class AnnotationTest1 {
    @MyAnnotation
    private int no;
    @MyAnnotation
    public AnnotationTest1(int no) {
        this.no = no;
    }
}
@MyAnnotation
interface MyInterface{

    
}
@MyAnnotation
enum Sesaon{
    Sping,summer,autumn,winter
}


@MyAnnotation
public @interface MyAnnotation {
}

```

### **JDK内置注解**

java.lang 下的注释类型

#### Deprecated注解

Deprecated用@Deprecated注释的程序元素，不鼓励程序员使用这样的元素，通常是因为它很危险或存在更好的选择。

这个注解告诉程序员，该元素已过时，有更好的解决方法

```java
@Retention(RetentionPolicy.RUNTIME)//表示被标注注解类型的Deprecated注解只能保留在class文件中,并且可以被反射机制所读取
```

#### Override注解

Override表示一个方法声明打算重写超类中的另一个方法声明。

这个注解**只能注解方法**，并且这个注解是给编译器参考的，和运行阶段没有关系

凡是Java中的方法带有这个注解的，编译器都会进行编译检查，如果这个方法**不是重写父类的方法**，编译报错

不用掌握:

suppresswarnings指示应该在注释元素（以及包含在该注释元素中的所有程序元素)中取消显示指定的编译器警告。

#### 元注解

用来标注注解类型的注解，称为元注解

常用的元注解:

**Target** 用来标注”被标注的注解“可以出现在哪些位置上

```java
@Target({ElementType.METHOD})//表示被标注注解类型的注解只能出现在方法上
```

**Retention**用来标注”被标注的注解“最终保存到哪里

```java
@Retention(RetentionPolicy.SOURCE)//表示被标注注解类型的注解只能保留在java源文件中
@Retention(RetentionPolicy.CLASS)//表示被标注注解类型的注解只能保留在class文件中
@Retention(RetentionPolicy.RUNTIME)//表示被标注注解类型的注解只能保留在class文件中,并且可以被反射机制所读取
```

**Retention源代码**

```java
public @interface Retention {
    RetentionPolicy value();
}
public enum RetentionPolicy {
    SOURCE,
    CLASS,
    RUNTIME;

    private RetentionPolicy() {
    }
}
```



#### 注解定义属性

注解一旦有属性，那么用注解时，需要给属性赋值

```java
public @interface MyAnnotation2 {
    //属性name
    String name();
    int age();
    int no() default 1; //属性指定默认值，可以不用再赋值
}


@MyAnnotation2(name="刘强"，age=23)
public static void doSome(){
    System.out.println("do doSome");
}
```

##### 属性是value时可以省略

```java
@MyAnnotation3("hah") //是value就可以省
public static void doOther(){
    System.out.println("do doOther");
}

public @interface MyAnnotation3 {
    String value();//有两个属性就不行
}
```

##### 属性是一个数组

```java
@MyAnnotation4(value={1,2,3},fw={Festival.AUTUMN})
int age = 0;

public @interface MyAnnotation4 {
    int[] value();
    Festival[] fw();
}

public enum Festival {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER
}
```

### 反射注解

```java
//获取这个类
Class annotationClass = Class.forName("qiangliu8.annotation.MyAnnotation5");
//判断类上面是否有注解
System.out.println(annotationClass.isAnnotationPresent(Target.class));
System.out.println(annotationClass.isAnnotationPresent(Retention.class));
System.out.println(annotationClass.isAnnotationPresent(MyAnnotation3.class));

MyAnnotation3 ts = (MyAnnotation3)annotationClass.getAnnotation(MyAnnotation3.class);
System.out.println(ts.value());123




@MyAnnotation3("123")/这里要加上 不然反射机制读不到
//只允许该注解可以标注类、方法
@Target({ElementType.TYPE,ElementType.METHOD})
//允许该注解可以被反射
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation5{
}


@Retention(RetentionPolicy.RUNTIME) //这里要加上 不然反射机制读不到
public @interface MyAnnotation3 {
    String value();
}
```

#### 通过反射获取对象属性的值

```java
//获取dosome方法上的注解信息
Class c = Class.forName("qiangliu8.annotation.AnnotationTest5");
//获取doScome方法
Method m = c.getDeclaredMethod("doSome");
//判断这个方法上是否存在这个解
System.out.println(m.isAnnotationPresent(Annotation.class));
Annotation a = m.getAnnotation(Annotation.class);

System.out.println(a.username());
System.out.println(a.password());

}

@Annotation(username = "刘强",password = "1102644615")
public static void doSome(){
}
```

### 注解在开发中的作用
