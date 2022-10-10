package ra.entity;

import java.util.*;

public class StudentManagement {
    static List<StudentClass> listClass = new ArrayList<>();
    static List<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("******** QUAN LI HOC VIEN********");
            System.out.println("1.Quan li lop hoc");
            System.out.println("2.Quan li sinh vien");
            System.out.println("3.Thoat");
            System.out.println("Su lua cho cua ban la ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1 :
                    StudentManagement.getClassManagement(sc);
                    break;
                case 2 :
                    StudentManagement.getStudentManagement(sc);
                    break;
                case 3 :
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("vui long nhap lai tu 1-3 ");
            }
        }while (true);

    }
    public static void getClassManagement(Scanner sc ){
        boolean classExit = true;
        do{
            System.out.println("********Quan li lop hoc *********");
            System.out.println("1.Them lop hoc moi ");
            System.out.println("2.Cap nhat thong tin lop hoc");
            System.out.println("3.Hien thi thong tin lop hoc");
            System.out.println("4.Thong ke cac lop hoc dang hoat dong ");
            System.out.println("5.Tim kiem lop hoc theo ten lop minh ");
            System.out.println("6.Thoat ");
            System.out.println("Su  lua chon cua ban la ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhap vao so lop nhap thong tin: ");
                    int countClass = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < countClass; i++) {
                        //Nhap thong tin cho tung lop
                        StudentClass studentClassNew = new StudentClass();
                        studentClassNew.inputData(sc);
                        //add vao danh sach lop
                        listClass.add(studentClassNew);
                    }
                    break;
                case 2:
                    System.out.println("Nhap vao so lop can cap nhat thong tin :");
                    String classId = sc.nextLine();
                    //kiem tra lop ton tai tong danh sach k __>cap nhap
                    boolean existClass = false;
                    for (StudentClass studentClass : listClass){
                        if (studentClass.getClassId().equals(classId)){
                            //ton tai ;op trong danh sach >>>cap nhap
                            System.out.println("Nhap vao ten lop can cap nhap :");
                            String className =  sc.nextLine();
                            if (className !="" && className.length() != 0 ){
                                //cap nhap ten lop
                                studentClass.setClassName(className);
                            }
                            System.out.println("Nhap vao mo ta lop can cap nhap :");
                            String description = sc .nextLine();
                            if (description != "" && description.length() != 0){
                                studentClass.setDescriptions(description);
                            }
                            System.out.println("Nhap vao trang thai lop can cap nhap ");
                            String classStatus = sc.nextLine();
                            if (classStatus != "" && classStatus.length() != 0){
                                studentClass.setClassStatus(Integer.parseInt(classStatus));
                            }
                            existClass = true ;
                            break;
                        }

                    }
                    if (existClass){
                        System.out.println("Khong ton tai lop co ma lop nhu vay ");
                    }
                    break;
                case 3:
                    System.out.println("Thong tin danh sach lop:");
                    for (StudentClass studentClass : listClass){
                            studentClass.displayData();
                    }
                    break;
                case 4:
                    System.out.println("Danh sach lop hoc dang hoat dong : ");
                    int countClassActive = 0;
                    for (StudentClass studentClass :listClass){
                        if(studentClass.getClassStatus()==0){
                            studentClass.displayData();
                            countClassActive++;
                        }
                    }
                    System.out.printf("Co %d lop dang hoat dong \n" ,countClassActive);
                    break;
                case 5:
                    System.out.println("Nhap vao ten lop can tim kiem :");
                    String classNameSeach = sc.nextLine();
                    boolean existClas = false;
                    for (StudentClass studentClass : listClass){
                        if (studentClass.getClassName().contains(classNameSeach)){
                            studentClass.displayData();
                            existClas = true ;
                        }

                    }if (!existClas) {
                    System.out.println("khong co lop nao co ten nhu vay ");
                     }

                    break;
                case 6:
                    classExit = false;
                    break;
                default:
                    System.out.println("vui long chon tu 1-6 ");
            }
        }while (classExit);
    }
    public static void getStudentManagement(Scanner sc){
        boolean studentExit = true;
        do {
            System.out.println("*********Quan li sinh vien *********");
            System.out.println("1.Them thong tin sinh vien ");
            System.out.println("2.Cap nhap thong tin sinh vien ");
            System.out.println("3.Hien thi thong tin sinh vien ");
            System.out.println("4.Tinh diem trung binh ");
            System.out.println("5.Xep loaij sinh vien ");
            System.out.println("6.Sap xem sinh vien theo diem tang dan ");
            System.out.println("7.Tim kiem sinh vien theo ten sinh vien ");
            System.out.println("8.Thong ke sinh vien dat gioi ,kha ,trung binh");
            System.out.println("9.Thong ke cac sinh vien pass qua monh hoc");
            System.out.println("10.Thoat");
            System.out.println("Su lua chon cua ban :");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.inputListStudent(sc);
                    break;
                case 2:
                    System.out.println("NHap vao ma sinh vien can cap nhat thong tin :");
                    String studentIdUpdate = sc.nextLine();
                    for (Student student : listStudent){
                        if (student.getStudentId().equals(studentIdUpdate)){
                            //Cap nhap thong tin sinh vien
                            System.out.println("Nhap vao ten sinh vien can cap nhap ");
                            String studentName = "";
                            do {
                                studentName = sc.nextLine();
                                if (studentName != ""&& studentName.length() != 0){
                                    if (studentName.length() >= 6 && studentName.length()<=50 )
                                        student.setStudentName(studentName);
                                    break;
                                }else {
                                    System.out.println("vui long nhap ten sinh vien tu 6 den 50 ki tu ");
                                }
                            }while (true);
                            System.out.println("Nhap vao tuoi sinh vien can cap nhat :");
                            String age = "";
                            do{
                                age = sc.nextLine();
                                if (age != "" && age.length() !=0){
                                    if (Integer.parseInt(age) >= 18){
                                        student.setAge(Integer.parseInt(age));
                                        break;
                                    }else {
                                        System.out.println("vui long nhap tuoi sinh vien lon hon ");
                                    }
                                }
                            }while (true);

                            System.out.println("Nhap vao gioi tinh cap nhat:");
                            String sex =  sc.nextLine();
                            if (sex != "" && sex.length() != 0){
                                student.setSex(Boolean.parseBoolean(sex));
                            }
                            //Cap nhap lop cho sinh vien
                            System.out.println("Chon lop cho sinh vien :");
                            int cntClass = 1;
                            for (StudentClass studentClass : listClass ){
                                System.out.printf("%d. %s\n ", cntClass, studentClass.getClassName());
                                cntClass++;
                            }
                            System.out.printf("%d . khong cap nhap lop \n ",cntClass);
                            System.out.println("su lua chon cua ban la ");
                            int choicee = Integer.parseInt(sc.nextLine());
                            if (choicee != cntClass){
                                //cap nhap lop cho sinh vien
                                student.setStudentClass(listClass.get(choicee-1));
                            }
                            // cap nhap cac diem cho sinh vien
                            StudentManagement.updateStudentMark(student.getListMarkJavaScript(),sc,student,"javaScrip");
                            StudentManagement.updateStudentMark(student.getListMarkJavaCore(),sc,student,"javaCore");
                            StudentManagement.updateStudentMark(student.getListMarkJavaWeb(),sc,student,"javaWeb");
                            //Tinh lai diem trung binh cho sinh vien
                            student.getAvgMark();
                            //Xep loai lai cho sinh vien
                            student.getGPA();
                            //Cap nhap trang thai sinh vien
                            System.out.println("Nhap vao trang thai sinh vien cap nhap:");
                            String studentStatus = sc.nextLine();
                            if (studentStatus != "" && studentStatus.length() != 0){
                                student.setStudentStatus(Boolean.parseBoolean(studentStatus));
                            }
                        }

                    }
                    break;
                case 3:
                    System.out.println("Thong tin danh sach sinh vien ");
                    for (Student student : listStudent) {
                        student.displayData();
                    }
                    break;
                case 4:
                    for (Student student : listStudent) {
                        student.calAvgMark();
                    }
                    System.out.println("Da tinh xong diem cho tat ca sinh vien ");
                    break;
                case 5:
                    for (Student student : listStudent) {
                        student.getGPA();
                    }
                    System.out.println("Da xep loai cho tat ca sinh vien ");
                    break;
                case 6:
                    Collections.sort(listStudent, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return (int) (o1.getAvgMark()-o2.getAvgMark());
                        }
                    });
                    break;

                case 7:
                    System.out.println("Nhập tên sinh viên muốn tìm kiếm");
                    String searchName = sc.nextLine();
                    Boolean existStudent = false;
                    for (Student student : listStudent) {
                        if (student.getStudentName().contains(searchName)) {
                            student.displayData();
                            existStudent = true;
                        }
                        if (!existStudent){
                            System.out.println("khong tim thay sinh vien nao co ten nhu vay");
                        }
                    }
                    break;
                case 8:
                    int cntExellent = 0, cntGood = 0,cntAvegage=0, cntWeek = 0;
                    for (Student student :listStudent ){
                        if (student.getAvgMark() < 5){
                            cntWeek++;
                        } else if (student.getAvgMark() < 7){
                            cntAvegage++;
                        }else if(student.getAvgMark() < 9){
                            cntGood++;
                        }else {
                            cntExellent++;
                        }
                    }
                    System.out.printf("So sinh vien gioi :%d - Kha :%d -Trung binh :%d -yeu :%d ", cntExellent, cntGood ,cntAvegage, cntWeek );
                    break;
                case 9:
                    int count = 0;
                    for (Student student : listStudent){
                        int jsSize = student.getListMarkJavaScript().size();
                        int jcSize = student.getListMarkJavaCore().size();
                        int jwSize = student.getListMarkJavaWeb().size();
                        if (student.getAvgMark()>=5&&student.getListMarkJavaScript().get(jsSize-1)>=5
                        &&student.getListMarkJavaCore().get(jcSize-1)>=5&&student.getListMarkJavaWeb().get(jwSize-1)>=5){
                            count++;
                        }
                    }
                    System.out.printf("Co %d sinh vien Pass \n ",count);
                    break;
                case 10:
                    studentExit = false;
                    break;
                default:
                    System.out.println("vui long chon lai tu 1 den 10 ");

            }
        }while (studentExit);


    }
  public static void inputListStudent(Scanner sc){
        System.out.println("Nhap vao so sinh vien can nhap thong tin: ");
        int cnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cnt; i++) {
            //Nhap thong tin 1 sinh vien
            Student studentNew = new Student();
            studentNew.inputData(sc);
            //-Nhap thong tin lop sinh vien
            System.out.println("Chon lop hoc cho sinh vien:");
            int index = 1;
            for (StudentClass stClass : listClass) {
                System.out.printf("%d.%s\n",index,stClass.getClassName());
                index++;
            }
            System.out.print("Su lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            //-gan vao cho thuoc tinh studentClass cua doi tuong studentNew
            studentNew.setStudentClass(listClass.get(choice-1));
            //add vao listStudent
            listStudent.add(studentNew);
        }
    }
    public static void updateStudentMark(List<Float> listMark, Scanner sc, Student student, String subject) {
        System.out.printf("Cap nhat diem %s cho sinh vien: \n", subject);
        System.out.println("1. Nhap moi diem cho sinh vien");
        System.out.println("2. Them moi diem cho sinh vien");
        System.out.println("3. Cap nhat 1 diem trong danh sach");
        System.out.println("4. Khong cap nhat");
        System.out.print("Lua chon cua ban: ");
        int choiceJS = Integer.parseInt(sc.nextLine());
        switch (choiceJS) {
            case 1:
                List<Float> listJS = new ArrayList<>();
                Student.inputMark(listJS, sc);
                student.setListMarkJavaScript(listJS);
                break;
            case 2:
                Student.inputMark(student.getListMarkJavaScript(), sc);
                break;
            case 3:
                System.out.println("Nhap vao lan thi muon cap nhat: ");
                int examTimes = Integer.parseInt(sc.nextLine());
                System.out.println("Nhap vao diem thi cap nhat:");
                float mark = Float.parseFloat(sc.nextLine());
                //Cap nhat
                student.getListMarkJavaScript().set(examTimes - 1, mark);

        }
    }

}

