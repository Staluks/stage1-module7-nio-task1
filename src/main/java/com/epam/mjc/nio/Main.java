package com.epam.mjc.nio;

import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args){
        FileReader kaka = new FileReader();
        File file = new File("C:\\Users\\37128\\IdeaProjects\\stage1-module7-nio-task1\\src\\main\\resources\\Profile.txt");
        kaka.getDataFromFile(file);
    }
}
