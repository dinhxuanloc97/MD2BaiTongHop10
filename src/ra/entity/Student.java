package ra.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement{
    private  String studentId;
    private  String studentName;
    private int age;
    private boolean sex;
    private StudentClass studentClass;
    private List<Float> listMarkJavaScript = new ArrayList<>();
    private List<Float> listMarkJavaCore  = new LinkedList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private Float avgMark;
    private String gpa;
    private boolean studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, StudentClass studentClass, List<Float> listMarkJavaScript, List<Float> listMarkJavaCore, List<Float> listMarkJavaWeb, Float avgMark, String gpa, boolean studentStatus) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.studentClass = studentClass;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
       this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public List<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(List<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public Float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(Float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }


    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhap thong tin sinh vien");
        System.out.println("Nhap ma sinh vien ");
        do {
            this.studentName = sc.nextLine();
            if (this.studentName.trim().length() == 5){
                if (this.studentName.charAt(0) == 'S'){
                    break;
                } else {
                    System.out.println("vui long nhap lai ki tu dau la S");
                }
            } else {
                System.out.println("Vui long nhap gon 5 ki tu ");
            }

        }while (true);
        System.out.println("Nhap vao ten sinh vien ");
        do {
            this.studentId =  sc.nextLine();
            if (this.studentId.trim().length() >=6  && this.studentId.trim().length()<=50){
                break;
            }else {
                System.out.println("Vui long nhap lai bat dau tu 6 den 50 ki tu ");
            }
        }while (true);
        System.out.println("Nhap vao tuoi cua sinh vien ");
        do {
            this.age = Integer.parseInt(sc.nextLine());
            if (this.age >=18){
                break;
            }else {
                System.out.println("nhap lai tuoi cua sinh vien lon hon hoac bang 18");
            }

        }while (true);
        System.out.println("Gioi tinh sinh vien ");
        this.sex = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Nhap cac diem thi JavaScript");
        inputMark(listMarkJavaScript  ,sc );
        System.out.println("Nhap vao diem thi JavaCore");
        inputMark(listMarkJavaCore,sc);
        System.out.println("Nhap vao diem thi JavaWeb");
        inputMark(listMarkJavaWeb,sc);
        System.out.println("Nhap vao trang thai sinh vien");
        this.studentStatus = Boolean.parseBoolean(sc.nextLine());


    }
    public static  void inputMark(List<Float> listMark, Scanner sc ){
        int cnt  = 1;
        do {
            System.out.printf("Nhap diem lan thu %d khong: \n",cnt);
            listMark.add(Float.parseFloat(sc.nextLine()));
            System.out.println("1. yes");
            System.out.println("2. No");
            System.out.println("Su lua cho cua ban : ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 1 ){
                break;
            }
        }while (true);
    }
    @Override
    public void displayData() {
        System.out.printf("Ma SV: %s - Ten SV: %s - Tuoi: %d - Gioi tinh: %b - Lop: %s\n", this.studentId, this.studentName, this.age, this.sex, this.studentClass.getClassName());
        System.out.println("Diem Javascript :");
        for (Float js_mark: listMarkJavaScript) {
            System.out.printf("%f\t" , js_mark );
        }
        System.out.println("\n");
        System.out.println("Diem java core");
        for (Float js_mark: listMarkJavaCore) {
            System.out.printf("%f\t" ,js_mark);
        }
        System.out.println("\n");
        System.out.println("Diem java ");
        for (Float js_mark :listMarkJavaWeb) {
            System.out.printf("%f\t" , js_mark);
        }
        System.out.println("\n");
        System.out.printf("Diem Tb :%f,-Xep loai :%s - Trang Thai ;%b\n" , this.avgMark,this.gpa,this.studentStatus );
    }
    public  void calAvgMark(){
        this.avgMark = (listMarkJavaScript.get(listMarkJavaScript.size()-1)
        + listMarkJavaCore.get(listMarkJavaCore.size()-1)
        +listMarkJavaWeb.get(listMarkJavaWeb.size()-1))/3;
    }
    public void getGPA(){
        if (this.avgMark<5){
            this.gpa="Yeu";
        }else if(this.avgMark<7){
            this.gpa = "Trung binh";
        }else if(this.avgMark<9){
            this.gpa = "Kha";
        }else {
            this.gpa = "Gioi";
        }
    }
}