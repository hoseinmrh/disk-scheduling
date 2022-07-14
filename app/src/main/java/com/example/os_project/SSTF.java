package com.example.os_project;

import java.util.ArrayList;

public class SSTF {
    private String direction;
    private int max;
    private int head_place;
    private String name;
    private ArrayList<Integer> disks = new ArrayList<Integer>();
    private int moving_time;
    public ArrayList<Integer> changing_disk = new ArrayList<Integer>();
    public ArrayList<Integer> result = new ArrayList<Integer>();
    public int time = 0;

    public SSTF(String direction, int max, int head_place, String name, ArrayList<Integer> disks, int moving_time) {
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

    public int getMin(int current_head){
        int min_distance_from = changing_disk.get(0);
        int min_distance = Math.abs(current_head -changing_disk.get(0));
        for(int i = 1; i < changing_disk.size(); i++){
            int distance = Math.abs(current_head -changing_disk.get(i));
            if (distance < min_distance){
                min_distance = distance;
                min_distance_from = changing_disk.get(i);
            }
        }
        changing_disk.remove(changing_disk.indexOf(min_distance_from));
        return min_distance_from;
    }

    public void algorithm(){
        result.add(head_place);
        int current_head = head_place;
        copy_disk();
        while (changing_disk.size()!= 0){
            int min_distance_from = getMin(current_head);
            time = time + moving_time*Math.abs(current_head - min_distance_from);
            result.add(min_distance_from);
            current_head = min_distance_from;
        }
    }
}
