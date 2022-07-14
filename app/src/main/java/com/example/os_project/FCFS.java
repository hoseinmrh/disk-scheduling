package com.example.os_project;

import java.util.ArrayList;

public class FCFS {
    private String direction;
    private int max;
    private int head_place;
    private String name;
    private ArrayList<Integer> disks = new ArrayList<Integer>();
    private int moving_time;
    public ArrayList<Integer> changing_disk = new ArrayList<Integer>();
    public ArrayList<Integer> result = new ArrayList<Integer>();
    public int time = 0;

    public FCFS(String direction, int max, int head_place, String name, ArrayList<Integer> disks, int moving_time) {
        this.direction = direction;
        this.max = max;
        this.head_place = head_place;
        this.name = name;
        this.disks = disks;
        this.moving_time = moving_time;
    }

    public void copy_disk(){
        this.changing_disk = this.disks;

    }

    public String print_result(){
        String toPrint = "";
        for(int i = 0; i < result.size(); i++){
            if (i != result.size() -1)
                toPrint = toPrint + String.valueOf(result.get(i)) + " -> ";
            else{
                toPrint = toPrint + String.valueOf(result.get(i));
            }
        }
        return toPrint;

    }

    public int printTime() {
        return time;
    }

    public void algorithm(){
        result.add(head_place);
        int current_head = head_place;
        for (int i = 0; i < disks.size(); i++){
            time = time + moving_time*Math.abs(current_head - disks.get(i));
            result.add(disks.get(i));
            current_head = disks.get(i);
        }
    }
}
