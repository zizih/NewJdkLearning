javac Singleton.java

javap -c -s -v -l Singleton.class


Classfile /Users/rain/IdeaProjects/NewJdkLearning/src/huizhou/hezi/concurrent/Singleton.class
  Last modified Nov 6, 2018; size 531 bytes
  MD5 checksum f594c8a0eb68e0f81ad8531212661af7
  Compiled from "Singleton.java"
public class concurrent.Singleton
  minor version: 0
  major version: 54
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #3                          // huizhou/hezi/concurrent/Singleton
  super_class: #5                         // java/lang/Object
  interfaces: 0, fields: 1, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #5.#18         // java/lang/Object."<init>":()V
   #2 = Fieldref           #3.#19         // huizhou/hezi/concurrent/Singleton.uniqInstance:Lhuizhou/hezi/concurrent/Singleton;
   #3 = Class              #20            // huizhou/hezi/concurrent/Singleton
   #4 = Methodref          #3.#18         // huizhou/hezi/concurrent/Singleton."<init>":()V
   #5 = Class              #21            // java/lang/Object
   #6 = Utf8               uniqInstance
   #7 = Utf8               Lhuizhou/hezi/concurrent/Singleton;
   #8 = Utf8               <init>
   #9 = Utf8               ()V
  #10 = Utf8               Code
  #11 = Utf8               LineNumberTable
  #12 = Utf8               getUniqInstance
  #13 = Utf8               ()Lhuizhou/hezi/concurrent/Singleton;
  #14 = Utf8               StackMapTable
  #15 = Class              #22            // java/lang/Throwable
  #16 = Utf8               SourceFile
  #17 = Utf8               Singleton.java
  #18 = NameAndType        #8:#9          // "<init>":()V
  #19 = NameAndType        #6:#7          // uniqInstance:Lhuizhou/hezi/concurrent/Singleton;
  #20 = Utf8               huizhou/hezi/concurrent/Singleton
  #21 = Utf8               java/lang/Object
  #22 = Utf8               java/lang/Throwable
{
  public concurrent.Singleton();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0
        line 8: 4

  public static concurrent.Singleton getUniqInstance();
    descriptor: ()Lhuizhou/hezi/concurrent/Singleton;
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=0
         0: getstatic     #2                  // Field uniqInstance:Lhuizhou/hezi/concurrent/Singleton;
         3: ifnonnull     37
         6: ldc           #3                  // class huizhou/hezi/concurrent/Singleton
         8: dup
         9: astore_0
        10: monitorenter
        11: getstatic     #2                  // Field uniqInstance:Lhuizhou/hezi/concurrent/Singleton;
        14: ifnonnull     27
        17: new           #3                  // class huizhou/hezi/concurrent/Singleton
        20: dup
        21: invokespecial #4                  // Method "<init>":()V
        24: putstatic     #2                  // Field uniqInstance:Lhuizhou/hezi/concurrent/Singleton;
        27: aload_0
        28: monitorexit
        29: goto          37
        32: astore_1
        33: aload_0
        34: monitorexit
        35: aload_1
        36: athrow
        37: getstatic     #2                  // Field uniqInstance:Lhuizhou/hezi/concurrent/Singleton;
        40: areturn
      Exception table:
         from    to  target type
            11    29    32   any
            32    35    32   any
      LineNumberTable:
        line 11: 0
        line 12: 6
        line 13: 11
        line 14: 17
        line 16: 27
        line 18: 37
      StackMapTable: number_of_entries = 3
        frame_type = 252 /* append */
          offset_delta = 27
          locals = [ class java/lang/Object ]
        frame_type = 68 /* same_locals_1_stack_item */
          stack = [ class java/lang/Throwable ]
        frame_type = 250 /* chop */
          offset_delta = 4
}
SourceFile: "Singleton.java"
