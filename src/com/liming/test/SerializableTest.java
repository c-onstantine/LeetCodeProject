package com.liming.test;

import java.io.*;
import java.util.AbstractList;

/**
 * @author ltf
 * @date 2021-04-27 10:00
 */
class Student implements Serializable{
    protected String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}

class TA extends Student{
    public TA() {
    }

    public TA(String name) {
        super(name);
    }

    private void readObject(ObjectInputStream s)throws IOException, ClassNotFoundException {
        System.out.println("ta readObject ---");
    }
    private void writeObject(ObjectOutputStream s)throws IOException {
        s.defaultWriteObject();
        System.out.println("ta writeObject ---");
    }
}
class Classroom implements Serializable{
    private int totalSeats;
    private MyList<Student> students;

    public Classroom() {
    }

    public Classroom(int totalSeats, MyList<Student> students) {
        this.totalSeats = totalSeats;
        this.students = students;
    }
}


class MyList<Student> extends AbstractList<Student> implements Serializable{
    private transient Student[] a;
    private int size;

    public MyList(Student[] a) {
        this.a = a;
    }

    public MyList(Student[] a, int size) {
        this.a = a;
        this.size = size;
    }

    private void readObject(ObjectInputStream s)throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        System.out.println("----");
        a = (Student[]) new Object[size];
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                a[i] = (Student) s.readObject();
            }
        }
    }
    private void writeObject(ObjectOutputStream s)throws IOException {
        s.defaultWriteObject();
        System.out.println("====");
        for (int i = 0; i < size; i++) {
            s.writeObject(a[i]);
        }
    }

    @Override
    public Student get(int index) {
        return a[index];
    }

    @Override
    public int size() {
        return size;
    }
}
public class SerializableTest {
    public static void main(String[] args) throws Exception {
        //Classroom c1 = new Classroom(30,new MyList<>(new Student[]{new Student("John"),new TA("Jane")},2));
        //FileOutputStream f =new FileOutputStream(new File("clazz.txt"));
        //ObjectOutputStream out = new ObjectOutputStream(f);
        //out.writeObject(c1);

        FileInputStream fs = new FileInputStream(new File("clazz.txt"));
        ObjectInputStream in = new ObjectInputStream(fs);
        Classroom c2 = (Classroom) in.readObject();
    }
}
