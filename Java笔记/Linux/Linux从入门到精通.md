# Linux从入门到精通

[TOC]



## 一、简介

### 1.1linux简介

一种开源、免费的操作系统，安装在计算机硬件上，管理计算机硬件和软件资源的系统软件。

注重安全性、稳定性、高并发处理能力。没有优异的可视化界面

Windows用于个人计算机, Linux用于企业服务器上。

### 1.2linux的发行版本

linus在1991年开发，linux的内核程序，后来很多软件开发组织以及软件公司在内核程序基础之上，陆续推出很多不同版本的linux操作系统: ubuntu (乌班图)、RedHat (红帽)、CentOS.

## 二、Linux起步

### 2.1 安装linux操作系统

1. **虚拟机**:可以用软件模拟出一套具有完整硬件系统功能的、运行在一个完全隔离环境中的完整计算机系统。
2. **安装linux: linux的镜像**
   可视化界面比较单薄，很少使用;使用linux多数都是基于终端命令使用linux指令操作计算机。

### 2.2 linux的目录结构

1. linux只有一个根目录。	 /

2. 层级式的子目录

   ![image-20210315145258602](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210315145258602.png)	

   1.  **/root** : 该目录为系统管理员目录，root是具有超级权限的用户。
   2.  **bin ->usr/bin** : 存放系统预装的**可执行程序**，这里存放的可执行文件可以在系统的任何目录下执行(**相当于配置了path环境目录，哪都可以用**)。****
   3. **/usr**是linux的**系统资源目录**，里边存放的都是一些系统可执行文件或者系统以来的一些文件库。
   4. **/usr/local/bin**：存放用户自己的可执行文件，同样这里存放的可执行文件可以在系统的任何目录下执行。
   5. **/etc**: 这个目录存放所有的系统管理所需要的**配置文件**
   6. **/home**：**普通用户的主目录**，在Linux中，每个用户都有一个自己的目录，一般该目录名以用户的账号命名，叫作用户的根目录；**用户登录以后，默认打开自己的根目录。**
   7. **/opt**: 这是给linux**额外安装软件**所存放的目录。比如你安装一个Oracle数据库则就可以放到这个目录下，默认为空。相当于windows系统中的Program files目录。
   8. **lib->usr/lib**: 这个目录存放着系统最基本的动态连接共享库（DLL库），其作用类似于Windows里的DLL文件，几乎所有的应用程序都需要用到这些共享库。
   9. **/boot** : 这个目录存放启动Linux时使用的**一些核心文件**，包括一些连接文件以及镜像文件
   10. **/dev**: dev是Device(设备)的缩写, 该目录下存放的是Linux的外部设备，Linux中的设备也是以文件的形式存在。
   11.  **/var** : 这个目录存放着在不断扩充着的东西，我们习惯将那些经常**被修改的文件**存放在该目录下，比如运行的各种日志文件。
   12. **/mnt** : 系统提供该目录是为了让用户临时挂载别的文件系统，我们可以将光驱挂载在/mnt/上，然后进入该目录就可以查看光驱里的内容
   13.  **/tmp**: 这个目录是用来存放一些**临时文件**的。

### 2.3 Linux的远程操作

#### Xshell：linux的终端模拟软件（只能操作，不可传输）

1. 安装并破解:解压、破解(运行两个.bat文件)、启动(xshell)

2. 连接远程linux系统:

   1. 查看linux系统的ip地址：ifconfig

      ![image-20210315161149347](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210315161149347.png)

   2. 创建会话: 添加ip地址

      ![image-20210315161236187](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210315161236187.png)

   3. 输入root和密码

#### xftp:文件传输软件

安装并破解:解压、破解(运行两个.bat文件)、启动(xftp)连接远程

linux系统:创建会话:

## 三、Linux系统管理

### 3.1 vi&vim编辑器

是Linux中的文本编辑器，用来查看linux中查看或编辑文本文件，和windows中的记事本类似。

vim是vi的增强版本，vi绝大多数用法在vim都适用

#### vi模式

1. **一般模式**：用vi命令打开，进入一般模式，只能查看，但不可编辑

2. **编辑模式**：在一般模式下，按i或者a键进入编辑模式。可以编辑文件内容;
   但是不能保存编辑的内容。

3. **命令行模式**：:在一般模式下，按shift+:,进入命令行模式;

   输入	:q!-----不保存强制退出编辑器

   输入	:wq-----保存且退出编辑器

   输入	:q-----退出编辑器

#### vi快捷键

![image-20210315182525056](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210315182525056.png)

**复制当前行**:在一般模式下，按yy，把光标所在行复制到剪切板按p,把剪切板中的内容粘贴到光标所在的下一行。

**复制当前行往下5行**:在一般模式下，按5yy，把光标所在行往下5行复制到剪切板按p，把剪切板中的丙容粘贴到光标所在的下一行。

**在文本文件中查找关键字**:在命令行模式下，输入/关键字，回车。按n表示光标查找下一个关键字

**删除光标所在的当前行**:在一般模式下，按dd，删除光标所在的当前行

**删除光标所在的5行**:在一般模式下，按5dd，删除光标所在的5行

**撤销**：在一个文件中输入"xxxx" ,然后又撤销这个动作(u)。

**设置行号**：命令行模式下，设置文件的行号，取消文件的行号.[命令行下(: set nu) 和(:set nonu)]。



### 3.2 linux用户管理

Linux系统是一个多用户多任务的操作系统，任何一个要使用系统资源的用户，都必须首先向系统管理员申请一个账号，然后以这个账号的身份进入系统。root用户是系统默认创建的管理员账号。

#### 添加用户 useradd [选项]  用户名

> useradd xxx(用户名)

1. 创建一个用户xxx
2. 在/home目录创建用的户的根目录，目录名称默认跟用户名相同 
3. 在linux中任何一个用户至少属于一个组，新建用户如果不指定组，则会新建一个组，组名跟用户名相同。并且把该用户添加到该组中。

> useradd  -d /home/ww  yuwenzhu

创建一个用户yuwenzhu同时，指定用户的目录地址 /home/ww 

#### 设置密码  passwd 用户名

> passwd xxx(用户名)

#### 删除用户 userdel 用户名

必须得是root管理员才可以删除

> userdel xxx（用户名）
>
> userdel -r xxx(用户名) 删除用户的同时级联删除目录

#### 查看用户信息 id 用户名

> id xxx(用户名)

#### 切换用户 su

> su xxx（用户名）

注意：从高权限用户切换到低权限用户时，不需要输密码；否则，需要输密码。

另：exit命令可以回到原来的用户。

### 3.3 Linux组管理

liunx中的组相当于角色的概念，可以对有共性的用户进行统一管理。

每一个用户至少属于一个组，不能独立于组存在，也可以属于多个组。

#### 添加组 groupadd 组名

> groupadd xxx(组名)

#### 删除组 groupadd 组名

> groupdel xxx(组名)

#### 添加用户进组	gpasswd -a 用户名 用户组名

> gpasswd -a xxx xxxx

#### 移除用户出组	gpasswd -d 用户名 用户组名

> gpasswd -d xxx xxxx

#### 创建用户时指定组	useradd -g 用户组名 用户名

> useradd -g  xxx xxx

#### 3.4 系统操作命令

**shutdown now**： 立刻进行关机

**shudown -h 1**：  1小时后会关机了

**shutdown –r now**： 现在重新启动计算机

**reboot**： 现在重新启动计算机

**sync**： 把内存的数据同步到磁盘.



## 四、linux中实操指令

### 4.1Linux帮助指令

1. 用来查看linux系统手册上的帮助信息： **man+命令**

   man ls

   分屏显示、按回车翻一页、按空格翻一页、按q退出查看

2. 用来查看命名的内置帮助信息： help +命令

   help cd

### 4.2文件目录指令

#### 4.2.1 查看当前所在目录：pwd

#### 4.2.2 查看当前目录下所有的子目录或者文件列表：ls  

##### 查看指定目录下所有的子目录或者文件列表：ls  指定目录

##### 查看指定目录下所有的子目录或者文件列表（以列表形式）：ls  -l 指定目录

##### 查看指定目录下所有的子目录或者文件列表（包括虚拟的目录）：ls  -a 指定目录

##### 查看指定目录下所有的子目录或者文件列表（以列表形式,包括虚拟的目录）：ls  -al 指定目录

#### 4.2.3  切换目录： cd 目录名

**绝对目录**：以盘符开头的目录	cd /opt/testDir

**相对目录**：以目录名开始的目录 cd testDir

**~** 	当前用户的根目录  root用户的根目录是/root，普通用户的根目录是在/home/xx

**cd ..**    去当前目录上一级目录

**cd .**    去当前目录

#### 4.2.4  创建目录： mkdir

**绝对目录**：mkdir  /opt/testDir/test1 在 /opt/testDir目录下创建一个目录test1

**相对目录**：mkdir  test2 在当前目录下创建一个目录test2

**一次创建多级目录 ：**mkdir /A/B/C

#### 4.2.5  删除一个空目录： rmdir 目录名

rmdir test1

#### 4.2.6  创建文件: vi/vim

#### 4.2.7  创建一个或多个空文件: touch 文件名列表（文件名之间用空格隔开）

touch test1.text

touch test1.text test2.text test3.text test4.text

#### 4.2.8  复制文件或目录：cp source(源) dest(目标)

cp test1.txt test2  把test1.txt复制到test2目录中

 cp  -r  test1 test2 将test1目录复制到test2目录中

#### 4.2.9  删除文件或目录：rm 文件名或者目录名

rm test.txt 		提示删除文件

rm -f test.txt	 强制删除文件

rm删不了目录，删除目录只能

rm -f   提示递归的删除

rm -rf   强制递归的删除

#### 4.2.10  移动文件或目录：mv source(源) dest(目标)

mv test1.txt test2  把test1.txt移动到test2目录中

 mv test1 test2  把test1目录移动到test2目录中

 mv test1.txt test2.txt  **文件重命名**

#### 4.2.11 输出系统变量或者常量的值到命令行终端： echo $变量名

echo $AVA_HOME

echo $PATH

echo HelloWorld 输出helloworld常量

#### 4.2.12 将前一个查看指令中的结果追加写入到目标文件中：查看命令 >> 文件名

是追加，如果文件按不存在则创建新文件

#### 4.2.13查看指令：cat [选项] 要查看的文件名

cat -n result.txt

#### 4.2.14全屏幕的方式按页显示文本文件: more 文件名

more result.txt

![image-20210316142929003](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316142929003.png)

#### 4.2.15 分屏查看文件内容： less 文件名

持各种显示终端。less指令在显示文件内容时，并不是一次将整个文件加载之后才显示，而是根据显示需要加载内容，对于显示大型文件具有较高的效率。

![image-20210316143124987](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316143124987.png)

#### 4.2.16 查看文本前几行内容：head 文件名

**head result.txt**  默认查看result.txt前10行

**head -n 5 result.txt**  默认查看result.txt前5行

4.2.17查看文本后几行内容：tail文件名

**tailresult.txt**  默认查看result.txt后10行

**tail-n 5 result.txt**  默认查看result.txt后5行

#### 4.2.17 把前一个查看命令的结果输出到指定的文件中：查看命令 > 文件名

ls  > result

ls  -al > result

将ls查看的结果 全部打印到result.txt中去了

如果文件不存在

**cat result.txt > path.txt**

相当于把result.txt的内容复制到path.txt中去了

![image-20210316135927798](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316135927798.png)



### 4.3 时间日期指令

#### 4.3.1查看或者设置系统的日期或者时间：date

1) date（功能描述：显示当前时间）

2) date +%Y（功能描述：显示当前年份）

3) date +%m（功能描述：显示当前月份）

4) date +%d（功能描述：显示当前是哪一天）

5) date "+%Y-%m-%d %H:%M:%S"（功能描述：显示年月日时分秒）

6) date -s 字符串时间（功能描述：设置日期

![image-20210316144208152](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316144208152.png)

#### 4.3.2 查看当前日历：cal

cal ：查看当前月份日历

cal 2020：指定2020的日历

### 4.4 搜索查找指令

#### 4.4.1 搜索文件或目录：find 【搜索范围】【搜索标准】关键字

**find *.txt** 搜索当前目录下，所有的.txt文件

**find *e*** 搜索当前目录下，所有名称中包含e的文件或者目录

**find  /etc  *.txt** 所有etc目录下所有.txt文件

**find  /etc  -size -5k **搜索etc目录，所有小于5k的文件

**find  /etc -user liuqiang **搜索etc目录，所有者是刘强的文件和目录

#### 4.4.2 在整颗目录树中搜索文件和目录（速度快），都是根据名称搜索：locate

因为目录树因为更新策略不及时，所以locate可能搜索不对。需要先updatedb 跟新一下再搜索

updatedb

locate *.txt

#### 4.4.3 搜索过滤命令，在前一个搜索命令的结果中进行按名称进一步过滤: 搜索命令|grep 【选项】过滤条件

find *.txt|grep new 搜索当前目录下，所有名称包含new的.txt文件

cat t1.txt|grep beijing搜索t1.txt文件中 beijing的行

cat t1.txt|grep - i beijing搜索t1.txt文件中 beijing的行，忽略大小写

cat t1.txt|grep - ni beijing搜索t1.txt文件中 beijing的记录，忽略大小写,显示行号



### 4.5 压缩解压命令

#### 4.5.1 压缩或者解压单个文件

**gzip(压缩) 文件名**  压缩单个文件，生成一个.gz的压缩包  ，并且源文件删除

![image-20210316160448629](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316160448629.png)

**gunzip(解压) 压缩包名**，并且源压缩包删除

![image-20210316160537195](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316160537195.png)

#### 4.52 压缩或者解压多个文件和目录

**zip(压缩) 目标压缩包名称 文件1 文件2 **   压缩多个文件，生成指定类型的压缩包  ，并且源文件不会删除

![image-20210316161737935](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316161737935.png)

**unzip(解压) 压缩包名 **，将指定的.zip压缩包解压到当前目录，并且源压缩包不会删除

![image-20210316161936055](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316161936055.png)

**unzip(解压) 压缩包名 -d 解压目录地址 **，将指定的.zip压缩包解压到指定目录，并且源压缩包不会删除

#### 4.5.3 打包或者解压文件： tar [选项]  [打包的内容]

-c：产生.tar.gz打包文件

-v：显示详细信息

-f：指定压缩后的文件名

-z：打包同时压缩

-x：解压.tar.gz文件

-C: 指定解压到哪个目录

**tar -zcvf xxx.tar.gz 文件或者目录列表**

![image-20210316163245576](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316163245576.png)

**tar -zxvf xxx.tar.gz -C  解压目录**

![image-20210316163544648](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316163544648.png)



### 4.6 组管理指令

#### 4.6.1 文件或者目录与组介绍

每一个**用户**至少属于一个组，不能独立于组存在，**也可以属于多个组。**

每一个**文件或者目录**至少属于一个组，不能独立于组存在，**只能属于一个组。**

文件或者目录通过组来控制哪些用户可以对它进行哪些操作，即文件或者目录的访问权限

在文件或者目录看来，所有的用户分为三类：

​		**文件目录所有者**：文件或者目录的所有者都是创建者，可以修改

​		**同组用户**：跟**文件或者目录**隶属于用一个组的用户

​		**其他组用户**：既不是文件或者目录的所有者，也不是同组用户

#### 4.6.2 查看文件的所有者和所在的组

**ls -l**

![image-20210316165928534](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316165928534.png)

#### 4.6.3 修改文件或目录的所有者：chown 新所有者 文件名

**chown 新所有者 文件名**

![image-20210316170208150](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316170208150.png)

**chown 新所有者:新的组 文件名**

![image-20210316170330516](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316170330516.png)

**chown 将一个目录修改组后，该目录的子文件不会修改组，需要加-R 递归修改目录**

**chown -R 新所有者:新的组 文件名 ** 递归修改目录的所有者和所在的组

#### 4.6.4 修改文件或目录的所在组：chgrp 新的组 文件名或目录名

**chgrp 新的组 文件名或目录名**

![image-20210316171129401](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210316171129401.png)



**chgrp -R 新的组 文件名或目录名 **递归修改目录所在的组



### 4.7 权限管理指令

### 4.7.1文件或者目录的三种权限

在linux中，任何文件或者目录都有三种权限:**读(Read)、写(Write)、执行(Execute)**

#### 对文件而言

​		**读**：可以读取，查看文件的内容，如cat、more、less、head、tail等

​		**写**：可以修改文件的内容，比如vi或者vim等

​		**执行**：如果该文件是可执行文件（.sh），可以直接运行。比如：./xxx.sh

#### 对目录而言

**读**：可以读取、查看目录下面的内容，比如ls

**写**:可以修改目录中的内容，创建子目录、删除子目录、创建文件、删除文件、重名文件或者目录

**执行**:可以进入该目录，比如: cd等。

### 4.7.2文件或者目录的权限控制

在linux中，任何文件或者目录都有三部分权限：**所有者权限、同组用户权限、其他组用户权限**

#### 所有者权限

文件或目录的所有者对该文件所拥有的权限，使用r,w,x分别表示读、写、执行的权限。比如 

**rwx：拥有读写执行的权限**

**r-x：拥有读执行的权限**

**r--：只拥有读的权限**

**---：没有任何权限**

#### 同组用户权限

文件或目录的同组用户对该文件所拥有的权限，使用r,w,x分别表示读、写、执行的权限。

#### 其他组用户权限

文件或目录的其他用户对该文件所拥有的权限，使用r,w,x分别表示读、写、执行的权限。

**chomd u-w t1.text**  给t1.text所有者减少读权限 

![image-20210317101554977](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317101554977.png)

**chomd g-w t1.text**  给t1.text同组用户减少写权限 

**chmod o-r path.txt**   给t1.text其他组用户减少可读权限 

**删除文件必须得看它的目录 ，用户有没有写权限**

#### 查看文件或者目录的权限

ls -aul

#### 修改文件或者目录的权限

用r、w 、x分别表示读、写、执行权限

用u、g、o、a分别表示给所有者、同组用户、其他组用户、所有用户修改权限

用+、-、=分别表示给指定的用户增加、减少、设置对应的权限

#### 使用数字的方式修改文件或者目录的权限

每一个权限都可以用数字表示:

 r = 4  w = 2  x = 1

每一个文件或者目录都有三部分权限，每一部分权限都可以用一组数据之和来表示，三部分权限就是一组三个数据序列：

rw—  r —x r —x 

6		5		5



753：所有者可读可写可执行  同组可读可执行 其他组可写可执行

777：所有用户都可读可写可执行

**chmod 777 t1.txt  相当于chmod  a+r,a+w,a+x t1.txt**



## 五、linux网络配置

linux中的网络配置文件 /etc/sysconfig/network-scripts/的ifcf-XXX

![image-20210317132709218](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317132709218.png)

进入ifcf-XXX文件 ，修改ONBOOT = yes

![image-20210317133008341](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317133008341.png)

重启



## 六、linux进程管理

线程：一个程序的线路

进程：一个程序的执行，一个进程占用一个端口

### 6.1查看进程

**ps** (只会显示应用进程)

**ps –u**:以用户的格式显示进程信 息

**ps –x**:显示后台进程运行的参数

**ps -e** (显示所有系统进程)

**ps -ef** (以全格式显示所有系统进程) 用于查看linux系统中某一些软件或者应用是否处于启动状态

**ps -ef |grep mysql  ** (以全格式显示所有系统进程) 用于查看mysql的进程

![image-20210317171345784](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317171345784.png)

![image-20210317171411944](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317171411944.png)

### 6.2终止进程

**kill 选项 进程ID、**

**killall 进程名称(支持通配符)**

kill -9 1024 表示强制终止pid为1024的进程

### 6.3服务管理

服务是支持Linux运行的一些必要程序。本质也是进程，叫守护进程。守护进程通常默默地运行在后台，为应用程序提供必要支撑没比如sshd,防火墙等

#### 6.3.1操作服务

**systemctl 【选项】服务名称**  

选项：start、stop、restart、reload、status、enable

**systemctl status firewalld 查看防火墙**

![image-20210317172235636](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317172235636.png)

**systemctl stop firewalld 关闭防火墙**

![image-20210317172442703](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317172442703.png)

**systemctl start firewalld 开启防火墙**

![image-20210317172536328](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317172536328.png)

**systemctl enable firewalld 设置防火墙开机启动**

#### 6.3.2 查看网路服务

**netstat 选项**

选项说明：

​	**-an 按一定顺序排列输出**

![image-20210317172902777](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317172902777.png)

​	**-p 显示哪个进程在调用**

![image-20210317173129782](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317173129782.png)

#### 6.3.3 curl命令

**curl 选项 url**

功能描述：用来发送HTTP请求。

-X参数：指定请求方式

-v参数：显示响应结果

-u参数：携带用户名/密码

-H参数：携带请求消息头信息

![image-20210317173145298](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317173145298.png)



## 七、Linux软件包管理：软件安装包

### 7.1 RPM简介

一种用于互联网下载包的打包及安装工具，它包含在某些Linux分发版中。它生成具有.RPM扩展名的文件。RPM是RedHat Package Manager（RedHat软件包管理工具）的缩写，**类似windows的setup.exe**，这一文件格式名称虽然打上了RedHat的标志，但理念是通用的。Linux的分发版本都有采用（suse,redhat, centos等等），可以算是公认的行业标准了。**它操作的软件包都是.rpm结尾**

### 7.2 使用RPM

#### rpm –qa :查询所安装的所有软件包

#### rpm –qa|more：分页查询所安装的所有软件包

#### rmp –qa|grep xxx：过滤查询安装的指定软件包

#### rpm –e 选项 软件包名称：卸载已安装的软件包

选项说明：

​	--nodeps 表示强制删除，用于被删除的软件包有依赖的情况

#### rpm 选项 RPM包全路径名：安装软件包

选项说明：

​	-i=install 安装

​	-v=verbose 提示

​	-h=hash 进度条

### 7.3 yum包管理

Yum 是一个Shell前端软件包管理器。基于RPM包管理，能够从指定的服务器(在公网上)**自动下载RPM包并且安装**，可以自动处理依赖性关系，并且一次安装所有依赖的软件包。

注意：使用YUM的前提是可以连接外网。

#### 查看系统已经安装的rpm软件包：yum list installed

#### 卸载系统已经安装的rpm软件包：yum remove XXXX

#### 安装的rpm软件包：yum install xxxxx



## 八、配置java环境

### 一、先将软件通过xftp5 上传到/opt 下

### 二、解压缩到/opt目录下

### 三配置环境变量的配置文件vim /etc/profile	 

JAVA_HOME=/opt/jdk1.7.0_79

PATH=$JAVA_HOME/bin:$PATH

CLASSPATH=$JAVA_HOME/lib:.

export JAVA_HOME PATH CLASSPATH

![image-20210317195850529](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317195850529.png)



## 九、配置Tomcat

### 一、先将软件通过xftp5 上传到/opt 下

### 二、解压缩到/opt目录下

### 三、启动tomcat 

![image-20210317210900738](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317210900738.png)

### 四、Linux上访问tomcat

![image-20210317210946028](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317210946028.png)

### 五、windows上访问tomcat

**从其它机器上访问需要关闭linux的防火墙**。

ip地址是在linux系统上查看ifconfig

![image-20210317211051559](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317211051559.png)

## 十、安装MySQL

### 一、查看是否已经安装了mariadb 

![image-20210317211837894](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317211837894.png)

如果有就删除

![image-20210317212002008](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317212002008.png)

### 二、上传mysql安装包到/opt下

### 三、解压mysql安装包到目录/opt

![image-20210317215306292](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317215306292.png)

### 四、修改解压后的根目录名

![image-20210317215332669](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317215332669.png)

### 五、创建数据文件夹data

data文件夹是mysql用来存放数据库文件的，数据库的表数据都放在data目录。

![image-20210317215431383](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317215431383.png)

### 六、创建用来执行mysqld命令的Linux用户

创建mysql用户，用来执行MySQL的命令mysqld ,此命令用来初始化msyql基础信息。

![image-20210317215705575](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317215705575.png)

### 七、初始化mysql

使用mysql的 mysqld 命令初始化数据库的基本信息。切换到mysq8.0/bin目录下执行。

命令：./mysqld --initialize --user=root--datadir=/opt/mysql8.0/data --basedir=/opt/mysql8.0

参数说明：

--initialize 初始化mysql，创建mysql的root, 随机生成密码。记住密码，登录msyql使用。

--user执行msyqld 命令的linux用户名

--datadir : mysql数据文件的存放位置，目录位置参照本机的设置。

--basedir : msyql安装程序的目录，目录位置参照本机的设置。

![image-20210317220153010](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317220153010.png)

该命令执行后，**会生成一个临时的mysql数据库root用户的密码**，请先拷贝出来记住，后续第一次登录mysql需要使用密码：iR,tHikXa0y%

![image-20210317220432375](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317220432375.png)

### 八、启用安全功能

在服务器与客户机之间来回传输的所有数据进行加密。通过证书提供了身份验证机制，mysql命令程序mysql_ssl_rsa_setup提供了开启数据加密功能，生成数字证书。

./mysql_ssl_rsa_setup --datadir=/opt/mysql8.0/data

### 九、修改mysql安装目录权限

mysql安装后，需要更改mysql8.08整个文件夹目录权限，更改所属的用户和组为之前创建的mysql用户及其所在组。在mysql安装目录的上级（/opt）位置，执行命令chown .

![image-20210317221305230](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210317221305230.png)

### 十、启动mysql

启动MySQL服务，mysql8.0/bin目录下执行命令：./mysqld_safe &（其中&符号表示后台启动）,输入命令后按Enter。

![image-20210318111517461](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210318111517461.png)

### 十一、客户端登录mysql

登录进入mysql，mysql-5.7.18/bin目录下执行命令：./mysql -uroot -p

-u表示使用root用户登录系统，使用第7步生成的密码。

-p表示使用密码登录

![image-20210318111633346](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210318111633346.png)

### 十二、修改root密码

修改mysql的密码，命令语法：alter user '用户名'@'主机域名或ip' identified by '新密码'

例如：alter user 'root'@'localhost' identified by 'Lq060528';

![-R](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210318111854181.png)

### 十三、授权远程访问

授权远程访问，在没有授权之前只能在本机访问msyql，远程授权就是让其他计算机通过网络访问mysql（这样远程客户端才能访问）。

授权命令:grant

*#创建账户*

>  create user 'root'@'1ocalhost' identified by  'password' 

#赋予权限，with grant option这个选项表示该用户可以将自己拥有的权限授权给别人

>  grant all privileges on *.* to 'root'@'1ocalhost' with grant option

 *#改密码&授权超用户，flush privileges 命令本质上的作用是将当前user和privilige表中的用户信息/权限设置从mysql库(MySQL数据库的内置库)中提取到内存里*

>  flush privileges;

![image-20210321195232048](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210321195232048.png)

**\关闭防火墙：\**systemctl stop firewalld

![img](file:///C:\Users\11026\AppData\Local\Temp\ksohtml9568\wps2.jpg) 

远程连接数据库：

![img](file:///C:\Users\11026\AppData\Local\Temp\ksohtml9568\wps3.jpg) 



### 十四、修改数据库编码

查看数据库编码：show variables where Variable_name like '%char%';

修改mysql的字符集：在mysql客户端执行如下命令

![image-20210318142948381](C:\Users\11026\AppData\Roaming\Typora\typora-user-images\image-20210318142948381.png)

### 十五、关闭mysql服务

mysql-5.7.18/bin目录下执行：./mysqladmin -uroot -p shutdown输入密码关闭

![img](file:///C:\Users\11026\AppData\Local\Temp\ksohtml20512\wps1.jpg) 

查看mysql进程，已经没有mysqld_safe

![img](file:///C:\Users\11026\AppData\Local\Temp\ksohtml20512\wps2.jpg) 





























**创建目录**

> mkdir XXX

**创建文件**

> vi  test.text   

如果有test.text就打开该文件，没有就创建该文件



**查看ip地址**

> ifconfig



##### 问题：查看是否能联网 

1. 安装图形化界面

   yum groupinstall  "X Window System" 

2. 输入startx

##### 问题：ifconfig 显示command not found

查询相关软件包：

> yum provides ifconfig

安装net-tools

> yum install net-tools

