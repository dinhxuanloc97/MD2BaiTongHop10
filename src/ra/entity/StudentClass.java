package ra.entity;

import java.util.Scanner;

public class StudentClass implements IStudentManagement {
    private String classId;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String descriptions, int studentStatus) {
        this.classId = classId;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = studentStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập thông tin của lớp");
        System.out.println("Nhập mã id của lớp");
        do{
            this.classId = sc.nextLine();
            if (classId.trim().length()==5){
                if (classId.charAt(0)=='j'){
                    break;
                }else {
                    System.out.println("vui long nhap ten lop bat dau tu j ");
                }
            }else {
                System.out.println("vui long nhap vao 5 ky tu ");
            }
        }while (true);
        System.out.println("Nhap ten lop");
        this.className = sc.nextLine();
        do{
            if (className.trim().length()<10){
                break;
            }else {
                System.out.println("vui long nhap vao toi da 10 ky tu ");
            }
        }while (true);

        System.out.println("Nhap mo ta ve lop ");
        this.descriptions = sc.nextLine();
        System.out.println("Nhap vao trang thai cua lop");
        this.classStatus = Integer.parseInt(sc.nextLine());
    }
    @Override
    public void displayData() {
        System.out.printf("Mã Lớp :%s - ,Tên Lớp :%s - ,Mô tả Lớp :%s - Trang thái :%d",this.classId,this.className,this.descriptions,this.classStatus);
    }
}
