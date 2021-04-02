linux

#### linux安装网络配置

打开/etc/sysconfig/network-scripts文件夹下的ifcfg-ens33，修改ONBOOT=yes

#### yum安装提示“没有可用软件包”

在Linux系统中使用yum安装软件时提示”没有可用软件包“时，代表在linux系统yum源中已经没有对应的安装包了，这时，我们需要安装EPEL。

EPEL（Extra Packages for Enterprise Linux）企业版Linux额外包，PHEL分布非标准包的社区类库。安装如下：

```shell
yum install -y epel-release
```



ifconfig隶属于net-tools

#### 重启网络状态

service network restart

#JAVA_HOME=/opt/jdk-16
#PATH=$JAVA_HOME/bin:$PATH
#CLASSPATH=$JAVA_HOME/lib:.
#export JAVA_HOME PATH CLASSPATH

export JAVA_HOME=/opt/jdk-16
export HADOOP_HOME=/opt/hadoop-3.2.2
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin

export HDFS_NAMENODE_USER = root
export HDFS_DATANODE_USER = root
export HDFS_SECONDARYNAMENODE_USER = root
export HDFS_RESOURCEMANAGER_USER = root
export HDFS_NODEMANAGER_USER = root