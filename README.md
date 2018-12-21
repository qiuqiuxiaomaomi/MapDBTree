# MapDBTree
JAVA内存数据库技术研究

<pre>
 MapDB:
         MapDB是一个嵌入式java数据库引擎，主要提供map和set形式的数据存储，使用起来就像是
      在操作java本身的map，set,事实上MapDB的确实现了jdk中对应的接口，MapDB可以提供内存
      级别和磁盘级别的缓存，底层实现部分使用了kotlin.
</pre>

<pre>
1）使用jvm堆
      DB db = DBMaker.memory().make();
2) 直接内存数据库
      DB db = DBMaker.memoryDirectDB().make();
3) 使用磁盘空间
      DB db = DBMaker.fileDB().make()
5) 使用内存映射磁盘，提高速度
      DB db = DBMaker.fileDB("/Users/cdqiushengsen/Documents/helloTreeMapDb")
                .fileMmapEnableIfSupported().make()
</pre>

<pre>
功能特性

      1) 并发 – MapDB有一个在数据库记录元组水平的锁和一个很先进的并发控制引擎，它的性能
         呈 线性扩展，数据库可以多线程水平写入。
      2) 快速 – MapDB有很好的性能，足以与原生的DB媲美，这得益于它的优化和重写。
      3) ACID事务 – 支持ACID事务和完全的MVCC隔离，MapDB使用写前日志。
      5) 灵活 – MapDB可以运行在内存缓存中，也可以支持TB级别的的数据库。它有很多选项用来
         让你可以选择牺牲持久性从而换来快速写的性能。拥有各种配置从而满足你的需求。
      6) Hackable – MapDB 都是模块组件化的，像一些特性（实例缓存，同步写，压缩）只是一
         些类的封装，你可以很容易的引入你的新的功能和组件。
      7) SQL Like – MapDB 有时可以代替SQL引擎，它有很多使你可以很容易地从关系数据库移
        植过来的特性，像辅助索引，自增序列ID， joints, triggers, 
        composite keys…低磁盘空间使用情况
</pre>