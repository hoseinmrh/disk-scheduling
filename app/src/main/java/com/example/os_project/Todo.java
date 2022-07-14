package com.example.os_project;

import java.util.ArrayList;

public class Todo {
    private int nothing;
    public  String printed_res;
    public  int time;
    Todo(int nothing){
        this.nothing = nothing;
    }
    public void main(String data){
        printed_res = "";
        String[] array = data.split(",");
        String name = array[0];
        int max = Integer.parseInt(array[1]);
        int head_place = Integer.parseInt(array[2]);
        String direction = array[3];
        int moving_time = Integer.parseInt(array[4]);
        String algorithm = array[5];
        ArrayList<Integer> disks = new ArrayList<Integer>();
        for(int i = 6; i<array.length ; i++)
            disks.add(Integer.parseInt(array[i]));

        if((algorithm.toUpperCase()).equals("FCFS")){
            FCFS entry = new FCFS(direction, max, head_place, name, disks, moving_time);
            entry.algorithm();
            printed_res = entry.print_result();
            time = entry.printTime();
        }
        else if((algorithm.toUpperCase()).equals("SSTF")){
            SSTF entry = new SSTF(direction, max, head_place, name, disks, moving_time);
            entry.algorithm();
            printed_res = entry.print_result();
            time = entry.printTime();
        }
        else if((algorithm.toUpperCase()).equals("LOOK")){
            LOOK entry = new LOOK(direction, max, head_place, name, disks, moving_time);
            entry.algorithm();
            printed_res = entry.print_result();
            time = entry.printTime();
        }
        else if((algorithm.toUpperCase()).equals("C-LOOK")){
            C_LOOK entry = new C_LOOK(direction, max, head_place, name, disks, moving_time);
            entry.algorithm();
            printed_res = entry.print_result();
            time = entry.printTime();
        }
        else if((algorithm.toUpperCase()).equals("SCAN")){
            SCAN entry = new SCAN(direction, max, head_place, name, disks, moving_time);
            entry.algorithm();
            printed_res = entry.print_result();
            time = entry.printTime();
        }
        else if((algorithm.toUpperCase()).equals("C-SCAN")){
            C_SCAN entry = new C_SCAN(direction, max, head_place, name, disks, moving_time);
            entry.algorithm();
            printed_res = entry.print_result();
            time = entry.printTime();
        }
    }

    public String getPrinted_res() {
        return printed_res;
    }

    public int getTime() {
        return time;
    }
    public void make_empty(){
        printed_res = "";
        time = 0;
    }
}

