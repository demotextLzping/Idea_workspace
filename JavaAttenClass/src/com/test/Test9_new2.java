package com.test;

import com.lzp.test7.test1.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: LZPing
 * @date: 2023-03-02 15:48
 * @Description
 */

class Student2 {
    public String name;
    public int id;

    public Student2(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student2 = (Student2) o;
        return id == student2.id && Objects.equals(name, student2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}

class Test9_new2 {
    public static double average(List<Integer> ints){
        return ints.stream().mapToInt(i -> i).average().orElse(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Student2, List<Integer>> map = new HashMap<>();
        while (sc.hasNext()) {
            String message = sc.nextLine();
            if ("exit".equals(message)) {
                break;
            }
            String[] messages = message.split(",");
            Student2 student = new Student2(messages[0], Integer.parseInt(messages[1]));
            List<Integer> scores = map.getOrDefault(student, new ArrayList<>());
            scores.add(Integer.parseInt(messages[3]));
            map.put(student, scores);
        }
        List<Student2> students = map.entrySet().stream()
                .sorted(Comparator.comparingInt(s -> (int) average(s.getValue())))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        for (int i = 0; i < students.size(); i++) {
            System.out.println("No"+ i + ":" + students.get(i).id+","+students.get(i).name);
        }
    }
}
