package com.example.os_project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SCAN {
    private String direction;
    private int max;
    private int head_place;
    private String name;
    private ArrayList<Integer> disks = new ArrayList<Integer>();
    private int moving_time;
    public ArrayList<Integer> changing_disk = new ArrayList<Integer>();
    public  ArrayList<Integer> less_disks = new ArrayList<Integer>();
    public  ArrayList<Integer> big_disks = new ArrayList<Integer>();
    public ArrayList<Integer> result = new ArrayList<Integer>();
    public int time = 0;

    public SCAN(String direction, int max, int head_place, String name, ArrayList<Integer> disks, int moving_time) {
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

    public void ascendingScan(){
        int current_head = head_place;
        for(int i = 0; i<big_disks.size(); i++){
            time = time + moving_time*Math.abs(current_head - big_disks.get(i));
            result.add(big_disks.get(i));
            current_head = big_disks.get(i);
        }
        time = time + moving_time*Math.abs(current_head - (max - 1));
        result.add(max - 1);
        current_head = max - 1;

        for(int j = less_disks.size()-1; j > -1; j--){
            time = time + moving_time*Math.abs(current_head - less_disks.get(j));
            result.add(less_disks.get(j));
            current_head = less_disks.get(j);
        }

    }

    public void descendingScan(){
        int current_head = head_place;
        for(int j = less_disks.size()-1; j > -1; j--){
            time = time + moving_time*Math.abs(current_head - less_disks.get(j));
            result.add(less_disks.get(j));
            current_head = less_disks.get(j);
        }

        time = time + moving_time*Math.abs(current_head - 0);
        result.add(0);
        current_head = 0;

        for(int i = 0; i<big_disks.size(); i++){
            time = time + moving_time*Math.abs(current_head - big_disks.get(i));
            result.add(big_disks.get(i));
            current_head = big_disks.get(i);
        }



    }

    public void algorithm(){
        result.add(head_place);
        copy_disk();
        Collections.sort(changing_disk);
        for(int i=0; i<changing_disk.size(); i++){
            if (changing_disk.get(i) < head_place)
                less_disks.add(changing_disk.get(i));
            else{
                big_disks.add(changing_disk.get(i));
            }
        }

        if ((direction.toUpperCase()).equals("UP"))
            ascendingScan();
        else{
            descendingScan();
        }

    }
}
